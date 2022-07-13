
package logic.interfaces;

import java.util.List;
import logic.models.Category;


public interface InterfaceCategory {
    
    public boolean saveCategory();

    public boolean deleteCategory();

    public boolean updateCategory();

    public List<Category> listCategory();
    
}
