package pokemonPack;
public class Pokemon {
    private String species; //name
    private int attack;
    private int defense;
    private int speed;
    private int height;
    private int weight;
    private String description;


    public Pokemon(String speciesName)
    {
        species = speciesName;
        attack = speciesName.length() * 4 + 2;
        defense = speciesName.length() * 2 + 7;
        speed = speciesName.length() * 3 + 5;
    }
    public int getAttack()
    {
        return attack;
    }
    public void setAttack(int newAttack)
    {
        attack = newAttack;
    }
    public int getDefense()
    {
        return defense;
    }
    public void setDefense(int newDefense)
    {
        defense = newDefense;
    }
    public int getSpeed()
    {
        return speed;
    }
    public void setSpeed(int newSpeed)
    {
        speed = newSpeed;
    }
    public String getSpecies()
    {
        return species;
    }
    public void setSpecies(String newSpecies)
    {
        species = newSpecies;
    }
    public void evolve()
    {
        setSpeed(speed * 2);
        setAttack(attack * 3);
        setDefense(defense * 5);

    }
    public int getHeight()
    {
        return height;
    }
    public void setHeight(int height)
    {
        this.height = height;
    }
    public int getWeight()
    {
        return weight;
    }
    public void setWeight(int weight)
    {
        this.weight = weight;
    }
    public String getDescription()
    {
        return description;
    }
    public void setDescription(String description)
    {
        this.description = description;
    }
}
