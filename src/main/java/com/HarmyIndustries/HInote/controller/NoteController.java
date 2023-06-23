package com.HarmyIndustries.HInote.controller;

import com.HarmyIndustries.HInote.model.Note;
import com.HarmyIndustries.HInote.model.User;

import com.HarmyIndustries.HInote.service.FavoritesService;
import com.HarmyIndustries.HInote.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @Autowired
    private FavoritesService favoritesService;

    @GetMapping("/all")
    public List<Note> getAllNotes() {
        return noteService.getAllNotes();
    }

    @GetMapping("/{id}")
    public Note getCertainNote(@PathVariable("id") Note note) {
        return note;
    }

    @PostMapping("/findByTag")
    public List<Note> getNotesByTag(@RequestParam String filter) {
        return noteService.findByTag(filter);
    }

    @PostMapping("/create")
    public Note createNote(@RequestBody Note note) {
        return noteService.createNote(note);
    }

    @PutMapping("/{id}/update")
    public Note updateNote(@PathVariable("id") Note noteToBeUpdated, @RequestBody Note updatedNote) {
        return noteService.updateNote(noteToBeUpdated, updatedNote);
    }

    @DeleteMapping("/{id}")
    public void deleteNote(@PathVariable("id") Note note) {
        noteService.deleteNote(note);
    }

    @GetMapping("/favoriteList")
    public List<Note> getFavList(@AuthenticationPrincipal User user){
        return user.getFavorites();
    }

    @PostMapping("/{id}/addToFav")
    public Note addToFavorites(@AuthenticationPrincipal User user, @PathVariable("id") Note note) {
        return favoritesService.addToFavorites(user, note);
    }

    @DeleteMapping("/{id}/delFromFav")
    public Note delFromFavorites(@AuthenticationPrincipal User user, @PathVariable("id") Note note){
        return favoritesService.deleteFromFavorites(user,note);
    }

}
