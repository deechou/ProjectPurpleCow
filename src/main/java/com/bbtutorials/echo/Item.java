package com.bbtutorials.echo;

public class Item {

    private int id;
    private String name;

    public Item(){}

    public Item(int id, String name){
        this.id = id;
        this.name = name;
    }

    public void setID(int id){ this.id = id; }

    public void setName(String name){ this.name = name; }

    public int getID(){ return this.id;}

    public String getName(){
        return this.name;
    }

    @Override
    public String toString(){
        return "Item{" +
                "id=" + id +
                ", name='" + name + "'}";
    }
}
