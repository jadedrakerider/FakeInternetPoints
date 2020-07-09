import java.util.Random;

public class ItemSpawner 
{
  Random r = new Random();
  Item item;

  // Constructors
  public ItemSpawner()
  {
    int result = r.nextInt(4);
    if(result == 0)
    {
      this.setItem(new Potion());
      System.out.println("New Potion Spawned");
    }

  }

  // Getters or Setters
  public Item getItem()
  {
    return this.item;
  }

  public void setItem(Item item)
  {
    this.item = item;
  }

  // Functional Methods

}