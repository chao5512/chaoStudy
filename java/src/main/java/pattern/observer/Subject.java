package pattern.observer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 主题
 * @author wangchao
 * @date 2019/12/4 - 7:25 下午
 */
public class Subject {
    List<Observer> observers = new ArrayList<>();
     private int state;

    public int getState() {
        return state;
    }
    public void attach(Observer observer){
        observers.add(observer);
    }
    public void setState(int state) {
        if(state == this.state){
            return;
        }
        this.state = state;
        notifyAllObserver();
    }

    void notifyAllObserver(){
        //observers为空时不会报错
        observers.stream().forEach(Observer::update);
    }
}
