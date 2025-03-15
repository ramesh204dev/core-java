package com.test.collection;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapExplore {

	public static void main(String[] args) {
		Map<String, Integer> map1,map2,map3;
		
		map1 = Map.of(
				"A",1,
				"D",2,
				"E",3,
				"B",4
				);
		
	map2 = new LinkedHashMap<String, Integer>(map1);
	map3 = new TreeMap<String, Integer>(map1);
	
	System.out.println(map1);
	
	System.out.println(map2);
	
	System.out.println(map3);

	}

}
