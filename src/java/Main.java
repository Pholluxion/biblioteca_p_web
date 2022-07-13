
import java.util.List;
import logic.models.Author;
import persistence.db.ConexionBD;


public class Main {


    public static void main(String[] args) {
       
        
        Author author = new Author("123456","Daniel","Colombiano");
        //author.saveAuthor();
        
        Author authorDos = new Author("654321","Juancho","Colombiano");
        //authorDos.saveAuthor();

         Author author3 = new Author("11111","Carlos","Colombiano");
        
         //author3.saveAuthor();
         author3.setName("Lucas");
         author3.updateAuthor();
        
         author.deleteAuthor();
        
        List<Author> lista =  author.listAuthor();
        
        for (Author author1 : lista) {
            System.out.println(author1.toString());
        }
        
         ConexionBD dataBase = ConexionBD.getInstance();
        dataBase.cerrarConexion();
      
        
    }
    
}
