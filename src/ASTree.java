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
