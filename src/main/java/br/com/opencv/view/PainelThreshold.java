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

public class PainelThreshold extends JPanel {

	private static final long serialVersionUID = 1L;
	private SpinnerModel controleValor, controleLimite;
	private JComboBox<String> controleTipo;

	public PainelThreshold() {
		carregaComponentes();
		adicionaLayouts();
		customizaComponentes();
		adicionaComponentes();
		adicionaComandos();
	}

	private void carregaComponentes() {
		controleValor = new SpinnerNumberModel(Configuracao.valorLimiarizacao,
				Configuracao.valorLimiarizacaoMin,
				Configuracao.valorLimiarizacaoMax,
				Configuracao.valorLimiarizacaoStep);
		controleLimite = new SpinnerNumberModel(
				Configuracao.limiteLimiarizacao,
				Configuracao.limiteLimiarizacaoMin,
				Configuracao.limiteLimiarizacaoMax,
				Configuracao.limiteLimiarizacaoStep);
		controleTipo = new JComboBox<String>();
		controleTipo.addItem("Binário");
		controleTipo.addItem("Binário Invertido");
		controleTipo.addItem("Truncado");
		controleTipo.addItem("Para Zero");
		controleTipo.addItem("Para Zero Invertido");
	}

	private void customizaComponentes() {
		setPreferredSize(new Dimension(350, 150));
		setBackground(Color.white);
	}

	private void adicionaLayouts() {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
	}

	private void adicionaComponentes() {
		add(new JLabel("Limiarização"));
		add(new JSpinner(controleValor));
		add(new JLabel("Limite"));
		add(new JSpinner(controleLimite));
		add(new JLabel("Tipo"));
		add(controleTipo);
	}

	private void adicionaComandos() {
		controleValor.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent evt) {
				Configuracao.valorLimiarizacao = (int) controleValor.getValue();
			}
		});
		controleLimite.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent evt) {
				Configuracao.limiteLimiarizacao = (int) controleLimite
						.getValue();
			}
		});
		controleTipo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				Configuracao.tipoLimiarizacao = controleTipo.getSelectedIndex();
			}
		});
	}

}
