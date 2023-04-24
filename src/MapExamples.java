import java.util.*;

public class MapExamples {

    @SuppressWarnings("all")
    public static void main(String[] args) {

        /* To test use HashMap, LinkedHashMap or TreeMap */

    	Map<String, String> map = new HashMap();
//    	Map<String, String> map = new LinkedHashMap();
//      Map<String, String> map = new TreeMap(); // used object's compareTo()
//        Map<String, String> map = new TreeMap(new Comparator() { // for keys
//            public int compare(Object o1, Object o2) {
//                return ((String)o1).compareToIgnoreCase((String)o2);
//            }
//        });

        map.put("A", "Anna");
        map.put("B", "Boris");
        map.put("C", "Carmen");


        System.out.println(map.size());                 // 3
        System.out.println(map.toString());             // {A=Anna, C=Carmen, B=Boris}

        System.out.println(map.containsKey("B"));       // true
        System.out.println(map.containsValue("Boris")); // true

        System.out.println(map.get("A"));               // Anna
        System.out.println(map.remove("A"));       // Anna
        System.out.println(map.put("C", "Cyrill"));     // Carmen - replaced with Cyrill
        System.out.println(map.toString());             // {C=Cyrill, B=Boris}

        System.out.println(map.isEmpty());              // false

        //looping over keys
        System.out.print("for (String key: map.keySet()): ");
        for (String key : map.keySet()) {
            System.out.print("(" + key + ": " + map.get(key) + ") "); // (C: Cyrill) (B: Boris)
        }
        System.out.println();

        //loop using entrySet
        System.out.print("for (Entry<String, String> entry: map.entrySet()): ");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.print("(" + key + ": " + value + ") "); // (C: Cyrill) (B: Boris)
        }
        System.out.println();

        //working with iterators

        Set keys = map.keySet();                        // only keys extracted
        for (Iterator it = keys.iterator(); it.hasNext(); /**/) {
            System.out.print(it.next() + " "); 			// C B
        }
        System.out.println();

        Collection values = map.values();           	// only values extracted
        for (Iterator it = values.iterator(); it.hasNext(); /**/) {
            System.out.print(it.next() + " "); 			// Cyrill Boris
        }
        System.out.println();
        // Or only for printing
        System.out.println(values); 					// [Cyrill, Boris]

        Set<Map.Entry<String, String>> entries = map.entrySet(); // both keys and values
        for (Iterator it = entries.iterator(); it.hasNext(); /**/) {
            Map.Entry entry = (Map.Entry)it.next();
            Object key   = entry.getKey();
            Object value = entry.getValue();
            System.out.print(key + " = " + value + " "); // C = Cyrill B = Boris
        }
        System.out.println();


        Map map2 = new HashMap();
        map2.put("O", "Otto");
        map2.put("R", "Roman");
        map2.put("Re", "Renate");
        map2.put("Ru", "Rupert");
        map2.put("RO", "Robert");

        map.putAll(map2);

        // HashMap:       {Ru=Rupert, Re=Renate, B=Boris, R=Roman, C=Cyrill, RO=Robert, O=Otto}
        // LinkedHashMap: {B=Boris, C=Cyrill, R=Roman, Re=Renate, Ru=Rupert, RO=Robert, O=Otto}
        // TreeMap:       {B=Boris, C=Cyrill, O=Otto, R=Roman, RO=Robert, Re=Renate, Ru=Rupert}
        // TreeMap(comp)  {B=Boris, C=Cyrill, O=Otto, R=Roman, Re=Renate, RO=Robert, Ru=Rupert}
        System.out.println(map.toString());

        map.clear();
        System.out.println(map.isEmpty());       // true
    }
}

