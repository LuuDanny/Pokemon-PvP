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
      boolean reChoose = true;
      String tempName = "";
      String yesNo = "";
      Pokemon tempPoke = new Bulbasaur();
      Player playerOne = new Player();
      Player playerTwo = new Player();
      Scanner userIn = new Scanner(System.in);
      Random randGen = new Random();
      
      
      // player 1 object creation
      System.out.println("Player 1" + " \nPlease enter your name.");
      tempName = userIn.nextLine();
      System.out.println("Please select your pokemon");
      tempPoke = choosePokemon();    
      Player p1 = new Player(tempName, tempPoke);
      System.out.println("You have chosen " + p1.getPoke().getSpecies() 
            + " as your pokemon.");
      System.out.println(p1.getPoke());
      tempPoke = reChoose(tempPoke);
      p1.setPoke(tempPoke);     
     
     
     
      // player 2 object creation
      System.out.println("======================================"); 
      System.out.println("Player 2" + " \nPlease enter your name.");
      tempName = userIn.nextLine();
      System.out.println("Please select your Pokemon");
      tempPoke = choosePokemon();
      Player p2 = new Player(tempName, tempPoke);
      System.out.println("You have chosen " + p2.getPoke().getSpecies() 
            + " as your pokemon.");
      System.out.println(p2.getPoke());
      tempPoke = reChoose(tempPoke);
      p2.setPoke(tempPoke);     

      
      //Randomize the positions of p1 and p2
      i = randGen.nextInt(RANGE);
      if (i == 0) {
         playerOne = p1;
         playerTwo = p2;
        
      } else {
         playerOne = p2;
         playerTwo = p1;
      } 
      
      //Assign player's position as their name if their name is empty.
      if (playerOne.getName().equals("")) {
         playerOne.setName("Player One");
      }
      if (playerTwo.getName().equals("")) {
         playerTwo.setName("Player Two");
      }
      
      System.out.println("\n===============================");
      System.out.println(playerOne.getName() + "(" 
            + playerOne.getPoke().getSpecies() + ")"
            + " VS " + playerTwo.getName() + "(" 
            + playerTwo.getPoke().getSpecies() + ")");
      System.out.println("===============================");
      
      // Battle Loop
      while (!endloop) { 
         System.out.println(playerOne.getName() + ", it is your turn!");
         System.out.println(playerOne.status());
         System.out.println(playerTwo.getName() + "'s HP: " 
               + playerTwo.getHp());
         battle(playerOne, playerTwo);
         System.out.println("======================================");
         
         //Check if playerTwo has fainted
         if (playerTwo.getHp() == 0) {
            System.out.println(playerOne.getName() + ", You Won!");
            endloop = true; 
         } else { //Continue game if still alive
            System.out.println(playerTwo.getName() + ", it is your turn!");
            System.out.println(playerTwo.status());
            System.out.println(playerOne.getName() + "'s HP: " 
                  + playerOne.getHp());
            battle(playerTwo, playerOne);
            System.out.println("======================================");
         } 
         //Check if playerOne has fainted
         if (playerOne.getHp() == 0) {
            System.out.println(playerTwo.getName() + ", You Won!");
            endloop = true;
         }
      } //Close Battle loop
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
         //Reset value back to true
         endLoop = true;
      
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
               System.out.println("\n=======Invalid Menu Choice=======");
               System.out.println("Please enter a number from 1 to 9");
               System.out.println("=================================\n");
               break; 
         } // Closes Switch
      } while (!endLoop);
      return poke;
   } // Closes makePokemon method
   
   /**
   * Reselection of Pokemon.
   * @param p Original Pokemon
   * @return a Pokemon object
   */   
   public static Pokemon reChoose(Pokemon p) {
      Scanner userIn = new Scanner(System.in);
      Pokemon poke = p;
      boolean reChoose = true;
      String yesNo = "";
      while (reChoose) {
         System.out.println("Would you like to reroll your pokemon? Y/N");
         yesNo = userIn.nextLine();
         yesNo = yesNo.trim();
         yesNo = yesNo.toUpperCase();
         switch (yesNo) {
            case "Y": 
               poke = choosePokemon(); 
               System.out.println(poke);
                               
               break;
            case "N":
               reChoose = false;
               break;
         
            default:
               System.out.println("\n=======Invalid Menu Choice=======");
               System.out.println("Please enter Y/N");
               System.out.println("=================================\n");
               break;
               
           
         }
      
      
      }
   
      return poke;
   }  
   
   
   
   
   
   
   /**
   * Emulates a pokemon battle between two players.
   * @param p1 The attacking Player
   * @param p2 The defending Player
   */
   // I needed to change Battle method name is battle method
   public static void  battle(Player p1, Player p2) {
     
      int previousHp = 0;
      int currentHp = 0;
      int damageTaken = 0;
      boolean inputOk = true;
      String choice = "";
      Player attacker = p1;
      Player opponent = p2;
      Scanner myObj = new Scanner(System.in); 
         
      do {
         //Reset value back to true
         inputOk = true; 
         
         //Text based menu for battle options
         System.out.println("\nWhat do you want to do?");
         System.out.println("1. Pass to build energy");
         System.out.println("2. Perform fast Attack");
         //Display special attack option if energy is sufficient
         if (attacker.getEnergy() >= 3) { 
            System.out.println("3. Perform Special Attack");
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
               previousHp = opponent.getHp();
               opponent = attacker.fastAttack(opponent);
               currentHp = opponent.getHp();
               damageTaken = previousHp - currentHp;
               System.out.println(opponent.getPoke().getSpecies() + " took " 
                     + damageTaken + " damage!"); 
               break; 
              
            case "3": //Perform special Attack
               if (attacker.getEnergy() >= 3) { 
                  previousHp = opponent.getHp();
                  opponent = attacker.specialAttack(opponent);
                  currentHp = opponent.getHp();
                  damageTaken = previousHp - currentHp;
                  System.out.println(opponent.getPoke().getSpecies() + " took " 
                        + damageTaken + " damage!");
               } else {
                  System.out.println(attacker.getPoke().getSpecies() 
                        + " failed to use it's special attack!");
                  System.out.println("Not enough energy!");
               }
               break;
            default: //Invalid choice
               inputOk = false; 
               System.out.println("\n=======Invalid Menu Choice=======");
               System.out.println("Please enter a number from 1 to 3");
               System.out.println("=================================\n");
               break;
         }
      } while (!inputOk);
   } // Closes battle method
} //Closes Class
