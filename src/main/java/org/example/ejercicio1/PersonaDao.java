package org.example.ejercicio1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class PersonaDao {
    public static final String queryRecuperarPersonaConTelefonosPorId =
            "select p.nombre,t.numero " +
                    "from personas p, telefonos t " +
                    "where p.id = t.idpersona and p.id = ?";

    public static final String queryObtenerTelefonosPorIdPersonal =
            "select t.numero from telefonos t where t.id = ?";

    public Persona personaPorId(int id) {
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement statement =
                     conn.prepareStatement(queryRecuperarPersonaConTelefonosPorId);) {
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            Set<Telefono> telefonos = new HashSet<Telefono>();
            String nombrePersona = null;
            while (result.next()) {
                nombrePersona = result.getString(1);
                telefonos.add(new Telefono(result.getString(2)));
            }
            return new Persona(id, nombrePersona, new TelefonoProxy(id, this));
        }
        catch(SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            ConnectionManager.disconnect();
        }
    }
    public Set<Telefono> telefonosDePersona (int id) {
        try (Connection conn =ConnectionManager.getConnection(); PreparedStatement statement =conn.prepareStatement(queryObtenerTelefonosPorIdPersonal);) {
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            Set<Telefono> telefonos = new HashSet<>();
            while (result.next()) {
                telefonos.add(new Telefono(result.getString(1)));
            }return telefonos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
