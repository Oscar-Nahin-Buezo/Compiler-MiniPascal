package Expresiones;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class ExpressionProcessor {
    List<Expresiones> list;
    public Map <String, Integer> values;

    public ExpressionProcessor(List<Expresiones> list){
        this.list = list;
        values = new HashMap<>();
    }

    public List<String> getEvaluationResults(){
        List<String> evaluations = new ArrayList<>();
        for(Expresiones e : list){
        }
        return evaluations;
    }
}
