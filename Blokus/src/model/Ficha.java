package model;
import java.util.ArrayList;
import java.util.List;

public class Ficha {

	private String equipo;
	private int[][] forma;
	private List<Casilla> listaCasillas = new ArrayList<Casilla>();

	public Ficha(int[][] forma, List<Casilla> arrayCasillas, String equipo) {
		this.forma = forma;
		this.equipo = equipo;
		this.listaCasillas = arrayCasillas;
	}

	public void rotar(int rotacion) {
		switch (rotacion) {
		case 270:
			for (int i = 0; i < listaCasillas.size() - 1; i++) {
				if (forma[i][0] == 0) {
					forma[i][0] = -1;
				} else {
					forma[i][0] = 0;
				}
				if (forma[i][1] == 0) {
					forma[i][1] = -1;
				} else {
					forma[i][1] = 0;
				}
				if (forma[i][0] == 0 && forma[i][1] == 0) {
					forma[i][0] = 1;
					forma[i][1] = -1;
				}
			}
			break;
		case 180:
			for (int i = 0; i < listaCasillas.size() - 1; i++) {
				forma[i][0] = -forma[i][0];
				forma[i][1] = -forma[i][1];
			}
			break;
		case 90:
			for (int i = 0; i < listaCasillas.size() - 1; i++) {
				if (forma[i][0] == 0) {
					forma[i][0] = 1;
				} else {
					forma[i][0] = 0;
				}
				if (forma[i][1] == 0) {
					forma[i][1] = 1;
				} else {
					forma[i][1] = 0;
				}
			}
			break;
		}

		setForma();
	}

	public void moverFicha(int x, int y) {
		listaCasillas.get(0).setX(x);
		listaCasillas.get(0).setY(y);
		setForma();
	}

	public void setForma() {
		for (int i = 1; i < listaCasillas.size(); i++) {
			listaCasillas.get(i).setX(listaCasillas.get(i - 1).getX() - forma[i - 1][1]);
			listaCasillas.get(i).setY(listaCasillas.get(i - 1).getY() + forma[i - 1][0]);
		}
	}

	public int[][] getForma() {
		return forma;
	}

	public String getEquipo() {
		return equipo;
	}

	public int getFichaX(int i) {

		return listaCasillas.get(i).getX();
	}

	public int getFichaY(int i) {

		return listaCasillas.get(i).getY();
	}

	public int getNumCasillas() {
		return listaCasillas.size();
	}

}
