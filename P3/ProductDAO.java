// V1C - Julian Kunst

package InleverOpdrachten.P3;

public interface ProductDAO {
	public Product save(Product pr);
	
	public Product update(Product pr);
	
	public boolean delete(Product pr);
}
