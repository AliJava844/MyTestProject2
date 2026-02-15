package homeworks.homework14.task1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> bag;

    public Person(String name, double money, List<Product> bag) {
        this.setName(name);
        this.setMoney(money);
        this.bag = new ArrayList<>();
    }

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (!name.isEmpty()){
            this.name = name;
        } else {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        if (money >= 0) {
            this.money = money;
        } else {
            throw new IllegalArgumentException("Деньги не" +
                    "могут быть отрицательными");
        }
    }

    public List<Product> getBag() {
        return Collections.unmodifiableList(bag);
    }

    public void addProduct(Product product) {
        if (money >= product.getPrice()) {
            bag.add(product);
            money -= product.getPrice();
            System.out.println(name + " купил " + product.getNameProduct());
        } else {
            System.out.println(name + " не может позволить себе " + product.getNameProduct());
        }
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;
        return Double.compare(money, person.money) == 0 && name.equals(person.name) && bag.equals(person.bag);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + Double.hashCode(money);
        result = 31 * result + bag.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", money=" + money +
                ", bag=" + bag +
                '}';
    }
}
