public class Player{

  int maxHP;
  int currentHP;
  int attackRating;

  Player()
  {
    this.maxHP = 100;
    this.currentHP = this.maxHP;
    this.attackRating = 2;
  }

  Player(int maxHP, int attackRating)
  {
    this.maxHP = maxHP;
    this.currentHP = this.maxHP;
    this.attackRating = attackRating;
  }

  public int getCurrentHP()
  {
    return this.currentHP;
  }

  public void setCurrentHP(int currentHP)
  {
    this.currentHP = currentHP;
  }

  public int getAttackRating()
  {
    return this.attackRating;
  }

  public void setAttackRating(int attackRating)
  {
    this.attackRating = attackRating;
  }

}