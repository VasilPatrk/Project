public class Main
{
	public static void main(String[] args) {
		Warrior warrior = new Warrior("Thor", 100, 50, 1, 20, 15);
        Mage mage = new Mage("Merlin", 80, 100, 1, 25, 30);
        Rogue rogue = new Rogue("Loki", 90, 60, 1, 30, 20);
        
        warrior.getInfo();
        System.out.println(" ");
        mage.getInfo();
        System.out.println(" ");
        rogue.getInfo();
        System.out.println(" ");
        warrior.attack(mage);
        System.out.println(" ");
        warrior.applyArmor();
        System.out.println(" ");
        mage.castSpell();
        System.out.println(" ");
        rogue.attack(mage);
        System.out.println(" ");
        mage.fool(rogue);
        System.out.println(" ");
        warrior.getInfo();
        System.out.println(" ");
        mage.getInfo();
        System.out.println(" ");
        rogue.getInfo();
        System.out.println(" ");
        
}
}
class Character{
    private String name;
    private int mana;
    private int health;
    private int level;
    
     public Character(String name, int health, int mana, int level) {
        this.name = name;
        this.health = health;
        this.mana = mana;
        this.level = level;
    }
    public int getMana(){
        return mana;
    }
    public int getHealth(){
        return health;
    }
    public int getLevel(){
        return level;
    }
    public void rHealth(){
        health = health - 1;
    }
    public void gHealth(){
        health = health + 1;
    }
    public void rMana(){
        mana--;
    }
    public void gMana(){
        mana++;
    }
    public void setHealth(int a){
        health = health + a;
    }
    public String getName(){
        return name;
    }
    public void getInfo(){
        System.out.println("Name: " + name);
        System.out.println("Health: " + health);
        System.out.println("Mana: " + mana);
        System.out.println("Level: " + level);
    }

    
    public void attack(Character a){
        mana--;
        level++;
        a.rHealth();
        System.out.println(name + " attacked " + a.getName());
        
    }
    public void defend(Character a){
        health++;
        a.rMana();
        System.out.println(name + "attacked " + a.getName());
    }
    public void castSpell(){
        level++;
        health++;
        System.out.println(name + " used a cast spell");
    }
}
class Warrior extends Character {
    private int strength;
    private int armor;

    public Warrior(String name, int health, int mana, int level, int strength, int armor) {
        super(name, health, mana, level);
        this.strength = strength;
        this.armor = armor;
    }
    public void attack(Character a){
        super.attack(a);
        strength++;
    }
    public void applyArmor(){
        super.setHealth(armor);
        System.out.println(super.getName() + " applied armor");
    }
    
}

class Mage extends Character {
    private int intelligence;
    private int spellPower;

    public Mage(String name, int health, int mana, int level, int intelligence, int spellPower) {
        super(name, health, mana, level);
        this.intelligence = intelligence;
        this.spellPower = spellPower;
    }
    
    public void castSpell(){
        super.castSpell();
        super.castSpell();
    }
    public void fool(Character a){
        System.out.println(super.getName() + " fooled " + a.getName());
    }
}

class Rogue extends Character {
    private int agility;
    private int dexterity;

    public Rogue(String name, int health, int mana, int level, int agility, int dexterity) {
        super(name, health, mana, level);
        this.agility = agility;
        this.dexterity = dexterity;
    }
    public void castSpell(){
        super.castSpell();
        agility++;
    }
}

