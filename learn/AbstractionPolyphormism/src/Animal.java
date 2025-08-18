abstract class Animal {
  abstract void sound();
}

class Dog extends Animal {
  @Override
  public void sound() {
    System.out.println("Bark");
  }
}

class Cat extends Animal {
  @Override
  public void sound() {
    System.out.println("Meow");
  }
}

class Bird extends Animal {
  @Override
  public void sound() {
    System.out.println("Tweet");
  }
}
