package br.com.orangetalents.validationerror;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NO_CONTENT)
public class ErroValidacao {
	
	private String campo;
	private String erro;

public ErroValidacao(String campo, String erro) {
		
		this.campo = campo;
		this.erro = erro;
	}

	public String getCampo() {
		return campo;
	}

	public String getErro() {
		return erro;
	}
	
	
	
	
	
}

