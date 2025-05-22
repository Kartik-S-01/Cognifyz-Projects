import java.util.*;

public class passwordstrength 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your password: ");
        String password = sc.nextLine();

        int strength = checkstrength(password);

        if (strength <= 2) 
        {
            System.out.println("password strength: weak");
        } 
        
        else if (strength == 3 || strength == 4) 
        {
            System.out.println("password strength: medium");
        } 
        
        else 
        {
            System.out.println("password strength: strong");
        }
    }

    public static int checkstrength(String password) 
    {
        int score = 0;

        if (password.length() >= 8) 
        {
            score++;
        }

        if (password.matches(".*[a-z].*")) 
        {
            score++;
        }

        if (password.matches(".*[A-Z].*")) 
        {
            score++;
        }

        if (password.matches(".*\\d.*")) 
        {
            score++;
        }

        if (password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*")) 
        {
            score++;
        }

        return score;
    }
}
