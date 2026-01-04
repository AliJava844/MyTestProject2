package homeworks.homework12.task1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();


        try {
            Person person = new Person(line);

            writeFile(person);

            System.out.println("Данные успешно записаны в файл: " + person.getSurname()+ ".txt");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }


        
    }

    private static void writeFile(Person person) throws IOException {
        String fileName = person.getSurname() + ".txt";

        // try-with-resources автоматически закроет файл (пункт 6)
        // параметр true в FileWriter включает режим append (дозапись) (пункт 5)
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(person.toString() + "\n");
        }
    }
}
