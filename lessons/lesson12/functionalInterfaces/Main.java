package lessons.lesson12.functionalInterfaces;
import java.util.*;
import java.util.function.*;
public class Main {
    public static void main(String[] args) {

        // 1. ne pustaya i > 3 simvola
        Predicate<String> isValid = s -> s != null && !s.isEmpty() && s.length() > 3;
        System.out.println(isValid.test("test"));

        // 2.dlina stroki
        Function<String, Integer> lengthFunc = String::length;
        System.out.println(lengthFunc.apply("java"));

        // 3. noviy UUID
        Supplier<UUID> uuidSupplier = UUID::randomUUID;
        System.out.println(uuidSupplier.get());

        // 4. pechat v upper case
        Consumer<String> upperPrinter = s -> System.out.println(s.toUpperCase());
        upperPrinter.accept("hello");

        // 5. summa dvuh chisel
        BiFunction<Integer, Integer, Integer> sum = (a, b) -> a + b;
        System.out.println(sum.apply(2, 5));

        // 6. trim + toUpperCase
        Function<String, String> trim = String::trim;
        Function<String, String> toUpper = String::toUpperCase;
        Function<String, String> trimThenUpper = trim.andThen(toUpper);
        System.out.println(trimThenUpper.apply("   world   "));

        // 7. dva consumer-a cherez andThen
        Consumer<String> printStr = System.out::println;
        Consumer<String> printLen = s -> System.out.println(s.length());
        Consumer<String> combined = printStr.andThen(printLen);
        combined.accept("java");

        // 8. nechetnoe ili otricatelnoe
        Predicate<Integer> isEven = x -> x % 2 == 0;
        Predicate<Integer> isPositive = x -> x > 0;
        Predicate<Integer> oddOrNegative = isEven.negate().or(isPositive.negate());
        System.out.println(oddOrNegative.test(-2));

        // 9. multiply + toStr
        BiFunction<Integer, Integer, Integer> multiply = (a, b) -> a * b;
        Function<Integer, String> toStr = x -> "Result: " + x;
        BiFunction<Integer, Integer, String> chain = multiply.andThen(toStr);
        System.out.println(chain.apply(2, 4));

        // 10. dobavit "!!!"
        UnaryOperator<String> addExcl = s -> s + "!!!";
        System.out.println(addExcl.apply("hi"));

        // 11. filter metod
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> filtered = filter(nums, n -> n % 2 == 0);
        System.out.println(filtered);

        // 12. map metod
        List<String> words = Arrays.asList("java", "go", "python");
        List<Integer> lengths = map(words, String::length);
        System.out.println(lengths);

        // 13. forEach metod
        forEach(words, System.out::println);

        // 14. generate metod
        List<UUID> uuids = generate(UUID::randomUUID, 3);
        System.out.println(uuids);
    }

    // 11. metod filter
    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T t : list) {
            if (predicate.test(t)) {
                result.add(t);
            }
        }
        return result;
    }

    // 12. metod map
    public static <T, R> List<R> map(List<T> list, Function<T, R> mapper) {
        List<R> result = new ArrayList<>();
        for (T t : list) {
            result.add(mapper.apply(t));
        }
        return result;
    }
    // 13. metod forEach
    public static <T> void forEach(List<T> list, Consumer<T> consumer) {
        for (T t : list) {
            consumer.accept(t);
        }
    }
    // 14. metod generate
    public static <T> List<T> generate(Supplier<T> supplier, int n) {
        List<T> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(supplier.get());
        }
        return list;
    }
}
