package lessons.lesson3;

import java.util.ArrayList;
import java.util.Scanner;

public class OnlineStore {
    private String code;
    private String name;
    private int count;
    private double price;

    public OnlineStore(String code, String name, double price, int count) {
        this.code = code;
        this.name = name;
        this.count = count;
        this.price = price;
    }

    private static ArrayList<OnlineStore> products = new ArrayList<>();

    public static void addProduct(String code, String name, double price, int count) {
        for (OnlineStore p : products) {
            if (p.code.equals(code)) {
                System.out.println("item with this code" + name + " already existss");
                return;
            }
        }
        OnlineStore newProd = new OnlineStore(code, name, price, count);
        products.add(newProd);
        System.out.println("Added!");
    }

    public void buyProduct(int quantity) {
        if (count >= quantity) {
            count -= quantity;
            double total = price * quantity;
            System.out.println("name: " + name + "quantity: " + quantity + " for total of " + total);
        } else {
            System.out.println("not enough stock. Availability: " + count);
        }
    }


    public void getProdInfo() {
        System.out.println("OnlineStore{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", price=" + price +
                '}');
    }

    public static OnlineStore findByCode(String code) {
        for (OnlineStore p : products) {
            if (p.code.equals(code)) {
                return p;
            }
        }
        return null;
    }

    public static void getProducts() {
        if (products.isEmpty()) System.out.println("no products available");
     else {
            for (OnlineStore p : products) {
                p.getProdInfo();
            }
        }}

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true){
        System.out.println("Choose an option: 1)add product 2)buy product 3)get product info 4) get products 5) exit ");
        int choice = scanner.nextInt();
        scanner.nextLine();


            switch(choice){
                case 1:
                    System.out.println("enter code: ");
                    String code = scanner.nextLine();

                    System.out.println("name of an item: ");
                    String name= scanner.nextLine();
                    System.out.println("price: ");
                    double price = scanner.nextDouble();
                    System.out.println("count: ");
                    int count = scanner.nextInt();

                    addProduct(code, name, price, count);
                    break;
                case 2:
                    System.out.print("Enter code of product to buy: ");
                    String buyCode = scanner.nextLine();
                    OnlineStore prod = findByCode(buyCode);

                    if (prod != null) {
                        System.out.print("Enter quantity: ");
                        int quantity = scanner.nextInt();
                        scanner.nextLine();
                        prod.buyProduct(quantity);
                    } else {
                        System.out.println(" Product not found with code " + buyCode);
                    }
                    break;

                case 3:
                    System.out.print("Enter code of product: ");
                    String searchCode = scanner.nextLine();
                    OnlineStore p = findByCode(searchCode);
                    if (p != null) {
                        p.getProdInfo();
                    } else {
                        System.out.println("product with this code not found");
                    }
                    break;
                case 4:
                    getProducts();
                    break;
                case 5:
                    System.out.println("exiting...");
            return;
                default:
                    System.out.println("invalid option!");}

        }
    }
}
