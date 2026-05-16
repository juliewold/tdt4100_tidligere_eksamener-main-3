package no.ntnu.tdt4100.part1;

public class Circle extends Shape {
    private double r;

    public Circle(double r) {
        this.r = r;
    }

    public double calculateArea() {
        return Math.PI * Math.pow(r, 2);
    }
}
