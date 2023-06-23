package ToyShopProject;

import java.io.FileWriter;
import java.util.Scanner;

public class main{
  public static void main(String[] args) {
    ToyShop toyShop = new ToyShop();
      toyShop.getToy();
      

      toyShop.addToy();
      toyShop.addToy();
      toyShop.addToy();

      toyShop.writeWins();
    }
}