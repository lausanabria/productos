package com.example.productos.services;

import com.example.productos.dto.ProductDTO;
import com.example.productos.models.Product;
import com.example.productos.repository.IProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    final IProductRepository iProductRepository;

    public ProductServiceImpl(IProductRepository iProductRepository) {
        this.iProductRepository = iProductRepository;
    }

    public ProductDTO crearProducto(ProductDTO productDTO){
        Product product = new Product(
                productDTO.getIdProducto(),
                productDTO.getNombre(),
                productDTO.getDescripcion()
        );
        Product productRepository = iProductRepository.save(product);
        return new ProductDTO(
                productRepository.getIdProducto(),
                productRepository.getNombre(),
                productRepository.getDescripcion()
        );
    }

    public List<ProductDTO> listarProductos() {
        List<Product> listaProductos = iProductRepository.findAll();
        List<ProductDTO> productosRepository = new ArrayList<>();
        for (Product prod : listaProductos) {
            productosRepository.add(
                    new ProductDTO(
                            prod.getIdProducto(),
                            prod.getNombre(),
                            prod.getDescripcion()
                    ));
        }
        return productosRepository;
    }

}
