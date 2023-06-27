import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static int[][] findPairs(int[] nums, int target) {
        List<int[]> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result.add(new int[]{nums[i], nums[j]});
                }
            }
        }

        return result.toArray(new int[0][]);
    }

    public static int[][] findDoublePairs(int[] nums, int target) {
        List<int[]> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    int[] combined = new int[nums.length];
                    System.arraycopy(nums, 0, combined, 0, nums.length);
                    combined[i] = target;
                    combined[j] = target;
                    result.add(combined);
                }
            }
        }

        return result.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 2, -4, -6, -2, 8};
        int target = 4;

        int[][] pairs = findPairs(nums, target);
        System.out.println("First Combination For \"" + target + "\":");
        for (int[] pair : pairs) {
            System.out.println(Arrays.toString(pair));
        }

        int[] mergedArray = mergeArray(nums);
        System.out.println("\nMerge Into a single Array:");
        System.out.println(Arrays.toString(mergedArray));

        int doubleTarget = target * 2;
        int[][] doublePairs = findDoublePairs(mergedArray, doubleTarget);
        System.out.println("\nSecond Combination For \"" + doubleTarget + "\":");
        for (int[] pair : doublePairs) {
            System.out.println(Arrays.toString(pair));
        }
    }

    public static int[] mergeArray(int[] nums) {
        Arrays.sort(nums);
        return nums;
    }
}
