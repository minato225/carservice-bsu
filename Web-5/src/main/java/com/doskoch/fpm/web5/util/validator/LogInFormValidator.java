package com.doskoch.fpm.web5.util.validator;

import java.util.HashMap;
import java.util.Map;

import static com.doskoch.fpm.web5.controller.navigation.PageDataHolder.PARAMETER_EMAIL;
import static com.doskoch.fpm.web5.controller.navigation.PageDataHolder.PARAMETER_PASSWORD;
import static com.doskoch.fpm.web5.util.locale.LocalisedMessageKey.MESSAGE_EMAIL_WRONG;
import static com.doskoch.fpm.web5.util.locale.LocalisedMessageKey.MESSAGE_PASSWORD_WRONG;
import static com.doskoch.fpm.web5.util.validator.ValidatorPatternHolder.EMAIL_PATTERN;
import static com.doskoch.fpm.web5.util.validator.ValidatorPatternHolder.PASSWORD_PATTERN;

public class LogInFormValidator implements FormValidator {

    private static FormValidator instance;

    private LogInFormValidator(){}

    public static FormValidator getInstance() {
        if(instance == null){
            instance = new LogInFormValidator();
        }
        return instance;
    }

    @Override
    public Map<String, String> validateForm(Map<String, String[]> data) {

        Map<String, String> validationResult = new HashMap<>();

        if(!data.get(PARAMETER_EMAIL)[0].matches(EMAIL_PATTERN)){
            validationResult.put(PARAMETER_EMAIL, MESSAGE_EMAIL_WRONG);
        }
        if(!data.get(PARAMETER_PASSWORD)[0].matches(PASSWORD_PATTERN)){
            validationResult.put(PARAMETER_PASSWORD, MESSAGE_PASSWORD_WRONG);
        }

        return validationResult;
    }
}
