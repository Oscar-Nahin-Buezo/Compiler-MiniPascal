package parser;

import org.antlr.v4.runtime.*;

import java.util.Collections;
import java.util.List;

public class ErrorListener extends BaseErrorListener{
    public static boolean hasError = false;

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer,
                            Object offendingSymbol, int line, int charPositionInLine,
                            String msg,
                            RecognitionException e) {
                hasError = true;
                List<String> stack = ((Parser) recognizer).getRuleInvocationStack();
                Collections.reverse(stack);
                System.err.println("Se ha detectado un error de Sintaxis.");
                System.err.println("Token " +  " \" " +  ((Token) offendingSymbol).getText() +  " \" "
                                    +  " (Linea " + line + ", Columna " + (charPositionInLine + 1) + ")"
                                    + ": " + msg);
                System.err.println("Bloque de Error del archivo G4: " + stack);
    }
}
