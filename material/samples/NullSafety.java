// program that illustrates null safety in java
public class NullSafety {
    public static void main(String[] args) {
        @NotNull
        String name;
        name = null; //
        String name2;
        name2 = null;
        System.out.println(name2.length()); // compile error
        System.out.println(name2 == null ? 0 : name2.length());
    }

    public static int getLength2(String name) {
        if (name == null)
            return 0;
        return name.length();
    }
}