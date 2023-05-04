package parser;

import Expresiones.Program;

public class AntlrToProgram extends MiniPascalBaseVisitor<Program> {
    @Override
    public Program visitProgram(MiniPascalParser.ProgramContext ctx) {
        Program prog = new Program();
        return prog;
    }
}

