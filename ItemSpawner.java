public class ItemSpawner 
{
  
  Item item;

  public ItemSpawner()
  {
    this.setItem(new Potion());
  }

  public Item getItem()
  {
    return this.item;
  }

  public void setItem(Item item)
  {
    this.item = item;
  }

}