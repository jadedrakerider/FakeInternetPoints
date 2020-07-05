import java.util.Random;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

class Main {
  public static void main(String[] args) 
  {
    Enemy enemy = new Enemy();
    Player player = new Player();

    System.out.println("Current enemy HP = " + enemy.getCurrentHP());

    System.out.println("Current Player HP = " + player.getCurrentHP());
    enemy.fights(player);
    System.out.println("Current Player HP = " + player.getCurrentHP());
    player.fights(enemy);
    System.out.println("Current enemy HP = " + enemy.getCurrentHP());

    Battle battle = new Battle(player,enemy);
    battle.commence();

    System.out.println("battle five enemies");

    player = new Player();
    enemy = new Enemy();
    battle = new Battle(player,enemy,5);

    battle.commence();

    Random r = new Random();
    
    battle = new Battle(player,enemy,r.nextInt(9)+1);
    battle.commence();

    player = new Player();
    battle = new Battle(player,enemy,24);
    battle.commence();

    assertEquals(1,player.getLevel());
    assertEquals(12,player.getAccumulatedXP());
  
    System.out.println("Player is alive = " + player.isAlive());
    

    // while(player.isAlive())
    // {
    //   battle = new Battle(player,enemy,r.nextInt(9)+1);
    //   battle.commence();
    // }

    System.out.println("last battle was battle: " + battle.counter);
    System.out.println("The player died at level: " + player.getLevel());
    
    Potion p = new Potion();

    System.out.println(p.getItemType());

    System.out.println("Player HP before potion: " + player.getCurrentHP());
    player.addItemToInventory(p);
    player.useItemInInventory(0);
    System.out.println("Player HP after potion: " + player.getCurrentHP());


  }



}