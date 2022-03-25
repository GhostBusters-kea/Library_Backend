package com.project1.api;

import com.project1.dto.LibraryRequest;
import com.project1.dto.LibraryResponse;
import com.project1.entity.Library;
import com.project1.service.LibraryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/libraries")
public class LibraryController {
    LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping
    public List<LibraryResponse> getLibraries(){return libraryService.getLibraries();}

    @GetMapping("/{id}")
    public LibraryResponse getLibrary(@PathVariable int id) throws Exception{
        return libraryService.getLibrary(id);
    }

    // Only for admins
    @PostMapping
    public LibraryResponse addLibrary(@RequestBody LibraryRequest body){
        return addLibrary(body);
    }

    @DeleteMapping("/{id}")
    public void deleteLibrary(@PathVariable int id) throws Exception {
        libraryService.deleteLibrary(id);
    }


}
