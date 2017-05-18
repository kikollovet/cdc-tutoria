package br.com.caelum.projetocdc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ConversorData {

	public static Calendar converteDataStringPraCalendar(String dataEmTexto){
		Calendar data = null;
		
		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
			data = Calendar.getInstance();
			data.setTime(date);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
		
		return data;
	}
}
