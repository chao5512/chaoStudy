package cap1.practice;

import edu.princeton.cs.algs4.*;
import sun.jvm.hotspot.utilities.Interval;

/**
 * Created by wangchao on 2018/5/26.
 */
public class TestDraw {
    public static void main(String[] args) {
        double xlo = Double.parseDouble(args[0]);
        double xhi = Double.parseDouble(args[1]);
        double ylo = Double.parseDouble(args[2]);
        double yhi = Double.parseDouble(args[3]);
        int T = Integer.parseInt(args[4]);

        Interval1D xinterval = new Interval1D(xlo, xhi);
        Interval1D yinterval = new Interval1D(ylo, yhi);
        Interval2D box = new Interval2D(xinterval, yinterval);
        box.draw();

        Counter c = new Counter("hits");
        for (int t = 0; t < T; t++) {
            double x = Math.random();
            double y = Math.random();
            Point2D p = new Point2D(x, y);
            if(box.contains(p))c.increment();
            else p.draw();
        }
        StdOut.println(box.area());
        StdOut.println("命中"+c);

    }
}
