package com.example.recipeproject.controllers;


import java.util.Optional;

import com.example.recipeproject.domain.Category;
import com.example.recipeproject.domain.UnitofMeasure;
import com.example.recipeproject.repositories.CategoryRepository;
import com.example.recipeproject.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexControllers {

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexControllers(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"", "/","/index"})
    public String getIndexPage(){

        Optional<Category> categoryOptional = categoryRepository.findByDescription("America");
        Optional<UnitofMeasure> unitofmeasureOptional = unitOfMeasureRepository.findByDescription("");

        System.out.println("My cat ID is" + categoryOptional.get().getId());
        System.out.println("My unit of measure ID is" + unitofmeasureOptional.get().getId());

        return "index";
    }
}
