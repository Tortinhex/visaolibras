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

public class PainelLaplacian extends JPanel {

	private static final long serialVersionUID = 1L;
	private SpinnerModel controleProfundidade, controleMascara, controleEscala,
			controleDelta;

	public PainelLaplacian() {
		carregaComponentes();
		adicionaLayouts();
		customizaComponentes();
		adicionaComponentes();
		adicionaComandos();
	}

	private void carregaComponentes() {
		controleProfundidade = new SpinnerNumberModel(
				Configuracao.profundidadeLaplaciano,
				Configuracao.profundidadeLaplacianoMin,
				Configuracao.profundidadeLaplacianoMax,
				Configuracao.profundidadeLaplacianoStep);
		controleMascara = new SpinnerNumberModel(
				Configuracao.mascaraLaplaciano,
				Configuracao.mascaraLaplacianoMin,
				Configuracao.mascaraLaplacianoMax,
				Configuracao.mascaraLaplacianoStep);
		controleEscala = new SpinnerNumberModel(Configuracao.escalaLaplaciano,
				Configuracao.escalaLaplacianoMin,
				Configuracao.escalaLaplacianoMax,
				Configuracao.escalaLaplacianoStep);
		controleDelta = new SpinnerNumberModel(Configuracao.deltaLaplaciano,
				Configuracao.deltaLaplacianoMin,
				Configuracao.deltaLaplacianoMax,
				Configuracao.deltaLaplacianoStep);
	}

	private void customizaComponentes() {
		setPreferredSize(new Dimension(350, 200));
		setBackground(Color.white);
	}

	private void adicionaLayouts() {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
	}

	private void adicionaComponentes() {
		add(new JLabel("Profundidade"));
		add(new JSpinner(controleProfundidade));
		add(new JLabel("Mascara"));
		add(new JSpinner(controleMascara));
		add(new JLabel("Escala"));
		add(new JSpinner(controleEscala));
		add(new JLabel("Delta"));
		add(new JSpinner(controleDelta));
	}

	private void adicionaComandos() {
		controleProfundidade.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent evt) {
				Configuracao.profundidadeLaplaciano = (int) controleProfundidade
						.getValue();
			}
		});
		controleMascara.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent evt) {
				Configuracao.mascaraLaplaciano = (int) controleMascara
						.getValue();
			}
		});
		controleEscala.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent evt) {
				Configuracao.escalaLaplaciano = (int) controleEscala.getValue();
			}
		});
		controleDelta.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent evt) {
				Configuracao.deltaLaplaciano = (int) controleDelta.getValue();
			}
		});
	}

}
