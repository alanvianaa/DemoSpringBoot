
package com.alanviana.demo.controller;

import com.alanviana.demo.model.Convidado;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alanviana.demo.repository.Convidados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/convidados")
public class ConvidadoController {
    
    @Autowired //injetar o repositorio no controller
    private Convidados convidados;

    @GetMapping("/")
    public String iniciar(){
        return "index";
    }
    
    @GetMapping
    public ModelAndView listar(){
              
        ModelAndView modelAndView = new ModelAndView("novapagina");
        modelAndView.addObject("convidados", convidados.findAll());
        
        modelAndView.addObject(new Convidado());
        
        return modelAndView;
    }
    
    @PostMapping
    public String salvar(Convidado convidado) {
        this.convidados.save(convidado);
        return "redirect:/convidados";
    }
    
}
