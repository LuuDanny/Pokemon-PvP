import java.util.Scanner;

public class tesDriver {
   public static void main (String []args) {
   
      Pokemon pokeOne = new Squirtle();
      Pokemon pokeTwo = new Charmander();
      Player p1= new Player("  ",pokeOne);
      Player p2= new Player("  ",pokeTwo);
      System.out.println("Player1 HP :"+ p1.getHp());
      System.out.println("Player1 energy:"+ p1.getEnergy());
      System.out.println("********");
   
      System.out.println(p2.getHp());
      System.out.println(p2.getEnergy());
      Battle(p1,p2);
   
      System.out.println(p1.getEnergy());
      System.out.println(p2.getHp());
   
   }
    //when superattack ocor, 
    //player lose energy and attack opponent
   public static void  Battle (Player p1, Player p2) {
      Scanner myObj = new Scanner(System.in);  // Create a Scanner object
      String choice = "";
      Player attacker = p1;
      Player opponent = p2;
      boolean inputOk = true;
      
      
      
      
      /*
      in main method, there is same things 
      */

      do {
      //eventhough user enter invalid thing,
      //run and get in do loop 
         inputOk = true;
         System.out.println("What do you want to do?");
         System.out.println("1. pass to build energy");
         System.out.println("2. perform fast Attack");
         if(attacker.getEnergy() >= 3) {
            System.out.println("3.perform Special Attack");
         }
         choice = myObj.nextLine();  // Read user input
     
              switch (choice) {
         
         //pass to build energy
         //it works
            case "1" :
            //when I get information from another class, 
            //i need to  variable.methodname();
               attacker.passTurn();
               System.out.println(attacker.getName() + " Your energy is now "+ attacker.getEnergy());
               break;
         
         // perform fastAttack
            case "2": 
               opponent = attacker.fastAttack(opponent); 
               break; 
              
            case "3": 
            //if attacker chose 3,specialAttack
               opponent = attacker.specialAttack(opponent);
               System.out.println("Speacial Attack");
               break;
            
            default:
               inputOk = false; 
               System.out.println("You did not print valid number.");
               break;
         }
      }
      while(!inputOk);
  
   /*
// in Battle method,damage is calcurated already  

     
   /**
   * Damage method.
   * It print if either player's hp is low
   */
   
   
   public static Player Damage(Player p1, Player p2, int a) {
      // who can I define which is player and which is opponent?
      Player attacker = p1;
      Player opponent = p2;
      // I'm confused by player 1 and player2 
      //and which is attacker and which is opponent 

   int a;
      if (a == 1) {
      //chooseFastAttack method from Pokemon.java
         attacker.chooseFastAttack(opponent);
      }
      else {
      //chooseSpecialAttack method from Pokemon.java
         player.SpecialAttack(opponent);
      }
       
       // opponent hp
      if (opponent.getHp <= 0) {
      //should it say like player 1's pokemon fainted instead of opponent?
         System.out.println("oppenent pokemon fainted");
      }
      else {
      
      //should it say like player 1's hp left instead of opponent?
         System.out.prinln("oppent hp left");
      }
       return player(opponent); 
   }

}