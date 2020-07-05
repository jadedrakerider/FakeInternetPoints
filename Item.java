public class Item
{
  enum ItemType
  {
    POTION
  }

  ItemType type;

  public ItemType getItemType()
  {
    return this.type;
  }

  public void setItemType(ItemType type)
  {
    this.type = type;
  }

}

class Potion extends Item
{
  int HPRecovery;
  
  public Potion()
  {
    this(10);
  }

  public Potion(int HPRecovery)
  {
    this.HPRecovery = HPRecovery;
    this.type = ItemType.POTION;
  }

  public int getHPRecovery(){
    return this.HPRecovery;
  }

  public void setHPRecovery(int HPRecovery)
  {
    this.HPRecovery = HPRecovery;
  }

}