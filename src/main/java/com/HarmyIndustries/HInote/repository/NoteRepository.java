package com.HarmyIndustries.HInote.repository;

import com.HarmyIndustries.HInote.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note,Long> {

    List<Note> findByTag(String tag);

}
