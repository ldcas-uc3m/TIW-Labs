package beans;

import java.io.Serializable;

public class ShoppingCart implements Serializable {

	int numProds;
	float price;

	public ShoppingCart(int numProds, float price) {
		super();
		this.numProds = numProds;
		this.price = price;
	}

	public int getNumProds() {
		return numProds;
	}

	public void setNumProds(int numProds) {
		this.numProds = numProds;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
}
