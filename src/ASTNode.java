class ASTNode {

    enum ASTNodeType {
        AddExpr, MulExpr, VarRef;
    }

    ASTNode leftChild, rightChild;
    ASTNodeType nodeType;
    String varName;
    String varType;

    ASTNode(ASTNodeType nodeType, String varName, String varType) {
        this.nodeType = nodeType;
        this.varName = varName;
        this.varType = varType;
    }

}
