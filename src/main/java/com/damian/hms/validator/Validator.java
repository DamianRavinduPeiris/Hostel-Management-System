package com.damian.hms.validator;

import com.damian.hms.util.GetAlert;
import javafx.scene.control.Alert;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private static Pattern userNamePattern = Pattern.compile("^[\\w.-]+@[\\w.-]+\\.[A-Za-z]{2,}$");
    /*
    ex - john3@gmail.com
*/
    private static Pattern passwordPattern = Pattern.compile("[A-Za-z0-9]+\\.");

    /*
   ex - John1234.
*/

    private  static Pattern telephonePattern = Pattern.compile("^(075|077|078|011|091|038|036)([0-9]{7})$");
    public static boolean check(String txt,ValidateTypes validateTypes){
        switch (validateTypes){
            case USERNAME:
            return validate(txt,userNamePattern);
            case PASSWORD:
                return validate(txt,passwordPattern);
            case TELEPHONE:
                return validate(txt,telephonePattern);
            default:
                GetAlert.getInstance().showAlert("Validation failed :No valid validation types found !", Alert.AlertType.ERROR);
                return false;
        }

    }
    public static boolean validate(String txt , Pattern pattern){
        Matcher matcher = pattern.matcher(txt);
        System.out.println(txt+" : "+ matcher.matches());
        return matcher.matches()?true:false;
    }

}
