package module04.question31.web;

import module04.question31.storage.DbStorageService;
import module04.question31.storage.FileStorageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StorageController {

    private final DbStorageService dbStorageService;

    private final FileStorageService fileStorageService;

    public StorageController(DbStorageService dbStorageService, FileStorageService fileStorageService) {
        this.dbStorageService = dbStorageService;
        this.fileStorageService = fileStorageService;
    }

    @PutMapping("db/storage")
    public int storeInDb(@RequestBody String content) {
        return dbStorageService.store(content);
    }

    @GetMapping("db/storage/{id}")
    public ResponseEntity<String> fetchFromDb(@PathVariable int id) {
        return dbStorageService.fetch(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("file/storage")
    public int storeInFile(@RequestBody String content) {
        return fileStorageService.store(content);
    }

    @GetMapping("file/storage/{id}")
    public ResponseEntity<String> fetchFromFile(@PathVariable int id) {
        return fileStorageService.fetch(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
