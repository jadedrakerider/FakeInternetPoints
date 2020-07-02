public class Enemy
{
  int maxHP;
  int currentHP;
  int attackRating;

  Enemy()
  {
    this.maxHP = 5;
    this.currentHP = maxHP;
    this.attackRating = 1;
  }

  Enemy(int maxHP, int attackRating)
  {
    this.maxHP = maxHP;
    this.currentHP = maxHP;
    this.attackRating = attackRating;
  }

  void fights(Player player)
  {
    int newHP = player.getCurrentHP() - this.attackRating();
    player.setCurrentHP( newHP );
  }

}