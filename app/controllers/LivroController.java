package controllers;
import play.mvc.*;
import models.Livro;
import models.Usuario;
import models.Anuncio;
import views.html.*;
import java.util.*;

import play.data.Form;
import play.data.FormFactory;
import javax.inject.Inject;

import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;

public class LivroController extends Controller{
    private ArrayList<Livro> livros = new ArrayList<>();
    //private ArrayList<Anuncio> anuncios = new ArrayList<>();
    //private List<Anuncio> anuncios = Anuncio.find.all();

    @Inject
    FormFactory formFactory;

    private List<Anuncio> getAnunciosUsuario(String email) {
        //List<Anuncio> anunciosAux = this.todosAnuncios();
        List<Anuncio> anunciosAux = Anuncio.find.all();
        List<Anuncio> anunciosUsuario = new ArrayList<>();

        for(int i = 0; i < anunciosAux.size(); i++){
            System.out.println(anunciosAux.get(i).getLivro());
            if(anunciosAux.get(i).getDoador().equals(email)){
                System.out.println(anunciosAux.get(i));
                anunciosUsuario.add(anunciosAux.get(i));
            }
        }

        return anunciosUsuario;
    }
    
	public Result index() {
		String email = session("email");
		if (email == null) {
			return redirect("/login");
        }
        
        //List<Anuncio> anunciosUsuario = getAnunciosUsuario(email);
        List<Anuncio> anunciosUsuario = new ArrayList<Anuncio>();
        //Usuario usuario = Usuario.buscarPorEmail(email);
        Usuario usuario = Usuario.find.byId(email);
        if(usuario == null){
            return ok("Erro");
        }
        if(usuario.anuncioIsEmpty()){
            return ok("O usuário não tem anúncios cadastrados");
        }else{
            anunciosUsuario = Usuario.find.byId(email).getAnunciosUsuario();
            return ok(views.html.index.render(anunciosUsuario));
        }      
        
	}
    
    public Result inicio(){
        ArrayList<Livro> livros = this.todosLivros();
        System.out.println(session().get("email"));
        return ok(homeDoele.render(livros));
    }

    public Result livros(){
        ArrayList<Livro> livros = this.todosLivros();
        
        return ok(livrosDisponiveis.render(livros));
    }

    public Result cadastroLivro(){
        String email = session("email");
        //Usuario usuario = Usuario.find.byId(email);

		if (email == null) {
			return redirect("/login");
        }else{
            System.out.println(email);
            //System.out.println(usuario);
        }

        return ok(cadastroLivro.render());
    }

    public Result salvarCadastro(){
        String email = session("email");
        Usuario usuario = Usuario.find.byId(email);

		if (email == null || usuario == null) {
			return redirect("/login");
        }else{
            System.out.println(email);
            System.out.println(usuario); 
        }

        Random valorQualquer = new Random();
        
        Map<String, String[]> r =
          request().body().asFormUrlEncoded();

        String idAnuncio = "d"+"+!"+valorQualquer.nextInt();
        String estado = r.get("estado")[0];
        String descricao = r.get("descricao")[0];
        int quantidade = Integer.parseInt(r.get("quantidade")[0]);

        String titulo = r.get("titulo")[0];
        String autor = r.get("autor")[0];
        String isbn = r.get("isbn")[0];
        int ano = Integer.parseInt(r.get("ano")[0]);
        String thumLink = r.get("thumb")[0];
        
        //String email = session("email");
        //Usuario usuario = Usuario.buscarPorEmail(email);
       
        ArrayList<Livro> livros = this.todosLivros();
        boolean existe = false;
        Livro livroExiste = new Livro();

        for(int i = 0; i < livros.size(); i++){
            System.out.println("Buscando Livro");
            // System.out.println(livros.get(i).getIsbn()+"= =>"+isbn);
            if(livros.get(i).getIsbn().equals(isbn)){
                existe = true;
                livroExiste = livros.get(i);
                break;
            }
        }

        if(existe){
            Anuncio anuncio = new Anuncio(usuario, idAnuncio, livroExiste.getIsbn(), quantidade, estado, descricao);
            //this.add(anuncio);
            anuncio.save();
            //anuncio.setLivro(livroExiste);
            usuario.addAnuncio(anuncio);
        }else{
            Livro livro = new Livro(isbn, titulo, autor, ano, thumLink);
            this.add(livro);       
            System.out.println("Livro add:" + livro.getTitulo() + livro.getIsbn());
            
            Anuncio anuncio = new Anuncio(idAnuncio,quantidade,estado,descricao);
/*          anuncio.setIdAnuncio(idAnuncio);
            anuncio.setQuantidade(quantidade);
            anuncio.setEstadoLivro(estado);
            anuncio.setDescricaoAnuncio(descricao); */
            anuncio.setLivro(livro.getIsbn());
            anuncio.setDoador(usuario);
            anuncio.save();
            System.out.println("Anuncio livro add:" + anuncio.getLivro() + "livro: " + livro.getIsbn());
            usuario.addAnuncio(anuncio);
        }

        return redirect(routes.LivroController.inicio());
    }

