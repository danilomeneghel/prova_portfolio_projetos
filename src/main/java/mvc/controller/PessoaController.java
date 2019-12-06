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

import mvc.model.Pessoa;
import mvc.service.PessoaService;

@Controller
@RequestMapping("/pessoa")
public class PessoaController {

	@Autowired
	PessoaService pessoaService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView model = new ModelAndView("pessoa/list");

		List list = pessoaService.listAllPessoas();
		model.addObject("listPessoa", list);

		return model;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView add() {
		ModelAndView model = new ModelAndView("pessoa/form");
		model.addObject("pessoaForm", new Pessoa());
		
		return model;
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public ModelAndView update(@PathVariable("id") int id) {
		ModelAndView model = new ModelAndView("pessoa/form");
		model.addObject("pessoaForm", pessoaService.findPessoaById(id));
		
		return model;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("pessoa") Pessoa pessoa) {

		if (pessoa != null && pessoa.getId() != null) {
			pessoaService.updatePessoa(pessoa);
		} else {
			pessoaService.addPessoa(pessoa);
		}

		return new ModelAndView("redirect:/pessoa/list");
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable("id") int id) {
		pessoaService.deletePessoa(id);

		return new ModelAndView("redirect:/pessoa/list");
	}

}