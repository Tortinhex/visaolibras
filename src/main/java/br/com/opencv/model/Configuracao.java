package br.com.opencv.model;

import org.opencv.core.CvType;

public class Configuracao {

	public static final String DIRETORIO_RAIZ = System
			.getProperty("user.dir");

	// BACKGROUND SUBTRACTION KNN
	public static double taxaAprendizadoKNN = 0.001;
	public static double taxaAprendizadoKNNMin = 0.001;
	public static double taxaAprendizadoKNNMax = 10;
	public static double taxaAprendizadoKNNStep = 0.001;
	public static int historicoKNN = 500;
	public static int historicoKNNMin = 0;
	public static int historicoKNNMax = 1000;
	public static int historicoKNNStep = 10;
	public static double limiarizacaoKNN = 400.0;
	public static double limiarizacaoKNNMin = 0.0;
	public static double limiarizacaoKNNMax = 1000.0;
	public static double limiarizacaoKNNStep = 10.0;
	public static boolean sombraKNN = false;

	// BACKGROUND SUBTRACTION MOG2
	public static double taxaAprendizadoMOG2 = 0.001;
	public static double taxaAprendizadoMOG2Min = 0.001;
	public static double taxaAprendizadoMOG2Max = 10;
	public static double taxaAprendizadoMOG2Step = 0.001;
	public static int historicoMOG2 = 500;
	public static int historicoMOG2Min = 0;
	public static int historicoMOG2Max = 1000;
	public static int historicoMOG2Step = 10;
	public static double limiarizacaoMOG2 = 16.0;
	public static double limiarizacaoMOG2Min = 0.0;
	public static double limiarizacaoMOG2Max = 1000.0;
	public static double limiarizacaoMOG2Step = 2.0;
	public static boolean sombraMOG2 = false;

	// MEDIAN BLUR
	public static int mascaraBorramentoMediana = 1;
	public static int mascaraBorramentoMedianaMin = 1;
	public static int mascaraBorramentoMedianaMax = 101;
	public static int mascaraBorramentoMedianaStep = 2;

	// GAUSSIAN BLUR
	public static int mascaraBorramentoGaussianoX = 1;
	public static int mascaraBorramentoGaussianoXMin = 1;
	public static int mascaraBorramentoGaussianoXMax = 101;
	public static int mascaraBorramentoGaussianoXStep = 2;
	public static int mascaraBorramentoGaussianoY = 1;
	public static int mascaraBorramentoGaussianoYMin = 1;
	public static int mascaraBorramentoGaussianoYMax = 101;
	public static int mascaraBorramentoGaussianoYStep = 2;
	public static double desvioPadraoBorramentoGaussianoX = 0.0;
	public static double desvioPadraoBorramentoGaussianoXMin = -100.0;
	public static double desvioPadraoBorramentoGaussianoXMax = 100.0;
	public static double desvioPadraoBorramentoGaussianoXStep = 0.5;
	public static double desvioPadraoBorramentoGaussianoY = 0.0;
	public static double desvioPadraoBorramentoGaussianoYMin = -100.0;
	public static double desvioPadraoBorramentoGaussianoYMax = 100.0;
	public static double desvioPadraoBorramentoGaussianoYStep = 0.5;

	// THRESHOLD
	public static int valorLimiarizacao = 127;
	public static int valorLimiarizacaoMin = 0;
	public static int valorLimiarizacaoMax = 255;
	public static int valorLimiarizacaoStep = 1;
	public static int limiteLimiarizacao = 255;
	public static int limiteLimiarizacaoMin = 0;
	public static int limiteLimiarizacaoMax = 255;
	public static int limiteLimiarizacaoStep = 1;
	public static int tipoLimiarizacao = 0;

	// LAPLACE
	public static int profundidadeLaplaciano = CvType.CV_16S;
	public static int profundidadeLaplacianoMin = 2;
	public static int profundidadeLaplacianoMax = 1000;
	public static int profundidadeLaplacianoStep = 1;
	public static int mascaraLaplaciano = 1;
	public static int mascaraLaplacianoMin = 1;
	public static int mascaraLaplacianoMax = 31;
	public static int mascaraLaplacianoStep = 2;
	public static int escalaLaplaciano = 1;
	public static int escalaLaplacianoMin = -1000;
	public static int escalaLaplacianoMax = 1000;
	public static int escalaLaplacianoStep = 1;
	public static int deltaLaplaciano = 0;
	public static int deltaLaplacianoMin = -1000;
	public static int deltaLaplacianoMax = 1000;
	public static int deltaLaplacianoStep = 1;

