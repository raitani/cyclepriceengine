/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Dao.FrameDao;
import module.Frame;

/**
 *
 * @author harsh
 */
public class FrameService {
   private Long date = null;

	private Frame frame = null;

	private FrameDao frameDAO = null;

	public FrameService(Long date, Frame wheel) {
		this.date = date;
		this.frame = wheel;
		frameDAO = new FrameDao();
	}

	public double getPrice() {
		return frame.getPrice();
	}

	public void calculatePrice() {
		double spokePrice = frameDAO.getFramePrice(frame.getType(), date);
		double totalPrice = spokePrice;
		frame.setPrice(totalPrice);
	} 
}
