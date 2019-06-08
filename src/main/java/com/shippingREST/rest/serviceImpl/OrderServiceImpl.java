/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shippingREST.rest.serviceImpl;

import com.shippingREST.rest.domain.ShippingOrder;
import com.shippingREST.rest.repository.OrderRepository;
import com.shippingREST.rest.service.OrderService;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

/**
 *
 * @author STEFAN94
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Override
    public ShippingOrder saveOrder(ShippingOrder order) {
        return orderRepository.save(order);
    }

    @Override
    public List<ShippingOrder> findAll() {
         return (List<ShippingOrder>) orderRepository.findAll();        
    }

}
