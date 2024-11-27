    package presentation;
    import java.util.regex.*;

    public class ValidateData {
            public static boolean isValidPhoneNumber(String phoneNumber) {
                String regex = "^(\\+84|0)(3|5|7|8|9)\\d{8}$";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(phoneNumber);
                return matcher.matches();
            }
            public static boolean isValidEmail(String email) {
                String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(email);
                return matcher.matches();
            }
            public static boolean isValidBirthday(String input) {
                String regex = "^(3[01]|[12][0-9]|0?[1-9])(\\/|-)(1[0-2]|0?[1-9])\\2((196[5-9]|19[7-9][0-9]|200[0-8]))$|^(29\\/02\\/(196[48]|19[7-9][26]|200[048]))$";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(input);
                return matcher.matches();
            }
            public static boolean isValidName(String name) {
                String regex = "^[A-Z][a-z]+(?: [A-Z][a-z]*)*$";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(name);
                return matcher.matches();
            }
            public static boolean isValidAddress(String address) {
                String regex = "^\\d+\\s+([A-Z][a-z0-9]*\\s*)+$";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(address);
                return matcher.matches();
            }
    }
