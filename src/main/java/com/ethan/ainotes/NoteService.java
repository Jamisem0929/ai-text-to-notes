package com.ethan.ainotes;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
@Service
public class NoteService {
    private final ArrayList<Note> notes = new ArrayList<>();
    private int nextId = 1;

    public Note createNote(String title, String content) {
        Note note = new Note(nextId, title, content);
        nextId++;
        notes.add(note);
        return note;
    }

    public ArrayList<Note> getNotes() {
        return notes;
    }

    public Note getNoteById(int id) {
        for (Note note : notes){
            if (note.getId() == id){
                return note;
            }
        }
        return null;
    }
    public boolean deleteNote(int id){
        for (int i = 0; i < notes.size(); i++){
            if (notes.get(i).getId() == id){
                notes.remove(i);
                return true;
            }
        }
        return false;
    }
    public Note updateNote(int id, String title, String content) {
        for(Note note : notes){
            if (note.getId() == id){
                note.setTitle(title);
                note.setContent(content);
                return note;
            }
        }
        return null;
    }

}
