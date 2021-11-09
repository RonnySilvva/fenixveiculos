package br.com.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class NotificationsUtils {
	
	public static void saveMessage() {
        FacesContext context = FacesContext.getCurrentInstance();
         
        context.addMessage(null, new FacesMessage("Successful",  "Foi gravado com sucesso ") );
    }

    public static void editMessage() {
        FacesContext context = FacesContext.getCurrentInstance();
         
        context.addMessage(null, new FacesMessage("Successful",  "Foi modificado com sucesso ") );
    }
    
}
