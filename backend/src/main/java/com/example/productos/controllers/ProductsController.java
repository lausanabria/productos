package com.example.productos.controllers;

import com.example.productos.dto.ProductDTO;
import com.example.productos.services.ProductServiceImpl;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductsController {

    final ProductServiceImpl productService;

    public ProductsController(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @PostMapping(value="/create")
    public String crearProducto(@RequestParam String nombre, @RequestParam String descripcion, Model model){

        ProductDTO productDTO =  productService.crearProducto(new ProductDTO(
                null,
                nombre,
                descripcion
        ));

        model.addAttribute("id",productDTO.getIdProducto());
        model.addAttribute("nombre",productDTO.getNombre());
        model.addAttribute("descripcion",productDTO.getDescripcion());

        return "infoProductView";
    }

    @GetMapping("/productList")
    public String listarProductos(Model model){
        List<ProductDTO> productList = productService.listarProductos();
        model.addAttribute("productList",productList);
        return "productListView";
    }

}
