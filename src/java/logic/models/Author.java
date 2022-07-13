package logic.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logic.interfaces.InterfaceAuthor;
import persistence.db.ConexionBD;

public class Author implements InterfaceAuthor {

    private String code;
    private String name;
    private String nationality;

    public Author() {
    }

    public Author(String code, String name, String nationality) {
        this.code = code;
        this.name = name;
        this.nationality = nationality;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public boolean saveAuthor() {
        boolean isOk = false;
        ConexionBD dataBase = ConexionBD.getInstance();
        String sqlSentence = "INSERT INTO autores "
                + "(codigo, nombre, nacionalidad)"
                + "VALUES("
                + "'" + this.code + "',"
                + "'" + this.name + "',"
                + "'" + this.nationality + "'"
                + ");";

        if (dataBase.setAutoCommitBD(false)) {
            if (dataBase.insertarBD(sqlSentence)) {
                dataBase.commitBD();
                
                isOk = true;
            } else {
                dataBase.rollbackBD();
                
            }
        } else {
            
        }

        return isOk;

    }

    @Override
    public boolean deleteAuthor() {
        boolean isOk = false;
        ConexionBD dataBase = ConexionBD.getInstance();
        String sqlSentence = "DELETE FROM autores WHERE codigo = '"+this.code+"';";

         if (dataBase.setAutoCommitBD(false)) {
            if (dataBase.borrarBD(sqlSentence)) {
                dataBase.commitBD();
                
                isOk = true;
            } else {
                dataBase.rollbackBD();
                
            }
        } else {
            
        }
        
        return  isOk;
     }

    @Override
    public boolean updateAuthor() {
        boolean isOk = false;
        ConexionBD dataBase = ConexionBD.getInstance();
        String sqlSentence = "UPDATE autores SET "
                + "nombre='" + this.name + "', "
                + "nacionalidad='" + this.nationality + "'"
                + "WHERE codigo='" + this.code + "';";

        if (dataBase.setAutoCommitBD(false)) {
            if (dataBase.actualizarBD(sqlSentence)) {
                dataBase.commitBD();
                
                isOk = true;
            } else {
                dataBase.rollbackBD();
                
            }
        } else {
            
        }
        return isOk;

    }

    @Override
    public List<Author> listAuthor() {

        List<Author> authors = new ArrayList<>();
        ConexionBD dataBase = ConexionBD.getInstance();
        String sqlSentence = "SELECT * FROM autores;";

        try {

            ResultSet results = dataBase.consultarBD(sqlSentence);

            Author author;
            while (results.next()) {
                author = new Author();
                author.setCode(results.getString("codigo"));
                author.setName(results.getString("nombre"));
                author.setNationality(results.getString("nacionalidad"));
                authors.add(author);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Author.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            
        }

        return authors;
    }

    @Override
    public String toString() {
        return "Author{" + "code=" + code + ", name=" + name + ", nationality=" + nationality + '}';
    }

    
    
}
