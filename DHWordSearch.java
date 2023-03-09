// Dansie Howard
// CS145
// Assignment 1: Word Search Generator

import java.util.*;

public class DHWordSearch {

    private char[][] puzzle;
    private Random random;
    private List<String> words;

    public int WordSearchGenerator(int size, List<String> words) {
        puzzle = new char[size][size];
        random = new Random();
        this.words = words;
    }

    public void generate() {
        // fill puzzle with random characters
        for (int i = 0; i < puzzle.length; i++) {
            for (int j = 0; j < puzzle[0].length; j++) {
                puzzle[i][j] = (char) (random.nextInt(26) + 'A');
            }
        }

        // insert words into puzzle
        for (String word : words) {
            insertWord(word.toUpperCase());
        }
    }

    public void insertWord(String word) {
        // generate random starting position and direction
        int x = random.nextInt(puzzle.length);
        int y = random.nextInt(puzzle[0].length);
        int dx = random.nextInt(3) - 1;
        int dy = random.nextInt(3) - 1;
        while (dx == 0 && dy == 0) {
            dx = random.nextInt(3) - 1;
            dy = random.nextInt(3) - 1;
        }

        // try to insert word in chosen direction
        for (int i = 0; i < word.length(); i++) {
            // check if current position is inside puzzle boundaries
            if (x < 0 || x >= puzzle.length || y < 0 || y >= puzzle[0].length) {
                return;
            }

            // check if current position is already occupied by a different letter
            if (puzzle[x][y] != word.charAt(i) && puzzle[x][y] != 0) {
                return;
            }

            // insert letter in current position
            puzzle[x][y] = word.charAt(i);

            // move to next position in chosen direction
            x += dx;
            y += dy;
        }
    }

    public void print() {
        for (int i = 0; i < puzzle.length; i++) {
            for (int j = 0; j < puzzle[0].length; j++) {
                System.out.print(puzzle[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        List<String> words = Arrays.asList("JAVA", "PYTHON", "CPLUSPLUS", "RUBY", "JAVASCRIPT");
        WordSearchGenerator generator = new WordSearchGenerator(10, words);
        generator.generate();
        generator.print();
    }
}

