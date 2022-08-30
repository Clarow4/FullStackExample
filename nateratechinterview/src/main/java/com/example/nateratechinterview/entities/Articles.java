package com.example.nateratechinterview.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Articles {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nytLogoLink;
    private String title;
    private String author;
    private String description;
    private String pubDate;
    private String imageLink;
    private String articleLink;

    public Articles() {
        nytLogoLink = null;
        title = null;
        author = null;
        description = null;
        pubDate = null;
        imageLink = null;
        articleLink = null;
    }

    public Articles(String nytLogoLink, String title, String author, String description, String pubDate,
            String imageLink,
            String articleLink) {
        this.nytLogoLink = nytLogoLink;
        this.title = title;
        this.author = author;
        this.description = description;
        this.pubDate = pubDate;
        this.imageLink = imageLink;
        this.articleLink = articleLink;
    }

    public String getnytLogoLink() {
        return nytLogoLink;
    }

    public void setnytLogoLink(String nytLogoLink) {
        this.nytLogoLink = nytLogoLink;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public String getArticleLink() {
        return articleLink;
    }

    public void setArticleLink(String articleLink) {
        this.articleLink = articleLink;
    }

    public String toString() {
        return title + "by: " + "\n" + author + "\n" + description + "\nPublished: " + pubDate + "\n\n" + nytLogoLink;
    }
}