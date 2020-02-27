package ejem4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Binarios3 {
	private String nomFich;
	private final static int LIM1=200, LIM2=300;
	
	public Binarios3(String n){
		this.nomFich=n;
	}
	
	void aniadirAleatorios(int cuantos) throws IOException{
		DataOutputStream dos=new DataOutputStream(new FileOutputStream(nomFich,true));
		for (int cont=1;cont<=cuantos;cont++){
			int num=LIM1 + (int) ( Math.random()*(LIM2-LIM1+1));
			dos.writeInt(num);
		}
		dos.close();
	}

	void ver() throws IOException{
		DataInputStream dis=new DataInputStream(new FileInputStream(nomFich));
		while (dis.available()>0){
			System.out.print(dis.readInt()+ " ");
		}
		dis.close();
	}

	public static void main(String[] args) throws IOException {
		Binarios3 b=new Binarios3("numsRandom.bin");
		b.aniadirAleatorios(3);
		b.aniadirAleatorios(2);
		b.ver();
	}
}
