import java.util.*;

class Main {

  //ブランドはゲーム上で見えるわけではないからカプセル化する？

  public static void main(String[] args) {
    Ichiro ichiro = new Ichiro();
    Jiro jiro = new Jiro();
    Saburo saburo = new Saburo();


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
            if (ichiro.isHungry(ichiro.ichiroData)) {
              ichiro.eat(ichiro.ichiroData, fruit, data);
              if (!ichiro.isHungry(ichiro.ichiroData)) {
                manpukuCount++;
              }
            } else {
              manpukuCount++;
            }
            break;
          case "jirou":
            if (jiro.isHungry(jiro.jiroData)) {
              jiro.eat(jiro.jiroData, fruit, data);
              if (!jiro.isHungry(jiro.jiroData)) {
                manpukuCount++;
              }
            } else {
              manpukuCount++;
            }
            break;
          case "saburou":
            if (saburo.isHungry(saburo.saburoData)) {
              saburo.eat(saburo.saburoData, fruit, data);
              if (!saburo.isHungry(saburo.saburoData)) {
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
              System.out.print(ichiro.isHappyPercent(ichiro.ichiroData) + "%\n");
              break;
            case "jirou":
              System.out.print(jiro.isHappyPercent(jiro.jiroData) + "%\n");
              break;
            case "saburou":
              System.out.print(saburo.isHappyPercent(saburo.saburoData) + "%\n");
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
              System.out.println(ichiro.isHungry(ichiro.ichiroData) ? "hungry." : "not hungry");
              break;
            case "jirou":
              System.out.println(jiro.isHungry(jiro.jiroData) ? "hungry." : "not hungry");
              break;
            case "saburou":
              System.out.println(saburo.isHungry(saburo.saburoData) ? "hungry." : "not hungry");
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
          System.out.println(ichiro.isHungry(ichiro.ichiroData) ? "hungry." : "not hungry");
          break;
        case "jirou":
          System.out.println(jiro.isHungry(jiro.jiroData) ? "hungry." : "not hungry");
          break;
        case "saburou":
          System.out.println(saburo.isHungry(saburo.saburoData) ? "hungry." : "not hungry");
          break;
      }
    }
    System.out.println("");

    sc.close();

  }
}