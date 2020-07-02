public class Entity
{

  int maxHP;
  int currentHP;
  int attackRating;

  Entity()
  {
    this.maxHP = 100;
    this.currentHP = this.maxHP;
    this.attackRating = 2;
  }

  Entity(int maxHP, int attackRating)
  {
    this.maxHP = maxHP;
    this.currentHP = this.maxHP;
    this.attackRating = attackRating;
  }

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
    if (currentHP > 0)
    {
      return true;
    }
    else
    {
      return false;
    }
  }
}