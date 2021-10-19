import java.util.*;
/**
* Game interface.
* @author Danny Luu, Satoko Yajima, Ula Nicholas, Jakob Oxinio
* @since .....
*/
public class PokemonGameAssignment5Ula {
   
   /* range for player randomizer */ 
   static final int RANGE = 2; 

   /**
   * Main method
   * @param args not used
   */
   public static void main(String[] args) {
      //Scanner and Random number generator
      Scanner userIn = new Scanner(System.in);
      Random randGen = new Random();
      
      String tempString = "";
      
      // variables
      int i = 0;
      boolean endloop = false;
      String tempName = "";
      Pokemon tempPoke = new Bulbasaur();
      Player playerOne = new Player();
      Player playerTwo = new Player();

      
      
      
      // player 1 object creation
      System.out.println("Player 1 please enter your name.");
      tempName = userIn.nextLine();
      tempName = tempName.trim();
      System.out.println(tempName + " select your pokemon");
      tempPoke = choosePokemon();    
      Player p1 = new Player(tempName, tempPoke);
     
      // player 2 object creation 
      System.out.println("Player 2 please enter your name.");
      tempName = userIn.nextLine();
      tempName = tempName.trim();
      System.out.println(tempName + " select your Pokemon");
      tempPoke = choosePokemon();
      Player p2 = new Player(tempName, tempPoke);
      
      //Randomize the positions of p1 and p2
      i = randGen.nextInt(RANGE);
      if(i == 0){
      
        playerOne = p1;
        playerTwo = p2;
        
      } else {
      
        playerOne = p2;
        playerTwo = p1;
      } 
      
      // Signal end of game once Player HP 0
      while(!endloop) {
         System.out.println(playerOne.getName() + ", it is your turn!");
         playerOne.getStatus();
         System.out.println(playerTwo.getName() + "ʻs HP: " + playerTwo.getHP());
         battle(playerOne, p1);
         if (playerTwo.getHP == 0) {
            System.out.println(playerOne.getName() + "You Won!");
            endloop = true; 
         } else {
            System.out.println(playerTwo.getName() + ", it is your turn!");
            playerTwo.getStatus();
            System.out.println(playerOne.getName() + "ʻs HP: " + playerOne.getHP());
            battle(playerTwo, p1);
         } if (playerOne.getHP == 0) {
            System.out.println(playerTwo.getName() + "You Won!");
            endloop = true;
         }
      
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