     public Result verLivro(String isbn){
        Livro livro = this.buscarPorISBN(isbn);
        if(livro == null){
            return notFound("ERRO - LIVRO NAO ENCONTRADO");
        }
        ArrayList<Anuncio> livroISBN = new ArrayList<Anuncio>();
        ArrayList<Anuncio> anunciosISBN = new ArrayList<Anuncio>();
        List<Anuncio> anuncios = Anuncio.find.all();
        System.out.println(anuncios.toString());
        //ArrayList<Anuncio> anuncios = this.todosAnuncios();

/*         List<Anuncio> anunciosISBNaux = Anuncio.find.query()
        .select("*")
        .where()
        .filterMany("livro").eq("isbn", isbn)
        .findList(); */
        anunciosISBN.addAll(Anuncio.find.query()
        .select("*")
        .where()
        .eq("livro", isbn)
        .findList());
/*         for(int i = 0; i < anuncios.size(); i++){
            if(anuncios.get(i).getLivro().getIsbn().equals(isbn)){
                anunciosISBN.add(anuncios.get(i));
            }
        } */

        System.out.println("ori: "+anunciosISBN);
        //System.out.println("aux: "+anunciosISBNaux);
        return ok(paginaLivro.render(anunciosISBN, livro));
    }


    public Result verAnuncio(String id){
        Anuncio anuncio = this.buscarPorID(id);
        if(anuncio == null){
            return notFound("ERRO - ANUNCIO NAO ENCONTRADO");
        }
        System.out.println("anuncio: " +anuncio.getIdAnuncio());
        Livro livro = this.buscarPorISBN(anuncio.getLivro());
        //System.out.println("anuncio: " +anuncio.getLivro().getIsbn());
        return ok(paginaAnuncio.render(anuncio, livro));
    }
 
    public ArrayList<Livro> todosLivros(){
        return livros;
    }

    public Livro buscarPorISBN(String isbn){
        for (Livro livro : livros) {
			if(isbn.equals(livro.getIsbn())){
				return livro;
			}
        }
        return null; 
	}
	
	public void add(Livro livro){
        livros.add(livro);
    }    

/*     public ArrayList<Anuncio> todosAnuncios(){
        return anuncios;
	} */

/*     public Anuncio buscarPorID(String id){
        for (Anuncio anuncio : anuncios) {
			if(id.equals(anuncio.getIdAnuncio())){
				return anuncio;
			}
        }
        return null; 
    } */
    public Anuncio buscarPorID(String id){
        Anuncio anuncio = Anuncio.find.query()
        .select("*")
//        .fetch("*")
        .where()
        .idEq(id)
        .findOne();
        return anuncio; 
    }    
	
/* 	public void add(Anuncio anuncio){
        anuncio.save();
    } */
}