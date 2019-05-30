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

public class UsuarioController extends Controller{

    // HELP US TO CREATE A FORM - FORM BOOK IN THIS CASE
    @Inject
    FormFactory formFactory;
    
    
	public Result perfil() {
		String email = session("email");
		if (email == null) {
			return redirect("/login");
        }
        
        //List<Anuncio> anunciosUsuario = getAnunciosUsuario(email);
        List<Anuncio> anunciosUsuario = new ArrayList<Anuncio>();
        Usuario usuario = Usuario.find.byId(email);
        //Usuario user = new Usuario();
        //List<Usuario> usuarios = Usuario.find.query().select("*").findList();
        //List<Usuario> usuarios = Usuario.find.query().select("*").findList();

        if(usuario == null){
            return ok("Erro");
        }

        anunciosUsuario.addAll(usuario.getAnunciosUsuario());

        for (int i = 0; i < usuario.getAnunciosUsuario().size(); i++) {
            anunciosUsuario.add(usuario.getAnunciosUsuario().get(i));
        }
        System.out.println("AnuncioS:"+ anunciosUsuario.get(0).getLivro());
        //anunciosUsuario = Usuario.find.byId(email).find.query().select("*").where().idEq("anunciosCadastrados").findList();
        
        //.select("*").fetch("anunciosCadastrados").findList();
/*         for(int i = 0; i < usuarios.size(); i++){
            if(usuarios.get(i).getEmail().equals(email)){
                user = usuarios.get(i);
                break;
            }
        } */
    
        return ok(perfil.render(usuario, anunciosUsuario));     
        
	}

}