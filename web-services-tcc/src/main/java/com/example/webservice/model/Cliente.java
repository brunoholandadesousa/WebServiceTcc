package com.example.webservice.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Cliente implements Serializable {
	private static final long serialVersionUID = 4076144634050904733L;
	private int id;
	private double longitude;
	private double latitude;
	private String data;
	private int id_dispositivos;
	
	public Cliente() {
		
	}

	public Cliente(double longitude, double latitude, String data) {		
		this.longitude = longitude;
		this.latitude = latitude;
		this.data = data;
	}
	public Cliente(int id,double longitude, double latitude, String data) {		
		this.longitude = longitude;
		this.latitude = latitude;
		this.data = data;
		this.id = id;
	}
	public Cliente(int id_dispositivos,int id) {		
		this.id_dispositivos = id_dispositivos;
		this.id = id;
	}

	public Cliente(int id) {		
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}	

	public int getId_dispositivos() {
		return id_dispositivos;
	}

	public void setId_dispositivos(int id_dispositivos) {
		this.id_dispositivos = id_dispositivos;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Override
	public String toString() {
		System.out.println(id_dispositivos);
		return "Cliente [id=" + id +", longitude=" + longitude + ", latatitude=" + latitude + ", data=" + data + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + id;
		long temp;
		temp = Double.doubleToLongBits(latitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(longitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (id != other.id)
			return false;
		if (Double.doubleToLongBits(latitude) != Double.doubleToLongBits(other.latitude))
			return false;
		if (Double.doubleToLongBits(longitude) != Double.doubleToLongBits(other.longitude))
			return false;
		return true;
	}

}