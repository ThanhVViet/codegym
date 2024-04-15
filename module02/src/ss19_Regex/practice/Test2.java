package ss19_Regex.practice;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test2 {
    public static void main(String[] args) {
        String text1 = "Hello java regex 2-12-2018, hello world 12/12/2018";

        Pattern pattern = Pattern.compile("\\d{1,2}[-|/]\\d{1,2}[-|/]\\d{4}");

        Matcher matcher = pattern.matcher(text1);

        System.out.println("Ngày tháng trong chuỗi text1: " + text1);

        while (matcher.find()) {

            System.out.println(text1.substring(matcher.start(), matcher.end()));

        }


        String text2 = "2/12/2018";

        String text3 = "12/12/aaaa";

        pattern = Pattern.compile("^\\d{1,2}[-|/]\\d{1,2}[-|/]\\d{4}$");

        System.out.println("\nChuỗi " + text2 + " có định dạng ngày tháng: "

                + pattern.matcher(text2).matches());

        System.out.println("Chuỗi " + text3 + " có định dạng ngày tháng: "

                + pattern.matcher(text3).matches());
    }
//    \d{1,2}: nghĩa là một số có 1 hoặc 2 chữ số (ngày và tháng).
//            [-|/]: nghĩa là ký tự - hoặc /.
//            \d{4}: nghĩa là một số có 4 chữ số (năm)
}
