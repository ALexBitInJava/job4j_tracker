package ru.job4j.oop;

public class DummyDic {

    public String engToRus(String eng) {
        return "Неизвестное слово." + eng;
    }

    public static void main(String[] args) {
        String worldEng = "eng - to - rus";
        DummyDic dD = new DummyDic();
        System.out.println(dD.engToRus(worldEng));
    }
}
