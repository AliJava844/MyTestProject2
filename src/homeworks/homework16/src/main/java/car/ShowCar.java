package car;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString
@NoArgsConstructor
public class ShowCar extends Car{
    private int stars = 0;

    public ShowCar(String brand, String model, int year,
                   int horsepower, int acceleration,
                   int suspension, int durability) {

        super(brand, model, year,
                horsepower, acceleration, suspension, durability);
    }

}
