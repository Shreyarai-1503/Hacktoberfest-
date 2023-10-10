import java.security.SecureRandom;

public class PasswordGenerator {
    private static final String LOWERCASE_CHARS = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARS = "!@#$%^&*()-_=+[]{}|;:'\",.<>?";

    public static void main(String[] args) {
        int length = 12; // Change the desired password length here
        boolean includeLowercase = true;
        boolean includeUppercase = true;
        boolean includeDigits = true;
        boolean includeSpecialChars = true;

        String password = generatePassword(length, includeLowercase, includeUppercase, includeDigits, includeSpecialChars);
        System.out.println("Generated Password: " + password);
    }

    public static String generatePassword(int length, boolean includeLowercase, boolean includeUppercase,
            boolean includeDigits, boolean includeSpecialChars) {
        StringBuilder password = new StringBuilder();
        String validChars = "";

        if (includeLowercase) {
            validChars += LOWERCASE_CHARS;
        }
        if (includeUppercase) {
            validChars += UPPERCASE_CHARS;
        }
        if (includeDigits) {
            validChars += DIGITS;
        }
        if (includeSpecialChars) {
            validChars += SPECIAL_CHARS;
        }

        if (validChars.isEmpty()) {
            throw new IllegalArgumentException("At least one character set must be included.");
        }

        SecureRandom random = new SecureRandom();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(validChars.length());
            char randomChar = validChars.charAt(randomIndex);
            password.append(randomChar);
        }

        return password.toString();
    }
}
