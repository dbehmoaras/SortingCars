# SortingCars

## Getting Started:

A package has already been provided. However, in the evnt certain dependencies are missing, please run the following command in the terminal:
```
mvn package
```

A testing suite that tests the Car object's compareTo method has been provided. To run the test suite, run the following command in the terminal:
```
mvn test
```

To run the package that executes the main multi-threaded sorting algorithm, run the following command in the terminal:
```
java -jar target/sortingcars-0.1.0.jar
```

The package will execute the following tasks:

	1. Generate all of the car data using random generators
	2. Store the unsorted data in a suite of txt files
	3. Create the thread pool and push a "quicksort" task to the thread pool's blocking queue
	4. Each thread will run concurrently sort the contents of each file individually.
	5. The sorted data will be written to new files so that the user can check the sorted data against the unsorted data.
	6. The time to complete the sorting operation will be logged in the terminal.