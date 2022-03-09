package com.lesson7;
import java.io.*;
import java.sql.Connection;

public class Employee {
    private String name;
    public Employee(String name) {this.name = name;}

    interface Importer {String fetchName();}
    interface Exporter {void storeName(String name);}

    public Employee(Importer source) {
        name = source.fetchName();
    }
    public void export(Exporter destination) {
        destination.storeName(name);
    }
}

class JsonImporter implements Employee.Importer {
    private Reader in;
    public JsonImporter(Reader in) {this.in = in;}
    public String fetchName() {
        return "Allen";
    }
}

class XMLImporter implements Employee.Importer {
    private Reader in;
    public XMLImporter(Reader in) {this.in = in;}
    public String fetchName() {
        return "Allen";
    }
}

class JsonExporter implements Employee.Exporter {
    private String name;
    public void storeName(String name) {this.name = name;}
    @Override public String toString() {
        return "{\"name\":\""+ name + "\"}";
    }
}

class XMLExporter implements Employee.Exporter {
    private String name;
    public void storeName(String name) {this.name = name;}
    @Override public String toString() {
        return "<name value=\""+name+"\">";
    }
}

class Demo {
    public void test() throws Exception {
        String xml = "<name value=\"Allen\">";

        Reader in = new StringReader(xml);
        Employee me = new Employee(new XMLImporter(in));

        Employee.Exporter exporter = new XMLExporter();
        me.export(exporter);
        String xmlVersion = exporter.toString();
    }
}