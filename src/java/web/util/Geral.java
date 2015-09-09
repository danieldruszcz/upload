package web.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class Geral {

	private Geral(){};
	
	public static Date getDataHora() {
		return new Date();
	}

	public static String getHora() {
		return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date())
				.toString();
	}

	public static String mensagemComHora(String msg) {
		return new SimpleDateFormat("HH:mm:ss ").format(new Date()).toString()
				+ msg;
	}

	public static String getDataHora(Date dt) {
		if (dt != null)
		{
			return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(dt);
		}
		else
		{
			return "";
		}
	}

	public static String getData(Date dt) {
		if (dt != null)
		{
			return new SimpleDateFormat("dd/MM/yyyy").format(dt);
		}
		else
		{
			return "";
		}
	}
	
	public static byte[] transformarIputStreamToByteArray(InputStream inputStream, Integer tamanhoDoByteArray) throws IOException
	{
		  
		  ByteArrayOutputStream buffer = new ByteArrayOutputStream();

		  int nRead;
		  byte[] data = new byte[tamanhoDoByteArray];

		  while ((nRead = inputStream.read(data, 0, data.length)) != -1) {
		    buffer.write(data, 0, nRead);
		  }

		  buffer.flush();
		  
		  return data;

	}
	
}
