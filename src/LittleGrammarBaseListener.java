// Generated from LittleGrammar.g4 by ANTLR 4.7.2

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Stack;

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
	private Stack<String> outputStack;
	private Stack<String[]> operatorStack;
//	private Stack<String> expressionStack;

	private IR ir;

	private boolean insideDeclaration;
	private boolean insideExpression;
	private boolean insideAssignment;
	private boolean insideFactor; //maybe useless
	private boolean insideConditional;
	private boolean insideStatementList;
	private TinyBuilder tb;

	LittleGrammarBaseListener() {
		this.symbolTableList = new ArrayList<>();
		this.currentSymbolTable = null;
		this.block = 0;
		this.currentVarType = null;

		this.outputStack = new Stack<>();
		this.operatorStack = new Stack<>();

		this.insideDeclaration = false;
		this.insideExpression = false;
		this.insideAssignment = false;
		this.insideConditional = false;
		this.insideStatementList = false;

		this.ir = new IR(this.symbolTableList);

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
			this.ir.beginProgram();
		}
	}
	
	@Override public void exitProgram(LittleGrammarParser.ProgramContext ctx) {
		this.ir.exitProgram();
		if (ctx != null) {

			}
		}

	
	@Override public void enterId(LittleGrammarParser.IdContext ctx) {
		if (ctx != null && insideStatementList) {
			if (!ctx.getText().equals("")) {
//				System.out.println("DEBUG ID " + ctx.getText());
			}
		}
	}
	
	@Override public void exitId(LittleGrammarParser.IdContext ctx) { }
	
	@Override public void enterPgm_body(LittleGrammarParser.Pgm_bodyContext ctx) {
	}
	
	@Override public void exitPgm_body(LittleGrammarParser.Pgm_bodyContext ctx) {
	}
	
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
		}
		if (ctx.id() != null && this.insideExpression) {
			String id = ctx.id().getText();
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

			//add label to IR
			this.ir.generateLabel(funcName);
			this.ir.pushFramePointerOntoStack();
		}
	}
	
	@Override public void exitFunc_decl(LittleGrammarParser.Func_declContext ctx) { }
	
	@Override public void enterFunc_body(LittleGrammarParser.Func_bodyContext ctx) { }
	
	@Override public void exitFunc_body(LittleGrammarParser.Func_bodyContext ctx) { }
	
	@Override public void enterStmt_list(LittleGrammarParser.Stmt_listContext ctx) {
		if (ctx != null) {
			this.insideStatementList = true;
		}
	}
	
	@Override public void exitStmt_list(LittleGrammarParser.Stmt_listContext ctx) {
		if (ctx != null) {
			this.insideStatementList = false;
		}
	}
	
	@Override public void enterStmt(LittleGrammarParser.StmtContext ctx) { }
	
	@Override public void exitStmt(LittleGrammarParser.StmtContext ctx) { }
	
	@Override public void enterBase_stmt(LittleGrammarParser.Base_stmtContext ctx) { }
	
	@Override public void exitBase_stmt(LittleGrammarParser.Base_stmtContext ctx) { }
	
	@Override public void enterAssign_stmt(LittleGrammarParser.Assign_stmtContext ctx) {

		if ( ctx.assign_expr() != null ) {
			this.insideAssignment = true;
//			System.out.println("Enter");
//			System.out.printf("EXPR %s\nvariable: %s\n", ctx.assign_expr().expr().getText(), ctx.assign_expr().id().getText());

			// TODO - commented this out
			//call ir to generate store with value and varname
//			String expr = ctx.assign_expr().expr().getText();
//			String varName = ctx.assign_expr().id().getText();
//			this.ir.generateStoreOLD(expr, varName);
		}
	}
	
	@Override public void exitAssign_stmt(LittleGrammarParser.Assign_stmtContext ctx) {
		if (ctx.assign_expr() != null && ctx.assign_expr().id() != null && this.insideAssignment) {

//			if (ctx.assign_expr().expr().getText().matches("[0-9]+")) {
//				//System.out.printf("Only one child?\n\t%s", ctx.assign_expr().expr().getText());
//				this.ir.generateStore(ctx.assign_expr().expr().getText(), ctx.assign_expr().id().getText());
//			}
			if (this.outputStack.size() == 1) {
				this.ir.generateStore(this.outputStack.pop(), ctx.assign_expr().id().getText());

			}
			this.insideAssignment = false;
//			System.out.println("Exit");
//			System.out.printf("EXPR %s\nvariable: %s\n", ctx.assign_expr().expr().getText(), ctx.assign_expr().id().getText());

//			System.out.printf("GENERATE STORE\nVariable: %s\nValue: %s\n", ctx.assign_expr().id().getText(), this.expressionStack.peek());
			//this.ir.generateStore(this.expressionStack.pop(), ctx.assign_expr().id().getText());
//			this.ir.generateStore(this.outputStack.pop().value, ctx.assign_expr().id().getText());		}
		}
	}
	
	@Override public void enterAssign_expr(LittleGrammarParser.Assign_exprContext ctx) {
		if (ctx.id() != null && ctx.expr().factor().postfix_expr().primary() != null) {
			//System.out.printf("ENTER ASSIGN EXPR\nID: %s\nEXPR: %s\n", ctx.id().getText(), ctx.expr().getText());
			this.ir.parseExpressionAndAssign(ctx.id().getText(), ctx.expr().getText());
			}
		}

	
	@Override public void exitAssign_expr(LittleGrammarParser.Assign_exprContext ctx) {

	}
	
	@Override public void enterRead_stmt(LittleGrammarParser.Read_stmtContext ctx) {
		if (ctx != null && ctx.id_list() != null) {
			this.ir.generateRead(ctx.id_list().getText());
		}
	}
	
	@Override public void exitRead_stmt(LittleGrammarParser.Read_stmtContext ctx) { }
	
	@Override public void enterWrite_stmt(LittleGrammarParser.Write_stmtContext ctx) {
		if ( ctx.id_list() != null && currentSymbolTable != null) {
			this.ir.generateWrite(ctx.id_list().getText());
		}
	}
	
	@Override public void exitWrite_stmt(LittleGrammarParser.Write_stmtContext ctx) { }
	
	@Override public void enterReturn_stmt(LittleGrammarParser.Return_stmtContext ctx) { }
	
	@Override public void exitReturn_stmt(LittleGrammarParser.Return_stmtContext ctx) { }
	
	@Override public void enterExpr(LittleGrammarParser.ExprContext ctx) {
		if (ctx.expr_prefix() != null && ctx.factor() != null) {
			this.insideExpression = true;
		}
	}
	
	@Override public void exitExpr(LittleGrammarParser.ExprContext ctx) {
		if (ctx != null) {
			//System.out.println("Factor: " + ctx.factor().getText());

			this.insideExpression = false;
		}
	}
	
	@Override public void enterExpr_prefix(LittleGrammarParser.Expr_prefixContext ctx) {
		if(ctx != null && ctx.factor() != null) {
			//case that expr_prefix().expr_prefix() is null

			//this.ir.queueMath(ctx.factor().getText());
		}
	}

	@Override public void exitExpr_prefix(LittleGrammarParser.Expr_prefixContext ctx) {
		if (ctx.expr_prefix() == null) {

		}
		else if (ctx.expr_prefix() != null) {

		}
	}

	@Override public void enterFactor(LittleGrammarParser.FactorContext ctx) {
		this.insideFactor = true;
		if (ctx.postfix_expr() != null) {

		}

	}
	
	@Override public void exitFactor(LittleGrammarParser.FactorContext ctx) {
		this.insideFactor = false;

	}
	
	@Override public void enterFactor_prefix(LittleGrammarParser.Factor_prefixContext ctx) {
		if (ctx.postfix_expr() != null && ctx.mulop() != null && insideAssignment) {
		}
	}
	
	@Override public void exitFactor_prefix(LittleGrammarParser.Factor_prefixContext ctx) { }
	
	@Override public void enterPostfix_expr(LittleGrammarParser.Postfix_exprContext ctx) {
		if (ctx.primary() != null && insideAssignment && ctx.primary().getChildCount() == 1) {
}
	}
	
	@Override public void exitPostfix_expr(LittleGrammarParser.Postfix_exprContext ctx) { }
	
	@Override public void enterCall_expr(LittleGrammarParser.Call_exprContext ctx) { }
	
	@Override public void exitCall_expr(LittleGrammarParser.Call_exprContext ctx) { }
	
	@Override public void enterExpr_list(LittleGrammarParser.Expr_listContext ctx) { }
	
	@Override public void exitExpr_list(LittleGrammarParser.Expr_listContext ctx) { }
	
	@Override public void enterExpr_list_tail(LittleGrammarParser.Expr_list_tailContext ctx) { }
	
	@Override public void exitExpr_list_tail(LittleGrammarParser.Expr_list_tailContext ctx) { }

	@Override public void enterPrimaryExpr(LittleGrammarParser.PrimaryExprContext ctx) { }

	@Override public void exitPrimaryExpr(LittleGrammarParser.PrimaryExprContext ctx) { }

	@Override public void enterPrimaryID(LittleGrammarParser.PrimaryIDContext ctx) {
//		primaryHandler(ctx.getText());
//		primaryNodeHandler(ctx.getText());

	}

	@Override public void exitPrimaryID(LittleGrammarParser.PrimaryIDContext ctx) { }

	@Override public void enterPrimaryINT(LittleGrammarParser.PrimaryINTContext ctx) {
//		primaryHandler(ctx.getText());
//		primaryNodeHandler(ctx.getText());

	}

	@Override public void exitPrimaryINT(LittleGrammarParser.PrimaryINTContext ctx) { }

	@Override public void enterPrimaryFLOAT(LittleGrammarParser.PrimaryFLOATContext ctx) {
//		primaryHandler(ctx.getText());
//		primaryNodeHandler(ctx.getText());
	}

	@Override public void exitPrimaryFLOAT(LittleGrammarParser.PrimaryFLOATContext ctx) { }

	@Override public void enterAddop(LittleGrammarParser.AddopContext ctx) {
		if (!ctx.getText().equals("")) {
//			this.pushOperator(new String[]{ctx.getText(), 0});

		}
	}
	
	@Override public void exitAddop(LittleGrammarParser.AddopContext ctx) { }
	
	@Override public void enterMulop(LittleGrammarParser.MulopContext ctx) {
		if (!ctx.getText().equals("")) {
//			this.pushOperator(new String[]{ctx.getText(), 1});
		}

	}
	
	@Override public void exitMulop(LittleGrammarParser.MulopContext ctx) {
		if (!ctx.getText().equals("")) {
		}
	}
	
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
	
	@Override public void enterCond(LittleGrammarParser.CondContext ctx) {
		this.insideConditional = true;
		if (ctx.expr() != null && ctx.compop() != null) {

			this.ir.generateConditional(ctx.getText());
		}
	}
	
	@Override public void exitCond(LittleGrammarParser.CondContext ctx) {
		this.insideConditional = false;

		if (ctx.expr() != null) {
			String operator = ctx.compop().getText();

//			ir.generateConditional(operator);
			//System.out.println("--------------------inside enterCompop--------------------");
		}
	}
	
	@Override public void enterCompop(LittleGrammarParser.CompopContext ctx) {

	}
	
	@Override public void exitCompop(LittleGrammarParser.CompopContext ctx) { }
	
	@Override public void enterWhile_stmt(LittleGrammarParser.While_stmtContext ctx) {

		// when we enter an while statement, create a new block symbol table and
		// increment our class variable, block
		if (ctx.cond() != null) {
			this.block += 1;
			SymbolTable newBlockSymTable = new SymbolTable("BLOCK " + block);
			this.symbolTableList.add(newBlockSymTable);
			this.currentSymbolTable = newBlockSymTable;

			this.ir.generateLabel("while");
		}
	}
	
	@Override public void exitWhile_stmt(LittleGrammarParser.While_stmtContext ctx) {
	}

	@Override public void enterEveryRule(ParserRuleContext ctx) { }
	
	@Override public void exitEveryRule(ParserRuleContext ctx) { }
	
	@Override public void visitTerminal(TerminalNode node) { }
	
	@Override public void visitErrorNode(ErrorNode node) { }
