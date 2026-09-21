package com.ethan.ainotes;

public class NoteInterpretation {
     private String title;
    private String content;

    public NoteInterpretation(String title, String content){
        this.title = title;
        this.content = content;
    }
    public String getTitle(){
        return this.title;
    }
    public String getContent(){
        return this.content;
    }
}
