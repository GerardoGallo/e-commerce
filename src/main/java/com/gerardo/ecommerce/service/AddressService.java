package com.gerardo.ecommerce.service;

import com.gerardo.ecommerce.dto.in.AddressDtoIn;
import com.gerardo.ecommerce.dto.out.AddressDtoOut;
import com.gerardo.ecommerce.entity.Address;
import com.gerardo.ecommerce.entity.User;
import com.gerardo.ecommerce.mapper.MapperAddress;
import com.gerardo.ecommerce.repository.AddressRepository;
import com.gerardo.ecommerce.repository.UserRepository;
import com.gerardo.ecommerce.utility.UserUtility;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    private UserUtility userUtility;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public AddressDtoOut addAddressToUser(AddressDtoIn dtoIn) {
        User user = userUtility.fetchAuthenticatedUser();
        if (user.getAddress() != null){
            throw new RuntimeException("Impossibile aggiungere un altro indirizzo senza prima cancellare il precedente");
        }
        Address newAddress = new Address();
        newAddress.setComune(dtoIn.getComune());
        newAddress.setIndirizzo(dtoIn.getIndirizzo());
        newAddress.setNazionalita(dtoIn.getNazionalita());
        newAddress.setProvincia(dtoIn.getProvincia());
        newAddress.setnCivico(dtoIn.getnCivico());
        newAddress.setUser(user);
        Address savedAddress = addressRepository.save(newAddress);

        return MapperAddress.entityToDtoOut(savedAddress);
    }
}
