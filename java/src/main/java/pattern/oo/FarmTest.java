package pattern.oo;

import pattern.iterator.chaosCollection.ArrayList;
import pattern.iterator.chaosCollection.Iterator;

/**
 * Created by wangchao on 2018/3/6.
 */
public class FarmTest {
    public void testoo(){
        Cow initCow = new Cow(1, 5, null);
        ArrayList<Cow> initCows = new ArrayList<Cow>();
        initCows.add(initCow);
        //其实农场有一只5岁的小母牛
        Farm farm = new Farm(initCows);
        ArrayList<Cow> cows = farm.getCows();
        for(int i = 0 ; i < 20 ; i++){
            Iterator iterator = cows.iterator();
            while (iterator.hasNext()){
                Cow next = (Cow) iterator.next();
                if(next.fertility()){
                    cows.add(next.birth());
                }
                next.setAge(next.getAge()+1);
            }
            System.out.println("第"+(i+1)+"年有"+cows.size()+"头牛");
        }
        Iterator iterator = cows.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println(cows.size());
    }
}
