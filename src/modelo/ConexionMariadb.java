package modelo;

import java.sql.*;

/**
 * Programa con métodos set y get para abrir y cerrar la conexión a la base de
 * datos
 *
 * @author Walter Ismael Sagástegui Lescano
 * @author sagastegui@hotmail.es
 * @version 1
 */
public class ConexionMariadb {

    private static Connection conexion;

    /**
     * Datos necesarios para realizar la conexion a la base de datos
     */
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String SERVERNAME = "localhost"; //"127.0.0.1";
    private static final String PORT = "3306";
    private static final String DATABASE = "factoria";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    /**
     * Direccion url en mi servidor mysql a la base de datos
     */
    private static final String URL = "jdbc:mysql://" + SERVERNAME + ":" + PORT + "/" + DATABASE + "?autoReconnect=true&useSSL=false";

    /**
     * Constructor crea una instancia de BaseDAtos sin conexión
     */
    public ConexionMariadb() {
        setConexion(false);
    }

    /**
     * Constructor crea una instancia de BaseDAtos con o sin conexión
     *
     * @param flag recibe un true o false si se desea crear una instancia de
     * BaseDatos con o sin conexion
     */
    public ConexionMariadb(boolean flag) {
        setConexion(flag);
    }

    /**
     * Metodo para abrir(flag=true) o cerrar(flag=false) la conexion a la base
     * de datos
     *
     * @param flag recibe un true o false si queremos abrir o cerrar la conexion
     * a la base de datos
     */
    public void setConexion(boolean flag) {
        try {
            if (flag) {
                Class.forName(DRIVER);
                conexion = (Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);
                Statement sql = conexion.createStatement();
                sql.executeUpdate("USE " + DATABASE);
            } else {
                conexion.close();
                conexion = null;
            }
        } catch (Exception e) {
            conexion = null;
        }
    }

    /**
     * Metodo para obtener la conexion a la base de datos
     *
     * @return Connection, implica que retorna un objeto de tipo Connection que
     * tiene la conexion a la base de datos
     */
    public Connection getConexion() {
        return conexion;
    }

}
