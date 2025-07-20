package com.gerardo.ecommerce.service;

import com.gerardo.ecommerce.dto.in.CartItemDtoIn;
import com.gerardo.ecommerce.dto.out.CartDtoOut;
import com.gerardo.ecommerce.entity.Cart;
import com.gerardo.ecommerce.entity.CartItem;
import com.gerardo.ecommerce.entity.Product;
import com.gerardo.ecommerce.entity.User;
import com.gerardo.ecommerce.mapper.MapperCart;
import com.gerardo.ecommerce.mapper.MapperCartItem;
import com.gerardo.ecommerce.repository.CartItemRepository;
import com.gerardo.ecommerce.repository.CartRepository;
import com.gerardo.ecommerce.repository.ProductRepository;
import com.gerardo.ecommerce.repository.UserRepository;
import com.gerardo.ecommerce.utility.UserUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserUtility userUtility;

    public CartDtoOut additemToCart(CartItemDtoIn cartItemDtoIn) {

        CartItem cartItem = new CartItem();
        Product productByCode = productRepository.findByCodeItem(cartItemDtoIn.getProduct().getCodeItem())
                .orElseThrow(() -> new RuntimeException(String.format("prodotto con id %d non trovato", cartItemDtoIn.getProduct().getCodeItem())));

        cartItem.setProduct(productByCode);
        cartItem.setQuantity(1);

        User user = userUtility.fetchAuthenticatedUser();
        Cart cart = cartRepository.findCartForUser(userUtility.fetchAuthenticatedUser().getEmail());
        if (cart == null) {
            cart = createCart();
        }
        boolean contains = false;
        //verifico se nel carrello è già presente un prodotto con un determinato barcode, nel caso ci fosse
        //imposto la variabile booleana a true in modo tale che nel caso sia già presente al posto di inserire
        //nuovamente il prodotto ne aumento direttamente la quantità, in caso contrario lo inserisco.
        for (CartItem e : cart.getCartItem()) {
            if (productByCode.getCodeItem() == e.getProduct().getCodeItem()) {
                e.setQuantity(e.getQuantity() + 1);
                contains = true;
                break;
            }
        }

        if (!contains) {
            cart.getCartItem().add(cartItem);
        }
        cartItem.setCart(cart);
        cartRepository.save(cart);
        userRepository.save(user);
        return null;
    }

    public CartDtoOut updateQuantityOfAProduct(int codeItem) {
        String email = userUtility.getEmailOfUser();
        Cart cart = cartRepository.findCartForUser(email);
        if (cart == null) {
            throw new RuntimeException("Il carrello è nullo");
        }
        boolean contains = false;
        for (CartItem c : cart.getCartItem()) {
            if (c.getProduct().getCodeItem() == codeItem) {
                c.setQuantity(c.getQuantity() + 1);
                contains = true;
                break;
            }
        }
        if (contains) {
            cartRepository.save(cart);
        } else {
            throw new RuntimeException(String.format("Prodotto con condice %s non trovato", codeItem));
        }
        return MapperCart.entityToDtoOut(cart);
    }

    public CartDtoOut deleteItemToCart(int codeItem) {
        User user = userUtility.fetchAuthenticatedUser();
        for (CartItem c : user.getCart().getCartItem()) {
            if (c.getProduct().getCodeItem() == codeItem) {
                if (c.getQuantity() > 1) {
                    c.setQuantity(c.getQuantity() - 1);
                } else {
                    user.getCart().getCartItem().remove(c);
                }
                break;
            }
        }
        cartRepository.save(user.getCart());
        return MapperCart.entityToDtoOut(user.getCart());
    }

    public Cart createCart() {
        Cart cart = new Cart();
        cart.setUser(userUtility.fetchAuthenticatedUser());
        return cart;
    }

    public CartDtoOut findCartOfAnUser() {
        return MapperCart.entityToDtoOut(userUtility.fetchAuthenticatedUser().getCart());
    }

    public void emptyTheCart() {
        User user = userUtility.fetchAuthenticatedUser();
        user.getCart().getCartItem().clear();
        cartRepository.save(user.getCart());
    }
}
