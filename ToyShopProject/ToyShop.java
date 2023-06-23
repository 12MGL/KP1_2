package ToyShopProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
// import java.util.Scanner;
// import java.util.PriorityQueue;
// import java.util.ArrayList;
// import java.util.List;
import java.util.*;

  //здесь будем описывать все манипуляции с игрушками - методы добавления 
  //новых игрушек, розыгрыш, запись результатов
public class ToyShop {
    private List<Toy> toyArray = new ArrayList<Toy>(); //список игрушек
    public PriorityQueue<Toy> toyQueue = new PriorityQueue<>(); //список игрушек сформируем через очередь
    private Map <Integer, String> idAndNames; //создаём связанный массив id и названий игрушек
    public List<Integer> weights = new ArrayList<>(); //список вероятностей
    public List<Integer> counts = new ArrayList<>(); //список всех игрушек по количеству игрушек
    
    public ToyShop(){
      idAndNames = new HashMap<>(); //массив id - название
    
    }

    public void addToy(Toy newToy) {
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
        toyQueue.add(newToy);
        toyQueue.add(newToy); //список игрушек формируем в очередь, которая в методе Toy настроена на сравнение весов (вероятностей)
        for (int j = 0; j < weight; j++) {
            weights.add(newToy.getId()); //добавляем игрушку в список вероятностей
        }
        for (int j = 0; j < count; j++) {
            counts.add(newToy.getId());   //добавляем игрушку в список с количествами всех игрушек
        }
        idAndNames.put(newToy.getId(), newToy.getName()); //добавляем игрушку в массив связок
        System.out.println("Новая игрушка добавлена!");
      }
    }
  

    public Toy getToy(){    //розыгрыш
      int index = new Random().nextInt(weights.size());
      int toyId = weights.get(index); //среди списка вероятностей мы случайно выбираем 1 игрушку
      counts.remove(toyId); //из списка с количеством убираем эту игрушку
      //Toy toy = toyQueue.poll();  //берём первую игрушку из списка с количествами
      weights.remove(toyId);  //убираем игрушку из списка весов
      int ost = Collections.frequency(counts, toyId); //проверяем, не закончились ли игрушки в списке количеств
       if (ost == 0){ //и если закончились
        for (int i = weights.size() - 1; i >= 0; i--) {
            if (weights.get(i) == toyId) { 
                weights.remove(i);  //то убираем все вхождения этой игрушки в список весов 
            }
          }
        }
        String name = idAndNames.get(toyId);  //по toyId находим в словаре имён нашу игрущку
        for (Toy toy : toyArray) {
        if (toy.getName().equals(name)) {
            return toy;         //и возвращаем в метод getToy
        }
    }
    return null;
    }
    public void writeWins() {    //запись в файл результатов розыгрыша
      try (PrintWriter writer = new PrintWriter(new File("Wins.txt"))) {
          for (int i = 1; i <= 10; i++) {               //делаем 10 гетов - 10 розыгрышей
              Toy toy = getToy(); 
              String winner = String.format("%d. %s\n", i, toy.getName());    //каждый пишем в файл в формате 1.Кукла 2.Машинка
              writer.write(winner);
          }
          } 
      catch (FileNotFoundException e) {
        System.out.println("Ошибка записи в файл");
      }
        System.out.println("Розыгрыш окончен!");
    } 
}
