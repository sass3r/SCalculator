/*
 * Copyright (C) 2013 Rafael Ramírez
 *
 *   SCalculator es software libre; puede redistribuirlo y/o modificarlo bajo 
 *   los términos de la Licencia Pública General GNU tal como se publica por 
 *   la Free Software Foundation; ya sea la versión 3 de la Licencia, o 
 *   (a su elección) cualquier versión posterior.
 *
 *   SCalculator se distribuye con la esperanza de que le sea útil, pero SIN 
 *   NINGUNA GARANTÍA; sin incluso la garantía implícita de MERCANTILIDAD o 
 *   IDONEIDAD PARA UN PROPÓSITO PARTICULAR. Vea la Licencia Pública 
 *   General GNU para más detalles.
 *
 *   Debería haber recibido una copia de la Licencia Pública General GNU
 *   junto con SCalculator; de lo contrario escriba a la Free Software Foundation, Inc.,
 *   51 Franklin Street, Fifth Floor, Boston, MA 02110-1301, EE. UU.
 *   También puede encontrar la licencia en la siguiente dirección 
 *   http://www.gnu.org/licenses/gpl.html
 */

package scalculator.op;

import edl.ListaSE;

/**
 * @author sass3r.net
 */

public class ExpresionEntera {
    ListaSE<Operacion> lop;
    String expr;
    
    public ExpresionEntera (String e){
        expr = new String(e);
        lop = new ListaSE<Operacion>();
    }
      
    public void cadena2Lista(){
        cadena2Lista(expr.length()-1,expr);
        
    }
    
    public void ordenarLista(){
        if(longitud()>1)
            lop = ordenarLista(longitud()-1, new ListaSE<Operacion>());

    }
    
    
    private ListaSE<Operacion> ordenarLista(int pos, ListaSE<Operacion> l){
        ListaSE<Operacion> res = null;
        Operacion op;
        String caracter;
        if(pos==0){
            op = acceder(pos);
            l.insertar(op);
            res = l;
        }else{
            op = acceder(pos);
            l.insertar(op);
            res = ordenarLista(--pos, l);
        }
        return res;
    }
    
    private void cadena2Lista(int pos, String e){
        String caracter;
        String nueva;       
        int entero;
        Operacion op;
        if(e.length() < 4){
            op = new Operacion();
            caracter = "" + e.charAt(pos);
            entero = Integer.parseInt(caracter);
            op.cambiarB(entero);
            caracter = "" + e.charAt(pos-1);
            op.cambiarOP(caracter);
            caracter = "" + e.charAt(pos-2);
            entero = Integer.parseInt(caracter);
            op.cambiarA(entero);
            lop.insertar(op);
        }else{
            op = new Operacion();
            caracter = "" + e.charAt(pos);
            entero = Integer.parseInt(caracter);
            op.cambiarB(entero);
            op.cambiarOP("" + e.charAt(pos-1));
            lop.insertar(op);
            nueva = e.substring(0, e.length()-2);
            cadena2Lista(pos-2,nueva);                                                    
        }
        
    }
    
    public void mostrarExpresion(){
        mostrarExpresion(0);
    }
    
    private void mostrarExpresion(int pos){
        if(lop.acceder(pos)!=null){
            if(lop.acceder(pos).obtenerA()!=null){
                lop.acceder(pos).mostrarOP(true);
                mostrarExpresion(++pos);
            }else{ 
                lop.acceder(pos).mostrarOP(false);
                mostrarExpresion(++pos);
            }
        }
    }
    
    public void cambiarExpr(String nexpr){
        expr = nexpr;
        lop = new ListaSE<Operacion>();
    }
        
    public int longitud(){
        return lop.longitud();
    }
    
    public Operacion acceder(int pos){
        return lop.acceder(pos);
    }
    
    public int evaluar(){
        int res = evaluar(longitud()-1);
        return res;
    }
    
    private int evaluar(int pos){
        int res;
        Operacion op;
        if(pos == 0){
            op = acceder(pos);
            res = op.calcular();
        }else{
            op = acceder(pos);
            op.cambiarA(evaluar(--pos));
            res = op.calcular();
        }
        return res;
    }
    
    public int cantDigitos(){
        return cantDigitos(0);
    }
    
    private int cantDigitos(int pos){
        int res;
        char caracter = expr.charAt(pos);
        if(caracter == '+'|| caracter == '-' || caracter == 'x' || caracter == '÷' || pos == expr.length()-1 || caracter == '(' || caracter ==')')
            if(pos == expr.length()-1)
                res = 1;
            else
                res = 0;
        else
            res = 1 + cantDigitos(++pos);
        return res;
            
    }
    
    private int parsearNumero(){
        int res;
        int digitos = cantDigitos();
        String string = expr.substring(0, digitos);
        res = Integer.parseInt(string);
        expr = expr.substring(digitos);
        return res;
    }
    
    private String parsearOP(){
        String res;
        res = "" + expr.charAt(0);
        expr = expr.substring(1); 
        return res;
        
    }
    
    public void string2List(){
        Operacion op;
        if(expr.equals(""))
            ;
        else{
            if(longitud() == 0){
                op = new Operacion();
                op.cambiarA(parsearNumero());
                op.cambiarOP(parsearOP());
                op.cambiarB(parsearNumero());
                lop.insertar(op);
                string2List();
            }else{
                op = new Operacion();
                op.cambiarOP(parsearOP());
                op.cambiarB(parsearNumero());
                lop.insertar(op);
                string2List();
            }
        }
            
    }
        
}
