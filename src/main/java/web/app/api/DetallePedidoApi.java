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

import web.app.entity.DetallePedidoEntity;
import web.app.service.DetallePedidoService;

@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/detallePedido")
public class DetallePedidoApi {
    
    @Autowired
    DetallePedidoService oDetallePedidoService;

    @GetMapping("")
    public ResponseEntity<Page<DetallePedidoEntity>> getPage(Pageable oPageable) {
            return ResponseEntity.ok(oDetallePedidoService.getPage(oPageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetallePedidoEntity> get(@PathVariable("id") Long id){
        return ResponseEntity.ok(oDetallePedidoService.get(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable("id") Long id){
        return ResponseEntity.ok(oDetallePedidoService.delete(id));
    }

    //HAY QUE HACER MAS SEGURO ESTE PROCESO
    @PostMapping("")
    public ResponseEntity<DetallePedidoEntity> create(@RequestBody DetallePedidoEntity oDetallePedidoEntity){
        return ResponseEntity.ok(oDetallePedidoService.create(oDetallePedidoEntity));
    }

    @PutMapping("")
    public ResponseEntity<DetallePedidoEntity> update(@RequestBody DetallePedidoEntity oDetallePedidoEntity){
        return ResponseEntity.ok(oDetallePedidoService.update(oDetallePedidoEntity));
    }

}
