package evernote;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

// @ Author: Avinash 
public class frequncycountoftopkwords 
{
	
	public static void main(String[] args) 
	{    
		
        Scanner sc = new Scanner(System.in);
        //Accept the input from user 
        int userinput = Integer.parseInt(sc.nextLine().trim());
        int counter = 0;
        TreeMap<String, Integer> frequencycount  = new TreeMap<String, Integer>();
        //If Entry is present in Tree Map incr entry by one else add the entry to tree map and set value to 1 
        for (int index = 0; index < userinput; index++) {
            String s = sc.nextLine();
            if (frequencycount.containsKey(s)) {
                frequencycount.put(s, frequencycount.get(s) + 1);
            } else {
                frequencycount.put(s, 1);

            }
        }
        counter = Integer.parseInt(sc.nextLine().trim());
        // Create a list from Tree Map 
        ArrayList ls = new ArrayList(frequencycount.entrySet());
        // Sort in decsending order 
        Collections.sort(ls, new Compare());
        Iterator iterator = ls.iterator();
        while (iterator.hasNext() && counter > 0) {

            Map.Entry e = (Map.Entry) iterator.next();
            if (counter != 1) {
                System.out.println(e.getKey());
            } else {
                System.out.print(e.getKey());
            }
            counter--;
        }
        
    }

    static class Compare implements Comparator 
    {

        @Override
        public int compare(Object object1, Object object2) {
            int result = 0;
            Map.Entry entry1 = (Map.Entry) object1;
            Map.Entry entry2 = (Map.Entry) object2;
            int value1 = (Integer) entry1.getValue();
            int value2 = (Integer) entry2.getValue();
            if(value1==value2)
                return ((String)entry1.getKey()).compareToIgnoreCase((String)entry2.getKey());
            return value2 - value1;

        }

    }
}
    
/* Test Input
14
Fee
Fi
Fo
Fum
Fee
Fo
Fee
Fee
Fo
Fi
Fi
Fo
Fum
Fee
3
Test Output
Fee
Fo
Fi
*/
