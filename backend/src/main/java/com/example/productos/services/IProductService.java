package com.example.productos.services;

import com.example.productos.dto.ProductDTO;

import java.util.List;

public interface IProductService {

    public ProductDTO crearProducto(ProductDTO productDTO);

    public List<ProductDTO> listarProductos();
}
