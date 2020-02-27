// Add Random and Scanner and ArrayList classes

import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * The Shooting class have an array from shots
 * And can create a shot
 * *
 *
 * @author Erfan
 * @version 1
 * @since 3/29/2018
 */
public class Shooting {

    // Fields //

    // An object from Scanner class for getting inputs
    private Scanner scanner = new Scanner(System.in);

    // An array list of point with shots name
    private ArrayList<Point> shots;

    // Constructor //

    /**
     * Create a shooting object
     */
    public Shooting() {
        shots = new ArrayList<Point>();
    }

    // Methods //

    /**
     * Get the shots array
     *
     * @return The shots array
     */
    public ArrayList<Point> getShots() {
        return shots;
    }

    /**
     * Add a shot to the shots array
     *
     * @param shot The added shot
     */
    public void addShot(Point shot) {
        shots.add(shot);
    }

    /**
     * Create a normal shot
     */
    public void createNormalShot() {
        Point point = new Point();
        addShot(point);
        while (true) {
            while (!setNormalShotX()) ;
            while (!setNormalShotY()) ;
            if (checkNewShot()) {
                break;
            } else {
                System.out.println("This point is choose later .");
                System.out.println("Enter another point : ");
            }
        }
    }

    /**
     * Create a compuer shot
     *
     * @param smart   Help the computer to be smart
     * @param counter Help the computer to be smart
     * @return True if there is nothing to do smart
     */
    /*public boolean createNormalShotCom(int smart, int counter) {
        Point point = new Point();

        addShot(point);
        if (shots.size() == 0 || shots.size()==1){
            shots.add(new Point());
            while (true) {
                shots.get(shots.size() - 1).setxCoordinates(findRandNum2() + 1);
                shots.get(shots.size() - 1).setyCoordinates(findRandNum2() + 1);
                if (checkNewShot()) {
                    break;
                }
            }
        }

        if (shots.size() >= 2) {
            if ((shots.get(shots.size() - 2).getxCoordinates() == 1)
                    || (shots.get(shots.size() - 2).getyCoordinates() == 1)
                    || (shots.get(shots.size() - 2).getxCoordinates() == 10)
                    || (shots.get(shots.size() - 2).getyCoordinates() == 10)
                    || (smart == 0)) {
                while (true) {
                    shots.get(shots.size() - 1).setxCoordinates(findRandNum2() + 1);
                    shots.get(shots.size() - 1).setyCoordinates(findRandNum2() + 1);
                    if (checkNewShot()) {
                        break;
                    }
                }
                return true;
            } else {
                while (true) {
                    if (counter == 0) {
                        shots.get(shots.size() - 1).setxCoordinates(shots.get(shots.size() - 2).getxCoordinates() + 1);
                        shots.get(shots.size() - 1).setyCoordinates(shots.get(shots.size() - 2).getyCoordinates());
                    }
                    if (counter == 1) {
                        shots.get(shots.size() - 1).setxCoordinates(shots.get(shots.size() - 2).getxCoordinates());
                        shots.get(shots.size() - 1).setyCoordinates(shots.get(shots.size() - 2).getyCoordinates() - 1);
                    }
                    if (counter == 2) {
                        shots.get(shots.size() - 1).setxCoordinates(shots.get(shots.size() - 2).getxCoordinates() - 1);
                        shots.get(shots.size() - 1).setyCoordinates(shots.get(shots.size() - 2).getyCoordinates());
                    }
                    if (counter == 3) {
                        shots.get(shots.size() - 1).setxCoordinates(shots.get(shots.size() - 2).getxCoordinates());
                        shots.get(shots.size() - 1).setyCoordinates(shots.get(shots.size() - 2).getyCoordinates() + 1);
                    }
                    if (checkNewShot()) {
                        return false;
                    } else {
                        counter++;
                    }
                }
            }
        }
        return true;
    }*/

