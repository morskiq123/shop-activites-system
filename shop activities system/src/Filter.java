import java.util.Comparator;

public class Filter implements Comparator<Product> {

	@Override
	public int compare(Product product1, Product product2) {
		if (product1.getQuantity() < product2.getQuantity()) {
			return 1;
		}if (product1.getQuantity() > product2.getQuantity()) {
			return -1;
		}else{
			return 0;
		}
	}
}
