package RobotFight;

public class MainClass {
    public static void main(String[] args) {

        ListOfClassRobot.createListOfRobot();

        String consoleDamageButton;
        int currentRobotNumberInList = 0;
        final String EXIT_BUTTON = "P";
        final int reduceHeath = 20;

        do {
            //check if all robots in list were shot. if true - print info and go to beginning of robot's list
            if (currentRobotNumberInList == ListOfClassRobot.getRobotArrayList().size()) {

                ListOfClassRobot.printRobotsInformation();
                currentRobotNumberInList = 0;
            }
            //print invitation to input one of damage button 'QWEASDZXC'
            ConsoleClass.printInvitationToShoot(ListOfClassRobot.getRobotArrayList().get(currentRobotNumberInList).getNameOfRobot());
            consoleDamageButton = ConsoleClass.getDataFromConsole();

            if (!EXIT_BUTTON.equalsIgnoreCase(consoleDamageButton)) {

                if (RandomClass.isInputButtonAcceptableInList(consoleDamageButton)) {

                    Robot currentRobot = ListOfClassRobot.getRobotArrayList().get(currentRobotNumberInList);

                    if (currentRobot.getMapOfDamageButton().containsKey(consoleDamageButton.toUpperCase())) {

                        if (currentRobot.getMapOfDamageButton().get(consoleDamageButton.toUpperCase())) {

                            System.out.println("You damage robot!!!");
                            currentRobot.setReduceHealthRobot(reduceHeath);
                            if (currentRobot.getHealthRobot() == 0) {
                                ListOfClassRobot.removeRobotFromList(currentRobotNumberInList);
                                continue;
                            }
                        } else {
                            System.out.println("Key is not damage robot!!!!");
                        }

                        currentRobot.deleteDamageButton(consoleDamageButton.toUpperCase());

                    } else {
                        System.out.println("Key already was press. It is not active!");
                    }
                    currentRobotNumberInList++;
                } else {
                    System.out.println("Wrong button!!! Try again!!");
                }
            } else {
                System.out.println("----GOODBYE!!!----");
                break;
            }
        } while (ListOfClassRobot.getRobotArrayList().size() > 1);

        if (ListOfClassRobot.getRobotArrayList().size() == 1) {
            System.out.println("\nYOU WIN!!! CONGRATULATION!!!");
            System.out.println("name robot : " + ListOfClassRobot.getRobotArrayList().get(0).getNameOfRobot());
            System.out.println("health : " + ListOfClassRobot.getRobotArrayList().get(0).getHealthRobot());
        }
    }
}
