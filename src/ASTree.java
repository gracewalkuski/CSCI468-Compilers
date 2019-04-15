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

    void postOrderTraversal(ASTNode node) {
        if (node == null) return;

        postOrderTraversal(node.leftChild);

        postOrderTraversal(node.rightChild);

        switch(node.nodeType) {
            case VarRef:
                System.out.printf("%s\n%s %s", node.nodeType, node.value);
                break;
            default:
                System.out.println("ASTree default");
                System.out.println(node.nodeType);
        }
    }
}
