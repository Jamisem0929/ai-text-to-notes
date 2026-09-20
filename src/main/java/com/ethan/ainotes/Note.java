package com.ethan.ainotes;

public class Note {
    private int id;
    private String title;
    private String content;

    public Note(int id, String title, String content){
        this.id = id;
        this.title = title;
        this.content = content;
    }
    public int getId(){
        return this.id;
    }
    public String getTitle(){
        return this.title;
    }
    public String getContent(){
        return this.content;
    }

}
