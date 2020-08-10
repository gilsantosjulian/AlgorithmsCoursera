import java.util.Set;
import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;

class SymbolTable {

    private HashMap st = new HashMap();

    public void put(String key, Object value) { st.put(key, value);   }
    public Object get(String key)             { return st.get(key);   }
    public String toString()                  { return st.toString(); }

    // Return an array contains all of the keys

    public String[] keys() {
        Set keyvalues = st.entrySet();
        String[] keys = new String[st.size()];
        Iterator it = keyvalues.iterator();
        for (int i = 0; i < st.size(); i++) {
            Map.Entry entry = (Map.Entry) it.next();
            keys[i] = (String) entry.getKey();
        }
        return keys;
    }


   /***********************************************************************
    * Test routine.
    **********************************************************************/

    public static void main(String[] args) {

        SymbolTable st = new SymbolTable();

        // Insert some (key, value pairs)

        st.put("A", "VALUE_A");
        st.put("B", "VALUE_B");
        st.put("C", "VALUE_C");
        st.put("D", "VALUE_D");
        st.put("E", "VALUE_E");
        st.put("F", "VALUE_F");
        st.put("G", "VALUE_G");

        System.out.println( st.get("A").toString() );
        System.out.println( st.get("B").toString() );
        System.out.println( st.get("D").toString() );
        System.out.println( st.get("F").toString() );
    }

    /**
		 * To Run
		 * javac 1-SymbolTable.java  
		 * java SymbolTable  
		 */
}