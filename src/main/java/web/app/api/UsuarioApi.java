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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import web.app.entity.UsuarioEntity;
import web.app.service.UsuarioService;

@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/luz")
public class UsuarioApi {
    
    @Autowired
    UsuarioService oUsuarioService;

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioEntity> get(@PathVariable("id") Long id){
        return ResponseEntity.ok(oUsuarioService.get(id));
    }
    
    //GET MAPPING CON EL USERNAME
    //PARA OBTENER LA INFORMACIÓN DE ALGÚN USUARIO
    @GetMapping("/de/{username}")
    public ResponseEntity<UsuarioEntity> get(@PathVariable("username") String username){
        return ResponseEntity.ok(oUsuarioService.getByUsername(username));
    }

    @GetMapping("")
    public ResponseEntity<Page<UsuarioEntity>> getPage(
            Pageable oPageable,
            @RequestParam(name = "filter", required = false) String strFilter) {
        return ResponseEntity.ok(oUsuarioService.getPage(oPageable, strFilter));
    }

    //POST MAPPING PARA CREAR UN USUARIO
    @PostMapping("")
    public ResponseEntity<Long> create(@RequestBody UsuarioEntity oUsuarioEntity){
        return ResponseEntity.ok(oUsuarioService.create(oUsuarioEntity));
    }

    //PUT MAPPING PARA ACTUALIZAR UN USUARIO
    //SI SE DESEA ACTUALIZAR LA CONTRASEÑA, SE DEBE HACER EN UN ENDPOINT APARTE
    @PutMapping("")
    public ResponseEntity<Long> update(@RequestBody UsuarioEntity oUsuarioEntity){
        return ResponseEntity.ok(oUsuarioService.update(oUsuarioEntity));
    }

    //DELETE MAPPING PARA ELIMINAR UN USUARIO
    //EN EL CASO DE QUE ALGUIEN QUIERA ELIMINAR SU CUENTA
    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable("id") Long id){
        return ResponseEntity.ok(oUsuarioService.delete(id));
    }
}
