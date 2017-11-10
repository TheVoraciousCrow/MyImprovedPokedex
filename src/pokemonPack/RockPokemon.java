package pokemonPack;

public class RockPokemon implements BaseTypeMethods
    {
        private String type = "Rock";
        private String[] superEffectiveAgainst = new String[4];
        private String[] weakAgainst = new String[3];
        RockPokemon()
        {
            superEffectiveAgainst[0] = "Flying";
            superEffectiveAgainst[1] = "Bug";
            superEffectiveAgainst[2] = "Fire";
            superEffectiveAgainst[3] = "Ice";

            weakAgainst[0] = "Fight";
            weakAgainst[1] = "Ground";
            weakAgainst[2] = "Steel";
        }
        public String getType()
        {
            return type;
        }
        public String[] superEffectiveAgainst ()
        {
            return superEffectiveAgainst;
        }
        public String[] weakAgainst ()
        {
            return weakAgainst;
        }
    }