package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Main {

  public static void main(String[] args) throws Exception {
    ArrayList<BigInteger> arrayList = getDataFromFile("file1.txt");
    System.out.println("Максимум: " + _max(arrayList));
    System.out.println("Минимум: " + _min(arrayList));
    System.out.println("Сумма: " + _sum(arrayList));
    System.out.println("Произведение: " + _mult(arrayList));
  }

  public static ArrayList<BigInteger> getDataFromFile(String file_name) {
    File file = null;
    ArrayList<BigInteger> arrayList = new ArrayList<>();
    try {
      URI uri = Main.class.getResource(String.format("/%s", file_name)).toURI();
      file = new File(uri);
      Scanner scanner = new Scanner(file);
      while (scanner.hasNextInt()) {
        arrayList.add(scanner.nextBigInteger());
      }
      scanner.close();
    } catch (FileNotFoundException e) {
      System.out.println("Ошибка чтения файла " + file.getName());
    } catch (URISyntaxException e) {
      throw new RuntimeException(e);
    }
    return arrayList;
  }

  public static BigInteger _min(ArrayList<BigInteger> arrayList) {
    long timeStart = System.currentTimeMillis();
    Collections.sort(arrayList);
    BigInteger minimum = arrayList.get(0);
    long timeFinish = System.currentTimeMillis();
    System.out.println("Количество чисел в файле для функции _min = " + arrayList.size());
    System.out.println("WorkTime для функции _min = " + (timeFinish - timeStart));
    return minimum;

  }


  public static BigInteger _max(ArrayList<BigInteger> arrayList) {
    long timeStart = System.currentTimeMillis();
    Collections.sort(arrayList);
    BigInteger maximum = arrayList.get(arrayList.size() - 1);
    long timeFinish = System.currentTimeMillis();
    System.out.println("Количество чисел в файле для функции _max = " + arrayList.size());
    System.out.println("WorkTime для функции _max = " + (timeFinish - timeStart));
    return maximum;
  }


  public static BigInteger _sum(ArrayList<BigInteger> arrayList) {

    BigInteger sum = BigInteger.valueOf(0);
    for (int i = 0; i < arrayList.size(); i++) {
      sum = sum.add(arrayList.get(i));
    }

    return sum;
  }


  public static BigInteger _mult(ArrayList<BigInteger> arrayList) {
    BigInteger multi = BigInteger.valueOf(1);
    for (int i = 0; i < arrayList.size(); i++) {
      multi = multi.multiply(arrayList.get(i));
    }
    return multi;
  }

}