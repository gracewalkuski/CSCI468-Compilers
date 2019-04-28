import java.util.LinkedHashMap;
import java.util.Map;

class SymbolTable {

    private final String scopeName;

    // a linked hashmap retains order so we can print our symbol tables correctly
    private LinkedHashMap<String, LinkedHashMap<String, String>> symbolTable;

    SymbolTable(String scopeName) {
        this.scopeName = scopeName;
        this.symbolTable = new LinkedHashMap<>();
    }

    public void insert(String varName, String typeName, String stringValue) throws DeclarationError{

        // if a variable name is declared more than once in the same scope, throw a declaration error
        if (this.symbolTable.keySet().contains(varName)) {
            throw new DeclarationError(varName);

        }
        // else we insert the variable name into our symbol table as normal
        // format of the symbol table:
        //              {*Variable Name*: {Variable Type : String value}}
        else {
            symbolTable.put(varName, new LinkedHashMap<>());
            symbolTable.get(varName).put(typeName, stringValue);
        }
    }

    public LinkedHashMap<String, String> lookup(String varName) {

        if (this.symbolTable.keySet().contains(varName)) {
            return this.symbolTable.get(varName);
        }
        else {
            return null;
        }
    }


    public String lookupVarType(String varName) {

        if (this.symbolTable.keySet().contains(varName)) {
            LinkedHashMap<String, String> temp = this.symbolTable.get(varName);

            String[] arr = temp.keySet().toArray(new String[0]);
            return arr[0];
        }
        else {
            return null;
        }
    }

    public String getScopeName() {
        return this.scopeName;
    }

    public void prettyPrint() {

        System.out.println("Symbol table " + this.scopeName);

        for (Map.Entry<String, LinkedHashMap<String, String>> varNameKey : this.symbolTable.entrySet()) {
            String varName = varNameKey.getKey();

            for (Map.Entry<String, String> typeNameKey : varNameKey.getValue().entrySet()) {
                String typeName = typeNameKey.getKey();
                String stringValue = typeNameKey.getValue();
                if (!typeName.equals("STRING")) {
                    System.out.println("name " + varName + " type " + typeName);
                } else {
                    System.out.println("name " + varName + " type " + typeName + " value " + stringValue);
                }
            }


        }
        System.out.println();
    }
}