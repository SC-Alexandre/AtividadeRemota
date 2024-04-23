package calculadora;

import org.lsmp.djep.djep.DJep;
import org.nfunk.jep.Node;
import org.nfunk.jep.ParseException;

/**
 *
 * @author Alexandre dos Santos Cunha <alexandre.sc115@gmail.com>
 * @date 21/04/2024
 * @brief Class Derivadas
 */

public class Derivadas {

    private String funcao = "";
    
    DJep djep;
    Node nodoFuncao;
    Node nodoDerivada;
    
    public Derivadas(){
        //...
    }
    
    public void setFuncaoADerivar(String funcao){
        this.funcao = funcao;
    }
    
    public String getFuncaoDerivada(){     
        return this.funcao;
    }
    
    public void derivar(){
    
        try{
        
            this.djep = new DJep();
            
            this.djep.addStandardFunctions();
            
            this.djep.addStandardConstants();
            
            this.djep.addComplex();
            
            this.djep.setAllowUndeclared(true);
            
            this.djep.setAllowAssignment(true);
            
            this.djep.setImplicitMul(true);
            
            this.djep.addStandardDiffRules();
            
            this.nodoFuncao = this.djep.parse(this.funcao); //
            
            Node diff = this.djep.differentiate(nodoFuncao,"x");
            
            this.nodoDerivada = this.djep.simplify(diff);
            
            this.funcao = this.djep.toString(this.nodoDerivada);
            
        }catch (ParseException e) {
            System.out.println("ERRO" + e.getErrorInfo());
        }
    }
    
}
