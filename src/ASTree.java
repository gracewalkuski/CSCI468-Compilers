class ASTree {

    ASTNode root;

    ASTree() {
        this.root = null;
    }
    ASTree(ASTNode node) {
        this.root = node;
    }

    void postOrderTraversal(ASTNode node) {
        if (node == null) return;

        postOrderTraversal(node.leftChild);

        postOrderTraversal(node.rightChild);

        switch(node.nodeType) {
            case VarRef:
                System.out.printf("%s\n%s %s", node.nodeType, node.varType, node.varName);
                break;
            default:
                System.out.println("ASTree default");
                System.out.println(node.nodeType);
        }
    }
}
