package RobotFight;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class RandomClass {
    final static String LIST_DAMAGE_BUTTON = "QWEASDZXC";

    public static Map<String, Boolean> createShuffleMapOfButton() {

        Map<String, Boolean> mapOfButton = new HashMap<>();

        final int COUNT_DAMAGE_BUTTON = 5;

        Boolean[] damageYesOrNo = new Boolean[LIST_DAMAGE_BUTTON.length()];

        for (int i = 0; i < LIST_DAMAGE_BUTTON.length(); i++) {
            if (i < COUNT_DAMAGE_BUTTON)
                damageYesOrNo[i] = true;
            else
                damageYesOrNo[i] = false;
        }
        Collections.shuffle(Arrays.asList(LIST_DAMAGE_BUTTON));
        Collections.shuffle(Arrays.asList(damageYesOrNo));

        for (int i = 0; i < LIST_DAMAGE_BUTTON.length(); i++) {
            mapOfButton.put(LIST_DAMAGE_BUTTON.substring(i, i + 1), damageYesOrNo[i]);
        }

        return mapOfButton;
    }

    public static boolean isInputButtonAcceptableInList(String currentInputButton) {

        for (int i = 0; i < LIST_DAMAGE_BUTTON.length(); i++) {
            if (LIST_DAMAGE_BUTTON.substring(i, i + 1).equalsIgnoreCase(currentInputButton)) {
                return true;
            }
        }
        return false;
    }
}
