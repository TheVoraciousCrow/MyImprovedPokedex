import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        boolean displayOptions = true;      //continues to list options until this is false.
        boolean displayNumEntry = true;     //asks for user input until this is false.
        int numPokemon = 1;
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to your new PokeDex!");

        while (displayNumEntry)
        {
            try
            {
                System.out.print("How many Pokemon are in your region: ");
                numPokemon = scan.nextInt();
                System.out.println("");

                if (numPokemon >= 0)
                    displayNumEntry = false;
                else
                    throw new Exception("Number Is less than zero.");
            }
            catch (Exception e)
            {
                System.out.println("Number Is less than zero.\n");
                scan.nextLine();
            }
        }
        System.out.println("Your new Pokedex can hold "+  numPokemon +  " Pokemon. Let’s start using it!");
        Pokedex myPokedex = new Pokedex(numPokemon);

        while (displayOptions)
        {
            System.out.print("\n1. List Pokemon\n2. Add Pokemon\n3. Check a Pokemon’s Stats\n" +
                    "4. Evolve Pokemon\n5. Sort Pokemon\n6. Exit\n\nWhat would you like to do? ");

            try{
                int userResponse = scan.nextInt();
                switch(userResponse)
                {
                    case 1:
                        //list pokemon
                        int counter = 1;
                        for (String pokemon : myPokedex.listPokemon()){ //iterate through list contents
                            System.out.println(counter + ". " + pokemon);
                            counter++;
                        }
                        break;
                    case 2:
                        //adds new pokemon to the Pokedex.
                        myPokedex.addPokemon(getSpeciesOfInterest(1));
                        break;
                    case 3:
                        // check Pokemon stats.
                        statCheck(myPokedex);
                        break;
                    case 4:
                        //evolve a pokemon.
                       evolvingPokemon(myPokedex);
                        break;
                    case 5:
                        //Sort Pokemon.
                        myPokedex.sortPokedex();
                        break;
                    case 6:
                        //exit program.
                        displayOptions = false;
                        return;
                    default:
                        System.out.println("");
                        System.out.println("That is not a valid choice. Try again.");
                }
            } catch(InputMismatchException e)
            {
                System.out.println("");
                System.out.println("That is not a valid choice. Try again.");
                scan.nextLine();
            }
        }

    }

    public static void statCheck(Pokedex myPokedex){
        //gets the stats from pokedex and prints them
        String species = getSpeciesOfInterest(2);

        if (myPokedex.getPokemonIndex(species) != -1)
        {
            //checks to ensure the pokemon is in Pokedex.
            int[] statList = myPokedex.checkStats(species);
            System.out.println("");
            System.out.println("The stats for " + species + " are:");
            System.out.println("Attack: " + statList[0] + "\nDefense: " + statList[1] +
                    "\nSpeed: " + statList[2]);
        }
        else
            System.out.println("Missing");
    }
    public static void evolvingPokemon(Pokedex myPokedex)
    { //evolves the supplied pokemon
        String species = getSpeciesOfInterest(2);
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
    public static String getSpeciesOfInterest(int printOption)
    { //takes in user input
        System.out.println("");
        if(printOption == 1) System.out.print("Please enter the Pokemon’s Species: ");
        else if (printOption == 2) System.out.print("Please enter the Pokemon of interest: ");
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }
}
