public class RandomNumber {
  private int number;

  public void createRandom() {
    this.number = (int)(Math.random()* 9 + 1);
  }

  public int getRandom() {
    this.createRandom();
    return this.number;
  }
}
