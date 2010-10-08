package br.pucpr.eng.comp.ia.model;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Classe responsável por desenhar as linhas.
 * 
 * @author Heverton Ivan de Sene
 * 
 */
public class Line implements Geometria {

	private int x1, x2, y1, y2;
	private Color color;

	public Line(int x1, int y1, int x2, int y2, Color c) {
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
		color = c;
	}

	public void draw(Graphics g) {
		// Salva a cor do contexto.
		Color oldColor = g.getColor();

		g.setColor(color);
		g.drawLine(x1, y1, x2, y2);

		// Recupera a cor do Contexto.
		g.setColor(oldColor);
	}
}
