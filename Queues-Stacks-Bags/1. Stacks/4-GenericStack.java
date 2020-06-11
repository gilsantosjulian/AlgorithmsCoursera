public class LinkedList<Item> {
  private Node first; 

  public class Node {
    Item value;
    Node next;

    public Node(Item value, Node next){
      this.value = value;
      this.next = next;
    }
  }

  public Node pop() {
    Node item = first;
    first = first.next;
    return item;
  }
  
  public void push(Item value) {
    Node currentFirst = first;
    Node newFirst = new Node(value, currentFirst);
    first = newFirst;
  }

  public void printList() {
    Node node = first;
    while(node != null) {
      System.out.print(node.value + " - ");
      node = node.next;
    }
    System.out.print("\n");
  }

  public boolean isEmpty() {
    return first == null;
  }

  public static void main (String[] args) {
    LinkedList list = new LinkedList();
    list.push("4");
    list.push(false);
    list.push("Julian");
    list.push(3);
    list.printList();
    list.pop();
    list.printList();
    list.pop();
    list.pop();
    System.out.print("\nisEmpty: " + list.isEmpty() + "\n");
    list.pop();
    System.out.print("\nisEmpty: " + list.isEmpty() + "\n");
    list.printList();
  }
}

