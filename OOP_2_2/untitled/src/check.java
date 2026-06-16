import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class check {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pattern pattern4 = Pattern.compile("\\w+@gmail.com");
        while (true){
            Matcher matcher = pattern4.matcher(scanner.nextLine());
            if(matcher.find()){
                System.out.println("ok");
/*                System.out.println(matcher.group(1));
                System.out.println(matcher.group(2));
                System.out.println(matcher.group(3));
                System.out.println(matcher.group(4));
                System.out.println(matcher.group(5));
                System.out.println(matcher.group(6));
                System.out.println(matcher.group(7));
*/
            }
            else{
                System.out.println("wrong \"");
            }
        }

    }
}