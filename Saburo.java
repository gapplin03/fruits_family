public class Saburo extends Family {
  int[] saburoData = { 0, 0, 0, 0};

  // 三郎が空腹かどうかを返す
  protected boolean isHungry(int[] data) {
    // 三郎のデータは配列になってて、１つ目がりんごの量、２つ目がりんごの味、３つ目がバナナの量、４つ目がバナナの味
    return (data[0]*data[1]+data[2]*data[3]) < (2000*0.95);
  }

  // 三郎の幸福度を返す
  protected int isHappyPercent(int[] data) {
    // 三郎のデータは配列になってて、１つ目がりんごの量、２つ目がりんごの味、３つ目がバナナの量、４つ目がバナナの味
    // 三郎の幸福度は味重視
    return (data[1] * 2 + data[3] * 3);
  }

  // 三郎が食べる処理
  protected void eat(int[] personData, String fruit, String[] fruitData) {
    // りんご
    if (fruit.equals("apple")) {
      personData[0] += Fruits.getAppleAmount(fruitData); // 量
      personData[1] += Fruits.getAppleTaste(fruitData);  // 味

      // バナナ
    } else {
      personData[2] += Fruits.getBananaAmount(fruitData);  // 量
      personData[3] += Fruits.getBananaTaste(fruitData);   // 味
    }

  }
}