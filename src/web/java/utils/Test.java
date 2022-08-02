package web.java.utils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import web.java.dao.UserDAO;
import web.java.model.User;

public class Test {
	public static void main(String[] args) {
		Set<Integer> hash_Set = new HashSet<Integer>();
		 
        // Adding elements to the Set
        // using add() method
        hash_Set.add(1);
        hash_Set.add(2);
        hash_Set.add(3);
        hash_Set.add(4);
        hash_Set.add(3);
 
        // Printing elements of HashSet object
        for(Integer x: hash_Set) {
        	System.out.println(x);
        }
	}
}
