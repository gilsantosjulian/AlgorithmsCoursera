/**
  Social network connectivity. Given a social network containing nn members 
  and a log file containing mm timestamps at which times pairs of members formed 
  friendships, design an algorithm to determine the earliest time at which all 
  members are connected (i.e., every member is a friend of a friend of a friend ... of a friend). 
  
  Assume that the log file is sorted by timestamp and that friendship is an equivalence relation. 
  The running time of your algorithm should be m \log nmlogn or better and use extra space proportional to nn.

  Note: these interview questions are ungraded and purely for your own enrichment. To get a hint, submit a solution.
 */

import java.sql.Timestamp;
import java.util.Scanner;

public class WeightedQuickUnionUF {
  private int[] id;
  private int[] sz;
  private int n;

  public WeightedQuickUnionUF(int N) {
    id = new int[N];
    sz = new int[N];
    n = N;
    for (int i = 0; i < N; i++) {
        id[i] = i;
        sz[i] = 1;
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

  public void union(int p, int q, Timestamp timestamp) {
    int i = root(p);
    int j = root(q);
    if (i == j) return;
    if (sz[i] < sz[j]) {
        id[i] = j;
        sz[j] += sz[i];
        this.isAllConnected(sz[j], timestamp);
    } else {
        id[j] = i;
        sz[i] += sz[j];
        this.isAllConnected(sz[i], timestamp);
    }
  }

  public void isAllConnected(int item, Timestamp timestamp) {
    if (item == this.n)
      System.out.print("All items connected at: " + timestamp);
  }

  public int[] getId() {
    return this.id;
  }

  public void printId() {
    for (int i = 0; i < id.length; i++) {
      System.out.print(id[i] + " ");
    }
  }

  public void printSz() {
    System.out.print("size is :");
    for (int i = 0; i < id.length; i++) {
      System.out.print(sz[i] + " ");
    }
    System.out.print("\n");
  }


  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    WeightedQuickUnionUF uf = new WeightedQuickUnionUF(n);
    Timestamp timestamp;

    /*
        Entry:
        4 3
        3 8
        6 5
        9 4
        2 1
        5 0
        7 2
        6 1
        7 3

        Result: 6 2 6 4 6 6 6 2 4 4
      */

    uf.union(4,3, new Timestamp(System.currentTimeMillis()));
    uf.union(3,8, new Timestamp(System.currentTimeMillis()));
    uf.union(6,5, new Timestamp(System.currentTimeMillis()));
    uf.union(9,4, new Timestamp(System.currentTimeMillis()));
    uf.union(2,1, new Timestamp(System.currentTimeMillis()));
    uf.union(5,0, new Timestamp(System.currentTimeMillis()));
    uf.union(7,2, new Timestamp(System.currentTimeMillis()));
    uf.union(6,1, new Timestamp(System.currentTimeMillis()));
    uf.union(7,3, new Timestamp(System.currentTimeMillis()));
    System.out.print("\n Result: \n");
    uf.printId();

  }
}


/*
  Ask numbers by console:

    while (in.hasNextInt()) {
      int p = in.nextInt();
      int q = in.nextInt();
      Timestamp timestamp = new Timestamp(System.currentTimeMillis());

      if (!uf.connected(p, q)) {
        uf.union(p, q, timestamp);
        System.out.print("Connected: " + p + " " + q + "\n");
      }
      continue;
    }

    System.out.print("\n");
    System.out.print("Result of Id is: ");
    uf.printId();
    System.out.print("\n");
    System.out.print("Result of Sz is: ");
    uf.printSz();