class IRNode {
    enum Type
    {
        ADDI, SUBI, MULTI, DIVI,
        ADDF, SUBF, MULTF, DIVF,
        STOREI, STOREF, READI, READF;
    }
    private String source1, source2, dest;
    private IRNode.Type type;

    IRNode(IRNode.Type type, String source1, String source2, String dest) {
        this.type = type;
        this.source1 = source1;
        this.source2 = source2;
        this.dest = dest;
    }
}
