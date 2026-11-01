
package com.imperialnet.inventiory.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author jonii
 */


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Notificacion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mensaje;

    private boolean leido;

    private LocalDateTime fecha;

    @Enumerated(EnumType.STRING)
    private TipoNotificacion tipo; // STOCK_BAJO, CAMBIO_CONTRASENA, etc.

    // Relación con el usuario que recibe la notificación
    @ManyToOne
    private Usuario usuario;

}
