public class LinkedList {
  private String[] stack; 
  private int N = 0;

  public LinkedList(int capacity) {
    this.stack = new String[capacity];
  } 

  public String pop() {
    String item = stack[N--];
    stack[N] = null; // Allow to loitering waste space
    return item;
  }
  
  public void push(String value) {
    stack[N++] = value;
  }

  public void printList() {
    for (int i = 0; i < stack.length; i++) {
      System.out.print(stack[i] + "\n");
    }
  }

  public boolean isEmpty() {
    return N == 0;
  }

  public static void main (String[] args) {
    LinkedList list = new LinkedList(6);
    list.push("4");
    list.push("5");
    list.push("1");
    list.push("0");
    list.push("8");
    list.printList();
    String first = list.pop();
    System.out.print("\nPoped num: " + first + "\n");
    list.printList();
    list.pop();
    list.pop();
    System.out.print("\nisEmpty: " + list.isEmpty() + "\n");
    list.pop();
    list.pop();
    System.out.print("\nisEmpty: " + list.isEmpty() + "\n");
    list.printList();
  }
}