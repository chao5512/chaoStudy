等待通知范式（生产者、消费者）

消费者
    synchronized(对象){
        while(条件不满足){
            对象.wait();
        }
        搞事情。。消费。。。
    }

生产者
    synchronized(对象){
        搞事情。。。
        //通知消费者验收
        对象.notifyAll();
    }
