package com.doskoch.fpm.web5.util.validator;

import java.util.HashMap;
import java.util.Map;

public class AddProductFormValidator implements FormValidator {

    private static FormValidator instance;

    private AddProductFormValidator() {
    }

    public static FormValidator getInstance() {
        if (instance == null) {
            instance = new AddProductFormValidator();
        }
        return instance;
    }

    @Override
    public Map<String, String> validateForm(Map<String, String[]> data) {

        var validationResult = new HashMap<String, String>();

        if (data.get("brand")[0] == null) {
            validationResult.put("brand", "null_str");
        }

        return validationResult;
    }
}
