package ejem6;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class Ejemplo6 {
	public static void crearFichNumeros(String nomFich) throws IOException{	
		DataOutputStream dos=new DataOutputStream(new FileOutputStream(nomFich) );
		for (int num=50; num<=100; num++){
			dos.writeInt(num);
		}
		dos.close();
	}
	
	public static boolean copiaDeBinATxt(String fichBin, String fichTxt) throws IOException{	
		//No existe fichero de lectura
		File f=new File(fichBin);
		if (!f.exists())
			return false;
		//Existe --> Copiarlo
		DataInputStream dis=new DataInputStream(new FileInputStream(fichBin));
		BufferedWriter bw=new BufferedWriter(new FileWriter(fichTxt));	
		while (dis.available()>0){
			int num=dis.readInt();
			bw.write(String.valueOf(num));
			bw.newLine();
		}
		dis.close();
		bw.close();
		return true;
	}

	public static void main(String[] args) throws IOException {
		crearFichNumeros("numeros.bin");
		if (!copiaDeBinATxt("numeros.bin","numeros.txt"))
			System.out.println("Copia imposible");
	}
}


