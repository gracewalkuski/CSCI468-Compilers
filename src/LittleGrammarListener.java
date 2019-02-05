// Generated from LittleGrammar.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LittleGrammarParser}.
 */
public interface LittleGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LittleGrammarParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(LittleGrammarParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link LittleGrammarParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(LittleGrammarParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link LittleGrammarParser#id}.
	 * @param ctx the parse tree
	 */
	void enterId(LittleGrammarParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by {@link LittleGrammarParser#id}.
	 * @param ctx the parse tree
	 */
	void exitId(LittleGrammarParser.IdContext ctx);
	/**
	 * Enter a parse tree produced by {@link LittleGrammarParser#pgm_body}.
	 * @param ctx the parse tree
	 */
	void enterPgm_body(LittleGrammarParser.Pgm_bodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link LittleGrammarParser#pgm_body}.
	 * @param ctx the parse tree
	 */
	void exitPgm_body(LittleGrammarParser.Pgm_bodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link LittleGrammarParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(LittleGrammarParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link LittleGrammarParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(LittleGrammarParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link LittleGrammarParser#string_decl}.
	 * @param ctx the parse tree
	 */
	void enterString_decl(LittleGrammarParser.String_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link LittleGrammarParser#string_decl}.
	 * @param ctx the parse tree
	 */
	void exitString_decl(LittleGrammarParser.String_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link LittleGrammarParser#str}.
	 * @param ctx the parse tree
	 */
	void enterStr(LittleGrammarParser.StrContext ctx);
	/**
	 * Exit a parse tree produced by {@link LittleGrammarParser#str}.
	 * @param ctx the parse tree
	 */
	void exitStr(LittleGrammarParser.StrContext ctx);
	/**
	 * Enter a parse tree produced by {@link LittleGrammarParser#var_decl}.
	 * @param ctx the parse tree
	 */
	void enterVar_decl(LittleGrammarParser.Var_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link LittleGrammarParser#var_decl}.
	 * @param ctx the parse tree
	 */
	void exitVar_decl(LittleGrammarParser.Var_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link LittleGrammarParser#var_type}.
	 * @param ctx the parse tree
	 */
	void enterVar_type(LittleGrammarParser.Var_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LittleGrammarParser#var_type}.
	 * @param ctx the parse tree
	 */
	void exitVar_type(LittleGrammarParser.Var_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LittleGrammarParser#any_type}.
	 * @param ctx the parse tree
	 */
	void enterAny_type(LittleGrammarParser.Any_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LittleGrammarParser#any_type}.
	 * @param ctx the parse tree
	 */
	void exitAny_type(LittleGrammarParser.Any_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LittleGrammarParser#id_list}.
	 * @param ctx the parse tree
	 */
	void enterId_list(LittleGrammarParser.Id_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link LittleGrammarParser#id_list}.
	 * @param ctx the parse tree
	 */
	void exitId_list(LittleGrammarParser.Id_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link LittleGrammarParser#id_tail}.
	 * @param ctx the parse tree
	 */
	void enterId_tail(LittleGrammarParser.Id_tailContext ctx);
	/**
	 * Exit a parse tree produced by {@link LittleGrammarParser#id_tail}.
	 * @param ctx the parse tree
	 */
	void exitId_tail(LittleGrammarParser.Id_tailContext ctx);
	/**
	 * Enter a parse tree produced by {@link LittleGrammarParser#param_decl_list}.
	 * @param ctx the parse tree
	 */
	void enterParam_decl_list(LittleGrammarParser.Param_decl_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link LittleGrammarParser#param_decl_list}.
	 * @param ctx the parse tree
	 */
	void exitParam_decl_list(LittleGrammarParser.Param_decl_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link LittleGrammarParser#param_decl}.
	 * @param ctx the parse tree
	 */
	void enterParam_decl(LittleGrammarParser.Param_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link LittleGrammarParser#param_decl}.
	 * @param ctx the parse tree
	 */
	void exitParam_decl(LittleGrammarParser.Param_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link LittleGrammarParser#param_decl_tail}.
	 * @param ctx the parse tree
	 */
	void enterParam_decl_tail(LittleGrammarParser.Param_decl_tailContext ctx);
	/**
	 * Exit a parse tree produced by {@link LittleGrammarParser#param_decl_tail}.
	 * @param ctx the parse tree
	 */
	void exitParam_decl_tail(LittleGrammarParser.Param_decl_tailContext ctx);
	/**
	 * Enter a parse tree produced by {@link LittleGrammarParser#func_declarations}.
	 * @param ctx the parse tree
	 */
	void enterFunc_declarations(LittleGrammarParser.Func_declarationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link LittleGrammarParser#func_declarations}.
	 * @param ctx the parse tree
	 */
	void exitFunc_declarations(LittleGrammarParser.Func_declarationsContext ctx);
	/**
	 * Enter a parse tree produced by {@link LittleGrammarParser#func_decl}.
	 * @param ctx the parse tree
	 */
	void enterFunc_decl(LittleGrammarParser.Func_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link LittleGrammarParser#func_decl}.
	 * @param ctx the parse tree
	 */
	void exitFunc_decl(LittleGrammarParser.Func_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link LittleGrammarParser#func_body}.
	 * @param ctx the parse tree
	 */
	void enterFunc_body(LittleGrammarParser.Func_bodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link LittleGrammarParser#func_body}.
	 * @param ctx the parse tree
	 */
	void exitFunc_body(LittleGrammarParser.Func_bodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link LittleGrammarParser#stmt_list}.
	 * @param ctx the parse tree
	 */
	void enterStmt_list(LittleGrammarParser.Stmt_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link LittleGrammarParser#stmt_list}.
	 * @param ctx the parse tree
	 */
	void exitStmt_list(LittleGrammarParser.Stmt_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link LittleGrammarParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(LittleGrammarParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LittleGrammarParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(LittleGrammarParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LittleGrammarParser#base_stmt}.
	 * @param ctx the parse tree
	 */
	void enterBase_stmt(LittleGrammarParser.Base_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LittleGrammarParser#base_stmt}.
	 * @param ctx the parse tree
	 */
	void exitBase_stmt(LittleGrammarParser.Base_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LittleGrammarParser#assign_stmt}.
	 * @param ctx the parse tree
	 */
	void enterAssign_stmt(LittleGrammarParser.Assign_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LittleGrammarParser#assign_stmt}.
	 * @param ctx the parse tree
	 */
	void exitAssign_stmt(LittleGrammarParser.Assign_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LittleGrammarParser#assign_expr}.
	 * @param ctx the parse tree
	 */
	void enterAssign_expr(LittleGrammarParser.Assign_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link LittleGrammarParser#assign_expr}.
	 * @param ctx the parse tree
	 */
	void exitAssign_expr(LittleGrammarParser.Assign_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link LittleGrammarParser#read_stmt}.
	 * @param ctx the parse tree
	 */
	void enterRead_stmt(LittleGrammarParser.Read_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LittleGrammarParser#read_stmt}.
	 * @param ctx the parse tree
	 */
	void exitRead_stmt(LittleGrammarParser.Read_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LittleGrammarParser#write_stmt}.
	 * @param ctx the parse tree
	 */
	void enterWrite_stmt(LittleGrammarParser.Write_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LittleGrammarParser#write_stmt}.
	 * @param ctx the parse tree
	 */
	void exitWrite_stmt(LittleGrammarParser.Write_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LittleGrammarParser#return_stmt}.
	 * @param ctx the parse tree
	 */
	void enterReturn_stmt(LittleGrammarParser.Return_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LittleGrammarParser#return_stmt}.
	 * @param ctx the parse tree
	 */
	void exitReturn_stmt(LittleGrammarParser.Return_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LittleGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(LittleGrammarParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link LittleGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(LittleGrammarParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link LittleGrammarParser#expr_list_tail}.
	 * @param ctx the parse tree
	 */
	void enterExpr_list_tail(LittleGrammarParser.Expr_list_tailContext ctx);
	/**
	 * Exit a parse tree produced by {@link LittleGrammarParser#expr_list_tail}.
	 * @param ctx the parse tree
	 */
	void exitExpr_list_tail(LittleGrammarParser.Expr_list_tailContext ctx);
	/**
	 * Enter a parse tree produced by {@link LittleGrammarParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(LittleGrammarParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link LittleGrammarParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(LittleGrammarParser.PrimaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link LittleGrammarParser#addop}.
	 * @param ctx the parse tree
	 */
	void enterAddop(LittleGrammarParser.AddopContext ctx);
	/**
	 * Exit a parse tree produced by {@link LittleGrammarParser#addop}.
	 * @param ctx the parse tree
	 */
	void exitAddop(LittleGrammarParser.AddopContext ctx);
	/**
	 * Enter a parse tree produced by {@link LittleGrammarParser#mulop}.
	 * @param ctx the parse tree
	 */
	void enterMulop(LittleGrammarParser.MulopContext ctx);
	/**
	 * Exit a parse tree produced by {@link LittleGrammarParser#mulop}.
	 * @param ctx the parse tree
	 */
	void exitMulop(LittleGrammarParser.MulopContext ctx);
	/**
	 * Enter a parse tree produced by {@link LittleGrammarParser#if_stmt}.
	 * @param ctx the parse tree
	 */
	void enterIf_stmt(LittleGrammarParser.If_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LittleGrammarParser#if_stmt}.
	 * @param ctx the parse tree
	 */
	void exitIf_stmt(LittleGrammarParser.If_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LittleGrammarParser#else_part}.
	 * @param ctx the parse tree
	 */
	void enterElse_part(LittleGrammarParser.Else_partContext ctx);
	/**
	 * Exit a parse tree produced by {@link LittleGrammarParser#else_part}.
	 * @param ctx the parse tree
	 */
	void exitElse_part(LittleGrammarParser.Else_partContext ctx);
	/**
	 * Enter a parse tree produced by {@link LittleGrammarParser#cond}.
	 * @param ctx the parse tree
	 */
	void enterCond(LittleGrammarParser.CondContext ctx);
	/**
	 * Exit a parse tree produced by {@link LittleGrammarParser#cond}.
	 * @param ctx the parse tree
	 */
	void exitCond(LittleGrammarParser.CondContext ctx);
	/**
	 * Enter a parse tree produced by {@link LittleGrammarParser#compop}.
	 * @param ctx the parse tree
	 */
	void enterCompop(LittleGrammarParser.CompopContext ctx);
	/**
	 * Exit a parse tree produced by {@link LittleGrammarParser#compop}.
	 * @param ctx the parse tree
	 */
	void exitCompop(LittleGrammarParser.CompopContext ctx);
	/**
	 * Enter a parse tree produced by {@link LittleGrammarParser#while_stmt}.
	 * @param ctx the parse tree
	 */
	void enterWhile_stmt(LittleGrammarParser.While_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LittleGrammarParser#while_stmt}.
	 * @param ctx the parse tree
	 */
	void exitWhile_stmt(LittleGrammarParser.While_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LittleGrammarParser#intliteral}.
	 * @param ctx the parse tree
	 */
	void enterIntliteral(LittleGrammarParser.IntliteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link LittleGrammarParser#intliteral}.
	 * @param ctx the parse tree
	 */
	void exitIntliteral(LittleGrammarParser.IntliteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link LittleGrammarParser#floatliteral}.
	 * @param ctx the parse tree
	 */
	void enterFloatliteral(LittleGrammarParser.FloatliteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link LittleGrammarParser#floatliteral}.
	 * @param ctx the parse tree
	 */
	void exitFloatliteral(LittleGrammarParser.FloatliteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link LittleGrammarParser#strliteral}.
	 * @param ctx the parse tree
	 */
	void enterStrliteral(LittleGrammarParser.StrliteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link LittleGrammarParser#strliteral}.
	 * @param ctx the parse tree
	 */
	void exitStrliteral(LittleGrammarParser.StrliteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link LittleGrammarParser#newline}.
	 * @param ctx the parse tree
	 */
	void enterNewline(LittleGrammarParser.NewlineContext ctx);
	/**
	 * Exit a parse tree produced by {@link LittleGrammarParser#newline}.
	 * @param ctx the parse tree
	 */
	void exitNewline(LittleGrammarParser.NewlineContext ctx);
	/**
	 * Enter a parse tree produced by {@link LittleGrammarParser#comment}.
	 * @param ctx the parse tree
	 */
	void enterComment(LittleGrammarParser.CommentContext ctx);
	/**
	 * Exit a parse tree produced by {@link LittleGrammarParser#comment}.
	 * @param ctx the parse tree
	 */
	void exitComment(LittleGrammarParser.CommentContext ctx);
	/**
	 * Enter a parse tree produced by {@link LittleGrammarParser#keyword}.
	 * @param ctx the parse tree
	 */
	void enterKeyword(LittleGrammarParser.KeywordContext ctx);
	/**
	 * Exit a parse tree produced by {@link LittleGrammarParser#keyword}.
	 * @param ctx the parse tree
	 */
	void exitKeyword(LittleGrammarParser.KeywordContext ctx);
	/**
	 * Enter a parse tree produced by {@link LittleGrammarParser#op}.
	 * @param ctx the parse tree
	 */
	void enterOp(LittleGrammarParser.OpContext ctx);
	/**
	 * Exit a parse tree produced by {@link LittleGrammarParser#op}.
	 * @param ctx the parse tree
	 */
	void exitOp(LittleGrammarParser.OpContext ctx);
	/**
	 * Enter a parse tree produced by {@link LittleGrammarParser#ws}.
	 * @param ctx the parse tree
	 */
	void enterWs(LittleGrammarParser.WsContext ctx);
	/**
	 * Exit a parse tree produced by {@link LittleGrammarParser#ws}.
	 * @param ctx the parse tree
	 */
	void exitWs(LittleGrammarParser.WsContext ctx);
	/**
	 * Enter a parse tree produced by {@link LittleGrammarParser#digit}.
	 * @param ctx the parse tree
	 */
	void enterDigit(LittleGrammarParser.DigitContext ctx);
	/**
	 * Exit a parse tree produced by {@link LittleGrammarParser#digit}.
	 * @param ctx the parse tree
	 */
	void exitDigit(LittleGrammarParser.DigitContext ctx);
	/**
	 * Enter a parse tree produced by {@link LittleGrammarParser#letter}.
	 * @param ctx the parse tree
	 */
	void enterLetter(LittleGrammarParser.LetterContext ctx);
	/**
	 * Exit a parse tree produced by {@link LittleGrammarParser#letter}.
	 * @param ctx the parse tree
	 */
	void exitLetter(LittleGrammarParser.LetterContext ctx);
}