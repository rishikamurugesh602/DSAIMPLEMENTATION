import java.util.Arrays;

public class sortedmatrix {
    public static void main(String[] args) {

        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };

        int target = 16;

        int[] ans = search(matrix, target);

        if (ans[0] != -1) {
            System.out.println("Target found at: " + Arrays.toString(ans));
        } else {
            System.out.println("Target not found");
        }
    }

    //search in the row provided 
    static int[] binarysearch(int[][] matrix, int row, int cstart, int cend, int target) {
        while (cstart <= cend) {
            int mid = cstart + (cend - cstart) / 2;
            if (matrix[row][mid] == target) {
                return new int[]{row, mid};
            }
            if (matrix[row][mid] < target) {
                cstart = mid + 1;
            } else {
                cend = mid - 1;
            }
        }
        return new int[]{-1, -1};
    }

    static int[] search(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        if (rows == 1) {
            return binarysearch(matrix, 0, 0, cols - 1, target);
        }

        //run the loop until 2 rows;
        int rstart = 0;
        int rend = rows - 1;
        int cmid = cols / 2;

        while (rstart < (rend - 1)) {
            int mid = rstart + (rend - rstart) / 2;
            if (matrix[mid][cmid] == target) {
                return new int[]{mid, cmid};
            }
            if (matrix[mid][cmid] < target) {
                rstart = mid;
            } else {
                rend = mid;
            }
        }

        //now check whether its there in the middle col
        if (matrix[rstart][cmid] == target) {
            return new int[]{rstart, cmid};
        }
        if (matrix[rstart + 1][cmid] == target) {
            return new int[]{rstart + 1, cmid};
        }

        //now check the other possibility;
        //search in first half ,secondhalf four parts;

        if (target <= matrix[rstart][cmid - 1]) {
            return binarysearch(matrix, rstart, 0, cmid - 1, target);
        }

        if (target >= matrix[rstart][cmid + 1] && target <= matrix[rstart][cols - 1]) {
            return binarysearch(matrix, rstart, cmid + 1, cols - 1, target);
        }

        if (target <= matrix[rstart + 1][cmid - 1]) {
            return binarysearch(matrix, rstart + 1, 0, cmid - 1, target);
        }

        if (target >= matrix[rstart + 1][cmid + 1]) {
            return binarysearch(matrix, rstart + 1, cmid + 1, cols - 1, target);
        }

        return new int[]{-1, -1};
    }
}
