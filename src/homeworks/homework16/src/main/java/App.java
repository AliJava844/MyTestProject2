import car.Car;
import car.PerformanceCar;
import car.ShowCar;
import race.DragRace;
import race.Race;
import repository.CarRepository;
import repository.CarRepositoryFileImpl;


public class App {
    public static void main(String[] args) {

        CarRepository repo = new CarRepositoryFileImpl();

        repo.deleteAll();

        // 🚗 создаём машины
        Car car1 = new Car("BMW", "M5", 2020, 600, 3, 200, 1000);
        Car car2 = new PerformanceCar("Audi", "RS7", 2021, 650, 3, 210, 1100);
        ShowCar car3 = new ShowCar("Lambo", "Huracan", 2022, 700, 2, 180, 900);
        car3.setStars(5);

        repo.create(car1);
        repo.create(car2);
        repo.create(car3);

        // 📋 вывод
        System.out.println("=== ВСЕ МАШИНЫ ===");
        repo.findAll().forEach(System.out::println);

        // 🏁 создаём гонку
        Race race = new DragRace();
        race.setLength(1000);
        race.setRoute("City");
        race.setPrizePool(10000);

        race.addParticipant(car1);
        race.addParticipant(car2);
        race.addParticipant(car3);

        System.out.println("\n=== ГОНКА ===");
        System.out.println(race.start());

        Garage garage = new Garage();

        garage.park(car1);
        garage.park(car2);
        garage.park(car3);

        System.out.println("\n=== ДО ТЮНИНГА ===");
        System.out.println(garage);

        garage.tune(50, 20, "Turbo");

        System.out.println("\n=== ПОСЛЕ ТЮНИНГА ===");
        System.out.println(garage);
    }
}
