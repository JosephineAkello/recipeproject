package com.example.recipeproject.domain;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {

    Category category;

    @Before
    public void setUp(){
        category= new Category();
    }

    @Test
   public void getId() throws Exception{
   Long idValue = 4l;

   category.setId(idValue);

   assertEquals(idValue,category.getId());
    }

    @Test
    void getDescription() {
    }

    @Test
    void getRecipeSet() {
    }
}
