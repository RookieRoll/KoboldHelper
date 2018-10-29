package test.regextest;

import com.kobold.regex.RegexConst;
import org.junit.Assert;
import org.junit.Test;

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
}
