package com.example.service;

import com.example.entity.Cart;

public interface CartService {
   void save(Cart cart);
   Cart findById(Long id);
}