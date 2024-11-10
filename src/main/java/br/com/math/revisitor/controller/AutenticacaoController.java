package br.com.math.revisitor.controller;

import br.com.math.revisitor.DTO.DadosAutenticacao;
import br.com.math.revisitor.configuration.TokenService;
import br.com.math.revisitor.entity.Usuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;


    @PostMapping()
    public ResponseEntity efetuarAutenticacao(@RequestBody @Valid DadosAutenticacao dadosAutenticacao) {
        var token = new UsernamePasswordAuthenticationToken(dadosAutenticacao.login(), dadosAutenticacao.senha());
        Authentication autenticacao = authenticationManager.authenticate(token);


        return ResponseEntity.ok(tokenService.gerarToken((Usuario) autenticacao.getPrincipal()));
    }

}
