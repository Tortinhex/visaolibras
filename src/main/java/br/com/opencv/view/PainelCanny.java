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

public class PainelCanny extends JPanel {

	private static final long serialVersionUID = 1L;
	private SpinnerModel controleValorMinimoLimiarizacao,
			controleValorMaximoLimiarizacao, controleMascaraGradiente;
	private JComboBox<Boolean> controleGradiente;

	public PainelCanny() {
		carregaComponentes();
		adicionaLayouts();
		customizaComponentes();
		adicionaComponentes();
		adicionaComandos();
	}

	private void carregaComponentes() {
		controleValorMinimoLimiarizacao = new SpinnerNumberModel(
				Configuracao.valorMinimoLimiarizacaoCanny,
				Configuracao.valorMinimoLimiarizacaoCannyMin,
				Configuracao.valorMinimoLimiarizacaoCannyMax,
				Configuracao.valorMinimoLimiarizacaoCannyStep);
		controleValorMaximoLimiarizacao = new SpinnerNumberModel(
				Configuracao.valorMaximoLimiarizacaoCanny,
				Configuracao.valorMaximoLimiarizacaoCannyMin,
				Configuracao.valorMaximoLimiarizacaoCannyMax,
				Configuracao.valorMaximoLimiarizacaoCannyStep);
		controleMascaraGradiente = new SpinnerNumberModel(
				Configuracao.mascaraGradienteCanny,
				Configuracao.mascaraGradienteCannyMin,
				Configuracao.mascaraGradienteCannyMax,
				Configuracao.mascaraGradienteCannyStep);
		controleGradiente = new JComboBox<Boolean>(new Boolean[] {
				Configuracao.gradienteCanny, !Configuracao.gradienteCanny });
	}

	private void customizaComponentes() {
		setPreferredSize(new Dimension(350, 200));
		setBackground(Color.white);
	}

	private void adicionaLayouts() {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
	}

	private void adicionaComponentes() {
		add(new JLabel("Valor Mínimo da Limiarização"));
		add(new JSpinner(controleValorMinimoLimiarizacao));
		add(new JLabel("Valor Máximo da Limiarização"));
		add(new JSpinner(controleValorMaximoLimiarizacao));
		add(new JLabel("Máscara Gradiente"));
		add(new JSpinner(controleMascaraGradiente));
		add(new JLabel("Gradiente"));
		add(controleGradiente);
	}

	private void adicionaComandos() {
		controleValorMinimoLimiarizacao.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent evt) {
				Configuracao.valorMinimoLimiarizacaoCanny = (double) controleValorMinimoLimiarizacao
						.getValue();
			}
		});
		controleValorMaximoLimiarizacao.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent evt) {
				Configuracao.valorMaximoLimiarizacaoCanny = (double) controleValorMaximoLimiarizacao
						.getValue();
			}
		});
		controleMascaraGradiente.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent evt) {
				Configuracao.mascaraGradienteCanny = (int) controleMascaraGradiente
						.getValue();
			}
		});
		controleGradiente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				Configuracao.gradienteCanny = (boolean) controleGradiente
						.getSelectedItem();
			}
		});
	}

}
