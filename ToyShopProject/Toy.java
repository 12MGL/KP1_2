package ToyShopProject;

import java.util.PriorityQueue;


//здесь будем описывать игрушки
public class Toy implements Comparable<Toy> { // основные параметры игрушки
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

//сеты по всем, кроме id. его мы не задаём. 
//добавлю. имя тоже не нужно будет менять.

  public void setCount(int count) {
    this.count = count;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }

  //из PriorityQueue будем использовать сортировку и сравнение для розыгрыша
@Override
    public int compareTo(Toy other) {
        if (other == null) {
            return -1; // this < other
        }
}