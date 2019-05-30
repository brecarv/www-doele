package models;
import java.util.*;
import javax.persistence.*;
import io.ebean.*;
import play.data.format.*;
import play.data.validation.*;

@Entity
@Table(name = "anuncios")
public class Anuncio extends Model{
	@Id
	//@ManyToOne(optional=false,fetch = FetchType.LAZY)
	private String idAnuncio;

	@Constraints.Required
	//private Livro livro;
	private String livro;

	//@ManyToOne(cascade = CascadeType.ALL)
	@Constraints.Required
	@ManyToOne(optional=false,fetch = FetchType.LAZY)
	private Usuario doador;
	
	@Constraints.Required
	private int quantidade;

	@Constraints.Required
	private String estadoLivro;

	@Constraints.Required
	private String descricaoAnuncio;

	@Constraints.Required
	private boolean disponivel;

//	private List<Usuario> usuariosInteressados = new ArrayList<Usuario>();
	
	public Anuncio() {
	}

	public Anuncio(String idAnuncio, int quantidade, String estadoLivro,
	String descricaoAnuncio) {
		this.idAnuncio = idAnuncio;
		this.quantidade = quantidade;
		this.estadoLivro = estadoLivro;
		this.descricaoAnuncio = descricaoAnuncio;
		this.disponivel = true;
	}

	public Anuncio(Usuario doador, String idAnuncio, String livro,  int quantidade, String estadoLivro,
			String descricaoAnuncio) {
		this.doador = doador;
		this.idAnuncio = idAnuncio;
		this.livro = livro;
		this.quantidade = quantidade;
		this.estadoLivro = estadoLivro;
		this.descricaoAnuncio = descricaoAnuncio;
		this.disponivel = true;
	}

	public String getIdAnuncio() {
		return idAnuncio;
	}

	public void setIdAnuncio(String idAnuncio) {
		this.idAnuncio = idAnuncio;
	}

/* 	public Livro getLivro() {
		return this.livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	} */

	public String getLivro() {
		return livro;
	}

	public void setLivro(String livro) {
		this.livro = livro;
	}

	public void setDoador(Usuario doador) {
		this.doador = doador;
	}

	public Usuario getDoador() {
		return doador;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getEstadoLivro() {
		return estadoLivro;
	}

	public void setEstadoLivro(String estadoLivro) {
		this.estadoLivro = estadoLivro;
	}
	
	public String getDescricaoAnuncio() {
		return descricaoAnuncio;
	}
	
	public void setDescricaoAnuncio(String descricaoAnuncio) {
		this.descricaoAnuncio = descricaoAnuncio;
	}
	
	public boolean isDisponivel() {
		return disponivel;
	}
	
	private void setDisponibilade(boolean disponibilidade) {
		this.disponivel = disponibilidade;
	}
	
	public void doarLivro() {
		if(isDisponivel())
			this.setQuantidade(this.quantidade--);
	}

	public static final Finder<String, Anuncio> find = new Finder<>(Anuncio.class);

}
