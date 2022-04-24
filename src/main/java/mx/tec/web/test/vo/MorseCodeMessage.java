package mx.tec.web.test.vo;

import javax.validation.constraints.NotBlank;

public class MorseCodeMessage {
	@NotBlank(message = "Name is mandatory")
	private String original;
	private String translation;	
	
	public MorseCodeMessage() {
	}
	
	public MorseCodeMessage(String original, String translation) {
		this.original = original;
		this.translation = translation;
	}

	public String getOriginal() {
		return original;
	}

	public void setOriginal(String original) {
		this.original = original;
	}

	public String getTranslation() {
		return translation;
	}

	public void setTranslation(String translation) {
		this.translation = translation;
	}
}
