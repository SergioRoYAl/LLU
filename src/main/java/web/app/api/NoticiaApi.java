package web.app.api;

import org.aspectj.weaver.ast.Not;
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

import web.app.entity.NoticiaEntity;
import web.app.service.NoticiaService;

@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/noticia")
public class NoticiaApi {
    
    @Autowired
    NoticiaService oNoticiaService;

    @GetMapping("")
    public ResponseEntity<Page<NoticiaEntity>> getPage(Pageable oPageable) {
            return ResponseEntity.ok(oNoticiaService.getPage(oPageable));
    }

    @GetMapping("/visible")
    public ResponseEntity<Page<NoticiaEntity>> getPage(Pageable oPageable, String filter) {
        return ResponseEntity.ok(oNoticiaService.getPageVisible(oPageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<NoticiaEntity> get(@PathVariable("id") Long id){
        return ResponseEntity.ok(oNoticiaService.get(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable("id") Long id){
        return ResponseEntity.ok(oNoticiaService.delete(oNoticiaService.get(id)));
    }

    @PostMapping("")
    public ResponseEntity<NoticiaEntity> create(@RequestBody NoticiaEntity oNoticiaEntity){
        return ResponseEntity.ok(oNoticiaService.create(oNoticiaEntity));
    }

    @PutMapping("")
public ResponseEntity<NoticiaEntity> update(@RequestBody NoticiaEntity oNoticiaEntity){
    return ResponseEntity.ok(oNoticiaService.update(oNoticiaEntity));
}


    
}
