package bai1TableTH2_TranThiMinhHuyen_34_20105231;

import java.io.Serializable;
import java.util.Objects;

public class NhanVien implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String manv;
	private String ho;
	private String ten;
	private int tuoi;
	private Boolean Phai;
	private double luong;

	

	public NhanVien(String ma) {
		this.manv = ma;
	}

	public NhanVien(String manv, String ho, String ten, int tuoi, Boolean phai, double luong) {
		super();
		this.manv = manv;
		this.ho = ho;
		this.ten = ten;
		this.tuoi = tuoi;
		Phai = phai;
		this.luong = luong;
	}

	public String getManv() {
		return manv;
	}

	public void setManv(String manv) {
		this.manv = manv;
	}

	public String getHo() {
		return ho;
	}

	public void setHo(String ho) {
		this.ho = ho;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public int getTuoi() {
		return tuoi;
	}

	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}

	public Boolean getPhai() {
		return Phai;
	}

	public void setPhai(Boolean phai) {
		Phai = phai;
	}

	public double getLuong() {
		return luong;
	}

	public void setLuong(double luong) {
		this.luong = luong;
	}

	@Override
	public int hashCode() {
		return Objects.hash(manv);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhanVien other = (NhanVien) obj;
		return Objects.equals(manv, other.manv);
	}

	@Override
	public String toString() {
		return "NhanVien [manv=" + manv + ", ho=" + ho + ", ten=" + ten + ", tuoi=" + tuoi + ", Phai=" + Phai
				+ ", luong=" + luong + "]";
	}

}
