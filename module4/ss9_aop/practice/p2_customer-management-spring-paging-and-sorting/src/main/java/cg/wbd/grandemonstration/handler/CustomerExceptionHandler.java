package cg.wbd.grandemonstration.handler;

import cg.wbd.grandemonstration.exception.DuplicateEmailException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class CustomerExceptionHandler {

    @ExceptionHandler(DuplicateEmailException.class)
    public ModelAndView showInputNotAcceptable() {
        return new ModelAndView("/customers/inputs-not-acceptable");
    }
}
