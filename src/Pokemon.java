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
    public void setAttack(int newAttack){
        attack = newAttack;
    }
    public int getDefense(){
        return defense;
    }
    public void setDefense(int newDefense){
        defense = newDefense;
    }
    public int getSpeed(){
        return speed;
    }
    public void setSpeed(int newSpeed){
        speed = newSpeed;
    }
    public String getSpecies(){
        return species;
    }
    public void setSpecies(String newSpecies){
        species = newSpecies;
    }
    public void evolve(){
        setSpeed(speed * 2);
        setAttack(attack * 3);
        setDefense(defense * 5);

    }
    public static void main(String[] args){}

}
