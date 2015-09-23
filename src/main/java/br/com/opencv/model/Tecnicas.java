package br.com.opencv.model;

import java.util.Vector;

import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfInt;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;
import org.opencv.video.BackgroundSubtractorKNN;
import org.opencv.video.BackgroundSubtractorMOG2;
import org.opencv.video.Video;

public class Tecnicas {

	private BackgroundSubtractorKNN bsKNN;
	private BackgroundSubtractorMOG2 bsMOG2;

	public Tecnicas() {
		bsKNN = Video.createBackgroundSubtractorKNN(Configuracao.historicoKNN,
				Configuracao.limiarizacaoKNN, Configuracao.sombraKNN);
		bsMOG2 = Video.createBackgroundSubtractorMOG2(
				Configuracao.historicoMOG2, Configuracao.limiarizacaoMOG2,
				Configuracao.sombraMOG2);
	}

	// ELIMINACAO DE RUIDO COM SUAVIZACAO
	public Mat medianBlur(Mat matriz) {
		Mat matrizMedian = new Mat();
		Imgproc.medianBlur(matriz, matrizMedian,
				Configuracao.mascaraBorramentoMediana);
		return matrizMedian;
	}

	// SUVIZACAO
	public Mat gaussianBlur(Mat matriz) {
		Mat matrizGaussian = new Mat();
		Imgproc.GaussianBlur(matriz, matrizGaussian, new Size(
				Configuracao.mascaraBorramentoGaussianoX,
				Configuracao.mascaraBorramentoGaussianoY),
				Configuracao.desvioPadraoBorramentoGaussianoX,
				Configuracao.desvioPadraoBorramentoGaussianoY);
		return matrizGaussian;
	}

	// LIMIARIZACAO
	public Mat threshold(Mat matriz) {
		Mat matrizThreshold = new Mat();
		Imgproc.threshold(matriz, matrizThreshold,
				Configuracao.valorLimiarizacao,
				Configuracao.limiteLimiarizacao, Configuracao.tipoLimiarizacao);
		return matrizThreshold;
	}

	// DETECCAO DE BORDAS
	public Mat laplacian(Mat matriz) {
		Mat matrizLaplacian = new Mat();
		Imgproc.Laplacian(matriz, matrizLaplacian,
				Configuracao.profundidadeLaplaciano,
				Configuracao.mascaraLaplaciano, Configuracao.escalaLaplaciano,
				Configuracao.deltaLaplaciano);
		return matrizLaplacian;
	}

	// DETECCAO DE BORDAS
	public Mat canny(Mat matriz) {
		Mat matrizCanny = new Mat();
		Imgproc.Canny(matriz, matrizCanny,
				Configuracao.valorMinimoLimiarizacaoCanny,
				Configuracao.valorMaximoLimiarizacaoCanny,
				Configuracao.mascaraGradienteCanny, Configuracao.gradienteCanny);
		return matrizCanny;
	}

	// DETECCAO DE BORDAS
	/*
	 * public Mat sobel(Mat matriz) { Mat matrizSobel = new Mat();
	 * Imgproc.Sobel(matriz, matrizSobel, 1, 1, 1); return matrizSobel; }
	 */

	/**
	 * Metodo de subtracao de Objeto na Matriz: Utiliza o
	 * backgroundSubtractionKNN para subtrair um objeto em uma matriz, alem de
	 * realizar o processo de aprendizado
	 * 
	 * @param matriz
	 * @return {@link Mat}
	 * @author Thiago Guy
	 */
	public Mat backgroundSubtractionKNN(Mat matriz) {
		Mat matrizBS = new Mat(matriz.size(), CvType.CV_8U);
		bsKNN.apply(matriz, matrizBS, Configuracao.taxaAprendizadoKNN);
		return matrizBS;
	}

	/**
	 * Metodo de subtracao de Objeto na Matriz: Utiliza o
	 * backgroundSubtractionMOG2 para subtrair um objeto em uma matriz, alem de
	 * realizar o processo de aprendizado
	 * 
	 * @param matriz
	 * @return {@link Mat}
	 * @author Thiago Guy
	 */
	public Mat backgroundSubtractionMOG2(Mat matriz) {
		Mat matrizBS = new Mat(matriz.size(), CvType.CV_8UC1);
		bsMOG2.apply(matriz, matrizBS, Configuracao.taxaAprendizadoMOG2);
		return matrizBS;
	}

	// CONVERSAO ESPACO CINZA PARA O ESPACO RGB
	public Mat colorGrayToRGB(Mat matriz) {
		Mat matrizCvtColor = new Mat();
		Imgproc.cvtColor(matriz, matrizCvtColor, Imgproc.COLOR_GRAY2BGRA, 0);
		return matrizCvtColor;
	}

	// CONVERSAO ESPACO RGB PARA O ESPACO CINZA
	public Mat colorRGBToGray(Mat matriz) {
		Mat matrizCvtColor = new Mat();
		Imgproc.cvtColor(matriz, matrizCvtColor, Imgproc.COLOR_BGRA2GRAY, 0);
		return matrizCvtColor;
	}

