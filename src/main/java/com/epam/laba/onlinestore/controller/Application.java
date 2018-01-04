package com.epam.laba.onlinestore.controller;

import com.epam.laba.onlinestore.model.Product;
import com.epam.laba.onlinestore.service.ProductService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class Application {
    private ProductService productService;

//    @Autowired(required = true)
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "products", method = RequestMethod.GET)
    public String listProducts(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("listProducts", this.productService.listProducts());

        return "products";
    }

    @RequestMapping(value = "/products/add", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("product") Product product) {
        if (0 == product.getId()) {
            this.productService.addProduct(product);
        } else {
            this.productService.updateProduct(product);
        }

        return "redirect:/products";
    }

    @RequestMapping(value = "/remove/{id}")
    public String removeProduct(@PathVariable("id") int id) {
        this.productService.removeProduct(id);

        return "redirect:/products";
    }

    @RequestMapping(value = "/edit/{id}")
    public String editProduct(@PathVariable("id") int id, Model model) {
        model.addAttribute("product", this.productService.getProductById(id));
        model.addAttribute("listProducts", this.productService.listProducts());

        return "products";
    }

    @RequestMapping(value = "productdata/{id}")
    public String productData(@PathVariable("id") int id, Model model) {
        model.addAttribute("product", this.productService.getProductById(id));

        return "productdata";
    }
}
