public class Main{
    static String intArrToString(int[] arr) {
        String str = "(";
        for (int i = 0; i < arr.length; i++) {
            str += arr[i];
            if (i != arr.length - 1) {
                str += ", ";
            }
        }
        return str + ")";
    }
    public static void main(String[] args) {
        int[] arr = {1, 4, 6, 9};
        System.out.println(intArrToString(arr));
        }

}