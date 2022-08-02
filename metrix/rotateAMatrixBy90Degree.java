class Matrix {
    public int[][] rotateAMatrixBy90Degree(int[][] arr) {
        int rowLength = arr.length;
        int columnLength = arr[0].length;

        int[][] res = new int[columnLength][rowLength];
        for (int r = 0; r < rowLength; r++) {
            for (int c = 0; c < columnLength; c++) {
                res[c][rowLength - 1 - r] = arr[r][c];
            }
        }
        return res;
    }
}
