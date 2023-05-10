import java.util.*;

class Main {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        int D = sc.nextInt();
        int result = taxCollection(A, D);
        System.out.println(result);
    }

    public static int taxCollection(int[] A, int D) {
        int start = 1;
        int end = Integer.MIN_VALUE;
        // Finding the maximum value in array A
        for (int i = 0; i < A.length; i++) {
            end = Math.max(end, A[i]);
        }
        // binary search to find the minimum value of S
        while (start < end) {
            int mid = (start + end) / 2;
            if (validation(mid, A, D)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    public static boolean validation(int current, int[] A, int D) {
        int day = 0;
        for (int i : A) {
            int time = i / current;
            day = day + time;
            if (i % current != 0) {
                day = day + 1;
            }
        }
        // checking if we can collect taxes in D days or less
        if (day <= D) {
            return true;
        }
        return false;
    }
}
