package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        try {
            Sandwich sandwich = new Sandwich();
            JSONObject sandwich_json = new JSONObject(json);
            // name object
            {
                JSONObject name = sandwich_json.getJSONObject("name");
                sandwich.setMainName(name.getString("mainName"));
                List<String> alias = new ArrayList<>();
                JSONArray alias_json = name.getJSONArray("alsoKnownAs");
                for (int count = 0; count < alias_json.length(); count++) {
                    alias.add(alias_json.getString(count));
                }
                sandwich.setAlsoKnownAs(alias);
            }
            // placeOfOrigin
            {
                sandwich.setPlaceOfOrigin(sandwich_json.getString("placeOfOrigin"));
            }
            // description
            {
                sandwich.setDescription(sandwich_json.getString("description"));
            }
            // placeOfOrigin
            {
                sandwich.setImage(sandwich_json.getString("image"));
            }
            // ingredients
            {
                JSONArray ingredients_json = sandwich_json.getJSONArray("ingredients");
                List<String> ingredients = new ArrayList<>();
                for (int count = 0; count < ingredients_json.length(); ++count) {
                    ingredients.add(ingredients_json.getString(count));
                }
                sandwich.setIngredients(ingredients);
            }
            return sandwich;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
