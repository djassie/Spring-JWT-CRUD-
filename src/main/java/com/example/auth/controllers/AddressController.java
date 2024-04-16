package com.example.auth.controllers;

import com.example.auth.entities.Address;
import com.example.auth.repositories.AddressRepository;
import com.example.auth.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/employee-address")
@RestController
public class AddressController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;

    @RequestMapping(path = "{userId}", method = RequestMethod.GET)
    public ResponseEntity<List<Address>> getAddressByUser(@PathVariable(value = "userId") int userId){
//        List<Address> addressByUserId = addressRepository.findAddressByUserId(userId).orElseThrow();

        List<Address> addressByUser = addressRepository.findByUserId(userId);
//        return new ResponseEntity<>(addressByUserId, HttpStatus.OK);
//        List<Address> addresList = new ArrayList<>(Arrays.asList(new Address("205 B","23/4 Mit Road", "412201", "maharashtra", "India", new User())));
//        return new ResponseEntity<>(addresList, HttpStatus.OK);
        return new ResponseEntity<>(addressByUser, HttpStatus.OK);
    }

    @RequestMapping(path = "{userId}", method = RequestMethod.POST)
    public ResponseEntity<Address> createAddress(@PathVariable(value = "userId") int userId, @RequestBody  Address addressRequest){
        Address address = userRepository.findById(userId).map(user -> {
            addressRequest.setUser(user);
            return addressRepository.save(addressRequest);
        }).orElseThrow();

        return new ResponseEntity<>(address, HttpStatus.CREATED);
    }

    @RequestMapping(path = "{addressId}", method = RequestMethod.PUT)
    public ResponseEntity<Address> updateAddress(@PathVariable(value = "addressId") int addressId, @RequestBody Address addressRequest){
        Address address = addressRepository.findById(addressId)
                .orElseThrow();

//        address.setUser(addressRequest.getUser());
        address.setStreetAddress(addressRequest.getStreetAddress());
        address.setCountry(addressRequest.getCountry());
        address.setState(addressRequest.getState());
        address.setZipCode(addressRequest.getZipCode());
        address.setHouseNo(addressRequest.getHouseNo());

        return new ResponseEntity<>(addressRepository.save(address), HttpStatus.OK);
    }

    @RequestMapping(path = "{addressId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteAddress(@PathVariable(value = "addressId") int addressId){
        Address address = addressRepository.findById(addressId).orElseThrow();

        addressRepository.deleteById(addressId);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
