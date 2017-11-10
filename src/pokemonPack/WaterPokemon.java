package pokemonPack;

public class WaterPokemon implements BaseTypeMethods
{
    private String type ="Water";
    private String[] superEffectiveAgainst = new String[3];
    private String[] weakAgainst = new String[3];
    WaterPokemon()
    {
        superEffectiveAgainst[0] = "Ground";
        superEffectiveAgainst[1] = "Rock";
        superEffectiveAgainst[2] = "Fire";

        weakAgainst[0] = "Water";
        weakAgainst[1] = "Grass";
        weakAgainst[2] = "Dragon";

    }
    public String getType()
    {
        return type;
    }
    public String[] superEffectiveAgainst()
    {
        return superEffectiveAgainst;
    }
    public String[] weakAgainst()
    {
        return weakAgainst;
    }
}