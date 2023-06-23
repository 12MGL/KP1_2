package ToyShopProject;

import java.util.Comparator;

public class WeightComparator implements Comparator<Toy> {
  public int compare(Toy t1, Toy t2) {
        return t2.getWeight() - t1.getWeight();   //для формирования списка
    }
}
