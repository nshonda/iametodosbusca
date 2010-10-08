package br.pucpr.eng.comp.ia.conteiner;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import br.pucpr.eng.comp.ia.model.Circle;
import br.pucpr.eng.comp.ia.model.Line;
import br.pucpr.eng.comp.ia.util.Constantes;

/**
 * Singleton que mantém todas as peças do jogo e tabuleiro.
 * 
 * @author g0012477
 * 
 */
public class Holders {

	private static Holders holder = null;

	private List<Circle> computador;
	private List<Circle> humano;
	private List<Circle> circulos_ocos;
	private List<Line> linhas;

	private Holders() {
		computador = new ArrayList<Circle>(3);
		humano = new ArrayList<Circle>(3);
		circulos_ocos = new ArrayList<Circle>(9);
		linhas = new ArrayList<Line>(16);

		initialize();
	}

	private void initialize() {
		// Monta os computadores para CIMA!
		computador.add(new Circle(Constantes.POS_1, Constantes.POS_1,
				Constantes.RAIO, Constantes.COR_COMPUTADOR));
		computador.add(new Circle(Constantes.POS_2, Constantes.POS_1,
				Constantes.RAIO, Constantes.COR_COMPUTADOR));
		computador.add(new Circle(Constantes.POS_3, Constantes.POS_1,
				Constantes.RAIO, Constantes.COR_COMPUTADOR));
		
		for (Circle c : computador) {
			c.setFilled(true);
		}

		// Monta os Humanos para baixo.
		humano.add(new Circle(Constantes.POS_1, Constantes.POS_3,
				Constantes.RAIO, Constantes.COR_HUMANO));
		humano.add(new Circle(Constantes.POS_2, Constantes.POS_3,
				Constantes.RAIO, Constantes.COR_HUMANO));
		humano.add(new Circle(Constantes.POS_3, Constantes.POS_3,
				Constantes.RAIO, Constantes.COR_HUMANO));
		
		for (Circle c : humano) {
			c.setFilled(true);
		}

		// Monta as partes OCA do quadro.
		circulos_ocos.add(new Circle(Constantes.POS_1, Constantes.POS_1,
				Constantes.RAIO_OCO, Constantes.COR_OCO));
		circulos_ocos.add(new Circle(Constantes.POS_1, Constantes.POS_2,
				Constantes.RAIO_OCO, Constantes.COR_OCO));
		circulos_ocos.add(new Circle(Constantes.POS_1, Constantes.POS_3,
				Constantes.RAIO_OCO, Constantes.COR_OCO));
		circulos_ocos.add(new Circle(Constantes.POS_2, Constantes.POS_1,
				Constantes.RAIO_OCO, Constantes.COR_OCO));
		circulos_ocos.add(new Circle(Constantes.POS_2, Constantes.POS_2,
				Constantes.RAIO_OCO, Constantes.COR_OCO));
		circulos_ocos.add(new Circle(Constantes.POS_2, Constantes.POS_3,
				Constantes.RAIO_OCO, Constantes.COR_OCO));
		circulos_ocos.add(new Circle(Constantes.POS_3, Constantes.POS_1,
				Constantes.RAIO_OCO, Constantes.COR_OCO));
		circulos_ocos.add(new Circle(Constantes.POS_3, Constantes.POS_2,
				Constantes.RAIO_OCO, Constantes.COR_OCO));
		circulos_ocos.add(new Circle(Constantes.POS_3, Constantes.POS_3,
				Constantes.RAIO_OCO, Constantes.COR_OCO));

		for (Circle c : circulos_ocos) {
			c.setFilled(false);
		}
		
		//Constrói as linhas Horizontais
		int x1 = Constantes.POS_1+Constantes.RAIO_OCO;
		int y1 = Constantes.POS_1;
		int x2 = Constantes.POS_2-Constantes.RAIO_OCO;
		int y2 = y1;
		linhas.add(new Line(x1,y1,x2,y2,Color.BLUE));

		x1 = Constantes.POS_2+Constantes.RAIO_OCO;
		y1 = Constantes.POS_1;
		x2 = Constantes.POS_3-Constantes.RAIO_OCO;
		y2 = y1;
		linhas.add(new Line(x1,y1,x2,y2,Color.BLUE));
		
		x1 = Constantes.POS_1+Constantes.RAIO_OCO;
		y1 = Constantes.POS_2;
		x2 = Constantes.POS_2-Constantes.RAIO_OCO;
		y2 = y1;
		linhas.add(new Line(x1,y1,x2,y2,Color.BLUE));
		
		x1 = Constantes.POS_2+Constantes.RAIO_OCO;
		y1 = Constantes.POS_2;
		x2 = Constantes.POS_3-Constantes.RAIO_OCO;
		y2 = y1;
		linhas.add(new Line(x1,y1,x2,y2,Color.BLUE));
		
		x1 = Constantes.POS_1+Constantes.RAIO_OCO;
		y1 = Constantes.POS_3;
		x2 = Constantes.POS_2-Constantes.RAIO_OCO;
		y2 = y1;
		linhas.add(new Line(x1,y1,x2,y2,Color.BLUE));
		
		x1 = Constantes.POS_2+Constantes.RAIO_OCO;
		y1 = Constantes.POS_3;
		x2 = Constantes.POS_3-Constantes.RAIO_OCO;
		y2 = y1;
		linhas.add(new Line(x1,y1,x2,y2,Color.BLUE));
		
		
		//Constrói as linhas Verticais
		x1 = Constantes.POS_1;
		y1 = Constantes.POS_1+Constantes.RAIO_OCO;
		x2 = x1;
		y2 = Constantes.POS_2-Constantes.RAIO_OCO;
		linhas.add(new Line(x1,y1,x2,y2,Color.BLUE));
		
		x1 = Constantes.POS_1;
		y1 = Constantes.POS_2+Constantes.RAIO_OCO;
		x2 = x1;
		y2 = Constantes.POS_3-Constantes.RAIO_OCO;
		linhas.add(new Line(x1,y1,x2,y2,Color.BLUE));
		
		x1 = Constantes.POS_2;
		y1 = Constantes.POS_1+Constantes.RAIO_OCO;
		x2 = x1;
		y2 = Constantes.POS_2-Constantes.RAIO_OCO;
		linhas.add(new Line(x1,y1,x2,y2,Color.BLUE));
		
		x1 = Constantes.POS_2;
		y1 = Constantes.POS_2+Constantes.RAIO_OCO;
		x2 = x1;
		y2 = Constantes.POS_3-Constantes.RAIO_OCO;
		linhas.add(new Line(x1,y1,x2,y2,Color.BLUE));
		
		x1 = Constantes.POS_3;
		y1 = Constantes.POS_1+Constantes.RAIO_OCO;
		x2 = x1;
		y2 = Constantes.POS_2-Constantes.RAIO_OCO;
		linhas.add(new Line(x1,y1,x2,y2,Color.BLUE));
		
		x1 = Constantes.POS_3;
		y1 = Constantes.POS_2+Constantes.RAIO_OCO;
		x2 = x1;
		y2 = Constantes.POS_3-Constantes.RAIO_OCO;
		linhas.add(new Line(x1,y1,x2,y2,Color.BLUE));
				
		
		//Constrói Diagonais Principais
		int deltaX = (int) (Math.sin(Math.PI/4)*Constantes.RAIO_OCO);
		int deltaY = (int) (Math.cos(Math.PI/4)*Constantes.RAIO_OCO);
		
		x1 = Constantes.POS_1+deltaX;
		y1 = Constantes.POS_1+deltaY;
		x2 = Constantes.POS_2-deltaX;
		y2 = Constantes.POS_2-deltaY;
		linhas.add(new Line(x1,y1,x2,y2,Color.BLUE));
		
		x1 = Constantes.POS_2+deltaX;
		y1 = Constantes.POS_2+deltaY;
		x2 = Constantes.POS_3-deltaX;
		y2 = Constantes.POS_3-deltaY;
		linhas.add(new Line(x1,y1,x2,y2,Color.BLUE));
		
		//Constrói Diagonais Secundárias
		x1 = Constantes.POS_3-deltaY;
		y1 = Constantes.POS_1+deltaX;
		x2 = Constantes.POS_2+deltaY;
		y2 = Constantes.POS_2-deltaX;
		linhas.add(new Line(x1,y1,x2,y2,Color.BLUE));
		
		x1 = Constantes.POS_1+deltaY;
		y1 = Constantes.POS_3-deltaX;
		x2 = Constantes.POS_2-deltaY;
		y2 = Constantes.POS_2+deltaX;
		linhas.add(new Line(x1,y1,x2,y2,Color.BLUE));
	}

	public static final Holders getInstance() {
		if (holder == null) {
			holder = new Holders();
		}
		return holder;
	}

	public List<Circle> getPecasComputador() {
		return this.computador;
	}

	public List<Circle> getPecasHumano() {
		return this.humano;
	}

	public List<Circle> getPecasVazias() {
		return this.circulos_ocos;
	}
	
	public List<Line> getLinhas() {
		return this.linhas;
	}

}
