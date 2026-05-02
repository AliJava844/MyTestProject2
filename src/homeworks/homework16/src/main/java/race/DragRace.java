package race;

import car.Car;

public class DragRace extends Race{
    @Override
    public String start() {

        Car winner = getParticipants()
                .stream()
                .max((c1, c2) ->
                        c1.getHorsepower() - c2.getHorsepower())
                .orElse(null);

        return "DragRace winner: " + winner;
    }
}
