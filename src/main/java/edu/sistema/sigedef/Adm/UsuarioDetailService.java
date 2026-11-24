package edu.sistema.sigedef.Adm;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service 
public class UsuarioDetailService implements UserDetailsService {
  
  @Autowired 
  private UsuarioRepository usuarioRepository;

  @Override 
  public UserDetails loadUserByUsername(String matricula) throws UsernameNotFoundException {
    Optional<Usuario> user = usuarioRepository.buscarListaUm(matricula);
    if (user.isEmpty()) {
      throw new UsernameNotFoundException("Usuário não encontrado");
    }
    return user.get();
  }
}
