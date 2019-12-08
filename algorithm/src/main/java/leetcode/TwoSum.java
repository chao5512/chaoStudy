package leetcode;

import utils.ArrayUtils;

/**
 * 数组中找到两个数a、b,使得a+b=target
 * Created by wangchao on 2018/6/12.
 */
public class TwoSum {
    /**
     * solution1.
     *
     * @param nums   目标数组
     * @param target 目标和
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] ints = new int[] {-1, -1};
        for (int i = 0; i < nums.length; i++) {
            int tmp = target - nums[i];
            for (int j = i; j < nums.length; j++) {
                if (tmp == nums[j]) {
                    ints[0] = i;
                    ints[1] = j;
                    return ints;
                }
            }
        }
        return ints;
    }

    /**
     * O（n2）的完美版
     *
     * @param nums   目标数组
     * @param target 目标和
     */
    public static int[] twoSumPro(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (target == nums[i] + nums[j]) {
                    return new int[] {i, j};
                }
            }
        }
        throw new IllegalArgumentException("no towSum in this array");
    }

    /**
     * O（n）的完美版
     *
     * @param nums   目标数组
     * @param target 目标和
     */
    public static void twoSumSuper(int[] nums, int target) {

    }

    /**
     * test solution.
     * todo 与ArrayUtils不兼容
     */
    public static void main(String[] args) {
//        int[] ints = ArrayUtils.makeArray(10000, 100);
////        int[] ints1 = twoSum(ints, 20);
//        int[] ints1 = twoSumPro(ints, 20);
//        for (int i : ints1) {
//            System.out.print(i + " : ");
//            System.out.println(ints[i]);
//        }
    }
}
