import java.awt.Point;

public interface KDTree {
    public Point VecinoMasCercano( KDTree T, Point q );
    public Point VecinoMasCercano( Point q );
}
