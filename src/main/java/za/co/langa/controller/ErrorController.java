package za.co.langa.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Noxolo.Mkhungo
 */
@Controller
public class ErrorController {
    //reference : https://www.baeldung.com/spring-boot-custom-error-page
    //error this request mapping is referencing the one on the web.xml
    @GetMapping(value = "/error")
    public ModelAndView renderErrorPage(HttpServletRequest httpRequest) {
        ModelAndView errorPage = new ModelAndView("errors/error");
        String errorMessage;
        int httpErrorCode = getErrorCode(httpRequest);
        switch (httpErrorCode) {
            case 400 -> errorMessage = "Bad Request";
            case 401 -> errorMessage = "Unauthorized";
            case 404 -> errorMessage = "Resource not found";
            default -> errorMessage = "Ops something went wrong...";
        }
        errorPage.addObject("errorCode", httpErrorCode);
        errorPage.addObject("message", errorMessage);
        return errorPage;
    }
    private int getErrorCode(HttpServletRequest httpRequest) {
        return (Integer) httpRequest.getAttribute("jakarta.servlet.error.status_code");
    }
}
