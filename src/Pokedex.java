import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Pokedex {
    private int numPokemon;
    private int numPokemonInDex = 0;
    private Pokemon[] pokeDex1; //stores the pokemon objects in array as needed
    private Map<String, Integer> pokeMap = new LinkedHashMap<>(); //maps keys to the pokemon object index in pokemon array
    private Map<String, Integer> lowerCasePokeMap = new LinkedHashMap<>(); //duplicate of other hash map, but with lowercase keys

    public Pokedex(int numMonsters) {
        numPokemon = numMonsters;
        pokeDex1 = new Pokemon[numPokemon];

    }
//creates array of the same size as pokemap, and converts the key set to the array
    public String[] listPokemon() {
        return pokeMap.keySet().toArray(new String[pokeMap.size()]);
    }

    public boolean addPokemon(String species) { //adds pokemon to pokedex
        Pokemon newMonster = new Pokemon(species);
        if (lowerCasePokeMap.get(species.toLowerCase()) != null) {
            System.out.println("Duplicate");
            return false;
        }
        else if (getTotalPokemonAdded() == numPokemon) {
            System.out.println("Max");
            return false;
        }
        else {
            pokeMap.put(species, numPokemonInDex); //adds name of pokemon and stores index in the pokeDex array
            lowerCasePokeMap.put(species.toLowerCase(), numPokemonInDex);
            pokeDex1[numPokemonInDex] = newMonster; //add pokemon object to pokemon array
            numPokemonInDex++;
            return true;
        }
    }

    public int[] checkStats(String species){
        int[] statList = new int[3];
        Integer speciesIndex = getPokemonIndex(species);
            Pokemon pokemonOfInterest = pokeDex1[speciesIndex]; //gets pokemon object from the array
            statList[0] = pokemonOfInterest.getAttack();
            statList[1] = pokemonOfInterest.getDefense();
            statList[2] = pokemonOfInterest.getSpeed();
            return statList;
    }
//converts hashmap to tree map to automatically sory by the keys
    public void sortPokedex(){
        pokeMap = new TreeMap<>(pokeMap);
    }

    public boolean evolvePokemon(String species){
        Integer speciesIndex = getPokemonIndex(species);

        if (speciesIndex != -1){ //getPokemonIndex returns -1 if the pokemon is not in pokedex
            Pokemon pokemonOfInterest = pokeDex1[speciesIndex];
            pokemonOfInterest.evolve();
            return true;
        }
        else
            return false;
    }

    public Integer getPokemonIndex(String species){

        if (pokeMap.get(species) != null){ //if species is in the pokedex
            return pokeMap.get(species); //returns index value associated with species key
        }
        else return -1; //if not found, returns -1
    }
    public int getTotalPokemonAdded(){
        return numPokemonInDex;
    } //checks to see if the pokemon being added is a duplicate of will exceed the max number of pokemon

    }

