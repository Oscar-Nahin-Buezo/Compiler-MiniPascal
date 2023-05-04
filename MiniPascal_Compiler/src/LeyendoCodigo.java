import parser.MiniPascalBaseListener;
import parser.MiniPascalParser;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
import javax.swing.*;

import org.antlr.v4.runtime.tree.ParseTree;

public class LeyendoCodigo extends MiniPascalBaseListener {
    private Map<String, Object> variables = new HashMap<>();
    private Map<String, variablex> pila = new HashMap<>();
    private String salida_input="";

}
