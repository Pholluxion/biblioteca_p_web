package logic.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistence.db.ConexionBD;
import logic.interfaces.InterfaceCategory;

public class Category implements InterfaceCategory {

    private long id;
    private String name;
    private String description;

    public Category() {
    }

    public Category(long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Category{" + "id=" + id + ", name=" + name + ", description=" + description + '}';
    }

    @Override
    public boolean saveCategory() {

        boolean isOk = false;
        ConexionBD dataBase = ConexionBD.getInstance();
        String sqlSentence = "INSERT INTO categorias "
                + "(nombre, descripcion) "
                + " VALUES('" + this.name + "', '" + this.description + "');";

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
    public boolean deleteCategory() {

        boolean isOk = false;
        ConexionBD dataBase = ConexionBD.getInstance();
        String sqlSentence = "DELETE FROM categorias WHERE idCategoria = '" + this.id + "';";

        if (dataBase.setAutoCommitBD(false)) {
            if (dataBase.borrarBD(sqlSentence)) {
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
    public boolean updateCategory() {
        boolean isOk = false;
        ConexionBD dataBase = ConexionBD.getInstance();
        String sqlSentence = "UPDATE categorias SET "
                + "nombre='" + this.name + "', "
                + "descripcion='" + this.description + "'"
                + "WHERE idCategoria='" + this.id + "';";

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
    public List<Category> listCategory() {
        List<Category> categories = new ArrayList<>();
        ConexionBD dataBase = ConexionBD.getInstance();
        String sqlSentence = "SELECT * FROM categorias;";

        try {

            ResultSet results = dataBase.consultarBD(sqlSentence);

            Category category;
            while (results.next()) {
                category = new Category();
                category.setId(results.getInt("idCategoria"));
                category.setName(results.getString("nombre"));
                category.setDescription(results.getString("descripcion"));
                categories.add(category);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Author.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

        }

        return categories;
    }

}
