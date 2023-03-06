import java.util.HashMap;
import java.util.Map;

public class LetterInventory {
    private Map<Character, Integer> inventory;

    public LetterInventory(String input) {
        inventory = new HashMap<>();
        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                c = Character.toLowerCase(c);
                inventory.put(c, inventory.getOrDefault(c, 0) + 1);
            }
        }
    }

    public int get(char c) {
        c = Character.toLowerCase(c);
        return inventory.getOrDefault(c, 0);
    }

    public void set(char c, int value) {
        c = Character.toLowerCase(c);
        inventory.put(c, value);
    }

    public int size() {
        return inventory.values().stream().mapToInt(Integer::intValue).sum();
    }

    public boolean isEmpty() {
        return inventory.isEmpty();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (char c = 'a'; c <= 'z'; c++) {
            int count = get(c);
            for (int i = 0; i < count; i++) {
                sb.append(c);
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public LetterInventory add(LetterInventory other) {
        LetterInventory result = new LetterInventory("");
        for (char c = 'a'; c <= 'z'; c++) {
            result.set(c, get(c) + other.get(c));
        }
        return result;
    }

    public LetterInventory subtract(LetterInventory other) {
        LetterInventory result = new LetterInventory("");
        for (char c = 'a'; c <= 'z'; c++) {
            int diff = get(c) - other.get(c);
            if (diff < 0) {
                return null; // can't subtract more than we have
            }
            result.set(c, diff);
        }
        return result;
    }
}
