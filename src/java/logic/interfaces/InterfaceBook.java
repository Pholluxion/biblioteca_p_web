/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.interfaces;

import java.util.List;
import logic.models.Book;

/**
 *
 * @author CENTIC
 */
public interface InterfaceBook {
        
    public boolean saveBook();

    public boolean deleteBook();

    public boolean updateBook();

    public List<Book> listBook();
}
