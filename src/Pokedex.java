import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Pokedex {
    private int numPokemon;
    private int numPokemonInDex = 0;
    private String[] pokeList;
    private Pokemon[] pokeDex1;
    private Map<String, Integer> pokeMap = new LinkedHashMap<>();

    public Pokedex(int numMonsters) {
        numPokemon = numMonsters;
        pokeList = new String[numPokemon];
        pokeDex1 = new Pokemon[numPokemon];

    }

    public static void main(String[] args) {
    }

    public String[] listPokemon() {
        return pokeMap.keySet().toArray(new String[pokeMap.size()]);
    }

    public boolean addPokemon(String species) {
        Pokemon newMonster = new Pokemon(species);
        if(pokeMap.get(species) != null) {
            return false;
        }
        else {
            pokeMap.put(species, numPokemonInDex); //adds name of pokemon and stores index in the pokeDex array
            pokeDex1[numPokemonInDex] = newMonster;
            numPokemonInDex ++;
        }
        return false;
    }

    public int[] checkStats(String species){
        int[] statList = new int[3];
        Integer speciesIndex = getPokemonIndex(species);
            Pokemon pokemonOfInterest = pokeDex1[speciesIndex];
            statList[0] = pokemonOfInterest.getAttack();
            statList[1] = pokemonOfInterest.getDefense();
            statList[2] = pokemonOfInterest.getSpeed();
            return statList;
    }

    public void sortPokedex(){
        pokeMap = new TreeMap<>(pokeMap);
    }

    public boolean evolvePokemon(String species){
        Integer speciesIndex = getPokemonIndex(species);
        if (speciesIndex != -1){
            Pokemon pokemonOfInterest = pokeDex1[speciesIndex];
            pokemonOfInterest.evolve();
            return true;
        }
        else
            return false;
    }

    public Integer getPokemonIndex(String species){
        if (pokeMap.get(species) != null){
            return pokeMap.get(species);
        }
        else return -1;
    }
    public int getTotalPokemonAdded(){
        return numPokemonInDex;
    }
}
