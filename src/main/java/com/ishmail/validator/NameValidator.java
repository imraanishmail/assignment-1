package com.ishmail.validator;

import com.ishmail.GameManagementService;
import com.ishmail.model.Game;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("nameValidator")
public class NameValidator implements Validator<String> {

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, String s) throws ValidatorException {

        // Iterate through the list to check if the name of the game exists and sets it to true
        boolean found = false;
        for(Game g: GameManagementService.games) {
            if(g.getName().equals(s)) {
                found = true;
                break;
            }
        }
        // If game not found in list (false) will throw exception
        if(!found) {
            throw new ValidatorException(new FacesMessage("Game title must match a game in the inventory: " + (GameManagementService.games.toString())));
        }
    }
}