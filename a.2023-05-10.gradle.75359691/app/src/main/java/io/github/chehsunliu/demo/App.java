/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package io.github.chehsunliu.demo;

import java.util.ServiceLoader;

public class App {
    public Animal getAnimal() {
        var animal = ServiceLoader.load(Animal.class).findFirst();
        assert animal.isPresent();
        return animal.get();
    }

    public static void main(String[] args) {
        System.out.println(new App().getAnimal().kind());
    }
}