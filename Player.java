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
   private int energy = 0;

   /**
   * Constructor for Player.
   */
   public Player(String newName, Pokemon newPoke) {
       this.name = newName;
       this.energy = energy;
       this.poke = newPoke;
   }
   /**
   * Constructor with no parameters.
   */
   public Player() {
       this.name = name;
       this.energy = energy;
       this.poke = poke;
   }
   
   
   public String toString() {
      String s = "";
      s = "Player: " + this.name;
      s = s + "\nEnergy: " + this.energy;
      s = s + "\nPokemon: \n" + this.poke;
      return s;
   }
   
   public String status() {
      String s = "";
      s = s + "Your Hp: " + getHp();
      s = s + "\nYour attack energy: " + getEnergy();
      return s;
   }
   
   /**
   * The player performs a fast attack on opponent.
   * @param The opponent player
   * @return Player The opponent player with their updated hp
   */
   public Player fastAttack(Player opponent){
      String s = "";
      Player p = opponent;
      
      s = this.poke.performFastAttack(p.getPoke());
      System.out.println(s);
      return p;
   }
   
   /**
   * The player performs a special attack on opponent.
   * @param The opponent player
   * @return Player The opponent player with their updated hp
   */
   public Player specialAttack(Player opponent){
      String s = "";
      Player p = opponent;
      
      this.energy = energy - 3;
      s = this.poke.performSpecialAttack(p.getPoke());
      System.out.println(s);
      return p;
   }
   
   /**
   * Gives the player one energy when they pass.
   */
   public void passTurn(){
      this.energy = energy + 1;
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