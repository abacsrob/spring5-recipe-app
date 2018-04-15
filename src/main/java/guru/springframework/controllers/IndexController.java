package guru.springframework.controllers;

import guru.springframework.domain.Recipe;
import guru.springframework.service.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

/**
 * Created by jt on 6/1/17.
 */
@Slf4j
@Controller
public class IndexController {

    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model){
        log.debug("In the controller layer with slf4j ...");
        Set<Recipe> recipes = recipeService.getAllRecipes();
        if (recipes != null) {
            model.addAttribute("recipes", recipes);
        }
        return "index";
    }

    @RequestMapping({"/detailed"})
    public String getDetailedRecipes(Model model){
        Set<Recipe> recipes = recipeService.getAllRecipes();
        if (recipes != null) {
            model.addAttribute("recipes", recipes);
        }
        return "recipes-detailed";
    }
}
