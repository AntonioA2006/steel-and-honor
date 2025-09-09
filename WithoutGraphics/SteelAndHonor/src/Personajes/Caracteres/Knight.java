package Personajes.Caracteres;

public class Knight extends Caracter{

	public Knight(String name, int hp, int attack, int defense,String chName) {
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
		this.Lore = "Guerrero con honor, buena defensa y liderazgo.";
	}

}
