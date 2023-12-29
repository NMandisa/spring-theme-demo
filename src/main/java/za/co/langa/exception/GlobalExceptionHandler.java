package za.co.langa.exception;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Noxolo.Mkhungo
 */
@ControllerAdvice(annotations = {Controller.class})
public class GlobalExceptionHandler {
    @ExceptionHandler(NullPointerException.class)
    public ModelAndView handleNullPointerException(Exception ex) {
        ModelAndView model = new ModelAndView("errors/500");
        model.addObject("exception", ex);
        return model;
    }
}
