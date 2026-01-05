package homeworks.homework12.task2;

import homeworks.homework12.task2.exceptions.WrongLoginException;
import homeworks.homework12.task2.exceptions.WrongPasswordException;

public class User {
    private String login;
    private String password;


    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public static boolean validate(String login, String password, String confirmPassword) {
        try {
            // Проверка логина
            if (!login.matches("[A-Za-z0-9_]+") || login.length() >= 20) {
                throw new WrongLoginException("Invalid login format");
            }

            // Проверка пароля
            if (!password.matches("[A-Za-z0-9_]+") || password.length() >= 20) {
                throw new WrongPasswordException("Invalid password format");
            }

            // Проверка подтверждения
            if (!password.equals(confirmPassword)) {
                throw new WrongPasswordException("Password mismatch");
            }

            return true; // если все проверки прошли

        } catch (WrongLoginException | WrongPasswordException ex) {
            System.out.println("Ошибка: " + ex.getMessage());
            return false;
        }
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;
        return login.equals(user.login) && password.equals(user.password);
    }

    @Override
    public int hashCode() {
        int result = login.hashCode();
        result = 31 * result + password.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
