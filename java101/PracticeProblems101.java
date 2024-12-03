public class PracticeProblems101 {
    // Practice Problem 1
    public static int countOccurrences(int[] arr, int n) {
        int count = 0;  

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == n) {  
                count++;  
            }
        }
        return count;
    }
    // Practice Problem 2
    public static int[] reverseArray(int[] arr) {
        int n = arr.length;  
        int[] reversedArr = new int[n];  
        for (int i = 0; i < n; i++) {
            reversedArr[i] = arr[n - 1 - i]; 
        }

        return reversedArr;  
    }
    // Practice Problem 3
     public static double sumGrid(double[][] grid) {
        double sum = 0;  

     
        for (int i = 0; i < grid.length; i++) {
         
            for (int j = 0; j < grid[i].length; j++) {
                sum += grid[i][j]; 
            }
        }

        return sum;  
    }
    // Practice Problem 4
    public static int fib(int n) {
        if (n == 0) {
            return 0;  
        } else if (n == 1) {
            return 1;  
        } else {
            
            int a = 0, b = 1;
            for (int i = 2; i <= n; i++) {
                int next = a + b;  
                a = b;  
                b = next;  
            }
            return b;  
        }
    }
}    
        



