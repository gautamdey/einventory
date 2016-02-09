package com.technath.einventory.service;

import org.hibernate.SessionFactory;

public class ShipmentServiceImpl implements ShipmentService{
	 private SessionFactory sessionFactory;
     
	    public void setSessionFactory(SessionFactory sf){
	        this.sessionFactory = sf;
	    }
	@Override
	public void receiveShipment(int poId, String[] poItems) {
		// TODO Auto-generated method stub
		
	}

}
