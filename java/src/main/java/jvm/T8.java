package jvm;

import pattern.iterator.chaosCollection.ArrayList;

/**
 * Created by wangchao on 2018/5/16.
 * 锁
 */
public class T8 {
    public static ArrayList list = new ArrayList();
    public static class TreadAddToList implements Runnable{
        @Override
        public void run() {
            for (int i = 0; i < 1000000; i++) {
                list.add(i);
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new TreadAddToList(), "thread-1");
        Thread t2 = new Thread(new TreadAddToList(), "thread-2");
        t1.start();
        t2.start();
        if(t1.isAlive()||t2.isAlive()){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(list.length());
    }
}
