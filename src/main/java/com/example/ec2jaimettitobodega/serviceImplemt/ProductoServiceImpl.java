package com.example.ec2jaimettitobodega.serviceImplemt;

import com.example.ec2jaimettitobodega.dto.request.ProductoDTOrequest;
import com.example.ec2jaimettitobodega.dto.response.ProductoDTOresponse;
import com.example.ec2jaimettitobodega.model.Productos;
import com.example.ec2jaimettitobodega.repository.ProductosRepository;
import com.example.ec2jaimettitobodega.services.ProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoServiceImpl implements ProductosService {

    @Autowired
    private ProductosRepository repository;

    @Override
    public void guardar(ProductoDTOrequest productoDTOrequest) {
        Productos p = new Productos();
        p.setProducto(productoDTOrequest.getName_producto());
        p.setDescripcion(p.getDescripcion());
        p.setPrecio(productoDTOrequest.getPrecio_pro());
        p.setStock(productoDTOrequest.getStock_pro());
        repository.save(p);
    }

    @Override
    public void actualizar(ProductoDTOrequest productoDTOrequest) {
        Productos p = new Productos();
        p.setId_producto(productoDTOrequest.getId_pro());
        p.setProducto(productoDTOrequest.getName_producto());
        p.setDescripcion(p.getDescripcion());
        p.setPrecio(productoDTOrequest.getPrecio_pro());
        p.setStock(productoDTOrequest.getStock_pro());

        repository.saveAndFlush(p);
    }

    @Override
    public void eliminar(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<ProductoDTOresponse> listar() {
        List<ProductoDTOresponse> listar = new ArrayList<>();

        ProductoDTOresponse dto = null;

        List<Productos> p = repository.findAll();

        for (Productos productos : p) {

            dto = new ProductoDTOresponse();

            dto.setId_pro(productos.getId_producto());
            dto.setName_producto(productos.getProducto());
            dto.setDescripcion_pro(productos.getDescripcion());
            dto.setPrecio_pro(productos.getPrecio());
            dto.setStock_pro(productos.getStock());


            listar.add(dto);
        }

        return listar;
    }

    @Override
    public ProductoDTOresponse obtenerPorId(Integer id) {
        Productos productos = repository.findById(id).orElse(null);
        ProductoDTOresponse dto = new ProductoDTOresponse();

        dto.setId_pro(productos.getId_producto());
        dto.setName_producto(productos.getProducto());
        dto.setDescripcion_pro(productos.getDescripcion());
        dto.setPrecio_pro(productos.getPrecio());
        dto.setStock_pro(productos.getId_producto());

        return dto;
    }
}
