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

    @Inject
    FormFactory formFactory;
    
    
	public Result perfil() {
		String email = session("email");
		if (email == null) {
			return redirect("/login");
        }
        
        List<Anuncio> anunciosUsuario = new ArrayList<Anuncio>();
        Usuario usuario = Usuario.find.byId(email);

        if(usuario == null){
            return ok("Erro");
        }

        anunciosUsuario.addAll(usuario.getAnunciosUsuario());
    
        return ok(perfil.render(usuario, anunciosUsuario));     
        
	}

}