import com.kobold.regex.RegexConst;

import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {
		var str = "2718934@qq.con@a";
		Pattern regex = Pattern.compile(RegexConst.EMAIL_REGEX);
		var matcher = regex.matcher(str);
		System.out.println(matcher.matches());
	}

}
