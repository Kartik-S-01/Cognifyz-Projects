import java.util.*;

public class PasswordGenerator 
{

    // Define character sets
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARS = "!@#$%^&*()-_=+[]{}|;:,.<>?";

    private static final String ALL_CHARS = UPPERCASE + LOWERCASE + DIGITS + SPECIAL_CHARS;

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter desired password length: ");
        int length = sc.nextInt();

        if (length < 4) 
        {
            System.out.println("Password length should be at least 4 characters.");
            return;
        }

        String password = generatePassword(length);
        System.out.println("Generated Password: " + password);
    }

    public static String generatePassword(int length) 
    {
        Random random = new Random();
        StringBuilder password = new StringBuilder();

        password.append(getRandomChar(UPPERCASE, random));      // Ensure at least one character from each category
        password.append(getRandomChar(LOWERCASE, random));
        password.append(getRandomChar(DIGITS, random));
        password.append(getRandomChar(SPECIAL_CHARS, random));

        for (int i = 4; i < length; i++) 
        {
            password.append(getRandomChar(ALL_CHARS, random));
        }

       return shuffleString(password.toString(), random);       // Shuffle the characters
    }

    private static char getRandomChar(String chars, Random random)      // get a random character from a given string
    {
        return chars.charAt(random.nextInt(chars.length()));
    }

    // Helper method to shuffle characters in a string
    private static String shuffleString(String input, Random random) 
    {
        char[] array = input.toCharArray();
        for (int i = array.length - 1; i > 0; i--) 
        {
            int j = random.nextInt(i + 1);
            char temp = array[i];                             // Swap characters
            array[i] = array[j];
            array[j] = temp;
        }
        return new String(array);
    }
}
