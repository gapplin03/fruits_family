public abstract class Family {

  public abstract String getName();

  //空腹かどうかを返す
  public abstract boolean isHungry();

  //幸福度を返す
  public abstract int isHappyPercent();

  //食べる処理
  public abstract void eat(String fruit, String[] fruitData);

}