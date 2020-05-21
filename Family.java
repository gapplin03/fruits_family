abstract class Family {
  //空腹かどうかを返す
  abstract boolean isHungry();

  //幸福度を返す
  abstract int isHappyPercent();

  //食べる処理
  abstract void eat(String fruit, String[] fruitData);

}