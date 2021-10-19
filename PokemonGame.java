import java.util.Random;
import java.util.Scanner;
/**
* Emulates a pokemon battle between two players through a text based menu.
* @author Danny Luu, Satoko Yajima, Ula Nicholas, Jakob Oxinio
* @since 10/19/2021
*/
public class PokemonGame {
   
   /** int range for player randomizer. */ 
   static final int RANGE = 2; 
   
   /**
   * Main method.
   * @param args not used
   */
   public static void main(String[] args) {

      int i = 0;
      boolean endloop = false;
      String tempName = "";
      Pokemon tempPoke = new Bulbasaur();
      Player playerOne = new Player();
      Player playerTwo = new Player();
      Scanner userIn = new Scanner(System.in);
      Random randGen = new Random();
      
      // player 1 object creation
      System.out.println("Player 1 please enter your name.");
      tempName = userIn.nextLine();
      tempName = tempName.trim();
      System.out.println(tempName + " select your pokemon");
      tempPoke = choosePokemon();    
      Player p1 = new Player(tempName, tempPoke);
      System.out.println(p1.getName() + ", here is your pokemon.");
      System.out.println(p1.getPoke());
     
      // player 2 object creation 
      System.out.println("Player 2 please enter your name.");
      tempName = userIn.nextLine();
      tempName = tempName.trim();
      System.out.println(tempName + " select your Pokemon");
      tempPoke = choosePokemon();
      Player p2 = new Player(tempName, tempPoke);
      System.out.println(p1.getName() + ", here is your pokemon.");
      System.out.println(p1.getPoke());
      
      //Randomize the positions of p1 and p2
      i = randGen.nextInt(RANGE);
      if (i == 0) {
         playerOne = p1;
         playerTwo = p2;
        
      } else {
         playerOne = p2;
         playerTwo = p1;
      } 
      
      // Battle Loop
      while (!endloop) {
         System.out.println("====================");
         System.out.println(playerOne.getName() + ", it is your turn!");
         System.out.println(playerOne.status());
         System.out.println(playerTwo.getName() + "'s HP: " + playerTwo.getHp());
         battle(playerOne, playerTwo);
         
         //Check if playerTwo has fainted
         if (playerTwo.getHp() == 0) {
            System.out.println(playerOne.getName() + ", You Won!");
            endloop = true; 
         } else { //Continue game if still alive
            System.out.println("====================");
            System.out.println(playerTwo.getName() + ", it is your turn!");
            System.out.println(playerTwo.status());
            System.out.println(playerOne.getName() + "'s HP: " + playerOne.getHp());
            battle(playerTwo, playerOne);
         } 
         //Check if playerOne has fainted
         if (playerOne.getHp() == 0) {
            System.out.println(playerTwo.getName() + ", You Won!");
            endloop = true;
         }
      } //While loop
   } //Main method
   
   

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
         //Text based menu for Pokemon options
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
         
         choice = userIn.nextLine();
         choice = choice.trim();
         
         // Switch based on player's choise
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
   } // Closes makePokemon method
   
   /**
   * Emulates a pokemon battle between two players.
   * @param p1 The attacking Player
   * @param p2 The defending Player
   */
   // I needed to change Battle method name is battle method
   public static void  battle(Player p1, Player p2) {
     
      Scanner myObj = new Scanner(System.in);  
      String choice = "";
      Player attacker = p1;
      Player opponent = p2;
      boolean inputOk = true;
         
      do {
         //Reset value back to true
         inputOk = true; 
         
         //Text based menu for battle options
         System.out.println("What do you want to do?");
         System.out.println("1. pass to build energy");
         System.out.println("2. perform fast Attack");
         //Display special attack option if energy is sufficient
         if (attacker.getEnergy() >= 3) { 
            System.out.println("3.perform Special Attack");
         }
         choice = myObj.nextLine(); 
         choice = choice.trim();
         
         // Switch based on player's choise
         switch (choice) {
            case "1" : //Pass turn
               attacker.passTurn();
               System.out.println(attacker.getName() + " Your energy is now "
                     + attacker.getEnergy());
               break;
            case "2": //Perform fastAttack
               opponent = attacker.fastAttack(opponent); 
               break; 
              
            case "3": //Perform special Attack
               opponent = attacker.specialAttack(opponent);
               break;
            default: //Invalid choice
               inputOk = false; 
               System.out.println("You did not print valid number.");
               System.out.println("Please enter a number from 1 to 3.");
               break;
         }
      } while(!inputOk);
   } // Closes battle method
} //Closes Class