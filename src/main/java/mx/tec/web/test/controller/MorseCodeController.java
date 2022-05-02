package mx.tec.web.test.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import mx.tec.web.test.service.MorseCodeService;
import mx.tec.web.test.vo.MorseCodeMessage;

@RestController
public class MorseCodeController {
	@Autowired
	private MorseCodeService morseCodeService;
	
	@PostMapping("/morse-code")
	public ResponseEntity<MorseCodeMessage> translate(@Valid @RequestBody MorseCodeMessage newMessage) {
		MorseCodeMessage translatedMessage = morseCodeService.translate(newMessage);		
		return new ResponseEntity<>(translatedMessage, HttpStatus.OK);
	}
}
