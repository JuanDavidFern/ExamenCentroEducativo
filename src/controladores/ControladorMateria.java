package controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import modelos.Materia;
import modelos.Nivel;

public class ControladorMateria {
	private static Connection conn = null;
	
	public static void update(Materia mat) throws NumberFormatException, SQLException, ParseException {
		conn = controladores.ConnectionManagerV1.getConexion();
		PreparedStatement ps = conn.prepareStatement(
				"update centroeducativo.materia set nombre = ?, codigo = ?, urlClassroom = ?, admiteMatricula = ? where id =" + mat.getId());

		ps.setString(1, mat.getNombre());
		ps.setString(2, mat.getCodigo());
		ps.setString(3, mat.getUrl());
		ps.setBoolean(4, mat.isAdmiteMatricula());


		ps.executeUpdate();

		ps.close();
		conn.close();

	}
	
	
	public static List<Materia> cargarNiveles(int id) {
		List<Materia> lc = new ArrayList<Materia>();
		try {
			conn = controladores.ConnectionManagerV1.getConexion();

			PreparedStatement ps = conn.prepareStatement(
					"SELECT * FROM centroeducativo.materia where idNivel = " + id);
			ResultSet rs = ps.executeQuery();
			Materia m = null;
			while (rs.next()) {
				m = new Materia();
				m.setId(rs.getInt(1));
				m.setNombre(rs.getString(2));
				Nivel n = new Nivel(); 
				n.setId(rs.getInt(3));
				m.setNivel(n);
				m.setCodigo(rs.getString(4));
				m.setUrl(rs.getString(5));
				m.setAdmiteMatricula(rs.getBoolean(6));
				m.setFechaInicio(rs.getDate(7));
				
				lc.add(m);

				
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
