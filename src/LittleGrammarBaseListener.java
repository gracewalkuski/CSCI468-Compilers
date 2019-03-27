// Generated from LittleGrammar.g4 by ANTLR 4.7.2

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

/**
 * This class provides an empty implementation of {@link LittleGrammarListener},
 * which can be extended to create a listener which only needs to handle a subset
 * of the available methods.
 */
public class LittleGrammarBaseListener implements LittleGrammarListener {

	private int block;
	private ArrayList<SymbolTable> symbolTableList;
	private Stack symbols;
	private String currentVarType;
	private SymbolTable currentSymbolTable;
	private boolean insideDeclaration;

	LittleGrammarBaseListener() {
		this.block = 0;
		this.symbolTableList = new ArrayList<>();
		this.symbols = new Stack();
		this.currentVarType = null;
		this.currentSymbolTable = null;
		this.insideDeclaration = false;
	}

	public ArrayList<SymbolTable> getSymbolTableList() {
		return this.symbolTableList;
	}

	@Override public void enterProgram(LittleGrammarParser.ProgramContext ctx) {

		if (ctx.id() != null ) {
			SymbolTable GLOBAL = new SymbolTable("GLOBAL");
			this.symbolTableList.add(GLOBAL);
			this.currentSymbolTable = GLOBAL;
			//System.out.println("enterProgram ctx: " + ctx.getText());
		}
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitProgram(LittleGrammarParser.ProgramContext ctx) {
		//System.out.println("exitProgram ctx: " + ctx.getText());

	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterId(LittleGrammarParser.IdContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitId(LittleGrammarParser.IdContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterPgm_body(LittleGrammarParser.Pgm_bodyContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitPgm_body(LittleGrammarParser.Pgm_bodyContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterDecl(LittleGrammarParser.DeclContext ctx) {

		if (ctx.string_decl() != null) {
			this.currentVarType = "STRING";
			String stringDecl = ctx.string_decl().getText();
			String decl = ctx.decl().getText();
			//System.out.println("stringDecl:" + stringDecl + " \ndecl: " + decl);

		}
		else if (ctx.var_decl() != null){
			this.currentVarType = "INT";
			String varDecl = ctx.var_decl().getText();
			String decl = ctx.decl().getText();

			//System.out.println("varDecl:" + varDecl + "\ndecl: " + decl);

		}
		//System.out.println();
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitDecl(LittleGrammarParser.DeclContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterString_decl(LittleGrammarParser.String_declContext ctx) {

		this.insideDeclaration = true;

		if (ctx.id() != null) {
			String id = ctx.id().getText();
			String str = ctx.str().getText();
			//System.out.println("id: " + id + " \nstr: " + str);
			this.currentSymbolTable.insert(id, this.currentVarType, str);


		}

	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitString_decl(LittleGrammarParser.String_declContext ctx) {
		this.insideDeclaration = false;
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterStr(LittleGrammarParser.StrContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitStr(LittleGrammarParser.StrContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterVar_decl(LittleGrammarParser.Var_declContext ctx) {

		this.insideDeclaration = true;

		if (ctx.var_type() != null) {
			String varType = ctx.var_type().getText();
			String id_list = ctx.id_list().getText();
			//System.out.println("Var type: " + varType + " \nid list: " + id_list);

		}

	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitVar_decl(LittleGrammarParser.Var_declContext ctx) {
		this.insideDeclaration = false;

	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterVar_type(LittleGrammarParser.Var_typeContext ctx) {
		if (ctx != null) {
			String varType = ctx.getText();
			this.currentVarType = varType;

		}
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitVar_type(LittleGrammarParser.Var_typeContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterAny_type(LittleGrammarParser.Any_typeContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitAny_type(LittleGrammarParser.Any_typeContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterId_list(LittleGrammarParser.Id_listContext ctx) {

		if (ctx.id() != null && this.insideDeclaration) {

			String id = ctx.id().getText();
			//System.out.println("id: " + id);
			this.currentSymbolTable.insert(id, this.currentVarType, "");
		}


	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitId_list(LittleGrammarParser.Id_listContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterId_tail(LittleGrammarParser.Id_tailContext ctx){
		//System.out.print("enterId_tail");

		if (ctx.id() != null && this.insideDeclaration) {
			String id = ctx.id().getText();
			//System.out.println("id: " + id);
			this.currentSymbolTable.insert(id, this.currentVarType, "");

		}

	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitId_tail(LittleGrammarParser.Id_tailContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterParam_decl_list(LittleGrammarParser.Param_decl_listContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitParam_decl_list(LittleGrammarParser.Param_decl_listContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterParam_decl(LittleGrammarParser.Param_declContext ctx){

		if (ctx.var_type() != null) {
			String varType = ctx.var_type().getText();
			String id = ctx.id().getText();
			this.currentSymbolTable.insert(id, varType, "");

		}


	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitParam_decl(LittleGrammarParser.Param_declContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterParam_decl_tail(LittleGrammarParser.Param_decl_tailContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitParam_decl_tail(LittleGrammarParser.Param_decl_tailContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterFunc_declarations(LittleGrammarParser.Func_declarationsContext ctx) {

	}

	@Override public void exitFunc_declarations(LittleGrammarParser.Func_declarationsContext ctx) {

		//System.out.println(ctx.getText());
	}

	@Override public void enterFunc_decl(LittleGrammarParser.Func_declContext ctx) {
		if (ctx.any_type() != null) {
			String funcName = ctx.id().getText();
			//System.out.println("FUNC NAME: " + funcName);
			SymbolTable funcSymbolTable = new SymbolTable(funcName);
			this.symbolTableList.add(funcSymbolTable);
			this.currentSymbolTable = funcSymbolTable;
		}
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitFunc_decl(LittleGrammarParser.Func_declContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterFunc_body(LittleGrammarParser.Func_bodyContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitFunc_body(LittleGrammarParser.Func_bodyContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterStmt_list(LittleGrammarParser.Stmt_listContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitStmt_list(LittleGrammarParser.Stmt_listContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterStmt(LittleGrammarParser.StmtContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitStmt(LittleGrammarParser.StmtContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterBase_stmt(LittleGrammarParser.Base_stmtContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitBase_stmt(LittleGrammarParser.Base_stmtContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterAssign_stmt(LittleGrammarParser.Assign_stmtContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitAssign_stmt(LittleGrammarParser.Assign_stmtContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterAssign_expr(LittleGrammarParser.Assign_exprContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitAssign_expr(LittleGrammarParser.Assign_exprContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterRead_stmt(LittleGrammarParser.Read_stmtContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitRead_stmt(LittleGrammarParser.Read_stmtContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterWrite_stmt(LittleGrammarParser.Write_stmtContext ctx) {


	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitWrite_stmt(LittleGrammarParser.Write_stmtContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterReturn_stmt(LittleGrammarParser.Return_stmtContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitReturn_stmt(LittleGrammarParser.Return_stmtContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterExpr(LittleGrammarParser.ExprContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitExpr(LittleGrammarParser.ExprContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterExpr_prefix(LittleGrammarParser.Expr_prefixContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitExpr_prefix(LittleGrammarParser.Expr_prefixContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterFactor(LittleGrammarParser.FactorContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitFactor(LittleGrammarParser.FactorContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterFactor_prefix(LittleGrammarParser.Factor_prefixContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitFactor_prefix(LittleGrammarParser.Factor_prefixContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterPostfix_expr(LittleGrammarParser.Postfix_exprContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitPostfix_expr(LittleGrammarParser.Postfix_exprContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterCall_expr(LittleGrammarParser.Call_exprContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitCall_expr(LittleGrammarParser.Call_exprContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterExpr_list(LittleGrammarParser.Expr_listContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitExpr_list(LittleGrammarParser.Expr_listContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterExpr_list_tail(LittleGrammarParser.Expr_list_tailContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitExpr_list_tail(LittleGrammarParser.Expr_list_tailContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterPrimary(LittleGrammarParser.PrimaryContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitPrimary(LittleGrammarParser.PrimaryContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterAddop(LittleGrammarParser.AddopContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitAddop(LittleGrammarParser.AddopContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterMulop(LittleGrammarParser.MulopContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitMulop(LittleGrammarParser.MulopContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterIf_stmt(LittleGrammarParser.If_stmtContext ctx) {
		if (ctx.cond() != null) {
			this.block += 1;
			SymbolTable newBlockSymTable = new SymbolTable("BLOCK " + block);
			this.symbolTableList.add(newBlockSymTable);
			this.currentSymbolTable = newBlockSymTable;
		}
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitIf_stmt(LittleGrammarParser.If_stmtContext ctx) {
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterElse_part(LittleGrammarParser.Else_partContext ctx) {
		if (ctx.decl() != null) {
			this.block += 1;
			SymbolTable newBlockSymTable = new SymbolTable("BLOCK " + block);
			this.symbolTableList.add(newBlockSymTable);
			this.currentSymbolTable = newBlockSymTable;
		}
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitElse_part(LittleGrammarParser.Else_partContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterCond(LittleGrammarParser.CondContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitCond(LittleGrammarParser.CondContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterCompop(LittleGrammarParser.CompopContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitCompop(LittleGrammarParser.CompopContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterWhile_stmt(LittleGrammarParser.While_stmtContext ctx) {

		if (ctx.cond() != null) {
			this.block += 1;
			SymbolTable newBlockSymTable = new SymbolTable("BLOCK " + block);
			this.symbolTableList.add(newBlockSymTable);
			this.currentSymbolTable = newBlockSymTable;
		}

	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitWhile_stmt(LittleGrammarParser.While_stmtContext ctx) { }

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterEveryRule(ParserRuleContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitEveryRule(ParserRuleContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void visitTerminal(TerminalNode node) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void visitErrorNode(ErrorNode node) { }
}