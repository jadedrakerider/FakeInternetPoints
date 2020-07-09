import java.util.LinkedList; 

public class Entity
{

  int maxHP;
  int currentHP;
  int attackRating;

  // Constructors
  public Entity()
  {
    this.maxHP = 100;
    this.currentHP = this.maxHP;
    this.attackRating = 2;
  }

  public Entity(int maxHP, int attackRating)
  {
    this.maxHP = maxHP;
    this.currentHP = this.maxHP;
    this.attackRating = attackRating;
  }

  // Getters and Setters
  public int getMaxHP()
  {
    return this.maxHP;
  }

  public void setMaxHP(int maxHP)
  {
    this.maxHP = maxHP;
  }

  public int getCurrentHP()
  {
    return this.currentHP;
  }

  public void setCurrentHP(int currentHP)
  {
    if(currentHP <= 0)
    {
      this.currentHP = 0;
    } 
    else if (currentHP > this.getMaxHP())
    {
      this.currentHP = this.getMaxHP();
    }
    else
    {
      this.currentHP = currentHP;
    }
  }

  public int getAttackRating()
  {
    return this.attackRating;
  }

  public void setAttackRating(int attackRating)
  {
    this.attackRating = attackRating;
  }
  
  public boolean isAlive()
  {
    if (this.currentHP > 0)
    {
      return true;
    }
    else
    {
      return false;
    }
  }


}

class Player extends Entity 
{

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
    if(item != null)
    {
      this.inventory.add(item);
    }

    System.out.println("Size of inventory: " + this.inventory.size());
  }

  public void useItemInInventory(int index)
  {
    if(this.inventory.get(index).getItemType() == Item.ItemType.POTION)
    {
      this.drink((Potion)this.inventory.get(index));
      this.inventory.remove(index);
    }
    else
    {
      System.out.println("Player.useItemInInventory(int) is not of any known ItemType");
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

    if(this.needsPotion() && this.hasPotion())
    {
      this.useItemInInventory(0);
    }

    int newEnemyHP = enemy.getCurrentHP() - this.getAttackRating();
    enemy.setCurrentHP(newEnemyHP);

    if(!enemy.isAlive())
    {
      int playerAccumulatedXP = this.getAccumulatedXP() + enemy.getXP();
      this.setAccumulatedXP(playerAccumulatedXP);
      this.levelUp();
      if(enemy.getItem() != null)
      {
        this.addItemToInventory(enemy.getItem());
      }
    }
    
  }

  private boolean needsPotion()
  {
    if(
      this.getCurrentHP() < this.getMaxHP() - 10)
    {
      return true;
    }
    else
    {
      return false;
    }
  }

  private boolean hasPotion()
  {
    if(this.inventory.size() > 0)
    {
      for( int i = 0; i < this.inventory.size()-1 ; i++)
      {
        if(this.inventory.get(i).getItemType() == Item.ItemType.POTION)
        {
          return true;
        }
      }
      return false;
    } 
    else 
    {
      return false;
    }
  }

  /*  increment Level 12*level+12
      LevelUp() uses the increment level formula described above.
      when the level is incremented, the player is restored to max health.
      then the accumulated XP is reduced to the remainder from the increment level formula.
  */
  private void levelUp(){
    int currentLevel = this.getLevel();
    if(this.getAccumulatedXP() / ((12*currentLevel)+12) >= 1)
    {
      this.setAccumulatedXP(this.getAccumulatedXP() % ((12*currentLevel)+12));
      this.setLevel( this.getLevel()+1 );
      System.out.println("Level up to " + this.getLevel());
      this.maxHeal();
    }
  }
  
  public void maxHeal()
  {
    this.setCurrentHP(this.maxHP);
  }

  
  
}

class Enemy extends Entity
{

  enum EnemyType{
    IMP
  }

  int XP;
  EnemyType enemyType;
  ItemSpawner itemSpawner = new ItemSpawner();


  //Constructors
  Enemy()
  {
    super(5,1);
    this.setXP(1);
  }

  Enemy(int maxHP, int attackRating)
  {
    super(maxHP,attackRating);
    this.setXP(1);
    this.setEnemyType(EnemyType.IMP);
  }

  //Getters and Setters
  public Item getItem()
  {
    return this.itemSpawner.getItem();
  }

  public int getXP()
  {
    return this.XP;
  }

  public void setXP(int XP)
  {
    this.XP = XP;
  }

  public EnemyType getEnemyType()
  {
    return this.enemyType;
  }

  public void setEnemyType(EnemyType enemyType)
  {
    this.enemyType = enemyType;
  }

  //Functional methods
  // This enemy fights a player by incrementing down the player's health. 
  void fights(Player player)
  {
    int newHP = player.getCurrentHP() - this.getAttackRating();
    player.setCurrentHP( newHP );
  }

}