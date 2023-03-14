package controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelos.CentroEducativo;
import modelos.Nivel;

public class ControladorNivel {
	private static Connection conn = null;
	
	public static List<Nivel> cargarNiveles(int id) {
		List<Nivel> lc = new ArrayList<Nivel>();
		try {
			conn = controladores.ConnectionManagerV1.getConexion();

			PreparedStatement ps = conn.prepareStatement(
					"select * from centroeducativo.nivel where idCentro = " + id);
			ResultSet rs = ps.executeQuery();
			Nivel n = null;
			while (rs.next()) {
				n = new Nivel();
				n.setId(rs.getInt(1));
				n.setDescripcion(rs.getString(2));
				CentroEducativo ce = new CentroEducativo(); 
				ce.setId(rs.getInt(3));
				n.setCentro(ce);
				lc.add(n);

				
			}
			rs.close();
			ps.close();
			conn.close();
			return lc;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
