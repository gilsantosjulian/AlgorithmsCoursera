/* Union-find with specific canonical element.
 * Add a method find() to the union-find data type so that find(i) 
 * returns the largest element in the connected component containing i. 
 * The operations, union(), connected(), and find() should all take logarithmic time or better.
 * 
 * For example, if one of the connected components is {1,2,6,9}, 
 * then the find() method should return 9 for each of the four elements in the connected components.
 */

import java.util.Scanner;

public class LargestQuickUnionUF {
  private int[] id;
  private int[] sz;
  private int[] largest;
  private int n;

  public LargestQuickUnionUF(int N) {
    id = new int[N];
    sz = new int[N];
    largest = new int[N];
    n = N;
    for (int i = 0; i < N; i++) {
        id[i] = i;
        sz[i] = 1;
        largest[i] = i;
    }
  }

  private int root(int i) {
    while (i != id[i]) {
        id[i] = id[id[i]];
        i = id[i];
    }
    return i;
  }

  public boolean connected(int p, int q) {
    return root(p) == root(q);
  }

  public void union(int p, int q) {
    int rP = root(p);
    int rQ = root(q);
    int largestP = largest[rP];
    int largestQ = largest[rQ];
    if (rP == rQ) return;
    if (sz[rP] < sz[rQ]) {
        id[rP] = rQ;
        sz[rQ] += sz[rP];
        if(largestP > largestQ)
          largest[rQ] = largestP;
    } else {
        id[rQ] = rP;
        sz[rP] += sz[rQ];
        if(largestP < largestQ)
          largest[rP] = largestQ;
    }
  }

  public int find(int item) {
    return largest[item];
  }

  public int[] getId() {
    return this.id;
  }

  public void printId() {
    for (int i = 0; i < id.length; i++) {
      System.out.print(id[i] + " ");
    }
  }

  public void printLargest() {
    for (int i = 0; i < largest.length; i++) {
      System.out.print(largest[i] + " ");
    }
    System.out.print("\n");
  }


  public static void main(String[] args) {
    LargestQuickUnionUF uf = new LargestQuickUnionUF(10);

    uf.union(0, 2);
    uf.union(8, 4);
    System.out.print(uf.find(0) == 2);
    System.out.print(uf.find(4) == 8);
    System.out.print("\n");
    uf.printLargest();

  }
}
