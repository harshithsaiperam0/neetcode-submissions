class HitCounter {
    private Queue<Integer> hits; 

    public HitCounter() {
        hits = new ArrayDeque<>();
    }

    public void hit(int timestamp) {
        hits.add(timestamp);
    }
    
    public int getHits(int timestamp) {
        while (!hits.isEmpty()) {
            int diff = timestamp - this.hits.peek();
            if (diff >= 300) this.hits.remove();
            else break;
        }
        
        return this.hits.size();
    }
}