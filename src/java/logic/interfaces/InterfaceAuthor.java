package logic.interfaces;

import java.util.List;
import logic.models.Author;

public interface InterfaceAuthor {

    public boolean saveAuthor();

    public boolean deleteAuthor();

    public boolean updateAuthor();

    public List<Author> listAuthor();

}
