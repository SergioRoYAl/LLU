package web.app.api;

import java.io.IOException;
import java.net.URLConnection;
import java.nio.file.Files;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.servlet.http.HttpServletRequest;
import web.app.service.FileSystemStorageService;

@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("media")
public class MediaControllerApi {


    @Autowired
    FileSystemStorageService storageService;

    @Autowired
    HttpServletRequest oHttpServletRequest;

    @PostMapping("upload")
    public Map<String, String> uploadFile(@RequestParam("file") MultipartFile multipartFile) {
        String path = storageService.store(multipartFile);
        String url = ServletUriComponentsBuilder.fromCurrentContextPath()
                                               .path("/media/")
                                               .path(path)
                                               .toUriString();
        return Map.of("url", url);
    }
    

    @CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST}, maxAge = 3600)
@GetMapping("{filename:.*}")
public ResponseEntity<Resource> getFile(@PathVariable String filename) {
    Resource file = storageService.loadAsResource(filename);
    String contentType = MediaType.APPLICATION_OCTET_STREAM_VALUE;

    if (file.getFilename() != null) {
        contentType = URLConnection.guessContentTypeFromName(file.getFilename());
    }

    return ResponseEntity.ok()
            .header(HttpHeaders.CONTENT_TYPE, contentType)
            .body(file);
}

}
