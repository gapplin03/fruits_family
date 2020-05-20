public class Saburo {
  int[] saburoData = { 0, 0, 0, 0};

  // 三郎が空腹かどうかを返す
  public boolean isHungry(int[] data) {
    // 三郎のデータは配列になってて、１つ目がりんごの量、２つ目がりんごの味、３つ目がバナナの量、４つ目がバナナの味
    return (data[0]*data[1]+data[2]*data[3]) < (2000*0.95);
  }

  // 三郎の幸福度を返す
  public int isHappyPercent(int[] data) {
    // 三郎のデータは配列になってて、１つ目がりんごの量、２つ目がりんごの味、３つ目がバナナの量、４つ目がバナナの味
    // 三郎の幸福度は味重視
    return (data[1] * 2 + data[3] * 3);
  }

  // 三郎が食べる処理
  public void eat(int[] personData, String fruit, String[] fruitData) {
    // りんご
    if (fruit.equals("apple")) {
      personData[0] += getAppleAmount(fruitData); // 量
      personData[1] += getAppleTaste(fruitData);  // 味

      // バナナ
    } else {
      personData[2] += getBananaAmount(fruitData);  // 量
      personData[3] += getBananaTaste(fruitData);   // 味
    }

  }

    // バナナの色を返す関数
    // private String getBananaColor(String[] data) {
    //   return data[0];
    // }

    // バナナの量を返す関数
    private int getBananaAmount(String[] data) {
      return Integer.parseInt(data[1]) * Integer.parseInt(data[3]);
    }

    // バナナのうまみ具合を返す関数
    private int getBananaTaste(String[] data) {
      return Integer.parseInt(data[2]);
    }

    // りんごの色を返す関数
    // private String getAppleColor(String[] data) {
    //   return data[0];
    // }

    // りんごの量を返す関数
    private int getAppleAmount(String[] data) {
      return Integer.parseInt(data[1]);
    }

    // りんごのうまみ具合を返す関数
    private int getAppleTaste(String[] data) {
      return Integer.parseInt(data[2]);
    }

    // りんごのブランドを返す関数
    // private String getAppleBland(String[] data) {
    //   return data[3];
    // }

}