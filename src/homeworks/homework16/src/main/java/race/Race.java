package race;

import car.Car;
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
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public abstract class Race {

    private int length;
    private String route;
    private int prizePool;
    private List<Car> participants = new ArrayList<>();

    public void addParticipant(Car car) {
        participants.add(car);
    }

    public abstract String start();

}
