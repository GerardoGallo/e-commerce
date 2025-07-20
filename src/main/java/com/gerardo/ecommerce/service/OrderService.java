package com.gerardo.ecommerce.service;

import com.gerardo.ecommerce.dto.out.OrderDtoOut;
import com.gerardo.ecommerce.entity.*;
import com.gerardo.ecommerce.mapper.MapperOrder;
import com.gerardo.ecommerce.repository.AddressRepository;
import com.gerardo.ecommerce.repository.OrderRepository;
import com.gerardo.ecommerce.repository.PaymentRepository;
import com.gerardo.ecommerce.utility.UserUtility;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private UserUtility userUtility;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    public List<OrderDtoOut> getUserOrders() {
        User user = userUtility.fetchAuthenticatedUser();
        return MapperOrder.listEntityToListDtoOut(user.getOrder());
    }

    public OrderDtoOut getUserOrdersByIdOrder(int id) {
        User user = userUtility.fetchAuthenticatedUser();
        Order order = user.getOrder().get(id);
        return MapperOrder.entityToDtoOut(order);
    }

    @Transactional
    public OrderDtoOut makeOrderByCart() {
        Payment byId = paymentRepository.findById(1)
                .orElseThrow(()-> new RuntimeException("Tipo di pagamento insesistente"));

        User user = userUtility.fetchAuthenticatedUser();
        Order newOrder = new Order();
        double prezzoOrdine = 0;
        List<OrderItem> listOrderItem = new ArrayList<>();
        for (CartItem p : user.getCart().getCartItem()) {
            OrderItem orderItem = new OrderItem();
            orderItem.setProduct(p.getProduct());
            orderItem.setQuantity(p.getQuantity());
            orderItem.setPrezzo(p.getProduct().getPrezzo() * p.getQuantity());
            listOrderItem.add(orderItem);
            prezzoOrdine += orderItem.getPrezzo();
        }

        newOrder.setUser(user);
        newOrder.setOrderitem(listOrderItem);
        newOrder.setDataOrdine(LocalDateTime.now());
        Address userAddress = user.getAddress();
        Address address = new Address(userAddress.getIndirizzo(),userAddress.getnCivico(),userAddress.getNazionalita(),userAddress.getComune(),userAddress.getProvincia());
        addressRepository.save(address);
        newOrder.setAddress(address);
        newOrder.setPayment(byId);//todo
        newOrder.setPrezzoOrdine(prezzoOrdine);
        newOrder.setStatoOrdine(StatoOrdine.COMPLETATO);
        byId.setOrder(newOrder);
        Order save = orderRepository.save(newOrder);
        return MapperOrder.entityToDtoOut(save);
    }
}
