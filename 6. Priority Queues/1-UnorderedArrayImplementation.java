class UnordearedMaxPQ<Key extends Comparable<Key>> {

  private Key[] pq; // PQ[i] = ith elemnt on pq 
  private int N;    // number of elements on pq

  public UnordearedMaxPQ(int capacity) {
    pq = (Key[]) new Comparable[capacity];
  }

  public boolean isEmpty() {
    return N == 0;
  }

  public void insert(Key x) {
    pq[N++] = x;
  }

  public Key delMax() {
    int max = 0;
    for(int i = 1; i < N; i++) 
      if(less(max, i)) max = i;
    exch(max, N-1);
    return pq[--N];
  }

  public Boolean less(int a, int b) {
    return (a < b);
  }
  
  public void exch(int min, int max) {
    Key temp = pq[min];
    pq[min] = pq[max];
    pq[max] = temp;
  }

  public void print() {
    for (int i = 0; i < N; i++) {
      System.out.print(pq[i] + "-");
    }
    System.out.print("\n");
  }

  public static void main(String args[]) { 

    UnordearedMaxPQ arr = new UnordearedMaxPQ(10);

    arr.insert(10);
    arr.insert(2);
    arr.insert(4);
    arr.insert(6);
    arr.insert(3);
    arr.insert(8);
    arr.insert(9);
    arr.insert(7);
    arr.insert(1);
    arr.insert(5);

    arr.print();
    arr.delMax();
    arr.print();

		/**
		 * To Run
		 * javac 1-UnorderedArrayImplementation.java  
		 * java UnordearedMaxPQ  
		 */
	} 
}