package demoRegex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatches
{
    public static void main( String args[] ){

      // 按指定模式在字符串查找
      String line = "This order was placed for QT3000! OK?";
      String pattern1 = ".*";
      String pattern2 = ".*\\d+.*";

      // 创建 Pattern 对象
      Pattern r = Pattern.compile(pattern1);

      // 现在创建 matcher 对象
      Matcher m = r.matcher(line);
      r = Pattern.compile(pattern2);
      m.usePattern(r);
      if (m.find( )) {
    	 System.out.println("Group count: " + m.group());
      }
   }
}
