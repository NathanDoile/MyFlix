package br.com.nathandoile.MyFlix.service.validator;

import br.com.nathandoile.MyFlix.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ValidarEmailService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void validar(String email){

        if(usuarioRepository.existsByEmail(email)){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "E-mail já utilizado, por favor, informe " +
                    "outro e-mail.");
        }
    }
}
