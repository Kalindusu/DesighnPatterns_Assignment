// Singleton Pattern in Java

class Singleton {
    private static Singleton instance; // Static variable to hold the one instance

    // Private constructor to prevent instantiation
    private Singleton() {
    }

    // Method to get the instance of Singleton (creates only one instance)
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("I am the only instance!");
    }
}

public class SingletonDemo {
    public static void main(String[] args) {
        // Get the only object available
        Singleton singleton = Singleton.getInstance();
        singleton.showMessage(); // Output: I am the only instance!

        Singleton anotherSingleton = Singleton.getInstance();
        System.out.println(singleton == anotherSingleton); // Output: true (same instance)
    }
}

