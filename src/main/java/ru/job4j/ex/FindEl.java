package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int index = 0; index < value.length; index++) {
            if (!value[index].equals(key)) {
                throw new ElementNotFoundException("Array index not found");
            }
            rsl = index;
        }
        return rsl;
    }

    public static boolean sent(String value, String[] abuses) throws ElementAbuseException {
        for (String a : abuses) {
            if (value.equals(a)) {
                throw new ElementAbuseException("The key is included in the private keys");
            }
        }
        return true;
    }

    public static void process(String[] values, String key, String[] abuses) {
        try {
            if (indexOf(values, key) != -1) {
                sent(key, abuses);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String[] value = {"Petr", "Vasya"};
        try {
            System.out.println(indexOf(value,  null));
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
