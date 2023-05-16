package api.methods;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class API {
    /**
     * In Java 8, IntStream is a specialized stream that deals specifically with primitive integers. It is part of the
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
}
