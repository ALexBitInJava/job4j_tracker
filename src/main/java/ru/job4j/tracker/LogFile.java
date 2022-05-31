package ru.job4j.tracker;

public final class LogFile {

    private static LogFile instance = null;
    private String[] messages = new String[1000];
    private int index = 0;

    private LogFile() {

    }

    public LogFile getInstance() {
        if (instance == null) {
            instance = new LogFile();
        }
        return instance;
    }

    public void add(String message) {
        messages[index++] = message;
    }

    public void save() {
    }
}
