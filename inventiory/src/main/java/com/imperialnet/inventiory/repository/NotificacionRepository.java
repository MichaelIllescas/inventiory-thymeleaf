
package com.imperialnet.inventiory.repository;

import com.imperialnet.inventiory.entities.Notificacion;
import com.imperialnet.inventiory.entities.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jonii
 */
@Repository
public interface NotificacionRepository extends JpaRepository<Notificacion, Long> {
    List<Notificacion> findByUsuarioAndLeidoFalseOrderByFechaDesc(Usuario usuario);
   
    List<Notificacion> findAllByUsuarioOrderByFechaDesc(Usuario usuario);

}
