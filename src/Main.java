import java.io.*;
import java.util.Scanner;

public class Main  {
    public static void main(String[] args) throws IOException {

        //System.out.println("Введите путь до файла и нажмите <Enter>: ");
        //String path = new Scanner(System.in).nextLine();
        String path = "C:\\Users\\pps_r\\IdeaProjects\\AccessLogParser\\access.log";
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
            BufferedReader reader = null;
            try {
                FileReader fileReader = new FileReader(path);
                reader = new BufferedReader(fileReader);
            } catch (FileNotFoundException ffe) {
                System.out.println("FileNotFound");
            }
            String line;
            int count = 0;
            int countMozilla = 0;
            int countGooglebot = 0;
            int countYandexbot = 0;
            int length = 0;
            while ((line = reader.readLine()) != null) {
                /*
                length = line.length();
                String[] parts = firstBrackets.split(";");
                if (parts.length >=2){
                    String fragment = parts[1];
                }
                 */
                if (line.matches(".*"+"Mozilla"+".*")){
                    countMozilla++;
                }
                if (line.matches(".*"+"YandexBot"+".*")){
                    countYandexbot++;
                }
                if (line.matches(".*"+"Googlebot"+".*")){
                    countGooglebot++;
                }
                if (length > 1024) {
                    throw new RuntimeException("Строка не должна быть длиннее 1024 символа");
                }
                try {
                    length = line.length();
                    count++;
                } catch (RuntimeException re) {
                        System.out.println("String must be shorter than 1024 characters");
                }

            }
            System.out.println("Количество строка: " + count);
            System.out.println("Число вхождений Mozilla:"+ countMozilla);
            System.out.println("Число вхождений Googlebot:"+ countGooglebot);
            System.out.println("Число вхождений Yandexbot:"+ countYandexbot);
            System.out.println("Доля запросов от Гуглоботов:" + (double) countGooglebot/countMozilla);
            System.out.println("Доля запросов от Яндексботов:" + (double) countYandexbot/countMozilla);

        }
    }
}
