package pattern.iterator.chaosCollection;

/**
 * todo:不是这个可以写个集合工具类，在这里可以放所有集合的公共算法
 *
 * Created by wangchao on 2018/3/2.
 */
public interface Collection<E> {
    Iterator iterator();
    void add(E e);
    int size();
}
