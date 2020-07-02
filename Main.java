class Main {
  public static void main(String[] args) {
    Enemy enemy = new Enemy();
    Player player = new Player();


    System.out.println("Current Player HP = " + player.getCurrentHP);
    enemy.fights(player);
    System.out.println("Current Player HP = " + player.getCurrentHP);
  }
}