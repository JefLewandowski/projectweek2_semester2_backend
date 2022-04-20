package com.example.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/")
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    @GetMapping("/check")
    public boolean greeting(@RequestParam(value = "name", defaultValue = "World") String name,
                           @AuthenticationPrincipal Jwt accessToken) {
        System.out.println("In GET Request");
        String scope = accessToken.getClaims().get("scope").toString();
        Boolean partnerRole = scope.contains("partner");
        System.out.println("Contains sequence 'partner': " + accessToken.getClaims().get("scope").toString());
        System.out.println("Contains sequence 'partner': " + accessToken.getClaims().get("scope").toString().contains("partner"));
        if (partnerRole) {
            return true;
        } else {
            return false;
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/products")
    public String addProduct(@Valid @RequestBody Product product, @AuthenticationPrincipal Jwt accessToken) {
        System.out.println("In POST Request");
        String scope = accessToken.getClaims().get("scope").toString();
        Boolean partnerRole = scope.contains("partner");

        if (partnerRole) {
            System.out.println("Contains sequence 'partner': " + accessToken.getClaims().get("scope").toString());
            System.out.println("Contains sequence 'partner': " + accessToken.getClaims().get("scope").toString().contains("partner"));
            repository.save(product);
            return "Product added";
        } else {
            return "Not Authorized to add product";
        }
    }

    @GetMapping("products/searchOnInhabitants/{amt}")
    public List<Product> findProduct(@PathVariable(value = "amt") int amt){
        return repository.findByAdults(amt);
    }

    @GetMapping("products/sortByPrice")
    public List<Product> sortByPrice(){
        return repository.findAll(Sort.by("price"));
    }

    @DeleteMapping("/delete/{id}")
    public List<Product> deleteProduct(@PathVariable("id") long id) {
        repository.deleteById(id);
        return repository.findAll();
    }

}