package repository;

import car.Car;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class CarRepositoryFileImpl implements CarRepository{

    private static final String FILE = "cars.txt";

    private List<Car> read() {
        List<Car> list = new ArrayList<>();

        File file = new File(FILE);
        if (!file.exists()) {
            return list;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(FILE))) {

            String line;

            while ((line = br.readLine()) != null) {

                if (line.isBlank()) continue; // ВАЖНО

                String[] p = line.split("\\|");

                if (p.length < 7) continue; // защита

                list.add(new Car(
                        p[0],
                        p[1],
                        Integer.parseInt(p[2]),
                        Integer.parseInt(p[3]),
                        Integer.parseInt(p[4]),
                        Integer.parseInt(p[5]),
                        Integer.parseInt(p[6])
                ));
            }

        } catch (Exception e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
        }

        return list;
    }

    private void write(List<Car> cars) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE))) {

            for (Car c : cars) {

                bw.write(c.getBrand() + "|" +
                        c.getModel() + "|" +
                        c.getYear() + "|" +
                        c.getHorsepower() + "|" +
                        c.getAcceleration() + "|" +
                        c.getSuspension() + "|" +
                        c.getDurability());

                bw.newLine();
            }

        } catch (Exception e) {
            System.out.println("Ошибка записи файла");
        }
    }

    @Override
    public void create(Car car) {
        List<Car> cars = read();
        cars.add(car);
        write(cars);
    }

    @Override
    public Car findByModel(String model) {
        return read().stream()
                .filter(c -> c.getModel().equals(model))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Машина не найдена"));
    }

    @Override
    public List<Car> findAll() {
        return read();
    }

    @Override
    public void deleteAll() {
        write(new ArrayList<>());
    }
}
