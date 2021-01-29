package com.videoclub.videoclubNestor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AcortadorController {

	@GetMapping("/acortador")
	public String acortador() {
		return "acortador";
	}
}
