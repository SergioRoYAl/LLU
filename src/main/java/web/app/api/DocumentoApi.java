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

import web.app.entity.DocumentoEntity;
import web.app.service.DocumentoService;

@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/documento")
public class DocumentoApi {
 
    @Autowired
    DocumentoService oDocumentoService;

    @GetMapping("")
    public ResponseEntity<Page<DocumentoEntity>> getPage(Pageable oPageable) {
            return ResponseEntity.ok(oDocumentoService.getPage(oPageable));
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<Page<DocumentoEntity>> getPageByUser(@PathVariable("id") Long id, Pageable oPageable) {
            return ResponseEntity.ok(oDocumentoService.getPageByUser(id, oPageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DocumentoEntity> get(@PathVariable("id") Long id){
        return ResponseEntity.ok(oDocumentoService.get(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable("id") Long id){
        return ResponseEntity.ok(oDocumentoService.delete(oDocumentoService.get(id)));
    }

    //HAY QUE HACER MAS SEGURO ESTE PROCESO
    @PostMapping("")
    public ResponseEntity<DocumentoEntity> create(@RequestBody DocumentoEntity oDocumentoEntity){
        return ResponseEntity.ok(oDocumentoService.create(oDocumentoEntity));
    }

    @PutMapping("")
    public ResponseEntity<DocumentoEntity> update(@RequestBody DocumentoEntity oDocumentoEntity){
        return ResponseEntity.ok(oDocumentoService.update(oDocumentoEntity));
    }

    @GetMapping("/pendiente/{id}")
    public ResponseEntity<DocumentoEntity> isPendiente(@PathVariable("id") Long id){
        return ResponseEntity.ok(oDocumentoService.isPendiente(id));
    }
    
}
