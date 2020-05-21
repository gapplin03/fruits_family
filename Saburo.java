public class Saburo extends Family {
  // int[] saburoData = { 0, 0, 0, 0};
  private int appleAmount = 0;
  private int appleTaste = 0;
  private int bananaAmount = 0;
  private int bananaTaste = 0;


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