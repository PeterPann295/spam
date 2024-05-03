package model;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Log {
    private String action;
    private String table;
    private String level;
    private String beforeData;
    private String afterData;
    private String user;
    private String time;
    public Log(String action, String table, String level, String beforeData, String afterData, String user, String time) {
        this.action = action;
        this.table = table;
        this.level = level;
        this.beforeData = beforeData;
        this.afterData = afterData;
        this.user = user;
        this.time = time;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getBeforeData() {
        return beforeData;
    }

    public void setBeforeData(String beforeData) {
        this.beforeData = beforeData;
    }

    public String getAfterData() {
        return afterData;
    }

    public void setAfterData(String afterData) {
        this.afterData = afterData;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Log{" +
                "action='" + action + '\'' +
                ", table='" + table + '\'' +
                ", level='" + level + '\'' +
                ", beforeData='" + beforeData + '\'' +
                ", afterData='" + afterData + '\'' +
                '}';
    }
    public static String formattedTime(LocalDateTime time){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy");
        return time.format(formatter);
    }
    public static <T extends IModel> Log insert(T model, String username) {
        return new Log("insert", model.table(), "Info", "{}", model.afterData(), username , formattedTime(LocalDateTime.now()));
    }
    public static <T extends IModel> Log delete(T model, String username) {
        return new Log("Delete", model.table(), "Danger", model.beforeData(), "{}", username,formattedTime(LocalDateTime.now()));
    }
    public static <T extends IModel> Log update(T model, String username) {
        return new Log("update", model.table(), "Danger", model.beforeData(), model.afterData(), username, formattedTime(LocalDateTime.now()));
    }
    public static <T extends IModel> Log login(T model, String username) {
        return new Log("login", model.table(),"Info", "{}", "{}", username, formattedTime(LocalDateTime.now()));
    }

    public static void main(String[] args) {
        System.out.println(formattedTime(LocalDateTime.now()));
    }
}
