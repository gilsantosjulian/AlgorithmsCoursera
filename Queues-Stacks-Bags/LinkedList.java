public class LinkedList {
  private Node first; 

  public Node pop() {
    Node item = first;
    first = first.next;
    return item;
  }
  
  public void push(String value) {
    Node currentFirst = first;
    Node newFirst = new Node(value, currentFirst);
    first = newFirst;
  }

  public void printList() {
    Node node = first;
    while(node != null) {
      System.out.print("\n");
      System.out.print(node.value);
      node = node.next;
    }
  }

  public boolean isEmpty() {
    return first == null;
  }

  public static void main (String[] args) {
    LinkedList list = new LinkedList();
    list.push("4");
    list.push("5");
    list.push("1");
    list.push("0");
    list.printList();
    Node first = list.pop();
    System.out.print("\nPoped num: " + first.value + "\n");
    list.printList();
    list.pop();
    list.pop();
    System.out.print("\nisEmpty: " + list.isEmpty() + "\n");
    list.pop();
    System.out.print("\nisEmpty: " + list.isEmpty() + "\n");
    list.printList();
  }
}

public class Node {
    String value;
    Node next;

    public Node(String value, Node next){
      this.value = value;
      this.next = next;
    }
  }