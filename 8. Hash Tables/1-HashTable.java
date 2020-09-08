class LinearProbingHashST {
  private int M = 10;
  private String[] vals = new String[M];
  private String[] keys = new String[M];

  private int hash(String key) {
    return (key.hashCode() & 0x7fffffff) % M;
  }

  public void put(String key, String val) {
    int i;
    for(i = hash(key); keys[i] != null; i = (i+1) % M)
      if(keys[i].equals(key))
        break;
      keys[i] = key;
      vals[i] = val;
  }

  public String get(String key) {
    int i;
    for(i = hash(key); keys[i] != null; i = (i+1) % M)
      if(keys[i].equals(key))
        return vals[i];
    return null;
  }

  public void print() { 
    for(int i = 0; i < M; i++) {
       System.out.println("keys: " + keys[i] + ", vals: " + vals[i]);
    }
  }

  public static void main(String[] args) {
    LinearProbingHashST HT = new LinearProbingHashST();
    HT.put("a", "2");
    HT.put("b", "5");
    HT.put("c", "6");

    HT.print();

    System.out.println("Value of a: " + HT.get("a"));

    /**
		 * To Run
		 * javac 1-HashTable.java  
		 * java LinearProbingHashST  
		 */
  }

}