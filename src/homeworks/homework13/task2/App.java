package homeworks.homework13.task2;

import homeworks.homework13.task2.utils.ParseUtils;
import homeworks.homework13.task2.utils.ValidateUtils;

public class App {
    public static void main(String[] args) {
        Integer result1 = ParseUtils.parseCount("100");

        System.out.println(result1);

        ValidateUtils.filter(result1, n -> n.intValue() > 0);
    }
}
