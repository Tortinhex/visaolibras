package br.com.opencv.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import br.com.opencv.controller.Controlador;
import br.com.opencv.model.Configuracao;

public class TelaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel painelMenu, painelInferior;
	private PainelVideo painelCaptura;
	private JMenuBar menu;
	private JMenu menuOpcoes;
	private JMenuItem itemTecnicas, itemConfiguracoes, itemSair;
	private JToggleButton botaoCaptura;
	private JLabel visualizadorContadorFrames;
	private int contadorFrames;
	private GridBagConstraints gbc;
	private Controlador controlador;
	private TelaTecnicas telaTecnicas;
	private TelaConfiguracoes telaConfiguracoes;

	public TelaPrincipal() {
		super(
				"Universidade Paulista - Marquês - Ciência da Computação - TCC 2015");
		carregaComponentes();
		adicionaLayouts();
		customizaComponentes();
		adicionaComponentes();
		adicionaComandos();
		controlador = new Controlador(this);
		setVisible(true);
		telaTecnicas = new TelaTecnicas();
		telaConfiguracoes = new TelaConfiguracoes();
		controlador.preencheListaTecnicas();
	}

	private void carregaComponentes() {
		gbc = new GridBagConstraints();
		painelMenu = new JPanel();
		painelInferior = new JPanel();
		painelCaptura = new PainelVideo();
		menu = new JMenuBar();
		botaoCaptura = new JToggleButton("Capturar Vídeo");
		menuOpcoes = new JMenu("Opções");
		itemTecnicas = new JMenuItem("Técnicas");
		itemConfiguracoes = new JMenuItem("Configurações");
		itemSair = new JMenuItem("Sair");
		visualizadorContadorFrames = new JLabel("Nenhum frame capturado..");
	}

	private void adicionaLayouts() {
		getContentPane().setLayout(new GridBagLayout());
		painelMenu.setLayout(new BorderLayout());
		painelInferior.setLayout(new FlowLayout(FlowLayout.LEFT));
	}

	private void customizaComponentes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setSize(660, 580);
		getContentPane().setBackground(Color.white);
		setLocationRelativeTo(null);
		painelInferior.setBackground(Color.white);
		painelInferior.setBorder(BorderFactory.createTitledBorder(""));
		painelCaptura.setBackground(Color.black);
	}

	private void adicionaComponentes() {

		ImageIcon iconeChapeuGraduacao = new ImageIcon(
				Configuracao.DIRETORIO_RAIZ
						+ "/resources/image/graduation_hat.png");

		ImageIcon iconeTecnicas = new ImageIcon(Configuracao.DIRETORIO_RAIZ
				+ "/resources/image/operations.png");

		ImageIcon iconeConfiguracoes = new ImageIcon(
				Configuracao.DIRETORIO_RAIZ + "/resources/image/settings.png");

		ImageIcon iconeSair = new ImageIcon(Configuracao.DIRETORIO_RAIZ
				+ "/resources/image/exit.png");

		setIconImage(iconeChapeuGraduacao.getImage());
		itemTecnicas.setIcon(iconeTecnicas);
		itemConfiguracoes.setIcon(iconeConfiguracoes);
		itemSair.setIcon(iconeSair);

		painelMenu.add(menu, BorderLayout.CENTER);
		painelInferior.add(botaoCaptura);
		painelInferior.add(visualizadorContadorFrames);
		menu.add(menuOpcoes);
		menuOpcoes.add(itemTecnicas);
		menuOpcoes.add(itemConfiguracoes);
		menuOpcoes.add(itemSair);

		gbc.fill = GridBagConstraints.BOTH;
		gbc.anchor = GridBagConstraints.NORTHWEST;

		gbc.weightx = 2;
		gbc.weighty = 1;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(0, 0, 8, 0);
		getContentPane().add(painelMenu, gbc);

		gbc.weightx = 2;
		gbc.weighty = 20;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.insets = new Insets(8, 8, 8, 8);
		getContentPane().add(painelCaptura, gbc);

		gbc.weightx = 0;
		gbc.weighty = 0;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.insets = new Insets(0, 8, 8, 8);
		getContentPane().add(painelInferior, gbc);
	}

	private void adicionaComandos() {
		botaoCaptura.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				if (botaoCaptura.isSelected())
					controlador.iniciaCaptura();
				else
					controlador.desligaCaptura();
			}
		});
		itemSair.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				controlador.sair();
			}
		});
		itemTecnicas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				telaTecnicas.setVisible(true);
			}
		});
		itemConfiguracoes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				telaConfiguracoes.setVisible(true);
			}
		});
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent ev) {
				controlador.desligaCaptura();
			}
		});
	}

	public void resetaFrames() {
		visualizadorContadorFrames
				.setText((contadorFrames = 0) + " Frame(s)..");
	}

	public void incrementaFrames() {
		visualizadorContadorFrames.setText((++contadorFrames) + " Frame(s)..");
	}

	public PainelVideo getPainelCaptura() {
		return painelCaptura;
	}

	public TelaTecnicas getTelaTecnicas() {
		return telaTecnicas;
	}

}
