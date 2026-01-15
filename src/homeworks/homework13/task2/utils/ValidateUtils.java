package homeworks.homework13.task2.utils;

import homeworks.homework13.task2.ByCondition;

public class ValidateUtils {
    public static <T extends Number> T filter(T number, ByCondition condition) {
        if (condition.isOk(number)) {
            return number;
        } else {
            throw new NumberFormatException("Число не отвечает заданному условию");
        }
    }
}
