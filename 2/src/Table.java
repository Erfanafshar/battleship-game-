// Add ArrayList class
import java.util.ArrayList;

/**
 * The Table class have a table for that contains ships
 * And an array from ships
 * *
 * @author Erfan
 * @version 1
 * @since 3/29/2018
 */
public class Table {

    // Fields //

    // This field reset the colors
    public static final String ANSI_RESET = "\u001B[0m";

    // This field can print blue color
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";

    // The sum of the ships size
    private int allShipsSize;

    // A 2d array that contain some chars
    private char[][] table;

    // An array that contain some ships
    private Ship[] ships;

    // Constructor //

    /**
     * Create a table object
     */
    public Table() {
        ships = new Ship[5];
        table = new char[22][43];
    }

    // Methods //

    /**
     * Check the ships have equal point
     * @param size The number of the ships
     * @param points The point of the ship
     * @param computerOrPlayer The twice player is computer or player
     * @return True if the Ship is valid
     */
    public boolean checkShips(int size, ArrayList<Point> points, int computerOrPlayer) {
        for (int i = 0; i < points.size(); i++) {
            for (int j = 0; j < size - 1; j++) {
                for (int k = 0; k < ships[j].getSize(); k++) {
                    if (points.get(i).getxCoordinates() == ships[j].getPoints().get(k).getxCoordinates()
                            && points.get(i).getyCoordinates() == ships[j].getPoints().get(k).getyCoordinates()) {
                        if (computerOrPlayer == 1) {
                            System.out.println("There is another ship at there .");
                            System.out.println("Enter new ship : ");
                        }
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * Get the ships array
     * @return The ships array
     */
    public Ship[] getShips() {
        return ships;
    }

    /**
     * Set a ship is ships array
     * @param ship The ship
     * @param i The index of the ship
     */
    public void setShips(Ship ship, int i) {
        ships[i] = ship;
    }

    /**
     * Set a ship is ships array
     * @param ship  The ship
     */
    public void setShips(Ship[] ship) {
        ships = ship;
    }

    /**
     * Calculate the sum of the size of the ships
     */
    public void setAllShipsSize() {
        for (int i = 0; i < 5; i++) {
            allShipsSize += ships[i].getSize();
        }
    }

    /**
     * Get size of all ships
     * @return Size of all ships
     */
    public int getAllShipsSize() {
        return allShipsSize;
    }

    /**
     * Print ships are in array
     */
    public void printShips() {
        for (int i = 0; i < 5; i++) {
            ships[i].printShip();
        }
    }

    /**
     * Draw the table
     */
    public void drawTable() {
        for (int i = 0; i < 22; i++) {
            for (int j = 0; j < 43; j++) {
                if (table[i][j] == '@') {
                    System.out.print(ANSI_BLUE_BACKGROUND + " " + ANSI_RESET);
                } else {
                    System.out.print(table[i][j]);
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Make the table symbols
     */
    public void makeTableSymbols() {
        for (int i = 0; i < 22; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < 43; j++) {
                    if (!(j % 4 == 2)) {
                        table[i][j] = ' ';
                    } else {
                        table[i][j] = '|';
                    }
                }
            }
            if (i % 2 == 1) {
                table[i][0] = '-';
                table[i][1] = '-';
                table[i][2] = '|';
                for (int j = 3; j < 43; j++) {
                    if (!(j % 4 == 2)) {
                        table[i][j] = '-';
                    } else {
                        table[i][j] = '+';
                    }
                }
            }
        }
    }

    /**
     * Make the table numbers
     */
    public void makeTableNumbers() {
        for (int i = 4; i < 43; i = i + 4) {
            table[0][i] = Character.forDigit(i / 4 - 1, 10);
        }
        for (int i = 2; i < 22; i = i + 2) {
            table[i][0] = Character.forDigit(i / 2 - 1, 10);
        }
    }

    /**
     * Make all of the table
     */
    public void makeAllTable() {
        makeTableSymbols();
        makeTableNumbers();
    }

    /**
     * Print the ship points in table
     * @param x x Coordinates
     * @param y y Coordinates
     */
    public void printShipPoint(int x, int y) {
        int xCoordinates;
        int yCoordinates;
        xCoordinates = 4 * x;
        yCoordinates = 2 * y;
        table[yCoordinates][xCoordinates] = '@';
    }

    /**
     * Print the the ships in the table
     */
    public void printShipInTable() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < ships[i].getSize(); j++) {
                printShipPoint(ships[i].getPoints().get(j).getxCoordinates(), ships[i].getPoints().get(j).getyCoordinates());
            }
        }
    }

    /**
     * Print shots in the table
     * @param bool The shot is correct or not
     * @param point The point for printing
     * @return True if the shot is correct
     */
    public boolean printShots(boolean bool, Point point) {
        int a;
        int b;
        a = point.getxCoordinates() * 4;
        b = point.getyCoordinates() * 2;
        if (bool) {
            table[b][a] = '&';
            return true;
        } else {
            table[b][a] = 'X';
            return false;
        }
    }

    /**
     * Get the table
     * @return The table
     */
    public char[][] getTable() {
        return table;
    }

}