	// CANNY
	public static double valorMinimoLimiarizacaoCanny = 150;
	public static double valorMinimoLimiarizacaoCannyMin = -1000;
	public static double valorMinimoLimiarizacaoCannyMax = 1000;
	public static double valorMinimoLimiarizacaoCannyStep = 1;
	public static double valorMaximoLimiarizacaoCanny = 250;
	public static double valorMaximoLimiarizacaoCannyMin = -1000;
	public static double valorMaximoLimiarizacaoCannyMax = 1000;
	public static double valorMaximoLimiarizacaoCannyStep = 1;
	public static int mascaraGradienteCanny = 3;
	public static int mascaraGradienteCannyMin = 3;
	public static int mascaraGradienteCannyMax = 7;
	public static int mascaraGradienteCannyStep = 2;
	public static boolean gradienteCanny = false;

	// DILATE
	public static int mascaraDilatacaoX = 8;
	public static int mascaraDilatacaoXMin = 1;
	public static int mascaraDilatacaoXMax = 100;
	public static int mascaraDilatacaoXStep = 1;
	public static int mascaraDilatacaoY = 8;
	public static int mascaraDilatacaoYMin = 1;
	public static int mascaraDilatacaoYMax = 100;
	public static int mascaraDilatacaoYStep = 1;
	public static int elementoDilatacao = 0;

	// ERODE
	public static int mascaraErosaoX = 8;
	public static int mascaraErosaoXMin = 1;
	public static int mascaraErosaoXMax = 100;
	public static int mascaraErosaoXStep = 1;
	public static int mascaraErosaoY = 8;
	public static int mascaraErosaoYMin = 1;
	public static int mascaraErosaoYMax = 100;
	public static int mascaraErosaoYStep = 1;
	public static int elementoErosao = 0;

	// Morphology Opening
	public static int mascaraAberturaMorfologicaX = 8;
	public static int mascaraAberturaMorfologicaXMin = 1;
	public static int mascaraAberturaMorfologicaXMax = 100;
	public static int mascaraAberturaMorfologicaXStep = 1;
	public static int mascaraAberturaMorfologicaY = 8;
	public static int mascaraAberturaMorfologicaYMin = 1;
	public static int mascaraAberturaMorfologicaYMax = 100;
	public static int mascaraAberturaMorfologicaYStep = 1;
	public static int elementoAberturaMorfologica = 0;

	// Morphology Closing
	public static int mascaraFechamentoMorfologicoX = 8;
	public static int mascaraFechamentoMorfologicoXMin = 1;
	public static int mascaraFechamentoMorfologicoXMax = 100;
	public static int mascaraFechamentoMorfologicoXStep = 1;
	public static int mascaraFechamentoMorfologicoY = 8;
	public static int mascaraFechamentoMorfologicoYMin = 1;
	public static int mascaraFechamentoMorfologicoYMax = 100;
	public static int mascaraFechamentoMorfologicoYStep = 1;
	public static int elementoFechamentoMorfologico = 0;

	// Morphology Gradient
	public static int mascaraGradienteMorfologicoX = 8;
	public static int mascaraGradienteMorfologicoXMin = 1;
	public static int mascaraGradienteMorfologicoXMax = 100;
	public static int mascaraGradienteMorfologicoXStep = 1;
	public static int mascaraGradienteMorfologicoY = 8;
	public static int mascaraGradienteMorfologicoYMin = 1;
	public static int mascaraGradienteMorfologicoYMax = 100;
	public static int mascaraGradienteMorfologicoYStep = 1;
	public static int elementoGradienteMorfologico = 0;

	// Morphology Top Hat
	public static int mascaraCartolaMorfologicaX = 8;
	public static int mascaraCartolaMorfologicaXMin = 1;
	public static int mascaraCartolaMorfologicaXMax = 100;
	public static int mascaraCartolaMorfologicaXStep = 1;
	public static int mascaraCartolaMorfologicaY = 8;
	public static int mascaraCartolaMorfologicaYMin = 1;
	public static int mascaraCartolaMorfologicaYMax = 100;
	public static int mascaraCartolaMorfologicaYStep = 1;
	public static int elementoCartolaMorfologica = 0;

	// Morphology Black Hat
	public static int mascaraChapeuPretoMorfologicoX = 8;
	public static int mascaraChapeuPretoMorfologicoXMin = 1;
	public static int mascaraChapeuPretoMorfologicoXMax = 100;
	public static int mascaraChapeuPretoMorfologicoXStep = 1;
	public static int mascaraChapeuPretoMorfologicoY = 8;
	public static int mascaraChapeuPretoMorfologicoYMin = 1;
	public static int mascaraChapeuPretoMorfologicoYMax = 100;
	public static int mascaraChapeuPretoMorfologicoYStep = 1;
	public static int elementoChapeuPretoMorfologico = 0;

}
