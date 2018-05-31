package pattern.oo;

import pattern.iterator.chaosCollection.ArrayList;

/**
 * Created by wangchao on 2018/3/6.
 */
public class Farm {
    private ArrayList<Cow> cows = new ArrayList<Cow>();

    public Farm(ArrayList<Cow> cows) {
        this.cows = cows;
    }

    public ArrayList<Cow> getCows() {
        return cows;
    }
}
