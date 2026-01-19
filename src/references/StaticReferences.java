package references;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Function;

public class StaticReferences {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "1", "52", "13", "24", "55", "46", "37", "28");
        /*
        list.stream().map(new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return Integer.parseInt(s);
            }
        }).forEach(s-> System.out.println(s));
         */
        list.stream().map(Integer::parseInt).forEach(s-> System.out.println(s+1));
    }
}