    public int createNormalShotCom(int smart, int counter) {
        Point point = new Point();

        addShot(point);
        if (shots.size() == 0 || shots.size()==1){
            shots.add(new Point());
            while (true) {
                shots.get(shots.size() - 1).setxCoordinates(findRandNum2() + 1);
                shots.get(shots.size() - 1).setyCoordinates(findRandNum2() + 1);
                if (checkNewShot()) {
                    break;
                }
            }
        }

        if (shots.size() >= 2) {
            if ((shots.get(shots.size() - 2).getxCoordinates() == 1)
                    || (shots.get(shots.size() - 2).getyCoordinates() == 1)
                    || (shots.get(shots.size() - 2).getxCoordinates() == 10)
                    || (shots.get(shots.size() - 2).getyCoordinates() == 10)
                    || (smart == 0)) {
                while (true) {
                    shots.add(new Point());
                    shots.get(shots.size() - 1).setxCoordinates(findRandNum2() + 1);
                    shots.get(shots.size() - 1).setyCoordinates(findRandNum2() + 1);
                    if (checkNewShot()) {
                        break;
                    } else {
                        shots.remove(shots.size()-1);
                    }
                }

            } else {
                while (true) {
                    shots.add(new Point());
                    if (counter == 0) {
                        shots.get(shots.size() - 1).setxCoordinates(shots.get(shots.size() - 2).getxCoordinates() + 1);
                        shots.get(shots.size() - 1).setyCoordinates(shots.get(shots.size() - 2).getyCoordinates());
                    }
                    if (counter == 1) {
                        shots.get(shots.size() - 1).setxCoordinates(shots.get(shots.size() - 2).getxCoordinates());
                        shots.get(shots.size() - 1).setyCoordinates(shots.get(shots.size() - 2).getyCoordinates() - 1);
                    }
                    if (counter == 2) {
                        shots.get(shots.size() - 1).setxCoordinates(shots.get(shots.size() - 2).getxCoordinates() - 1);
                        shots.get(shots.size() - 1).setyCoordinates(shots.get(shots.size() - 2).getyCoordinates());
                    }
                    if (counter == 3) {
                        shots.get(shots.size() - 1).setxCoordinates(shots.get(shots.size() - 2).getxCoordinates());
                        shots.get(shots.size() - 1).setyCoordinates(shots.get(shots.size() - 2).getyCoordinates() + 1);
                    }
                    if (checkNewShot()) {
                        //return false;
                        return counter;
                    } else {
                        counter++;
                        shots.remove(shots.size()-1);
                        if ( counter ==4){
                            return counter;
                        }
                    }
                }
            }
        }
        return counter;
    }

    /**
     * Create mistaken shot
     */
    public void createMistakenShot() {
        Point point = new Point();
        addShot(point);
        while (!setNormalShotX()) ;
        while (!setNormalShotY()) ;
        while (true) {
            while (!changeCoordinatesToRandom(findRandNum1())) ;
            if (checkNewShot()) {
                break;
            }
        }
    }

    /**
     * This method get a random number from 0 to 8
     *
     * @return A random number between 0 to 8
     */
    public int findRandNum1() {
        Random random = new Random();
        return Math.abs(random.nextInt() % 9);
    }

    /**
     * This method get a random number from 0 to 9
     *
     * @return A random number between 0 to 9
     */
    public int findRandNum2() {
        Random random = new Random();
        return Math.abs(random.nextInt() % 10);
    }

