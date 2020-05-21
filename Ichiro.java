public class Ichiro extends Family {
  int[] ichiroData = { 0, 0};

  // 一郎が空腹かどうかを返す
  public boolean isHungry(int[] data) {
    // 一郎のデータは配列になってて、１つ目が満腹度。満腹度１００％にならないと空腹感はなくならない子。
    return data[0] < (2000*1.0);
  }

  // 一郎の幸福度を返す
  public int isHappyPercent(int[] data) {
    // 一郎のデータは配列になってて、２つめが幸福度。
    return data[1];
  }

  // 一郎が食べる処理
  public void eat(int[] personData, String fruit, String[] fruitData) {
    // 一郎はりんごを食べない
    if (fruit.equals("apple")) {
      return;
    }
    String color = Fruits.getBananaColor(fruitData);
    int amount = Fruits.getBananaAmount(fruitData);
    int taste = Fruits.getBananaTaste(fruitData);
    int manpuku = personData[0];

    // 白色のバナナは２倍の効果
    int kouka = 1;
    if (color.equals("white")) {
      kouka = 2;
    }

    // 量 * 味　を満腹度に加算する
    manpuku += amount * taste * kouka;

    // 満腹度データを更新
    personData[0] = manpuku;

    // 幸福度データを更新する。一郎は量によって幸福度が上がる
    personData[1] = personData[1] + amount;

  }

}