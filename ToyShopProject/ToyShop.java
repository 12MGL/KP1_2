package ToyShopProject;

import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.List;

  //здесь будем описывать все манипуляции с игрушками - методы добавления 
  //новых игрушек, розыгрыш, запись результатов
public class ToyShop {
    //private List<Toy> toyarray = new ArrayList<Toy>(); //список игрушек
    private PriorityQueue<Toy> toyQueue = new PriorityQueue<>(); //список игрушек сформируем через очередь
    public void addToy(Toy newToy) {
      //toyarray.add(toy);      //добавляем игрушки в список
      Scanner input = new Scanner(System.in);
      System.out.println("Какое количество видов игрушек находятся в магазине?   ");
      int countToys = input.nextInt();
      for (int i = 1; i <= countToys; i++) {   //для каждой игрушки конструктором добавляем данные в список
        System.out.println("введите название игрушки:  ");
        String name = input.next();
        System.out.println("введите количество игрушек " + name + ":  ");
        int count = input.nextInt();
        System.out.println("введите вероятность выигрыша игрушки " + name + ":  ");
        int weight = input.nextInt();
        //Toy toy = new Toy(i, name, count, weight);    //в данном случае счётчик от 1 до общего количества для нас станет id игрушки, логично
        //ToyShop.addToy(toy);  //по введённым параметрам добавляем игрушку в список, переходим на следующую итерацию
        newToy = new Toy(i, name, count, weight);
        toyQueue.add(newToy); //список игрушек формируем в очередь
      }
    }
}