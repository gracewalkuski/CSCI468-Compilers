import java.util.HashMap;
import java.util.Map;

public class SymbolTable {

    String scopeName;
    HashMap<String, HashMap<String, String>> symbolTable;

    SymbolTable(String scopeName) {
        this.scopeName = scopeName;
        this.symbolTable = new HashMap<String, HashMap<String, String>>();
    }

    public void insert(String varName, String typeName, String stringValue) {
        symbolTable.put(varName, new HashMap<String, String>());
        symbolTable.get(varName).put(typeName, stringValue);
    }

    public String lookup() {

        // if the symbol does not exist
        return "0";
    }
    public void prettyPrint() {

        System.out.println("Symbol table " + this.scopeName);

        for (Map.Entry<String, HashMap<String, String>> varNameKey : this.symbolTable.entrySet()) {
            String varName = varNameKey.getKey();

            for (Map.Entry<String, String> typeNameKey : varNameKey.getValue().entrySet()) {
                String typeName = typeNameKey.getKey();
                String stringValue = typeNameKey.getValue();
                if (typeName != "str") {
                    System.out.println("name " + varName + " type " + typeName);
                } else {
                    System.out.println("name " + varName + " type " + typeName + " value \"" + stringValue + "\'");
                }
            }


        }
    }
}