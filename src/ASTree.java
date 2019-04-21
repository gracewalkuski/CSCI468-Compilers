class ASTree {

    ASTNode root;

    ASTree() {
        this.root = null;
    }
    ASTree(ASTNode node) {
        this.root = node;
    }

    public void insert(ASTNode node) {
        this.root = insertRecursively(root, node);
    }

    private ASTNode insertRecursively(ASTNode currNode, ASTNode newNode) {
        if (currNode == null) {
            return newNode;
        }
        if (currNode.leftChild == null) {

        }
        else if (currNode.rightChild == null) {
            currNode.rightChild = newNode;
        }
        else {
            System.out.println("Node not added. Already has left and right child.");
            return currNode;
        }
        return currNode;
    }

    public void insertLeftChild(ASTNode node) {
        if (this.root.leftChild == null) {
            this.root.leftChild = node;
        }
        else {
            System.out.println("THIS NODE ALREADY HAS A LEFT CHILD");
        }
    }

    public void insertRightChild(ASTNode node) {
        if (this.root.rightChild == null) {
            this.root.rightChild = node;
        }
        else {
            System.out.println("THIS NODE ALREADY HAS A RIGHT CHILD");
        }
    }


    void postOrderTraversal(ASTNode node) {
        if (node == null) return;

        postOrderTraversal(node.leftChild);

        postOrderTraversal(node.rightChild);

        System.out.printf("Node Value: %s (%s)\n", node.value, node.nodeType);

        // we will print out the nodes differently depending on their type
//        switch(node.nodeType) {
//            case VarRef:
//                break;
//            default:
//                System.out.printf("Node Value: %s (%s)\n", node.value, node.nodeType);
//        }

    }

}
