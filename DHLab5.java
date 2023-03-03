// Dansie Howard
// CS145
// Lab 5: Tower of Hanoi

public class DHLab5 {
    public static void main(String[] args) {
        int numDisks = 3;
        moveDisks(numDisks, 'A', 'B', 'C');
    }

    public static void moveDisks(int numDisks, char fromRod, char toRod, char auxRod) {
        if (numDisks == 1) {
            System.out.println("Move disk 1 from rod " +  fromRod + " to rod " + toRod);
            return;
        }
        moveDisks(numDisks-1, fromRod, auxRod, toRod);
        System.out.println("Move disk " + numDisks + " from rod " +  fromRod + " to rod " + toRod);
        moveDisks(numDisks-1, auxRod, toRod, fromRod);
    }
}
