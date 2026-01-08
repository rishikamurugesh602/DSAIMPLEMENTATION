public class infinitearray {
    public static void main(String[] args) {
        int[] arr = {2,3,5,6,7,8,10,11,12,15,20,23,30};
        int target = 10;
        int ans = findrange(arr, target);
        System.out.println(ans);
    }

    static int findrange(int[] arr, int target) {
        int start = 0;
        int end = 1;

        while (end < arr.length && target > arr[end]) {
            int temp = end + 1;
            end = end + (end - start + 1) * 2;
            start = temp;

            if (end >= arr.length) {
                end = arr.length - 1;
            }
        }

        return binary(arr, target, start, end);
    }

    static int binary(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
