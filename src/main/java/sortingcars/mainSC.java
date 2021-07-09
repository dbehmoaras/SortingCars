package sortingcars;
import java.util.concurrent.ThreadLocalRandom;

import sortingcars.Car.Color;



public class mainSC{
	public static void main (String[] args){

		Car testCar1 = new Car(1, Color.BLACK, "Los Angeles");
		Car testCar2 = new Car(2, Color.RED, "Miami");
		Car testCar3 = new Car(3, Color.BLACK, "Los Angeles");

		String fileName = GenerateData.createFile(1);
		GenerateData.clear(fileName);
		GenerateData.write(fileName, testCar1);
		GenerateData.write(fileName, testCar2);
		GenerateData.write(fileName, testCar3);

		Color[] colorArr = Color.class.getEnumConstants();

		System.out.println(Car.getRandomColor());

	}
}