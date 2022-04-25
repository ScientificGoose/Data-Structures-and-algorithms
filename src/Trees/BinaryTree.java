package Trees;

import LinearStructures.Queue;

public class BinaryTree<T> {

    Node<T> root;

    private class Node<T>{

        T data;
        Node<T> left;
        Node<T> right;

        Node(T data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public BinaryTree(){
        this.root = null;
    }

    /**
     * This method uses an inorder traversal to insert a new element into the first
     * empty branch on the tree.
     * @param temp The node to be processed.
     * @param key The value to be entered.
     * @return The node that was processed.
     */
    public Node<T> insert(Node<T> temp, T key){

        // If the node is empty make it the new root node.
        if(temp == null){
            temp = new Node<>(key);
            return temp;
        }

        // Check the left branch for a free leaf.
        if(temp.left == null){
            temp.left = new Node<>(key);
        } else {
            insert(temp.left, key);
        }

        // Check the right branch for a free leaf.
        if(temp.right == null){
            temp.right = new Node<>(key);
        } else{
            insert(temp.right, key);
        }
        return temp;
    }

    /**
     * The search function will search the tree for the input data.
     * @param root The node to be searched.
     * @param data The data to be searched for.
     * @return A boolean value for if the data was found in the tree.
     */
    public boolean search(Node<T> root, T data){
        if(root == null){return false;}
        if(root.data == data){return true;}

        if(search(root.left, data)){
            return true;
        } else return search(root.right, data);
    }

    /**
     * The delete function will search the tree for the input data and delete
     * the first node that contains that data.
     * @param root The root node to be processed.
     * @param data The data to be removed from the tree.
     * @return The resulting Node from the delete operation.
     */
    public Node<T> delete(Node<T> root, T data){
        if(root == null){return null;}

        // Traverse the tree until matching data is found.
        if(search(root.left, data)){
            root.left = delete(root.left, data);
        } else if(search(root.right, data)){
            root.right = delete(root.right, data);

        // If the data is found, check to see if the root has child nodes.
        } else if(root.data == data){
            // No child nodes exist.
            if(root.left == null && root.right == null){
                root = null;
            // One child node exists.
            } else if(root.left == null || root.right == null){
                if(root.left == null){
                    return root.right;
                } else {
                    return root.left;
                }
            }
        // Root node has both a left and right branch.
        } else{
            // Traverse to bottom of the branch.
            Node<T> currentNode = root;
            while(currentNode.left != null){
                currentNode = currentNode.left;
            }
            // Bubble data up to the deleted node.
            root.data = currentNode.data;
            root.left = delete(root.left, currentNode.data);
        }
        return root;
    }

    /**
     * This method will print the tree using a depth first traversal method. The root Node
     * will be printed, followed by a decent through the left most branch. Once the bottom
     * the recursive structure will bubble back up and print the right branches of
     * the tree.
     * @param root The Node to be processed.
     */
    public void printPreOrder(Node<T> root){
        if(root == null){return;}

        System.out.print(root.data + ", ");
        printPreOrder(root.left);
        printPreOrder(root.right);
    }

    /**
     * This method will print the tree using a depth first traversal method. There will be a
     *  decent through the left most branch. Once at the bottom the recursive structure will
     *  bubble back up and print the parent nodes value, followed by a decent into the right
     *  branches of the tree.
     * @param root The Node to be processed.
     */
    public void printInOrder(Node<T> root){
        if (root == null){return;}

        printInOrder(root.left);
        System.out.print(root.data + ", ");
        printInOrder(root.right);
    }

    /**
     * This method will print the tree using a depth first traversal method. There will be a
     *  decent through the left most branch. Once at the bottom the recursive structure will
     *  bubble back up and print the parent nodes value, followed by a decent into the right
     *  branches of the tree. Finally the root of the tree will be printed.
     * @param root The Node to be processed.
     */
    public void printPostOrder(Node<T> root){
        if (root == null){return;}
        printPostOrder(root.left);
        printPostOrder(root.right);
        System.out.print(root.data + ", ");
    }
}
