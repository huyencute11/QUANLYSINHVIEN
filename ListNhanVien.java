package bai1TableTH2_TranThiMinhHuyen_34_20105231;

import java.io.Serializable;
import java.util.ArrayList;



public class ListNhanVien implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<NhanVien> danhSachNhanVien;

	public ListNhanVien() {
		super();
		danhSachNhanVien = new ArrayList<NhanVien>();
	}
	
	public boolean themNhanVien(NhanVien nv) {
		if(danhSachNhanVien.contains(nv))
			return false;
		else
			danhSachNhanVien.add(nv);
			return true;
	}
	public String toString() {
		String s = "";
		for (NhanVien nhanVien : danhSachNhanVien) {
			s+= nhanVien.toString() + '\n';
		}
		return s;
	}
	/**
	 * Sua nhan vien
	 * @param id
	 * @param ho
	 * @param ten
	 * @param tuoi
	 * @param gt
	 * @param luong
	 * @return
	 */
	public boolean suaNhanVien(String id, String ho, String ten, int tuoi, boolean gt, double luong) {
		for (NhanVien nhanVien : danhSachNhanVien) {
			if(nhanVien.getManv().equalsIgnoreCase(id)) {
				nhanVien.setHo(ho);
				nhanVien.setTen(ten);
				nhanVien.setTuoi(tuoi);
				nhanVien.setPhai(gt);
				nhanVien.setLuong(luong);
				return true;
			}
			
		}
		return false;
	}
	public boolean xoaNhanVien(String id) {
		NhanVien nv = new NhanVien(id);
		if(danhSachNhanVien.contains(nv)) {
			danhSachNhanVien.remove(nv);
			return true;
		}
		return false;
	}
	public int timKiemNhanVien(String id) {
		for(int i = 0; i< danhSachNhanVien.size(); i++) {
			if(danhSachNhanVien.get(i).getManv().equalsIgnoreCase(id))
				return i;      
		}                                                                                                                                                                                                                                                                                                                                                    
		return -1;
	}
	public ArrayList<NhanVien> getDSNV() {
		return danhSachNhanVien;
	}
	public void setDanhSachNhanVien(ArrayList<NhanVien> danhSachNhanVien) {
		this.danhSachNhanVien = danhSachNhanVien;
	}
	
	
	public NhanVien getElement(int index) {
		if(index < 0 || index >= danhSachNhanVien.size())
			return null;
		else
			return danhSachNhanVien.get(index);
	}

	public ArrayList<NhanVien> getDanhSachNhanVien() {
		return danhSachNhanVien;
	}
	public int getSize() {
		return danhSachNhanVien.size();
	}
	
}
