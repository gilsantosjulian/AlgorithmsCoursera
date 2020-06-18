public class QuickUnionUF {
    private int[] id;

    public QuickUnionUF(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) id[i] = i;
    }

    private int root(int i) {
        while (i != id[i]) i = id[i];
        return i;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        id[i] = j;
    }

    public void printId() {
        for (int i = 0; i < id.length; i++) {
            System.out.print(id[i]);
        }
    }

    public static void main(String[] args) {
      QuickUnionUF uf = new QuickUnionUF(10);

      uf.union(4,3);
      uf.union(3,8);
      uf.union(6,5);
      uf.union(9,4);
      uf.union(2,1);
      uf.union(5,0);
      uf.union(7,2);
      uf.union(6,1);
      uf.union(7,3);
      System.out.print("\n Result: \n");
      uf.printId();

  }

}
