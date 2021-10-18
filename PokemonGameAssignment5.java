import java.util.*;
/**
* Game interface.
* @author Danny Luu, Satoko Yajima, Ula Nicholas, Jakob Oxinio
* @since .....
*/
public class PokemonGameAssignment5 {
   /**
   * Main method
   * @param args not used
   */
   public static void main(String[] args) {
      //Scanner and Random number generator
      Scanner userIn = new Scanner(System.in);
      Random randGen = new Random();
      
      String tempString = "";
      boolean endloop = false;
      
      String name = "";
      int i = 0;
      
      Pokemon tempPoke = new Bulbasaur();
      
      System.out.println("Player 1 please enter your name.");
      name = userIn.nextLine();
      
      System.out.println(name + " select your pokemon");
      tempPoke = choosePokemon();
      
      //Gets first players name and pokemon, sends to constructor
      Player p1 = new Player(name, tempPoke);
      
      System.out.println("Player 2 please enter your name.");
      name = userIn.nextLine();
      
      System.out.println(name + " select your Pokemon");
      tempPoke = choosePokemon();
      //Gets second players name and pokemon, sends to constructor
      Player p2 = new Player(name, tempPoke);
      
      //Randomize who is going first
      i = randGen.nextInt(2);
      if(i == 0){
      
        Player playerOne = p1;
      
      } else {
      
        Player playerOne = p2;
         
      } 
      
      while(!endloop) {
         //Text based menu
         //System.out.println(player.toString());
         System.out.println("What would you like to do?");
         System.out.println("\t1. Pass turn to build energy");
         System.out.println("\t2. Perform fast attack");
         System.out.println("\t3. Perform special attack");
         
         //Gets user choice what to do between 1-3
         tempString = userIn.nextLine();
         
         switch(tempString) {
            case "1": //EnergyBuild();
               break;
            case "2": //Battle(playerOne, playerTwo);
               break;
            case "3":
               break;
            default: System.out.println("That was an invalid entry.");
               break;      
         } //Switch statements
      
      } //While loop
   
   } //Main method
   
   
   /*
   //============= choosePokemon ==================
   /**
   * Creates a pokemon object from a selection of 9.
   * @return a Pokemon object
   */
   public static Pokemon choosePokemon() {
      Pokemon poke = new Bulbasaur();
      Scanner userIn = new Scanner(System.in);
      int choiceNum = 0;
      String choice = new String("");
      boolean endLoop = true;
      do {
         // menu text
         System.out.println("Please enter a number to choose your Pokemon:");
         System.out.println("\t1 for Bulbasaur");
         System.out.println("\t2 for Ivysaur");
         System.out.println("\t3 for Venusaur");
         System.out.println("\t4 for Charmander");
         System.out.println("\t5 for Charmeleon");
         System.out.println("\t6 for Charizard");
         System.out.println("\t7 for Squirtle");
         System.out.println("\t8 for Wartortle");
         System.out.println("\t9 for Blastoise");
         
         //Reads user's choice
         choice = userIn.nextLine();
         choice = choice.trim();
      
         switch (choice) {
            case "1":
                  poke = new Bulbasaur();
                  break;
            case "2":
                  poke = new Ivysaur();
                  break;
            case "3":
                  poke = new Venusaur();
                  break;
            case "4":
                  poke = new Charmander();
                  break;
            case "5":
                  poke = new Charmeleon();
                  break;
            case "6":
                  poke = new Charizard();
                  break;
            case "7":
                  poke = new Squirtle();
                  break;
            case "8":
                  poke = new Wartortle();
                  break;
            case "9":
                  poke = new Blastoise();
                  break;
            default:
                  endLoop = false;
                  System.out.println("\n****Invalid menu choice.****");
                  System.out.println("Please enter a number from 1 to 9\n");
                  break; 
         } // Closes Switch
      } while (!endLoop);
      return poke;
   } // Closes makePokemon

} //Class