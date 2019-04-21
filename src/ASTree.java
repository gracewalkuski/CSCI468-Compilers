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

        // we will print out the nodes differently depending on their type
        switch(node.nodeType) {
            case VarRef:
                System.out.printf("Node Type: %s\nNode Value: %s\n", node.nodeType, node.value);
                break;
            default:
                //System.out.println("ASTree default");
                System.out.println("Node Type: " + node.nodeType);
        }

    }
}
