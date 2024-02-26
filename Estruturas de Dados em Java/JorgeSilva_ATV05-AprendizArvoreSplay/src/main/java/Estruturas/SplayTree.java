package Estruturas;

public class SplayTree<T extends Comparable<T>> {

    private Node<T> root;

    private static class Node<N extends Comparable<N>> {

        N key;
        Node<N> left, right, parent;

        Node(N key) {
            this.key = key;
            left = right = parent = null;
        }
    }

    private void rightRotate(Node<T> x) {
        Node<T> y = x.left;
        x.left = y.right;
        if (y.right != null) {
            y.right.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            root = y;
        } else if (x == x.parent.right) {
            x.parent.right = y;
        } else {
            x.parent.left = y;
        }
        y.right = x;
        x.parent = y;
    }

    private void leftRotate(Node<T> x) {
        Node<T> y = x.right;
        x.right = y.left;
        if (y.left != null) {
            y.left.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }
        y.left = x;
        x.parent = y;
    }

    private void splay(Node<T> x) {
        while (x.parent != null) {
            if (x.parent.parent == null) {
                if (x.parent.left == x) {
                    rightRotate(x.parent);
                } else {
                    leftRotate(x.parent);
                }
            } else if (x.parent.left == x && x.parent.parent.left == x.parent) {
                rightRotate(x.parent.parent);
                rightRotate(x.parent);
            } else if (x.parent.right == x && x.parent.parent.right == x.parent) {
                leftRotate(x.parent.parent);
                leftRotate(x.parent);
            } else if (x.parent.left == x && x.parent.parent.right == x.parent) {
                rightRotate(x.parent);
                leftRotate(x.parent);
            } else {
                leftRotate(x.parent);
                rightRotate(x.parent);
            }
        }
    }

    public void insert(T key) {
        Node<T> newNode = new Node<>(key);
        Node<T> y = null;
        Node<T> x = this.root;

        while (x != null) {
            y = x;
            if (newNode.key.compareTo(x.key) < 0) {
                x = x.left;
            } else if (newNode.key.compareTo(x.key) > 0) {
                x = x.right;
            } else {
                // Element already exists, splay it to the root
                splay(x);
                return;
            }
        }

        newNode.parent = y;

        if (y == null) {
            root = newNode;
        } else if (newNode.key.compareTo(y.key) < 0) {
            y.left = newNode;
        } else {
            y.right = newNode;
        }

        splay(newNode);
    }

    public T find(T key) {
        Node<T> z = findNode(key);
        if (z != null) {
            splay(z);
            return z.key;
        }
        return null;
    }

    public void remove(T key) {
        Node<T> node = findNode(key); // Use findNode(key) que retorna Node<T>
        if (node == null) {
            return; // Element not found.
        }

        splay(node);

        if (node.left == null && node.right == null) {
            root = null;
        } else if (node.left == null) {
            root = node.right;
            root.parent = null;
        } else if (node.right == null) {
            root = node.left;
            root.parent = null;
        } else {
            Node<T> leftSubtree = node.left;
            Node<T> rightSubtree = node.right;
            leftSubtree.parent = null;
            node.left = null;
            node.right = null;

            root = leftSubtree;
            Node<T> maxNode = maximum(leftSubtree);
            splay(maxNode);
            maxNode.right = rightSubtree;
            rightSubtree.parent = maxNode;
        }
    }

    private Node<T> findNode(T key) {
        Node<T> z = root;
        while (z != null) {
            int cmp = key.compareTo(z.key);
            if (cmp < 0) {
                z = z.left;
            } else if (cmp > 0) {
                z = z.right;
            } else {
                return z;
            }
        }
        return null;
    }

    private Node<T> maximum(Node<T> node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    public T getRoot() {
        return root != null ? root.key : null;
    }

    public void printTree() {
        printTreeHelper(this.root, "", true);
    }

    private void printTreeHelper(Node<T> node, String indent, boolean last) {
        if (node != null) {
            System.out.print(indent);
            if (last) {
                System.out.print("R----");
                indent += "   ";
            } else {
                System.out.print("L----");
                indent += "|  ";
            }
            System.out.println(node.key);
            printTreeHelper(node.left, indent, false);
            printTreeHelper(node.right, indent, true);
        }
    }

}
