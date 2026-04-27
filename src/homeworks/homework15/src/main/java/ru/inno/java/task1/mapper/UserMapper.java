package ru.inno.java.task1.mapper;

import ru.inno.java.task1.model.User;

import java.time.LocalDateTime;

public class UserMapper {

    public static User mapToUser(String line) {
        String[] data = line.split("\\|");

        return new User(
                data[0],
                LocalDateTime.parse(data[1]),
                data[2],
                data[3],
                data[4],
                data[5],
                data[6],
                data[7],
                Integer.parseInt(data[8]),
                Boolean.parseBoolean(data[9])
        );
    }
}
