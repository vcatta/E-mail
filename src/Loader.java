import java.util.Scanner;
import java.util.TreeSet;

public class Loader {
    private static TreeSet<String> emailList = new TreeSet<>();
    private static final String PATTERN_EMAIL = "^([_A-Za-z0-9-+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,}))$";
    private static int countEmail = 0;

    public static void main(String[] args) {

        while (true) {
            System.out.println("Добавить e-mail - команда ADD.Вывод списка введенных e-mail - команда LIST.");
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();

            if (command.toUpperCase().startsWith("ADD"))
            {
                String email = command.substring(command.indexOf(" ") + 1).trim();
                if(!validEmail(email))
                {
                    System.out.println("E-mail введен некорректно!");
                    continue;
                }

                if(addEmail(email))
                {
                   printEmailList();
                }

            }
            else {

                if (command.toUpperCase().startsWith("LIST")) {
                    if (emailList.isEmpty()) {
                        System.out.println("Список пуст!");
                        continue;
                    }
                    printEmailList();
                }

                else {
                    System.out.println("Команда не введена или введена неверно!");
                }
            }
        }

    }

    private static boolean validEmail(String command)
    {
        return command.matches(PATTERN_EMAIL);
    }

    private static boolean addEmail(String email)
    {
        emailList.add(email);
        if(emailList.size() <= countEmail)
        {
            System.out.println("E-mail не добавлен. Возможно, он был добавлен ранее.");
            return false;
        }
        countEmail++;
        System.out.println("E-mail успешно добавлен.");
        return true;
    }

    private static void printEmailList()
    {
        for (String item : emailList) {
            System.out.println(item);
        }
    }

}
