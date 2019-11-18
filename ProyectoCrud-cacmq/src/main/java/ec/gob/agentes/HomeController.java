package ec.gob.agentes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.jboss.logging.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sun.org.apache.bcel.internal.generic.IFEQ;

import ec.gob.model.Operativo;
import ec.gob.service.IOperativoService;
import ec.gob.service.OperativoServiceJpa;
import ec.gob.util.Utileria;

@Controller
public class HomeController {
	
		
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String mostrarPrincipal() {
		
		return "home";
	}
		
	
	@RequestMapping(value = "/login" , method = RequestMethod.GET)
	public String mostrarLogin(){
		return "formlogin";
	}
	
	

	

}
