public class Main {
    public static void main(String[] args){
        Pokemon dude = new Pokemon("hola");
        System.out.println(dude.getAttack());
        dude.setAttack(4);
        System.out.println(dude.getAttack());
    }
}
