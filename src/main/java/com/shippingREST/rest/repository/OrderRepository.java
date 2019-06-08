/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shippingREST.rest.repository;

import com.shippingREST.rest.domain.ShippingOrder;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


/**
 *
 * @author STEFAN94
 */

public interface OrderRepository extends CrudRepository<ShippingOrder, Long>{
    
    public Optional<ShippingOrder> findByOrderId(long oId);
    
}
