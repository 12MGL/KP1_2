package ToyShopProject;

import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.List;

  //здесь будем описывать все манипуляции с игрушками - методы добавления 
  //новых игрушек, розыгрыш, запись результатов
public class ToyShop {
    private List<Toy> toyarray = new ArrayList<Toy>(); //определяем список игрушек

    public void addToy(Toy toy) {
        toyarray.add(toy);      //добавляем игрушки в список
    }



}
