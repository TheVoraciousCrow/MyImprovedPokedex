import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        boolean displayOptions = true;
        boolean displayNumEntry = true;
        int numPokemon = 1;
        String species;
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to your new PokeDex!");
        while (displayNumEntry){
            try{
                System.out.println("How many pokemon are in your region: ");
                numPokemon = scan.nextInt();
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
        System.out.println("Your new Pokedex can hold "+  numPokemon +  " Pokemon. Let's start using it!\n");
        Pokedex myPokedex = new Pokedex(numPokemon);

        while (displayOptions){
            System.out.println("1. List Pokemon\n2. Add Pokemon\n3. Check Pokemon Stats\n" +
                    "4. Evolve Pokemon\n5. Sort Pokemon\n6. Exit\nWhat would you like to do?\n");
            try{
                int userResponse = scan.nextInt();
                switch(userResponse){
                    case 1:
                        //list pokemon
                        //myPokedex.listPokemon();
                        break;
                    case 2:
                        //add a pokemon
                        System.out.println("Please enter the Pokemon's Species: ");
                        myPokedex.addPokemon(scan.next());
                        break;
                    case 3:
                        // check Pokemon stats
                        species = getSpeciesOfInterest();
                        int[] statList = myPokedex.checkStats(species);
                        System.out.println("The stats for " + species + " are:");
                        System.out.println("Attack: " + statList[0] + "\nDefense: " + statList[1] +
                                            "\nSpeed: " + statList[2]);
                        break;
                    case 4:
                        //evolve a pokemon
                        species = getSpeciesOfInterest();
                        boolean speciesHasEvolved = false;
                        while(! speciesHasEvolved) {
                            if (myPokedex.getPokemonIndex(species) != -1) {
                                speciesHasEvolved = myPokedex.evolvePokemon(species); //returns true after evolution
                                System.out.println("" + species + " has evolved!");
                            }
                            else
                            System.out.print("Stats unknown; that species has not yet been discovered." +
                                    "\n Try another");
                        }
                        break;
                    case 5:
                        //Sort Pokemon
                        break;
                    case 6:
                        //exit program
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
    public static String getSpeciesOfInterest(){
        System.out.println("Please enter the species of interet: ");
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }
}
