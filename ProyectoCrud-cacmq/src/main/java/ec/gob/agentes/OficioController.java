package ec.gob.agentes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ec.gob.model.Oficios;
import ec.gob.model.Operativo;
import ec.gob.service.IOficiosService;
import ec.gob.util.Utileria;

@Controller
@RequestMapping("/Oficios")
public class OficioController {
	@Autowired 
	private IOficiosService serviceOficios;
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<Oficios> lista= serviceOficios.buscarTodas();
		model.addAttribute("oficio",lista);
		return "oficios/listaOficios";
		
	}
	
	@GetMapping(value = "/create")
	public String crear(@ModelAttribute Oficios oficios) {
		return "oficios/formOficios";
	}
	
	
	
	
	@PostMapping(value = "/save")
	public String gurdar(@ModelAttribute Oficios oficios, BindingResult result,RedirectAttributes attributes) {
		
		if (result.hasErrors()) {
			
			return "oficios/formOficios";
		}
		serviceOficios.insertar(oficios);
	 attributes.addFlashAttribute("mensaje","guardado con exito");
		return "redirect:/Oficios/index";
	}
	
	
	
	
	
	@GetMapping(value = "/edit/{id}")
	public String editar(@PathVariable("id")   int idOficios , Model model ) {
		Oficios oficios = serviceOficios.buscarPorId(idOficios);
		
		model.addAttribute("oficios" ,oficios);
		return "oficios/formOficios";
	}
	
	
	
	
	
	@GetMapping("/delete/{id}")
   public String delet(@PathVariable("id") int idOficios, RedirectAttributes attributes ) {
		
	  serviceOficios.eliminar(idOficios);
	 
		 attributes.addFlashAttribute("mensaje","Eliminado con exito ");
	return "redirect:/Oficios/index";
}
	
	
	
	
	//permite  ingrese el formato date dorrecto  
		@InitBinder
		 public void initBinder(WebDataBinder binder) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
		}
	
}
