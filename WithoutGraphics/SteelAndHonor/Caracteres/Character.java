abstract class Character {
    protected String name;
    protected int hp, attack, defense;

    public Character(String name, int hp, int attack, int defense) {
        this.name = name;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public void takeDamage(int dmg) {
        int realDmg = Math.max(0, dmg - defense);
        hp -= realDmg;
        System.out.println(name + " recibió " + realDmg + " de daño. HP = " + hp);
    }

    public abstract void specialAttack(Character target);
}
