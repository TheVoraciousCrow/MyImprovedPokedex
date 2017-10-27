public class Pokemon {
    private String species; //name
    private int attack;
    private int defense;
    private int speed;

    public Pokemon(String speciesName){
        species = speciesName;
        attack = speciesName.length() * 4 + 2;
        defense = speciesName.length() * 2 + 7;
        speed = speciesName.length() * 3 + 5;
    }
    public int getAttack(){
        return attack;
    }
    public void setAttack(int atk){
        attack = atk;
    }
    public int getDefense(){
        return defense;
    }
    public void setDefense(int def){
        defense = def;
    }
    public int getSpeed(){
        return speed;
    }
    public void setSpeed(int spd){
        speed = spd;
    }
    public String getSpecies(){
        return species;
    }
    public void setSpecies(String spec){
        species = spec;
    }
    public void evolve(){
        setSpeed(speed * 2);
        setAttack(attack * 3);
        setDefense(defense * 5);

    }
    public static void main(String[] args){}

}
