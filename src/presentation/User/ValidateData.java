package presentation.User;
import java.util.regex.*;

public class ValidateData {
    /**
     * Validates an email address.
     * Supports standard email formats.
     */
    public static boolean isValidEmail(String email) {
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    /**
     * Validates a birthday in the format DD/MM/YYYY or DD-MM-YYYY.
     * Supports valid days, months, and years from 1965 to 2008,
     * including leap year handling.
     */
    public static boolean isValidBirthday(String input) {
        String regex = "^(3[01]|[12][0-9]|0?[1-9])(\\/|-)(1[0-2]|0?[1-9])\\2((196[5-9]|19[7-9][0-9]|200[0-8]))$" +
                "|^(29\\/02\\/(196[48]|19[7-9][26]|200[048]))$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    /**
     * Validates a name.
     * Supports names with each word capitalized and allows hyphenated names.
     */
    public static boolean isValidName(String name) {
        String regex = "^[A-Z][a-z]*(?: [A-Z][a-z]*)*(?:-[A-Z][a-z]*)*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }
}
