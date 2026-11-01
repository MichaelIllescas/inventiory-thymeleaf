/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.imperialnet.inventiory.service;

import com.imperialnet.inventiory.entities.Notificacion;
import com.imperialnet.inventiory.entities.TipoNotificacion;
import com.imperialnet.inventiory.entities.Usuario;
import com.imperialnet.inventiory.repository.NotificacionRepository;
import com.imperialnet.inventiory.repository.UsuarioRepository;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jonii
 */
@Service
public class NotificacionService implements INotificacionService{
    
    
    @Autowired
    private NotificacionRepository notificacionRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    public void crearNotificacion(String mensaje, TipoNotificacion tipo, Usuario usuario) {
        Notificacion notificacion = new Notificacion();
        notificacion.setMensaje(mensaje);
        notificacion.setLeido(false);
        notificacion.setFecha(LocalDateTime.now());
        notificacion.setTipo(tipo);
        notificacion.setUsuario(usuario);
        notificacionRepository.save(notificacion);
    }

    public List<Notificacion> obtenerNotificacionesNoLeidas(Usuario usuario) {
        return notificacionRepository.findByUsuarioAndLeidoFalseOrderByFechaDesc(usuario);
    }

    public void marcarComoLeido(Long id) {
        Notificacion notificacion = notificacionRepository.findById(id).orElseThrow();
        notificacion.setLeido(true);
        notificacionRepository.save(notificacion);
    }
    
    @Override
    public void marcarTodasLeidas(Long usuarioId){
        Usuario usuario= usuarioRepository.findById(usuarioId).orElse(null);
       List<Notificacion> notificaciones= notificacionRepository.findByUsuarioAndLeidoFalseOrderByFechaDesc(usuario);
       for(Notificacion not: notificaciones){
           not.setLeido(true);
       }
        notificacionRepository.saveAll(notificaciones);
    }

    @Override
    public List<Notificacion> obtenerTodasNotificacionesdeUsuario(Long idUsuario) {
        Usuario usuario= usuarioRepository.findById(idUsuario).orElse(null);
        List<Notificacion> listadoDeNotificaciones=notificacionRepository.findAllByUsuarioOrderByFechaDesc(usuario);
        return listadoDeNotificaciones;
    }
    
    
    
}
    
    

