package homeworks.homework12.task1;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Person {
    private String surname;
    private String name;
    private String lastname;
    private LocalDate birthday;
    private long phoneNumber;
    private char gender;
    private int age;

    public Person(String line) {
        String[] personParams = line.split(" ");

        if (personParams.length != 7) {
            throw new IllegalArgumentException("Не верное количество параметров!");
        }

        this.surname = personParams[0];
        this.name = personParams[1];
        this.lastname = personParams[2];

        this.birthday = LocalDate.parse(personParams[3], DateTimeFormatter.ofPattern("dd.MM.yyyy"));

        if (Integer.parseInt(personParams[4]) <= 0) {
            throw new IllegalArgumentException("номер телефона не может быть отрицательным");
        } else {
            this.phoneNumber = Long.parseLong(personParams[4]);
        }

        if (!(personParams[5].equalsIgnoreCase("f") || personParams[5].equalsIgnoreCase("m"))) {
            throw new IllegalArgumentException("неправильный формат");
        } else {
            this.gender = personParams[5].charAt(0);
        }

        if (Integer.parseInt(personParams[6]) < 0) {
            throw new IllegalArgumentException("возраст не может быть меньше нуля");
        } else {
            this.age = Integer.parseInt(personParams[6]);
        }
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;
        return phoneNumber == person.phoneNumber && gender == person.gender && age == person.age && surname.equals(person.surname) && name.equals(person.name) && lastname.equals(person.lastname) && birthday.equals(person.birthday);
    }

    @Override
    public int hashCode() {
        int result = surname.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + lastname.hashCode();
        result = 31 * result + birthday.hashCode();
        result = 31 * result + Long.hashCode(phoneNumber);
        result = 31 * result + gender;
        result = 31 * result + age;
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", birthday=" + birthday +
                ", phoneNumber=" + phoneNumber +
                ", gender=" + gender +
                ", age=" + age +
                '}';
    }
}
