public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] arr = {0,0,0,0,0,1,1,1,1,2,2,5,5,5,8,9,10,11};
        int[] values = {1,4,5,10};
        int[] output = getStartOfEachValues(arr, values);
        for(int i = 0; i < output.length; i++){
            System.out.println(output[i]);
        }
    }

    // arr = [0,0,0,0,0,1,1,1,1,2,2,5,5,5,8,9,10,11]
    // values = [1,4,5,10]
    // output = [5, -1, 12, 17]
    private static int[] getStartOfEachValues(int[] arr, int[] values){
        int[] indexes = new int[values.length];
        for(int i = 0; i < values.length; i++) {
            indexes[i] = searchValue(arr, values[i]);
        }
        return indexes;
    }

    public static int searchValue(int[] arr, int target) {

        if(arr == null || arr.length == 0) {
            return -1;
        }

        int l = 0;
        int r = arr.length - 1;
        while(l < r) {
            int mid = (l+r)/2;
            if(arr[mid] >= target) {
                r = mid;
            }
            else {
                l = mid + 1;
            }
        }
        if(arr[r] != target) {
            return -1;
        }
        return r;

    }
}
