package com.lesson8;
import java.net.*;
import java.util.*;

interface JsonDB {
    public void open(URL location);
    public void close();
    public HashMap<String, String> lookup(String key);

    public class Default implements JsonDB {
        public void open(URL location) {}
        public void close() {}
        public HashMap<String, String> lookup(String key) {
            return null;
        }
    }
}

public class Employee {
    private String name;

    public Employee(String id) throws Exception {
        JsonDB database = JsonDBFactory.create();
        HashMap<String, String> result = database.lookup(id);
        name = result.get("name");
        JsonDBFactory.destroy(database);
    }
}

class JsonDBFactory {
    public static JsonDB create() throws Exception {
        String dbLocation = "http://holub.com/employees";
        JsonDB database = new JsonDB.Default();
        database.open(new URL(dbLocation));
        return database;
    }
    public static void destroy(JsonDB db) {
        db.close();
    }
}

class DatabaseSpy implements JsonDB {
    JsonDB wrapped;
    public DatabaseSpy(JsonDB wrapped) {
        this.wrapped = wrapped;
    }
    @Override public void open(URL location) {wrapped.open(location);}
    @Override public void close() {wrapped.close();}
    @Override public HashMap<String, String> lookup(String key) {
        HashMap<String, String> result = wrapped.lookup(key);
        System.out.println(result.toString());
        return result;
    }
}

class Test {
    public void test() throws Exception {
        Employee allen = new Employee("Allen");
    }
}