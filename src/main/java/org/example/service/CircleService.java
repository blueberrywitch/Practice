package org.example.service;

import org.example.model.Circle;
import org.example.model.Point;
import org.example.util.Scan;

public class CircleService implements GeneralCircle {

    public Circle readCircle() {
        return new Circle(new Point(Scan.scanDouble(), Scan.scanDouble()), Scan.scanDouble());
    }

    public void printCircle(Circle circle) {
        System.out.println(circle);
    }

    public double circumference(Circle circle) {
        return 2 * Math.PI * circle.getRadius();
    }

    public double areaCircle(Circle circle) {
        return 2 * Math.PI * Math.pow(circle.getRadius(), 2);
    }

    public boolean containsCircle(Circle circle, Point point) {
        return (Math.hypot(point.getX(), point.getY()) <= Math.pow(circle.getRadius(), 2));
    }

    public boolean circuitCircle(Circle circle, Point point) {
        return (Math.abs(Math.hypot(point.getX(), point.getY()) - Math.pow(circle.getRadius(), 2)) <= 1e-5);
    }

    public boolean intersectCircle(Circle circle1, Circle circle2) {
        return ((Math.abs(circle1.getCenter().getX() - circle2.getCenter().getX())) <=
                Math.abs(circle1.getRadius()) + Math.abs(circle2.getRadius())) &&
                ((Math.abs(circle1.getCenter().getY() - circle2.getCenter().getY())) <=
                        Math.abs(circle1.getRadius()) + Math.abs(circle2.getRadius()));
    }

    public boolean circleBelongsToCircle(Circle circle1, Circle circle2) {
        return (Math.hypot(circle1.getCenter().getX() + circle1.getRadius(), circle1.getCenter().getY())
                <= Math.pow(circle2.getRadius(), 2)) &&
                (Math.hypot(circle1.getCenter().getX(), circle1.getCenter().getY() + circle1.getRadius())
                        <= Math.pow(circle2.getRadius(), 2)) &&
                (Math.hypot(circle1.getCenter().getX() - circle1.getRadius(), circle1.getCenter().getY())
                        <= Math.pow(circle2.getRadius(), 2)) &&
                (Math.hypot(circle1.getCenter().getX(), circle1.getCenter().getY() - circle1.getRadius())
                        <= Math.pow(circle2.getRadius(), 2));
    }
}
