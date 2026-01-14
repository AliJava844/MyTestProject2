package homeworks.homework13.task1;

import homeworks.homework13.task1.utils.ParseUtils;

public class App {
    public static void main(String[] args) {
        Integer result1 = ParseUtils.parseCount("100");

        System.out.println(result1);

        Double result2 = ParseUtils.parseNumber("12.44");

        System.out.println(result2);

        Integer result3 = ParseUtils.validateCount("55");

        System.out.println(result3);

        Double result4 = ParseUtils.validateNumber("fvdfvdfv");

        System.out.println(result4);
    }
}
