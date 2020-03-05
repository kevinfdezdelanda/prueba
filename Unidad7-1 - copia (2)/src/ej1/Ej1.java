package ej1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;



public class Ej1 {
	public static void copiar(String fichOrigen) throws IOException {
		String fichDestino;
		
		String[] aux =fichOrigen.split("\\.");
		fichDestino=aux[0]+"_CPY."+ aux[1];
		
		FileInputStream fis = new FileInputStream(fichOrigen);
		FileOutputStream fos = new FileOutputStream(fichDestino);
		while (fis.available() > 0) {
			int byteleido = fis.read();
			fos.write(byteleido);
		}
		fis.close();
		fos.close();
	}
	
	public static void copiarNBytes(String fichOrigen) throws IOException{
		final int N = 512; 
		String fichDestino;
		
		String[] aux =fichOrigen.split("\\.");
		fichDestino=aux[0]+"_CPY2."+ aux[1];
		
		FileInputStream fis = new FileInputStream(fichOrigen);
		FileOutputStream fos = new FileOutputStream(fichDestino);
		
		while (fis.available() > 0) {
			byte[] bytesLeidos = new byte[N];
			int leidos = fis.read(bytesLeidos);
			fos.write(bytesLeidos, 0, leidos);
		}
		
		fis.close();
		fos.close();
	}
	
	public static boolean copiarEntero(String fichOrigen) throws IOException{
		String fichDestino;
		
		String[] aux =fichOrigen.split("\\.");
		fichDestino=aux[0]+"_CPY3."+ aux[1];
		
		File imagen = new File(fichOrigen);
		if (!imagen.exists()) {
			return false;
		}
		byte[] tamanio = new byte[(int) imagen.length()];
		
		FileInputStream fis = new FileInputStream(fichOrigen);
		FileOutputStream fos = new FileOutputStream(fichDestino);
		 
		fis.read(tamanio);
		fos.write(tamanio);
		fis.close();
		fos.close();
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		copiar(args[0]);
		copiarNBytes(args[0]);
		copiarEntero(args[0]);
	}
}
