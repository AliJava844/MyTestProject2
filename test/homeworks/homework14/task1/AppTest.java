package homeworks.homework14.task1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


class AppTest {

    @Test
    void getInputLine() {
        System.out.println("Тест запущен!");
        String inputLine = "Павел Андреевич=10000";
        Person result = App.getPersonFromLine(inputLine);

        Assertions.assertAll(() -> {
            Assertions.assertNotNull(result);
            Assertions.assertEquals("Павел Андреевич", result.getName());
            Assertions.assertEquals(10000, result.getMoney());
        });
    }

    @Test
    void getInputLineWithError() {
        String inputLine = "Павел Андреевич=bdfbdfb";

        Assertions.assertThrows(NumberFormatException.class, () -> App.getPersonFromLine(inputLine));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Павел Андреевич=vfvrv", "dffvbf=vbjhebvj"})
    void getInputLineWithErrorPar(String inputLine) {

        Assertions.assertThrows(NumberFormatException.class, () -> App.getPersonFromLine(inputLine));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Павел Андреевич=10000",
            "Павел Андреевич=10000;Анна Петровна=2000",
            "Павел Андреевич=10000;Анна Петровна=2000;Борис=10"})
    void getPersons(String input) {
        Person[] result = App.getPersons(input);

        Assertions.assertAll(() -> {
            Assertions.assertNotNull(result);
            Assertions.assertNotEquals(0, result.length);
        });
    }

}