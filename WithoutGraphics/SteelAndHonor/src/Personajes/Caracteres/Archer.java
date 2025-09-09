package Personajes.Caracteres;

public class Archer extends Caracter {

	
	
	
public Archer(String name, int hp, int attack, int defense, String chName) {
		super(name, hp, attack, defense, chName);
		
}

	@Override
	public void specialAttack(Caracter target) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLore() {
		// TODO Auto-generated method stub
		this.Lore = "Experto en ataques a distancia, rápido y ágil.";
	}

}
