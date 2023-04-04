import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

public class ClaseMain {


	public static void main(String[] args) {
		
		 BufferedReader lector;
	        String linea;
	        
	        String rutaPronostico = "C:\\Users\\KTA\\eclipse-workspace\\TrabajoInt\\src\\pronosticos.csv";
	        String rutaResultados = "C:\\Users\\KTA\\eclipse-workspace\\TrabajoInt\\src\\resultados.csv";
	        
	        List<Partido> partidos = new ArrayList<Partido>();
	        List<Pronostico> pronosticos = new ArrayList<Pronostico>();
	        
    try {
	        lector = new BufferedReader(new FileReader(rutaPronostico));
	        while ((linea = lector.readLine()) != null) {
	                String[] lineaArray = linea.split(";");

	             System.out.println(lineaArray[0]+" "+lineaArray[1]+" "+lineaArray[2]+" "+lineaArray[3]);

	              Equipo equipo1 = new Equipo(lineaArray[0],"equipo1");
	              Equipo equipo2 = new Equipo(lineaArray[3], "equipo2");
	              int golesEquipo1 = Integer.parseInt(lineaArray[1]);
	              int golesEquipo2 = Integer.parseInt(lineaArray[2]);

	      Partido partido = new Partido(equipo1, equipo2, golesEquipo1, golesEquipo2);

	                partidos.add(partido);
	            }
	        } catch (Exception e) {
	            System.out.println("Error al leer el archivo partidos");
	        }

	  try {
	         lector = new BufferedReader(new FileReader(rutaPartido));
	         int cont = 0;
	         while ((linea = lector.readLine()) != null) {
	            
	                ResultadoEnum resultado = null;
	                String[] lineaPronostico = linea.split(";");

	        
	                if (lineaPronostico[1].equals("x")) {
	                    resultado = ResultadoEnum.GANADOR;
	                }

	                else if (lineaPronostico[2].equals("x")) {
	                    resultado = ResultadoEnum.EMPATE;
	                }

	                else if (lineaPronostico[3].equals("x")) {
	                    resultado = ResultadoEnum.PERDEDOR;
	                }else {
	                    System.out.println("No se encontró resultado");
	                }
	               
	                System.out.println(lineaPronostico[0]+" "+lineaPronostico[1]+" "+lineaPronostico[2]+" "+lineaPronostico[3]+" "+lineaPronostico[4]);


	                Pronostico pronostico = new Pronostico(partidos.get(cont), partidos.get(cont).getEquipo1(), resultado);

	             
	                pronosticos.add(pronostico);

	                cont++;
	            }
	        } catch (Exception e) {
	            System.out.println("Error")   ;  
	     }


	     Ronda ronda = new Ronda("1", partidos, pronosticos);

	        int puntos = ronda.puntos();

	        System.out.println("Puntaje = "+puntos);
	
	}

}
