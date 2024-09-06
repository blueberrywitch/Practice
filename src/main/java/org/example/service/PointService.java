package org.example.service;

import org.example.model.Point;
import org.example.util.Scan;

public class PointService implements GeneralPoint {

    public Point readPoint() {
        return new Point(Scan.scanDouble(), Scan.scanDouble());
    }

    public void printCoordinates(Point point) {
        System.out.println(point);
    }
}
