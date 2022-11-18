package com.portal.server.dao;

import com.portal.server.entity.Recipe;
import org.springframework.stereotype.Component;

@Component
public interface RecipeDAO {
    void saveRecipe(Recipe recipe);
    Recipe getRecipeById(Long id);
}
