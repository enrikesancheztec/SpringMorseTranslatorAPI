package mx.tec.web.test.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import mx.tec.web.test.vo.MorseCodeMessage;

@Service
public class MorseCodeService {
	private Map<String, String> translationMap;
	
	public MorseCodeService() {
		translationMap = new HashMap<>();
		translationMap.put(" ", " ");
		translationMap.put("A", ".-");
		translationMap.put("B", "-...");
		translationMap.put("C", "-.-.");
		translationMap.put("D", "-..");
		translationMap.put("E", ".");
		translationMap.put("F", "..-.");
		translationMap.put("G", "--.");
		translationMap.put("H", "....");
		translationMap.put("I", "..");
		translationMap.put("J", ".---");
		translationMap.put("K", "-.-");
		translationMap.put("L", ".-..");
		translationMap.put("M", "--");
		translationMap.put("N", "-.");
		translationMap.put("O", "---");
		translationMap.put("P", ".--.");
		translationMap.put("Q", "--.-");
		translationMap.put("R", ".-.");
		translationMap.put("S", "...");
		translationMap.put("T", "-");
		translationMap.put("U", "..-");
		translationMap.put("V", "...-");
		translationMap.put("W", ".--");
		translationMap.put("X", "-..-");
		translationMap.put("Y", "-.--");
		translationMap.put("Z", "--..");
		translationMap.put("0", "-----");
		translationMap.put("1", ".----");
		translationMap.put("2", "..---");
		translationMap.put("3", "...--");
		translationMap.put("4", "....-");
		translationMap.put("5", ".....");
		translationMap.put("6", "-....");
		translationMap.put("7", "--...");
		translationMap.put("8", "---..");
		translationMap.put("9", "----.");
	}

	public MorseCodeMessage translate(MorseCodeMessage originalMessage) {
	    String translation = "";
	    
	    for (int i = 0; i < originalMessage.getOriginal().length(); i++) {
	    	String letter = String.valueOf(originalMessage.getOriginal().charAt(i));
	        String letterTranslation = translationMap.get(letter.toUpperCase());
	        if (null != letterTranslation) {
	            translation += letterTranslation + "/";
	        }
	    }
	    
	    if (translation.endsWith("/")) {
	        translation = translation.substring(0, translation.length() - 1);
	    }

	    MorseCodeMessage translatedMessage = new MorseCodeMessage(originalMessage.getOriginal().toUpperCase(), translation);		
		
		return translatedMessage;
	}
}
