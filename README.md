# Pokemon Game
## Grading
 * 100 points for the game code.
   * **Due Thursday 10/21 at 11:59pm**
 * 10 points for writing a thorough code review.
   * For code review, each group should have a `develop` branch that holds a *beta* version of your game.
   * **Code reviews will be done in class Tues 10/19. Attendance (in-person or virtual with cameras) is required. Your game should be somewhat working.**
   * Each group will be reviewing another group's project together and combine their feedback in the pull request.
 * 10 points for using code reviewer suggestions and/or responding to your reviews in your pull request.

### Group Contributions
 * Each group member should fill out the [Group Contribution Google form](https://forms.gle/EnHgRkSDxLkGYfmW6) after the assignment is submitted.
 * If all contributions are roughly equal, each group member will recieve the same grade. If some members have not contributed equally, their grades will be adjusted accordingly.
 
 
 ## Instructions
 * Build a two player Pokemon Battle game/main method using your Pokemon object classes.
   * Two players will alternate turns on the same computer.
   
### Game Phase 1 - Game Setup
  * In the first phase of the game, each player will choose one Pokemon to battle with. There should be a menu offered to each player to choose one Pokemon to battle with.
    * This will be similar to your menu for choosing Pokemon in Assignment 4.
    * The program should ask Player 1 to choose their Pokemon, then save it, and give an acknowledgement message with the complete information about their chosen Pokemon.
    * Then it should ask Player 2 to choose their Pokemon, save it, and give an acknowledgement message with the complete information about their chosen Pokemon.
  * After both Pokemon are chosen, the game should *randomly* choose which Player goes first.
    * one of the most challenging parts of this assignment is to figure out how to alternate turns!
### Game Phase 2 - Battling
 * In the second (main game play) phase of the game, the two players should alternate turns, entering commands to attack until one Pokemon "faints" (reaches 0 HP).
 * Make sure to make your game fun to play, the players will need information at each turn to be able to decide their strategy. At each turn the program should output something like: 
 ```
  Player 1, it is your turn! 
    Your HP: 56
    Your attack energy: 1
    Player2's HP: 129
  What do you want to do?
   1. perform fastAttack
   2. perform specialAttack
   3. pass to build energy
 ```
 * The options each player has during their turn should be:
   1. perform fastAttack
   2. perform specialAttack
   3. pass to build energy
   
 * fastAttack and pass are always allowed. 
 * A player must "pass" at least three times in order to build up energy for a specialAttack.
   * You will have to develop a way to keep track of how many passes a player has made and when to allow the specialAttack as this is not part of the Pokemon objects.
   * After specialAttack is performed, the amount of accumulated passes should be reduced by 3.
 * The attacking functionality should use the Pokemon's performFastAttack and performSpecialAttack methods. The attacking player's Pokemon will call the method, with the other player's Pokemon as the "victim" parameter Pokemon. *You don't have to write anything to do with attacking*
  * The String returned by these methods should print to the screen.
 
 * You'll have to build a way to check the victim Pokemon's HP (hitPnts) after being attacked. This will be the sentinel value for the battle loop.
   * Once a Pokemon has its hitPnts reduced to 0, that signals the end of the game, with the other player as the winner.
   * **Make sure to stop the game immediately when a Pokemon faints. There should not be another turn allowed!**
 
### Game Phase 3 - Game Over
 * Once a player's Pokemon has fainted, the game should end and print out a congratulatory message to the winner.

## Assignment 5 Grading
----

- [x] **20/20** Menu for both players to pick their Pokemon
- [x] **20/20** Alternating turns
- [x] **20/20** Implementation of "passing" to charge Special Attack
- [x] **20/20** Tracking of HP, correct win/lose calculation.
- [x] **20/20** Comments, coding style, documentation.
