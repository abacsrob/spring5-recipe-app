package guru.springframework.bootstrap;

import guru.springframework.domain.*;
import guru.springframework.repository.CategoryRepository;
import guru.springframework.repository.IngredientRepository;
import guru.springframework.repository.RecipeRepository;
import guru.springframework.repository.UnitOfMeasureRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Component
public class RecipesBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private UnitOfMeasureRepository unitOfMeasureRepository;
    private CategoryRepository categoryRepository;
    private IngredientRepository ingredientRepository;
    private RecipeRepository recipeRepository;

    private static final BigDecimal B2 = new BigDecimal("2");

    public RecipesBootstrap(UnitOfMeasureRepository unitOfMeasureRepository, CategoryRepository categoryRepository, IngredientRepository ingredientRepository, RecipeRepository recipeRepository) {
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.categoryRepository = categoryRepository;
        this.ingredientRepository = ingredientRepository;
        this.recipeRepository = recipeRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        UnitOfMeasure uomTeaspoon = unitOfMeasureRepository.findByUom("Teaspoon").get();
        UnitOfMeasure uomTablespoon = unitOfMeasureRepository.findByUom("Tablespoon").get();
        UnitOfMeasure uomOunce = unitOfMeasureRepository.findByUom("Ounce").get();
        UnitOfMeasure uomPound = unitOfMeasureRepository.findByUom("Pound").get();
        UnitOfMeasure uomPiece = unitOfMeasureRepository.findByUom("Piece(s)").get();
        UnitOfMeasure uomClove = unitOfMeasureRepository.findByUom("Clove").get();
        UnitOfMeasure uomCup = unitOfMeasureRepository.findByUom("Cup").get();
        Category category1 = categoryRepository.findByDescription("category1").get();
        Category category2 = categoryRepository.findByDescription("category2").get();
        Category category3 = categoryRepository.findByDescription("category3").get();
        Category category4 = categoryRepository.findByDescription("category4").get();
        Recipe recipe = new Recipe();
        Set<Category> categories = new HashSet<>();
        categories.add(category1);
        categories.add(category2);
        recipe.setCategories(categories);
        Set<Ingredient> ingredients = new HashSet<>();
        ingredients.add(new Ingredient("sesame oil", B2, uomTeaspoon, recipe));
        ingredients.add(new Ingredient("soy sauce", B2, uomTablespoon, recipe));
        ingredients.add(new Ingredient("seasoned rice vinegar", B2, uomTablespoon, recipe));
        ingredients.add(new Ingredient("Asian rice sticks or rice vermicelli noodles", new BigDecimal("6"), uomOunce, recipe));
        ingredients.add(new Ingredient("large eggs", B2, uomPiece, recipe));
        ingredients.add(new Ingredient("peanut or canola oil", B2, uomTablespoon, recipe));
        ingredients.add(new Ingredient("minced ginger", B2, uomTablespoon, recipe));
        ingredients.add(new Ingredient("garlic, finely chopped", BigDecimal.ONE, uomClove, recipe));
        ingredients.add(new Ingredient("carrots, shredded", B2, uomPiece, recipe));
        ingredients.add(new Ingredient("jalapeno pepper, cored and thinly sliced", BigDecimal.ONE, uomPiece, recipe));
        ingredients.add(new Ingredient("sweet onion, thinly sliced", new BigDecimal("0.5"), uomPiece, recipe));
        ingredients.add(new Ingredient("salt", new BigDecimal("0.5"), uomTeaspoon, recipe));
        ingredients.add(new Ingredient("flavorful baked ham, cut into thin 2-inch strips", new BigDecimal("4"), uomOunce, recipe));
        ingredients.add(new Ingredient("Napa cabbage, thinly sliced", new BigDecimal("0.5"), uomPound, recipe));
        ingredients.add(new Ingredient("scallions, green and white parts cut into 1-inch lengths", new BigDecimal("4"), uomPiece, recipe));
        ingredients.add(new Ingredient("red bell pepper, cored, seeded, and cut into 2-inch thin strips", new BigDecimal("0.5"), uomPiece, recipe));
        ingredients.add(new Ingredient("curry powder", B2, uomTeaspoon, recipe));
        ingredients.add(new Ingredient("shrimp, peeled and deveined", new BigDecimal("0.5"), uomPound, recipe));
        ingredients.add(new Ingredient("cilantro leaves, for garnish", B2, uomTablespoon, recipe));
        recipe.setIngredients(ingredients);
        recipe.setCookTime(60 * 10);
        recipe.setPrepTime(60 * 30);
        recipe.setServings(4);
        recipe.setDescription("Singapore Noodles with Shrimp");
        recipe.setDirections("Singapore Noodles with Shrimp");
        recipe.setDifficulty(Difficulty.MODERATE);
        recipe.setUrl("https://www.simplyrecipes.com/recipes/singapore_noodles_with_shrimp/");
        recipe.setSource("https://www.simplyrecipes.com");
        recipe.setNotes(new Notes(recipe, "1 Make the sauce: In a bowl, combine the sesame oil, soy sauce, and rice vinegar. 2 Cook the rice noodles: Bring a large saucepan of water to a boil, add the noodles, and use tongs to turn them so they are submerged. Cook for 2 minutes, or until they are tender but still have some bite (they will cook a little more once you add them to the skillet). Drain, rinse with cold water, and use scissors to snip the noodles several times to break them up into shorter lengths. 3 Scramble the eggs: In a small bowl whisk together the eggs. Heat the skillet or Dutch oven over medium heat. Add 1 tablespoon of the peanut or canola oil. Add the eggs and scramble them for 2 minutes, or until they form large, soft curds. Transfer them from the pan to a plate or bowl. 4 Cook the vegetables: Add 1 tablespoon of the remaining oil to the pan. When it is hot, add the ginger, garlic, carrots, jalapeño, onion, and salt. Cook, stirring constantly, for 2 minutes or until the vegetables start to soften. 5 Add the remaining ingredients: Sprinkle the vegetable mixture with the remaining 1 tablespoon peanut or canola oil. When it is hot, add the ham, cabbage, scallions, red pepper, and curry powder to the pan. Cook, stirring constantly, for 1 minute. Add the shrimp and cook, stirring, for 3 more minutes or until the shrimp are bright pink and cooked through. 6 Add the noodles in batches: Add the eggs, the sauce mixture, and half the noodles to the pan. Toss for 1 minute. Add the remaining noodles and continue tossing for 1 minute more until they are thoroughly combined and the mixture is heated through. 7 Serve: Taste for seasoning and add more salt or soy sauce, if you like. Sprinkle with cilantro leaves and serve."));
        recipeRepository.save(recipe);

        recipe = new Recipe();
        categories = new HashSet<>();
        categories.add(category3);
        categories.add(category4);
        recipe.setCategories(categories);
        ingredients = new HashSet<>();
        ingredients.add(new Ingredient("olive oil, divided", new BigDecimal("3"), uomTablespoon, recipe));
        ingredients.add(new Ingredient("Panko breadcrumbs", new BigDecimal("0.75"), uomCup, recipe));
        ingredients.add(new Ingredient("coarsely chopped toasted almonds", new BigDecimal("0.25"), uomCup, recipe));
        ingredients.add(new Ingredient("salt, divided", new BigDecimal("0.5"), uomTeaspoon, recipe));
        ingredients.add(new Ingredient("medium shaped pasta, such as penne, medium shells, lumache, or fusilli", new BigDecimal("0.75"), uomPound, recipe));
        ingredients.add(new Ingredient("garlic, minced", new BigDecimal("1"), uomClove, recipe));
        ingredients.add(new Ingredient("(12-ounce) package frozen artichoke hearts, partially thawed if time allows", new BigDecimal("1"), uomPiece, recipe));
        ingredients.add(new Ingredient("baby spinach", new BigDecimal("3"), uomOunce, recipe));
        ingredients.add(new Ingredient("finely grated lemon zest", new BigDecimal("2"), uomTeaspoon, recipe));
        ingredients.add(new Ingredient("grated Parmesan", new BigDecimal("0.33"), uomCup, recipe));
        ingredients.add(new Ingredient("lemon juice", new BigDecimal("2"), uomTablespoon, recipe));
        ingredients.add(new Ingredient("ricotta cheese", new BigDecimal("0.75"), uomCup, recipe));
        ingredients.add(new Ingredient("chopped fresh parsley, to garnish", new BigDecimal("2"), uomTablespoon, recipe));
        recipe.setIngredients(ingredients);
        recipe.setCookTime(60 * 20);
        recipe.setPrepTime(60 * 10);
        recipe.setServings(4);
        recipe.setDescription("Pasta with Spinach, Artichokes and Ricotta");
        recipe.setDirections("Pasta with Spinach, Artichokes and Ricotta");
        recipe.setDifficulty(Difficulty.MODERATE);
        recipe.setUrl("https://www.simplyrecipes.com/recipes/pasta_with_spinach_artichokes_and_ricotta/");
        recipe.setSource("https://www.simplyrecipes.com");
        recipe.setNotes(new Notes(recipe, "1 Make the breadcrumb topping:  In a small skillet over medium heat, heat 1 tablespoon of the oil. Add the breadcrumbs and chopped almonds, and cook, stirring, for 2 to 3 minutes, or until brown and crisp. Add 1/4 teaspoon salt, or to taste. Set aside. 2 Cook the pasta: Bring a large pot of salted water to a boil. Add the pasta and cook for 8 to 10 minutes, or until al dente. (Check the package for recommended cooking time and cook one minute less.) Scoop out and set aside 1 cup of the pasta cooking water. Drain the pasta in a colander. 3 While the pasta cooks, cook the artichokes: In a large skillet over medium-high heat, heat the remaining 2 tablespoons of oil. Add the garlic and cook, stirring, for 30 seconds. Add the artichokes and stir and cook for 3 to 4 minutes, or until lightly browned. Stir in the spinach and cook for another 30 seconds, or until it has wilted very slightly. Stir in the lemon zest and 1/4 teaspoon salt. Taste and add additional salt if needed. 4 Toss the pasta with the artichokes: Add the drained pasta to the skillet with the artichokes. Add the Parmesan and lemon juice, and toss to combine. Dollop the ricotta over the pasta by the spoonful. Toss together. If the pasta seems dry, add a little of the pasta cooking water. Taste and add salt and freshly ground black pepper. 5 Serve the pasta: Divide the pasta among 4 bowls and top with the toasted breadcrumbs and almonds. Sprinkle with parsley and serve."));
        recipeRepository.save(recipe);
    }
}
