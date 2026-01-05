package com.sourav.addressapp.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sourav.addressapp.entity.Address;
import com.sourav.addressapp.repository.AddressRepo;
import com.sourav.addressapp.response.AddressResponse;

@Service
public class AddressService {

    @Autowired
    private AddressRepo addressRepo;

    @Autowired
    private ModelMapper modelMapper;

    public AddressResponse getAddressByEmployeeId(int id) {

        return modelMapper.map(addressRepo.getAddressByEmployeeId(id), AddressResponse.class);

    }

    public AddressResponse createAddress(Address address) {

        address.setId(0);

        return modelMapper.map(addressRepo.save(address), AddressResponse.class);

    }

}
