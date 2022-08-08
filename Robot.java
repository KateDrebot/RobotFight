package RobotFight;

import java.util.*;

public class Robot {
    private String nameOfRobot;
    private int healthRobot = 100;
    private Map<String, Boolean> mapOfDamageButton;

    public Robot(String nameOfRobot) {
        this.nameOfRobot = nameOfRobot;
        this.mapOfDamageButton = RandomClass.createShuffleMapOfButton();
    }

    public String getNameOfRobot() {
        return nameOfRobot;
    }

    public int getHealthRobot() {
        return healthRobot;
    }

    public void setReduceHealthRobot(int healthRobot) {
        this.healthRobot -= healthRobot;
    }

    public Map<String, Boolean> getMapOfDamageButton() {
        return mapOfDamageButton;
    }

    public void deleteDamageButton(String damageButton) {
        try {
            getMapOfDamageButton().remove(damageButton);
        } catch (Exception exception) {
            System.out.println("can't remove " + damageButton + " from list of damage button");
        }
    }
}
