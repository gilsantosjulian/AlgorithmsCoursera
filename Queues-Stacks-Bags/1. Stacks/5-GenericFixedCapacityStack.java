public class FixedCapacityStack<Item> {
  private Item[] stack; 
  private int N = 0;

  public FixedCapacityStack(int capacity) {
    stack = (Item[]) new Object[capacity];
  } 

  public Item pop() {
    Item item = stack[N--];
    stack[N] = null; // Allow to loitering waste space
    return item;
  }
  
  public void push(Item value) {
    stack[N++] = value;
  }

  public void printList() {
    for (int i = 0; i < stack.length; i++) {
      System.out.print(stack[i] + "-");
    }
    System.out.print("\n");
  }

  public boolean isEmpty() {
    return N == 0;
  }

  public static void main (String[] args) {
    FixedCapacityStack list = new FixedCapacityStack(6);
    list.push("4");
    list.push(false);
    list.push("Hola");
    list.push("0");
    list.push(100);
    list.printList();
    list.pop();
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