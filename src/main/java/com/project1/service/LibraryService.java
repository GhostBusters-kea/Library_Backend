package com.project1.service;

import com.project1.dto.LibraryRequest;
import com.project1.dto.LibraryResponse;
import com.project1.entity.Library;
import com.project1.error.ClientException;
import com.project1.repository.LibraryRepository;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.stream.Collectors;

// @Author LBK
public class LibraryService {
    LibraryRepository libraryRepository;

    public LibraryService(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    public List<LibraryResponse> getLibraries(){
        List<Library> libraries = libraryRepository.findAll();
        return libraries.stream().map(library -> new LibraryResponse(library)).collect(Collectors.toList());
    }

    public LibraryResponse getLibrary(int id){
        Library library = libraryRepository.findById(id).orElseThrow(()->
        new ClientException("Library not found", HttpStatus.NOT_FOUND));
        return new LibraryResponse(library);
    }


    // Only for admins
    public LibraryResponse addLibrary(LibraryRequest body){
        if(libraryRepository.existsById(body.getId())){
            throw new ClientException("Library already exists");
        }
        Library newLibrary = libraryRepository.save(new Library(body));
        return new LibraryResponse(newLibrary);
    }

    public void updateName(int id, String newName){
        Library library = libraryRepository.findById(id).orElseThrow(() -> new ClientException("No library with that ID"));
        library.setName(newName);
        libraryRepository.save(library);
    }

    public void deleteLibrary(int id){
        if(!libraryRepository.existsById(id)){
            throw new ClientException("Library not found");
        }
        libraryRepository.deleteById(id);
    }

}
