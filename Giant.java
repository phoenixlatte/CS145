// Dansie Howard
// CS145
// Lab 2: Critters
//

import java.awt.*;
import java.util.Random;

public class Giant extends Critter { // creates giant class
    private int nameCounter = 0; // name 0 = fee, 1 = fie, 2 = foe, 3 = fum
    private int changeCounter = 1; // changes name every six counts
    private String giantName = "fee";

    public Giant() {
    }
    public Action getMove(CritterInfo info) {
         // tell the giant actions and behaviors
        if(info.getFront() == Neighbor.OTHER)   {
            return Action.INFECT;
        }
        else if (info.getFront() == Neighbor.EMPTY) {
            return Action.HOP;
        }
        else {
         return Action.RIGHT;
        }
    } // end if/else
    
    public Color getColor() { // set the color for the giant
        return Color.GRAY;
    } // end of action
    
    public String toString() { // returns the string value word of the giant
        if (changeCounter % 6 == 0) {
            nameCounter++;
            if (nameCounter == 4) {
               nameCounter = 0;
            }
            switch (nameCounter) {
               case 0:
                  giantName = "fee";
               case 1:
                  giantName = "fie";
               case 2:
                  giantName = "foe";
               case 3:
                  giantName = "fum";
                  break;
             } // end switch case
         } // end if statement
         changeCounter++;
         return giantName;
    } // end of string
} // end of giant class
