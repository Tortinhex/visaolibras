package br.com.opencv.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import br.com.opencv.model.Configuracao;

public class PainelBackgroundSubtractionKNN extends JPanel {

	private static final long serialVersionUID = 1L;
	private SpinnerModel controleTaxaAprendizado, controleHistorico,
			controleLimiarizacao;
	private JComboBox<Boolean> controleSombra;

	public PainelBackgroundSubtractionKNN() {
		carregaComponentes();
		adicionaLayouts();
		customizaComponentes();
		adicionaComponentes();
		adicionaComandos();
	}

	private void carregaComponentes() {
		controleTaxaAprendizado = new SpinnerNumberModel(
				Configuracao.taxaAprendizadoKNN,
				Configuracao.taxaAprendizadoKNNMin,
				Configuracao.taxaAprendizadoKNNMax,
				Configuracao.taxaAprendizadoKNNStep);
		controleHistorico = new SpinnerNumberModel(Configuracao.historicoKNN,
				Configuracao.historicoKNNMin, Configuracao.historicoKNNMax,
				Configuracao.historicoKNNStep);
		controleLimiarizacao = new SpinnerNumberModel(
				Configuracao.limiarizacaoKNN, Configuracao.limiarizacaoKNNMin,
				Configuracao.limiarizacaoKNNMax,
				Configuracao.limiarizacaoKNNStep);
		controleSombra = new JComboBox<Boolean>(new Boolean[] {
				Configuracao.sombraKNN, !Configuracao.sombraKNN });
	}

	private void customizaComponentes() {
		setPreferredSize(new Dimension(350, 200));
		setBackground(Color.white);
	}

	private void adicionaLayouts() {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
	}

	private void adicionaComponentes() {
		add(new JLabel("Taxa de Aprendizado"));
		add(new JSpinner(controleTaxaAprendizado));
		add(new JLabel("Histórico"));
		add(new JSpinner(controleHistorico));
		add(new JLabel("Limiarização"));
		add(new JSpinner(controleLimiarizacao));
		add(new JLabel("Sombra"));
		add(controleSombra);
	}

	private void adicionaComandos() {
		controleTaxaAprendizado.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent evt) {
				Configuracao.taxaAprendizadoKNN = (double) controleTaxaAprendizado
						.getValue();
			}
		});
		controleHistorico.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent evt) {
				Configuracao.historicoKNN = (int) controleHistorico.getValue();
			}
		});
		controleLimiarizacao.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent evt) {
				Configuracao.limiarizacaoKNN = (double) controleLimiarizacao
						.getValue();
			}
		});
		controleSombra.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				Configuracao.sombraKNN = (boolean) controleSombra
						.getSelectedItem();
			}
		});
	}

}
