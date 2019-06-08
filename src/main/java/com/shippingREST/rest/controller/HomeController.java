/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shippingREST.rest.controller;

import com.shippingREST.rest.domain.ShippingOrder;
import com.shippingREST.rest.repository.OrderRepository;
import com.shippingREST.rest.service.OrderService;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author STEFAN94
 */
@RestController
@RequestMapping("/")
public class HomeController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/getStandardPrice")
    public double getStandardPrice() {
        return 7.5d;
    }

    @GetMapping("/getPremiumPrice")
    public double getPremiumPrice() {
//        System.out.println("===================================" + code);
        return 13.2d;
    }

    @PostMapping("/saveOrder")
    public ShippingOrder saveOrder(@RequestBody ShippingOrder order) {
        System.out.println("============================" + order);
        ShippingOrder so = orderService.saveOrder(order);
        LocalDate today = LocalDate.now();
        LocalDate estimatedDeliveryDate;
        if (order.getShippingMethod().equals("standardShipping")) {
            estimatedDeliveryDate = today.plusDays(15);
            System.out.println("++++++++++++++++++++" + estimatedDeliveryDate);
            so.setEstimatedDeliveryDate(estimatedDeliveryDate);
        } else {
            estimatedDeliveryDate = today.plusDays(7);
            System.out.println("++++++++++++++++++++" + estimatedDeliveryDate);
            so.setEstimatedDeliveryDate(estimatedDeliveryDate);
        }
        return so;
    }
    
    @GetMapping("/getStatus/{orderId}")
    public ShippingOrder getStatus(@PathVariable("orderId") String orderId){
        int oId = Integer.parseInt(orderId);
        List<ShippingOrder> shippingOrderList = orderService.findAll();
        ShippingOrder theShippingOrder = null;
        for (ShippingOrder so : shippingOrderList) {
            if(so.getId()==oId){
                theShippingOrder = so;
            }
        }
        return theShippingOrder;
    }
}
