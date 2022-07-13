package logic.models;

import java.util.List;
import logic.interfaces.InterfaceBook;
import persistence.db.ConexionBD;

public class Book implements InterfaceBook {

    private String isbn;
    private String name;
    private long numPages;
    private int annio;
    private String codAuthor;
    private long idCategory;

    public Book() {
    }

    public Book(String isbn, String name, long numPages, int annio, String codAuthor, long idCategorie) {
        this.isbn = isbn;
        this.name = name;
        this.numPages = numPages;
        this.annio = annio;
        this.codAuthor = codAuthor;
        this.idCategory = idCategorie;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String _isbn) {
        this.isbn = _isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String _name) {
        this.name = _name;
    }

    public long getNumPages() {
        return numPages;
    }

    public void setNumPages(long _numPages) {
        this.numPages = _numPages;
    }

    public int getAnnio() {
        return annio;
    }

    public void setAnnio(int _annio) {
        this.annio = _annio;
    }

    public String getCodAuthor() {
        return codAuthor;
    }

    public void setCodAuthor(String _codAuthor) {
        this.codAuthor = _codAuthor;
    }

    public long getIdCategorie() {
        return idCategory;
    }

    public void setIdCategorie(long _idCategorie) {
        this.idCategory = _idCategorie;
    }

    @Override
    public boolean saveBook() {
        boolean isOk = false;
        ConexionBD dataBase = ConexionBD.getInstance();
        String sqlSentence = "INSERT INTO libros"
                + "(isbn, nombre, numeroDePaginas,"
                + " annio, codigoAutor, idCategoria)"
                + "VALUES("
                + "'" + this.isbn + "', "
                + "'" + this.name + "', "
                + "" + String.valueOf(this.numPages) + ", "
                + "" + String.valueOf(this.annio) + ", "
                + "'" + this.codAuthor + "', "
                + "" + String.valueOf(this.idCategory) + ""
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
    public boolean deleteBook() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateBook() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Book> listBook() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
