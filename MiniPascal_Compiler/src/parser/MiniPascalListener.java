// Generated from java-escape by ANTLR 4.11.1
package parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MiniPascalParser}.
 */
public interface MiniPascalListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MiniPascalParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(MiniPascalParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(MiniPascalParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(MiniPascalParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(MiniPascalParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVarDeclaration(MiniPascalParser.VarDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVarDeclaration(MiniPascalParser.VarDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalParser#varDeclList}.
	 * @param ctx the parse tree
	 */
	void enterVarDeclList(MiniPascalParser.VarDeclListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalParser#varDeclList}.
	 * @param ctx the parse tree
	 */
	void exitVarDeclList(MiniPascalParser.VarDeclListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void enterVarDecl(MiniPascalParser.VarDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void exitVarDecl(MiniPascalParser.VarDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(MiniPascalParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(MiniPascalParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(MiniPascalParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(MiniPascalParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalParser#functionStatement}.
	 * @param ctx the parse tree
	 */
	void enterFunctionStatement(MiniPascalParser.FunctionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalParser#functionStatement}.
	 * @param ctx the parse tree
	 */
	void exitFunctionStatement(MiniPascalParser.FunctionStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalParser#compoundStatement}.
	 * @param ctx the parse tree
	 */
	void enterCompoundStatement(MiniPascalParser.CompoundStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalParser#compoundStatement}.
	 * @param ctx the parse tree
	 */
	void exitCompoundStatement(MiniPascalParser.CompoundStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalParser#statementList}.
	 * @param ctx the parse tree
	 */
	void enterStatementList(MiniPascalParser.StatementListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalParser#statementList}.
	 * @param ctx the parse tree
	 */
	void exitStatementList(MiniPascalParser.StatementListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalParser#assignmentStatement}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentStatement(MiniPascalParser.AssignmentStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalParser#assignmentStatement}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentStatement(MiniPascalParser.AssignmentStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(MiniPascalParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(MiniPascalParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(MiniPascalParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(MiniPascalParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalParser#procedureCall}.
	 * @param ctx the parse tree
	 */
	void enterProcedureCall(MiniPascalParser.ProcedureCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalParser#procedureCall}.
	 * @param ctx the parse tree
	 */
	void exitProcedureCall(MiniPascalParser.ProcedureCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void enterArgumentList(MiniPascalParser.ArgumentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void exitArgumentList(MiniPascalParser.ArgumentListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(MiniPascalParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(MiniPascalParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalParser#simpleExpression}.
	 * @param ctx the parse tree
	 */
	void enterSimpleExpression(MiniPascalParser.SimpleExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalParser#simpleExpression}.
	 * @param ctx the parse tree
	 */
	void exitSimpleExpression(MiniPascalParser.SimpleExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(MiniPascalParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(MiniPascalParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(MiniPascalParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(MiniPascalParser.FactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(MiniPascalParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(MiniPascalParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterConstant(MiniPascalParser.ConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitConstant(MiniPascalParser.ConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalParser#relop}.
	 * @param ctx the parse tree
	 */
	void enterRelop(MiniPascalParser.RelopContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalParser#relop}.
	 * @param ctx the parse tree
	 */
	void exitRelop(MiniPascalParser.RelopContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalParser#addop}.
	 * @param ctx the parse tree
	 */
	void enterAddop(MiniPascalParser.AddopContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalParser#addop}.
	 * @param ctx the parse tree
	 */
	void exitAddop(MiniPascalParser.AddopContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalParser#mulop}.
	 * @param ctx the parse tree
	 */
	void enterMulop(MiniPascalParser.MulopContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalParser#mulop}.
	 * @param ctx the parse tree
	 */
	void exitMulop(MiniPascalParser.MulopContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalParser#arrayType}.
	 * @param ctx the parse tree
	 */
	void enterArrayType(MiniPascalParser.ArrayTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalParser#arrayType}.
	 * @param ctx the parse tree
	 */
	void exitArrayType(MiniPascalParser.ArrayTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalParser#arrayDecList}.
	 * @param ctx the parse tree
	 */
	void enterArrayDecList(MiniPascalParser.ArrayDecListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalParser#arrayDecList}.
	 * @param ctx the parse tree
	 */
	void exitArrayDecList(MiniPascalParser.ArrayDecListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalParser#arrayDec}.
	 * @param ctx the parse tree
	 */
	void enterArrayDec(MiniPascalParser.ArrayDecContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalParser#arrayDec}.
	 * @param ctx the parse tree
	 */
	void exitArrayDec(MiniPascalParser.ArrayDecContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalParser#typeList}.
	 * @param ctx the parse tree
	 */
	void enterTypeList(MiniPascalParser.TypeListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalParser#typeList}.
	 * @param ctx the parse tree
	 */
	void exitTypeList(MiniPascalParser.TypeListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalParser#componentType}.
	 * @param ctx the parse tree
	 */
	void enterComponentType(MiniPascalParser.ComponentTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalParser#componentType}.
	 * @param ctx the parse tree
	 */
	void exitComponentType(MiniPascalParser.ComponentTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalParser#endType}.
	 * @param ctx the parse tree
	 */
	void enterEndType(MiniPascalParser.EndTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalParser#endType}.
	 * @param ctx the parse tree
	 */
	void exitEndType(MiniPascalParser.EndTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalParser#indexType}.
	 * @param ctx the parse tree
	 */
	void enterIndexType(MiniPascalParser.IndexTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalParser#indexType}.
	 * @param ctx the parse tree
	 */
	void exitIndexType(MiniPascalParser.IndexTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalParser#simpleType}.
	 * @param ctx the parse tree
	 */
	void enterSimpleType(MiniPascalParser.SimpleTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalParser#simpleType}.
	 * @param ctx the parse tree
	 */
	void exitSimpleType(MiniPascalParser.SimpleTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalParser#scalarType}.
	 * @param ctx the parse tree
	 */
	void enterScalarType(MiniPascalParser.ScalarTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalParser#scalarType}.
	 * @param ctx the parse tree
	 */
	void exitScalarType(MiniPascalParser.ScalarTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalParser#identifierList}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierList(MiniPascalParser.IdentifierListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalParser#identifierList}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierList(MiniPascalParser.IdentifierListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalParser#typeIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterTypeIdentifier(MiniPascalParser.TypeIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalParser#typeIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitTypeIdentifier(MiniPascalParser.TypeIdentifierContext ctx);
}