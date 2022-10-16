public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] arr = {1,2,3,4,5,6,7};
        rotateArray(arr, 3);
        System.out.println(arr);
    }

    public static int[] rotateArray(int[] array, int k) {
        if(array == null || array.length == 0 || k == 0) {
            return array;
        }

        int length = array.length;
        int p = k%length;
        reverse(array, 0, length-1);
        reverse(array, 0, p-1);
        reverse(array, p, length-1);

        return array;

    }

    public static int[] reverse(int[] array, int start, int end) {
        int len = array.length;
        while(start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
        return array;
    }
}
