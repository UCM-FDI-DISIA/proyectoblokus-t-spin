package model;

import java.util.HashMap;
import java.util.List;

public interface GameObserver {
	
	// TODO Completar eventos, revisar parámetros:
	// No estoy segura aún de que los parámetros sean los correctos, es posible que se necesiten más o incluso que alguno sobre
	// Faltan eventos por hacer
	
	public void onReset(List<Jugador> jugadores, HashMap<String, String> mapaCasillas);
	
	public void onFichaAnadida(int color, int x, int y, int f);
	
	public void updateIcono (int color);

}
