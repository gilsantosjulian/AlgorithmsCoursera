public class SelectionSort {

  private int[] array;
  private int N = 0;

  public SelectionSort(int capacity) {
     array = new int[capacity]; 
  }

  public void sort() {
    int N = array.length;
    for(int i=0; i<N; i++) {
      int min = i;
      for(int j=i+1; j<N; j++)
        if(less(array[j], array[min])) 
          min = j;
      exch(i, min);
    }
  }

  public void push(int value) {
    array[N++] = value;
  }

  public Boolean less(int a, int b) {
    return (a < b);
  }
  
  public void exch(int index, int min) {
    array[index] = min;
  }

  public Boolean isSorted() {
    for(int i=0; i<N; i++)
      if(array[i] > array[i+1]) 
        return false;
    return true;
  }

  public void print() {
    for (int i = 0; i < array.length; i++) {
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

  }
}