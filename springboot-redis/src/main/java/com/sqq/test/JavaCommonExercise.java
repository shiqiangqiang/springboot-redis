package com.sqq.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import org.junit.Test;

import com.sun.javafx.collections.MappingChange.Map;

public class JavaCommonExercise {
	
	/**
	 * traversal Map
	 */
	@Test
	public void printMap() {
		HashMap<String, String> hm = new HashMap<String, String>();
		hm.put("s1", "11");
		hm.put("s2", "22");
		hm.put("s3", "33");
		Iterator<Entry<String, String>> iterator = hm.entrySet().iterator();
		while(iterator.hasNext()) {
			Entry<String, String> entry = iterator.next();
			System.out.println(entry.getKey() + entry.getValue());
		}
	}
	
	
	
	
	
	
	
}
