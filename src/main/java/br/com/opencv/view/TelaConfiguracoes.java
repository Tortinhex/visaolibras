package br.com.opencv.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import br.com.opencv.model.Configuracao;

public class TelaConfiguracoes extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel painelConfiguracoes;
	private JComboBox<String> listaTecnicas;
	private GridBagConstraints gbc;

	public TelaConfiguracoes() {
		super("Configurações");
		carregaComponentes();
		adicionaLayouts();
		customizaComponentes();
		adicionaComponentes();
		adicionaComandos();
		setVisible(false);
		mudaPainelConfiguracao();
	}

	private void carregaComponentes() {
		gbc = new GridBagConstraints();
		painelConfiguracoes = new JPanel();
		listaTecnicas = new JComboBox<String>();
		listaTecnicas.addItem("BackgroundSubtractionKNN");
		listaTecnicas.addItem("BackgroundSubtractionMOG2");
		listaTecnicas.addItem("MedianBlur");
		listaTecnicas.addItem("GaussianBlur");
		listaTecnicas.addItem("Threshold");
		listaTecnicas.addItem("Laplacian");
		listaTecnicas.addItem("Canny");
		listaTecnicas.addItem("Dilate");
		listaTecnicas.addItem("Erode");
		listaTecnicas.addItem("MorphologyOpening");
		listaTecnicas.addItem("MorphologyClosing");
		listaTecnicas.addItem("MorphologyGradient");
		listaTecnicas.addItem("MorphologyTopHat");
		listaTecnicas.addItem("MorphologyBlackHat");
	}

	private void adicionaLayouts() {
		getContentPane().setLayout(new GridBagLayout());
	}

	private void customizaComponentes() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setPreferredSize(new Dimension(400, 300));
		painelConfiguracoes.setPreferredSize((new Dimension(300, 200)));
		getContentPane().setBackground(Color.white);
		painelConfiguracoes.setBackground(Color.white);
		setResizable(false);
		pack();
		setLocationRelativeTo(null);
	}

	private void adicionaComponentes() {

		ImageIcon iconeChapeuGraduacao = new ImageIcon(
				Configuracao.diretorioUsuario + "/resources/image/settings.png");

		setIconImage(iconeChapeuGraduacao.getImage());

		gbc.fill = GridBagConstraints.BOTH;
		gbc.anchor = GridBagConstraints.NORTHWEST;

		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.insets = new Insets(8, 8, 8, 8);
		getContentPane().add(listaTecnicas, gbc);

		gbc.weightx = 1;
		gbc.weighty = 10;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.insets = new Insets(8, 8, 8, 8);
		getContentPane().add(painelConfiguracoes, gbc);

	}

	private void adicionaComandos() {
		listaTecnicas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				mudaPainelConfiguracao();
			}
		});
	}

	private void mudaPainelConfiguracao() {
		JPanel painel = null;
		try {
			painel = (JPanel) Class.forName(
					"br.com.opencv.view.Painel"
							+ listaTecnicas.getSelectedItem()).newInstance();
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			e.printStackTrace();
		}
		painelConfiguracoes.removeAll();
		painelConfiguracoes.add(painel);
		painelConfiguracoes.repaint();
		pack();
	}

}
