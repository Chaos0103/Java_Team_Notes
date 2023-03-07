/**
 * 중복 조합 - Duplicate Combination
 * 서로 다른 n개에서 순서 없이, 중복이 가능하게 r개를 뽑는 경우의 수
 */
public class DuplicateCombination {

    private static void duplicateCombination(int[] arr, int[] out, int start, int depth, int r) {
        if (depth == r) {
            for (int num : out) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }
        for (int i = start; i < arr.length; i++) {
            out[depth] = arr[i];
            duplicateCombination(arr, out, i, depth + 1, r);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int r = 2;
        duplicateCombination(arr, new int[r], 0, 0, r);
    }
}
/*
1 1
1 2
1 3
2 2
2 3
3 3
 */
