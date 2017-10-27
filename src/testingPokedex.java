public class testingPokedex {
    public static void main(String[] args){
        Pokemon dude = new Pokemon("Charmander");
        System.out.println(dude.getSpeed());
        System.out.println(dude.getDefense());
        System.out.println(dude.getAttack());
        dude.evolve();
        System.out.println(dude.getSpecies() + " has evolved!! His new stats are: ");
        System.out.println(dude.getSpeed());
        System.out.println(dude.getDefense());
        System.out.println(dude.getAttack());
    }
}
