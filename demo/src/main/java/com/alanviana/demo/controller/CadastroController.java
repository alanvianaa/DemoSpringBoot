
package com.alanviana.demo.controller;

import com.alanviana.demo.model.Cadastro;
import com.alanviana.demo.repository.Cadastros;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cadastros")
public class CadastroController {
    
    @Autowired //injetar o repositório no controller
    private Cadastros cadastros;
    
    @GetMapping
    public ModelAndView listar(){
        
        ModelAndView modelAndView = new ModelAndView("cadastro");
        modelAndView.addObject("cadastros",cadastros.findAll());
        
        modelAndView.addObject(new Cadastro());
        
        return modelAndView;
    }
    
    @PostMapping
    public String salvar(Cadastro cadastro) {
        this.cadastros.save(cadastro);
        return "redirect:/cadastros";
    }

}
