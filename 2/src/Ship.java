// Add Random and Scanner and ArrayList classes
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * The Ship class have x and y oordinates of the first point
 * And the size of the ship
 * And can get and create ships
 * *
 * @author Erfan
 * @version 1
 * @since 3/29/2018
 */
public class Ship {

    // Fields //

    // An object from Point class
    private Point firstPoint = new Point();

    // The size of the ship
    private int size;

    // The direction of the ship
    private String direction;

    // An array list from points for each ship
    private ArrayList<Point> points = new ArrayList<Point>();

    // An object from Scanner class for getting inputs
    private Scanner scanner1 = new Scanner(System.in);

    // An object from Scanner class for getting inputs
    private Scanner scanner2 = new Scanner(System.in);

    // Methods //

    /**
     * This method create a ship with checking the inputs
     * @return true if the ship is in the table
     */
    public boolean createShip() {
        while (!setFirstPointX()) ;
        while (!setFirstPointY()) ;
        while (!setSize()) ;
        while (!setDirection()) ;
        if (!setPoints()) {
            System.out.println("This ship is out of the table .");
            System.out.println("Enter another ship : ");
            return false;
        } else
            return true;
    }

    /**
     * This method create a ship with with random numbers from computer
     * @return true if the ship is in the table
     */
    public boolean createShipCom() {
        firstPoint.setxCoordinates(findRandNum1() + 1);
        firstPoint.setyCoordinates(findRandNum1() + 1);
        size = findRandNum2() + 2;
        direction = setDirectionCom();
        if (!setPoints()) {
            return false;
        } else
            return true;
    }

    /**
     * This method get a random number from 0 to 9
     * @return A random number between 0 to 9
     */
    public int findRandNum1() {
        Random random = new Random();
        return Math.abs(random.nextInt() % 10);
    }

    /**
     * This method get a random number from 0 to 3
     * @return A random number between 0 to 3
     */
    public int findRandNum2() {
        Random random = new Random();
        return Math.abs(random.nextInt() % 4);
    }

    /**
     * Set the directions of the ship with use random number
     * @return The direction of the ship
     */
    public String setDirectionCom() {
        int rand = 0;
        rand = findRandNum2();
        if (rand == 0) {
            return "U";
        }
        if (rand == 1) {
            return "D";
        }
        if (rand == 2) {
            return "R";
        }
        if (rand == 3) {
            return "L";
        }
        return "R";
    }

    /**
     * Get the size of the ship
     * @return The size of the ship
     */
    public int getSize() {
        return size;
    }

    /**
     * Set the first point x Coordinates
     * @return The first point x Coordinates
     */
    public boolean setFirstPointX() {
        System.out.println("Enter the first point x Coordinate : ");
        String string = scanner1.nextLine();
        if (string.length() == 1 && Character.isDigit(string.charAt(0))) {
            firstPoint.setxCoordinates(Character.getNumericValue(string.charAt(0)) + 1);
        } else {
            System.out.println("Invalid input . ");
            return false;
        }
        if (!(getFirstPoint().getxCoordinates() >= 1 && getFirstPoint().getxCoordinates() <= 10)) {
            System.out.println("Wrong input .");
            return false;
        } else
            return true;
    }

    /**
     * Set the first point y Coordinates
     * @return The first point x Coordinates
     */
    public boolean setFirstPointY() {
        System.out.println("Enter the first point y Coordinate : ");
        String string = scanner1.nextLine();
        if (string.length() == 1 && Character.isDigit(string.charAt(0))) {
            firstPoint.setyCoordinates(Character.getNumericValue(string.charAt(0)) + 1);
        } else {
            System.out.println("Invalid input . ");
            return false;
        }
        if (!(getFirstPoint().getyCoordinates() >= 1 && getFirstPoint().getyCoordinates() <= 10)) {
            System.out.println("Wrong input .");
            return false;
        } else
            return true;
    }

    /**
     * Set the size of the ship
     * @return true if the size is a number between 2 and 5
     */
    public boolean setSize() {
        System.out.println("Enter the size of ship : ");
        String string = scanner1.nextLine();
        if (string.length() == 1 && Character.isDigit(string.charAt(0))) {
            size = Character.getNumericValue(string.charAt(0));
        } else {
            System.out.println("Invalid input .");
            return false;
        }
        if (!(getSize() >= 2 && getSize() <= 5)) {
            System.out.println("Wrong input .");
            return false;
        } else
            return true;
    }

    /**
     * Set the directions of the ship
     * @return true if the direction is valid
     */
    public boolean setDirection() {
        System.out.println("Enter the direction : ");
        direction = scanner2.nextLine();
        if (!(getDirection().equals("U") || getDirection().equals("D") || getDirection().equals("R") || getDirection().equals("L"))) {
            System.out.println("Wrong input .");
            return false;
        } else
            return true;
    }

    /**
     * Add point to the points array
     * @param point Added point
     */
    public void addPoint(Point point) {
        points.add(point);
    }

    /**
     * Set other points of the ship with use the first point Coordinates and size and direction
     * @return true if all points are in table
     */
    public boolean setPoints() {
        if (direction.equals("U")) {
            for (int i = firstPoint.getyCoordinates() - 1; i >= firstPoint.getyCoordinates() - size; i--) {
                addPoint(new Point(firstPoint.getxCoordinates(), i));
            }
        }
        if (direction.equals("D")) {
            for (int i = firstPoint.getyCoordinates(); i < firstPoint.getyCoordinates() + size; i++) {
                addPoint(new Point(firstPoint.getxCoordinates(), i));
            }
        }
        if (direction.equals("R")) {
            for (int i = firstPoint.getxCoordinates(); i < firstPoint.getxCoordinates() + size; i++) {
                addPoint(new Point(i, firstPoint.getyCoordinates()));
            }
        }
        if (direction.equals("L")) {
            for (int i = firstPoint.getxCoordinates() - 1; i >= firstPoint.getxCoordinates() - size; i--) {
                addPoint(new Point(i, firstPoint.getyCoordinates()));
            }
        }
        for (int i = 0; i < points.size(); i++) {
            if (!(points.get(i).getxCoordinates() >= 1 && points.get(i).getxCoordinates() <= 10
                    && points.get(i).getyCoordinates() >= 1 && points.get(i).getyCoordinates() <= 10)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Get points array list
     * @return Array list of points
     */
    public ArrayList<Point> getPoints() {
        return points;
    }

    /**
     * Get the first point of ship
     * @return The first point of ship
     */
    public Point getFirstPoint() {
        return firstPoint;
    }

    /**
     * Get the direction of ship
     * @return The direction of ship
     */
    public String getDirection() {
        return direction;
    }

    /**
     * Print all ships points
     */
    public void printShip() {
        for (int i = 0; i < points.size(); i++) {
            points.get(i).printPoint();
        }
    }

}
