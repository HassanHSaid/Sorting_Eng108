package om.spartaglobal.com.sortingmanager.model;

public class BSTSort implements Sort{


    public BSTSort() {
        root = null;
    }

    //node class
    class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }
    // Root of BST
    Node root;

    // This method mainly
    // calls insert Recursive
    void insert(int key) {
        root = insertRec(root, key);
    }

    //A recursive function to
    //insert a new key in BST
    Node insertRec(Node root, int key) {
        //If the tree is empty,
        //return a new node
        if (root == null){
            root = new Node(key);
            return root;
        }
        //Otherwise, recur down the tree
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        return root;
    }

    int i = 0;
    // A function to do
    // inorder traversal of BST
    void inorderRec(Node root, int[] array) {
        if (root != null) {
            inorderRec(root.left, array);
            array[i] = root.key;
            i++;
            inorderRec(root.right, array);
        }
    }
    void treeIns(int[] arr) {
        for (int j : arr) {
            insert(j);
        }

    }

    public void sortArray(int[] arr) {
        i = 0;
        BSTSort tree = new BSTSort();
        tree.treeIns(arr);
        tree.inorderRec(tree.root, arr);
    }
}
