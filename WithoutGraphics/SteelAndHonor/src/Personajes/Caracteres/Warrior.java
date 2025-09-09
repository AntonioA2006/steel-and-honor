package Personajes.Caracteres;
public class Warrior extends Caracter {
    public Warrior(String name, int hp, int attack, int defense, String chName) {
        super(name, hp, attack, defense, chName);
    }

    @Override
    public void specialAttack(Caracter target) {
        System.out.println(name + " usa Slash!");
        target.takeDamage(attack + 5);
    }

	@Override
	public void setLore() {
		// TODO Auto-generated method stub
		this.Lore = " Fuerte en combate cuerpo a cuerpo, mucha defensa.";
	}
    
}
