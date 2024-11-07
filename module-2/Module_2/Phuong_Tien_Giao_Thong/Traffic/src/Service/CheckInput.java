package Service;

import model.Struck;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckInput {
    public static final String Struck_REGEX = "43C-[0-9]{2,3}\\.\\d{2,3}$";
    public static final Pattern Struck_Patten = Pattern.compile(Struck_REGEX);
    public static final String Car_REGEX = "43(A|B)-[0-9]{2,3}\\.\\d{2,3}$";
    public static final Pattern Car_Patten = Pattern.compile(Car_REGEX);
    public static final String Motobike_REGEX ="43-(H1|K1|AK)-[0-9]{2,3}\\.\\d{2,3}";
    public static final Pattern Motobike_Patten = Pattern.compile(Motobike_REGEX);

    public static boolean chechInputStruck(String controlPlate){
        Matcher matcher = Struck_Patten.matcher(controlPlate);
        return matcher.matches();
    }
    public static boolean checkInputCar(String controlPlate){
        Matcher matcher = Car_Patten.matcher(controlPlate);
        return matcher.matches();
    }
    public static boolean checkInputMotobike(String controlPlate){
        Matcher matcher = Motobike_Patten.matcher(controlPlate);
        return matcher.matches();
    }

    public static boolean checkInputCarCompany(String carCompany){
        if (carCompany.equalsIgnoreCase("Yamaha"))
        {
            return true;
        } else if (carCompany.equalsIgnoreCase("Honda")) {
            return true;
        }else if (carCompany.equalsIgnoreCase("Dongfeng")) {
            return true;
        }else if (carCompany.equalsIgnoreCase("Huyndai")) {
            return true;
        }else if (carCompany.equalsIgnoreCase("Ford")) {
            return true;
        }
        else if (carCompany.equalsIgnoreCase("Toyota")) {
            return true;
        }
        else if (carCompany.equalsIgnoreCase("Hino")) {
            return true;
        }
        return false;
    }
}

