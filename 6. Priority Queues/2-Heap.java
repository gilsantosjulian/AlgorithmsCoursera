public class MaxPQ<Key extends Comparable<Key>> {

  private Key[] pq;
  private int N;

  public MaxPQ(int capacity)

  public void insert () {
    pq[++N] = x;
  }

  public static void sort(Comparable[] pq) {
    int N = pq.length;
    for(int k = N/2; k >= 1; k--)
      sink(pq, k, N);

    while(N > 1) {
      exch(pq, 1, N);
      sink(pq, 1, --N);
    }
  }

  private static void sink(Comparable[] pq, int k, int N) {
    while(2*k <= N) {
      int j = 2 * k;
      if(j < N && less(j, j + 1)) j++;
      if(!less(k, j)) break;
      exch(k, j);
      k = j;
    }

  }

  private static boolean less(Comparable[] pq, int i, int j) {
    
  }

  private static boolean exch(Comparable[] pq, int i, int j) {
    
  }


  public static void main(String[] args){

  }
}