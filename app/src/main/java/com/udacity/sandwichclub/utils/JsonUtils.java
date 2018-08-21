package com.udacity.sandwichclub.utils;

import android.util.Log;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {
    private static final String TAG="JsonUtils";

    public static Sandwich parseSandwichJson(String json) {
        Sandwich sandwich = new Sandwich();

        try {

            //get root object from string value of json
            JSONObject root = new JSONObject(json);

            //parse main name and set it on sandwich object
            JSONObject name = root.getJSONObject("name");
            String mainName = name.getString("mainName");
            sandwich.setMainName(mainName);

            //parse alsoKnownAs and set it on sandwich object
            JSONArray alsoKnownAs = name.getJSONArray("alsoKnownAs");
            List<String> listOfAlsoKnownAs = new ArrayList<>();

            for(int i=0;i<alsoKnownAs.length();i++){
                String alsoKnownAsItem = alsoKnownAs.getString(i);
                listOfAlsoKnownAs.add(alsoKnownAsItem);
            }
            sandwich.setAlsoKnownAs(listOfAlsoKnownAs);
            //parse place of origin and set it on sandwich object
            String placeOfOrigin = root.getString("placeOfOrigin");
            sandwich.setPlaceOfOrigin(placeOfOrigin);

            //parse Description and set it on sandwich object
            String description = root.getString("description");
            sandwich.setDescription(description);

            //parse image value and set it on sandwich object
            String imageURL = root.getString("image");
            sandwich.setImage(imageURL);

            //parse ingredients  and set it on sandwich object
            JSONArray ingredients = root.getJSONArray("ingredients");
            List<String> listOfIngredients = new ArrayList<>();

            for(int i=0;i<ingredients.length();i++){
                String ingredientsItem = ingredients.getString(i);
                listOfIngredients.add(ingredientsItem);
            }
            sandwich.setIngredients(listOfIngredients);

        } catch (JSONException e) {
            Log.e(TAG, "Problem parsing the JSON data", e);
        }
        return sandwich;
    }
}
