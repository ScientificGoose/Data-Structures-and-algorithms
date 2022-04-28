package Trees;

import java.util.ArrayList;

public class BinarySearchTree<T extends Comparable<T>>{

    /**
     * This is the default constructor for the node class.
     */
    private class Node{
        T data;
        Node left;
        Node right;

        public Node(T data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    /**
     * This is the default constructor for the BinarySearchTree.
     */
    public BinarySearchTree(){
        this.root = null;
    }

    /**
     * The search method will traverse the tree inorder to check if the input data
     * is contained in the tree.
     * @param node The node being searched.
     * @param data The data being searched for.
     * @return A boolean value for if the input data is contained in the tree.
     */
    public boolean search(Node node, T data){
        if(node == null){return false;}

        if(node.data == data){return true;}

        if(search(node.left, data)){
            return true;
        } else{
            return search(node.right, data);
        }
    }

    /**
     * The method will insert a new node in the first available leaf.
     * @param data The data to be added to the tree.
     */
    public void insert(T data) {
        Node newNode = new Node(data);
        if (root == null) {
            root = newNode;
            return;
        }

        Node current = new Node(data);
        while (true) {
            if (current.data.compareTo(data) <= 0) {
                if (current.left == null) {
                    current.left = newNode;
                    return;
                }
                current = current.left;
            } else {

                if (current.data.compareTo(data) > 0) {
                    current.right = newNode;
                    return;
                }
                current = current.right;
            }
        }
    }

    /**
     * This method will delete the input value, if it exists in the tree.
     * @param node The root node to be evaluated.
     * @param data The data to be deleted from the tree.
     * @return The processed Node.
     */
    public Node delete (Node node, T data){
        if (node == null) {return null;}

        // If the input is less than the node's data.
        if (node.data.compareTo(data) < 0){
            node.left = delete(node.left, data);

          // If the input is greater than the node's data.
        } else if (node.data.compareTo(data) > 0) {
            node.right = delete(node.right, data);
        } else {
            // Node has no left child.
            if(node.left == null) {
                return node.right;

              // Root has no right child.
            } else if(node.right == null){
                return node.left;
            }

            // Node has two children find the smallest value in the right branch.
            Node smallestNode = getMin(node.right);
            // Copy the smallest leaf value to node.
            node.data = smallestNode.data;
            // Descend the right branch and delete the copied node.
            node.right = delete(node.right, node.data);
        }
        return node;
    }

    /**
     * This method will find the smallest value in the tree.
     * @param node The node to be evaluated.
     * @return The node with the smallest value in the tree.
     */
    private Node getMin(Node node){
        while(node.left != null){
            node = node.left;
        }
        return node;
    }

    /**
     * This method will check if the input node exists and then call the methods to
     * balance the tree.
     * @param root The root node of the tree.
     * @return Returns the root node of the balanced tree.
     */
    public Node balance(Node root){
        ArrayList<Node> listOfNodes = getInOrderList(root);
        if(listOfNodes == null || listOfNodes.size() == 0){
            return null;
        }
        return sortListToTree(listOfNodes, 0, listOfNodes.size() - 1);
    }

    /**
     * This method will convert create an arrayList of the tree values. This uses inorder traversal.
     * @param root The root of the tree being copied to the list.
     * @return The inorder ArrayList of the tree.
     */
    public ArrayList<Node> getInOrderList(Node root){

        if(root == null){return null;}

        ArrayList<Node> left = getInOrderList(root.left);
        ArrayList<Node> right = getInOrderList(root.right);

        // Combine the resulting lists in order.
        ArrayList<Node> list = new ArrayList<>(left);
        list.add(root);
        list.addAll(right);

        return list;
    }

    /**
     * This method will take an array list of elements and sort them into a new Binary Search Tree.
     * @param list The list to be converted into a tree.
     * @return The root node of the sorted tree.
     */
    public Node sortListToTree(ArrayList<Node> list, int startIdx, int endIdx){
        if(list == null || list.size() == 0){
            return null;
        }

        int midpoint = startIdx + (endIdx - startIdx) / 2;
        // Get the value from the middle of the list for the root node.
        Node root = list.get(midpoint);

        // split the list into a left and right and assign the values to the root's children.
        root.left = sortListToTree(list, startIdx, midpoint - 1);
        root.right = sortListToTree(list, midpoint + 1, endIdx);
        return root;
    }

}
