public class Ichiro extends Family {
  // int[] ichiroData = { 0, 0};
  private int hungry = 0;
  private int happy = 0;

  // 一郎が空腹かどうかを返す
  public boolean isHungry() {
    // 一郎のデータは配列になってて、１つ目が満腹度。満腹度１００％にならないと空腹感はなくならない子。
    return this.hungry < (2000*1.0);
  }

  // 一郎の幸福度を返す
  public int isHappyPercent() {
    // 一郎のデータは配列になってて、２つめが幸福度。
    return this.happy;
  }

  // 一郎が食べる処理
  public void eat(String fruit, String[] fruitData) {
    // 一郎はりんごを食べない
    if (fruit.equals("apple")) {
      return;
    }
    String color = Fruits.getBananaColor(fruitData);
    int amount = Fruits.getBananaAmount(fruitData);
    int taste = Fruits.getBananaTaste(fruitData);
    int manpuku = this.hungry;

    // 白色のバナナは２倍の効果
    int kouka = 1;
    if (color.equals("white")) {
      kouka = 2;
    }

    // 量 * 味　を満腹度に加算する
    manpuku += amount * taste * kouka;

    // 満腹度データを更新
    this.hungry = manpuku;

    // 幸福度データを更新する。一郎は量によって幸福度が上がる
    this.happy = this.happy + amount;

  }

}