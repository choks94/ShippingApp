/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shippingREST.rest.service;

import com.shippingREST.rest.domain.ShippingOrder;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author STEFAN94
 */
public interface OrderService {
    
    public ShippingOrder saveOrder(ShippingOrder order);

    public List<ShippingOrder> findAll();
}
