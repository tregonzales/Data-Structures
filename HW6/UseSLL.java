//Tre Gonzales fgonzales19@cmc.edu

import java.io.*;
import java.util.Arrays;
import java.util.Iterator;

public class UseSLL {

    public static void main (String [ ] args) {
        
        SLL<String> words = new SLL<String>();

        String word1 = "Apple";
        String word2 = "Pear";
        String word3 = "Kiwi";
        String word4 = "Orange";
        String word5 = "pineapple";

        words.add(word4);
        words.add(word3);
        words.add(word2);
        words.add(null);
        words.add(word1);
      

        System.out.println("List : " + words);
        System.out.println("size: " + words.size());
        System.out.println(words.indexOf(word1));
        
        words.set(1, word5);
        System.out.println("List : " + words);

        System.out.println("contains before: " + words.contains(word1));
        words.remove(word1);  // remove Apple
        System.out.println("contains after: " + words.contains(word1));
        System.out.println("List : " + words);

        System.out.println("contains null 1: " + words.contains(null));

        words.remove(word3);  // remove Kiwi
        System.out.println("List : " + words);

        words.remove(word4);  // remove Orange
        System.out.println("List : " + words);

        words.remove(word2);  // remove Pear
        System.out.println("List : " + words);

        words.remove(word4);  // remove Orange once more on empty list
        System.out.println("List : " + words);
        
        
        words.add(word4); //add previously removed words back in 
        words.add(word3);
        System.out.println("List : " + words);
        
        System.out.println(Arrays.deepToString(words.toArray()));
        

        words.remove(null); 
        System.out.println("List : " + words);

        System.out.println("contains null 2: " + words.contains(null));
        
        Iterator <String> itr=words.iterator();
        if(itr.hasNext()) {
        	System.out.println(itr.next());
        }
        
        
        
       

    }

}