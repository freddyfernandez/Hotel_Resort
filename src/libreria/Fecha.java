package libreria;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Fecha {
	//  Métodos static tipo void 
	public static String leerFechaActual() {
		int dd, mm, aa;
		Calendar c = new GregorianCalendar();
		dd = c.get(Calendar.DAY_OF_MONTH);
		mm = c.get(Calendar.MONTH) + 1;
		aa = c.get(Calendar.YEAR);
		return ajustar(dd) + "/" + ajustar(mm) + "/" + aa;
	}
	public static String leerHoraActual() {
		int hh, mm, ss;
		Calendar c = new GregorianCalendar();
		hh = c.get(Calendar.HOUR_OF_DAY);
		mm = c.get(Calendar.MINUTE);
		ss = c.get(Calendar.SECOND);
		return ajustar(hh) + ":" + ajustar(mm) + ":" + ajustar(ss);
	}
	static String ajustar(int numero) {
		return String.format("%02d", numero);
	}
	public static int diasTranscurridos(String fechaInicial, String fechaFinal) {
		try {
			SimpleDateFormat adt = new SimpleDateFormat("dd/MM/yyyy");
			Date fi = adt.parse(fechaInicial),
			     ff = adt.parse(fechaFinal);
			return (int) ((ff.getTime() - fi.getTime()) / 86400000);
		}
		catch (Exception e) {
			return 0;
		}
	}
}
