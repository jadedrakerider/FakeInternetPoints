public class Enemy extends Entity
{

  Enemy()
  {
    super(5,1);
  }

  Enemy(int maxHP, int attackRating)
  {
    super(maxHP,attackRating);
  }

  void fights(Player player)
  {
    int newHP = player.getCurrentHP() - this.getAttackRating();
    player.setCurrentHP( newHP );
    System.out.println("Player HP: " + player.getCurrentHP());
  }

}