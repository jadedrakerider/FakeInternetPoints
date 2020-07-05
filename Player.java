import java.util.LinkedList; 

public class Player extends Entity {

  int accumulatedXP;
  int level;
  LinkedList<Item> inventory = new LinkedList<Item>();

  // Constructors
  Player()
  {
    super();
    this.setAccumulatedXP(0);
    this.setLevel(0);
  }

  Player(int maxHP, int attackRating)
  {
    super(maxHP, attackRating);
    this.setAccumulatedXP(0);
    this.setLevel(0);
  }

  //Getters and Setters
  public int getAccumulatedXP()
  {
    return this.accumulatedXP;
  }

  public void setAccumulatedXP(int XP)
  {
    this.accumulatedXP = XP;
  }

  public int getLevel()
  {
    return this.level;
  }

  public void setLevel(int i)
  {
    this.level = i;
  }

// Functional Methods

  public void addItemToInventory(Item item)
  {
    this.inventory.add(item);
  }

  public void useItemInInventory(int index)
  {
    switch (this.inventory.get(index).getItemType()){
      case POTION:
        this.drink((Potion)this.inventory.get(index));
        break;
      default:
        System.out.println("useItemInInventory(index) default value");
        break;
    } 
  }

  public void drink(Potion potion)
  {
    System.out.println("Old HP Total: " + this.getCurrentHP());
    this.setCurrentHP(this.getCurrentHP() + potion.getHPRecovery());
    System.out.println("New HP Total: " + this.getCurrentHP());
  } 

  public void fights(Enemy enemy)
  {
    int currentHP = enemy.getCurrentHP() - this.getAttackRating();
    enemy.setCurrentHP(currentHP);

    if(!enemy.isAlive())
    {
      int accumulatedXP = this.getAccumulatedXP() + enemy.getXP();
      this.setAccumulatedXP(accumulatedXP);
      this.levelUp();
    }
    
  }

  private void levelUp(){
//    incrementLevel 12*level+12
    int currentLevel = this.getLevel();
    if(this.getAccumulatedXP() / ((12*currentLevel)+12) >= 1)
    {
      this.setAccumulatedXP(this.getAccumulatedXP() % ((12*currentLevel)+12));
      this.setLevel( this.getLevel()+1 );
      this.maxHeal();
    }
  }
  
  public void maxHeal()
  {
    this.setCurrentHP(this.maxHP);
  }

  
  
}