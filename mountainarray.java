public class Mountain {

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 6, 4, 2};
        int target = 6;

        int result = search(arr, target);
        System.out.println(result);
    }

    public static int search(int[] arr, int target) {
        int peak = peakMountain(arr);

        int first = binary(arr, target, 0, peak);
        if (first != -1) {
            return first;
        }

        return binary(arr, target, peak + 1, arr.length - 1);
    }

    public static int peakMountain(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] > arr[mid + 1]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    static int binary(int[] arr, int target, int start, int end) {

        boolean isAsc = arr[start] < arr[end];

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (isAsc) {
                if (target < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target > arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
}
