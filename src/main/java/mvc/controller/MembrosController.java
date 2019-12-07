package mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mvc.model.Membros;
import mvc.service.MembrosService;
import mvc.service.ProjetoService;
import mvc.service.PessoaService;

@Controller
@RequestMapping("/membros")
public class MembrosController {

	@Autowired
	ProjetoService projetoService;
	
	@Autowired
	PessoaService pessoaService;
	
	@Autowired
	MembrosService membrosService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView model = new ModelAndView("membros/list");

		List list = membrosService.listAllMembros();
		model.addObject("listMembros", list);

		return model;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView add() {
		ModelAndView model = new ModelAndView("membros/form");
		List listProjetos = projetoService.listAllProjetos();
		List listPessoas = pessoaService.listAllPessoas();
		
		model.addObject("membrosForm", new Membros());
		model.addObject("listProjetos", listProjetos);
		model.addObject("listPessoas", listPessoas);
				
		return model;
	}

	@RequestMapping(value = "/update/{idprojeto}/{idpessoa}", method = RequestMethod.GET)
	public ModelAndView update(@PathVariable("idprojeto") int idprojeto, @PathVariable("idpessoa") int idpessoa) {
		ModelAndView model = new ModelAndView("membros/form");
		List listProjetos = projetoService.listAllProjetos();
		List listPessoas = pessoaService.listAllPessoas();
		
		model.addObject("membrosForm", membrosService.findMembrosById(idprojeto, idpessoa));
		model.addObject("listProjetos", listProjetos);
		model.addObject("listPessoas", listPessoas);
		
		return model;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("membros") Membros membros) {
		membrosService.addMembros(membros);
		
		return new ModelAndView("redirect:/membros/list");
	}

	@RequestMapping(value = "/delete/{idprojeto}/{idpessoa}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable("idprojeto") int idprojeto, @PathVariable("idpessoa") int idpessoa) {
		membrosService.deleteMembros(idprojeto, idpessoa);

		return new ModelAndView("redirect:/membros/list");
	}

}