//	private void primaryHandler(String primary) {
//		if (this.insideAssignment && !primary.equals("")) {
//			if (this.expressionStack.size() != 0 && this.expressionStack.peek().matches("[*/+-]") && this.insideExpression) {
//
//				String operator = this.expressionStack.pop();
//
//				String value1 = this.expressionStack.pop();
//				String value2 = primary;
//				ASTNode root;
//				if (operator.equals("*") || operator.equals("/")) {
//					root = new ASTNode(ASTNode.ASTNodeType.MulExpr, operator, 20);
//				} else {
//					root = new ASTNode(ASTNode.ASTNodeType.AddExpr, operator, 10);
//				}
//				ASTNode lc = new ASTNode(ASTNode.ASTNodeType.VarRef, value1, 5);
//				ASTNode rc = new ASTNode(ASTNode.ASTNodeType.VarRef, value2, 5);
//				root.leftChild = lc;
//				root.rightChild = rc;
//
//				this.partialExpressionNodes.add(root);
//
//
////				System.out.println("EXPRESSION STACK BEFORE");
////				for (String s : this.expressionStack) {
////					System.out.println(s);
////				}
////				switch(operator) {
////					case "*":
////						if (value1.contains(".") || value2.contains(".")) {
////							this.ir.generateMultFloat(value1, value2);
////
////						}
////						else {
////							this.ir.generateMultInt(value1, value2);
////						}
////						break;
////
////					case "/":
////						if (value1.contains(".") || value2.contains(".")) {
////							this.ir.generateDivFloat(value1, value2);
////						}
////						else {
////							this.ir.generateDivInt(value1, value2);
////						}
////						break;
////
////					case "+":
////						if (value1.contains(".") || value2.contains(".")) {
////							this.ir.generateAddFloat(value1, value2);
////
////						}
////						else {
////							this.ir.generateAddInt(value1, value2);
////						}
////						break;
////					case "-":
////
////						if (value1.contains(".") || value2.contains(".")) {
////							this.ir.generateSubFloat(value1, value2);
////
////						}
////						else {
////							this.ir.generateSubInt(value1, value2);
////						}
////						break;
////					default:
////						System.out.println("CTX GET TEXT NOT * / + -");
////				}
//////
//////				System.out.println("EXPRESSION STACK AFTER");
//////				for (String s : this.expressionStack) {
//////					System.out.println(s);
//////				}
//////
//////
////			}
//			}
//			else {
//				this.expressionStack.push(primary);
//			}
//
//
//		}
//	}
	private void primaryNodeHandler(String primary) {
		if (this.insideAssignment && !primary.equals("")) {
			System.out.printf("\nPushing new primary node: %s\n", primary);
//			this.outputStack.push(new ASTNode(ASTNode.ASTNodeType.VarRef, primary, 5));
			this.outputStack.push(primary);
		}
	}

	private void pushOperator(String[] operatorAndPrecendence) {
		String operator = operatorAndPrecendence[0];
		int precedence = Integer.parseInt(operatorAndPrecendence[1]);

		while (Integer.parseInt(this.operatorStack.peek()[1]) > precedence && !this.operatorStack.peek()[0].equals("(")) {
			this.outputStack.push(this.operatorStack.pop()[0]);
		}

		this.operatorStack.push(new String[]{operator, precedence + ""});

	}

	private int evaluatePostfix(String expr) {
		Stack<Integer> stack = new Stack<>();
		String[] tokens = expr.split("\\s+");
		for (int i = 0; i < tokens.length; i++) {
			String token = tokens[i];
			//System.out.printf("TOKEN: %s\n", token);
			if (token.matches("[*/+-]")) {
				int number1 = stack.pop();
				int number2 = stack.pop();

				switch(token) {
					case "*":
						stack.push(number2 * number1);
						break;
					case "/":
						stack.push(number2 / number1);
						break;
					case "+":
						stack.push(number2 + number1);
						break;
					case "-":
						stack.push(number2 - number1);
						break;
				}
			} else {
				stack.push(Integer.parseInt(tokens[i]));
			}
		}
		return stack.pop();
	}


}