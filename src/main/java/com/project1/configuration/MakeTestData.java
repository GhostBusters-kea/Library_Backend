package com.project1.configuration;

import com.project1.entity.Library;
import com.project1.repository.LibraryRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;

@Controller
@Profile("!test")
public class MakeTestData implements ApplicationRunner {
    LibraryRepository libraryRepository;

    public MakeTestData(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    public void makeData(){


    }

    @Override
    public void run(ApplicationArguments args){
        makeData();
    }

}
