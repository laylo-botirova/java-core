package lessons.lesson12.streams;

import java.util.*;
import java.util.stream.Collectors;


public class StreamAPI {
    public static void main(String[] args) {


        //1) vivod chetnih  s ispolzovaniem for

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> sqrs = new ArrayList<>();
        for (Integer n : numbers) {
            if (n % 2 == 0) sqrs.add(n * n);
        }
        System.out.println(sqrs);

        //1) cherez stream
        List<Integer> sqrStream = numbers.stream().filter((n) -> n % 2 == 0).map((n) -> n * n).toList();
        System.out.println(sqrStream);


        //2) counter strok dlinnee 5 bukv cherez for
        List<String> words = List.of("banana", "apple", "pear", "pineapple");
        int count = 0;
        for (String s : words) if (s.length() > 5) count++;

        System.out.println(count);


        //2) Stream
        long countStr = words.stream().filter(s -> s.length() > 5).count();
        System.out.println(countStr);


        //3 max-min using for
        List<Integer> nums = List.of(10, 2, 33, 4, 25);
        int min = nums.get(0);
        int max = nums.get(0);
        for (Integer n : nums) {
            if (n < min) min = n;
            if (n > max) max = n;
        }
        System.out.println("min num- " + min);
        System.out.println("max num- " + max);

        //Stream
        int minStream = nums.stream().min(Integer::compare).orElseThrow();
        int maxStream = nums.stream().max(Integer::compare).orElseThrow();

        System.out.println("min num- " + minStream);
        System.out.println("max num- " + maxStream);


        //4) average str length -> for
        List<String> names = List.of("Alice", "Bob", "Charlie", "David");
        int sum = 0;
        for (String name : names) {
            sum += name.length();
        }
        double average = (double) sum / names.size();
        System.out.println(average);

        //stream
        double avgStr = names.stream().mapToInt(String::length).average().orElse(0);
        System.out.println(avgStr);


        //5) udalenie dublikatov i sortirovka po dline-> for
        List<String> str = List.of("apple", "pear", "apple", "banana", "pear");
        List<String> unique = new ArrayList<>();
        for (String w : str) {
            if (!unique.contains(w)) unique.add(w);
        }

        for (int i = 0; i < unique.size(); i++) {
            for (int j = 0; j < unique.size(); j++) {
                if (unique.get(i).length() > unique.get(j).length()) {
                    String temp = unique.get(i);
                    unique.set(i, unique.get(j));
                    unique.set(j, temp);
                }
            }

        }
        System.out.println(unique);

        //stream
        List<String> res = str.stream().distinct().sorted(Comparator.comparing(String::length)).toList();
        System.out.println(res);


        //6 with for
        List<String> fruits = List.of("apple", "banana", "kiwi");
        Map<String, Integer> map = new HashMap<>();
        for (String f : fruits) map.put(f, f.length());
        System.out.println(map);

        //stream
        Map<String, Integer> mapStream = fruits.stream().collect(Collectors.toMap(f -> f, String::length));
        System.out.println(mapStream);


        //7) group by first letter-> for
        List<String> names1 = List.of("Alice", "Andrew", "Bob", "Charlie", "Catherine");
        Map<Character, List<String>> groups = new HashMap<>();
        for (String n : names1) {
            char first = n.charAt(0);
            groups.computeIfAbsent(first, k -> new ArrayList<>()).add(n);
        }
        System.out.println(groups);

        //stream
        Map<Character, List<String>> grouped = names.stream().collect(Collectors.groupingBy(n -> n.charAt(0)));
        System.out.println(grouped);

        //8 for
        List<String> names2 = Arrays.asList("Tom", "Jerry", "Spike");

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < names2.size(); i++) {
            sb.append(names2.get(i));
            if (i < names2.size() - 1) sb.append(", ");


        }
        System.out.println(sb.toString());


        //stream
        String appended = names2.stream().collect(Collectors.joining(", "));
        System.out.println(appended);


        //9) for
        List<String> sentences = Arrays.asList("Java is cool", "Streams are powerful");

        List<String> wordsList = new ArrayList<String>();
        for (String s : sentences) {
            String[] parts = s.split(" ");
            for (String w : parts) {
                wordsList.add(w);
            }
        }

        System.out.println(wordsList);

        //stream
        List<String> all = sentences.stream().flatMap(s -> Arrays.stream(s.split(" "))).toList();
        System.out.println(all);


        //10
        List<Product> products = Arrays.asList(
                new Product("Phone", "Electronics", 1200),
                new Product("TV", "Electronics", 1800),
                new Product("Apple", "Fruits", 2.5),
                new Product("Mango", "Fruits", 4.0)
        );

        Map<String, Product> mostExpensive = new HashMap<String, Product>();

        for (Product p : products) {
            Product existing = mostExpensive.get(p.category);
            if (existing == null || p.price > existing.price) {
                mostExpensive.put(p.category, p);
            }
        }
        System.out.println(mostExpensive);


        //stream
        Map<String, Optional<Product>> expensiveStream = products.stream()
                .collect(Collectors.groupingBy(
                        Product::getCategory,
                        Collectors.maxBy(Comparator.comparingDouble(Product::getPrice))
                ));
        System.out.println(expensiveStream);
    }

}
