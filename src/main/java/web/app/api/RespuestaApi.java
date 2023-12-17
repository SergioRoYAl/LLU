package web.app.api;

import org.springframework.beans.factory.annotation.Autowired;
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

import jakarta.servlet.http.HttpServletRequest;
import web.app.entity.RespuestaEntity;
import web.app.service.RespuestaService;
import web.app.service.SesionService;

@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/respuesta")
public class RespuestaApi {
    
    @Autowired
    RespuestaService oRespuestaService;

    @Autowired
    HttpServletRequest oHttpServletRequest;

    @Autowired
    SesionService oSesionService;

    @GetMapping("/{id}")
    public ResponseEntity<RespuestaEntity> get(@PathVariable("id") Long id){
        return ResponseEntity.ok(oRespuestaService.get(id));
    }

    @PostMapping("")
    public ResponseEntity<Long> create(@RequestBody RespuestaEntity oRespuestaEntity){
        return ResponseEntity.ok(oRespuestaService.create(oRespuestaEntity));
    }

    @PutMapping("")
    public ResponseEntity<Long> update(@RequestBody RespuestaEntity oRespuestaEntity){
        return ResponseEntity.ok(oRespuestaService.update(oRespuestaEntity));
    }   

    @DeleteMapping("")
    public ResponseEntity<Long> delete(@RequestBody RespuestaEntity oRespuestaEntity){
        return ResponseEntity.ok(oRespuestaService.delete(oRespuestaEntity));
    }
}