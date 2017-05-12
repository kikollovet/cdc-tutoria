package br.com.caelum.projetocdc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

public class ValidadorLivro {

	public boolean validaDadosLivro(String titulo, String subTitulo, String precoTexto
			, String dataUltimaAtualizacaoTexto, String dataLancamentoTexto, HttpServletRequest request){
		boolean naoEhValido = false;
		
		if(isTituloVazio(titulo)){
			request.setAttribute("erroTitulo", "Campo obrigatório");
			naoEhValido = true;
		}
		if(isSubTituloVazio(subTitulo)){
			request.setAttribute("erroSubTitulo", "Campo obrigatório");
			naoEhValido = true;
		}
		if(isPrecoCaracter(precoTexto)){
			request.setAttribute("erroPreco", "Campo deve ser preenchido com número");
			naoEhValido = true;
		}
		if(isPrecoIgualZero(precoTexto)){
			request.setAttribute("erroPreco", "Preço deve ser diferente de zero");
			naoEhValido = true;
		}
		if(isDataUltimaAtualizacaoInvalida(dataUltimaAtualizacaoTexto)){
			request.setAttribute("erroDataUltimaAtualizacao", "Data em formato dd/MM/aaaa");
			naoEhValido = true;
		}
		if(isDataLancamentoInvalida(dataLancamentoTexto)){
			request.setAttribute("erroDataLancamento", "Data em formato dd/MM/aaaa");
			naoEhValido = true;
		}
		return naoEhValido;
	}

	private boolean isPrecoIgualZero(String precoTexto) {
		double preco = Double.parseDouble(precoTexto);
		if(preco == 0)
			return true;
		return false;
	}

	private boolean isDataLancamentoInvalida(String dataLancamentoTexto) {
		Calendar dataLancamento = null;
		
		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy")
			.parse(dataLancamentoTexto);
			dataLancamento = Calendar.getInstance();
			dataLancamento.setTime(date);
			return false;
		} catch (ParseException e) {
			return true;
		}
	}

	private boolean isDataUltimaAtualizacaoInvalida(String dataUltimaAtualizacaoTexto) {
		Calendar dataUltimaAtualizacao = null;
		
		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy")
			.parse(dataUltimaAtualizacaoTexto);
			dataUltimaAtualizacao = Calendar.getInstance();
			dataUltimaAtualizacao.setTime(date);
			return false;
		} catch (ParseException e) {
			return true;
		}
	}

	private boolean isPrecoCaracter(String precoTexto) {
		try {
			Double.parseDouble(precoTexto);
			return false;
		} catch (NumberFormatException e) {
			return true;
		}
	}

	private boolean isSubTituloVazio(String subTitulo) {
		if(subTitulo.isEmpty())
			return true;
		return false;
	}

	private boolean isTituloVazio(String titulo) {
		if(titulo.isEmpty())
			return true;
		return false;
	}
}
