// Generated from LittleGrammar.g4 by ANTLR 4.7.2

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * This class provides an empty implementation of {LittleGrammarListener},
 * which can be extended to create a listener which only needs to handle a subset
 * of the available methods.
 */
@SuppressWarnings({"EmptyMethod", "unused", "SpellCheckingInspection"})
public class LittleGrammarBaseListener implements LittleGrammarListener {


	private int block;
	private ArrayList<SymbolTable> symbolTableList;
	private String currentVarType;
	private SymbolTable currentSymbolTable;
	private IR ir;

	private boolean insideDeclaration;
	private boolean insideExpression;
	private boolean insideAssignment;

	LittleGrammarBaseListener() {
		this.symbolTableList = new ArrayList<>();
		this.currentSymbolTable = null;
		this.block = 0;
		this.currentVarType = null;

		this.insideDeclaration = false;
		this.insideExpression = false;
		this.insideAssignment = false;


	}

	public ArrayList<SymbolTable> getSymbolTableList() {
		return this.symbolTableList;
	}

	/**
	 * {@inheritDoc}
	 *
	 * The default implementation for ALL enter/exit methods does nothing.
	 *
	 *
	 **/

	@Override public void enterProgram(LittleGrammarParser.ProgramContext ctx) {

		if (ctx.id() != null ) {
			SymbolTable globalSymbolTable = new SymbolTable("GLOBAL");
			this.symbolTableList.add(globalSymbolTable);
			this.currentSymbolTable = globalSymbolTable;

			//Create an IR to generate 3AC
			ir = new IR();
		}
	}
	
	@Override public void exitProgram(LittleGrammarParser.ProgramContext ctx) {
	}
	
	@Override public void enterId(LittleGrammarParser.IdContext ctx) { }
	
	@Override public void exitId(LittleGrammarParser.IdContext ctx) { }
	
	@Override public void enterPgm_body(LittleGrammarParser.Pgm_bodyContext ctx) { }
	
	@Override public void exitPgm_body(LittleGrammarParser.Pgm_bodyContext ctx) { }
	
	@Override public void enterDecl(LittleGrammarParser.DeclContext ctx) { }
	
	@Override public void exitDecl(LittleGrammarParser.DeclContext ctx) { }
	
	@Override public void enterString_decl(LittleGrammarParser.String_declContext ctx) {

		this.insideDeclaration = true;
		this.currentVarType = "STRING";

		if (ctx.id() != null) {
			String id = ctx.id().getText();
			String str = ctx.str().getText();
			this.currentSymbolTable.insert(id, this.currentVarType, str);
		}
	}
	
	@Override public void exitString_decl(LittleGrammarParser.String_declContext ctx) {
		this.insideDeclaration = false;
	}
	
	@Override public void enterStr(LittleGrammarParser.StrContext ctx) { }
	
	@Override public void exitStr(LittleGrammarParser.StrContext ctx) { }
	
	@Override public void enterVar_decl(LittleGrammarParser.Var_declContext ctx) {

		// when we enter a variable declaration, set our class boolean to true
		// so that we ensure our variables are written to a symbol table
		this.insideDeclaration = true;
	}
	
	@Override public void exitVar_decl(LittleGrammarParser.Var_declContext ctx) {

		// when we exit a variable declaration, set our class boolean to false
		// so that we don't add write(var) or read(var) to our symbol tables
		this.insideDeclaration = false;
	}
	
	@Override public void enterVar_type(LittleGrammarParser.Var_typeContext ctx) {

		if (ctx != null) {
			//noinspection UnnecessaryLocalVariable
			String varType = ctx.getText();
			this.currentVarType = varType;
		}
	}
	
	@Override public void exitVar_type(LittleGrammarParser.Var_typeContext ctx) { }
	
	@Override public void enterAny_type(LittleGrammarParser.Any_typeContext ctx) { }
	
	@Override public void exitAny_type(LittleGrammarParser.Any_typeContext ctx) { }
	
	@Override public void enterId_list(LittleGrammarParser.Id_listContext ctx) {

		// if we enter a list of IDs, ensure we are in a declaration statement
		// before adding the id to our symbol table
		if (ctx.id() != null && this.insideDeclaration) {
			String id = ctx.id().getText();
			this.currentSymbolTable.insert(id, this.currentVarType, "");
			//System.out.println("Created VarRef " + currentVarType + " " + id);
		}
		if (ctx.id() != null && this.insideExpression) {
			String id = ctx.id().getText();
			//System.out.println("Created VarRef " + currentVarType + " " + id);
		}
	}
	
