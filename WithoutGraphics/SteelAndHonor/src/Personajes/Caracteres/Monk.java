package Personajes.Caracteres;

public class Monk extends Caracter {

	public Monk(String name, int hp, int attack, int defense, String chName) {
		super(name, hp, attack, defense, chName);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void specialAttack(Caracter target) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLore() {
		// TODO Auto-generated method stub
		this.Lore = "Pelea con artes marciales, rápido y disciplinado.";
	}
	

}
