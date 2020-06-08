public class Queue {
  private Node first; 
  private Node last; 

  public Node dequeue() {
    Node item = first;
    first = item.next;
    return item;
  }
  
  public void enqueue(String value) {
    Node newNode = new Node(value, null);
    Node temp = last;
    last = newNode;
    
    if(isEmpty()) first = last;
    else temp.next = newNode;
  }

  public void printQueue() {
    Node node = first;
    while(node != null) {
      System.out.print(node.value + " - ");
      node = node.next;
    }
  }

  public boolean isEmpty() {
    return first == null;
  }

  public static void main (String[] args) {
    Queue queue = new Queue();
    queue.enqueue("4");
    queue.enqueue("5");
    queue.enqueue("1");
    queue.enqueue("0");
    queue.enqueue("8");
    queue.printQueue();
    
    Node first = queue.dequeue();
    System.out.print("\ndequeueed num: " + first.value + "\n");
    queue.printQueue();
    Node second = queue.dequeue();
    System.out.print("\ndequeueed num: " + second.value + "\n");
    queue.printQueue();
    queue.dequeue();
    System.out.print("\nisEmpty: " + queue.isEmpty() + "\n");
    queue.dequeue();
    queue.printQueue();
    queue.dequeue();
    queue.printQueue();
    System.out.print("\nisEmpty: " + queue.isEmpty() + "\n");
    queue.printQueue();
  }
}

public class Node {
  String value;
  Node next;

  public Node(String value, Node next) {
    this.value = value;
    this.next = next;
  }
}