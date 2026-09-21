package com.ethan.ainotes;

import java.util.List;
import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoteController {
    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }



    @PostMapping("/notes")
    public Note createNote(@RequestBody CreateNoteRequest request) {
        return noteService.createNote(request.getTitle(), request.getContent());
    }

    @GetMapping("/notes")
    public List<Note> getNotes() {
        return noteService.getNotes();
    }

    @GetMapping("/notes/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable int id) {
        Note note = noteService.getNoteById(id);
        if(note != null){
            return ResponseEntity.ok(note);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/notes/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable int id) {
        if(noteService.deleteNote(id)){
            return ResponseEntity.noContent().build();
        }
       return ResponseEntity.notFound().build();
    }

    @PutMapping("/notes/{id}")
    public ResponseEntity<Note> updateNote(@PathVariable int id, @RequestBody CreateNoteRequest request) {
        Note note = noteService.updateNote(id, request.getTitle(), request.getContent());
        if (note != null){
            return ResponseEntity.ok(note);
        }
        return ResponseEntity.notFound().build();
    }

}
