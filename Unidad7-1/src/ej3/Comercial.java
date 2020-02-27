package ej3;

public class Comercial {
	private String nombre;
	private float salario;
	private TelefonoMovil telefono;
	
	public Comercial(String nombre, float salario, TelefonoMovil telefono) {
		this.nombre = nombre;
		this.salario = salario;
		this.telefono = telefono;
	}
	
	public void ver() {
		System.out.println("nombre: "+nombre);
		System.out.println("salario: "+salario);
		telefono.ver();
	}
	
	public void trabajar() {
		if(telefono.getSaldo()>(15*2)) {
			salario+=10;
			telefono.llamar(15);
		}else{
			System.out.println("saldo insuficiente");
		}
	}
	
	public void trabajar(int g, int m) {
		if(telefono.getSaldo()>(m*2)) {
			salario+=g;
			telefono.llamar(m);
		}else{
			System.out.println("saldo insuficiente");
		}
	}
}
