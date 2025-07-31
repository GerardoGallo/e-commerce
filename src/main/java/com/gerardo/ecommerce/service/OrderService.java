package com.gerardo.ecommerce.service;

import com.gerardo.ecommerce.dto.in.PaymentDtoIn;
import com.gerardo.ecommerce.dto.out.OrderDtoOut;
import com.gerardo.ecommerce.entity.*;
import com.gerardo.ecommerce.enums.StatoOrdine;
import com.gerardo.ecommerce.enums.StatoPagamento;
import com.gerardo.ecommerce.mapper.MapperOrder;
import com.gerardo.ecommerce.repository.*;
import com.gerardo.ecommerce.utility.UserUtility;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CartService cartService;

    @Autowired
    private OrderItemRepository orderItemRepository;

    public List<OrderDtoOut> getUserOrders() {
        User user = userUtility.fetchAuthenticatedUser();
        return MapperOrder.listEntityToListDtoOut(user.getOrder());
    }

    public OrderDtoOut getUserOrdersByIdOrder(int id) {
        User user = userUtility.fetchAuthenticatedUser();
        if (user.getOrder().size() + 1 <= id || id <= 0) {
            throw new RuntimeException(String.format("Impossibile trovare l oridine numero %d", id));
        }
        Order order = user.getOrder().get(id - 1);//recupero l ordine che equivale a id-1 dato che se mi chiede il primo ordine in realta voglio recuperare l elemento 0 dalla lista e così via
        return MapperOrder.entityToDtoOut(order);
    }

    @Transactional
    public OrderDtoOut makeOrderByCart(PaymentDtoIn tipoPagamentoDtoIn) {
        User user = userUtility.fetchAuthenticatedUser();
        if (user.getCart().getCartItem().isEmpty()) {
            throw new RuntimeException("Impossibile effettuare un ordine se il carrello è vuoto");
        }

        Payment nuovoPagamento = new Payment();
        nuovoPagamento.setMetodo(tipoPagamentoDtoIn.getMetodo());
        nuovoPagamento.setStatoPagamento(StatoPagamento.IN_CORSO);
        paymentRepository.save(nuovoPagamento);


        Order newOrder = new Order();
        double prezzoOrdine = 0;
        List<OrderItem> listOrderItem = new ArrayList<>();
        for (CartItem p : user.getCart().getCartItem()) {
            if (p.getQuantity() > p.getProduct().getPezziDisponibili()) {
                throw new RuntimeException(String.format("per il prodotto %s hai richiesto piu pezzi di quanti ne abbiamo disponibili. pezzi richiesti:%d, pezzi disponibili:%d", p.getProduct().getNome(), p.getQuantity(), p.getProduct().getPezziDisponibili()));
            }
            OrderItem orderItem = new OrderItem();
            orderItem.setProduct(p.getProduct());
            orderItem.setQuantity(p.getQuantity());
            orderItem.setPrezzo(p.getProduct().getPrezzo() * p.getQuantity());
            orderItem.setOrder(newOrder);
            listOrderItem.add(orderItem);
            prezzoOrdine += orderItem.getPrezzo();
            p.getProduct().setPezziDisponibili(p.getProduct().getPezziDisponibili() - p.getQuantity());
            orderItemRepository.save(orderItem);
        }

        Address userAddress = user.getAddress();
        Address address = new Address(userAddress.getIndirizzo(), userAddress.getnCivico(), userAddress.getNazionalita(), userAddress.getComune(), userAddress.getProvincia());
        addressRepository.save(address);

        newOrder.setOrderitem(listOrderItem);
        newOrder.setDataOrdine(LocalDateTime.now());
        newOrder.setAddress(address);
        newOrder.setPayment(nuovoPagamento);//todo
        newOrder.setPrezzoOrdine(prezzoOrdine);
        newOrder.setStatoOrdine(StatoOrdine.COMPLETATO);
        nuovoPagamento.setOrder(newOrder);
        newOrder.setUser(user);

        Order save = orderRepository.save(newOrder);
        user.getOrder().add(newOrder);
        cartService.emptyTheCart();
        userRepository.save(user);
        return MapperOrder.entityToDtoOut(save);
    }
}
