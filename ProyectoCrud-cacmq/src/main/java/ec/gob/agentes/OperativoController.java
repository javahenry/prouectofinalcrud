package ec.gob.agentes;

import java.lang.ProcessBuilder.Redirect;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ec.gob.model.Operativo;
import ec.gob.service.IDetallesService;
import ec.gob.service.IOperativoService;

import ec.gob.service.OperativoServiceJpa;

@Controller
@RequestMapping("/operativos")
public class OperativoController {
	@Autowired
	private IDetallesService serviceDetalle;
	@Autowired
	private IOperativoService serviceOperativo;
	@GetMapping("index")
	public String mostrarIndex(Model model) {
		List<Operativo> lista= serviceOperativo.buscarTodas();
		model.addAttribute("operativo",lista);
		return "operativo/listaOperativos";
		
	}
	
	
	@GetMapping(value = "/create")
	public String crear(@ModelAttribute Operativo operativo) {
		return "operativo/formOperativo";
	}

	@PostMapping(value = "/save")
	public String gurdar(@ModelAttribute Operativo operativo, BindingResult result,RedirectAttributes attributes) {
		
		if (result.hasErrors()) {
			System.out.println("existe errores");
			return "operativo/formOperativo";
		}
		System.out.println("antes" +operativo.getDetalle());
		serviceDetalle.insertar(operativo.getDetalle());
		System.out.println("despues" +operativo.getDetalle());
		serviceOperativo.insertar(operativo);
		
		attributes.addFlashAttribute("mensaje","guardado con exito");
		return "redirect:/operativos/index";
	}
	
	@GetMapping(value = "/edit/{id}")
	public String editar(@PathVariable("id")   int  idOperativo , Model model ) {
		Operativo operativo = serviceOperativo.buscarPorId(idOperativo);
		
		model.addAttribute("operativo" ,operativo);
		return "operativo/formOperativo";
	}
	
	
	@GetMapping("/delete/{id}")
   public String delet(@PathVariable("id") int idOperativo, RedirectAttributes attributes ) {
		//primero se elimina pelicula
		//despues los detalles
		
		Operativo operativo = serviceOperativo.buscarPorId(idOperativo);
	  serviceOperativo.eliminar(idOperativo);
	  serviceDetalle.eliminar(operativo.getDetalle().getId());
		 attributes.addFlashAttribute("mensaje","Eliminado con exito ");
	return "redirect:/operativos/index";
}
	
	
	
	
	
	//permite  ingrese el formato date dorrecto  
	@InitBinder
	 public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
}
