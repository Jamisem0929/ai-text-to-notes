package com.ethan.ainotes;

import org.springframework.stereotype.Service;

@Service
public class MessageService {
    private final NoteService noteService;

    public MessageService(NoteService noteService){
        this.noteService = noteService;
    }

    public Note processMessage(String message){
        return noteService.createNote("Captured Message", message);
    }
}
