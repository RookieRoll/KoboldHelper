package test.regextest;

import com.kobold.listutils.ListUtils;
import com.kobold.objectutils.ObjectHelpers;
import com.kobold.regex.RegexConst;
import com.kobold.stringutils.LevenshteinSearch;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;


public class RegexUnitTest {

	@Test
	/**
	 * 测试邮箱校验
	 */
	public void testEmailRegex() {
		var str = "2718934@qq.con@a";
		Pattern regex = Pattern.compile(RegexConst.EMAIL_REGEX);
		var matcher = regex.matcher(str);
		Assert.assertFalse(matcher.matches());
		var str1 = "12312@qq.com";
		var matcher1 = regex.matcher(str1);
		Assert.assertTrue(matcher1.matches());
	}

	@Test
	public void testLevenshtein() {
		String str1 = "今天";
		List<String> list = new ArrayList<>();
		list.add("今天还好");
		list.add("今天adf好");
		list.add("今天");
		list.add("前天天还好");
		list.add("未来还好");
		list.add("希望还好");
		list.add("今asdsf还好");
		list.add("今天还好dgfd");
		list.add("今天buhao还好");
		list.add("明天还好");
		list.add("后天还好");
		list.add("昨天天还好");


		LevenshteinSearch search = new LevenshteinSearch(str1, list);
		search.levenshteinSort(0.19).forEach(m -> {
			System.out.println(m);
		});
	}

	@Test
	public void testMaxKNumber() {
		int[] number = new int[]{2, 3, 4, 562, 1, 4, 6, 8, 56, 4, 3, 2, 4, 6, 8, 4, 34, 234, 6, 7, 3, 423, 12, 67, 3, 23, 45, 34, 2, 2, 34345, 65, 74, 5, 345, 7568, 7, 88, 6, 45};
		var result = ListUtils.getMaxKNumber(number, 1);
		result.forEach(System.out::println);
	}

	@Test
	public void testEqualsTwoObject() {
		StudentTest s1 = new StudentTest("adgfa", 12);
		StudentTest s2 = new StudentTest("adgfa", 12);
		List<String> map=new ArrayList<>();
		map.add("age");
		var result = ObjectHelpers.equalTwoObject(s1, s2,map);
		Assert.assertTrue(result);
		s1.setAge(23);
		Assert.assertTrue(ObjectHelpers.equalTwoObject(s1, s2,map));
	}
}
