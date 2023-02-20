// Generated from java-escape by ANTLR 4.11.1
package parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MiniPascalParser}.
 */
public interface MiniPascalListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MiniPascalParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(MiniPascalParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(MiniPascalParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalParser#estructura_codigo}.
	 * @param ctx the parse tree
	 */
	void enterEstructura_codigo(MiniPascalParser.Estructura_codigoContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalParser#estructura_codigo}.
	 * @param ctx the parse tree
	 */
	void exitEstructura_codigo(MiniPascalParser.Estructura_codigoContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalParser#librerias}.
	 * @param ctx the parse tree
	 */
	void enterLibrerias(MiniPascalParser.LibreriasContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalParser#librerias}.
	 * @param ctx the parse tree
	 */
	void exitLibrerias(MiniPascalParser.LibreriasContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalParser#declaracion_iniciacion_variables}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracion_iniciacion_variables(MiniPascalParser.Declaracion_iniciacion_variablesContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalParser#declaracion_iniciacion_variables}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracion_iniciacion_variables(MiniPascalParser.Declaracion_iniciacion_variablesContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalParser#declaracion_variable}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracion_variable(MiniPascalParser.Declaracion_variableContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalParser#declaracion_variable}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracion_variable(MiniPascalParser.Declaracion_variableContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalParser#inicializar_variable}.
	 * @param ctx the parse tree
	 */
	void enterInicializar_variable(MiniPascalParser.Inicializar_variableContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalParser#inicializar_variable}.
	 * @param ctx the parse tree
	 */
	void exitInicializar_variable(MiniPascalParser.Inicializar_variableContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalParser#tipo_de_dato}.
	 * @param ctx the parse tree
	 */
	void enterTipo_de_dato(MiniPascalParser.Tipo_de_datoContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalParser#tipo_de_dato}.
	 * @param ctx the parse tree
	 */
	void exitTipo_de_dato(MiniPascalParser.Tipo_de_datoContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalParser#declaracion_subprogramas}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracion_subprogramas(MiniPascalParser.Declaracion_subprogramasContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalParser#declaracion_subprogramas}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracion_subprogramas(MiniPascalParser.Declaracion_subprogramasContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalParser#declarar_funcion}.
	 * @param ctx the parse tree
	 */
	void enterDeclarar_funcion(MiniPascalParser.Declarar_funcionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalParser#declarar_funcion}.
	 * @param ctx the parse tree
	 */
	void exitDeclarar_funcion(MiniPascalParser.Declarar_funcionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalParser#declarar_metodo}.
	 * @param ctx the parse tree
	 */
	void enterDeclarar_metodo(MiniPascalParser.Declarar_metodoContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalParser#declarar_metodo}.
	 * @param ctx the parse tree
	 */
	void exitDeclarar_metodo(MiniPascalParser.Declarar_metodoContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalParser#argumentos}.
	 * @param ctx the parse tree
	 */
	void enterArgumentos(MiniPascalParser.ArgumentosContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalParser#argumentos}.
	 * @param ctx the parse tree
	 */
	void exitArgumentos(MiniPascalParser.ArgumentosContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalParser#inicio_de_programa}.
	 * @param ctx the parse tree
	 */
	void enterInicio_de_programa(MiniPascalParser.Inicio_de_programaContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalParser#inicio_de_programa}.
	 * @param ctx the parse tree
	 */
	void exitInicio_de_programa(MiniPascalParser.Inicio_de_programaContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalParser#lista_de_declaraciones}.
	 * @param ctx the parse tree
	 */
	void enterLista_de_declaraciones(MiniPascalParser.Lista_de_declaracionesContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalParser#lista_de_declaraciones}.
	 * @param ctx the parse tree
	 */
	void exitLista_de_declaraciones(MiniPascalParser.Lista_de_declaracionesContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalParser#declaraciones}.
	 * @param ctx the parse tree
	 */
	void enterDeclaraciones(MiniPascalParser.DeclaracionesContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalParser#declaraciones}.
	 * @param ctx the parse tree
	 */
	void exitDeclaraciones(MiniPascalParser.DeclaracionesContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalParser#sentencia_asignacion}.
	 * @param ctx the parse tree
	 */
	void enterSentencia_asignacion(MiniPascalParser.Sentencia_asignacionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalParser#sentencia_asignacion}.
	 * @param ctx the parse tree
	 */
	void exitSentencia_asignacion(MiniPascalParser.Sentencia_asignacionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalParser#sentencia_if}.
	 * @param ctx the parse tree
	 */
	void enterSentencia_if(MiniPascalParser.Sentencia_ifContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalParser#sentencia_if}.
	 * @param ctx the parse tree
	 */
	void exitSentencia_if(MiniPascalParser.Sentencia_ifContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalParser#sentencia_while}.
	 * @param ctx the parse tree
	 */
	void enterSentencia_while(MiniPascalParser.Sentencia_whileContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalParser#sentencia_while}.
	 * @param ctx the parse tree
	 */
	void exitSentencia_while(MiniPascalParser.Sentencia_whileContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalParser#sentencia_for}.
	 * @param ctx the parse tree
	 */
	void enterSentencia_for(MiniPascalParser.Sentencia_forContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalParser#sentencia_for}.
	 * @param ctx the parse tree
	 */
	void exitSentencia_for(MiniPascalParser.Sentencia_forContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalParser#sentencia_write}.
	 * @param ctx the parse tree
	 */
	void enterSentencia_write(MiniPascalParser.Sentencia_writeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalParser#sentencia_write}.
	 * @param ctx the parse tree
	 */
	void exitSentencia_write(MiniPascalParser.Sentencia_writeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalParser#sentencia_read}.
	 * @param ctx the parse tree
	 */
	void enterSentencia_read(MiniPascalParser.Sentencia_readContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalParser#sentencia_read}.
	 * @param ctx the parse tree
	 */
	void exitSentencia_read(MiniPascalParser.Sentencia_readContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalParser#condicion}.
	 * @param ctx the parse tree
	 */
	void enterCondicion(MiniPascalParser.CondicionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalParser#condicion}.
	 * @param ctx the parse tree
	 */
	void exitCondicion(MiniPascalParser.CondicionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalParser#relational_operator}.
	 * @param ctx the parse tree
	 */
	void enterRelational_operator(MiniPascalParser.Relational_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalParser#relational_operator}.
	 * @param ctx the parse tree
	 */
	void exitRelational_operator(MiniPascalParser.Relational_operatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniPascalParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExpresion(MiniPascalParser.ExpresionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniPascalParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExpresion(MiniPascalParser.ExpresionContext ctx);
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
}