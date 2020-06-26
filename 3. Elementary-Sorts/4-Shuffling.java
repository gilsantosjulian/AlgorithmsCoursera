import java.util.Random; 

public class Shuffling {
  private int[] array;
  private int N = 0;

  public Shuffling (int capacity) {
    array = new int[capacity];
  }

  public void push(int value) {
    array[N++] = value;
  }

  public void shuffle() {
    int length = array.length;
    for(int i=0; i<length; i++) {
      Random rand = new Random(); 
      int x = rand.nextInt(length - 2) + 0;  // between 0 and array.length -> (max - min) + 1
      int temp = array[x];
      array[x] = array[i];
      array[i] = temp;
    }
  }
  
  public void print() {
    for (int i = 0; i < N; i++) {
      System.out.print(array[i] + "-");
    }
    System.out.print("\n");
  }

  public static void main (String[] args) {

    Shuffling arr = new Shuffling(10);

    arr.push(1);
    arr.push(2);
    arr.push(3);
    arr.push(4);
    arr.push(5);
    arr.push(6);
    arr.push(7);
    arr.push(8);
    arr.push(9);
    arr.push(10);
    arr.print();

    arr.shuffle();
    arr.print();
  }
}