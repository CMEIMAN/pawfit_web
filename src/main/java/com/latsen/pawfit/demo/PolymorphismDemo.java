package com.latsen.pawfit.demo;

public class PolymorphismDemo {
    public static void main(String[] args) {
        Anminal cat=new Cat();
        cat.eat();
        Anminal dog=new Dog();
        dog.eat();
        System.out.println("--------------------");
        Cat a=(Cat)cat;
        cat.eat();

    }
}
