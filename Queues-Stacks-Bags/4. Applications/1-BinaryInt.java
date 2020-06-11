import java.util.Scanner;

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
    LinkedList stack = new LinkedList();
    LinkedList binary = new LinkedList();

    Scanner in = new Scanner(System.in);
    int num = in.nextInt();

    while(num > 0) {
      stack.push(num % 2);
      num = num / 2;
    }
    stack.printList();
  }
}

