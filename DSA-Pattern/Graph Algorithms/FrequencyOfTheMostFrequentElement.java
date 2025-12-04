import java.util.Arrays;

public class FrequencyOfTheMostFrequentElement {
    public static void main(String[] args) {
        int arr[]={1,2,4};
        int k=5;

        System.out.println("Frequency of the most frequent element Bruteforce Approach: "+frequencyOfMostFrequentElement(arr,k));

        System.out.println("Frequency of the most frequent element Optimized Approach: "+frequencyOfMostFrequentElementOptimized(arr,k));

    }

    private static int frequencyOfMostFrequentElementOptimized(int[] arr, int k) { //Optimized  TC: O(n log n) SC: O(1)
        Arrays.sort(arr);
    int left = 0;
    long sum = 0;
    int maxFreq = 0;

    for (int right = 0; right < arr.length; right++) {
        sum += arr[right];

        // shrink window while cost > k
        while ((long) arr[right] * (right - left + 1) - sum > k) {
            sum -= arr[left];
            left++;
        }

        maxFreq = Math.max(maxFreq, right - left + 1);
    }

    return maxFreq;
    }   

    private static int frequencyOfMostFrequentElement(int[] arr, int k) { //BruteForce  TC: O(n^2) SC: O(1)
    Arrays.sort(arr);
    int maxFreq = 0;

    for (int i = 0; i < arr.length; i++) {
        long sum = 0;
        for (int j = i; j < arr.length; j++) {
            sum += arr[j];
            int len = j - i + 1;
            long cost = (long) arr[j] * len - sum;

            if (cost > k) {
                break; // further j will only increase cost
            }
            maxFreq = Math.max(maxFreq, len);
        }
    }
    return maxFreq;
}

}