	@Override public void exitId_list(LittleGrammarParser.Id_listContext ctx) { }
	
	@Override public void enterId_tail(LittleGrammarParser.Id_tailContext ctx){

		// if we enter a list of IDs, ensure we are in a declaration statement
		// before adding the id to our symbol table
		if (ctx.id() != null && this.insideDeclaration) {
			String id = ctx.id().getText();
			this.currentSymbolTable.insert(id, this.currentVarType, "");
		}
		if (ctx.id() != null && this.insideExpression) {
			String id = ctx.id().getText();
			//System.out.print(" (id tail): " + currentVarType + " " + id);
		}
	}
	
	@Override public void exitId_tail(LittleGrammarParser.Id_tailContext ctx) { }
	
	@Override public void enterParam_decl_list(LittleGrammarParser.Param_decl_listContext ctx) { }
	
	@Override public void exitParam_decl_list(LittleGrammarParser.Param_decl_listContext ctx) { }
	
	@Override public void enterParam_decl(LittleGrammarParser.Param_declContext ctx){

		if (ctx.var_type() != null) {
			String varType = ctx.var_type().getText();
			String id = ctx.id().getText();
			this.currentSymbolTable.insert(id, varType, "");
		}
	}
	
	@Override public void exitParam_decl(LittleGrammarParser.Param_declContext ctx) { }
	
	@Override public void enterParam_decl_tail(LittleGrammarParser.Param_decl_tailContext ctx) { }
	
	@Override public void exitParam_decl_tail(LittleGrammarParser.Param_decl_tailContext ctx) { }
	
	@Override public void enterFunc_declarations(LittleGrammarParser.Func_declarationsContext ctx) { }

	@Override public void exitFunc_declarations(LittleGrammarParser.Func_declarationsContext ctx) { }

	@Override public void enterFunc_decl(LittleGrammarParser.Func_declContext ctx) {

		// when we enter a function declaration, create a new symbol table for it
		if (ctx.any_type() != null) {
			String funcName = ctx.id().getText();
			SymbolTable funcSymbolTable = new SymbolTable(funcName);
			this.symbolTableList.add(funcSymbolTable);
			this.currentSymbolTable = funcSymbolTable;
		}
	}
	
	@Override public void exitFunc_decl(LittleGrammarParser.Func_declContext ctx) { }
	
	@Override public void enterFunc_body(LittleGrammarParser.Func_bodyContext ctx) { }
	
	@Override public void exitFunc_body(LittleGrammarParser.Func_bodyContext ctx) { }
	
	@Override public void enterStmt_list(LittleGrammarParser.Stmt_listContext ctx) { }
	
	@Override public void exitStmt_list(LittleGrammarParser.Stmt_listContext ctx) { }
	
	@Override public void enterStmt(LittleGrammarParser.StmtContext ctx) { }
	
	@Override public void exitStmt(LittleGrammarParser.StmtContext ctx) { }
	
	@Override public void enterBase_stmt(LittleGrammarParser.Base_stmtContext ctx) { }
	
	@Override public void exitBase_stmt(LittleGrammarParser.Base_stmtContext ctx) { }
	
	@Override public void enterAssign_stmt(LittleGrammarParser.Assign_stmtContext ctx) {
		this.insideAssignment = true;
	}
	
	@Override public void exitAssign_stmt(LittleGrammarParser.Assign_stmtContext ctx) {
		this.insideAssignment = false;
	}
	
	@Override public void enterAssign_expr(LittleGrammarParser.Assign_exprContext ctx) {
	}
	
	@Override public void exitAssign_expr(LittleGrammarParser.Assign_exprContext ctx) { }
	
	@Override public void enterRead_stmt(LittleGrammarParser.Read_stmtContext ctx) { }
	
	@Override public void exitRead_stmt(LittleGrammarParser.Read_stmtContext ctx) { }
	
	@Override public void enterWrite_stmt(LittleGrammarParser.Write_stmtContext ctx) { }
	
	@Override public void exitWrite_stmt(LittleGrammarParser.Write_stmtContext ctx) { }
	
	@Override public void enterReturn_stmt(LittleGrammarParser.Return_stmtContext ctx) { }
	
	@Override public void exitReturn_stmt(LittleGrammarParser.Return_stmtContext ctx) { }
	
	@Override public void enterExpr(LittleGrammarParser.ExprContext ctx) {
		this.insideExpression = true;
	}
	
