class SmallestInfiniteSet {


    private final TreeSet<Integer> ts;
    private int cur = 1;

    public SmallestInfiniteSet() {
        ts = new TreeSet<>();
    }
    
    public int popSmallest() {

        if (!ts.isEmpty()) {
            return ts.pollFirst();
        }

        return cur++;
    }
    
    public void addBack(int num) {
        if (num < cur) {
            ts.add(num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */