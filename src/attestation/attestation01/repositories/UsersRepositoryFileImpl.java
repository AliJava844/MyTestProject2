package attestation.attestation01.repositories;

import attestation.attestation01.exceptions.UserNotFoundException;
import attestation.attestation01.mapper.UserMapper;
import attestation.attestation01.model.User;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UsersRepositoryFileImpl implements UsersRepository {

    private static final String FILE_NAME = "users.txt";

    private List<User> readUsers() {

        List<User> users = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {

            String line;

            while ((line = reader.readLine()) != null) {

                users.add(UserMapper.mapToUser(line));

            }

        } catch (IOException e) {

            System.out.println("Ошибка чтения файла");

        }

        return users;
    }

    private void writeUsers(List<User> users) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {

            for (User user : users) {

                writer.write(user.toString());
                writer.newLine();

            }

        } catch (IOException e) {

            System.out.println("Ошибка записи файла");

        }
    }


    @Override
    public void create(User user) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {

            writer.write(user.toString());
            writer.newLine();

        } catch (IOException e) {

            System.out.println("Ошибка записи");

        }
    }

    @Override
    public User findById(String id) {

        return readUsers()
                .stream()
                .filter(u -> u.getId().equals(id))
                .findFirst()
                .orElseThrow(() ->
                        new UserNotFoundException("Пользователь не найден"));
    }

    @Override
    public List<User> findAll() {
        return readUsers();
    }

    @Override
    public void update(User user) {

        List<User> users = readUsers();

        boolean found = false;

        for (int i = 0; i < users.size(); i++) {

            if (users.get(i).getId().equals(user.getId())) {

                users.set(i, user);
                found = true;
                break;
            }
        }

        if (!found) {
            users.add(user);
        }

        writeUsers(users);
    }

    @Override
    public void deleteById(String id) {

        List<User> users = readUsers();

        boolean removed = users.removeIf(u -> u.getId().equals(id));

        if (!removed) {
            throw new UserNotFoundException("Пользователь не найден");
        }

        writeUsers(users);
    }

    @Override
    public void deleteAll() {

        writeUsers(new ArrayList<>());
    }

    @Override
    public List<User> findByAge(int age) {

        List<User> result = new ArrayList<>();

        for (User user : readUsers()) {

            if (user.getAge() != null && user.getAge() == age) {
                result.add(user);
            }

        }

        return result;
    }

    @Override
    public List<User> findByIsWorker(boolean isWorker) {

        List<User> result = new ArrayList<>();

        for (User user : readUsers()) {

            if (user.isWorker() == isWorker) {
                result.add(user);
            }

        }

        return result;
    }
}
