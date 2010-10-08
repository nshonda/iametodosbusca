package br.pucpr.eng.comp.ia;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import br.pucpr.eng.comp.ia.conteiner.Holders;
import br.pucpr.eng.comp.ia.model.Geometria;

public class GameWindow extends JPanel
{
	
	private static final long serialVersionUID = 1L;
		
	public GameWindow(Color backColor, int width, int height)
	{
		setBackground(backColor);
		setPreferredSize(new Dimension(width, height));
	
		// Listener da Janela para o Mouse.
		addMouseListener(new PanelListener());
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		for (Geometria pecas : Holders.getInstance().getPecasComputador()) {
			pecas.draw(g);
		}
		
		for (Geometria pecas : Holders.getInstance().getPecasHumano()) {
			pecas.draw(g);
		}
		
		for (Geometria pecas : Holders.getInstance().getPecasVazias()) {
			pecas.draw(g);
		}
		
		for (Geometria pecas : Holders.getInstance().getLinhas()) {
			pecas.draw(g);
		}
	}

	private class PanelListener extends MouseAdapter
	{
		public void mousePressed(MouseEvent e)
		{
			Point pto = e.getLocationOnScreen();
			System.out.println("x = "+pto.x+" >> y = "+pto.y);
		}
	}

	public static void main(String [] args)
	{
		JFrame theGUI = new JFrame();
		theGUI.setTitle("Jogo de Trilha");
		theGUI.setSize(530, 600);
		theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Desenha o circulo
		GameWindow jogo = new GameWindow(Color.WHITE, 530, 600);
		
		Container pane = theGUI.getContentPane();
		pane.add(jogo);
		
		theGUI.setVisible(true);
	}
}
