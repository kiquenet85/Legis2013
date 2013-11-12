package main;

import system.persona.Persona;
import utileria.NotiEnum;

public class Contexto {

	/** Objeto Persona que se encuentra en el sistema. */
	public static Persona usuario;

	/** Objeto que contiene el tipo de Notificación a lanzar. */
	public static NotiEnum notif=NotiEnum.INTENTOS_INGRESO_3;
	
}
