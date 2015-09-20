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

public class PainelMorphologyTopHat extends JPanel {

	private static final long serialVersionUID = 1L;
	private SpinnerModel controleMascaraX, controleMascaraY;
	private JComboBox<String> controleElemento;

	public PainelMorphologyTopHat() {
		carregaComponentes();
		adicionaLayouts();
		customizaComponentes();
		adicionaComponentes();
		adicionaComandos();
	}

	private void carregaComponentes() {
		controleMascaraX = new SpinnerNumberModel(
				Configuracao.mascaraCartolaMorfologicaX,
				Configuracao.mascaraCartolaMorfologicaXMin,
				Configuracao.mascaraCartolaMorfologicaXMax,
				Configuracao.mascaraCartolaMorfologicaXStep);
		controleMascaraY = new SpinnerNumberModel(
				Configuracao.mascaraCartolaMorfologicaY,
				Configuracao.mascaraCartolaMorfologicaYMin,
				Configuracao.mascaraCartolaMorfologicaYMax,
				Configuracao.mascaraCartolaMorfologicaYStep);
		controleElemento = new JComboBox<String>();
		controleElemento.addItem("Retangulo");
		controleElemento.addItem("Cruz");
		controleElemento.addItem("Elipse");
		controleElemento
				.setSelectedIndex(Configuracao.elementoCartolaMorfologica);
	}

	private void customizaComponentes() {
		setPreferredSize(new Dimension(350, 150));
		setBackground(Color.white);
	}

	private void adicionaLayouts() {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
	}

	private void adicionaComponentes() {
		add(new JLabel("Mascara X"));
		add(new JSpinner(controleMascaraX));
		add(new JLabel("Mascara Y"));
		add(new JSpinner(controleMascaraY));
		add(new JLabel("Elemento"));
		add(controleElemento);
	}

	private void adicionaComandos() {
		controleMascaraX.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent evt) {
				Configuracao.mascaraCartolaMorfologicaX = (int) controleMascaraX
						.getValue();
			}
		});
		controleMascaraY.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent evt) {
				Configuracao.mascaraCartolaMorfologicaY = (int) controleMascaraY
						.getValue();
			}
		});
		controleElemento.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				Configuracao.elementoCartolaMorfologica = controleElemento
						.getSelectedIndex();
			}
		});
	}

}
