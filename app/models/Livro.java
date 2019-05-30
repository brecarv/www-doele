package models;
import java.util.*;
import javax.persistence.*;
import io.ebean.*;
import play.data.format.*;
import play.data.validation.*;

@Entity
@Table(name = "livros")
public class Livro extends Model{
	@Id
	private String isbn;

	@Constraints.Required
	private String titulo;

	@Constraints.Required
	private String autor;

	@Constraints.Required
	private int ano;

	@Constraints.Required
	private String thumbCover;
	 
	public Livro(){
	}
	 
	public Livro(String isbn, String titulo, String autor, int ano, String thumbCover) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
		this.ano = ano;
		this.thumbCover = thumbCover;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getThumbCover(){
		return thumbCover;
	}
	
	public void setThumbCover(String thumbCover){
		this.thumbCover = thumbCover;
	}

	public static final Finder<String, Livro> find = new Finder<>(Livro.class);
}
