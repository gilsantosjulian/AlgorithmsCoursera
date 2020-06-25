public class SelectionSort {

  private int[] array;
  private int N = 0;

  public SelectionSort(int capacity) {
     array = new int[capacity]; 
  }

  public void sort() {
    int N = array.length;
    for(int i = 0; i < N; i++) 
      for(int j = i; j > 0; j--)
        if(less(array[j], array[j-1])) 
          exch(j, j-1);
  }

  public void push(int value) {
    array[N++] = value;
  }

  public Boolean less(int a, int b) {
    return (a < b);
  }
  
  public void exch(int min, int max) {
    int temp = array[min];
    array[min] = array[max];
    array[max] = temp;
  }

  public Boolean isSorted() {
    for(int i = 0; i < N-1; i++)
      if(less(array[i+1], array[i])) 
        return false;
    return true;
  }

  public void print() {
    for (int i = 0; i < N; i++) {
      System.out.print(array[i] + "-");
    }
    System.out.print("\n");
  }

  public static void main (String[] args) {
    SelectionSort arr = new SelectionSort(10);

    arr.push(10);
    arr.push(2);
    arr.push(4);
    arr.push(6);
    arr.push(3);
    arr.push(8);
    arr.push(9);
    arr.push(7);
    arr.push(1);
    arr.push(5);
    arr.print();
    arr.sort();
    arr.print();

    System.out.print("\n" + arr.isSorted());
  }
}