public class AVLDictionary {

    public Node root;

    public String Search(String key) {
        Node current = root;
        while (current != null) {
            if (current.data.getSpell().equals(key)) {
                break;
            }
            int i = current.data.getSpell().compareTo(key);

            if (i > 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        if (current != null) {
            return current.data.toString();
        }
        return "==>Word not Present In the Dictionary !!";
    }


    public void insert(Word key) {
        root = insert(root, key);
    }

    public void delete(String key) {
        root = delete(root, key);
    }

    private Node insert(Node node, Word key) {
        if (node == null) {
            return new Node(key);
        } else if (key.getSpell().compareTo(node.data.getSpell()) > 0) {
            node.right = insert(node.right, key);
        } else if (key.getSpell().compareTo(node.data.getSpell()) < 0) {
            node.left = insert(node.left, key);
        } else {
            if (node.data.getSpell().equalsIgnoreCase(key.getSpell())) {
                throw new RuntimeException("Cannot Enter into Dictionary : This Word is Already Present in the Dictionary !!!");
            }
        }
        return Balance(node);
    }

    private Node delete(Node node, String key) {
        if (node == null) {
            return node;
        } else if (key.compareTo(node.data.getSpell()) < 0) {
            node.left = delete(node.left, key);
        } else if (key.compareTo(node.data.getSpell()) > 0) {
            node.right = delete(node.right, key);
        } else {
            if (node.left == null || node.right == null) {
                node = (node.left == null) ? node.right : node.left;
            } else {
                Node mostLeftChild = MinChild(node.right);
                node.data = mostLeftChild.data;
                node.right = delete(node.right, node.data.getSpell());
            }
        }
        if (node != null) {
            node = Balance(node);
        }
        return node;
    }

    private Node MinChild(Node node) {
        Node current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    private Node Balance(Node z) {
        updateHeight(z);
        int balance = getBalance(z);
        if (balance > 1) {
            if (height(z.right.right) > height(z.right.left)) {
                z = rotateLeft(z);
            } else {
                z.right = rotateRight(z.right);
                z = rotateLeft(z);
            }
        } else if (balance < -1) {
            if (height(z.left.left) > height(z.left.right)) {
                z = rotateRight(z);
            } else {
                z.left = rotateLeft(z.left);
                z = rotateRight(z);
            }
        }
        return z;
    }

    private Node rotateRight(Node y) {
        Node x = y.left;
        Node z = x.right;
        x.right = y;
        y.left = z;
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    private Node rotateLeft(Node y) {
        Node x = y.right;
        Node z = x.left;
        x.left = y;
        y.right = z;
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    private void updateHeight(Node n) {
        n.height = 1 + Math.max(height(n.left), height(n.right));
    }

    public int height(Node n) {
        return n == null ? 0 : n.height;
    }

    public int getBalance(Node n) {
        return (n == null) ? 0 : height(n.right) - height(n.left);
    }


    void printPostorder(Node node) {
        if (node == null)
            return;

        printPostorder(node.left);

        printPostorder(node.right);

        System.out.println(node.data.toString() + " ");
    }

    void printInorder(Node node) {
        if (node == null)
            return;

        printInorder(node.left);

        System.out.println(node.data.toString() + " ");

        printInorder(node.right);
    }

    void printPreorder(Node node) {
        if (node == null)
            return;

        System.out.println(node.data.toString() + " ");

        printPreorder(node.left);

        printPreorder(node.right);
    }

    public void printTree(Node currPtr, String indent, boolean last) {
        if (currPtr != null) {
            System.out.print(indent);
            if (last) {
                System.out.print("R----");
                indent += "   ";
            } else {
                System.out.print("L----");
                indent += "|  ";
            }
            System.out.println(currPtr.data.getSpell());
            printTree(currPtr.left, indent, false);
            printTree(currPtr.right, indent, true);
        }
    }
}

