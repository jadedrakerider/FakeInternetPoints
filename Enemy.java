public class Enemy extends Entity
{

  int XP;
  ItemSpawner itemSpawner = new ItemSpawner();

  Enemy()
  {
    super(5,1);
    this.setXP(1);
  }

  Enemy(int maxHP, int attackRating)
  {
    super(maxHP,attackRating);
    this.setXP(1);
  }

  public Item getItem()
  {
    return this.itemSpawner.getItem();
  }

  public int getXP(){
    return this.XP;
  }

  public void setXP(int XP){
    this.XP = XP;
  }

  void fights(Player player)
  {
    int newHP = player.getCurrentHP() - this.getAttackRating();
    player.setCurrentHP( newHP );
  }

}