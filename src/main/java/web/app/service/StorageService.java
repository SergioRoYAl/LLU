package web.app.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
public interface StorageService {

    void init() throws IOException;

    String store(MultipartFile file);

    Resource loadAsResource(String filename);
}
