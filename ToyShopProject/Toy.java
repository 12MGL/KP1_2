package ToyShopProject;
  //здесь будем описывать игрушки
public class Toy { //основные параметры игрушки
  private int id; 
  public String name; 
  public int count;
  public int weight;
}

//геты по всем параметрам

public int getId(){
  return id;
}

public int getName(){
  return name;
}

public int getCount(){
  return count;
}

public int getWeight(){
  return weight;
}
