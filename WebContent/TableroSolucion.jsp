<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
	import = "modelo.Partida"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Soluci�n</title>
	<style>
		table, th, td {
			text-align: center;
		}
		form{
			text-align: center;
		}
		table {
		
			margin-left: auto; 
			margin-right: auto;
		}
		div{
			margin-left: 25%;
		}
		.Agua{
			background-color: blue;
		}
		
		.Barco{
			background-color: red;
		}
	</style>
</head>
<body>
	<div>
		<h1>Hundir la Flota</h1>
		
		<%
			String[] letras = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N",
					 "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
			Partida partida = (Partida) request.getAttribute("Partida");
			int NUMFILAS = (Integer) request.getAttribute("filas");
			int NUMCOLUMNAS = (Integer) request.getAttribute("columnas");
			int NUMBARCOS = (Integer) request.getAttribute("barcos");
			
			
			out.print("Solucion PARTIDA");
			out.print("<br/>Barcos navegando: "+partida.barcosQueQuedan()+"<br/>Barcos hundidoa: "+(NUMBARCOS-partida.barcosQueQuedan()));
			out.print("<br/>N�mero de disparos efectuados: "+partida.getNumDisparos());
			out.print("</div>");
			out.print("<table>");
			for(int fila = 0; fila<NUMFILAS+1; fila++){
				out.print("<tr>");
				for(int col = 0; col<NUMCOLUMNAS+2; col++){
					out.print("<td width=\"60 px\" class=\""+
							(col>0 && col<NUMCOLUMNAS+1 && fila>0 ? (partida.getCasilla(fila-1, col-1)==-1) ? "Agua" : "Barco":" ")
							+"\">");
					if(fila == 0){
						if (col == 0 || col == NUMCOLUMNAS +1){
							out.print(" ");
						}else{
							out.print(letras[(col-1)%letras.length]);
						}
					}else{
						if (col == 0 || col == NUMCOLUMNAS +1){
							out.print(fila);
						}else{
							// En caso de que se haya disparado no queremos que haya la opci�n de volver a disparar sobre la misma casilla. Para ello la marcamos como readonly.
							out.print(" ");
						}
					}
					out.print("</td>");
				}
				out.print("</tr>");
			}
			out.print("</table>");
		%>
	<div>
		<a href="NuevaPartidaServlet">Nueva Partida</a><br/>
		<a href="">Salir</a>
	</div>
</body>
</html>