package homeworks.homework14.task1;

public class App {
    public static void main(String[] args) {

    }

    public static Person[] getPersons(String inputLine) {
        String[] personStringArray = inputLine.split(";");
        Person[] persons = new Person[personStringArray.length];

        for (int i = 0; i < personStringArray.length; i++) {
            Person p = getPersonFromLine(personStringArray[i]);
            persons[i] = p;
        }

        return persons;
    }

    public static Person getPersonFromLine(String line) {
        System.out.println("Входящая строка" + line);
        String[] params = line.split("=");
        Person person = new Person(params[0], Double.valueOf(params[1]));
        System.out.println("Создан новый покупатель" + person);
        return person;
    }
}
