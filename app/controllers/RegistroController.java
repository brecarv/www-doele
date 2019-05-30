package controllers;

import java.util.Map;

import models.Usuario;
import play.mvc.*;

public class RegistroController extends Controller {
 
    public Result registro() {
    	return ok(views.html.registro.render());
    }
    
    public Result dados_registro() {
		Map<String, String[]> r = request().body().asFormUrlEncoded();
		String nome = r.get("nome")[0];
		String cpf = r.get("cpf")[0];
    String email = r.get("email")[0];
		String senha = r.get("senha")[0];
		
		Usuario novoUsuario = new Usuario(cpf, nome, email, senha);
		//Usuario.add(novoUsuario);
		novoUsuario.save();
		flash("registrado", "Registro Feito");
    	return redirect("/login");
    }
    
}
