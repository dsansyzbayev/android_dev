package com.example.recycleview;

class ContentItem {

    private String title;
    private String description;

    public ContentItem(){

    }
    public ContentItem(String title, String description){
        this.title = title;
        this.description =description;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getTitle(){
        return this.title;
    }

    public String getDescription(){
        return this.description;
    }
}
