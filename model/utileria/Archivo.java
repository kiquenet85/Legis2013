package utileria;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class Archivo {

	
	public static String LeerArchivo(String fileName)
	{
		StringBuilder result=new StringBuilder("");
		String s;
		try{
			
		FileReader fr = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fr);
		
		while ((s = br.readLine()) != null) {
			result.append(s);
		}
		fr.close();
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return result.toString();
	}
	
	public static void EscribirArchivo (String fileName, String body)
	{
		try {
			char buffer[] = new char[body.length()]; 
			body.getChars(0, body.length(), buffer, 0); 
			FileWriter f0 = new FileWriter(fileName); 
			for (int i=0; i < buffer.length; i += 2) { 
			f0.write(buffer[i]); 
			} 
			f0.close(); 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
