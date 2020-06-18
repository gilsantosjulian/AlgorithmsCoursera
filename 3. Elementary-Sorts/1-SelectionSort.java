public class SelectionSort<Item> {

  private Item[] array;

  public static void sort(Item[] array) {
    int N = array.length;
    for(int i=0; i<N; i++) {
      int min = i;
      for(int j=i+1; j<N; j++)
        if(less(array[j], array[min])) 
          min = j;
      exch(array, i, min)
    }
  }

  public Boolean less(Item a, Item b) {
    return a < b;
  }
  
  public void exch(Item[] array, int index, Item min) {
    a[index] = min;
  }

  public Boolean isSorted(){
    int N = array.length;
    for(int i=0; i<N; i++)
      if(array[i] > array[i+1]) 
        return false;
    return true;
  }

  static void main (String[] args) {

  }
}