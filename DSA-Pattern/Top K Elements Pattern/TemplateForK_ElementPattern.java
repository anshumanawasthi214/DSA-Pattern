public class TemplateForK_ElementPattern {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 2;
        // Call the function to find the top k elements
        int[] result = findTopKElements(arr, k);
        // Print the result
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    public static int[] findTopKElements(int[] arr, int k) {
        // Implement the logic to find the top k elements
        //approach using heap
        
        // This is just a placeholder and should be replaced with actual logic
        return new int[k]; // Return an array of size k with the top k elements
    }
}