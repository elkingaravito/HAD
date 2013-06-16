package snk.nucleo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;
 
/**
 */
public class validador {
	public List<String[]> myEntries;
    /**
     * Constructor for validador.
     * @param adr String
     * @param fileName String
     * @throws IOException
     */
    public validador(String adr, String fileName) throws IOException {
		File fileIn = new File(adr);
    	CSVReader reader = new CSVReader(new FileReader(adr),';');
	    List<String[]> matrix = reader.readAll();
		File archivoSalida=new File(fileName);
		FileWriter fw = null;
		String[] tipoDato={"Alfabetico","Numerico"};
		int[][] porcentaje=dataType(matrix);
		try {   
			fw = new FileWriter(archivoSalida);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    BufferedWriter bw = new BufferedWriter(fw);
	    PrintWriter salida = new PrintWriter(bw);
	    InputStreamReader archivo = new InputStreamReader(new FileInputStream(fileIn));
	    
		salida.print("<html><head><title>Validaci?n archivo "+fileIn.getName()+"</title></head>");
		salida.print("<body>");
		salida.print("Archivo: "+adr+"<br><br>");
		salida.print("Codificaci?n: "+archivo.getEncoding()+"<br><br>");
		salida.print(getSize(adr));
		salida.print("N?mero de filas: "+getRows(matrix)+"<br><br>");
		salida.print("Filas vacias: "+getEmpty(matrix)+"<br><br>");
		System.out.print("1");
		salida.print("N?mero de columnas: "+getColumns(matrix)+"<br>");
		System.out.print("2");
		salida.print("<table border='1px'><tr><td>Nombres de columnas</td><td>"+columnNames(matrix).replaceAll(",", "</td><td>")+"</td></tr>");
		int cuenta=0;
		for(int[] a:porcentaje){
			salida.print("<tr><td>"+tipoDato[cuenta]+"</td>");
			for(int  b:a){
				salida.print("<td>"+b+"</td>");
			}
			salida.print("</tr>");
			cuenta++;
		}
		System.out.print("3");
		salida.print("<tr><td>");
		salida.print("Longitud maxima dato");
		salida.print("</td>");
		int[] longitudMaxima=longMax(matrix);
		for(int g:longitudMaxima){
			salida.print("<td>"+g+"</td>");
		}
		salida.print("</tr>");
		salida.print("</table>");
		salida.print("</body></html>");
		salida.close();
  //  	System.out.println(getCoding(adr));
    //	System.out.println(getSize(adr));
    //	System.out.println(getRows(matrix));
    //	System.out.println(getEmpty(matrix));
    //	System.out.println(getColumns(matrix));
    //	System.out.println(columnNames(matrix));
    //	System.out.println(dataType(matrix));
    //	int[] arreglo = longMax(matrix); 
    //	for(int valor:arreglo)System.out.println(valor);
		System.out.print("fin");
	  //  viewCSV(matrix);
    	reader.close();
    	matrix.clear();
    }
	/**
	 * Method viewCSV.
	 * @param matrix List<String[]>
	 * @throws IOException
	 */
	public void viewCSV(List<String[]> matrix) throws IOException {
	    ArrayList<String> listaColumna = new ArrayList();
		for(int j=0;j<matrix.get(0).length;j++){
		    for(int i=0;i<matrix.size();i++){
	    		String[] a=matrix.get(i);
	    		listaColumna.add(a[j]);
	    	}
	    	System.out.println(listaColumna.size());
	    	listaColumna.clear();
	    }
	}
	/**
	 * Method getCoding.
	 * @param adr String
	 * @return String
	 * @throws IOException
	 */
	public String getCoding(String adr) throws IOException{
		String codigo=null;
    	InputStreamReader archivo = new InputStreamReader(new FileInputStream(new File(adr)));
		codigo = archivo.getEncoding();
		archivo.close();
		return codigo;
	}
	/**
	 * @param adr
	
	 * @return String
	 */
	public String getSize(String adr){
		File archivo=new File(adr);
		long size=archivo.length();
		double valorBytes=size;
		double fileSizeInKB = valorBytes/ 1024;
		double fileSizeInMB = fileSizeInKB / 1024;
		String tamano="Tama?o <br>Bytes: "+valorBytes+" <br>KBytes: "+fileSizeInKB+" <br>MBytes: "+fileSizeInMB+"<br><br>";
		return tamano;
				
	}
	/**
	 * Method getRows.
	 * @param matrix List<String[]>
	 * @return String
	 */
	public String getRows(List<String[]> matrix){
		int rows=matrix.size();
		return rows+"";
	}
	/**
	 * Method getEmpty.
	 * @param matrix List<String[]>
	 * @return String
	 */
	public String getEmpty(List<String[]> matrix){
		String rows = "";
		int i=0,row1=0;
	    for(String[] fila:matrix){
		    i++;
	    	for(String celda:fila){
	    		if(celda.replaceAll(" ", "").equals("")){
	    			row1++;
	    		}
	    	}
	    	if(row1==(fila.length))rows+=i+", ";
	    	row1=0;
	    }
		return rows;
	}
	/**
	 * Method getColumns.
	 * @param matrix List<String[]>
	 * @return String
	 */
	public String getColumns(List<String[]> matrix){
		return matrix.get(0).length+"";
	}
	/**
	 * Method columnNames.
	 * @param matrix List<String[]>
	 * @return String
	 */
	public String columnNames(List<String[]> matrix){
		String fila="";
		for(String celda:matrix.get(0)){
			fila+=celda+",";
		}
		return fila;
	}
	/**
	 * Method dataType.
	 * @param matrix List<String[]>
	 * @return int[][]
	 */
	public int[][] dataType(List<String[]> matrix){
		String filas="";
		Pattern pattern;
		Matcher mattcher;
		int[][] porcentaje=new int[2][matrix.get(0).length];
		String[] expresionReg={"^[A-Za-z?????????????\\s]*$","^[\\d]*$"},tipoDato={"Alfabetico","Numerico"};
	    for(String[] fila:matrix){
			for(int contador=0;contador<2;contador++){
				pattern = Pattern.compile(expresionReg[contador]);
				for(int contador1=0;contador1<fila.length;contador1++){
					mattcher = pattern.matcher(fila[contador1].replaceAll("\"", "").replaceAll("'", "").replaceAll(" ", ""));
					if(mattcher.matches()==true){	
						porcentaje[contador][contador1]++;
					}
				}
			}
	    }
		return porcentaje;
	}
	/**
	 * Method longMax.
	 * @param matrix List<String[]>
	 * @return int[]
	 */
	public int[] longMax(List<String[]> matrix){
		int size[] = new int[matrix.get(0).length];
		for(int j=0;j<matrix.get(0).length;j++){
		    for(int i=0;i<matrix.size();i++){
	    		String[] a=matrix.get(i);
	    		if(i==0)size[j]=a[j].length();
	    		else{
	    			if(size[j]<a[j].length()){
	    				size[j]=a[j].length();
	    			}
	    		}
    		}
    	}
    	return size;
    }
	

}
