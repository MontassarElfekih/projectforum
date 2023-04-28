package tn.devteam.immonexus.Services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tn.devteam.immonexus.Interfaces.IFileUploadService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileUploadService implements IFileUploadService {
    @Override
    public void uploadfile(MultipartFile file) throws IllegalStateException, IOException {
        //file.transferTo(new File("C:\\PiDevFiles\\"+file.getOriginalFilename()));
        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get("src/main/resources/images/" + file.getOriginalFilename());
            Files.write(path, bytes);
        } catch (IOException e) {
            e.printStackTrace();

        }

    }
}
