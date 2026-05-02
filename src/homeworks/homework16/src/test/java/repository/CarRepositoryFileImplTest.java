package repository;

import car.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class CarRepositoryFileImplTest {

    CarRepository repo;

    @BeforeEach
    void setup() throws Exception {
        repo = new CarRepositoryFileImpl();

        File file = new File("cars.txt");
        if (file.exists()) file.delete();
        file.createNewFile();
    }

    @Test
    void create_success() {
        repo.create(new Car("BMW", "M5", 2020, 600, 3, 200, 1000));
        assertEquals(1, repo.findAll().size());
    }

    @Test
    void find_success() {
        repo.create(new Car("BMW", "M5", 2020, 600, 3, 200, 1000));
        assertEquals("BMW", repo.findByModel("M5").getBrand());
    }

    @Test
    void find_notFound() {
        assertThrows(RuntimeException.class,
                () -> repo.findByModel("X5"));
    }

    @Test
    void deleteAll_success() {
        repo.create(new Car("BMW", "M5", 2020, 600, 3, 200, 1000));
        repo.deleteAll();
        assertEquals(0, repo.findAll().size());
    }

}