package com.velogresttemplate.adapter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.velogresttemplate.port.TranslatorPort;

@RestController
@RequestMapping("/api/v1")
public class TranslatorApi {

	private final TranslatorPort translatorPort;

	public TranslatorApi(TranslatorPort translatorPort) {
		this.translatorPort = translatorPort;
	}

	@GetMapping("/translate")
	public ResponseEntity<?> translate(
		@RequestParam(name = "text") String text,
		@RequestParam(name = "source", required = false, defaultValue = "ko") String source,
		@RequestParam(name = "target", required = false, defaultValue = "en") String target
	) {
		return ResponseEntity.status(HttpStatus.OK)
			.body(translatorPort.translate(source, target, text));
	}
}