	// FILTRO MORFOLOGICO
	public Mat dilate(Mat matriz) {
		Mat mascaraDilate = Imgproc.getStructuringElement(
				Configuracao.elementoDilatacao, new Size(
						Configuracao.mascaraDilatacaoX,
						Configuracao.mascaraDilatacaoY));
		Imgproc.dilate(matriz, matriz, mascaraDilate);
		return matriz;
	}

	// FILTRO MORFOLOGICO
	public Mat erode(Mat matriz) {
		Mat mascaraErode = Imgproc.getStructuringElement(
				Configuracao.elementoErosao, new Size(
						Configuracao.mascaraErosaoX,
						Configuracao.mascaraErosaoY));
		Imgproc.erode(matriz, matriz, mascaraErode);
		return matriz;
	}

	// FILTRO MORFOLOGICO
	public Mat morphologyOpening(Mat matriz) {
		Mat mascaraOpening = Imgproc.getStructuringElement(
				Configuracao.elementoAberturaMorfologica, new Size(
						Configuracao.mascaraAberturaMorfologicaX,
						Configuracao.mascaraAberturaMorfologicaY));
		Imgproc.morphologyEx(matriz, matriz, Imgproc.MORPH_OPEN, mascaraOpening);
		return matriz;
	}

	// FILTRO MORFOLOGICO
	public Mat morphologyClosing(Mat matriz) {
		Mat mascaraClosing = Imgproc.getStructuringElement(
				Configuracao.elementoFechamentoMorfologico, new Size(
						Configuracao.mascaraFechamentoMorfologicoX,
						Configuracao.mascaraFechamentoMorfologicoY));
		Imgproc.morphologyEx(matriz, matriz, Imgproc.MORPH_CLOSE,
				mascaraClosing);
		return matriz;
	}

	// FILTRO MORFOLOGICO
	public Mat morphologyGradient(Mat matriz) {
		Mat mascaraGradient = Imgproc.getStructuringElement(
				Configuracao.elementoGradienteMorfologico, new Size(
						Configuracao.mascaraGradienteMorfologicoX,
						Configuracao.mascaraGradienteMorfologicoY));
		Imgproc.morphologyEx(matriz, matriz, Imgproc.MORPH_GRADIENT,
				mascaraGradient);
		return matriz;
	}

	// FILTRO MORFOLOGICO
	public Mat morphologyTopHat(Mat matriz) {
		Mat mascaraTopHat = Imgproc.getStructuringElement(
				Configuracao.elementoCartolaMorfologica, new Size(
						Configuracao.mascaraCartolaMorfologicaX,
						Configuracao.mascaraCartolaMorfologicaY));
		Imgproc.morphologyEx(matriz, matriz, Imgproc.MORPH_TOPHAT,
				mascaraTopHat);
		return matriz;
	}

	// FILTRO MORFOLOGICO
	public Mat morphologyBlackHat(Mat matriz) {
		Mat mascaraBlackHat = Imgproc.getStructuringElement(
				Configuracao.elementoChapeuPretoMorfologico, new Size(
						Configuracao.mascaraChapeuPretoMorfologicoX,
						Configuracao.mascaraChapeuPretoMorfologicoY));
		Imgproc.morphologyEx(matriz, matriz, Imgproc.MORPH_BLACKHAT,
				mascaraBlackHat);
		return matriz;
	}

	/**
	 * Procura e renderiza os contornos
	 * 
	 * @author Danilo Dorotheu & Thiago Guy
	 * @param image
	 *            {@link Mat}
	 * @return {@link Mat}
	 */
	public Mat findContours(Mat image) {

		Vector<MatOfPoint> contours = new Vector<>();

		MatOfInt hull = new MatOfInt();
		Vector<Point> pointsHull = new Vector<>();
		MatOfPoint contourHull = new MatOfPoint();
		Vector<MatOfPoint> contoursHull = new Vector<>();
		Mat draw = Mat.zeros(image.size(), CvType.CV_8UC3);

		Imgproc.findContours(image, contours, new Mat(), Imgproc.RETR_TREE,
				Imgproc.CHAIN_APPROX_SIMPLE);

		if (contours.size() == 0)
			return image;

		for (int i = 0; i < contours.size(); i++) {

			Imgproc.convexHull(contours.get(i), hull, false);
			pointsHull.clear();

			for (int j = 0; j < hull.toList().size(); j++)
				pointsHull.add(contours.get(i).toList()
						.get(hull.toList().get(j)));

			contourHull.fromList(pointsHull);
			contoursHull.add(contourHull);

			Imgproc.drawContours(draw, contours, i, new Scalar(0, 0, 255), 2,
					8, new Mat(), 0, new Point());
			Imgproc.drawContours(draw, contoursHull, i, new Scalar(0, 0, 255),
					2, 8, new Mat(), 0, new Point());
		}

		return draw;
	}
}
