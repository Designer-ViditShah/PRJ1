package com.example.demo.item;

import lombok.Data;

@Data
public class CreateItemRequest {

    public String name;
    public Long qty;
    public Long price;

}
