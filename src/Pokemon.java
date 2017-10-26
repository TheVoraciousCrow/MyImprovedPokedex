public class Pokemon {
    private String species; //name
    private int attack;
    private int defense;
    private int speed;

    public Pokemon(String spec){
        species = spec;
        attack = spec.length() * 4 + 2;
       // defense = species.length() * 2 + 7;
       // speed = species.length() * 3 + 5;
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
    public static void main(String[] args){}

}
