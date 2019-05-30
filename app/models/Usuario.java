package models;
import java.util.*;
import javax.persistence.*;
import io.ebean.*;
import play.data.format.*;
import play.data.validation.*;



@Entity
@Table(name = "usuarios")
public class Usuario extends Model{
	@Constraints.Required
	private String cpf;

	@Constraints.Required
	private String nome;

	@Id
	@Constraints.Required
	private String email;

	@Constraints.Required
	private String senha;
	
	//@OneToMany(mappedBy="doador", cascade=CascadeType.ALL)
	//@ManyToOne()
	//@OneToMany(cascade = CascadeType.ALL)
	@OneToMany(mappedBy="doador",cascade = CascadeType.ALL)
	private List<Anuncio> anunciosCadastrados;
	
	public Usuario() {
		this.anunciosCadastrados = new ArrayList<Anuncio>();
	}
	
/* 	public Usuario(String cpf, String nome, String email, String senha) {
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	} */

	public Usuario(String cpf, String nome, String email, String senha) {
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.anunciosCadastrados = new ArrayList<Anuncio>();
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	private String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

 	public void addAnuncio(Anuncio anuncio){
        anunciosCadastrados.add(anuncio);
	}
	
/* 	public void addAnuncio(String anuncio){
        anunciosCadastrados.add(anuncio);
	} */

	public boolean anuncioIsEmpty(){
		return anunciosCadastrados.isEmpty();
	}

	public List<Anuncio> getAnunciosUsuario(){
		return this.anunciosCadastrados;
	}

	public static boolean autenticaUsuario(Usuario user, String senha){
		if(senha.equals(user.getSenha())){
			return true;
		}
        return false; 
	}

	public static final Finder<String, Usuario> find = new Finder<>(Usuario.class);


/* 	private static ArrayList<Usuario> usuarios;

	static {
		usuarios = new ArrayList<>();
		Usuario admin = new Usuario("123", "Administrador", "a@a", "a");
		usuarios.add(admin);
	}
	
	public static ArrayList<Usuario> todosUsuarios(){
        return usuarios;
	}
	
	public static Usuario buscarPorEmail(String email){
		if(email == null)
			return null;
        else{
			for (Usuario usuario : usuarios) {
				if(email.equals(usuario.getEmail())){
					return usuario;
				}		
			}
			return null;
		}
	}
	
	public static void add(Usuario usuario){
        usuarios.add(usuario);
    } */
}
