package models;
import java.util.*;
import javax.persistence.*;
import io.ebean.*;
import play.data.format.*;
import play.data.validation.*;

@Entity
public class Doacao {

	private Usuario doador;
	private Usuario donatario;
	private Anuncio anuncio;
	@Id
	private String idDoacao;
	private boolean concluida;
	
	public Doacao () {
	}
	
	public Doacao (Usuario doador, Usuario donatario, Anuncio anuncio, String idDoacao) {
		super();
		this.doador = doador;
		this.donatario = donatario;
		this.anuncio = anuncio;
		this.idDoacao = idDoacao;
	}
	
	public Usuario getDoador() {
		return doador;
	}

	public void setDoador(Usuario doacao) {
		this.doador = doacao;
	}

	public Usuario getDoantario() {
		return donatario;
	}

	public void setDoantario(Usuario donatario) {
		this.donatario = donatario;
	}

	public Anuncio getAnuncio() {
		return anuncio;
	}

	public void setAnuncio(Anuncio anuncio) {
		this.anuncio = anuncio;
	}

	public String getIdDoacao() {
		return idDoacao;
	}

	public void setIdDoacao(String idDoacao) {
		this.idDoacao = idDoacao;
	}

	public boolean isConcluida() {
		return concluida;
	}

	public void setConcluida(boolean concluida) {
		this.concluida = concluida;
	}
	
	public static final Finder<Long, Doacao> find = new Finder<>(Doacao.class);
}
