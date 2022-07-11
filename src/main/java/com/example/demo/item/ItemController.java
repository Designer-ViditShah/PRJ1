package com.example.demo.item;

import com.example.demo.CrudConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/item")
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @PostMapping(path="/create")
    public @ResponseBody String create (@RequestBody CreateItemRequest createItemRequest) {
        return CrudConstants.createReturnValue;
    }

    @GetMapping(path="/get")
    public @ResponseBody Iterable<ItemEntity> get() {
        return itemRepository.findAll();
    }

    @PutMapping(path="/update")
    public @ResponseBody String update (@RequestBody UpdateItemRequest updateItemRequest) {
        return CrudConstants.updateReturnValue;
    }

    @DeleteMapping(path="/delete")
    public @ResponseBody void delete(@RequestBody DeleteItemRequest deleteItemRequest) {
    }

    private String validateCreateRequest(CreateItemRequest createItemRequest) {

        if(createItemRequest.getName().isEmpty()){
            return "Name can not be empty";
        }
        if(createItemRequest.getQty() == null){
            return "Please enter Qty";
        }
        if(createItemRequest.getPrice() == null){
            return "Please enter Price";
        }
        return "Saved";
    }
}
