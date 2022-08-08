package RobotFight;

import java.util.Scanner;

public class ConsoleClass {
    public static String getDataFromConsole() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static int getNumberFromConsole() {
        Scanner scanner = new Scanner(System.in);
        try {
            return scanner.nextInt();
        } catch (Exception ex) {
            return 0;
        }
    }

    public static void printInvitationToShoot(String nameRobot) {
        System.out.println("\nFor EXIT press  'P'");
        System.out.println(String.format("A shot at the robot : %s", nameRobot));
        System.out.println("Your step: press one of the keys 'QWEASDZXC'    ");
    }
}
