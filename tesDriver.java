import java.util.Scanner;

public class tesDriver {
   public static void main (String []args) {
   
      Pokemon pokeOne = new Squirtle();
      Pokemon pokeTwo = new Charmander();
      Player p1= new Player("  ",pokeOne);
      Player p2= new Player("  ",pokeTwo);
      System.out.println("Player1 HP: "+ p1.getHp());
      System.out.println("Player1 energy: "+ p1.getEnergy());
      System.out.println("********");
   
      System.out.println("Player2 HP: "+ p2.getHp());
      System.out.println("Player2 energy: "+p2.getEnergy());
      Battle(p1,p2);
   
      System.out.println("Now Player1 energy: " + p1.getEnergy());
      System.out.println("NowPlayer2 HP: " + p2.getHp());
   
   }   
    //when superAttack occor, 
    //in Player.java line14 
    //player lose energy and attack opponent
   
   public static void  Battle (Player p1, Player p2) {
      Scanner myObj = new Scanner(System.in);  // Create a Scanner object
      String choice = "";
      Player attacker = p1;
      Player opponent = p2;
      boolean inputOk = true;
      boolean pokeIsOk = true;
      //if either p1 or p2's hp is 0
      //I need loop for uer hp = 0
      pokeIsOk = p1.getHp()>0 || p2.getHp()>0;
      
      
            
      /*
      in main method, there is same things 
      */
      
      
      // I do not need do loop things
      // in main method.
         do {
         //eventhough user enter invalid thing,
         //run and get in do loop once.
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
      }
   
  // need to loop while either p1 or p2' hp is more than 0
  // need to have switch player.
    



 //Do I need damage method?
 //we jsut need stop when either p1 or p2 hp is 0? 
    

// in Battle method,damage is calcurated already  

     
        
}