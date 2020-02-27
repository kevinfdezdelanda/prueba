package ej2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Numeros {
	public static int generar1Num(int limiteInf, int limiteSup) {
		int aux = limiteSup - limiteInf + 1;
		int num;
		
		num = (int) (Math.random()*aux)+limiteInf;
		
		return num;
	}
	
	public static ArrayList<Integer> generarNums(int limiteInf, int limiteSup, int cantidad){
		int aux = limiteSup - limiteInf + 1;
		ArrayList<Integer> nums = new ArrayList<Integer>();
		
		for (int i = 0; i < cantidad; i++) {
			nums.add((int) (Math.random()*aux)+limiteInf);
		}
			
		return nums;
	}
	
	public static void anade1Num(String nomFich, int num) throws IOException {
		File f=new File(nomFich);
		
		DataOutputStream dis = new DataOutputStream(new FileOutputStream(f,true));
		
		dis.writeInt(num);
		
		dis.close();
	}
	
	public static void anadeNums(String nomFich, ArrayList<Integer> nums) throws IOException {
		File f=new File(nomFich);
		
		DataOutputStream dis = new DataOutputStream(new FileOutputStream(f,true));
		
		for (int i = 0; i < nums.size(); i++) {
			dis.writeInt(nums.get(i));
		}
		
		dis.close();
	}
	
	public static Integer buscaEnFichero(String nomFich, int p) throws IOException {
		File f=new File(nomFich);
		if (!f.exists()) {
			System.out.println("El fichero no existe");
			return null;
		}
		
		DataInputStream dis = new DataInputStream(new FileInputStream(f));
		
		if((p>f.length()/Integer.BYTES)||(p<0)) {
			System.out.println("Posicion erronea");
			dis.close();
			return null;
		}
		
		dis.skip((p-1)*Integer.BYTES);
		
		Integer num = dis.readInt();
		dis.close();
		
		return num;
	}
	
	public static void verFichero(String nomFich) throws IOException {
		File f=new File(nomFich);
		if (!f.exists()) {
			System.out.println("El fichero no existe");
			return;
		}
		
		DataInputStream dis = new DataInputStream(new FileInputStream(f));
		
		while(dis.available()>0) {
			System.out.print(dis.readInt()+ " ");
		}
		dis.close();
	}
	
	public static void main(String[] args) throws IOException {
//		ArrayList<Integer> nums = new ArrayList<Integer>();
//		char respuesta='s';
//		int num;
//		while(respuesta=='s') {
//			System.out.println("Introduce un numero: ");
//			num = Consola.leeInt();
//			nums.add(num);
//			System.out.println("Desea continuar: ");
//			respuesta = Consola.leeChar();
//		}
//		
//		anadeNums("fich1.bin", nums);
//		
//		anade1Num("fich1.bin", generar1Num(1, 5));
//		
//		anadeNums("fich1.bin", generarNums(1, 50, 5));
//		
		verFichero("fich1.bin");
		
		System.out.println();
		System.out.println(buscaEnFichero("fich1.bin", 6));
		
		System.out.println();
		System.out.println(buscaEnFichero("fich1.bin", 9));
		
		System.out.println();
		File f = new File("fich1.bin");
		int ultimo = (int) (f.length()/Integer.BYTES);
		System.out.println(buscaEnFichero("fich1.bin",ultimo));
		
		anadeNums("fich2.bin", generarNums(1, 50, 10));
		
		for (int i = 1; i <= ultimo; i++) {
			if(i%2!=0) {
				anade1Num("fich2.bin", buscaEnFichero("fich1.bin", i));
			}	
		}
		
		verFichero("fich1.bin");
		System.out.println();
		verFichero("fich2.bin");
	}
}
