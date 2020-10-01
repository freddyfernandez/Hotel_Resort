package libreria;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class Coloreando extends DefaultTableCellRenderer{
	
	private static final long serialVersionUID = 1L;
	
	private Component componente;
	public Component getTableCellRendererComponent(JTable table, Object value,boolean isSelected, boolean hasFocus, int row, int column){	
		componente = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		componente.setBackground(Color.WHITE);
		componente.setForeground(Color.black);
		if (isSelected)
			componente.setBackground(Color.LIGHT_GRAY);
		if (value == "Libre")
			componente.setForeground(Color.BLUE);
		else
			if (value == "Ocupado")
				componente.setForeground(Color.RED);
			else
				if (value == "Pendiente")
					componente.setForeground(Color.RED);
				else
					if (value == "Pagado")
						componente.setForeground(Color.BLUE);			
		return componente;
	}
}