package pokemonPack;

public class FirePokemon implements BaseTypeMethods
{
    private String type = "Fire";
    private String[] superEffectiveAgainst = new String[4];
    private String[] weakAgainst = new String[4];
    FirePokemon()
    {
        superEffectiveAgainst[0] = "Bug";
        superEffectiveAgainst[1] = "Steel";
        superEffectiveAgainst[2] = "Grass";
        superEffectiveAgainst[3] = "Ice";

        weakAgainst[0] = "Rock";
        weakAgainst[1] = "Fire";
        weakAgainst[2] = "Water";
        weakAgainst[3] = "Dragon";
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
