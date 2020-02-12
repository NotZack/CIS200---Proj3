import java.text.DecimalFormat;
import java.util.Scanner;

public class Proj3 {

    /**
     * Proj3.java
     * Zackary Nichol / Friday 3:30PM lab session
     *
     * Creates a coordinate plane that graphs the two given points (x1, x2, y1, y2) and gives the slope of the two points.
     * Checks to make sure that the input coordinates are valid.
     */

    public static void main(String[] args) {

        boolean running = true;
        boolean reEnter = false;

        Scanner scnr = new Scanner(System.in);
        DecimalFormat form = new DecimalFormat("0.00");

        while (running) {
            if (reEnter) System.out.print("Re-");
            System.out.print("Enter x1: ");
            int x1 = Integer.parseInt(scnr.nextLine());

            if (reEnter) System.out.print("Re-");
            System.out.print("Enter y1: ");
            int y1 = Integer.parseInt(scnr.nextLine());

            if (reEnter) System.out.print("Re-");
            System.out.print("Enter x2: ");
            int x2 = Integer.parseInt(scnr.nextLine());

            if (reEnter) System.out.print("Re-");
            System.out.print("Enter y2: ");
            int y2 = Integer.parseInt(scnr.nextLine());

            reEnter = false;

            if (!validateCoords(x1, x2, y1, y2)) {
                System.out.println("All points must be between (0,0) and (9,9).\n");
                reEnter = true;
                continue;
            }
            else if (x1 == x2 && y1 == y2) {
                System.out.println("Point values must be different.\n");
                reEnter = true;
                continue;
            }
            else if (x1 == x2 || y1 == y2) {
                System.out.println("Line between points must have a slope\n" +
                                    "(i.e. x1 and x2 must differ) \n");
                reEnter = true;
                continue;
            }

            double slope = (double)(y2-y1) / (double)(x2-x1);
            double yIntercept = y1 - slope * x1;
            System.out.print("\n");
            System.out.println("y = " + form.format(slope) + "x + " + form.format(yIntercept));

            char spacerChar = ' ';
            for (int i = 9; i > -1; i--) {
                if (y1 == i) {
                    plotPoint(x1, y1);
                    continue;
                }
                if (y2 == i) {
                    plotPoint(x2, y2);
                    continue;
                }

                if (i == 0) {
                    System.out.println("0 ---------------------");
                }
                else {
                    System.out.println(i + " |                    ");
                }
            }

            System.out.println("  0 1 2 3 4 5 6 7 8 9  ");
            System.out.print("\n");
            System.out.print("Run program again? (y/n)");
            if (!scnr.nextLine().toLowerCase().equals("y")) {
                break;
            }

            System.out.print("\n");
        }
    }

    private static boolean validateCoords(int ... coords) {
        for (int coord : coords) {
            if (coord < 0 || coord > 9) {
                return false;
            }
        }
        return true;
    }

    private static void plotPoint(int x1, int y1) {
        if (y1 == 0) {
            System.out.print("0 ");
            for (int i = 0; i < 20; i++) {
                if ((x1 * 2) == i) System.out.print("*");
                else System.out.print("-");
            }
            System.out.print("\n");
        }
        else {
            System.out.print(y1 + " |");
            for (int j = 0; j < 20; j++) {
                if ((x1 * 2) == j) {
                    System.out.print("*");
                    j += 2;
                }
                else System.out.print(" ");
            }
            System.out.print("\n");
        }
    }
}
