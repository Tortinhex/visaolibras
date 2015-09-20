package br.com.opencv.view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import br.com.opencv.model.Configuracao;

public class PainelGaussianBlur extends JPanel {

	private static final long serialVersionUID = 1L;
	private SpinnerModel controleMascaraBorramentoX,
			controleMascaraBorramentoY, controleDesvioPadraoBorramentoX,
			controleDesvioPadraoBorramentoY;

	public PainelGaussianBlur() {
		carregaComponentes();
		adicionaLayouts();
		customizaComponentes();
		adicionaComponentes();
		adicionaComandos();
	}

	private void carregaComponentes() {
		controleMascaraBorramentoX = new SpinnerNumberModel(
				Configuracao.mascaraBorramentoGaussianoX,
				Configuracao.mascaraBorramentoGaussianoXMin,
				Configuracao.mascaraBorramentoGaussianoXMax,
				Configuracao.mascaraBorramentoGaussianoXStep);
		controleMascaraBorramentoY = new SpinnerNumberModel(
				Configuracao.mascaraBorramentoGaussianoY,
				Configuracao.mascaraBorramentoGaussianoYMin,
				Configuracao.mascaraBorramentoGaussianoYMax,
				Configuracao.mascaraBorramentoGaussianoYStep);
		controleDesvioPadraoBorramentoX = new SpinnerNumberModel(
				Configuracao.desvioPadraoBorramentoGaussianoX,
				Configuracao.desvioPadraoBorramentoGaussianoXMin,
				Configuracao.desvioPadraoBorramentoGaussianoXMax,
				Configuracao.desvioPadraoBorramentoGaussianoXStep);
		controleDesvioPadraoBorramentoY = new SpinnerNumberModel(
				Configuracao.desvioPadraoBorramentoGaussianoY,
				Configuracao.desvioPadraoBorramentoGaussianoYMin,
				Configuracao.desvioPadraoBorramentoGaussianoYMax,
				Configuracao.desvioPadraoBorramentoGaussianoYStep);
	}

	private void customizaComponentes() {
		setPreferredSize(new Dimension(350, 200));
		setBackground(Color.white);
	}

	private void adicionaLayouts() {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
	}

	private void adicionaComponentes() {
		add(new JLabel("Mascara X"));
		add(new JSpinner(controleMascaraBorramentoX));
		add(new JLabel("Mascara Y"));
		add(new JSpinner(controleMascaraBorramentoY));
		add(new JLabel("Desvio Padrao X"));
		add(new JSpinner(controleDesvioPadraoBorramentoX));
		add(new JLabel("Desvio Padrao Y"));
		add(new JSpinner(controleDesvioPadraoBorramentoY));
	}

	private void adicionaComandos() {
		controleMascaraBorramentoX.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent evt) {
				Configuracao.mascaraBorramentoGaussianoX = (int) controleMascaraBorramentoX
						.getValue();
			}
		});
		controleMascaraBorramentoY.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent evt) {
				Configuracao.mascaraBorramentoGaussianoY = (int) controleMascaraBorramentoY
						.getValue();
			}
		});
		controleDesvioPadraoBorramentoX.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent evt) {
				Configuracao.desvioPadraoBorramentoGaussianoX = (double) controleDesvioPadraoBorramentoX
						.getValue();
			}
		});
		controleDesvioPadraoBorramentoY.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent evt) {
				Configuracao.desvioPadraoBorramentoGaussianoY = (double) controleDesvioPadraoBorramentoY
						.getValue();
			}
		});
	}

}
