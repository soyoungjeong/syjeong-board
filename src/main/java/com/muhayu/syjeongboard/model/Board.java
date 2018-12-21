package com.muhayu.syjeongboard.model;

public class Board {

    private String title;
    private String content;
    private String date;
    private int index;
    private String writer;

    public Board() {

    }

    public Board(String title, String content){
        this.title = title;
        this.content = content;
    }

    public String getWriter() { return writer; }

    public void setWriter(String writer) { this.writer = writer; }
    public int getIndex() { return index; }

    public void setIndex(int index) {
        this.index =  index;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
