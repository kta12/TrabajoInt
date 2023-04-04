package torneo;

public class ResultadoEnum {

	public static final ResultadoEnum GANADOR = null;
	public static final ResultadoEnum PERDEDOR = null;
	public static final ResultadoEnum EMPATE = null;
	private static final String resultado = null;


public String[] result() {
    String[] resultados = new String[3];
    resultados[0] = ResultadoEnum.resultado;
    resultados[1] = ResultadoEnum.resultado;
    resultados[2] = ResultadoEnum.resultado;
    return resultados;
}
}