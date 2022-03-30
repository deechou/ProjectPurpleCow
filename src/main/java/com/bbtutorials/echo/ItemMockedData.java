package com.bbtutorials.echo;

import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

//Singleton Class for generating Mock Item Data
public class ItemMockedData {

    private List<Item> items;

    private static ItemMockedData instance = null;
    public static ItemMockedData getInstance(){
        if(instance == null){
            instance = new ItemMockedData();
        }
        return instance;
    }


    public ItemMockedData(){
        items = new ArrayList<>();
        for(int i = 0; i<10; i++){
            Item toAdd = new Item((int)(Math.random()*1000), "item"+i);
            items.add(toAdd);
        }
    }

    public List<Item> fetchItems(){
        return items;
    }

    public Item getItemById(int id){
        for(Item i : items){
            if(i.getID() == id){
                return i;
            }
        }
        return null;
    }

    public void addItem(Item i){
        items.add(i);
    }

    public boolean deleteAll(){
        items = new ArrayList<>();
        return true;
    }
    public boolean deleteItemById(int id){
        for(Item i : items){
            if(i.getID() == id){
                items.remove(i);
                return true;
            }
        }
        return false;
    }

    public Item getItemByName(String name){
        for(Item i : items){
            if(i.getName().equals(name)){
                return i;
            }
        }
        return null;
    }
}
