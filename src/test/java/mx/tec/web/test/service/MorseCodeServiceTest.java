package mx.tec.web.test.service;

import static org.junit.jupiter.api.Assertions.*;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import mx.tec.web.test.vo.MorseCodeMessage;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class MorseCodeServiceTest {
	@Resource
	private MorseCodeService morseService;
	
	@Test
	void givenValidMessageWhenTranslateThenValidTranslation() {
		// Given
		String originalMessage = "Buenos dias";
		String expectedOutput = "-.../..-/./-./---/.../ /-../../.-/...";
		MorseCodeMessage input = new MorseCodeMessage(originalMessage, "");		
		
		// When
		MorseCodeMessage output = morseService.translate(input);
				
		// Then
		assertEquals(originalMessage, output.getOriginal());
		assertEquals(expectedOutput, output.getTranslation());
	}
	
	@Test
	void givenEmptyMessageWhenTranslateThenEmptyTranslation() {
		// Given
		String originalMessage = "";
		String expectedOutput = "";
		MorseCodeMessage input = new MorseCodeMessage(originalMessage, "");		
		
		// When
		MorseCodeMessage output = morseService.translate(input);
				
		// Then
		assertEquals(originalMessage, output.getOriginal());
		assertEquals(expectedOutput, output.getTranslation());
	}
}
