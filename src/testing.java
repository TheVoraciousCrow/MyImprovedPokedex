import java.util.*;
import java.io.*;

public class testing {
    public static void testPokemon(){
        Pokemon testMon = new Pokemon("testMon");
        assert testMon.getSpecies().equals("testMon");
        testMon.setSpecies("newGuy");
        assert testMon.getSpecies().equals("newGuy");
    }
    public static void testPokedex(){
        Pokedex testDex = new Pokedex(5);
        testDex.addPokemon("testMon");
        assert testDex.getPokemonIndex("testMon") == 0;
        assert testDex.getPokemonIndex("testmon") == 0;
        System.out.println(testDex.getPokemonIndex("TESTMON"));

    }
    public static void main(String[] args) throws IOException{
        testPokemon();
        testPokedex();
        FileOutputStream fOut = new FileOutputStream("TestingStream.txt");
        PrintWriter writing = new PrintWriter(fOut);



    }
}
