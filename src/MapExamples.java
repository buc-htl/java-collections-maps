import java.util.*;

public class MapExamples {

    @SuppressWarnings("all")
    public static void main(String[] args) {

        /* To test use HashMap, LinkedHashMap or TreeMap */

    	Map<String, Integer> map = new HashMap();
 //  	Map<String, Integer> map = new LinkedHashMap();
 //    Map<String, Integer> map = new TreeMap(); // used object's compareTo()
  /*     Map<String, Integer> map = new TreeMap(new Comparator<String>() { // for keys
           public int compare(String o1, String o2) {
               return o2.compareToIgnoreCase(o1);
           }
       });
*/

        map.put("Boris", 2);
        map.put("Anna", 1);
        map.put("Carmen",3);

        System.out.println("map.size() = " + map.size());


        //HashMap: {Carmen=3, Boris=2, Anna=1}
        //LinkedHashMap: {Boris=2, Anna=1, Carmen=3}
        //TreeMap: {Anna=1, Boris=2, Carmen=3}
        //TreeMap + Comparator: {Carmen=3, Boris=2, Anna=1}
        System.out.println("map = " + map.toString());

        System.out.println(map.containsKey("Boris"));       // true
        System.out.println(map.containsValue(3));           // true

        System.out.println(map.get("Anna"));               // 1
        System.out.println(map.remove("Anna"));       // Anna
        System.out.println(map.put("Carmen", 5));     //  for key "Carmen": 3 replaced with 5
        System.out.println(map);

        Set<String> keys = map.keySet();    //get all keys
        System.out.println("keys = " + keys);
        Collection<Integer> values = map.values(); //get all values
        System.out.println("values = " + values);

        System.out.println(map.isEmpty());              // false

        //looping over keys
        System.out.print("for (String key: map.keySet()): ");
        for (String key : map.keySet()) {
            System.out.print("(" + key + ": " + map.get(key) + ") ");
        }
        System.out.println();

        //loop using entrySet
        System.out.print("for (Entry<String, String> entry: map.entrySet()): ");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.print("(" + key + ": " + value + ") ");
        }
        System.out.println();

        //working with iterators
        Set<String> allKeys = map.keySet();                        // only keys extracted
        //using a for-loop
        for (Iterator<String> it = allKeys.iterator(); it.hasNext(); /**/) {
            System.out.print(it.next() + " ");
        }
        System.out.println();
        //using a while-loop
        Iterator<String> it = allKeys.iterator();
        while (it.hasNext()) {
            String key =  it.next();
            Integer value = map.get(key);

            //you must use an iterator if you want to remove elements while looping over them
            if(key.equals("Boris")) {
                it.remove();    //remove the current entry
            }
        }

        Collection<Integer> allValues = map.values();           	// only values extracted
        for (Iterator iterator = allValues.iterator(); iterator.hasNext(); /**/) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        Set<Map.Entry<String, Integer>> entries = map.entrySet(); // both keys and values
        for (Iterator iterator = entries.iterator(); iterator.hasNext(); /**/) {
            Map.Entry entry = (Map.Entry)iterator.next();
            Object key   = entry.getKey();
            Object value = entry.getValue();
            System.out.println(key + " = " + value + " ");

            //you must use an iterator if you want to remove elements while looping over them
            if(key.equals("Anna")) {
                it.remove();    //remove the current entry
            }
        }
        System.out.println("map = " + map);


        Map map2 = new HashMap();
        map2.put("O", "Otto");
        map2.put("R", "Roman");
        map2.put("Re", "Renate");
        map2.put("Ru", "Rupert");
        map2.put("RO", "Robert");

        map.putAll(map2);   //add all entries of map2 at once

        map.clear();
        System.out.println(map.isEmpty());       // true
    }
}

