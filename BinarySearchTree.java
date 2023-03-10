public class BinarySearchTree<K extends Comparable<K>, V> {
    private Node root;

    private class Node {
        private K key;
        private V value;
        private Node left, right;
        private int size;

        public Node(K key, V value, int size) {
            this.key = key;
            this.value = value;
            this.size = size;
        }
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) {
            return 0;
        } else {
            return x.size;
        }
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public V get(K key) {
        return get(root, key);
    }

    private V get(Node x, K key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return get(x.left, key);
        } else if (cmp > 0) {
            return get(x.right, key);
        } else {
            return x.value;
        }
    }

    public boolean contains(K key) {
        return get(key) != null;
    }

    public void put(K key, V value) {
        if (value == null) {
            delete(key);
            return;
        }
        root = put(root, key, value);
    }

    private Node put(Node x, K key, V value) {
        if (x == null) {
            return new Node(key, value, 1);
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = put(x.left, key, value);
        } else if (cmp > 0) {
            x.right = put(x.right, key, value);
        } else {
            x.value = value;
        }
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }

    public void deleteMin() {
        if (isEmpty()) {
            throw new NoSuchElementException("Symbol table underflow");
        }
        root = deleteMin(root);
    }

    private Node deleteMin(Node x) {
        if (x.left == null) {
            return x.right;
        }
        x.left = deleteMin(x.left);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void deleteMax() {
        if (isEmpty()) {
            throw new NoSuchElementException("Symbol table underflow");
        }
        root = deleteMax(root);
    }

    private Node deleteMax(Node x) {
        if (x.right == null) {
            return x.left;
        }
        x.right = deleteMax(x.right);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void delete(K key) {
        root = delete(root, key);
    }

    private Node delete(Node x, K key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = delete(x.left, key);
        } else if (cmp > 0) {
            x.right = delete(x.right, key);
        } else {
            if (x.right == null) {
                return x.left;
            }
            if (x.left == null) {
                return x.right;
            }
        }
    }
