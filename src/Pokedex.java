import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Pokedex
{
    private int numPokemon;                                                 //stores the mak number of poKemon in the Pokedex.
    private int numPokemonInDex = 0;                                        //stores how many pokemon have actually been added.
    private Pokemon[] pokeDex1;                                             //stores the pokemon objects in array as needed.
    private Map<String, Integer> pokeMap = new LinkedHashMap<>();           //maps keys to the pokemon object index in pokemon array.
    private Map<String, Integer> lowerCasePokeMap = new LinkedHashMap<>();  //duplicate of other hash map, but with lowercase keys.

    public Pokedex(int numMonsters)
    {
        numPokemon = numMonsters;
        pokeDex1 = new Pokemon[numPokemon];

    }

    public String[] listPokemon()
    {
        //Gets the Key set from the pokemap and converts it to a string array of size: length pf pokeMap.
        return pokeMap.keySet().toArray(new String[pokeMap.size()]);
    }

    public boolean addPokemon(String species)
    {
        Pokemon newMonster = new Pokemon(species);
        if (lowerCasePokeMap.get(species.toLowerCase()) != null && getTotalPokemonAdded() == numPokemon) {
            //check if pokemon is in Pokedex and if it is full.
            System.out.println("Duplicate");
            System.out.println("Max");
            return false;
        }
        else if (lowerCasePokeMap.get(species.toLowerCase()) != null)
        {
            //check if pokemon is already in Pokedex
            System.out.println("Duplicate");
            return false;
        }
        else if (getTotalPokemonAdded() == numPokemon)
        {
            //check if pokedex is full
            System.out.println("Max");
            return false;
        }
        else {
            pokeMap.put(species, numPokemonInDex);                          //adds name of pokemon and stores index in the pokeDex array.
            lowerCasePokeMap.put(species.toLowerCase(), numPokemonInDex);   //adds lower case version to pokedex.
            pokeDex1[numPokemonInDex] = newMonster;                         //add pokemon object to pokemon array.
            numPokemonInDex++;                                              //increase Pokedex counter.
            return true;
        }
    }

    public int[] checkStats(String species)
    {
        int[] statList = new int[3];                                        //create array to hold stat contents.
        if (lowerCasePokeMap.get(species.toLowerCase()) != null)
        {
            //Check if Pokemon is in the map.
            Integer speciesIndex = getPokemonIndex(species);                //obtains index location of pokemon.
            Pokemon pokemonOfInterest = pokeDex1[speciesIndex];             //gets pokemon object from the array.
            statList[0] = pokemonOfInterest.getAttack();
            statList[1] = pokemonOfInterest.getDefense();
            statList[2] = pokemonOfInterest.getSpeed();
        }
        else
        {
            //Return Array of Zeros if pokemon not found
            statList[0] = 0;
            statList[1] = 0;
            statList[2] = 0;
        }
            return statList;
    }

    public void sortPokedex()
    {
        //converts hashmap to tree map because a tree map automatically sorts by key.
        pokeMap = new TreeMap<>(pokeMap);
    }

    public boolean evolvePokemon(String species)
    {
        Integer speciesIndex = getPokemonIndex(species);

        if (speciesIndex != -1){
            //getPokemonIndex returns -1 if the pokemon is not in pokedex
            Pokemon pokemonOfInterest = pokeDex1[speciesIndex];
            pokemonOfInterest.evolve();
            return true;
        }
        else
            return false;
    }

    public Integer getPokemonIndex(String species)
    {

        if (lowerCasePokeMap.get(species.toLowerCase()) != null)
        {
            //if species is in the pokedex
            return lowerCasePokeMap.get(species.toLowerCase());              //returns index value associated with species key.
        }
        else return -1;                                                      //if not found, returns -1.
    }
    public int getTotalPokemonAdded()
    {
        //returns the number of pokemon that are successfully added to the Pokedex.
        return numPokemonInDex;
    }
}

