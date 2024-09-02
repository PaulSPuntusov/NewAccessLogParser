import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Введите путь до файла и нажмите <Enter>: ");
        String path = new Scanner(System.in).nextLine();
        // path = "C:\\Users\\pps_r\\IdeaProjects\\AccessLogParser\\log.txt";
        File file = new File(path);
        boolean fileExists = file.exists();
        boolean isDirectory = file.isDirectory();
        if (fileExists == false) {
            System.out.println("Ошибочно введен путь, или файл не существует");

        }
        if ((fileExists == true) && (isDirectory == true)) {
            System.out.println("Это директория");

        }
        if ((fileExists == true) && (isDirectory == false)) {
            try {
                FileReader fileReader = new FileReader(path);
                BufferedReader reader = new BufferedReader(fileReader);
                String line;
                int count = 0;
                int maxLength = 0;
                int minLength = 0;
                if (reader.readLine() != null) minLength = reader.readLine().length();
                while ((line = reader.readLine()) != null) {
                    int length = line.length();
                    if (length > 1024) throw new RuntimeException("Строка не должна быть длиннее 1024 символа");
                    if (length > maxLength) maxLength = length;
                    if (length < minLength) minLength = length;
                    count++;
                }
                System.out.println( "Количество строка: "+ count);
                System.out.println("Самая длинная строка: "+maxLength);
                System.out.println("Самая короткая строка: "+minLength);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
    }
}
