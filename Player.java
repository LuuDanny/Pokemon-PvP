/**
* Player object class.
* @author Lisa Miller
* @since 10/17/2021
*/
public class Player {

/**
   * Constructor for Player.
   */
   public Player(String name, Pokemon poke) {
      super("Bulbasaur", "Bulbasaur", 1, GRASS_COLOR, 0.71, 6.9, 
        GRASS_TYPE, POISON_TYPE, BASE_ATTACK_POWER, 
        BASE_DEFENSE_POWER, BASE_STAMINA_POWER);   
      //pick Attacks after construct
      chooseFastAttack();
      chooseSpecialAttack();
   }





}