	@Override public void exitExpr(LittleGrammarParser.ExprContext ctx) {
		this.insideExpression = false;
	}
	
	@Override public void enterExpr_prefix(LittleGrammarParser.Expr_prefixContext ctx) {
		}

	@Override public void exitExpr_prefix(LittleGrammarParser.Expr_prefixContext ctx) { }

	@Override public void enterFactor(LittleGrammarParser.FactorContext ctx) {

	}
	
	@Override public void exitFactor(LittleGrammarParser.FactorContext ctx) { }
	
	@Override public void enterFactor_prefix(LittleGrammarParser.Factor_prefixContext ctx) { }
	
	@Override public void exitFactor_prefix(LittleGrammarParser.Factor_prefixContext ctx) { }
	
	@Override public void enterPostfix_expr(LittleGrammarParser.Postfix_exprContext ctx) { }
	
	@Override public void exitPostfix_expr(LittleGrammarParser.Postfix_exprContext ctx) { }
	
	@Override public void enterCall_expr(LittleGrammarParser.Call_exprContext ctx) { }
	
	@Override public void exitCall_expr(LittleGrammarParser.Call_exprContext ctx) { }
	
	@Override public void enterExpr_list(LittleGrammarParser.Expr_listContext ctx) { }
	
	@Override public void exitExpr_list(LittleGrammarParser.Expr_listContext ctx) { }
	
	@Override public void enterExpr_list_tail(LittleGrammarParser.Expr_list_tailContext ctx) { }
	
	@Override public void exitExpr_list_tail(LittleGrammarParser.Expr_list_tailContext ctx) { }
	
	@Override public void enterPrimary(LittleGrammarParser.PrimaryContext ctx) {
	}
	
	@Override public void exitPrimary(LittleGrammarParser.PrimaryContext ctx) { }
	
	@Override public void enterAddop(LittleGrammarParser.AddopContext ctx) {
	}
	
	@Override public void exitAddop(LittleGrammarParser.AddopContext ctx) { }
	
	@Override public void enterMulop(LittleGrammarParser.MulopContext ctx) {
	}
	
	@Override public void exitMulop(LittleGrammarParser.MulopContext ctx) { }
	
	@Override public void enterIf_stmt(LittleGrammarParser.If_stmtContext ctx) {

		// when we enter an if statement, create a new block symbol table and
		// increment our class variable, block
		if (ctx.cond() != null) {
			this.block += 1;
			SymbolTable newBlockSymTable = new SymbolTable("BLOCK " + block);
			this.symbolTableList.add(newBlockSymTable);
			this.currentSymbolTable = newBlockSymTable;
		}
	}
	
	@Override public void exitIf_stmt(LittleGrammarParser.If_stmtContext ctx) { }
	
	@Override public void enterElse_part(LittleGrammarParser.Else_partContext ctx) {

		// when we enter an else statement, create a new block symbol table and
		// increment our class variable, block
		if (ctx.decl() != null) {
			this.block += 1;
			SymbolTable newBlockSymTable = new SymbolTable("BLOCK " + block);
			this.symbolTableList.add(newBlockSymTable);
			this.currentSymbolTable = newBlockSymTable;
		}
	}
	
	@Override public void exitElse_part(LittleGrammarParser.Else_partContext ctx) { }
	
	@Override public void enterCond(LittleGrammarParser.CondContext ctx) { }
	
	@Override public void exitCond(LittleGrammarParser.CondContext ctx) { }
	
	@Override public void enterCompop(LittleGrammarParser.CompopContext ctx) { }
	
	@Override public void exitCompop(LittleGrammarParser.CompopContext ctx) { }
	
	@Override public void enterWhile_stmt(LittleGrammarParser.While_stmtContext ctx) {

		// when we enter an while statement, create a new block symbol table and
		// increment our class variable, block
		if (ctx.cond() != null) {
			this.block += 1;
			SymbolTable newBlockSymTable = new SymbolTable("BLOCK " + block);
			this.symbolTableList.add(newBlockSymTable);
			this.currentSymbolTable = newBlockSymTable;
		}
	}
	
	@Override public void exitWhile_stmt(LittleGrammarParser.While_stmtContext ctx) { }

	@Override public void enterEveryRule(ParserRuleContext ctx) { }
	
	@Override public void exitEveryRule(ParserRuleContext ctx) { }
	
	@Override public void visitTerminal(TerminalNode node) { }
	
	@Override public void visitErrorNode(ErrorNode node) { }
}