package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckInput {
    public static final String KHVN_REGEX = "KHVN_[0-9]{4}$";
    public static final Pattern KHVN_PATTEN = Pattern.compile(KHVN_REGEX);
    public static final String KHNN_REGEX = "KHVN_[0-9]{4}$";
    public static final Pattern KHNN_PATTEN = Pattern.compile(KHNN_REGEX);

    public static boolean checkInputKHVN(String id){
        Matcher matcher = KHVN_PATTEN.matcher(id);
        return matcher.matches();
    }
    public static boolean checkInputKHNN(String id){
        Matcher matcher = KHNN_PATTEN.matcher(id);
        return matcher.matches();
    }

}
