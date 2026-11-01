
package com.imperialnet.inventiory.service;

import com.imperialnet.inventiory.entities.Notificacion;
import com.imperialnet.inventiory.entities.TipoNotificacion;
import com.imperialnet.inventiory.entities.Usuario;
import java.util.List;


/**
 *
 * @author jonii
 */

public interface INotificacionService {
   
    public void crearNotificacion(String mensaje, TipoNotificacion tipo, Usuario usuario);
    
    public List<Notificacion> obtenerNotificacionesNoLeidas(Usuario usuario);
    
    public void marcarComoLeido(Long id);
    
    public void marcarTodasLeidas(Long usuarioId);
    
    public List<Notificacion> obtenerTodasNotificacionesdeUsuario(Long idUsuario);
    
    
    
}
