package app.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Fecha
{
  public static String convertirDDMMYYY(Date date)
  {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    return sdf.format(date);
  }
  
  public static String convertirHHMMSS(Date date)
  {
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    return sdf.format(date);
  }
  
  public static String convertirHHMM(Date date)
  {
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
    return sdf.format(date);
  }
  
  public static Date fechaSinHora(Date date){
	  return convetirDate(convertirDDMMYYY(date));
  }
  
  public static Date convetirDate(String fecha)
  {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    try
    {
      return sdf.parse(fecha);
    }
    catch (ParseException e)
    {
      e.printStackTrace();
    }
    return new Date();
  }
  
  public static Date convetirTime(String hora)
  {
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    try
    {
      return sdf.parse(hora);
    }
    catch (ParseException e)
    {
      e.printStackTrace();
    }
    return new Date();
  }
  
  public static Date convetirTimeHM(String hora)
  {
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
    try
    {
      return sdf.parse(hora);
    }
    catch (ParseException e)
    {
      e.printStackTrace();
    }
    return new Date();
  }
}