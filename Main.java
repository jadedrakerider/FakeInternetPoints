import java.util.Random;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

class Main {
  public static void main(String[] args) 
  {
    unitTesting();
    Enemy enemy = new Enemy();
    Player player = new Player();
    Battle battle;
    Random r = new Random();

    while(player.isAlive())
    {
      battle = new Battle(player,enemy,r.nextInt(9)+1);
      battle.commence();
    }

    System.out.println("Player is dead.");
  

  }

  public static boolean unitTesting()
  {
    Player player = new Player();
    Enemy enemy = new Enemy();

    return true;
  }



}