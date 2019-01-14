package test.regextest;

import com.kobold.regex.RegexConst;
import com.kobold.stringutils.LevenshteinSearch;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
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
		var str1="12312@qq.com";
		var matcher1=regex.matcher(str1);
		Assert.assertTrue(matcher1.matches());
	}

	@Test
	public void testLevenshtein(){
		String str1="今天";
		List<String> list=new ArrayList<>();
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


		LevenshteinSearch search=new LevenshteinSearch(str1,list);
		search.levenshteinSort().forEach(m->{
			System.out.println(m);
		});
	}
}
