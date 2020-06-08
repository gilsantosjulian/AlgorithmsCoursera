public class LinkedList {
  private String[] stack = new String[1]; 
  private int N = 0;

  public String pop() {
    String item = stack[N--];
    stack[N] = null; // Allow to loitering waste space
    if(N>0 && N == stack.length/4) resize(stack.length/2)
    return item;
  }
  
  public void push(String value) {
    stack[N++] = value;
    if(N == stack.length)
      this.resize(stack.length * 2);
  }

  public void resize(int capacity) {
    String[] stackCopy = new String[capacity];
    for (int i = 0; i < stack.length; i++) {
    stackCopy[i] = stack[i];
    }
    stack =stackCopy;
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
    LinkedList list = new LinkedList();
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