public class Main {

    public static int n = 3;
    public static int m = 4;
    public static int[] a = {1, 3, 5};
    public static int[] b = {2, 4, 6, 8};

    public static void main(String[] args) {
        int[] result = new int[n + m];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < n || j < m) {
            if (j >= m || (i < n && a[i] <= b[j])) {
                result[k] = a[i];
                i++;
            } else {
                result[k] = b[j];
                j++;
            }
            k++;
        }

        for (i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
