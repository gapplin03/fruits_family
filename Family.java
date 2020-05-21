abstract class Family {
  //空腹かどうかを返す
  abstract boolean isHungry(int[] data);

  //幸福度を返す
  abstract int isHappyPercent(int[] data);

  //食べる処理
  abstract void eat(int[] personData, String fruit, String[] fruitData);

}