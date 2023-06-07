package entity;

import java.sql.Array;
import java.sql.Date;

public class Writer {
    private String name;
    private String lastName;
    private int age;
    private String[] bookNames;
    private int numOfBooks;


    public Writer(String name, String lastName, int age, int maxNumOfBooks) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.bookNames = new String[maxNumOfBooks];
        this.numOfBooks = 0;
    }

    public Writer(int id, String name, String lastName, int age, Array book) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String[] getBookNames() {
        return bookNames;
    }

    public int getNumOfBooks() {
        return numOfBooks;
    }

    public void addBookName(String bookName) {
        if (numOfBooks < bookNames.length) {
            bookNames[numOfBooks] = bookName;
            numOfBooks++;
        } else {
            System.out.println("its full!!");
        }
    }


    public Object[] getBook() {
        Object[] objects = new Object[0];
        return objects;
    }
}

