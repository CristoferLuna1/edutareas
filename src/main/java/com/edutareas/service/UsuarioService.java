package com.edutareas.service;

import com.edutareas.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    Usuario crearUsuario(Usuario usuario);
    Optional<Usuario> obtenerPorId(Long id);
    List<Usuario> listarTodos();
    void eliminarUsuario(Long id);
}
