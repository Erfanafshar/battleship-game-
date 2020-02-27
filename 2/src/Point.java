/**
 * The Point class have Coordinates of a point
 * And can set and get them
 * *
 * @author Erfan
 * @version 1
 * @since 3/29/2018
 */
public class Point {

    // Fields //

    // The x Coordinates of point
    private int xCoordinates;

    // The y Coordinates of point
    private int yCoordinates;

    // Constructors //

    /**
     * Create Point object with given x Coordinates and y Coordinates
     * @param xCoordinates  The x Coordinates of point
     * @param yCoordinates  The y Coordinates of point
     */
    public Point(int xCoordinates, int yCoordinates) {
        this.xCoordinates = xCoordinates;
        this.yCoordinates = yCoordinates;
    }

    /**
     * Create a point object
     */
    public Point() {

    }

    // Methods //

    /**
     * Get the x Coordinates of point
     * @return x Coordinates of point
     */
    public int getxCoordinates() {
        return xCoordinates;
    }

    /**
     * Set the x Coordinates of point
     * @param xCoordinates The x Coordinates of point
     */
    public void setxCoordinates(int xCoordinates) {
        this.xCoordinates = xCoordinates;
    }

    /**
     * Get the y Coordinates of point
     * @return The y Coordinates of point
     */
    public int getyCoordinates() {
        return yCoordinates;
    }

    /**
     * Set the y Coordinates of point
     * @param yCoordinates The y Coordinates of point
     */
    public void setyCoordinates(int yCoordinates) {
        this.yCoordinates = yCoordinates;
    }

    /**
     * print the points x and y coordinates
     */
    public void printPoint() {
        System.out.println(xCoordinates + "-" + yCoordinates);
    }


}
