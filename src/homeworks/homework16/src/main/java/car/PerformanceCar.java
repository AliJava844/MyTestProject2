package car;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@ToString
public class PerformanceCar extends Car{
    private List<String> addOns = new ArrayList<>();

    public PerformanceCar(String brand, String model, int year,
                          int horsepower, int acceleration,
                          int suspension, int durability) {

        super(brand, model, year,
                (int)(horsepower * 1.5),
                acceleration,
                (int)(suspension * 0.75),
                durability);
    }
}
