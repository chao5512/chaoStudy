知道方针：https://www.cnblogs.com/yiwangzhibujian/p/7107785.html
思路
1.基本socket（单向）长啥样？咋用的。
2.双向通信
3.考虑一下socket的用途，即客户端发命令给服务端，服务端响应命令。
4.如何告知服务器我已经发送完命令了呢？
    4.1：客户端关闭连接
    4.2：客户端不关闭连接，使用socket.shutdownOutput()方法关闭输出流
            注意不是outputStream.close()-->等同于socket关闭。
    4.3：约定符号代表结束
        Socket socket = server.accept();
        // 建立好连接后，从socket中获取输入流，并建立缓冲区进行读取
        BufferedReader read=new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));
        String line;
        StringBuilder sb = new StringBuilder();
        while ((line = read.readLine()) != null && "end".equals(line)) {
          //注意指定编码格式，发送方和接收方一定要统一，建议使用UTF-8
          sb.append(line);
        }
    4.4：完美版，思想是约定两个（或多个）字节作为长度，后面跟这个长度的消息
5.服务端优化，即并发处理请求。详见concurrentSocket包下的readme.txt
6.服务端属性
    ServerSocket有以下3个属性。

    SO_TIMEOUT：表示等待客户连接的超时时间。一般不设置，会持续等待。
    SO_REUSEADDR：表示是否允许重用服务器所绑定的地址。一般不设置，经我的测试没必要，下面会进行详解。
    SO_RCVBUF：表示接收数据的缓冲区的大小。一般不设置，用系统默认就可以了。
7.客户端不要绑定端口，虽然可以绑。
    非得指定一个端口也是可以的，做法如下，这时候就不能用Socket的构造方法了，要一步一步来：

    // 要连接的服务端IP地址和端口
    String host = "localhost";
    int port = 55533;
    // 与服务端建立连接
    Socket socket = new Socket();
    socket.bind(new InetSocketAddress(55534));
    socket.connect(new InetSocketAddress(host, port));
    　　这样做就可以了，但是当这个程序执行完成以后，再次执行就会报，端口占用异常：

    java.net.BindException: Address already in use: connect
    　　明明上一个Socket已经关闭了，为什么再次使用还会说已经被占用了呢？如果你是用netstat 命令来查看端口的使用情况：

    netstat -n|findstr "55533"
    TCP 127.0.0.1:55534 127.0.0.1:55533 TIME_WAIT
    　　就会发现端口的使用状态为TIME_WAIT，说到这你需要有一点TCP连接的基本常识，建议看《》，这是其中的一点摘抄笔记，或许对理解有一些帮助。

    　　简单来说，当连接主动关闭后，端口状态变为TIME_WAIT，其他程序依然不能使用这个端口，防止服务端因为超时重新发送的确认连接断开对新连接的程序造成影响。

    　　TIME_WAIT的时间一般有底层决定，一般是2分钟，还有1分钟和30秒的。

    　　所以，客户端不要绑定端口，不要绑定端口，不要绑定端口。
8.读超时SO_TIMEOUT
  　　读超时这个属性还是比较重要的，当Socket优化到最后的时候，往往一个Socket连接会一直用下去，那么当一端因为异常导致连接没有关闭，另一方是不应该持续等下去的，所以应该设置一个读取的超时时间，当超过指定的时间后，还没有读到数据，就假定这个连接无用，然后抛异常，捕获异常后关闭连接就可以了，调用方法为：

  public void setSoTimeout(int timeout)
  throws SocketException
  　　timeout - 指定的以毫秒为单位的超时值。设置0为持续等待下去。建议根据网络环境和实际生产环境选择。

  　　这个选项设置的值将对以下操作有影响：

  ServerSocket.accept()
  SocketInputStream.read()
  DatagramSocket.receive()

9.设置连接超时
  　　这个连接超时和上面说的读超时不一样，读超时是在建立连接以后，读数据时使用的，而连接超时是在进行连接的时候，等待的时间。

10.判断一个Socket是否可用
    1.判断自身是否可用。
        不能简简单单判断是否为null，是否关闭，下面给出一个比较全面的判断Socket是否可用的表达式，这是根据Socket自身的一些状态进行判断的，它的状态有：

           bound：是否绑定
           closed：是否关闭
           connected：是否连接
           shutIn：是否关闭输入流
           shutOut：是否关闭输出流
        socket != null && socket.isBound() && !socket.isClosed() && socket.isConnected()&& !socket.isInputShutdown() && !socket.isOutputShutdown()
    2.自定义心跳包
      　　双方需要约定，什么样的消息属于心跳包，什么样的消息属于正常消息，假设你看了上面的章节现在说就容易理解了，我们定义前两个字节为消息的长度，那么我们就可以定义第3个字节为消息的属性，可以指定一位为消息的类型，1为心跳，0为正常消息。那么要做的有如下：

      客户端发送心跳包
      服务端获取消息判断是否是心跳包，若是丢弃
      当客户端发送心跳包失败时，就可以断定连接不可用
      此处需要代码实现。
      思路：   服务器，丢弃心跳包
              客户端，开一个定时任务发送心跳。发送失败则连接不可用，抛出异常，关闭连接
    3.通过发送紧急数据
      　　Socket自带一种模式，那就是发送紧急数据，这有一个前提，那就是服务端的OOBINLINE不能设置为true，它的默认值是false。

      　　OOBINLINE的true和false影响了什么：

      对客户端没有影响
      对服务端，如果设置为true，那么服务端将会捕获紧急数据，这会对接收数据造成混淆，需要额外判断
      　　发送紧急数据通过调用Socket的方法：

      socket.sendUrgentData(0);
      　　发送数据任意即可，因为OOBINLINE为false的时候，服务端会丢弃掉紧急数据。

      　　当发送紧急数据报错以后，我们就会知道连接不通了。
    4.不做额外的检测
        发送心跳成功时确认连接可用，当再次发送消息时能保证连接还可用吗？即便中间的间隔很短
        如果连接不可用了，你会怎么做？重新建立连接再次发送数据？还是说单单只是记录日志？
        如果你打算重新建立连接，那么发送心跳包的意义何在？为何不在发送异常时再新建连接？
        如果你认真考虑了上面的问题，那么你就会觉得发送心跳包完全是没有必要的操作，通过发
        送心跳包来判断连接是否可用是通过捕获异常来判断的。那么我们完全可以在发送消息报出
        IO异常的时候，在异常中重新发送一次即可，这两种方式的编码有什么不同呢，下面写一写伪代码。

        1.　　提前检测连接是否可用：

        复制代码
        //有一个连接中的socket
        Socket socket=...
        //要发送的数据
        String data="";
        try{
            //发送心跳包或者紧急数据，来检测连接的可用性
        }catch (Excetption e){
            //打印日志，并重连Socket
            socket=new Socket(host,port);
        }
        socket.write(data);
        复制代码
        2.　　直接发送数据，出异常后重新连接再次发送：

        复制代码
        //有一个连接中的socket
        Socket socket=...
        //要发送的数据
        String data="";
        try{
            socket.write(data);
        }catch (Excetption e){
            //打印日志，并重连Socket
            socket=new Socket(host,port);
            socket.write(data);
        }
        复制代码
        　　通过比较可以发现两种方式的特点，现在简单介绍下：

        两种方式均可实现连接断开重新连接并发送
        提前检测，再每次发送消息的时候都要检测，影响效率，占用带宽

