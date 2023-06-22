package ToyShopProject;

import java.io.FileWriter;
import java.util.Scanner;


public class main(String[] args) {
  //здесь будет основное тело программы - запросы игрушек, выдача результатов
  Scanner input = new Scanner(System.in);
  System.out.println("Какое количество видов игрушек находятся в магазине?   ");
  int countToys = input.nextInt();
  for (int i = 1; i <= countToys; i++) {   //для каждой игрушки конструктором добавляем данные в список
    System.out.println("введите название игрушки:  ");
    String name = input.next();
    System.out.println("введите количество игрушек " + name + ":  ");
    int count = input.nextInt();
    System.out.println("введите частоту (вес вероятности) выпадения игрушки " + name + " в %:  ");
    int weight = input.nextInt();
    Toy toy = new Toy(i, name, count, weight);    //в данном случае счётчик от 1 до общего количества для нас станет id игрушки, логично
    ToyShop.addToy(toy);  //по введённым параметрам добавляем игрушку в список, переходим на следующую итерацию
  }

}