/**
 * 부분 집합(재귀) - SubSet
 */
public class SubSet {

    private static void subSet(int[] arr, boolean[] visited, int r, int depth) {
        if (depth == r) {
            for (int i = 0; i < arr.length; i++) {
                if (visited[i]) {
                    System.out.print(arr[i] + " ");
                }
            }
            System.out.println();
            return;
        }
        visited[depth] = false;
        subSet(arr, visited, r, depth + 1);

        visited[depth] = true;
        subSet(arr, visited, r, depth + 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};

        subSet(arr, new boolean[arr.length], arr.length, 0);
    }
}
/*
3
2
2 3
1
1 3
1 2
1 2 3
 */
