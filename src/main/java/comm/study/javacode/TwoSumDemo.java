/**
 * Copyright(c) 2018 asura
 */
package comm.study.javacode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <p></p>
 *
 * 两数求和，返回数组下标
 *  给定 nums= {2 ,7 ,11 ,15} ,target = 9
 *
 * @author liuzhen
 * @since 1.0
 * @version 1.0
 * @Date 2021/3/26 9:23 上午
 */
public class TwoSumDemo {

    private static int[] nums = new int[]{2,15,11,7};

    public static void main(String[] args) {
        int[] arrs = new TwoSumDemo().twoSum2(nums,9);
        System.out.println(Arrays.toString(arrs));
    }


    /**
     * 利用HashMap思想
     *  1.首先循环数组，map初始为空，利用 target - nums[0] = parentNumber
     *   parentNumber 是我们的期望值
     *    第一次：
     *         map为空，将 key作为值 nums[0]，value 值得下标 0 存进去
     *    第二次：
     *         map不为空，target - nums[1] = parentNumber,判断 parentNumber 是否作为key在map中存在，
     *         若存在则返回 parentNumber 的下标 和 当前循环的数组下标
     *    第三次同二操作
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums ,int target){
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int parentNumber  = target - nums[i] ;
            if(map.containsKey(parentNumber)){
                return new int[]{map.get(parentNumber),i};
            }
            map.put(nums[i],i);
        }
        return  null;
    }
    /**
     * 最初始的暴力破解 - 循环遍历
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums ,int target){
        for (int i = 0; i < nums.length ; i++){
            for (int j = 1; j < nums.length; j++) {
                if(nums[j] + nums[i] == target ){
                   return new int[]{i,j};
                }
            }
        }
        return null;
    }
}
