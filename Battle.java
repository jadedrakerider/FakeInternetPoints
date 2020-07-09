import java.util.LinkedList; 
import java.time.*;

class Battle 
{
  
  LinkedList<Enemy> enemies = new LinkedList<Enemy>();
  Player player;
  static int counter = 0;
  
  //Constructors
  Battle(Player player, Enemy enemy)
  {
    this(player,enemy,1);
    counter++;
  }

  Battle(Player player, Enemy enemy, int quantity)
  {
    this.player = player;

    for(int i = 0; i < quantity ; i++)
    {
      enemies.add(new Enemy(enemy.getMaxHP(), enemy.getAttackRating()));
    }

    counter++;

  }

  Battle(Player player, LinkedList<Enemy> enemies)
  {
    this.player = player;
    this.enemies = enemies;
    counter++;
  }

  // Getters and Setters

  // Functional Methods
  /*  implements the battle action.
      loops check to see if the player is still alive.
      Initial for loop iterates through the LinkedList of enemies for the 
        player to fight. 
      Then two entities fight(). 
  */ 
  void commence()
  {
    for(int i = 0 ; i < enemies.size() && player.isAlive() ; i++)
    {
      System.out.println("Battling enemy number "+ (i+1));
      pauseBattle();
      Enemy currentEnemy = enemies.get(i);
      
      while(currentEnemy.isAlive() && player.isAlive())
      {
        currentEnemy.fights(player);
        player.fights(currentEnemy);
        System.out.println("Player's HP: " + player.getCurrentHP());
      }
    }
  }

  //pauseBattle() pauses the battle for 1 second
  void pauseBattle(){ 
    try 
    {
      Thread.sleep(1000);
    }
    catch(InterruptedException ex) 
    {
      Thread.currentThread().interrupt();
    }
  }

}