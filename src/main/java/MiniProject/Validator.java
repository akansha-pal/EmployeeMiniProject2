package MiniProject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    public boolean idValidator(String id){
        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher match = pattern.matcher(id);
        return match.find();
    }
    public boolean nameValidator(String name){
        Pattern pattern = Pattern.compile("[A-Z]+([A-Za-z][ '-]+)*");
        Matcher match = pattern.matcher(name);
        return match.find();
    }
    public boolean dateValidator(String date){
        Pattern pattern = Pattern.compile("[0-9]{1,2}/[0-9]{1,2}/[0-9]{4}");
        Matcher match = pattern.matcher(date);
        return match.find();
    }
    public boolean genderValidator(String gender){
        Pattern pattern = Pattern.compile("[MFX]");
        Matcher match = pattern.matcher(gender);
        return match.find();
    }
}
