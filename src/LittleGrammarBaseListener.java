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

	private ASTNode exprPrefixNode, factorNode, addOpNode;
	private Queue<ASTNode> inUseASTNodes;

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

		this.inUseASTNodes = new LinkedList<>();


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
		}
	}
	
	@Override public void exitProgram(LittleGrammarParser.ProgramContext ctx) {
		if (ctx.id() != null) {
//			for (ASTNode node : this.inUseASTNodes) {
//				System.out.println("BEGIN LIST POSTORDER TRAVERSAL");
//				ASTree tree = new ASTree(node);
//				tree.postOrderTraversal(node);
//				System.out.println("END LIST POSTORDER TRAVERSAL");
//
//			}
//			if (this.exprPrefixNode != null) {
//                System.out.println("EXPR PREFIX NODE: BEGIN POSTORDER TRAVERSAL");
//				ASTree tree = new ASTree(this.exprPrefixNode);
//				tree.postOrderTraversal(this.exprPrefixNode);
//
//                System.out.println("EXPR PREFIX NODE: END POSTORDER TRAVERSAL");
//            }
		}
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
			System.out.println("Created VarRef " + currentVarType + " " + id);
		}
		if (ctx.id() != null && this.insideExpression) {
			String id = ctx.id().getText();
			System.out.println("Created VarRef " + currentVarType + " " + id);
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
			System.out.print(" (id tail): " + currentVarType + " " + id);
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
		if (ctx.id() != null) {
			//System.out.println("Created ASSIGNMENT NODE: " + ctx.id().getText() + " " + ctx.expr().getText());
		}
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
	
//	@Override public void enterExpr_prefix(LittleGrammarParser.Expr_prefixContext ctx) {
//		//TODO MAKE EXPR_PREFIX'S RIGHT CHILD FACTOR, MAKE ADDOP ITS PARENT (ADDOPS LEFT CHILD) might be done, not sure about order
//
//			if (this.exprPrefixNode != null && this.addOpNode != null) {
////				ASTNode addOpNode = new ASTNode(ASTNode.ASTNodeType.AddExpr, ctx.addop().getText());
////				String factorNode = ctx.factor().getText();
////				String exprPrefixNode = ctx.expr_prefix().getText();
////				System.out.println("EXPR PREFIX!=(NULL)\naddop(): " + ctx.addop().getText() + "\nfactor(): " + factorNode + "\nexpr_prefix(): " + exprPrefixNode);
//				assert(this.exprPrefixNode.rightChild == null);
//                this.exprPrefixNode.rightChild = this.factorNode;
//                this.addOpNode.leftChild = this.exprPrefixNode;
//                this.exprPrefixNode = addOpNode;
//
//
//			}
//			else if (this.exprPrefixNode == null && ctx.addop() != null && this.factorNode != null) {
////				ASTNode addOpNode = new ASTNode(ASTNode.ASTNodeType.AddExpr, ctx.addop().getText());
////				String factorNode = ctx.factor().getText();
////				System.out.println("EXPR PREFIX==(NULL)\naddop(): " + ctx.addop().getText() + "\nfactor(): " + factorNode);
//                ASTNode addOpNode = new ASTNode(ASTNode.ASTNodeType.AddExpr, ctx.addop().getText());
//                addOpNode.leftChild = this.factorNode;
//				this.exprPrefixNode = addOpNode;
//			}
//		}

//	@Override public void exitExpr_prefix(LittleGrammarParser.Expr_prefixContext ctx) { }

	@Override public void enterValidExprPrefix(LittleGrammarParser.ValidExprPrefixContext ctx) {
		if (ctx.factor() != null) {
			if (ctx.factor().factor_prefix() != null) {
				if (ctx.factor().factor_prefix().mulop() != null) {
//				System.out.printf("FACTORPREFIX>POSTFIX EXPR: %s", ctx.factor_prefix().postfix_expr().getText());
//				System.out.println("MULOP: " + ctx.factor_prefix().mulop().getText());
					ASTNode factorNode = new ASTNode(ASTNode.ASTNodeType.MulExpr, ctx.factor().factor_prefix().mulop().getText());
					ASTNode addOpNode = new ASTNode(ASTNode.ASTNodeType.AddExpr, ctx.addop().getText());
					factorNode.leftChild = new ASTNode(ASTNode.ASTNodeType.VarRef, ctx.factor().factor_prefix().postfix_expr().getText());
					factorNode.rightChild = new ASTNode(ASTNode.ASTNodeType.VarRef, ctx.factor().postfix_expr().getText());

					this.inUseASTNodes.add(factorNode);
//					this.factorNode = factorNode;
//				System.out.printf("ROOT: %s\nLEFT CHILD: %s\nRIGHT CHILD: %s\n", factorNode.value, factorNode.leftChild.value, factorNode.rightChild.value);

					if (this.exprPrefixNode != null) {
						System.out.println("-EXPR PREFIX NOT NULL-\nexpr_prefix(): " + ctx.expr_prefix().getText());
						this.exprPrefixNode.rightChild = factorNode;
						addOpNode.leftChild = this.exprPrefixNode;
						ASTree tree = new ASTree(addOpNode);
						tree.postOrderTraversal(addOpNode);
					} else {
						System.out.println("-EXPR PREFIX NULL-");
						ASTree tree = new ASTree(addOpNode);
						addOpNode.leftChild = factorNode;
						tree.postOrderTraversal(addOpNode);
						this.exprPrefixNode = addOpNode;
					}

				}


			}
		}
	}

	@Override public void exitValidExprPrefix(LittleGrammarParser.ValidExprPrefixContext ctx) {

	}

	@Override public void enterNullExprPrefix(LittleGrammarParser.NullExprPrefixContext ctx) {

	}

	@Override public void exitNullExprPrefix(LittleGrammarParser.NullExprPrefixContext ctx) {

	}


	@Override public void enterFactor(LittleGrammarParser.FactorContext ctx) {
		if (ctx.factor_prefix() != null) {
//			System.out.printf("\n-ENTERFACTOR-\nFACTOR PREFIX: %s\nPOSTFIX_EXPR: %s\n\n", ctx.factor_prefix().getText(), ctx.postfix_expr().getText());
			if (ctx.factor_prefix().mulop() != null) {
				System.out.println("-ENTER FACTOR-");
//				System.out.printf("FACTORPREFIX>POSTFIX EXPR: %s", ctx.factor_prefix().postfix_expr().getText());
//				System.out.println("MULOP: " + ctx.factor_prefix().mulop().getText());
				ASTNode factorNode = new ASTNode(ASTNode.ASTNodeType.MulExpr, ctx.factor_prefix().mulop().getText());
				factorNode.leftChild = new ASTNode(ASTNode.ASTNodeType.VarRef, ctx.factor_prefix().postfix_expr().getText());
				factorNode.rightChild = new ASTNode(ASTNode.ASTNodeType.VarRef, ctx.postfix_expr().getText());

				this.inUseASTNodes.add(factorNode);
				this.factorNode = factorNode;
//				System.out.printf("ROOT: %s\nLEFT CHILD: %s\nRIGHT CHILD: %s\n", factorNode.value, factorNode.leftChild.value, factorNode.rightChild.value);
			}
		}
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
		if (!ctx.getText().equals("") && this.insideExpression) {
			//System.out.println("Created PRIMARY node: " + ctx.getText());
		}
	}
	
	@Override public void exitPrimary(LittleGrammarParser.PrimaryContext ctx) { }
	
	@Override public void enterAddop(LittleGrammarParser.AddopContext ctx) {
		if (!ctx.getText().equals("")) {
			System.out.println("-ENTER ADDOP-");
			ASTNode addOpNode = new ASTNode(ASTNode.ASTNodeType.AddExpr, ctx.getText());
			this.inUseASTNodes.add(addOpNode);
			this.addOpNode = addOpNode;
		}
	}
	
	@Override public void exitAddop(LittleGrammarParser.AddopContext ctx) { }
	
	@Override public void enterMulop(LittleGrammarParser.MulopContext ctx) {
		if (!ctx.getText().equals("") && this.insideExpression) {
			//System.out.println("Created MULOP node: " + ctx.getText());
		}

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