package pokemonPack;

public class GrassPokemon
{
    private String type = "Grass";
    private String[] superEffectiveAgainst = new String[3];
    private String[] weakAgainst = new String[7];
    GrassPokemon()
    {
        superEffectiveAgainst[0] = "Ground";
        superEffectiveAgainst[1] = "Rock";
        superEffectiveAgainst[2] = "Water";

        weakAgainst[0] = "Flying";
        weakAgainst[1] = "Poison";
        weakAgainst[2] = "Bug";
        weakAgainst[3] = "Steel";
        weakAgainst[4] = "Fire";
        weakAgainst[5] = "Grass";
        weakAgainst[6] = "Dragon";
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
