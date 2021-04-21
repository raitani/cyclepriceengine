/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Dao.WheelDao;
import module.Wheel;

/**
 *
 * @author jatin
 */
public class WheelService {
    private Long date = null;

	private Wheel wheel = null;

	private WheelDao wheelDao = null;

	public WheelService(Long date, Wheel wheel) {
		this.date = date;
		this.wheel = wheel;
		wheelDao = new WheelDao();
	}

	public double getPrice() {
		return wheel.getPrice(); 
	}

	public void calculatePrice() {
		double spokePrice = wheelDao.getSpokePrice(wheel.getSpoke(), date);

		double rimPrice = wheelDao.getRimPrice(wheel.getRim(), date);

		double tubePrice = wheelDao.getTubePrice(wheel.getRim(), date);

		double tyrePrice = wheelDao.getTyrePrice(wheel.getRim(), date);

		double totalPrice = spokePrice + rimPrice + tubePrice + tyrePrice;

		wheel.setPrice(totalPrice);

	}
}
