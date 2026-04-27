package ru.inno.java.task1;

import ru.inno.java.task1.model.User;
import ru.inno.java.task1.repositories.UsersRepository;
import ru.inno.java.task1.repositories.UsersRepositoryFileImpl;

import java.time.LocalDateTime;
import java.util.List;

public class App {
    public static void main(String[] args) {
        UsersRepository repo = new UsersRepositoryFileImpl();

        User user = new User(
                "123",
                LocalDateTime.now(),
                "ivan_123",
                "pass123",
                "pass123",
                "Иванов",
                "Иван",
                "Иванович",
                25,
                true
        );

        repo.create(user);

        System.out.println("Найден пользователь:");
        System.out.println(repo.findById(user.getId()));

        System.out.println("Все пользователи:");
        repo.findAll().forEach(u -> System.out.println(u.toString()));

        user.setAge(30);
        repo.update(user);

        List<User> workers = repo.findByIsWorker(true);

        System.out.println("Работники:");
        workers.forEach(u -> System.out.println(u.toString()));

        repo.deleteById(user.getId());

        repo.deleteAll();
    }
}
