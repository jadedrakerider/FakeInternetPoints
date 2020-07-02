import java.util.Random;

class Main {
  public static void main(String[] args) {
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

    enemy = new Enemy();
    battle = new Battle(player,enemy,5);

    battle.commence();

    Random r = new Random();
    
    while(true){
      battle = new Battle(player,enemy,r.nextInt(9)+1);
      battle.commence();
    }

    
  }
}