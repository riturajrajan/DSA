package Search;

public class BinaryArrayCountOne {
    public static void main(String[] args) {
        int[] arr = {0, 0, 0, 1, 1, 1, 1};
        System.out.println(findOne(arr, 0, arr.length-1));
    }

    private static int findOne(int[] arr, int low, int high) {
        if(low > high) return -1;
        int mid = (low + high) / 2;
        if(arr[mid] == 0) {
            low =  mid + 1;
        } else {
            if(mid == 0 || arr[mid] != arr[mid-1]) {
                return (arr.length - mid);
            } else {
                high = mid - 1;
            }
        }
        return 0;
    }
}
