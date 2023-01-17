// Dansie Howard
// CS145
// Lab 2: Critters
//

import java.awt.*;
import java.util.Random;

public class Orca extends Critter { // creates giant class
    private int nameCounter = 0; // name 0 = fee, 1 = fie, 2 = foe, 3 = fum
    private int changeCounter = 1; // changes name every six counts
    private String giantName = "fee";

    public Orca() {
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
        return Color.MAGENTA;
    } // end of action
    
    public String toString() { // returns the string value word of the giant
        return "?";
    } // end of string
} // end of orca class
