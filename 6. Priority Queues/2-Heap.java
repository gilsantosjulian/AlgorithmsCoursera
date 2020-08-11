class MaxPQ<Key extends Comparable<Key>> {

  private Key[] pq;
  private int N;

  public MaxPQ(int capacity) { 
    pq = (Key[]) new Comparable[capacity+1];
   }

  public void insert (Key x) {
    pq[++N] = x;
    swim(N);
  }

  private void swim(int k) {
    while(k > 1 && less(k/2, k)) {
      exch(k, k/2);
      k = k/2;
    }
  }

  public void sort(Comparable[] pq) {
    int N = pq.length;
    for(int k = N/2; k >= 1; k--)
      sink(k, N);

    while(N > 1) {
      exch(1, N);
      sink(1, --N);
    }
  }

  private void sink(int k, int N) {
    while(2*k <= N) {
      int j = 2 * k;
      if(j < N && less(j, j + 1)) j++;
      if(!less(k, j)) break;
      exch(k, j);
      k = j;
    }

  }

  private boolean less(int i, int j) {
    return pq[i].compareTo(pq[j]) < 0;
  }

  private void exch(int i, int j) {
    Key t = pq[i];
    pq[i] = pq[j];
    pq[j] = t;
  }

  public void print() {
    for (int i = 0; i < N; i++) {
      System.out.print(pq[i] + "-");
    }
    System.out.print("\n");
  }

  public static void main(String[] args) {

    MaxPQ pq = new MaxPQ(11);

    pq.insert("T");
    pq.insert("S");
    pq.insert("R");
    pq.insert("P");
    pq.insert("N");
    pq.insert("O");
    pq.insert("A");
    pq.insert("E");
    pq.insert("I");
    pq.insert("H");
    pq.insert("G");

    pq.print();

  }
}