    /**
     * change Coordinates To Random numbers
     *
     * @param rand a rand number between 0 to 8
     * @return True if point is in the table
     */
    public boolean changeCoordinatesToRandom(int rand) {
        if (rand == 0) {
            shots.get(shots.size() - 1).setxCoordinates(shots.get(shots.size() - 1).getxCoordinates() - 1);
            shots.get(shots.size() - 1).setyCoordinates(shots.get(shots.size() - 1).getyCoordinates() - 1);
        }
        if (rand == 1) {
            shots.get(shots.size() - 1).setxCoordinates(shots.get(shots.size() - 1).getxCoordinates());
            shots.get(shots.size() - 1).setyCoordinates(shots.get(shots.size() - 1).getyCoordinates() - 1);
        }
        if (rand == 2) {
            shots.get(shots.size() - 1).setxCoordinates(shots.get(shots.size() - 1).getxCoordinates() + 1);
            shots.get(shots.size() - 1).setyCoordinates(shots.get(shots.size() - 1).getyCoordinates() - 1);
        }
        if (rand == 3) {
            shots.get(shots.size() - 1).setxCoordinates(shots.get(shots.size() - 1).getxCoordinates() - 1);
            shots.get(shots.size() - 1).setyCoordinates(shots.get(shots.size() - 1).getyCoordinates());
        }
        if (rand == 4) {
            shots.get(shots.size() - 1).setxCoordinates(shots.get(shots.size() - 1).getxCoordinates());
            shots.get(shots.size() - 1).setyCoordinates(shots.get(shots.size() - 1).getyCoordinates());
        }
        if (rand == 5) {
            shots.get(shots.size() - 1).setxCoordinates(shots.get(shots.size() - 1).getxCoordinates() + 1);
            shots.get(shots.size() - 1).setyCoordinates(shots.get(shots.size() - 1).getyCoordinates());
        }
        if (rand == 6) {
            shots.get(shots.size() - 1).setxCoordinates(shots.get(shots.size() - 1).getxCoordinates() - 1);
            shots.get(shots.size() - 1).setyCoordinates(shots.get(shots.size() - 1).getyCoordinates() + 1);
        }
        if (rand == 7) {
            shots.get(shots.size() - 1).setxCoordinates(shots.get(shots.size() - 1).getxCoordinates());
            shots.get(shots.size() - 1).setyCoordinates(shots.get(shots.size() - 1).getyCoordinates() + 1);
        }
        if (rand == 8) {
            shots.get(shots.size() - 1).setxCoordinates(shots.get(shots.size() - 1).getxCoordinates() + 1);
            shots.get(shots.size() - 1).setyCoordinates(shots.get(shots.size() - 1).getyCoordinates() + 1);
        }

        if (shots.get(shots.size() - 1).getxCoordinates() < 1 || shots.get(shots.size() - 1).getxCoordinates() > 10
                || shots.get(shots.size() - 1).getyCoordinates() < 1 || shots.get(shots.size() - 1).getyCoordinates() > 10) {
            return false;
        } else
            return true;

    }

    /**
     * Set the normal shot x Coordinates
     *
     * @return true if the input is valid
     */
    public boolean setNormalShotX() {
        String string = scanner.nextLine();
        if (string.length() == 1 && Character.isDigit(string.charAt(0))) {
            shots.get(shots.size() - 1).setxCoordinates(Character.getNumericValue(string.charAt(0)) + 1);
        } else {
            System.out.println("Invalid input . ");
            return false;
        }

        if (!(shots.get(shots.size() - 1).getxCoordinates() >= 1 && shots.get(shots.size() - 1).getxCoordinates() <= 10)) {
            System.out.println("Wrong input .");
            return false;
        } else
            return true;
    }

    /**
     * Set the normal shot y Coordinates
     *
     * @return true if the input is valid
     */
    public boolean setNormalShotY() {
        String string = scanner.nextLine();
        if (string.length() == 1 && Character.isDigit(string.charAt(0))) {
            shots.get(shots.size() - 1).setyCoordinates(Character.getNumericValue(string.charAt(0)) + 1);
        } else {
            System.out.println("Invalid input .");
            return false;
        }

        if (!(shots.get(shots.size() - 1).getyCoordinates() >= 1 && shots.get(shots.size() - 1).getyCoordinates() <= 10)) {
            System.out.println("Wrong input .");
            return false;
        } else
            return true;
    }

    /**
     * Check the new shot is not repeated
     *
     * @return True if not repeated
     */
    public boolean checkNewShot() {
        for (int i = 0; i < shots.size() - 1; i++) {
            if (shots.get(shots.size() - 1).getxCoordinates() == shots.get(i).getxCoordinates()
                    && shots.get(shots.size() - 1).getyCoordinates() == shots.get(i).getyCoordinates()) {
                return false;
            }
        }
        return true;
    }

    /**
     * The shot is on the table or not
     *
     * @param ships The ships array
     * @param size  the nubmer of ships
     * @return true if not any problem
     */
    public boolean isOnShip(Ship[] ships, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < ships[i].getSize(); j++) {
                if (shots.get(shots.size() - 1).getxCoordinates() == ships[i].getPoints().get(j).getxCoordinates()
                        && shots.get(shots.size() - 1).getyCoordinates() == ships[i].getPoints().get(j).getyCoordinates()) {
                    return true;
                }
            }
        }
        return false;
    }

    public void printShot() {
        if (shots.size() > 1){
            System.out.println(shots.get(shots.size()-1).getxCoordinates() + "-" + shots.get(shots.size() - 1).getyCoordinates());
        }
    }
}
