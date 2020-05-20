public class Ichiro {
  String[] ichiroData = { "0", "0"};

  // 一郎が空腹かどうかを返す
  public boolean isHungry(String[] data) {
    // 一郎のデータは配列になってて、１つ目が満腹度。満腹度１００％にならないと空腹感はなくならない子。
    return Integer.parseInt(data[0]) < (2000*1.0);
  }

  // 一郎の幸福度を返す
  public String isHappyPercent(String[] data) {
    // 一郎のデータは配列になってて、２つめが幸福度。
    return data[1];
  }

  // 一郎が食べる処理
  public void eat(String[] personData, String fruit, String[] fruitData) {
    // 一郎はりんごを食べない
    if (fruit.equals("apple")) {
      return;
    }
    String color = getBananaColor(fruitData);
    int amount = getBananaAmount(fruitData);
    int taste = getBananaTaste(fruitData);
    int manpuku = Integer.parseInt(personData[0]);

    // 白色のバナナは２倍の効果
    int kouka = 1;
    if (color.equals("white")) {
      kouka = 2;
    }

    // 量 * 味　を満腹度に加算する
    manpuku += amount * taste * kouka;

    // 満腹度データを更新
    personData[0] = String.valueOf(manpuku);

    // 幸福度データを更新する。一郎は量によって幸福度が上がる
    personData[1] = String.valueOf(Integer.parseInt(personData[1]) + amount);

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
    // private static String getAppleColor(String[] data) {
    //   return data[0];
    // }

    // りんごの量を返す関数
    // private static int getAppleAmount(String[] data) {
    //   return Integer.parseInt(data[1]);
    // }

    // りんごのうまみ具合を返す関数
    // private static int getAppleTaste(String[] data) {
    //   return Integer.parseInt(data[2]);
    // }

    // りんごのブランドを返す関数
    // private static String getAppleBland(String[] data) {
    //   return data[3];
    // }

}