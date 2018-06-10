单例模式
    1.构造函数私有化
    2.private static 引用 = （懒汉模式和饿汉模式不同）
    3.public static synchronized 引用 getInstance()

    懒汉模式：单例对象对象从类加载就被创建
    饿汉模式：单例对象第一次调用getInstance方法时被创建