class Mage extends Character {
    public Mage(String name, int hp, int attack, int defense) {
        super(name, hp, attack, defense);
    }

    @Override
    public void specialAttack(Character target) {
        System.out.println(name + " lanza Fireball 🔥!");
        target.takeDamage(attack + 10);
    }
}