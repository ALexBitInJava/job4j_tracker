package ru.job4j.collection;

import java.io.StringReader;
import java.util.HashSet;

public class UniqueText {
    public static boolean isEquals(String originText, String duplicateText) {
        boolean rsl = true;
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        HashSet<String> check = new HashSet<>();
        for (String a : origin) {
            check.add(a);
        }
        for (String b : text) {
            if (!check.contains(b)) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }

}
