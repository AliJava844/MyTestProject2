package race;

import car.Car;

public class CasualRace extends Race{
    @Override
    public String start() {

        Car winner = getParticipants()
                .stream()
                .max((c1, c2) ->
                        (c1.getHorsepower() + c1.getAcceleration())
                                - (c2.getHorsepower() + c2.getAcceleration()))
                .orElse(null);

        return "CasualRace winner: " + winner;
    }
}
