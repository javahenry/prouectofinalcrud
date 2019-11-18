package ec.gob.agentes;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;

import org.aspectj.runtime.internal.PerObjectMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ec.gob.model.Operativo;
import ec.gob.model.Persona;
import ec.gob.service.IPersonaService;
@Controller
@RequestMapping("Personas")
public class PersonaController {
	@Autowired 
	private IPersonaService servicePesona;
	@GetMapping("index")
	public String mostrarIndex(Model model) {
		List<Persona> lista= servicePesona.buscarTodas();
		model.addAttribute("persona",lista);
		return "persona/listaPersona";
		
	}
	
	@GetMapping(value = "/create")
	public String crear(@ModelAttribute Persona persona) {
		return "persona/formPersona";
	}
	@PostMapping(value = "/save")
	public String gurdar(@ModelAttribute Persona persona, BindingResult result,RedirectAttributes attributes) {
		
		if (result.hasErrors()) {
			
			return "persona/formPersona";
		}
		servicePesona.insertar(persona);
	 attributes.addFlashAttribute("mensaje","guardado con exito");
		return "redirect:/Personas/index";
	}
	
	@GetMapping(value = "/edit/{id}")
	public String editar(@PathVariable("id")   int idPersona , Model model ) {
		Persona persona = servicePesona.buscarPorId(idPersona);
		
		model.addAttribute("persona" ,persona);
		return "persona/formPersona";
	}
	
	@GetMapping("/delete/{id}")
   public String delet(@PathVariable("id") int idPersona, RedirectAttributes attributes ) {
		Persona persona = servicePesona.buscarPorId(idPersona);
	  servicePesona.eliminar(idPersona);
	 
		 attributes.addFlashAttribute("mensaje","Eliminado con exito ");
	return "redirect:/Personas/index";
}
	@RequestMapping(value = "/buscar/{name}" ,method = RequestMethod.POST)
	public String editar(@PathVariable("name") String nombre   , Model model ) {
		Persona persona = servicePesona.buscarPorNombre(nombre);
		
		model.addAttribute("persona" ,persona);
		return "persona/listaPersona";
	}
	
	
	
	//permite  ingrese el formato date dorrecto  
		@InitBinder
		 public void initBinder(WebDataBinder binder) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
		}
	
}
