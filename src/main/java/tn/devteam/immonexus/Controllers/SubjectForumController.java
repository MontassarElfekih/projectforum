package tn.devteam.immonexus.Controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tn.devteam.immonexus.Dto.SubjectForumDto;
import tn.devteam.immonexus.Entities.SubjectForum;
import tn.devteam.immonexus.Interfaces.ISubjectForumService;
import tn.devteam.immonexus.Repository.SubjectForumRepository;
import tn.devteam.immonexus.Services.FileUploadService;
import tn.devteam.immonexus.Services.SubjectForumService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
@Slf4j
@RequestMapping("/SubjectForum")
public class SubjectForumController {

    @Autowired
    SubjectForumService subForumServ;
    @Autowired
    FileUploadService fileUploadService;
    /*
    @PostMapping("/addSubForum")
    public SubjectForum addSubjectForum(@RequestBody SubjectForum sub){
        subForumServ.addSubjectForum(sub);
        return sub;
    }

     */

    /**
     * upload image using multipartfile
     *
     * @param file
     * @param title
     * @param description
     * @return responce entity
     * @throws IOException
     */
    @PostMapping("/saveSubForum")
    public ResponseEntity<SubjectForum> createItem(@RequestPart("image") MultipartFile file,
                                                   @RequestPart("title") String title,
                                                   @RequestPart("description") String description)
            throws IOException {

        SubjectForum item = new SubjectForum();
        item.setTitle(title);
        item.setDescription(description);
        //item.setImage(file.getBytes());
        fileUploadService.uploadfile(file);
        String imagePath = file.getOriginalFilename();
        log.info("jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj" + imagePath);
        item.setPhoto(imagePath);
        SubjectForum createdItem = subForumServ.addSubjectForum(item);
        return new ResponseEntity<>(createdItem, HttpStatus.CREATED);
    }


    @GetMapping("/getAll")
    public List<SubjectForum> getAllSubForum() {
        return subForumServ.getAllSubForum();
    }

    @GetMapping("/get/{id}")
    public SubjectForum getAllSubForumById(@PathVariable(value = "id") Long id) {
        Optional<SubjectForum> sub = subForumServ.getByIdSubjectForum(id);
        if (sub.isPresent()) {
            return sub.get();
        } else {
            return null;
        }
    }

    @GetMapping("/image/{fileName:.+}")
    public ResponseEntity<byte[]> getImage(@PathVariable String fileName) {
        try {
            Path path = Paths.get("src/main/resources/images/" + fileName);
            byte[] imageBytes = Files.readAllBytes(path);
            return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("remove/{idSubjectForum}")
    public void deleteSubjectForum(@PathVariable(value = "idSubjectForum") Long idSubjectForum) {
        subForumServ.deleteSubjectForum(idSubjectForum);
    }

    @PutMapping("update/{idSubjectForum}")
    public SubjectForum updateSubjectForum(@PathVariable(value = "idSubjectForum") Long idSubjectForum, @RequestBody SubjectForum sub) {
        return subForumServ.updateSubjectForum(idSubjectForum, sub);
    }

    @GetMapping("/SubjectForumwithReact")
    public List<SubjectForumDto> getAllSubForumWithReact() {
        return subForumServ.getAllSubjectForumDto();
    }
}
