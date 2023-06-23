package com.HarmyIndustries.HInote.model;

import jakarta.persistence.*;


@Entity
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String text;
    private String tag;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User author;

    public Note() {
    }

    public Note(String title, String text, String tag) {
        this.title = title;
        this.text = text;
        this.tag = tag;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
