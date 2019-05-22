package com.workstudy.ssm.model;

public class Todo {

    private Long id;
    private String content;
    private Boolean isfinish;

    public Todo() {
    }

    public Todo(long id, String content, boolean isfinish) {
        this.id = id;
        this.content = content;
        this.isfinish = isfinish;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean getIsfinish() {
        return isfinish;
    }

    public void setIsfinish(boolean isfinish) {
        this.isfinish = isfinish;
    }

    @Override
    public String toString() {
        return "id:" + id + ";content:" + content + ";isfinish:" + isfinish + ";";
    }
}
