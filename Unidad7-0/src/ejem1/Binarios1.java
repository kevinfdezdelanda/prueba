package ejem1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Binarios1 {	
	public static boolean crearFichNums(String nomfich) throws IOException{
		//Crea fichero de bytes con N numeros entre 1 y 100
		final int N=10;
		File f=new File(nomfich);
		if (f.exists())
			return false;
		FileOutputStream fos=new FileOutputStream(f);
		for (int cont=1;cont<=N; cont++){
			int n=1 + (int)(Math.random()*100);
			fos.write(n);
		}
		fos.close();
		return true;
	}

	public static void verFicheroNums(String nomfich) throws IOException{
		File f=new File(nomfich);
		if (!f.exists())
			System.out.println("No existe el fichero"+nomfich);
		else{
			FileInputStream fis=new FileInputStream(f);
			/*
			int n=fis.read();
			while (n!=-1){
				System.out.print(n + " " );
				n=fis.read();
			}
			*/
			while (fis.available()>0){
				int n=fis.read();
				System.out.print(n + " " );
			}
			fis.close();
		}
	}

	public static void main(String[] args) throws IOException {
		if (crearFichNums("nums.bin")==false)
			System.out.println("Ya existe ese fichero");
		verFicheroNums("nums.bin");
	}
}


