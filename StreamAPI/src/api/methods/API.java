package api.methods;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class API {
    /**
     * In Java 8, IntStream is a specialized stream that deals specifically with primitive integers.
     * It is part of the
     * Stream API and provides a set of operations specifically tailored for manipulating streams of integer values.
     * Using IntStream, you can perform various operations on streams of primitive integers efficiently.
     * Here are some key features and operations provided by IntStream:
     * Creation: You can create an IntStream from a variety of sources, such as arrays, ranges, or by transforming
     * other streams. For example,
     * 1. Creation: You can create an IntStream from a variety of sources, such as arrays, ranges,
     * or by transforming other streams. For example,
     * 2. Terminal operations: IntStream supports various terminal operations like sum(), average(), min(), max(),
     * count(), and forEach(), which allow you to perform calculations or obtain specific information from the stream.
     * 3. Intermediate operations: IntStream provides various intermediate operations such as filter(), map(),
     * flatMap(), distinct(), sorted(), etc., that allow you to transform or filter the elements in the stream.
     * 4. Reduction operations: IntStream provides reduction operations such as reduce() and collect(), allowing you
     * to combine the elements of the stream into a single result.
     * 5. Parallel execution: IntStream supports parallel processing, allowing you to perform operations on the stream
     * in parallel, utilizing multiple threads.
     */
    public void range(){
        IntStream.range(0,10).forEach(System.out::println);
        IntStream.rangeClosed(0,10).forEach(System.out::println);
    }

    /**
     * find min number from an array.
     * min() method takes a comparator as input, based on that finds the min value from a given list.
     * min() method returns an Optional object that may or may not contain the minimum element.
     * similarly, we can use the max() method as well.
     */
    public void findMin(){
        // find min in a list
        final List<Integer> numbers = List.of(3,12,34,5,23,12,54,65);
        numbers.stream()
                .min((num1, num2)->{
                    if(Objects.equals(num1, num2)){
                        return 0;
                    }
                    return num1 > num2 ? 1 : -1;
                })
                .ifPresent(System.out::println);

        //Find the minimum element from a stream of integers.
        Optional<Integer> minNumber = numbers.stream().min(Integer::compareTo);
        minNumber.ifPresent(System.out::println);

        // Find the employee with the lowest salary from a list of employees.
        List<Employee> employees = Arrays.asList(
                new Employee("John", 5000D),
                new Employee("Mary", 4500D),
                new Employee("Tom", 6000D)
        );
        Optional<Employee> minSalaryEmployee = employees.stream().min(Comparator.comparingDouble(Employee::getSalary));
        minSalaryEmployee.ifPresent(e -> System.out.println("Lowest salary: " + e.getSalary()));

        // Find the string with the minimum length from a stream of strings.
        List<String> strings = Arrays.asList("apple", "banana", "orange", "pear");
        strings.stream().min(Comparator.comparingInt(String::length)).ifPresent(System.out::println);

        // Find the earliest date from a stream of LocalDate objects.
        List<LocalDate> dates = Arrays.asList(
                LocalDate.of(2022, 1, 1),
                LocalDate.of(2022, 6, 15),
                LocalDate.of(2021, 12, 31)
        );
        dates.stream().min(LocalDate::compareTo).ifPresent(System.out::println);
    }


    /**
     * distinct() method is used to eliminate duplicate elements from a stream. It returns a new stream that contains
     * only distinct elements based on their equals() method.
     * To ensure that distinct() works correctly for custom objects, you need to override the equals() and hashCode()
     * methods in your class.
     */
    public void distinct(){
        List<Integer> numbers = List.of(1,1,1,1,2,3,3,3,3,4,5,55,5,5,5);
        numbers.stream().distinct().toList().forEach(System.out::println);

        List<String> words = Arrays.asList("apple", "banana", "apple", "orange", "banana");
        words.stream().distinct().toList()
                .forEach(System.out::println);


        List<Product> products = Arrays.asList(
                new Product("Apple", "Fruit"),
                new Product("Banana", "Fruit"),
                new Product("Orange", "Fruit"),
                new Product("Apple", "Fruit"),
                new Product("Mango", "Fruit")
        );

        products.stream().distinct().toList().forEach(System.out::println);
    }


    /**
     * filter() method is used to select elements from a stream based on a specified condition.
     * It takes a Predicate as an argument, which is a functional interface representing a condition to
     * be checked for each element in the stream.
     */
    public void filter(){
        // Example 1: Filter even numbers from a list of integers:
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .toList();
        System.out.println(evenNumbers); // Output: [2, 4, 6]

        // Example 2: Filter strings with length greater than 5 from a list of strings:
        List<String> words = Arrays.asList("apple", "banana", "orange", "pear", "grape");
        List<String> longWords = words.stream()
                .filter(s -> s.length() > 5)
                .toList();
        System.out.println(longWords); // Output: [banana, orange]

        // Example 3: Filter objects based on a custom condition using a class method reference:
        List<Person> people = Arrays.asList(
                new Person("John", 25),
                new Person("Mary", 17),
                new Person("Tom", 32),
                new Person("Alice", 20)
        );
        List<Person> adults = people.stream()
                .filter(Person::isAdult)
                .collect(Collectors.toList());
        System.out.println(adults);

        // Example 4: Filter objects based on a custom condition using a lambda expression:
        List<Person> adults2 = people.stream()
                .filter(person -> person.getAge() >= 18)
                .collect(Collectors.toList());
        System.out.println(adults2);

    }

    /**
     * map(): allows us to simply transform from one data type to another.
     * In Java's Stream API, the map() method is used to transform each element of a stream into another value based
     * on a provided mapping function. It takes a Function as an argument, which is a functional interface representing
     * the transformation logic.
     */
    public void map(){
        // Example 1: Convert a list of strings to uppercase:
        List<String> words = Arrays.asList("apple", "banana", "orange", "pear");
        words.stream().map(String::toUpperCase).toList().forEach(System.out::println);


        //Example 2: Extract the lengths of strings in a list:
        words.stream().map(String::length).toList().forEach(System.out::println);


        // Example 4: Extract a specific property from a list of objects:
        List<Person> people = Arrays.asList(
                new Person("John", 25),
                new Person("Mary", 30),
                new Person("Tom", 35)
        );

        people.stream().map(Person::getName).toList().forEach(System.out::println);
    }

    /**
     * average(), mapToDouble()
     */
    public void average(){
        List<Person> people = Arrays.asList(
                new Person("John", 25),
                new Person("Mary", 17),
                new Person("Tom", 32),
                new Person("Alice", 20)
        );

        Double avg = people.stream().mapToDouble(Person::getAge).average().orElse(0);
        System.out.println(avg);

    }

    /**
     * finaAny(): method is used to retrieve an arbitrary element from a stream.
     * It returns an Optional object that either contains the found element or is empty if the stream is empty.
     * It is Non-deterministic: if we run it multiple times, we can get different results.
     * findFirst(): method is used to retrieve the first element from a stream.
     * It returns an Optional object that either contains the first element of the stream
     *  or is empty if the stream is empty.
     * Deterministic: returns same result if executed multiple times on a data set.
     */
    public void find(){
        // Find any person older than 30 from a list of people:
        List<Person> people = Arrays.asList(
                new Person("John", 25),
                new Person("Mary", 35),
                new Person("Tom", 40)
        );
        Optional<Person> anyPersonOlderThan30 = people.stream()
                .filter(person -> person.getAge() > 30)
                .findAny();
        anyPersonOlderThan30.ifPresent(person -> System.out.println(person.getName())); // Output: "Mary"
        // (or any other person older than 30 from the list)


        // Find the first person older than 30 from a list of people:
        Optional<Person> firstPersonOlderThan30 = people.stream()
                .filter(person -> person.getAge() > 30)
                .findFirst();
        firstPersonOlderThan30.ifPresent(person -> System.out.println(person.getName())); // Output: "Mary"
    }

    /**
     * count(): method is used to count the number of elements in a stream. It returns a long value representing the count.
     */
    public void count(){
        List<Person> people = Arrays.asList(
                new Person("John", 25),
                new Person("Mary", 35),
                new Person("Tom", 40)
        );
        long count = people.stream()
                .filter(person -> person.getAge() > 30)
                .count();
        System.out.println(count); // Output: 2
    }

    /**
     * sum(): method is used to calculate the sum of elements in a numeric stream. It returns the sum as a result.
     */
    public void sum(){
        // Example 1: Calculate the sum of integers in a list:
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int sum = numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println(sum);

        // Example 2: Calculate the sum of doubles in a list:
        List<Double> values = Arrays.asList(1.5, 2.5, 3.5, 4.5, 5.5);
        double sum1 = values.stream()
                .mapToDouble(Double::doubleValue)
                .sum();
        System.out.println(sum1);

        // Example 3: Calculate the sum of salaries for a list of employees:
        List<Employee> employees = Arrays.asList(
                new Employee("John", 2000D),
                new Employee("Mary", 3000D),
                new Employee("Tom", 2500D)
        );

        double sum2 = employees.stream().mapToDouble(Employee::getSalary).sum();
        System.out.println(sum2);
    }

    /**
     * statistics(): method is used to calculate statistical summary data for numeric elements in a stream.
     * It returns an instance of the DoubleSummaryStatistics class,
     * which provides statistical information such as count,
     * sum, average, minimum, and maximum values.
     */
    public void statistics(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        DoubleSummaryStatistics stats = numbers.stream()
                .mapToDouble(Integer::doubleValue)
                .summaryStatistics();
        System.out.println("Count: " + stats.getCount());       // Output: Count: 5
        System.out.println("Sum: " + stats.getSum());           // Output: Sum: 15.0
        System.out.println("Average: " + stats.getAverage());   // Output: Average: 3.0
        System.out.println("Min: " + stats.getMin());           // Output: Min: 1.0
        System.out.println("Max: " + stats.getMax());           // Output: Max: 5.0
        System.out.println("stats: " + stats);     // DoubleSummaryStatistics{count=5, sum=15.000000, min=1.000000, average=3.000000, max=5.000000}
    }

    /**
     * groupBy():method is used to group elements of a stream based on a specified classification function.
     * It returns a Collector that partitions or groups the elements into a Map where the keys represent the grouping
     * criteria, and the values represent the elements that belong to each group.
     */
    public void groupBy(){
        List<Person> people = Arrays.asList(
                new Person("John", 25),
                new Person("Mary", 35),
                new Person("Tom", 40),
                new Person("Lisa", 25)
        );

        Map<Integer, List<Person>> peopleByAge = people.stream()
                .collect(Collectors.groupingBy(Person::getAge));

        System.out.println(peopleByAge);

        // You can also apply additional downstream collectors after groupingBy() to perform additional operations on
        // the grouped elements.For example,you can calculate the sum, average, or count of elements within each
        // group using collectors like summingInt(), averagingInt(), or counting().
        Map<Integer, Long> countByAge = people.stream()
                .collect(Collectors.groupingBy(Person::getAge, Collectors.counting()));
        System.out.println(countByAge);


        //Example 1: Grouping a list of strings by their length java
        List<String> words = Arrays.asList("apple", "banana", "cat", "dog", "elephant", "frog");
        Map<Integer, List<String>> fruitGroup = words.stream().collect(Collectors.groupingBy(String::length));
        System.out.println(fruitGroup);

        // Example 2: Grouping a list of objects by a custom criteria:
        List<Product> products = Arrays.asList(
                new Product("iPhone", "Electronics"),
                new Product("MacBook", "Electronics"),
                new Product("Shirt", "Clothing"),
                new Product("Jeans", "Clothing"),
                new Product("Book", "Books")
        );

        Map<String, List<Product>> productsCategory = products.stream().collect(Collectors.groupingBy(Product::getCategory));
        System.out.println(productsCategory);

        // Example 3: Grouping a list of numbers by their parity (even/odd):
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.println(numbers.stream().collect(Collectors.groupingBy(item-> item%2==0 ? "Even":"Odd")));


        // Example 4: group and count
        List<String> names = Arrays.asList("Emma", "Liam", "Hector", "Bella", "Alex", "Alex", "Emma");
        names.stream().collect(Collectors.groupingBy(String::valueOf, Collectors.counting()))
                .forEach((name, count)->{System.out.println(name+" : "+count);});
    }

    /**
     * reduce(): combines all the elements of a stream and then produces a single result.
     * Reduce() method is used to perform a reduction operation on the elements of a stream.
     * It combines the elements of the stream into a single result by applying a binary operator to each element successively.
     * The reduce() method has multiple overloaded versions, but the most commonly used one takes two parameters:
     * an identity value and a binary operator. The identity value represents the initial value of the reduction
     * operation, and the binary operator specifies how two elements should be combined.
     */
    public void reduce(){
        // Example 1: Summing the numbers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int sum = numbers.stream().reduce(0, Integer::sum);
        System.out.println(sum);

        // Example 2: Finding the maximum number
        Optional<Integer> max = numbers.stream().reduce(Integer::max);
        System.out.print(max.get());

        // Example 3: Concatenating strings
        List<String> strings = Arrays.asList("Hello", "World", "!");
        Optional<String> line = strings.stream().reduce(String::concat);
        System.out.println(line.get());

        line = strings.stream().reduce((str1, str2)-> str1 + " "+str2);
        System.out.println(line.get());

    }
}
