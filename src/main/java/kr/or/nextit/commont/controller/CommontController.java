package kr.or.nextit.commont.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.nextit.common.file.service.FileItemService;
import kr.or.nextit.commont.service.CommontService;

@Controller
@RequestMapping("/commont")
public class CommontController {
	
	@Autowired
	CommontService commontService;
	
	@Autowired
	FileItemService fileItemService;
	
	

}
