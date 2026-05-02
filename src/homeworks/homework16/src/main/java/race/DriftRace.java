package race;

import car.Car;

public class DriftRace extends Race{

    @Override
    public String start() {

        Car winner = getParticipants()
                .stream()
                .max((c1, c2) ->
                        (c1.getSuspension() + c1.getAcceleration())
                                - (c2.getSuspension() + c2.getAcceleration()))
                .orElse(null);

        return "DriftRace winner: " + winner;
    }
}
