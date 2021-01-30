package DailyTry;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 349.求两个数组的交集
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1：
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 *
 * 示例 2：
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 */
public class IntersectionOfArrays {

    /**
     * 方法1：用set常用的add（），contains()方法
     * 这种方法是讨了Java集合 set的巧，不能算是普适通用的解法，而且其耗时耗内存都不会算小的
     */
    public static int[] intersection1(int[] nums1, int[] nums2) {
        Set<Integer> ParentSet =new HashSet<>();
        Set<Integer> SonSet=new HashSet<>();

        for (int one : nums1) {
            ParentSet.add(one);
        }

        for (int one : nums2) {
            if(ParentSet.contains(one)){
                SonSet.add(one);
            }
        }

        int []out=new int[SonSet.size()];
        int i=0;
        for (Integer one : SonSet) {
            out[i++]=one;
        }
        return out;
    }

    /**
     * 方法2：双指针
     *
     *
     */
    public static int[] intersection2(int[] nums1, int[] nums2){
        Set<Integer> set=new HashSet<>();
        int i,j;
        i=0; j=0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        while(i< nums1.length&&j< nums2.length){
            if(nums1[i]<nums2[j]){
                i++;
            }else if(nums1[i]>nums2[j]){
                j++;
            }else if(nums1[i]==nums2[j]){
                set.add(nums1[i]);
                i++;
                j++;
            }
        }
        int []out=new int[set.size()];
        int k=0;
        for (Integer one : set) {
            out[k++]=one;
        }
        return out;
    }

    public static void main(String[] args) {
        int[] nums1=new int[]{1,2,2,1,25,14};
        int[] nums2=new int[]{1,2,2,14,25};
        int []out=intersection1(nums1,nums2);
        int[]out2=intersection2(nums1,nums2);
        System.out.println("方法1结果："+Arrays.toString(out));
        System.out.println("方法2结果："+Arrays.toString(out2));
    }


}
