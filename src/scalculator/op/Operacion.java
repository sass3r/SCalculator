/*
 * Copyright (C) 2013 Rafael Ramírez
 *
 *   La calculadora es software libre; puede redistribuirlo y/o modificarlo bajo 
 *   los términos de la Licencia Pública General GNU tal como se publica por 
 *   la Free Software Foundation; ya sea la versión 3 de la Licencia, o 
 *   (a su elección) cualquier versión posterior.
 *
 *   La calculadora se distribuye con la esperanza de que le sea útil, pero SIN 
 *   NINGUNA GARANTÍA; sin incluso la garantía implícita de MERCANTILIDAD o 
 *   IDONEIDAD PARA UN PROPÓSITO PARTICULAR. Vea la Licencia Pública 
 *   General GNU para más detalles.
 *
 *   Debería haber recibido una copia de la Licencia Pública General GNU
 *   junto con la Calculadora; de lo contrario escriba a la Free Software Foundation, Inc.,
 *   51 Franklin Street, Fifth Floor, Boston, MA 02110-1301, EE. UU.
 *   También puede encontrar la licencia en la siguiente dirección 
 *   http://www.gnu.org/licenses/gpl.html
 */


package scalculator.op;

/**
 * @author sass3r
 */

public class Operacion {
    
    private Integer a;
    private String op;
    private Integer b;
    
    public Operacion(){
        a = null;
        op = null;
        b = null;
    }   
    
    public Integer obtenerA(){
        return a;
    }
    
    public Integer obtenerB(){
        return b;
    }
    
    public String obtenerOP(){
        return op;
    }
    
    public void cambiarA(int na){
        a = na;
    }
    
    public void cambiarB(int nb){
        b = nb;
    }
    
    public void cambiarOP(String nop){
        op = nop;
    }
    
    public Integer calcular(){
        Integer res = null;
        switch (obtenerOP().charAt(0)) {
            case '+':{
                res = sumar();
                break;
            }
            case '-':{
                res = restar();
                break;
            }
            case 'x':{
                 res =multiplicar();
                 break;
            }
        }
        return res;
    }
    
    public Integer sumar(){
        int res = 0;
        if(a!=null && b!=null)
            res = a + b;
        return res;
    }
    
    public Integer restar(){
        int res = 0;
        if(a!=null && b!=null)
            res = a - b;
        return res;
    }
    
    public Integer multiplicar(){
        int res = 0;
        if(a!=null && b!=null)
                res = a * b;
        return res;
    }
    
    public void mostrarOP(boolean flag){
        if(flag)
            System.out.print("" + a + "" + op + "" + b);
        else
            System.out.print("" + op + "" + b);
    }
}
