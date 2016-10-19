package by.epam.task8.entity;

/**
 * Created by Davud_Murtazin on 10/19/2016.
 */
public class Car {
    private String carType;
    private String mark;
    private String title;
    private String number;
    private String color;
    private int price;

    public Car() {
    }

    public Car(String carType, String mark, String title, String number, String color, int price) {
        this.carType = carType;
        this.mark = mark;
        this.title = title;
        this.number = number;
        this.color = color;
        this.price = price;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (price != car.price) return false;
        if (carType != null ? !carType.equals(car.carType) : car.carType != null) return false;
        if (mark != null ? !mark.equals(car.mark) : car.mark != null) return false;
        if (title != null ? !title.equals(car.title) : car.title != null) return false;
        if (number != null ? !number.equals(car.number) : car.number != null) return false;
        return color != null ? color.equals(car.color) : car.color == null;

    }

    @Override
    public int hashCode() {
        int result = carType != null ? carType.hashCode() : 0;
        result = 31 * result + (mark != null ? mark.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + price;
        return result;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carType='" + carType + '\'' +
                ", mark='" + mark + '\'' +
                ", title='" + title + '\'' +
                ", number='" + number + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                '}';
    }
}
