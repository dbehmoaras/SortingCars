# SortingCars

To do:
1. Create the list files. all of the pieces are ready.
2. Implement the quicksort object array algorithm by accessing the car's compareTo method in the quicksort engine's partition method.
git commit -m "added clear method to data generator. generates the Vin randomly in the car class's constructor.
---

## Some sample test code
```java
		int[] arr = { 10, 7, 8, 9, 1, 5 };
		int n = arr.length;

		QuicksortEngine.quickSort(arr, 0, n - 1);
		System.out.println("Sorted array: ");
		QuicksortEngine.printResults(arr, n);

		String a = "PW4Y2JD5099A";
		String b = "ND5N2XLUDMTB";

		System.out.println(a.compareTo(b));
		System.out.println(b.compareTo(a));

		Car testCar1 = new Car(1, Color.BLACK, "Los Angeles");
		Car testCar2 = new Car(2, Color.RED, "Miami");
		Car testCar3 = new Car(3, Color.BLACK, "Los Angeles");

		String fileName = GenerateData.create(1);
		GenerateData.write(fileName, testCar1);
		GenerateData.write(fileName, testCar2);
		GenerateData.write(fileName, testCar3);


		System.out.println(ThreadLocalRandom.current().nextInt(0,100));

		UniqueVinGen gen = new UniqueVinGen(1, ThreadLocalRandom.current());

		int i = 0;
		while (i < 7) {
			String randString = gen.nextString();
			System.out.println(randString);
			i += 1;
		}

		Color[] colorArr = Color.class.getEnumConstants();
		for(int i = 0; i < colorArr.length; i += 1){
			System.out.println(colorArr[i]);
		}

		System.out.println(Car.getRandomColor());
		GenerateData.clear(fileName);

```