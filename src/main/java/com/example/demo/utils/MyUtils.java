package com.example.demo.utils;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Component
public class MyUtils {
	
	private static MessageSource messageSource;
	
	public MyUtils(MessageSource messageSource) {
		MyUtils.messageSource = messageSource;
	}
	
	public static String getMessage(String key, Object... args) {
		return messageSource.getMessage(key, args, LocaleContextHolder.getLocale());
	}
	
	public static void flash(RedirectAttributes redirectAttributes, 
			String flashKind, String flashMessageCode) {
		redirectAttributes.addFlashAttribute("flashMessage", getMessage(flashMessageCode));
		redirectAttributes.addFlashAttribute("flashKind", flashKind);		
	}
	

}
