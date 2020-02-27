// Add Scanner class
import java.util.Scanner;
/**
 * The Main class have the main method
 * And can create objects and continue the program .
 * *
 * @author Erfan
 * @version 1
 * @since 3/29/2018
 */
public class Main {

    // Fields //

    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";

    // Methods //

    public static void main(String[] args) {
        boolean prize;
        String string;
        int comortwo = 0;
        int misOrnor1 = 0;
        int misOrnor2 = 0;

        System.out.println("[1]play with computer ");
        System.out.println("[2]play with another player ");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            string = scanner.nextLine();
            if (string.length() == 1 && (string.charAt(0) == '1' || string.charAt(0) == '2')) {
                comortwo = Character.getNumericValue(string.charAt(0));
                break;
            } else {
                System.out.println("enter 1 or 2 ");
            }
        }

        if (comortwo == 1) {
            Player player1 = new Player();
            Player player2 = new Player();
            player1.makeTwoTableSymbols();
            player2.makeTwoTableSymbols();

            player1.createPlayerTable();
            player1.getTable1().printShips();

            player2.createPlayerTableCom();
            player2.getTable1().printShips();

            player1.setOpponetnsShipsSize(player2.getShipsSize());
            player2.setOpponetnsShipsSize(player1.getShipsSize());
            System.out.println("[1]play with normal shot ");
            System.out.println("[2]play with mistaken shot ");
            while (true) {
                string = scanner.nextLine();
                if (string.length() == 1 && (string.charAt(0) == '1' || string.charAt(0) == '2')) {
                    misOrnor1 = Character.getNumericValue(string.charAt(0));
                    break;
                } else {
                    System.out.println("invalid");
                }
            }
            if (misOrnor1 == 1) {
                while (true) {
                    player1.createPlayerShotsNor(player2);
                    player1.addTwoTable(player2.getTable2(), player1.getTable1(), player1.getTable2());
                    player1.drawTable2d();

                    player2.createPlayerShotsCom(player1);
                }
            }
            if (misOrnor1 == 2) {
                while (true) {
                    player1.createPlayerShotsMis(player2);
                    player1.addTwoTable(player2.getTable2(), player1.getTable1(), player1.getTable2());
                    player1.drawTable2d();

                    player2.createPlayerShotsCom(player1);
                }
            }
        }
        if (comortwo == 2) {
            Player player1 = new Player();
            Player player2 = new Player();
            player1.makeTwoTableSymbols();
            player2.makeTwoTableSymbols();
            player1.createPlayerTable();
            player2.createPlayerTable();
            player1.setOpponetnsShipsSize(player2.getShipsSize());
            player2.setOpponetnsShipsSize(player1.getShipsSize());

            System.out.println("[1]play with normal shot ");
            System.out.println("[2]play with mistaken shot ");
            while (true) {
                string = scanner.nextLine();
                if (string.length() == 1 && (string.charAt(0) == '1' || string.charAt(0) == '2')) {
                    misOrnor1 = Character.getNumericValue(string.charAt(0));
                    break;
                } else {
                    System.out.println("Wrong input .");
                }
            }

            System.out.println("[1]play with normal shot ");
            System.out.println("[2]play with mistaken shot ");
            while (true) {
                string = scanner.nextLine();
                if (string.length() == 1 && (string.charAt(0) == '1' || string.charAt(0) == '2')) {
                    misOrnor2 = Character.getNumericValue(string.charAt(0));
                    break;
                } else {
                    System.out.println("Wrong input ");
                }
            }

            if (misOrnor1 == 1 && misOrnor2 == 1) {
                while (true) {
                    createGame1(player1, player2);
                    createGame1(player2, player1);
                }
            }
            if (misOrnor1 == 2 && misOrnor2 == 2) {

                while (true) {
                    createGame2(player1, player2);
                    createGame2(player2, player1);
                }
            }
            if (misOrnor1 == 1 && misOrnor2 == 2) {
                while (true) {
                    createGame1(player1, player2);
                    createGame2(player2, player1);
                }

            }
            if (misOrnor1 == 2 && misOrnor2 == 1) {
                while (true) {
                    createGame2(player1, player2);
                    createGame1(player2, player1);
                }

            }
        }
    }

    private static void createGame2(Player player1, Player player2) {
        boolean prize;
        while (true) {
            prize = player1.createPlayerShotsMis(player2);
            player1.addTwoTable(player2.getTable2(), player1.getTable1(), player1.getTable2());
            player1.drawTable2d();
            for (int i = 0; i < 40; i++) {
                System.out.println();
            }
            if (!prize) {
                break;
            }
            System.out.println("Correct .");
            System.out.println("Enter the prize shot : ");
        }
    }

    private static void createGame1(Player player1, Player player2) {
        boolean prize;
        while (true) {
            prize = player1.createPlayerShotsNor(player2);
            player1.addTwoTable(player2.getTable2(), player1.getTable1(), player1.getTable2());
            player1.drawTable2d();
            for (int i = 0; i < 40; i++) {
                System.out.println();
            }
            if (!prize) {
                break;
            }
            System.out.println("Correct .");
            System.out.println("Enter the prize shot : ");
        }
    }

}
