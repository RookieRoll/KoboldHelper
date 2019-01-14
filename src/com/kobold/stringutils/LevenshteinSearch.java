package com.kobold.stringutils;

import com.kobold.listutils.ListUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LevenshteinSearch {

	private String searchValue;
	private List<String> originSource;

	public LevenshteinSearch(String searchValue, List<String> originSource) {
		this.searchValue = searchValue;
		this.originSource = originSource;
	}

	public List<String> levenshteinSort() {
		List<List<Object>> list = ListUtils.getPartitional(originSource, 2);
		List<TempClass> tempResult = new ArrayList<>();
		for (List<Object> m : list) {
			List<TempClass> tempPartitions = m.parallelStream().map(n -> {
				var sort = levenshtein((String) n, searchValue);
				return new TempClass((String) n, sort);
			}).collect(Collectors.toList());
			tempResult.addAll(tempPartitions);
		}

		return tempResult.stream().sorted(Comparator.comparing(TempClass::getSortIndex).reversed()).map(m -> m.getSource()).collect(Collectors.toList());
	}


	public float levenshtein(String str1, String str2) {
		//计算两个字符串的长度。
		int len1 = str1.length();
		int len2 = str2.length();
		//建立上面说的数组，比字符长度大一个空间
		int[][] dif = new int[len1 + 1][len2 + 1];
		//赋初值，步骤B。
		for (int a = 0; a <= len1; a++) {
			dif[a][0] = a;
		}
		for (int a = 0; a <= len2; a++) {
			dif[0][a] = a;
		}
		//计算两个字符是否一样，计算左上的值
		int temp;
		for (int i = 1; i <= len1; i++) {
			for (int j = 1; j <= len2; j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					temp = 0;
				} else {
					temp = 1;
				}
				//取三个值中最小的
				dif[i][j] = min(dif[i - 1][j - 1] + temp, dif[i][j - 1] + 1,
						dif[i - 1][j] + 1);
			}
		}

		float similarity = 1 - (float) dif[len1][len2] / Math.max(str1.length(), str2.length());
		return similarity;
	}

	//得到最小值
	private int min(int... is) {
		int min = Integer.MAX_VALUE;
		for (int i : is) {
			if (min > i) {
				min = i;
			}
		}
		return min;
	}

}

class TempClass {
	private String source;
	private float sortIndex;

	TempClass(String source, float sortIndex) {
		this.source = source;
		this.sortIndex = sortIndex;
	}

	public float getSortIndex() {
		return sortIndex;
	}

//	public void setSortIndex(float sortIndex) {
//		this.sortIndex = sortIndex;
//	}

	public String getSource() {
		return source;
	}

//	public void setSource(String source) {
//		this.source = source;
//	}
}
