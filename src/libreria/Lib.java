package libreria;

import java.awt.event.KeyEvent;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
//import javax.swing.JRadioButton;
//import javax.swing.JLabel;
import javax.swing.JTextField;
//import javax.swing.JTextArea;
import java.text.DecimalFormat;

public class Lib {
	//  Atributos static 
	public static String tiposDeCategoria[] = { "Simple", "Doble", "Familiar" };
	public static String tiposDeEstadoBungalow[] = { "Libre", "Ocupado" };
	public static String tiposDeEstado[] = { "Pendiente", "Pagado" };
	//  Métodos static tipo void (con parámetros)
	public static void mensaje(JDialog jd, String s){
		JOptionPane.showMessageDialog(jd, s, "", 1);
	}
	public static void mensajeError(JDialog jd, String s, JTextField txt){
		JOptionPane.showMessageDialog(jd, s, "", 0);
		txt.requestFocus();
	}
	public static void soloLetras(KeyEvent e, JTextField txt, int maximo) {
	 	char x = e.getKeyChar();
	 	if (Character.isDigit(x)  &&  x != ' ')
	 		e.consume();
       	if (txt.getText().length() == maximo)
       		e.consume();
    }
    public static void soloNumeros(KeyEvent e, JTextField txt, int maximo) {
    	char x = e.getKeyChar();	 
	 	if (!Character.isDigit(x))
			e.consume();
       	if (txt.getText().length() == maximo)
			e.consume();
    }
    public static void soloDecimales(KeyEvent e, JTextField txt, int maximo) {
    	char x = e.getKeyChar();	 
	 	if (((x<'0')||(x>'9')) && (x!=KeyEvent.VK_BACK_SPACE) && (x!='.' || txt.getText().contains(".")))
			e.consume();
       	if (txt.getText().length() == maximo)
			e.consume();
    }
	//  Métodos static que retornan valor (con parámetros)
	public static int mensajeConfirmacion(JDialog jd, String s){
		return JOptionPane.showConfirmDialog(jd, s,"", 0,3,null);
	}
	public static int mensajeConfirmacion(JDialog jd, String s1, String s2) {
		return JOptionPane.showConfirmDialog(jd, s1, s2, 0, 1, null);
	}
	public static String dosDecimales(double d){
		DecimalFormat df = new DecimalFormat("###,###.##");
		return df.format(d);
	}
	public static String confirmarIngreso(JDialog jd, String s) {
		return JOptionPane.showInputDialog(jd, "", s, 3);
	}
	public static double redondear(double real) {
		return Math.round(real * 100) / 100.0;
	}
}
