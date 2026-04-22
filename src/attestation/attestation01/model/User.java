package attestation.attestation01.model;

import attestation.attestation01.exceptions.ValidationException;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class User {
    private String id;
    private LocalDateTime date;
    private String login;
    private String password;
    private String confirmPassword;
    private String firstName;
    private String name;
    private String lastName;
    private Integer age;
    private boolean isWorker;

    public User(String id, LocalDateTime date, String login, String password, String confirmPassword, String firstName, String name, String lastName, Integer age, boolean isWorker) {

        validateLogin(login);
        validatePassword(password, confirmPassword);
        validateName(firstName);
        validateName(name);
        validateName(lastName);

        this.id = id;
        this.date = date;
        this.login = login;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.firstName = firstName;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.isWorker = isWorker;
    }

    public User() {

    }

    private void validateLogin(String login) {

        if (!login.matches("^(?=.*[a-zA-Z])[a-zA-Z0-9_]{1,20}$")) {
            throw new ValidationException("Неверный формат login");
        }
    }

    private void validatePassword(String password, String confirmPassword) {

        if (!password.equals(confirmPassword)) {
            throw new ValidationException("Пароли не совпадают");
        }

        if (!password.matches("^(?=.*[0-9])[a-zA-Z0-9_]{1,20}$")) {
            throw new ValidationException("Неверный формат password");
        }
    }

    private void validateName(String name) {

        if (!name.matches("^[a-zA-Zа-яА-Я]+$")) {
            throw new ValidationException("Имя должно содержать только буквы");
        }
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public boolean isWorker() {
        return isWorker;
    }

    public void setWorker(boolean worker) {
        isWorker = worker;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;
        return isWorker == user.isWorker && id.equals(user.id) && date.equals(user.date) && login.equals(user.login) && password.equals(user.password) && confirmPassword.equals(user.confirmPassword) && firstName.equals(user.firstName) && name.equals(user.name) && lastName.equals(user.lastName) && age.equals(user.age);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + date.hashCode();
        result = 31 * result + login.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + confirmPassword.hashCode();
        result = 31 * result + firstName.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + age.hashCode();
        result = 31 * result + Boolean.hashCode(isWorker);
        return result;
    }

    @Override
    public String toString() {
        return id + "|" +
                date + "|" +
                login + "|" +
                password + "|" +
                confirmPassword + "|" +
                firstName + "|" +
                name + "|" +
                lastName + "|" +
                age + "|" +
                isWorker;
    }
}
