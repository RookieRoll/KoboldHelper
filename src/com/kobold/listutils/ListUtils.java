package com.kobold.listutils;

import java.util.ArrayList;
import java.util.List;

public class ListUtils {

	public static List<List<Object>> getPartitional(List<?> list, int size) {
		List<List<Object>> results= new ArrayList<>();
		int j=0;

		List<Object> tempList = new ArrayList<>();
		for(int i=0;i<list.size();i++){
			if(i==size*j){
				if(i!=0)
					results.add(tempList);
				tempList=new ArrayList<>();
				j++;
			}
			tempList.add(list.get(i));
		}
		results.add(tempList);
		return results;
	}

}
