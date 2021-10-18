/**
* Player object class.
* @author Danny Luu
* @since 10/17/2021
*/
public class Player {
   
   //============= Instance Variables ==================
   /** The Player's Name. */
   private String name = "";
   /** The Player's Pokemon*/
   private Pokemon poke = new Bulbasaur();
   /** The Player's Energy */
   private int energy = 3;

   /**
   * Constructor for Player.
   */
   public Player(String newName, Pokemon newPoke) {
       this.name = newName;
       this.poke = newPoke;
       this.energy = energy;
   }
   
   /**
   * The player performs a fast attack
   * @param 
   * @return 
   */
   public Player fastAttack(Player opponent){
      String s = "";
      Player p = opponent;
      s = this.poke.performFastAttack(p.getPoke());
      System.out.println(s);
      return p;
   }
   
   /**
   * Gives the player one energy when they pass.
   * @return int the Player's new energy
   */
   public int passTurn(){
      this.energy = energy++;
      return this.energy;
   }
   
   


   //============= getMethod ==================
   /**
   * Gets the Player's name.
   * @return String the Player's name
   */
   public String getName(){
      return this.name;
   }
   
   /**
   * Gets the Player's pokemon.
   * @return Pokemon the Player's pokemon
   */
   public Pokemon getPoke(){
      return this.poke;
   }
   
   /**
   * Gets the Player's energy.
   * @return int the Player's energy
   */
   public int getEnergy(){
      return this.energy;
   }
   
   /**
   * Gets the Player's Pokemon's Hp.
   * @return int the Player's energy
   */
   public int getHp(){
      return this.poke.getHP();
   }
   


}