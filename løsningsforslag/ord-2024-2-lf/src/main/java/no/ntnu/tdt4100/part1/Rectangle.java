package no.ntnu.tdt4100.part1;

public class Rectangle extends Shape {
    private double l;
    private double w;
    public Rectangle(double l, double w) {
        this.l = l;
        this.w = w;
    }

    public double calculateArea() {
        return l * w;
    }
}
