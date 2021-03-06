public class SelectionSort {

  private int[] array;
  private int N = 0;

  public SelectionSort(int capacity) {
     array = new int[capacity]; 
  }

  public void sort() {
    int N = array.length;
    int h = 1;

    while(h < N/3) h = 3 * h + 1; // 1, 4, 13, 40, 121, 364, ...

    while(h >= 1) {
      // h-sort the array
      for(int i = h; i < N; i++) 
        for(int j = i; j >= h && less(array[j], array[j-h]); j -= h)
            exch(j, j-1);
      h = h/3;
    }
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