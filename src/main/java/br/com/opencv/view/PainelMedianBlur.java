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

public class PainelMedianBlur extends JPanel {

	private static final long serialVersionUID = 1L;
	private SpinnerModel controleMascaraBorramento;

	public PainelMedianBlur() {
		carregaComponentes();
		adicionaLayouts();
		customizaComponentes();
		adicionaComponentes();
		adicionaComandos();
	}

	private void carregaComponentes() {
		controleMascaraBorramento = new SpinnerNumberModel(
				Configuracao.mascaraBorramentoMediana,
				Configuracao.mascaraBorramentoMedianaMin,
				Configuracao.mascaraBorramentoMedianaMax,
				Configuracao.mascaraBorramentoMedianaStep);
	}

	private void customizaComponentes() {
		setPreferredSize(new Dimension(350, 50));
		setBackground(Color.white);
	}

	private void adicionaLayouts() {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
	}

	private void adicionaComponentes() {
		add(new JLabel("Mascara"));
		add(new JSpinner(controleMascaraBorramento));
	}

	private void adicionaComandos() {
		controleMascaraBorramento.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent evt) {
				Configuracao.mascaraBorramentoMediana = (int) controleMascaraBorramento
						.getValue();
			}
		});
	}

}
