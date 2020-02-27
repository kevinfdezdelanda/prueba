package ejem3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Binarios2 {
	public static void crearFich(String nomFich) throws IOException{
		//Crear fichero que contenga bloques: n1:int, n2:int, int, int, int,media: double
		int[][] notas={ {3,4,5,6,7}, {10,9,5,6,8}, {5,5,7,7,7}, {4,4,8,8,7}};
		DataOutputStream dos=new DataOutputStream(new FileOutputStream(nomFich));
		for (int i=0; i<notas.length; i++){
			double suma=0;
			for (int j=0; j<notas[i].length; j++){
				dos.writeInt(notas[i][j]);
				suma+=notas[i][j];
			}
			dos.writeDouble(suma/notas[i].length);
		}
		dos.close();	
	}
	
	public static int[] dameNotasAlumno(int pos, String nomFich) throws IOException {
		//CASO ERROR 1: no existe el fichero
		File f=new File(nomFich);
		if (!f.exists())
			return null;
		//CASO ERROR 2: no existe el nº alumno q nos pasan
		long tamFich=f.length();
		long tam1Alumno=(5*Integer.BYTES)+Double.BYTES;
		long cantAlumnos=tamFich/tam1Alumno;
		if ((pos <=0) || (pos>cantAlumnos))
			return null;
		DataInputStream dis=new DataInputStream(new FileInputStream(f));
		//Leer los alumnos anteriores a la posicion pos		
		/* //FORMA 1
		for (int cont=1; cont<pos; cont++){
			for (int cont2=1;cont2<=5;cont2++){
				dis.readInt();
			}
			dis.readDouble();
		}
		*/
		/*//FORMA 2
		byte[] bytesanteriores=new byte[(int)tam1Alumno*(pos-1)];
		dis.read(bytesanteriores);
		*/
		//FORMA 3
		dis.skip((int)tam1Alumno*(pos-1));
		//Cargar notas del alumno en posicion pos
		int[] notas=new int[5];
		for (int i=0;i<notas.length;i++){
			notas[i]=dis.readInt();
		}
		dis.close();
		return notas;
	}
	
	public static void main(String[] args) throws IOException {
		crearFich("notas.bin");
		int[] notas=dameNotasAlumno( 4,"notas.bin");
		if (notas==null)
			System.out.println("Fich o posicion erroneos");
		else{
			System.out.println("Notas del alumno 4");
			for (int i=0; i<notas.length; i++){
				System.out.print(notas[i]+ " ");
			}
		}
	}
}


