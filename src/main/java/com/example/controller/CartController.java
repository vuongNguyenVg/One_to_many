package com.example.controller;

import com.example.entity.Cart;
import com.example.entity.Items;
import com.example.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

/**
 * Các bạn có thể tìm hiểu thêm  phần này tại blogs: https://levunguyen.com,
 * blogs chuyên về lập trình và các kỹ năng mềm trong nghề lập trình
 */
@RestController
public class CartController {

   @Autowired
   private CartService cartService;

   @GetMapping("/addCart")
   public void addCart() {
      Items item1 = new Items("Item 1");
      Items item2 = new Items("Item 2");
      Set<Items> items = new HashSet<Items>();
      items.add(item1);
      items.add(item2);

      Cart cart = new Cart();
      cart.setItems(items);
      item1.setCart(cart);
      item2.setCart(cart);

      cartService.save(cart); // như vậy ta sẽ lưu dữ liệu xuống 2 bảng Cart và Items
   }

   @GetMapping("/getCart/{id}")
   public Cart getCart(@PathVariable Long id) {
      return this.cartService.findById(id);
   }
}