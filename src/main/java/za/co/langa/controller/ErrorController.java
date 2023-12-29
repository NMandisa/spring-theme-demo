package za.co.langa.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Noxolo.Mkhungo
 */
@Controller
public class ErrorController {

    //error this request mapping is referencing the one on the web.xml
    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public ModelAndView renderErrorPage(HttpServletRequest httpRequest) {
        ModelAndView errorPage = new ModelAndView("errors/error");
        String errorMessage = "";
        int httpErrorCode = getErrorCode(httpRequest);
        switch (httpErrorCode) {
            case 400: {
                errorMessage = "400. Bad Request";
                break;
            }
            case 401: {
                errorMessage = "401. Unauthorized";
                break;
            }
            case 404: {
                errorMessage = "404. Resource not found";
                break;
            }
            case 500: {
                errorMessage = "500. Internal Server Error";
                break;
            }
        }
        errorPage.addObject("errorMsg", errorMessage);
        return errorPage;
    }

    private int getErrorCode(HttpServletRequest httpRequest) {
        return (Integer) httpRequest.getAttribute("jakarta.servlet.error.status_code");
    }
}
