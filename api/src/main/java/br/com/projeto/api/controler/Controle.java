package br.com.projeto.api.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.api.modelo.Pessoa;
import br.com.projeto.api.repositorio.Repositorio;

@RestController
public class Controle {

    @Autowired
    private Repositorio acao;

    @SuppressWarnings("null")
    @PostMapping("/api")
    public Pessoa cadastrar(@RequestBody Pessoa obj) {
        return acao.save(obj);
    }

    @GetMapping("/api/{codigo}")
    public Pessoa selecionarPeloCodigo(@PathVariable int codigo) {
        return acao.findByCodigo(codigo);
    }

    @SuppressWarnings("null")
    @PutMapping("/api")
    public Pessoa editar(@RequestBody Pessoa obj) {
        return acao.save(obj);
    }

    @SuppressWarnings("null")
    @DeleteMapping("/api/{codigo}")
    public void remover(@PathVariable int codigo) {
        Pessoa obj = selecionarPeloCodigo(codigo);
        acao.delete(obj);
    }

    @GetMapping("/api/contado")
    public long contador() {
        return acao.count();
    }

    @GetMapping("/api/ordenaNomes")
    public List<Pessoa> ordenarNomes() {
        return acao.findByOrderByNomeAsc();
    }

    @GetMapping("/api/ordenarNomes2")
    public List<Pessoa> ordenarNomes2(){
        return acao.findByNomeOrderByIdadeDesc("João Paulo");
    }

    @GetMapping("/api/nomeContem")
    public List<Pessoa> nomeContem(){
        return acao.findByNomeContaining("Lu");
    }

    @GetMapping("/api/nomeIniciaCom")
    public List<Pessoa> nomeIniciaCom(){
        return acao.findByNomeStartsWith("L");
    }
    @GetMapping("/api/nomeTerminaCom")
    public List<Pessoa> nomeTerminaCom(){
        return acao.findByNomeEndsWith("e");
    }

    @GetMapping("/api/somaIdades")
    public int somaIdades(){
         return acao.somaIdades();
    }

    @GetMapping("/api/idadeMaiorIgual")
    public List<Pessoa> idadeMaiorIgual(){
        return acao.idadeMaiorIgual(20);
    }

    @GetMapping("/api")
    public List<Pessoa> selecionar() {
        return acao.findAll();
    }

    @GetMapping("/status")
    public ResponseEntity<?> status(){
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
   
}
