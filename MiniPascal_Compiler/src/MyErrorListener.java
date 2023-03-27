import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;

import java.util.BitSet;

public class MyErrorListener extends BaseErrorListener  {
    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
        System.err.println("Error de sintaxis en la línea " + line + ", posición " + charPositionInLine + ": " + msg);
    }

    @Override
    public void reportAmbiguity(Parser recognizer, DFA dfa, int startIndex, int stopIndex, boolean exact, BitSet ambigAlts, ATNConfigSet configs) {
        //System.err.println("Existen errores debido a ambiguedad ");
        //System.out.println("Informacion: ");
        //System.out.println("analizador sintáctico que encontró el conflicto de ambigüedad: "+recognizer.toString());
        //System.out.println("posicion de inicio del conflicto: "+startIndex);
       // System.out.println("posicion final del conflicto: "+stopIndex);
    }

    @Override
    public void reportAttemptingFullContext(Parser recognizer, DFA dfa, int startIndex, int stopIndex, BitSet conflictingAlts, ATNConfigSet configs) {
        //System.out.println("Error: analizador sintáctico intenta analizar un contexto completo (es decir, un conjunto completo de reglas de análisis) y falla debido a una ambigüedad o un error sintáctico");
        //System.out.println("Informacion: ");
        //System.out.println("analizador sintáctico que encontró el conflicto de ambigüedad: "+recognizer.toString());
        //System.out.println("posicion de inicio del conflicto: "+startIndex);
        //System.out.println("posicion final del conflicto: "+stopIndex);
    }

    @Override
    public void reportContextSensitivity(Parser recognizer, DFA dfa, int startIndex, int stopIndex, int prediction, ATNConfigSet configs) {
        //System.out.println("se encontro un conflicto de ambigüedad en el análisis y se necesita información adicional sobre el contexto para resolver la ambigüedad");
        //System.out.println("Informacion: ");
        //System.out.println("analizador sintáctico que encontró el conflicto de ambigüedad: "+recognizer.toString());
        //System.out.println("posicion de inicio del conflicto: "+startIndex);
        //System.out.println("posicion final del conflicto: "+stopIndex);

    }
}