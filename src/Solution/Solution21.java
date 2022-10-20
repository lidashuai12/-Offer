package Solution;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Solution21 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(Arrays.toString(exchange(nums)));
    }
    public static int[] exchange(int[] nums){//双端指针，i从前往后找偶数，j从后往前找奇数，找到之后交换。
        int i=0, j=nums.length-1;
        while (i<j){
            while (i<j && (nums[i] & 1) == 1) i++;
            while (i<j && ((nums[j] & 1) == 0)) j--;
            int temp = 0;
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return nums;
    }
}
