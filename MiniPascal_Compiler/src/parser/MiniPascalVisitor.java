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
	 * Visit a parse tree produced by {@link MiniPascalParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(MiniPascalParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalParser#estructura_codigo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEstructura_codigo(MiniPascalParser.Estructura_codigoContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalParser#librerias}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLibrerias(MiniPascalParser.LibreriasContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalParser#declaracion_iniciacion_variables}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracion_iniciacion_variables(MiniPascalParser.Declaracion_iniciacion_variablesContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalParser#declaracion_variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracion_variable(MiniPascalParser.Declaracion_variableContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalParser#inicializar_variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInicializar_variable(MiniPascalParser.Inicializar_variableContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalParser#tipo_de_dato}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo_de_dato(MiniPascalParser.Tipo_de_datoContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalParser#declaracion_subprogramas}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracion_subprogramas(MiniPascalParser.Declaracion_subprogramasContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalParser#declarar_funcion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarar_funcion(MiniPascalParser.Declarar_funcionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalParser#declarar_metodo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarar_metodo(MiniPascalParser.Declarar_metodoContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalParser#argumentos}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentos(MiniPascalParser.ArgumentosContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalParser#inicio_de_programa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInicio_de_programa(MiniPascalParser.Inicio_de_programaContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalParser#lista_de_declaraciones}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLista_de_declaraciones(MiniPascalParser.Lista_de_declaracionesContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalParser#declaraciones}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaraciones(MiniPascalParser.DeclaracionesContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalParser#sentencia_asignacion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentencia_asignacion(MiniPascalParser.Sentencia_asignacionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalParser#sentencia_if}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentencia_if(MiniPascalParser.Sentencia_ifContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalParser#sentencia_while}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentencia_while(MiniPascalParser.Sentencia_whileContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalParser#sentencia_for}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentencia_for(MiniPascalParser.Sentencia_forContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalParser#sentencia_write}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentencia_write(MiniPascalParser.Sentencia_writeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalParser#sentencia_read}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentencia_read(MiniPascalParser.Sentencia_readContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalParser#condicion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondicion(MiniPascalParser.CondicionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalParser#relational_operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelational_operator(MiniPascalParser.Relational_operatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpresion(MiniPascalParser.ExpresionContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniPascalParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(MiniPascalParser.TermContext ctx);
}