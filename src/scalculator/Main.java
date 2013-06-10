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


package scalculator;
import com.trolltech.qt.gui.QApplication; 
import scalculator.guiQt.Gui;

/*
 * @author sass3r
 */

public class Main {
    public static void main(String[] arg){
        QApplication.initialize(arg);
        Gui gui = new Gui();
        gui.show();
        QApplication.execStatic();
        
    }
}
