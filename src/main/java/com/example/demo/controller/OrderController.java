package com.example.demo.controller;

import com.example.demo.models.Order;
import com.example.demo.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;
    @RequestMapping(value = "/orders", method= RequestMethod.GET)
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();

    }
    @RequestMapping(value="/orders", method=RequestMethod.POST)
    public void createOrder (@RequestBody Order o){
        orderService.createOrder(o);
    }

    @RequestMapping(value="/orders/{id}", method=RequestMethod.DELETE)
    public void deleteOrder(@PathVariable int id, HttpServletRequest request) {

        orderService.deleteOrder(id);
        request.setAttribute("o",orderService.getAllOrders());

    }
    @RequestMapping(value = "/ordersid", method= RequestMethod.GET)
    public ModelAndView deleteOrder(HttpServletRequest request, Order o){
        Integer id = Integer.parseInt((request.getParameter("id")));
        orderService.deleteOrder(id);
        List <Order> list = orderService.getAllOrders();
        return new ModelAndView();

    }

    @RequestMapping(value="/orders", method=RequestMethod.PUT)
    public void updateOrder (@RequestBody Order o){
        orderService.updateOrder(o);
    }
}


