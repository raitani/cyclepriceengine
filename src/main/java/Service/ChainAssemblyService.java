/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Dao.ChainAssemblyDao;
import module.ChainAssembly;

/**
 *
 * @author harsh
 */
public class ChainAssemblyService {
    private Long date = null;

	private ChainAssembly chainAssembly = null;

	private ChainAssemblyDao chainAssemblyDAO = null;

	public ChainAssemblyService(Long date, ChainAssembly chainAssembly) {
		this.date = date;
		this.chainAssembly = chainAssembly;
		chainAssemblyDAO = new ChainAssemblyDao();
	}

	public double getPrice() {
		return chainAssembly.getPrice();
	}

	public void calculatePrice() {
		double sizePrice = chainAssemblyDAO.getChainSizePrice(chainAssembly.getChainSize(), date);

		double speedPrice = chainAssemblyDAO.getChainSpeedPrice(chainAssembly.getSpeed(), date);

		double totalPrice = sizePrice + speedPrice;
		chainAssembly.setPrice(totalPrice);
	}
}
