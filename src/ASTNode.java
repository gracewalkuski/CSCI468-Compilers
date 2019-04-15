class ASTNode {

    enum ASTNodeType {
        AddExpr, MulExpr, VarRef, AssignExpr;
    }

    ASTNode leftChild, rightChild;
    ASTNodeType nodeType;
    String value;

    ASTNode(ASTNodeType nodeType, String value) {
        this.nodeType = nodeType;
        this.value = value;
    }

}
