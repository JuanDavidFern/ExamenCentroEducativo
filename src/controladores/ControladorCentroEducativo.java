package controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelos.CentroEducativo;



public class ControladorCentroEducativo {
	private static Connection conn = null;
	
	public static CentroEducativo cargarPrimerRegistro() {

		try {
			conn = controladores.ConnectionManagerV1.getConexion();
			CentroEducativo ce = null;
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM centroeducativo.centroeducativo order by id limit 1");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

				ce = new CentroEducativo();
				ce.setId(rs.getInt(1));
				ce.setDescripcion(rs.getString(2));

				rs.close();
				ps.close();
				conn.close();
				return ce;
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
	public static CentroEducativo cargarSiguienteRegistro(CentroEducativo ce) {
		try {
			conn = controladores.ConnectionManagerV1.getConexion();

			PreparedStatement ps = conn.prepareStatement(
					"select * from centroeducativo.materia where id > " + ce.getId() + " order by id limit 1");
			ResultSet rs = ps.executeQuery();
			CentroEducativo ce2 = new CentroEducativo();
			if (rs.next()) {

				ce2.setId(rs.getInt(1));
				ce2.setDescripcion(rs.getString(2));
				
				rs.close();
				ps.close();
				conn.close();
				return ce2;

			}
			rs.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	
	public static List<CentroEducativo> findAll() {
		List<CentroEducativo> lc = new ArrayList<CentroEducativo>();
		CentroEducativo ce = cargarPrimerRegistro();
		do {
			lc.add(ce);
			ce = cargarSiguienteRegistro(ce);
		} while (ce != null);
		return lc;
	}
}
