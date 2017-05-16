package br.com.caelum.projetocdc;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import br.com.caelum.projetocdc.Livro;

public class ValidadorLivroDois {

	Map<String, String> erros = new HashMap<>();
	
	public Map<String, String> getErros() {
		return erros;
	}
	
	public boolean livroNaoEhValido(Livro livro){
		boolean naoEhValido = false;
		 
		if(isTituloVazio(livro.getTitulo())){
			//request.setAttribute("erroTitulo", "Campo obrigatório");
			erros.put("erroTitulo", "Campo obrigatório");
			naoEhValido = true;
		}
		
		if(isSubTituloVazio(livro.getSubTitulo())){
			//request.setAttribute("erroSubTitulo", "Campo obrigatório");
			erros.put("erroSubTitulo", "Campo obrigatório");
 			naoEhValido = true;
		}
		
		if(isPrecoIgualAZero(livro.getPreco())){
			//request.setAttribute("erroPreco", "Preço deve ser diferente de zero");
			erros.put("erroPreco", "Preço deve ser diferente de zero");
			naoEhValido = true;
		}
		
		if(isDataUltimaAtualizacaoNull(livro.getDataUltimaAtualizacao())){
			//request.setAttribute("erroDataUltimaAtualizacao", "Data em formato dd/MM/aaaa");
			erros.put("erroDataUltimaAtualizacao", "Data em formato dd/MM/aaaa");
			naoEhValido = true;
		}
		
		if(isDataLancamentoNull(livro.getDataLancamento())){
			//request.setAttribute("erroDataLancamento", "Data em formato dd/MM/aaaa");
			erros.put("erroDataLancamento", "Data em formato dd/MM/aaaa");
			naoEhValido = true;
		}
		
		return naoEhValido;
	}

	private boolean isDataLancamentoNull(Calendar dataLancamento) {
		if(dataLancamento == null)
			return true;
		return false;
	}

	private boolean isDataUltimaAtualizacaoNull(Calendar dataUltimaAtualizacao) {
		if(dataUltimaAtualizacao == null)
			return true;
		return false;
	}

	private boolean isPrecoIgualAZero(double preco) {
		if(preco <= 0)
			return true;
		return false;
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
