import java.util.*;

class Main {

  // 一郎が空腹かどうかを返す
  private static boolean isIchiroHungry(String[] data) {
    // 一郎のデータは配列になってて、１つ目が満腹度。満腹度１００％にならないと空腹感はなくならない子。
    return Integer.parseInt(data[0]) < (2000*1.0);
  }

  // 次郎が空腹かどうかを返す
  private static boolean isJiroHungry(int[] data) {
    // 次郎のデータは配列になってて、１つ目が満腹度。満腹度８０％を超えると空腹感はなくなる子。
    return data[0] < (2000*0.8);
  }

  // 三郎が空腹かどうかを返す
  private static boolean isSaburoHungry(int[] data) {
    // 三郎のデータは配列になってて、１つ目がりんごの量、２つ目がりんごの味、３つ目がバナナの量、４つ目がバナナの味
    return (data[0]*data[1]+data[2]*data[3]) < (2000*0.95);
  }

  // 一郎の幸福度を返す
  private static String isIchiroHappyPercent(String[] data) {
    // 一郎のデータは配列になってて、２つめが幸福度。
    return data[1];
  }

  // 次郎の幸福度を返す
  private static int isJiroHappyPercent(int[] data) {
    // 次郎のデータは配列になってて、２つめが幸福度。
    return data[1];
  }

  // 三郎の幸福度を返す
  private static int isSaburoHappyPercent(int[] data) {
    // 三郎のデータは配列になってて、１つ目がりんごの量、２つ目がりんごの味、３つ目がバナナの量、４つ目がバナナの味
    // 三郎の幸福度は味重視
    return (data[1] * 2 + data[3] * 3);
  }

  // 一郎が食べる処理
  private static void eatIchiro(String[] personData, String fruit, String[] fruitData) {
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

  // 次郎が食べる処理
  private static void eatJiro(int[] personData, String fruit, String[] fruitData) {
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


  // 三郎が食べる処理
  private static void eatSaburo(int[] personData, String fruit, String[] fruitData) {
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
  private static String getBananaColor(String[] data) {
    return data[0];
  }

  // バナナの量を返す関数
  private static int getBananaAmount(String[] data) {
    return Integer.parseInt(data[1]) * Integer.parseInt(data[3]);
  }

  // バナナのうまみ具合を返す関数
  private static int getBananaTaste(String[] data) {
    return Integer.parseInt(data[2]);
  }

  // りんごの色を返す関数
  private static String getAppleColor(String[] data) {
    return data[0];
  }

  // りんごの量を返す関数
  private static int getAppleAmount(String[] data) {
    return Integer.parseInt(data[1]);
  }

  // りんごのうまみ具合を返す関数
  private static int getAppleTaste(String[] data) {
    return Integer.parseInt(data[2]);
  }

  // りんごのブランドを返す関数
  private static String getAppleBland(String[] data) {
    return data[3];
  }


  public static void main(String[] args) {

    String[][] apples = {
      {"red", "100", "5", "fuji"},
      {"magenda", "150", "2", "tsugaru"},
      {"magenda", "80", "8", "ourin"},
      {"magenda", "100", "9", "tsugaru"},
      {"red", "200", "4", "fuji"},
    };
    int appleCount = apples.length;

    String[][] bananas = {
      {"yellow", "50", "5", "3"},
      {"green", "30", "2", "4"},
      {"green", "40", "8", "4"},
      {"white", "100", "9", "2"},
      {"yellow", "45", "4", "4"},
      {"yellow", "60", "8", "2" },
    };
    int bananaCount = bananas.length;

    String[] family = {"ichirou", "jirou", "saburou"};
    String[] ichiroData = { "0", "0"};
    int[] jiroData = { 0, 0};
    int[] saburoData = { 0, 0, 0, 0};

    Scanner sc = new Scanner(System.in);

    int gameCount = 0;

    while (appleCount > 0 || bananaCount > 0) {

      // ゲームは５回まで
      gameCount++;
      if (gameCount > 5) {
        break;
      }

      System.out.print("Do you want apple or yellow>");
      String fruit = sc.next();
      String[] data;
      if (fruit.equals("apple")) {
        if (appleCount <= 0) {
          System.out.println("");
          System.out.println("Sorry! apple is sold out.");
          System.out.println("");
          continue;
        }
        data = apples[appleCount - 1];
        appleCount--;

      } else if (fruit.equals("banana")) {
        if (bananaCount <= 0) {
          System.out.println("");
          System.out.println("Sorry! banana is sold out.");
          System.out.println("");
          continue;
        }
        data = bananas[bananaCount - 1];
        bananaCount--;

      } else {
        System.out.println("");
        System.out.println("Sorry! write banana or apple.");
        System.out.println("");
        continue;
      }


      int manpukuCount = 0;
      for (int i = 0; i < family.length; i++) {
        switch (family[i]) {
          case "ichirou":
            if (isIchiroHungry(ichiroData)) {
              eatIchiro(ichiroData, fruit, data);
              if (!isIchiroHungry(ichiroData)) {
                manpukuCount++;
              }
            } else {
              manpukuCount++;
            }
            break;
          case "jirou":
            if (isJiroHungry(jiroData)) {
              eatJiro(jiroData, fruit, data);
              if (!isJiroHungry(jiroData)) {
                manpukuCount++;
              }
            } else {
              manpukuCount++;
            }
            break;
          case "saburou":
            if (isSaburoHungry(saburoData)) {
              eatSaburo(saburoData, fruit, data);
              if (!isSaburoHungry(saburoData)) {
                manpukuCount++;
              }
            } else {
              manpukuCount++;
            }
            break;

        }
      }

      if (manpukuCount == family.length) {
        System.out.println("");
        System.out.println(" Game Clear !!!! game count is " + gameCount);
        System.out.println("");
        for (int i = 0; i < family.length; i++) {
          System.out.print(family[i] + " : ");
          switch (family[i]) {
            case "ichirou":
              System.out.print(isIchiroHappyPercent(ichiroData) + "%\n");
              break;
            case "jirou":
              System.out.print(isJiroHappyPercent(jiroData) + "%\n");
              break;
            case "saburou":
              System.out.print(isSaburoHappyPercent(saburoData) + "%\n");
              break;
          }
        }
        System.out.println("");
        sc.close();
        return;
      } else {
        for (int i = 0; i < family.length; i++) {
          System.out.print(family[i] + " : ");
          switch (family[i]) {
            case "ichirou":
              System.out.println(isIchiroHungry(ichiroData) ? "hungry." : "not hungry");
              break;
            case "jirou":
              System.out.println(isJiroHungry(jiroData) ? "hungry." : "not hungry");
              break;
            case "saburou":
              System.out.println(isSaburoHungry(saburoData) ? "hungry." : "not hungry");
              break;
          }
        }
        System.out.println("");
      }

    }
    System.out.println("");
    System.out.println("GAME OVER!");
    System.out.println("");
    for (int i = 0; i < family.length; i++) {
      System.out.print(family[i] + " : ");
      switch (family[i]) {
        case "ichirou":
          System.out.println(isIchiroHungry(ichiroData) ? "hungry." : "not hungry");
          break;
        case "jirou":
          System.out.println(isJiroHungry(jiroData) ? "hungry." : "not hungry");
          break;
        case "saburou":
          System.out.println(isSaburoHungry(saburoData) ? "hungry." : "not hungry");
          break;
      }
    }
    System.out.println("");
    System.out.println("がっちゃん");

    sc.close();

  }
}