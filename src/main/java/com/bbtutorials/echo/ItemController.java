package com.bbtutorials.echo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class ItemController {

    /* generates random mocked Item Data */
    ItemMockedData mockData = ItemMockedData.getInstance();

    /* gets all items */
    @GetMapping("/items/retrieve")
    public List<Item> index(){
        return mockData.fetchItems();
    }

    /* retrieve Item by ID */
    @GetMapping("/items/retrieve/{id}")
    public Item getItemById(@PathVariable String id){
        int itemId = Integer.parseInt(id);
        return mockData.getItemById(itemId);
    }

    /* This updates the Item name at id from data provided in JSON body */
    @PutMapping("/items/update/{id}")
    public boolean updateItemById(@PathVariable("id") String id, @RequestBody Map<String, String> body){
        if(body.containsKey("name")){
            int itemId = Integer.parseInt(id);
            mockData.getItemById(itemId).setName(body.get("name"));
            return true;
        }
        return false;
    }

    /* adds an item represented by a JSON. If Id already exists, updates instead */
    @PostMapping(path="items/add")
    public boolean addItem(@RequestBody Map<String, String> body){
        int itemId = Integer.parseInt(body.get("id"));
        if(mockData.getItemById(itemId) != null){
            return updateItemById(body.get("id"), body);
        }else {
            if (body.containsKey("id") && body.containsKey("name")) {
                Item i = new Item(Integer.parseInt(body.get("id")), body.get("name"));
                mockData.addItem(i);
                return true;
            }
        }
        return false;
    }

    /* adds a list of items represented by a JSON array. Any already existing ids will be updated instead */
    @PostMapping(path="items/addall")
    public boolean addAllItems(@RequestBody List<Map<String, String>> body){
        if(body.size() > 0){
            for(Map<String, String> m : body){
                addItem(m);
            }

            return true;
        }
        return false;
    }

    /* deletes all items */
    @DeleteMapping("items/deleteall")
    public boolean deleteAll(){
        return mockData.deleteAll();
    }

    /* deletes item by ID */
    @DeleteMapping("items/delete/{id}")
    public boolean deleteById(@PathVariable String id){
        int itemId = Integer.parseInt(id);
        return mockData.deleteItemById(itemId);
    }
}
