package com.HarmyIndustries.HInote.service;

import com.HarmyIndustries.HInote.model.Note;
import com.HarmyIndustries.HInote.model.User;
import com.HarmyIndustries.HInote.repository.UserDetailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FavoritesService {

    @Autowired
    private UserDetailRepo userDetailRepo;


    public Note addToFavorites(User user, Note note) {
        user.getFavorites().add(note);
        userDetailRepo.save(user);
        return note;
    }

    public Note deleteFromFavorites(User user, Note note) {
        user.getFavorites().remove(note);
        userDetailRepo.save(user);
        return note;
    }
}
