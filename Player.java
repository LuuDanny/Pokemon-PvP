/**
* Player object class.
* @author Danny Luu
* @since 10/17/2021
*/
public class Player {
   
   //============= Instance Variables ==================
   /** The Player's Name.*/
   private String name = "";
   /** The Player's Pokemon.*/
   private Pokemon poke = new Bulbasaur();
   /** The Player's Energy.*/
   private int energy = 0;

   /**
   * Constructor for Player.
   * @param newName The player's name
   * @param newPoke The player's pokemon
   */
   public Player(String newName, Pokemon newPoke) {
      this.setName(newName);
      this.energy = energy;
      this.poke = newPoke;
   }
   
   /**
   * Constructor for Player with no parameters.
   */
   public Player() {
      this.name = name;
      this.energy = energy;
      this.poke = poke;
   }
   
   /**
   * Returns Player's information as a formatted String.
   * @return String representing Player object data.
   */
   public String toString() {
      String s = "";
      s = "Player: " + this.name;
      s = s + "\nEnergy: " + this.energy;
      s = s + "\nPokemon: \n" + this.poke;
      return s;
   }
   
   /**
   * Returns Player's status as a formatted String.
   * @return String representing Player's Hp and energy.
   */
   public String status() {
      String s = "";
      s = s + "Your Hp: " + getHp();
      s = s + "\nYour attack energy: " + getEnergy();
      return s;
   }
   
   /**
   * The player performs a fast attack on opponent.
   * @param opponent the defending player
   * @return Player The opponent player with their updated data
   */
   public Player fastAttack(Player opponent) {
      String s = "";
      Player p = opponent;
      
      s = this.poke.performFastAttack(p.getPoke());
      System.out.println(s);
      return p;
   }
   
   /**
   * The player performs a special attack on opponent.
   * @param opponent the defending player
   * @return Player The opponent player with their updated data
   */
   public Player specialAttack(Player opponent) {
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
   public void passTurn() {
      this.energy = energy + 1;
   }

   //============= getMethod ==================
   /**
   * Gets the Player's name.
   * @return String the Player's name
   */
   public String getName() {
      return this.name;
   }
   
   /**
   * Gets the Player's pokemon.
   * @return Pokemon the Player's pokemon
   */
   public Pokemon getPoke() {
      return this.poke;
   }
   
   /**
   * Gets the Player's energy.
   * @return int the Player's energy
   */
   public int getEnergy() {
      return this.energy;
   }
   
   /**
   * Gets the Player's Pokemon's Hp.
   * @return int the Player's energy
   */
   public int getHp() {
      return this.poke.getHP();
   }
   
   //============= setMethod ==================
   /** 
   * sets the Player's name.
   * @param updateName is the Player's updated name
   */
   public void setName(String updateName) {
      updateName = updateName.trim();
      this.name = updateName;
   } // Close name setMethod
   
   /** 
   * sets the Player's Pokemon.
   * @param updatePoke is the Player's updated Pokemon
   */
   public void setPoke(Pokemon updatePoke) {
      this.poke = updatePoke;
   } // Close name setMethod
   

}
