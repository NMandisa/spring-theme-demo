package za.co.langa.exception;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Noxolo.Mkhungo
 */
@ControllerAdvice(annotations = {Controller.class})
public class GlobalExceptionHandler {
    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ModelAndView handleNullPointerException(Exception ex) {
        ModelAndView model = new ModelAndView("errors/500");
        model.addObject("cause", ex.getCause());
        model.addObject("message", ex.getLocalizedMessage());
        model.addObject("trace", ex.getStackTrace());
        return model;
    }
}
