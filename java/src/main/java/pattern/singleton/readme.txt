单例模式
步骤：
    1.构造函数私有化
    2.private static 引用 = （懒汉模式和饿汉模式不同）
    3.public static synchronized 引用 getInstance()
演进过程
    1. 饿汉模式：单例对象对象从类加载就被创建
    2. 懒汉模式：单例对象第一次调用getInstance方法时被创建
    3. 加锁的懒汉式 : 同步getInstance方法
    4. 双重检查的单例 : 两次检查，一次检查保证效率，一次检查保证不出现2的情况，可能会出现空指针异常
    5. volitale双重检查 : 保证了其他线程看到之前线程创建的实例时，实例确实是初始化完成了
    6. 利用内部类的懒加载特性的单例 ：
        + 利用类的初始化保证单例唯一(针对2)且有（针对3）
        + 利用内部类的懒加载机制完成单例的懒加载(针对1)
    7. 枚举的方式