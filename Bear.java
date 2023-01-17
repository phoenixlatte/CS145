// Dansie Howard
// CS145
// Lab 2: Critters
//

import java.awt.*;

public class Bear extends Critter { // creates bear class
    private boolean polar;
    private boolean slash;

    public Bear(boolean polar) {
        this.polar= polar;
        slash= true;

    }
    public Action getMove(CritterInfo info) {
        // tell the bear actions and behavior
        slash = !slash;
        if(info.getFront() == Neighbor.OTHER)   {
            return Action.INFECT;
        }
        else if (info.getFront() == Neighbor.EMPTY) {
            return Action.HOP;
        }
        else {
            return Action.LEFT;
        }
    }
    public Color getColor() { // set the color for the bear
        if (polar) {
            return Color.WHITE;
        }
        else {
            return Color.BLACK;
        }
    } // end of action
    // returns the string value "/" "\" of the Bear
    public String toString() {
        if (slash) {
            return "/";
        }
        else {
            return "\\";
        }
        
    } // end of string
} // end of bear class
