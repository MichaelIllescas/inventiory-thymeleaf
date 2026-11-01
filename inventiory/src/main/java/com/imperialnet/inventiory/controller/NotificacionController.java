/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.imperialnet.inventiory.controller;

import com.imperialnet.inventiory.entities.Notificacion;
import com.imperialnet.inventiory.entities.Usuario;
import com.imperialnet.inventiory.service.INotificacionService;
import com.imperialnet.inventiory.service.IUsuarioService;
import jakarta.servlet.http.HttpSession;
import java.security.Principal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author jonii
 */
@Controller
public class NotificacionController {
    
    @Autowired
    IUsuarioService usuarioService;
    @Autowired
    INotificacionService notificacionService;
    
    
    @GetMapping("/notificaciones")
public String mostrarNotificaciones(Principal principal,HttpSession sesion)  {
    Usuario usuario = usuarioService.obtenerUsuarioPorId((Long) sesion.getAttribute("idUsuario"));
    List<Notificacion> notificaciones = notificacionService.obtenerNotificacionesNoLeidas(usuario);
    sesion.setAttribute("notificaciones", notificaciones);
    

    return "redirect:/index";
}
    @GetMapping("/notificaciones/leido/{id}")
public String marcarComoLeido(@PathVariable Long id) {
    notificacionService.marcarComoLeido(id);
    return "redirect:/notificaciones";
}

    @GetMapping("/notificacionesStock")
public String mostrarNotificaciones(HttpSession sesion)  {
    Usuario usuario = usuarioService.obtenerUsuarioPorId((Long) sesion.getAttribute("idUsuario"));
    List<Notificacion> notificaciones = notificacionService.obtenerNotificacionesNoLeidas(usuario);
    sesion.setAttribute("notificaciones", notificaciones);
    

    return "redirect:/registrarVenta";
}



    @GetMapping("/marcarLeidas")
    public String marcarNotificacionesComoLeidas(HttpSession sesion){
        
        notificacionService.marcarTodasLeidas((Long)sesion.getAttribute("idUsuario"));
        Usuario usuario = usuarioService.obtenerUsuarioPorId((Long) sesion.getAttribute("idUsuario"));
    List<Notificacion> notificaciones = notificacionService.obtenerNotificacionesNoLeidas(usuario);
        return "redirect:/notificaciones";
    
}
    
    @GetMapping("/centroNotificaciones")
    public String abrirCentroNotifcaciones( HttpSession sesion){
        List<Notificacion> notificaciones = notificacionService.obtenerTodasNotificacionesdeUsuario((Long) sesion.getAttribute("idUsuario"));
        sesion.setAttribute("notificacionesCentro", notificaciones);
        return "verNotificaciones";
    }
    
    @PostMapping("/marcarNotificacionLeida")
    public String marcarNotificacionLeida(@RequestParam("idNotificacion") long idNotificacion ){
       notificacionService.marcarComoLeido(idNotificacion);
        
        return "redirect:/centroNotificaciones";
    }
    
}
