package javafxdemo.app.src.main.java.org.example;

public class Hello {
    // In Kotlin -> (message: String)
    public void sayHelloNonNull(@Nonnull String message) {
        System.out.println(message);
    }

    // In Kotlin -> (message: String?)
    public void sayHelloNullable(@Nullable String message) {
        System.out.println(message != null ? message.toUpperCase() : "null");
    }

    // In Kotlin -> (message: String!) (! means that message can be String? or String)
    public void sayHello(String message) {
        System.out.println(message);
    }
}

