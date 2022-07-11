package com.example.demo.item;

import lombok.Data;

import java.util.List;

@Data
public class DeleteItemRequest {

    public List<Long> ids;

}
