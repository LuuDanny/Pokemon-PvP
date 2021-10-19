import java.util.Scanner;
/**
* tesDriver.
* @author qqqqqqqqqqqq
* @since 21/32/1098
*/
public class tesDriver {
/**
* main method.
* @param args not used
* @param args not used
*/

   public static void main(String []args) {
      Pokemon pokeOne = new Squirtle();
      Pokemon pokeTwo = new Charmander();
      Player p1 = new Player("  ", pokeOne);
      Player p2 = new Player("  ", pokeTwo);
      System.out.println("Player1 HP: " + p1.getHp());
      System.out.println("Player1 energy: " + p1.getEnergy());
      System.out.println("********");
   
      System.out.println("Player2 HP: " + p2.getHp());
      System.out.println("Player2 energy: " + p2.getEnergy());
      battle(p1, p2);
   
      System.out.println("Now Player1 energy: " + p1.getEnergy());
      System.out.println("NowPlayer2 HP: " + p2.getHp());
   
   }   
   
/**
* Battle method.
* The 
* @param p1 Player object 
* @param p2 Player object 
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
               System.out.println("Speacial Attack");
               break;
            default: //Invalid choice
               inputOk = false; 
               System.out.println("You did not print valid number.");
               System.out.println("Please enter a number from 1 to 3.");
               break;
         }
      }
      while(!inputOk);
   }
}