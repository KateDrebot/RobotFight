package RobotFight;

import java.util.ArrayList;

public class ListOfClassRobot {

    private static ArrayList<Robot> robotArrayList = new ArrayList();

    public static ArrayList<Robot> getRobotArrayList() {

        return robotArrayList;
    }

    public static void addRobotList(String nameRobot) {
        Robot robot = new Robot(nameRobot);
        robotArrayList.add(robot);
    }

    public static void removeRobotFromList(int indexOfRobot) {
        try {
            robotArrayList.remove(indexOfRobot);
        } catch (Exception ex) {
            System.out.println("can't delete index=" + indexOfRobot + " from robot list!!  ");
        }
    }

    public static void createListOfRobot() {
        int countRobot = 0;
        int iterator = 0;
        final int MIN_COUNT_ROBOT = 2;
        final int MAX_COUNT_ROBOT = 5;

        do {
            System.out.println("Input count of robot (2-5): ");
            countRobot = ConsoleClass.getNumberFromConsole();

            if (MIN_COUNT_ROBOT <= countRobot && countRobot <= MAX_COUNT_ROBOT) {

                do {
                    String consoleName;
                    System.out.println("Input robot_" + (1 + iterator) + " name: ");
                    consoleName = ConsoleClass.getDataFromConsole();

                    if (!consoleName.isEmpty()) {
                        if (isNameOfRobotNotExist(consoleName)) {
                            addRobotList(consoleName);
                            iterator++;
                        } else {
                            System.out.println("This name already exist!!! Try again!!!");
                        }
                    } else {
                        System.out.println("Name can't be empty!!!! Try again!!!");
                    }

                } while (iterator < countRobot);

            } else {
                System.out.println("Wrong count of robot!!! try again!!");
            }
        } while ((iterator < countRobot) || (iterator == 0));
    }

    public static boolean isNameOfRobotNotExist(String inputName) {

        if (robotArrayList.isEmpty()) {
            return true;
        } else {
            for (int i = 0; i < robotArrayList.size(); i++) {
                if (robotArrayList.get(i).getNameOfRobot().equals(inputName)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void printRobotsInformation() {

        for (Robot robot : robotArrayList) {
            System.out.println(String.format("\nname \t%s\nhealth\t%s"
                    , robot.getNameOfRobot(), robot.getHealthRobot()));
        }
    }

}
