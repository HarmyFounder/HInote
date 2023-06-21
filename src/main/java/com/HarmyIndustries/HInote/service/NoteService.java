package com.HarmyIndustries.HInote.service;

import com.HarmyIndustries.HInote.model.Note;
import com.HarmyIndustries.HInote.repository.NoteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    public List<Note> getAllNotes(){
        return noteRepository.findAll();
    }

    public List<Note> findByTag(String filter){

        if(filter != null && !filter.isEmpty()){
            return noteRepository.findByTag(filter);
        } else {
            return noteRepository.findAll();
        }
    }

    public Note createNote(Note note){
        return noteRepository.save(note);
    }

    public Note updateNote(Note noteToBeUpdated, Note updatedNote){
        BeanUtils.copyProperties(updatedNote,noteToBeUpdated);
        return noteRepository.save(noteToBeUpdated);
    }

    public void deleteNote(Note note){
        noteRepository.delete(note);
    }

}
