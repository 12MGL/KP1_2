package ToyShopProject;
//здесь будем описывать игрушки
public class Toy implements Comparable<Toy>{ // основные параметры игрушки, включаем Comparable для метода comparableTo
  private static int id;
  public String name;
  public int count;
  public int weight;


  public Toy(String name, int count, int weight) { //конструктор класса
    this.name = name;
    this.count = count;
    this.weight = weight;
    id++;
  }

  // геты по всем параметрам

  public static int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public int getCount() {
    return count;
  }

  public int getWeight(){
    return weight;
  }

//сеты по всем, кроме id. его мы не задаём
//имя тоже менять незачем. количество понадобится  менять для розыгрышей. вероятность - по условию.

  public void setCount(int count) {
    this.count = count;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }

  @Override
  public int compareTo(Toy other) {
  return Integer.compare(this.weight, other.weight); 
  //метод должен вернуть результат сравнения вероятностей
  //выигрыша двух игрушек
  }
}