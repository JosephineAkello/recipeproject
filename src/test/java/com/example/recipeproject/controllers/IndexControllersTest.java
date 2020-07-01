package com.example.recipeproject.controllers;

import java.util.HashSet;

import com.example.recipeproject.domain.Recipe;
import com.example.recipeproject.repositories.RecipeRepository;
import com.example.recipeproject.service.RecipeService;
import com.example.recipeproject.service.RecipeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class IndexControllersTest {

    RecipeServiceImpl recipeService;


    @Mock
    Model model;

    IndexControllers controllers;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
       controllers= new IndexControllers(recipeService);
    }


    @Test
    void testMockMvc() throws Exception{
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controllers).build();
        mockMvc.perform(get("/"))
                .andExpect(status().isOK())
                .andExpect(view().name("index"));

    }


    @Test
    void getIndexPage() throws Exception{

        String viewName = controllers.getIndexPage(model);

        assertEquals("index", viewName);
        when(recipeService.getRecipes()).thenReturn(model);

        verify(recipeService, times(1)).getRecipes();
        verify(model,times(1)).addAttribute(eq("recipe"), anySet());

    }
}
