public class Jiro {
  int[] jiroData = { 0, 0};

  // 次郎が空腹かどうかを返す
  public boolean isHungry(int[] data) {
    // 次郎のデータは配列になってて、１つ目が満腹度。満腹度８０％を超えると空腹感はなくなる子。
    return data[0] < (2000*0.8);
  }

  // 次郎の幸福度を返す
  public int isHappyPercent(int[] data) {
    // 次郎のデータは配列になってて、２つめが幸福度。
    return data[1];
  }


  // 次郎が食べる処理
  public void eat(int[] personData, String fruit, String[] fruitData) {
    // りんご
    if (fruit.equals("apple")) {
      String color = getAppleColor(fruitData);
      int amount = getAppleAmount(fruitData);
      int taste = getAppleTaste(fruitData);
      String bland = getAppleBland(fruitData);

      // 効果
      int kouka = 1;
      if (color.equals("red")) {
        kouka = 2;
      }
      if (bland.equals("ourin")) {
        kouka *= 2;
      }

      // 量 * 味 を満腹度に加算する
      personData[0] += amount * taste;

      // 幸福度データを更新する。次郎は味・色・ブランドによって幸福度が上がる
      personData[1] += taste * kouka;

    // バナナ
    } else {
      String color = getBananaColor(fruitData);
      int amount = getBananaAmount(fruitData);
      int taste = getBananaTaste(fruitData);

      // 白色のバナナは２倍の効果
      int kouka = 1;
      if (color.equals("white")) {
        kouka = 2;
      }

      // 量 * 味 を満腹度に加算する
      personData[0] += amount * taste * kouka;

      // 幸福度データを更新する。次郎はバナナの時は量によって幸福度が上がる
      personData[1] += amount;
    }

  }

    // バナナの色を返す関数
    private String getBananaColor(String[] data) {
      return data[0];
    }

    // バナナの量を返す関数
    private int getBananaAmount(String[] data) {
      return Integer.parseInt(data[1]) * Integer.parseInt(data[3]);
    }

    // バナナのうまみ具合を返す関数
    private int getBananaTaste(String[] data) {
      return Integer.parseInt(data[2]);
    }

    // りんごの色を返す関数
    private String getAppleColor(String[] data) {
      return data[0];
    }

    // りんごの量を返す関数
    private int getAppleAmount(String[] data) {
      return Integer.parseInt(data[1]);
    }

    // りんごのうまみ具合を返す関数
    private int getAppleTaste(String[] data) {
      return Integer.parseInt(data[2]);
    }

    // りんごのブランドを返す関数
    private String getAppleBland(String[] data) {
      return data[3];
    }

}