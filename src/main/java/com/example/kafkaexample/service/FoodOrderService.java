package com.example.kafkaexample.service;

import com.example.kafkaexample.model.FoodOrder;
import com.example.kafkaexample.producer.Producer;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class FoodOrderService {

    private final Producer producer;

    @Autowired
    public FoodOrderService(Producer producer) {
        this.producer = producer;
    }

    public String createFoodOrder(FoodOrder foodOrder) throws JsonProcessingException {
        return producer.sendMessage(foodOrder);
    }

    public void doSmthWithFoodOrder(FoodOrder foodOrder) {
        System.out.println("Some logic with foodOrder, received from kafka");
    }
}
