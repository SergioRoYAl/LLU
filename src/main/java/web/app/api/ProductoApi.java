package web.app.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import web.app.entity.ProductoEntity;
import web.app.service.ProductoService;



@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/productos")
public class ProductoApi {
    
    @Autowired
    ProductoService oProductoService;

    //MI SUEÑO ES VIVIR EN UNA CASA CON CHARCA LINDÍSIMA Y QUE ESTO FUNCIONE 
    @GetMapping("/{id}")
    public ResponseEntity<ProductoEntity> get(@PathVariable("id") Long id){
        return ResponseEntity.ok(oProductoService.get(id));
    }

    @GetMapping("/{nombre}")
    public ResponseEntity<ProductoEntity> getByNombre(@PathVariable("nombre") String nombre){
        return ResponseEntity.ok(oProductoService.getByNombre(nombre));
    }

    @GetMapping("/visible")
    public ResponseEntity<Page<ProductoEntity>> getPage(Pageable oPageable) {
        return ResponseEntity.ok(oProductoService.getPageVisible(oPageable));
    }

    @GetMapping("/full")
    public ResponseEntity<Page<ProductoEntity>> getPageFull(Pageable oPageable) {
        return ResponseEntity.ok(oProductoService.getPageFull(oPageable));
    }

    @PutMapping("")
    public ResponseEntity<ProductoEntity> update(@RequestBody ProductoEntity oProductoEntity){
        return ResponseEntity.ok(oProductoService.update(oProductoEntity));
    }

    @PostMapping("")
    public Long create(@RequestBody ProductoEntity oProductoEntity){
        return oProductoService.create(oProductoEntity);
    }

    @DeleteMapping("")
    public Long delete(@RequestBody ProductoEntity oProductoEntity){
        return oProductoService.delete(oProductoEntity);
    }
}
