package ua.avk.shopbuilder.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.ErrorPage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;

/**
 * @author Alexander Kononenko
 * @version 1.0.0
 */
@Controller
public class ExceptionController implements EmbeddedServletContainerCustomizer {
	private static final Logger logger = (Logger) LoggerFactory.getLogger(ExceptionController.class);


	@Override
	public void customize(ConfigurableEmbeddedServletContainer container) {

		container.addErrorPages(new ErrorPage("/403"));
	}



    /**
     * for 403 access denied page
     */
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String accessDenied(HttpServletResponse res, HttpServletRequest req, Principal user) {

		logger.error("1 USER NAME: " + user.getName()
				+ "; \nHttpServletRequest: " + req.getServletPath()
				+ "; \nHttpServletResponse: " + res.getStatus() + "; "
		);
		/*
		ModelAndView model = new ModelAndView();

		if (user != null) {
			model.addObject("msg", "Hi " + user.getName()
			+ ", you do not have permission to access this page!");
		} else {
			model.addObject("msg",
			"You do not have permission to access this page!");
		}

		model.setViewName("/403");

		return model;
        */

		return "/error/403";
	}


}
