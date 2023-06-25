package ToyShopProject;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;


  //здесь будем описывать все манипуляции с игрушками - методы добавления 
  //новых игрушек, розыгрыш, запись результатов
public class ToyShop {
    private List<Toy> toyArray = new ArrayList<Toy>(); //список игрушек
    private Map <Integer, String> idAndNames; //создаём связанный массив id и названий игрушек
    public static List<Integer> weights = new ArrayList<>(); //список вероятностей
    public static List<Integer> counts = new ArrayList<>(); //список всех игрушек по количеству игрушек
    
    public ToyShop(){
      idAndNames = new HashMap<>(); //массив id - название
    }

    public void addToy() {
    Scanner input = new Scanner(System.in, "cp866");
    System.out.println("Какое количество видов игрушек находятся в магазине?   ");
    int countToys = input.nextInt();
    counts.add(0);
    for (int i = 1; i <= countToys; i++) {   //для каждой игрушки конструктором добавляем данные в список
      System.out.println("введите название игрушки:  ");
      String name = input.next();
      System.out.println("введите количество игрушек " + name + ":  ");
      int count = input.nextInt();
      System.out.println("введите вероятность выигрыша игрушки " + name + ":  ");
      int weight = input.nextInt();
      Toy newToy = new Toy(name, count, weight);    //в данном случае счётчик от 1 до общего количества для нас станет id игрушки, логично
      toyArray.add(newToy);
      for (int j = 0; j < weight; j++) {
        weights.add(newToy.getId());   //добавляем игрушку в список с количествами всех игрушек
      }
      for (int j = 0; j < count; j++) {
        counts.add(newToy.getId());   //добавляем игрушку в список с количествами всех игрушек
      }
      idAndNames.put(newToy.getId(), newToy.getName()); //добавляем игрушку в массив связок
      System.out.println("Новая игрушка добавлена!");
    }
    // System.out.println(idAndNames);
    // System.out.println(counts);
    // System.out.println(weights);
    input.close();
    }
  

    public Toy getToy(){    //розыгрыш
      int index = new Random().nextInt(weights.size());
      int toyId = weights.get(index); //среди списка вероятностей мы случайно выбираем 1 игрушку
      counts.remove(toyId); //из списка с количеством убираем эту игрушку
      int ost = Collections.frequency(counts, toyId); //проверяем, не закончились ли игрушки в списке количеств
      if (ost == 0){ //и если закончились
        Iterator itr = weights.iterator();  //проходимся итератором по весами и
        while (itr.hasNext()) {
          int x = (Integer)itr.next();
          if (x == toyId) itr.remove(); //удаляем toyId из весов
        } 
        counts.remove(toyId); 
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
      try (PrintWriter writer = new PrintWriter("ToyShopProject/Wins.txt")) {
        for (int f = 1; f <= 10; f++) {               //делаем 10 гетов - 10 розыгрышей
            Toy toy = getToy(); 
             System.out.println(counts);
             System.out.println(weights);
            String winner = String.format("%d. %s\n", f, toy.getName(), "cp866");    //каждый пишем в файл в формате 1.Кукла 2.Машинка
            writer.write(winner);
        }
      } 
      catch (FileNotFoundException e) {
        System.out.println("Ошибка записи в файл");
      }
        System.out.println("Розыгрыш окончен!");
    } 
}
