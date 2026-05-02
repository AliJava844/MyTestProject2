import car.Car;
import car.PerformanceCar;
import car.ShowCar;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Garage {

    private List<Car> parkedCars = new ArrayList<>();

    // 🚗 припарковать
    public void park(Car car) {
        parkedCars.add(car);
    }

    // 🚗 убрать из гаража
    public void unpark(Car car) {
        parkedCars.remove(car);
    }

    // 🔧 ТЮНИНГ
    public void tune(int horsepower, int suspension, String addOn) {

        for (Car car : parkedCars) {

            // увеличиваем мощность
            car.setHorsepower(car.getHorsepower() + horsepower);

            // увеличиваем подвеску
            car.setSuspension(car.getSuspension() + suspension);

            // если PerformanceCar → добавляем addOn
            if (car instanceof PerformanceCar performanceCar) {
                performanceCar.getAddOns().add(addOn);
            }

            // если ShowCar → увеличиваем stars
            if (car instanceof ShowCar showCar) {
                showCar.setStars(showCar.getStars() + 1);
            }
        }
    }
}
