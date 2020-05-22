import java.util.*;

class Main {

  //ブランドはゲーム上で見えるわけではないからカプセル化する？

  public static void main(String[] args) {
    // Ichiro ichiro = new Ichiro();
    // Jiro jiro = new Jiro();
    // Saburo saburo = new Saburo();

    // String[] family = {"ichirou", "jirou", "saburou"};
    Family[] family = {new Ichiro(0,0), new Jiro(0,0),new Saburo(0,0,0,0)};

    Scanner sc = new Scanner(System.in);

    int gameCount = 0;

    String[][] apples = {
      {"red", "100", "5", "fuji"},
      {"magenda", "150", "2", "tsugaru"},
      {"magenda", "80", "8", "ourin"},
      {"magenda", "100", "9", "tsugaru"},
      {"red", "200", "4", "fuji"},
    };

    String[][] bananas = {
      {"yellow", "50", "5", "3"},
      {"green", "30", "2", "4"},
      {"green", "40", "8", "4"},
      {"white", "100", "9", "2"},
      {"yellow", "45", "4", "4"},
      {"yellow", "60", "8", "2" },
    };

    int appleCount = apples.length;
    int bananaCount = bananas.length;

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
        System.out.println(data);
        appleCount--;

      } else if (fruit.equals("banana")) {
        if (bananaCount <= 0) {
          System.out.println("");
          System.out.println("Sorry! banana is sold out.");
          System.out.println("");
          continue;
        }
        data = bananas[bananaCount - 1];
        // System.out.println(data[0]);
        // System.out.println(data[1]);
        // System.out.println(data[2]);
        // System.out.println(data[3]);
        bananaCount--;

      } else {
        System.out.println("");
        System.out.println("Sorry! write banana or apple.");
        System.out.println("");
        continue;
      }


      for(int i = 0; i < family.length; i++){
        System.out.println("お名前" + family[i]);
        System.out.println(family[i].isHungry());
      }

      int manpukuCount = 0;
      for(int i = 0; i < family.length; i++){
        if(family[i].isHungry()){
          family[i].eat(fruit, data);
          if(!family[i].isHungry()){
            manpukuCount++;
          }
        }else{
          manpukuCount++;
        }
      }

      // 旧
      // for (int i = 0; i < family.length; i++) {
      //   switch (family[i]) {
      //     case "ichirou":
      //       if (ichiro.isHungry()) {
      //         ichiro.eat(fruit, data);
      //         if (!ichiro.isHungry()) {
      //           manpukuCount++;
      //         }
      //       } else {
      //         manpukuCount++;
      //       }
      //       break;
      //     case "jirou":
      //       if (jiro.isHungry()) {
      //         jiro.eat(fruit, data);
      //         if (!jiro.isHungry()) {
      //           manpukuCount++;
      //         }
      //       } else {
      //         manpukuCount++;
      //       }
      //       break;
      //     case "saburou":
      //       if (saburo.isHungry()) {
      //         saburo.eat(fruit, data);
      //         if (!saburo.isHungry()) {
      //           manpukuCount++;
      //         }
      //       } else {
      //         manpukuCount++;
      //       }
      //       break;

      //   }
      // }

      if(manpukuCount == family.length){
        System.out.println("");
        System.out.println(" Game Clear !!!! game count is " + gameCount);
        System.out.println("");
        for(int i = 0; i < family.length; i++){
          System.out.print(family[i].getName() + " : ");
          System.out.print(family[i].isHappyPercent() + "%\n");
        }
        System.out.println("");
        sc.close();
        return;
      }else{
        for(int i = 0; i < family.length; i++){
          System.out.print(family[i].getName() + " : ");
          System.out.println(family[i].isHungry() ? "hungry." : "not hungry");
        }
        System.out.println("");
      }

      // 旧
      // if (manpukuCount == family.length) {
      //   System.out.println("");
      //   System.out.println(" Game Clear !!!! game count is " + gameCount);
      //   System.out.println("");
      //   for (int i = 0; i < family.length; i++) {
      //     System.out.print(family[i] + " : ");
      //     switch (family[i]) {
      //       case "ichirou":
      //         System.out.print(ichiro.isHappyPercent() + "%\n");
      //         break;
      //       case "jirou":
      //         System.out.print(jiro.isHappyPercent() + "%\n");
      //         break;
      //       case "saburou":
      //         System.out.print(saburo.isHappyPercent() + "%\n");
      //         break;
      //     }
      //   }
      //   System.out.println("");
      //   sc.close();
      //   return;
      // } else {
      //   for (int i = 0; i < family.length; i++) {
      //     System.out.print(family[i] + " : ");
      //     switch (family[i]) {
      //       case "ichirou":
      //         System.out.println(ichiro.isHungry() ? "hungry." : "not hungry");
      //         break;
      //       case "jirou":
      //         System.out.println(jiro.isHungry() ? "hungry." : "not hungry");
      //         break;
      //       case "saburou":
      //         System.out.println(saburo.isHungry() ? "hungry." : "not hungry");
      //         break;
      //     }
      //   }
      //   System.out.println("");
      // }

    }
    System.out.println("");
    System.out.println("GAME OVER!");
    System.out.println("");

    for(int i = 0; i < family.length; i++){
      System.out.print(family[i].getName() + " : ");
      System.out.println(family[i].isHungry() ? "hungry." : "not hungry");
    }

    //旧
    // for (int i = 0; i < family.length; i++) {
    //   System.out.print(family[i] + " : ");
    //   switch (family[i]) {
    //     case "ichirou":
    //       System.out.println(ichiro.isHungry() ? "hungry." : "not hungry");
    //       break;
    //     case "jirou":
    //       System.out.println(jiro.isHungry() ? "hungry." : "not hungry");
    //       break;
    //     case "saburou":
    //       System.out.println(saburo.isHungry() ? "hungry." : "not hungry");
    //       break;
    //   }
    // }
    System.out.println("");

    sc.close();

  }
}