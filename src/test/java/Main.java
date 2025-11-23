import me.z7087.stablecollections.StableCollectionFactory;

import java.util.List;

public class Main {
    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        int version = 8;
        try {
            //noinspection Since15
            version = Runtime.version().major();
        } catch (NoSuchMethodError ignored) {
        }
        System.out.println("Java version: " + version);
        StableCollectionFactory factory = StableCollectionFactory.DEFAULT_IMPL;
        List<String> list = factory.ofList("Hello", "Stable", "Collection", "Factory", "!");
        for (String s : list) {
            System.out.println(s);
        }

    }
}
