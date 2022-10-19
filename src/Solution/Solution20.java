package Solution;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution20 {
    public static void main(String[] args) {
        String s = ".1";
        System.out.println(isNumber(s));
    }

    //    public static boolean isNumber(String s){
//        //"?":匹配前面的子表达式零次或一次，或指明一个非贪婪限定符。要匹配 ? 字符，请使用 \?。
//        //"*":匹配前面的子表达式零次或多次。要匹配 * 字符，请使用 \*。
//        //java中要加转义，为双杠
//        String pattern = "\\s*[+-]?[0-9]*((\\.[0-9])|([0-9]\\.)|[0-9])[0-9]*([eE][+-]?[0-9]+)?\\s*";
//        Pattern r = Pattern.compile(pattern);
//        Matcher m = r.matcher(s);
//
//
//        boolean result = m.matches();
//        return result;
//    }
    public static boolean isNumber(String s) {
        if (s == null || s.length() == 0) return false; // s为空对象或 s长度为0(空字符串)时, 不能表示数值
        boolean isNum = false, isDot = false, ise_or_E = false; // 标记是否遇到数位、小数点、‘e’或'E'
        char[] str = s.trim().toCharArray();  // 删除字符串头尾的空格，转为字符数组，方便遍历判断每个字符
        for (int i = 0; i < str.length; i++) {
            if (str[i] >= '0' && str[i] <= '9') isNum = true; // 判断当前字符是否为 0~9 的数位
            else if (str[i] == '.') { // 遇到小数点
                if (isDot || ise_or_E) return false; // 小数点之前可以没有整数，但是不能重复出现小数点、或出现‘e’、'E'
                isDot = true; // 标记已经遇到小数点
            } else if (str[i] == 'e' || str[i] == 'E') { // 遇到‘e’或'E'
                if (!isNum || ise_or_E) return false; // ‘e’或'E'前面必须有整数，且前面不能重复出现‘e’或'E'
                ise_or_E = true; // 标记已经遇到‘e’或'E'
                isNum = false; // 重置isNum，因为‘e’或'E'之后也必须接上整数，防止出现 123e或者123e+的非法情况
            } else if (str[i] == '-' || str[i] == '+') {
                if (i != 0 && str[i - 1] != 'e' && str[i - 1] != 'E')
                    return false; // 正负号只可能出现在第一个位置，或者出现在‘e’或'E'的后面一个位置
            } else return false; // 其它情况均为不合法字符
        }
        return isNum;
    }

}
