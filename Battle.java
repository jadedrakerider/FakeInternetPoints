import java.util.LinkedList; 

class Battle{
  
  LinkedList<Enemy> enemies = new LinkedList<Enemy>();
  Player player;
  
  
  Battle(Player player, Enemy enemy)
  {
    this(player,enemy,1);
  }

  Battle(Player player, Enemy enemy, int quantity)
  {
    this.player = player;

    for(int i = 0; i < quantity ; i++)
    {
      enemies.add(new Enemy(enemy.getMaxHP(), enemy.getAttackRating()));
    }

  }

  void commence()
  {
    for(int i = 0 ; i < enemies.size() ; i++)
    {
      System.out.println("Battling enemy number "+ (i+1));
      Enemy currentEnemy = enemies.get(i);
      while(currentEnemy.isAlive() && player.isAlive() )
      {
        currentEnemy.fights(player);
        player.fights(currentEnemy);
      }
    }
    // player.maxHeal();
  }

}