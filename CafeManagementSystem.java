import java.util.ArrayList;
import java.util.Scanner;


abstract class MenuItem {
    String name;
    double price;

    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    
    public abstract double calculateTotal(int quantity);

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}


class Coffee extends MenuItem {
    public Coffee() {
        super("Coffee", 1.00);
    }

    @Override
    public double calculateTotal(int quantity) {
        return price * quantity;
    }
}

class Tea extends MenuItem {
    public Tea() {
        super("Tea", 1.00);
    }

    @Override
    public double calculateTotal(int quantity) {
        return price * quantity;
    }
}

class Sandwich extends MenuItem {
    public Sandwich() {
        super("Sandwich", 2.00);
    }

    @Override
    public double calculateTotal(int quantity) {
        return price * quantity;
    }
}

class Pastry extends MenuItem {
    public Pastry() {
        super("Pastry", 5.00);
    }

    @Override
    public double calculateTotal(int quantity) {
        return price * quantity;
    }
}

class Cake extends MenuItem {
    public Cake() {
        super("Cake", 5.00);
    }

    @Override
    public double calculateTotal(int quantity) {
        return price * quantity;
    }
}



public class CafeManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        MenuItem[] menu = {
            new Coffee(),
            new Tea(),
            new Sandwich(),
            new Pastry(),
            new Cake()
        };

        ArrayList<String> receipt = new ArrayList<>();
        double totalCost = 0;

        while (true) {
        
            System.out.println("----------------------------");
            System.out.println("          CAFE MENU         ");
            System.out.println("----------------------------");
            for (int i = 0; i < menu.length; i++) {
                System.out.printf("%d. %s - $%.2f%n", i + 1, menu[i].getName(), menu[i].getPrice());
            }

            
            System.out.print("Enter your choice (1-5): ");
            int choice = scanner.nextInt();

            
            if (choice < 1 || choice > 5) {
                System.out.println("Invalid choice. Please try again.");
                continue;
            }

            
            System.out.print("Enter quantity: ");
            int quantity = scanner.nextInt();

            if (quantity <= 0) {
                System.out.println("Invalid quantity. Please try again.");
                continue;
            }

            MenuItem selectedItem = menu[choice - 1];
            double itemTotal = selectedItem.calculateTotal(quantity);
            totalCost += itemTotal;

            
            receipt.add(String.format("%s x %d = $%.2f", selectedItem.getName(), quantity, itemTotal));

            
            System.out.print("Add more items? (Y/N): ");
            char addMore = scanner.next().toLowerCase().charAt(0);
            if (addMore != 'y') {
                break;
            }
        }

       
        System.out.println("----------------------------");
        System.out.println("           RECEIPT          ");
        System.out.println("----------------------------");
        for (String line : receipt) {
            System.out.println(line);
        }
        System.out.printf("Total: $%.2f%n", totalCost);
        System.out.println("----------------------------");
        System.out.println("Thank you for visiting!");

        scanner.close();
    }
}