package ej3;

public class TelefonoMovil {
	private String numero;
	private int saldo;
	
	public TelefonoMovil(String numero, int saldo) {
		this.numero=numero;
		this.saldo=saldo;
	}
	
	public void ver() {
		System.out.println("telefono: "+numero);
		System.out.println("saldo: "+saldo);
	}
	
	public void cargar(int s) {
		saldo+=s;
	}
	
	public void llamar(int minutos) {
		saldo-=minutos*2;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}
	
	
}
