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


package scalculator.guiQt;
import com.trolltech.qt.gui.QWidget;
import com.trolltech.qt.gui.QPushButton;
import com.trolltech.qt.gui.QVBoxLayout;
import com.trolltech.qt.gui.QGridLayout;
import com.trolltech.qt.gui.QLineEdit;
import edl.ListaSE;
import scalculator.op.ExpresionEntera;
import com.trolltech.qt.gui.QFont;
import com.trolltech.qt.gui.QIcon;

/**
 *
 * @author sass3r
 */
public class Gui extends QWidget {
    
     //QColor color;
    QLineEdit entry;
    QGridLayout glayout;
    QVBoxLayout vlayout;
    ExpresionEntera expr;
    ListaSE<QPushButton> buttonList;
    
    public Gui() {
    
        entry = new QLineEdit();
        glayout = new QGridLayout();
        vlayout = new QVBoxLayout();
        buttonList = new ListaSE<QPushButton>();
        setWindowTitle("SCalculator 0.1");
        setFixedSize(200,200);
        setLayout(vlayout);
        entry.setFixedSize(178, 50);
        entry.setFont(new QFont("times",12,QFont.Weight.Bold.value()));
        entry.setStyleSheet("QWidget { background-color: white }");
        vlayout.addWidget(entry);
        vlayout.addLayout(glayout);
        setStyleSheet("QWidget { background-color: black }");
        setWindowIcon(new QIcon("/usr/share/icons/gnome/16x16/apps/accessories-calculator.png"));
        genButtons();
        connectButtons();
    
    }
    
     private void genButtons(){
        for(int row = 0; row < 4; ++row)
            for(int column = 0; column < 4; ++column){
                QPushButton button = new QPushButton();
                button.setFixedSize(37,23);
                button.setFont(new QFont("times", 12, QFont.Weight.Bold.value()));
                button.setStyleSheet("QWidget { background-color: white }");
		buttonList.insertar(button);
                glayout.addWidget(button, row, column);
		}
        
        buttonList.acceder(0).setText("7");
	buttonList.acceder(1).setText("8");
	buttonList.acceder(2).setText("9");
	buttonList.acceder(3).setText("÷");
	buttonList.acceder(4).setText("4");
	buttonList.acceder(5).setText("5");
	buttonList.acceder(6).setText("6");
	buttonList.acceder(7).setText("x");
	buttonList.acceder(8).setText("1");
	buttonList.acceder(9).setText("2");
	buttonList.acceder(10).setText("3");
	buttonList.acceder(11).setText("-");
	buttonList.acceder(12).setText("0");
	buttonList.acceder(13).setText("del");
	buttonList.acceder(14).setText("=");
	buttonList.acceder(15).setText("+");
		
        
    }
    
    private void connectButtons(){
        
        buttonList.acceder(0).clicked.connect(this, "onButton7Type()");
        buttonList.acceder(1).clicked.connect(this, "onButton8Type()");
        buttonList.acceder(2).clicked.connect(this, "onButton9Type()");
        buttonList.acceder(3).clicked.connect(this, "printDiv()");
        buttonList.acceder(4).clicked.connect(this, "onButton4Type()");
        buttonList.acceder(5).clicked.connect(this, "onButton5Type()");
        buttonList.acceder(6).clicked.connect(this, "onButton6Type()");
        buttonList.acceder(7).clicked.connect(this, "printX()");
        buttonList.acceder(8).clicked.connect(this, "onButton1Type()");
        buttonList.acceder(9).clicked.connect(this, "onButton2Type()");
        buttonList.acceder(10).clicked.connect(this, "onButton3Type()");
        buttonList.acceder(11).clicked.connect(this, "printResta()");
        buttonList.acceder(12).clicked.connect(this, "onButton0Type()");
        buttonList.acceder(13).clicked.connect(this, "del()");
        buttonList.acceder(14).clicked.connect(this, "evaluar()");
        buttonList.acceder(15).clicked.connect(this, "printSum()");
                
                
	
    }
    
    public void evaluar(){
        String texto = entry.text();
        expr = new ExpresionEntera(texto);
        //expr.cadena2Lista();
        //expr.ordenarLista();
        expr.string2List();
        int res = expr.evaluar();
        entry.clear();
        entry.insert(Integer.toString(res));
        expr = null;
    }
    
    public void printSum(){
        type("+");
    }
    
    public void printDiv(){
        type("÷");
    }
    
    public void printX(){
        type("x");
    }
    
    public void printResta(){
        type("-");
    }
        
    public void onButton0Type(){
	type("0");
    }
	
    public void onButton1Type(){
	type("1");
    }
	
    public void onButton2Type(){
	type("2");
    }
	
    public void onButton3Type(){
	type("3");
    }
	
    public void onButton4Type(){
	type("4");
    }
	
    public void onButton5Type(){
	type("5");
    }
	
    public void onButton6Type(){
	type("6");
    }
	
    public void onButton7Type(){
	type("7");
    }
	
    public void onButton8Type(){
	type("8");
    }
	
    public void onButton9Type(){
	type("9");
    }
    
    public void type(String s){
        entry.insert(s);        
    }
    
    public void del(){
        entry.clear();
    }
    
    
}

    

