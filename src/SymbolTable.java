import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class SymbolTable {

    private String scopeName;
    private LinkedHashMap<String, LinkedHashMap<String, String>> symbolTable;

    SymbolTable(String scopeName) {
        this.scopeName = scopeName;
        this.symbolTable = new LinkedHashMap<String, LinkedHashMap<String, String>>();
    }

    public void insert(String varName, String typeName, String stringValue) throws DeclarationError{

        if (this.symbolTable.keySet().contains(varName)) {
            throw new DeclarationError(varName);

        }
        else {
            symbolTable.put(varName, new LinkedHashMap<String, String>());
            symbolTable.get(varName).put(typeName, stringValue);
        }
    }

    public String lookup() {
        // if the symbol does not exist
        return "0";
    }
    public void prettyPrint() {

        System.out.println("Symbol table " + this.scopeName);

        for (Map.Entry<String, LinkedHashMap<String, String>> varNameKey : this.symbolTable.entrySet()) {
            String varName = varNameKey.getKey();

            for (Map.Entry<String, String> typeNameKey : varNameKey.getValue().entrySet()) {
                String typeName = typeNameKey.getKey();
                String stringValue = typeNameKey.getValue();
                if (typeName != "STRING") {
                    System.out.println("name " + varName + " type " + typeName);
                } else {
                    System.out.println("name " + varName + " type " + typeName + " value " + stringValue);
                }
            }


        }
        System.out.println();
    }
}