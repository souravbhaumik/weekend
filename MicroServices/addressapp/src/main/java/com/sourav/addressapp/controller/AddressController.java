package com.sourav.addressapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sourav.addressapp.entity.Address;
import com.sourav.addressapp.response.AddressResponse;
import com.sourav.addressapp.service.AddressService;

@RestController
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/address/{employeeId}")
    public ResponseEntity<AddressResponse> getAddressByEmployeeId(@PathVariable("employeeId") int id) {

        return ResponseEntity.ok(addressService.getAddressByEmployeeId(id));

    }

    @PostMapping("/address/create")
    public ResponseEntity<AddressResponse> createAddress(@RequestBody Address address) {
        return ResponseEntity.status(HttpStatus.OK).body(addressService.createAddress(address));
    }

}
