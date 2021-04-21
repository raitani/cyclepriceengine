/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package module;

/**
 *
 * @author harsh
 */
public class Handle {
    private String type;
	
	private boolean shockLock;
	
	private Double price;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isShockLock() {
		return shockLock;
	}

	public void setShockLock(boolean shockLock) {
		this.shockLock = shockLock;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
}
