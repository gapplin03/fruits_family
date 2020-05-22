public class Jiro extends Family {
  // int[] jiroData = { 0, 0};
  private String name = "Jiro";
  private int hungry;
  private int happy;

  Jiro(int hungry, int happy){
    this.hungry = hungry;
    this.happy = happy;
  }

  public String getName(){
    return this.name;
  }

  // 次郎が空腹かどうかを返す
  public boolean isHungry() {
    // 次郎のデータは配列になってて、１つ目が満腹度。満腹度８０％を超えると空腹感はなくなる子。
    return this.hungry < (2000*0.8);
  }

  // 次郎の幸福度を返す
  public int isHappyPercent() {
    // 次郎のデータは配列になってて、２つめが幸福度。
    return this.happy;
  }


  // 次郎が食べる処理
  public void eat(String fruit, String[] fruitData) {
    // りんご
    if (fruit.equals("apple")) {
      String color = Fruits.getAppleColor(fruitData);
      int amount = Fruits.getAppleAmount(fruitData);
      int taste = Fruits.getAppleTaste(fruitData);
      String bland = Fruits.getAppleBland(fruitData);

      // 効果
      int kouka = 1;
      if (color.equals("red")) {
        kouka = 2;
      }
      if (bland.equals("ourin")) {
        kouka *= 2;
      }

      // 量 * 味 を満腹度に加算する
      this.hungry += amount * taste;

      // 幸福度データを更新する。次郎は味・色・ブランドによって幸福度が上がる
      this.happy += taste * kouka;

    // バナナ
    } else {
      String color = Fruits.getBananaColor(fruitData);
      int amount = Fruits.getBananaAmount(fruitData);
      int taste = Fruits.getBananaTaste(fruitData);

      // 白色のバナナは２倍の効果
      int kouka = 1;
      if (color.equals("white")) {
        kouka = 2;
      }

      // 量 * 味 を満腹度に加算する
      this.hungry += amount * taste * kouka;

      // 幸福度データを更新する。次郎はバナナの時は量によって幸福度が上がる
      this.happy += amount;
    }

  }

}