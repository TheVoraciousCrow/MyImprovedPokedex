import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){


        boolean displayOptions = true;
        boolean displayNumEntry = true;
        int numPokemon = 1;
        int pokemonAdded = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to your new PokeDex!");

        while (displayNumEntry){
            try{
                System.out.print("How many pokemon are in your region: ");
                numPokemon = scan.nextInt();
                System.out.println("");
                if (numPokemon > 0)
                    displayNumEntry = false;
                else
                    throw new Exception("Number Is less than or equal to zero.");
            }
            catch (Exception e){
                System.out.println(e.getMessage());
                System.out.println("Enter a number greater than zero!\n");
                scan.nextLine();
            }
        }
        System.out.println("\nYour new Pokedex can hold "+  numPokemon +  " Pokemon. Let's start using it!");
        Pokedex myPokedex = new Pokedex(numPokemon);

        while (displayOptions){
            System.out.print("\n1. List Pokemon\n2. Add Pokemon\n3. Check a Pokemon's Stats\n" +
                    "4. Evolve Pokemon\n5. Sort Pokemon\n6. Exit\nWhat would you like to do? ");
            try{
                int userResponse = scan.nextInt();
                System.out.println("");
                switch(userResponse){
                    case 1:
                        //list pokemon
                        int counter = 1;
                        for (String pokemon : myPokedex.listPokemon()){
                            System.out.println(counter + ". " + pokemon);
                            counter++;
                        }
                        break;
                    case 2: //adds new pokemon to the pokedex
                        addingPokemon(myPokedex, scan, pokemonAdded, numPokemon);
                        break;
                    case 3: // check Pokemon stats
                        statCheck(myPokedex);
                        break;
                    case 4: //evolve a pokemon
                       evolvingPokemon(myPokedex);
                        break;
                    case 5: //Sort Pokemon
                        myPokedex.sortPokedex();
                        break;
                    case 6: //exit program
                        displayOptions = false;
                        return;
                    default:
                        System.out.println("What was that\n");
                }
            } catch(InputMismatchException e){
                System.out.println("what was that?\n");
                scan.nextLine();
            }
        }

    }
    public static void addingPokemon(Pokedex myPokedex, Scanner scan, int pokemonAdded, int numPokemon){
        //add a pokemon
        if (myPokedex.getTotalPokemonAdded() < numPokemon){
            System.out.print("Please enter the Pokemon's Species: ");
            myPokedex.addPokemon(scan.next());
            System.out.println("");
        }
        else {
            System.out.print("There are only " + numPokemon + " pokemon in your region, you cannot add more!");
            System.out.println("");
        }
    }

    public static void statCheck(Pokedex myPokedex){ //gets the stats from pokedex and prints them


        String species = getSpeciesOfInterest();
        if (myPokedex.getPokemonIndex(species) != -1) {
            int[] statList = myPokedex.checkStats(species);
            System.out.println("The stats for " + species + " are:");
            System.out.println("Attack: " + statList[0] + "\nDefense: " + statList[1] +
                    "\nSpeed: " + statList[2]);
        }
        else
            System.out.println("Missing");
    }
    public static void evolvingPokemon(Pokedex myPokedex){


        String species = getSpeciesOfInterest();
        boolean speciesHasEvolved;
        if (myPokedex.getPokemonIndex(species) != -1) {
            speciesHasEvolved = myPokedex.evolvePokemon(species); //returns true after evolution
            if (speciesHasEvolved)
                System.out.println("" + species + " has evolved!");
        }
        else
            System.out.print("Missing");
    }
    public static String getSpeciesOfInterest(){


        System.out.print("Please enter the species of interest: ");
        Scanner scan = new Scanner(System.in);
        String response = scan.nextLine();
        return response;

    }
}
