/**
 * The Player class have the information of each player
 * Like table and shooting and ships
 * *
 * @author Erfan
 * @version 1
 * @since 3/29/2018
 */
public class Player {

    // Fields //

    // Fiels for creating colors
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";


    private int opponetnsShipsSize;
    private Table table1 = new Table();
    private Table table2 = new Table();
    private Shooting shooting1 = new Shooting();
    private int shipsSize;
    private char table2d[][];
    private boolean prize;
    private int k = 0;
    private int j = 0;

    // Constructor //

    public Player() {
        table2d = new char[22][95];
    }

    // Methods //

    public int getShipsSize() {
        return shipsSize;
    }

    public void setOpponetnsShipsSize(int opponetnsShipsSize) {
        this.opponetnsShipsSize = opponetnsShipsSize;
    }

    public Table getTable1() {
        return table1;
    }

    public Table getTable2() {
        return table2;
    }

    public boolean createNormalShot(Shooting shooting, Table table) {
        shooting.createNormalShot();
        if (table.printShots(shooting.isOnShip(table.getShips(), 5), shooting.getShots().get(shooting.getShots().size() - 1))) {
            opponetnsShipsSize--;
            prize = true;
        } else {
            prize = false;
        }
        if (opponetnsShipsSize == 0) {
            return true;
        } else
            return false;
    }

    public boolean createNormalShotCom(Shooting shooting, Table table) {
        shooting.printShot();
        //j=0;
        //k=0;
        /*if(shooting.createNormalShotCom(k , j )){
            k = 0;
            j = 0;
        }*/
        j = shooting.createNormalShotCom(k , j);
        if (table.printShots(shooting.isOnShip(table.getShips(), 5), shooting.getShots().get(shooting.getShots().size() - 1))) {
            //k++;
            opponetnsShipsSize--;
            prize = true;
        } else {

            if ( k == 1){
                if(j==4){
                    j=0;
                    k=0;
                    return false;
                }
                j++;
            }
            if ( k >=2 ){
                k = 0;
                j = 0;
            }
            prize = false;
        }
        System.out.println("ships : " + opponetnsShipsSize);
        if (opponetnsShipsSize == 0) {
            return true;
        } else
            return false;
    }

    public boolean createMistakenShot(Shooting shooting, Table table) {
        shooting.createMistakenShot();
        if (table.printShots(shooting.isOnShip(table.getShips(), 5), shooting.getShots().get(shooting.getShots().size() - 1))) {
            opponetnsShipsSize--;
            prize = true;
        } else {
            prize = false;
        }
        if (opponetnsShipsSize == 0) {
            return true;
        } else
            return false;
    }

    public void createShip(Table table, int size) {
        while (true) {
            Ship ship1 = new Ship();
            if (ship1.createShip()) {
                if (table.checkShips(size, ship1.getPoints(), 1)) {
                    table.setShips(ship1, size - 1);
                    shipsSize += ship1.getSize();
                    return;
                }
            }
        }
    }

    public void createShipCom(Table table, int size) {
        while (true) {
            Ship ship1 = new Ship();
            if (ship1.createShipCom()) {
                if (table.checkShips(size, ship1.getPoints(), 2)) {
                    table.setShips(ship1, size - 1);
                    shipsSize += ship1.getSize();
                    return;
                }
            }
        }
    }

    public void checkFinishNormal(Shooting shooting, Table table) {
        if (createNormalShot(shooting, table)) {
            System.out.println("YOU WIN !!!!! ");
            System.exit(1);
            //return;
        }
    }

    public void checkFinishCom(Shooting shooting, Table table) {
        if (createNormalShotCom(shooting, table)) {
            System.out.println("COM WIN !!!!! ");
            System.exit(1);
        }
    }

    public void checkFinishMistaken(Shooting shooting, Table table) {
        if (createMistakenShot(shooting, table)) {
            System.out.println("YOU WIN :/ . ");
            System.exit(1);
        }
    }

    public void createPlayerTable() {
        System.out.println("place your ships . ");
        table1.makeAllTable();
        table2.makeAllTable();
        for (int i = 1; i < 6; i++) {
            createShip(table1, i);
        }
        table2.setShips(table1.getShips());
        table1.setAllShipsSize();
        shipsSize = table1.getAllShipsSize();
        table1.printShipInTable();
        System.out.println("your ships . ");
        table1.drawTable();
    }

    public void createPlayerTableCom() {
        table1.makeAllTable();
        table2.makeAllTable();
        for (int i = 1; i < 6; i++) {
            createShipCom(table1, i);
        }
        table2.setShips(table1.getShips());
        table1.setAllShipsSize();
        shipsSize = table1.getAllShipsSize();
        table1.printShipInTable();
    }

    public boolean createPlayerShotsNor(Player player) {
        System.out.println("enter your point . ");
        checkFinishNormal(shooting1, player.getTable2());
        return prize;
    }

    public void createPlayerShotsCom(Player player) {
        checkFinishCom(shooting1, player.getTable2());
    }

    public boolean createPlayerShotsMis(Player player) {
        System.out.println("enter your point . ");
        checkFinishMistaken(shooting1, player.getTable2());
        return prize;
    }

    public void makeTwoTableSymbols() {
        for (int i = 0; i < 22; i++) {
            for (int j = 0; j < 95; j++) {
                table2d[i][j] = ' ';
            }
        }
    }

    public void drawTable2d() {
        for (int i = 0; i < 22; i++) {
            for (int j = 0; j < 95; j++) {
                if (table2d[i][j] == '@') {
                    System.out.print(ANSI_BLUE_BACKGROUND + " " + ANSI_RESET);
                } else {
                    if (table2d[i][j] == '#') {
                        System.out.print(ANSI_RED_BACKGROUND + " " + ANSI_RESET);
                    } else {
                        if (table2d[i][j] == '&') {
                            System.out.print(ANSI_GREEN_BACKGROUND + " " + ANSI_RESET);
                        } else {
                            if (table2d[i][j] == 'X') {
                                System.out.print(ANSI_YELLOW_BACKGROUND + " " + ANSI_RESET);
                            } else {
                                System.out.print(table2d[i][j]);
                            }
                        }
                    }
                }
            }
            System.out.println();
        }
    }

    public void addTwoTable(Table tableOne, Table tableTwo, Table tablethree) {
        for (int i = 0; i < 43; i++) {
            for (int j = 0; j < 22; j++) {
                table2d[j][i] = tableOne.getTable()[j][i];
            }
        }
        for (int i = 52; i < 95; i++) {
            for (int j = 0; j < 22; j++) {
                if (tablethree.getTable()[j][i - 52] == '&') {
                    table2d[j][i] = '#';
                } else {
                    table2d[j][i] = tableTwo.getTable()[j][i - 52];
                }
            }
        }
    }

}
