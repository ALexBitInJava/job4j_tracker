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

    public static void main(String[] args) {
        String[] value = {"Petr", "Vasya"};
        try {
            System.out.println(indexOf(value,  null));
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
