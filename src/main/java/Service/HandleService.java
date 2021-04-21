/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Dao.HandleDao;
import module.Handle;

/**
 *
 * @author harsh
 */
public class HandleService {
    private Long date = null;

	private Handle handle = null;

	private HandleDao handleDAO = null;

	public HandleService(Long date, Handle handle) {
		this.date = date;
		this.handle = handle;
		handleDAO = new HandleDao();
	}

	public double getPrice() {
		return handle.getPrice();
	}

	public void calculatePrice() {
		double spokePrice = handleDAO.getHandlePrice(handle.getType(), date);

		double shockLockPrice = handleDAO.getShocklockPrice(handle.isShockLock(), date);
		double totalPrice = spokePrice + shockLockPrice;
		handle.setPrice(totalPrice);
	}
}
