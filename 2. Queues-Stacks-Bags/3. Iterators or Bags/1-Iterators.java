public interface Iterable<Item> {
  Iterator<Item> iterator();
}

public interface Iterator<Item> {
  boolean hasNext();
  Item nex();
}

public static void main (String[] args) {
  Iterator<String> i = stack.iterator();

  while(i.hasNext()) {
    String s = next();
    System.out.print(s + " - ");
  }

}