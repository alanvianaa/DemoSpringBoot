
package com.alanviana.demo.repository;

import com.alanviana.demo.model.Cadastro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Cadastros extends JpaRepository<Cadastro, Long>{
    
}
