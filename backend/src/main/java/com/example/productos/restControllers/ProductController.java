package com.example.productos.restControllers;

import com.example.productos.dto.ProductDTO;
import com.example.productos.dto.ProductDTORequest;
import com.example.productos.services.ProductServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    final ProductServiceImpl productService;

    public ProductController(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @PostMapping("/create")
    public ResponseEntity<ProductDTO> crearProducto(@RequestBody ProductDTORequest productDTORequest){
        ProductDTO productDTO =  productService.crearProducto(new ProductDTO(
                null,
                productDTORequest.getNombre(),
                productDTORequest.getDescripcion()
        ));
        return new ResponseEntity<>(productDTO, HttpStatus.OK);
    }

    @GetMapping("/productList")
    public ResponseEntity<List<ProductDTO>> listarProductos(){
        List<ProductDTO> productList = productService.listarProductos();
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

}
