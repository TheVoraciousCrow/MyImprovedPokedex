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
        System.out.println("Your new Pokedex can hold "+  numPokemon +  " Pokemon. Let's start using it!");
        Pokedex myPokedex = new Pokedex(numPokemon); //create pokedex object with numPokemon pokemon

        while (displayOptions){
            System.out.print("\n1. List Pokemon\n2. Add Pokemon\n3. Check a Pokemon's Stats\n" +
                    "4. Evolve Pokemon\n5. Sort Pokemon\n6. Exit\n\nWhat would you like to do? ");

            try{
                int userResponse = scan.nextInt();
                switch(userResponse){
                    case 1:
                        //list pokemon
                        int counter = 1;
                        for (String pokemon : myPokedex.listPokemon()){ //iterate through list contents
                            System.out.println(counter + ". " + pokemon);
                            counter++;
                        }
                        break;
                    case 2: //adds new pokemon to the pokedex
                        addingPokemon(myPokedex, scan);
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
                        System.out.println("");
                        System.out.println("That is not a valid choice. Try again.");
                }
            } catch(InputMismatchException e){
                System.out.println("");
                System.out.println("That is not a valid choice. Try again.");
                scan.nextLine();
            }
        }

    }
    //this method will add a pokemon, or print the reason why a pokemon cannot be added
    public static void addingPokemon(Pokedex myPokedex, Scanner scan){
        //add a pokemon
        System.out.println("");
        System.out.print("Please enter the Pokemon's Species: ");
        String species = scan.next();
        String addingValidation = myPokedex.addPokemonValidation(species); //will tell if pokemon was added or why it wasn't

        if (addingValidation.equals("Duplicate"))
            System.out.println("Duplicate");
        else if(addingValidation.equals("Max"))
            System.out.println("Max");
        else if(addingValidation.equals("Can add pokemon"))
            myPokedex.addPokemon(species);
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
    public static void evolvingPokemon(Pokedex myPokedex){ //evolves the supplied pokemon
        String species = getSpeciesOfInterest();
        boolean speciesHasEvolved;

        if (myPokedex.getPokemonIndex(species) != -1) { //method returns -1 if pokemon is not in the index
            speciesHasEvolved = myPokedex.evolvePokemon(species); //returns true after evolution

            if (speciesHasEvolved)
                System.out.println("" + species + " has evolved!");
        }
        else {
            System.out.print("Missing");
        System.out.println("");
        }
    }
    public static String getSpeciesOfInterest(){ //takes in user input
        System.out.println("");
        System.out.print("Please enter the species of interest: ");
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }
}
