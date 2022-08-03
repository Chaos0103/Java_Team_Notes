class Combination {
    private int n;
    private int r;
    private int[] now; // 현재 조합
    private ArrayList<ArrayList<Node>> result; // 모든 조합

    public ArrayList<ArrayList<Node>> getResult() {
        return result;
    }

    public Combination(int n, int r) { //전체 갯수, 뽑을 갯수
        this.n = n;
        this.r = r;
        this.now = new int[r];
        this.result = new ArrayList<ArrayList<Node>>();
    }

    public void combination(ArrayList<Node> arr, int depth, int index, int target) {
        if (depth == r) {
            ArrayList<Node> temp = new ArrayList<>();
            for (int i = 0; i < now.length; i++) {
                temp.add(arr.get(now[i]));
            }
            result.add(temp);
            return;
        }
        if (target == n) return;
        now[index] = target;
        combination(arr, depth + 1, index + 1, target + 1);
        combination(arr, depth, index, target + 1);
    }
}
