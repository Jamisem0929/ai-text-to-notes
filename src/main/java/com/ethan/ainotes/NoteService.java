package com.ethan.ainotes;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;
@Service
public class NoteService {
    private final ArrayList<Note> notes = new ArrayList<>();
    private int nextId = 1;
    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository){
        this.noteRepository = noteRepository;
    }

    public Note createNote(String title, String content) {
        Note note = new Note(title, content);
        return noteRepository.save(note);
    }

    public List<Note> getNotes() {
        return noteRepository.findAll();
    }

    public Note getNoteById(int id) {
        Optional<Note> note = noteRepository.findById(id);

        if(note.isPresent()){
            return note.get();
        }
        return null;
    }
    public boolean deleteNote(int id){
        if (noteRepository.existsById(id)){
            noteRepository.deleteById(id);
            return true;
        }
        return false;
    }
    public Note updateNote(int id, String title, String content) {
       Optional<Note> note = noteRepository.findById(id);
       if (note.isPresent()){
        Note existingNote = note.get();
        existingNote.setTitle(title);
        existingNote.setContent(content);
        noteRepository.save(existingNote);
        return existingNote;
       }
       return null;
    }

}
