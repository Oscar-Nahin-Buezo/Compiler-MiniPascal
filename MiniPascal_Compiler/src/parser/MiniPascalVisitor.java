// Generated from java-escape by ANTLR 4.11.1
package parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MiniPascalParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MiniPascalVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MiniPascalParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(MiniPascalParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(MiniPascalParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalParser#varDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDeclaration(MiniPascalParser.VarDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalParser#varDeclList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDeclList(MiniPascalParser.VarDeclListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalParser#varDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDecl(MiniPascalParser.VarDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(MiniPascalParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(MiniPascalParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalParser#functionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionStatement(MiniPascalParser.FunctionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalParser#compoundStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompoundStatement(MiniPascalParser.CompoundStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalParser#statementList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementList(MiniPascalParser.StatementListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalParser#assignmentStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentStatement(MiniPascalParser.AssignmentStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(MiniPascalParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalParser#whileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(MiniPascalParser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalParser#procedureCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcedureCall(MiniPascalParser.ProcedureCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalParser#argumentList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentList(MiniPascalParser.ArgumentListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(MiniPascalParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalParser#simpleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleExpression(MiniPascalParser.SimpleExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(MiniPascalParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(MiniPascalParser.FactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(MiniPascalParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalParser#constant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstant(MiniPascalParser.ConstantContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalParser#relop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelop(MiniPascalParser.RelopContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalParser#addop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddop(MiniPascalParser.AddopContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalParser#mulop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulop(MiniPascalParser.MulopContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalParser#arrayType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayType(MiniPascalParser.ArrayTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalParser#arrayDecList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayDecList(MiniPascalParser.ArrayDecListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalParser#arrayDec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayDec(MiniPascalParser.ArrayDecContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalParser#typeList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeList(MiniPascalParser.TypeListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalParser#componentType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComponentType(MiniPascalParser.ComponentTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalParser#endType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEndType(MiniPascalParser.EndTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalParser#indexType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexType(MiniPascalParser.IndexTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalParser#simpleType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleType(MiniPascalParser.SimpleTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalParser#scalarType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScalarType(MiniPascalParser.ScalarTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalParser#identifierList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierList(MiniPascalParser.IdentifierListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalParser#typeIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeIdentifier(MiniPascalParser.TypeIdentifierContext ctx);
}