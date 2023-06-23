package ToyShopProject;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Random;


//здесь будем описывать игрушки
public class Toy implements Comparable<Toy>{ // основные параметры игрушки, включаем Comparable для метода comparableTo
  private int id;
  public String name;
  public int count;
  public int weight;


  public Toy(int id, String name, int count, int weight) { //конструктор класса
    this.id = id;
    this.name = name;
    this.count = count;
    this.weight = weight;
  }

  // геты по всем параметрам

  public int getId() {
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

  // public Toy getToy(){    //розыгрыш
  //   int index = new Random().nextInt(ToyShop.weights.size());
    
    
  //     Toy toy = toyQueue.poll();  //берём первую игрушку из списка с весами
  //     int toyIndex = weight.indexOf(toy.getId());
  //     weight.remove(toyIndex);  //убираем игрушку из списка 
  //     int ost = Collections.frequency(weight, toy.getId())
      


}