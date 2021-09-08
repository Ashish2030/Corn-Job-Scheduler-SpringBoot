package com.example.demo.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "database123")
public class database
{
    @Transient
    public static final String SEQUENCE_NAME="user_sequence";

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Id
    private int id;
    private String date;
    public database()
    {

    }

    public database(int id, String date, int count) {
        super();
       this. id = id;
        this.date = date;
        this.count = count;
    }

    private int count;




    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
