package ru.inno.java.task1.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.inno.java.task1.exceptions.UserNotFoundException;
import ru.inno.java.task1.model.User;

import java.io.File;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UsersRepositoryFileImplTest {

    UsersRepository repo;

    @BeforeEach
    void setup() {
        repo = new UsersRepositoryFileImpl();
        new File("users.txt").delete(); // очищаем файл перед каждым тестом
    }

    private User createUser(String id) {
        User user = new User();
        user.setId(id);
        user.setLogin("user_" + id);
        user.setPassword("pass123_");
        user.setConfirmPassword("pass123_");
        user.setAge(25);
        user.setWorker(true);

        user.setDate(LocalDateTime.now());

        return user;
    }

    // 1. Позитивный тест: create + findById
    @Test
    void createAndFindById_success() {
        User user = createUser("1");

        repo.create(user);

        User found = repo.findById("1");

        assertNotNull(found);
        assertEquals("1", found.getId());
    }

    // 2. Позитивный тест: findAll
    @Test
    void findAll_success() {
        repo.create(createUser("1"));
        repo.create(createUser("2"));

        List<User> users = repo.findAll();

        assertEquals(2, users.size());
    }

    // 3. Тест на исключение: findById (не найден)
    @Test
    void findById_notFound() {
        assertThrows(UserNotFoundException.class, () -> {
            repo.findById("999");
        });
    }

    // 4. Тест на исключение: deleteById (не найден)
    @Test
    void deleteById_notFound() {
        assertThrows(UserNotFoundException.class, () -> {
            repo.deleteById("999");
        });
    }
}