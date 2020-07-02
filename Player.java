public class Player extends Entity {

  Player(){
    super();
  }

  Player(int maxHP, int attackRating){
    super(maxHP, attackRating);
  }

  public void fights(Enemy enemy)
  {
    int currentHP = enemy.getCurrentHP() - this.getAttackRating();
    enemy.setCurrentHP(currentHP);
    
    System.out.println("Enemy HP: " + enemy.getCurrentHP());
  }

  public void maxHeal()
  {
    this.setCurrentHP(this.maxHP);
    System.out.println("Player healed to max health: "+this.getCurrentHP());
  }

}