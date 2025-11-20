// Question : 

class Bike {
  String model;
  int speed;

  static int numberOfBikes = 0;
  public Bike() {
    numberOfBikes++;
  }
}

public class Question2 {
  public static void main(String[] args) {
    Bike bike1 = new Bike();
    Bike bike2 = new Bike();
    Bike bike3 = new Bike();
    Bike bike4 = new Bike();
    Bike bike5 = new Bike();

    System.out.println("Number of bikes: " + Bike.numberOfBikes);
  }
}
