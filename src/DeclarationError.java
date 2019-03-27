class DeclarationError extends RuntimeException {

    public DeclarationError(String variable) {
        super(variable);
    }

}
