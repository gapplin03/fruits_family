public class Saburo extends Family {
  // int[] saburoData = { 0, 0, 0, 0};
  private String name = "Saburos";
  private int appleAmount;
  private int appleTaste;
  private int bananaAmount;
  private int bananaTaste;

  Saburo(int appleAmount, int appleTaste, int bananaAmount, int bananaTaste){
    this.appleAmount = appleAmount;
    this.appleTaste = appleTaste;
    this.bananaAmount = bananaAmount;
    this.bananaTaste = bananaTaste;
  }

  public String getName(){
    return this.name;
  }

  // 三郎が空腹かどうかを返す
  public boolean isHungry() {
    // 三郎のデータは配列になってて、１つ目がりんごの量、２つ目がりんごの味、３つ目がバナナの量、４つ目がバナナの味
    return (this.appleAmount * this.appleTaste + this.bananaAmount * this.bananaTaste) < (2000*0.95);
  }

  // 三郎の幸福度を返す
  public int isHappyPercent() {
    // 三郎のデータは配列になってて、１つ目がりんごの量、２つ目がりんごの味、３つ目がバナナの量、４つ目がバナナの味
    // 三郎の幸福度は味重視
    return (this.appleTaste * 2 + this.bananaTaste * 3);
  }

  // 三郎が食べる処理
  public void eat(String fruit, String[] fruitData) {
    // りんご
    if (fruit.equals("apple")) {
      this.appleAmount += Fruits.getAppleAmount(fruitData); // 量
      this.appleTaste += Fruits.getAppleTaste(fruitData);  // 味

      // バナナ
    } else {
      this.bananaAmount += Fruits.getBananaAmount(fruitData);  // 量
      this.bananaTaste += Fruits.getBananaTaste(fruitData);   // 味
    }

  }
}