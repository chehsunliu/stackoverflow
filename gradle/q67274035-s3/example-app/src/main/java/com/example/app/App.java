package com.example.app;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.stream.Collectors;

public class App {

  public static void main(String[] args) {
    InputStream inputStream = Objects.requireNonNull(
        App.class.getResourceAsStream("/com/example/props/application.yml"));
    String content = new BufferedReader(new InputStreamReader(inputStream)).lines()
        .collect(Collectors.joining("\n"));

    System.out.println("Yeah! " + content);
  }
}
