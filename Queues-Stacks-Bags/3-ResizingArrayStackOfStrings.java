public class LinkedList {
  private String[] stack; 
  private int N = 0;

  public LinkedList(int capacity) {
    stack = new String[capacity];
  } 

  public String pop() {
    String item = stack[N--];
    stack[N] = null; // Allow to loitering waste space
    return item;
  }
  
  public void push(String value) {
    stack[N++] = value;
    if(N == stack.length)
      this.resize();
  }

  public void resize() {
    int newlength = stack.length * 2;
    String[] newStack = new String[newlength];
    for (int i = 0; i < stack.length; i++) {
      newStack[i] = stack[i];
    }
    stack = newStack;
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
    LinkedList list = new LinkedList(3);
    list.push("4");
    list.push("5");
    list.push("1");
    list.push("0");
    list.push("8");
    list.printList();
    System.out.print("\nN: " + list.N + "\n");
    System.out.print("\nLength: " + list.stack.length + "\n");
  }
}