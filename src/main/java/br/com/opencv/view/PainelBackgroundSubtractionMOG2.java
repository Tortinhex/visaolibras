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

public class PainelBackgroundSubtractionMOG2 extends JPanel {

	private static final long serialVersionUID = 1L;
	private SpinnerModel controleTaxaAprendizado, controleHistorico,
			controleLimiarizacao;
	private JComboBox<Boolean> controleSombra;

	public PainelBackgroundSubtractionMOG2() {
		carregaComponentes();
		adicionaLayouts();
		customizaComponentes();
		adicionaComponentes();
		adicionaComandos();
	}

	private void carregaComponentes() {
		controleTaxaAprendizado = new SpinnerNumberModel(
				Configuracao.taxaAprendizadoMOG2,
				Configuracao.taxaAprendizadoMOG2Min,
				Configuracao.taxaAprendizadoMOG2Max,
				Configuracao.taxaAprendizadoMOG2Step);
		controleHistorico = new SpinnerNumberModel(Configuracao.historicoMOG2,
				Configuracao.historicoMOG2Min, Configuracao.historicoMOG2Max,
				Configuracao.historicoMOG2Step);
		controleLimiarizacao = new SpinnerNumberModel(
				Configuracao.limiarizacaoMOG2,
				Configuracao.limiarizacaoMOG2Min,
				Configuracao.limiarizacaoMOG2Max,
				Configuracao.limiarizacaoMOG2Step);
		controleSombra = new JComboBox<Boolean>(new Boolean[] {
				Configuracao.sombraMOG2, !Configuracao.sombraMOG2 });
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
				Configuracao.taxaAprendizadoMOG2 = (double) controleTaxaAprendizado
						.getValue();
			}
		});
		controleHistorico.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent evt) {
				Configuracao.historicoMOG2 = (int) controleHistorico.getValue();
			}
		});
		controleLimiarizacao.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent evt) {
				Configuracao.limiarizacaoMOG2 = (double) controleLimiarizacao
						.getValue();
			}
		});
		controleSombra.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				Configuracao.sombraMOG2 = (boolean) controleSombra
						.getSelectedItem();
			}
		});
	}

}
