package controllers;

import java.util.Map;

import models.Usuario;
import play.mvc.*;

public class LoginController extends Controller {
 
    public Result login() {
    	return ok(views.html.login.render());
    }
    
    public Result dados_login() {
    	Map<String, String[]> r = request().body().asFormUrlEncoded();
    	String email = r.get("email")[0];
		String senha = r.get("senha")[0];
		

		if (Usuario.find.byId(email) == null){
			return ok("Erro - email");
			//return redirect("/registro");
		}
		else if(Usuario.autenticaUsuario(Usuario.find.byId(email), senha)){
			session("email", email);
    		return redirect("/");
		}

    	return redirect("/login");
    }
    
    public Result logout() {
		session().clear();
		flash("logout", "Deslogado");
    	return redirect("/login");
    }

}
