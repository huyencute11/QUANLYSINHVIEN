package bai1TableTH2_TranThiMinhHuyen_34_20105231;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;

import java.util.Locale;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.table.DefaultTableModel;

public class GUI extends JFrame implements ActionListener, ItemListener, MouseListener {

	private static final long serialVersionUID = 1L;

	
	private ListNhanVien listNV;
	private DefaultTableModel dfTable;
	private JTable table;

	private JLabel lblMa;
	private JLabel lblHo;
	private JLabel lblTen;
	private JTextField txtHo;
	private JTextField txtTen;
	private JTextField txtTuoi;
	private JCheckBox checkGT;
	private JTextField txtMa;
	private JTextField txtTL;
	private JLabel lblTL;

	private JTextField txtNhap;
	private JButton btnTim;
	private JButton btnThem;
	private JButton btnXoa;
	private JButton btnXoaTrang;
	private JButton btnLuu;


	private JButton btnSua;

	public GUI() {
		showWindow();
		addControl();
		addEvent();
//		addData();
	}

	public void showWindow() {
		setTitle("Jtable demo");
		setSize(850, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
	}

	public void addControl() {
		// pnNorth
		JPanel pnNorth = new JPanel();
		pnNorth.setLayout(new BoxLayout(pnNorth, BoxLayout.Y_AXIS));

		JPanel pnNorthT = new JPanel();
		JLabel lblTitle = new JLabel("THONG TIN NHAN VIEN");
		Font f = new Font("Arial", Font.BOLD, 22);
		lblTitle.setFont(f);
		lblTitle.setForeground(Color.blue);
		pnNorthT.add(lblTitle);
		pnNorthT.setBackground(Color.gray);
		pnNorth.add(pnNorthT);

		JPanel pnMa = new JPanel();
		pnMa.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		lblMa = new JLabel("Ma nhan vien");
		txtMa = new JTextField(70);
		pnMa.add(lblMa);
		pnMa.add(txtMa);
		pnNorth.add(pnMa);

		JPanel pnHoTen = new JPanel();
		pnHoTen.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));
		lblHo = new JLabel("Ho");
		txtHo = new JTextField(30);
		pnHoTen.add(lblHo);
		pnHoTen.add(txtHo);
		lblTen = new JLabel("Ten nhan vien");
		txtTen = new JTextField(30);
		lblHo.setPreferredSize(lblMa.getPreferredSize());
		pnHoTen.add(lblTen);
		pnHoTen.add(txtTen);
		pnNorth.add(pnHoTen);

		JPanel pnTuoiGt = new JPanel();
		pnTuoiGt.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		JLabel lblTuoi = new JLabel("Tuoi");
		lblTuoi.setPreferredSize(lblMa.getPreferredSize());
		txtTuoi = new JTextField(50);
		pnTuoiGt.add(lblTuoi);
		pnTuoiGt.add(txtTuoi);
		JLabel lblGT = new JLabel("Gioi tinh");
		lblGT.setPreferredSize(lblMa.getPreferredSize());
		checkGT = new JCheckBox("Nu");
		pnTuoiGt.add(lblGT);
		pnTuoiGt.add(checkGT);
		pnNorth.add(pnTuoiGt);

		JPanel pnTL = new JPanel();
		pnTL.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		lblTL = new JLabel("Tien luong");
		txtTL = new JTextField(70);
		lblTL.setPreferredSize(lblMa.getPreferredSize());
		pnTL.add(lblTL);
		pnTL.add(txtTL);
		pnNorth.add(pnTL);

		add(pnNorth, BorderLayout.NORTH);

		// add table in CENTER

		String[] header = { "Ma", "Ho", "Ten", "Phai", "Tuoi", "Tien Luong" };
		dfTable = new DefaultTableModel(header, 0);
		table = new JTable(dfTable);
		this.add(new JScrollPane(table), BorderLayout.CENTER);
		table.setRowHeight(20);

		JPanel pnSouth = new JPanel();
		JPanel pnSouthL = new JPanel();
		JLabel lblNhap = new JLabel("Nhap ma so can tim");
		txtNhap = new JTextField(15);
		btnTim = new JButton("Tim");
		pnSouthL.add(lblNhap);
		pnSouthL.add(txtNhap);
		pnSouthL.add(btnTim);
		pnSouth.add(pnSouthL);

		JToolBar tbar = new JToolBar();
		JPanel pnSouthR = new JPanel();
		btnThem = new JButton("Them");
		btnXoaTrang = new JButton("XoaTrang");
		btnLuu = new JButton("Luu");
		btnXoa = new JButton("Xoa");
		btnSua = new JButton("Sua");
		pnSouthR.add(btnThem);
		pnSouthR.add(btnXoaTrang);
		pnSouthR.add(btnLuu);
		pnSouthR.add(btnXoa);
		pnSouthR.add(btnSua);
		tbar.add(pnSouthR);
		pnSouth.add(tbar);

		add(pnSouth, BorderLayout.SOUTH);
		listNV = new ListNhanVien();
		LuuTru l =new LuuTru();
		try {
			listNV = (ListNhanVien) l.DocFile("src/bai1TableTH2_TranThiMinhHuyen_34_20105231/NhanVien.txt");
		} catch (Exception e) {
			System.out.print("KHONG TIM THẤY");
		}
		
//		NhanVien nv1 = new NhanVien("001", "Tran Minh ", "Huyen", 20, true, 2000000);
//		NhanVien nv2 = new NhanVien("002", "Le Minh", "Tu", 20, false, 1500000);
//		NhanVien nv3 = new NhanVien("003", "Hoang ", "Mai", 21, true, 1000000);
//		NhanVien nv4 = new NhanVien("004", "Nguyen Minh ", "Quan", 22, false, 2500000);
//
//		listNV.themNhanVien(nv1);
//		listNV.themNhanVien(nv2);
//		listNV.themNhanVien(nv3);
//		listNV.themNhanVien(nv4);
		docDuLieuTuArrayVaoListModel();
		
		
	}
	
	public void addEvent() {
		btnTim.addActionListener(this);
		btnThem.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		btnLuu.addActionListener(this);
		btnXoa.addActionListener(this);
		btnSua.addActionListener(this);
		table.addMouseListener(this);
		checkGT.addItemListener(this);
		txtHo.addActionListener(this);
		txtTen.addActionListener(this);
		txtTL.addActionListener(this);
		txtTuoi.addActionListener(this);
		txtMa.addActionListener(this);
		txtNhap.addActionListener(this);
	}
	public String[] layDuLieu(NhanVien nv) {
		String phai = "";
		if (nv.getPhai()) {
			phai = "Nữ";
		} else {
			phai = "Nam";
		}
	
		String[] row1 = { nv.getManv().trim(), nv.getHo().trim(), nv.getTen().trim(), phai, "" + nv.getTuoi(), nv.getLuong() + "" };
		return row1;
	}
	
	public void docDuLieuTuArrayVaoListModel() {
		for (int i = 0; i < listNV.getSize(); i++) {
			String[] row1 = layDuLieu(listNV.getElement(i));
			dfTable.addRow(row1);

		}
	}

	public static void main(String[] args) {
		new GUI().setVisible(true);
	}


	public void ThemNv() {
		boolean phai = true;
		if (checkGT.isSelected()) {
			phai = true;
		} else {
			phai = false;
		}
		NhanVien n1 = new NhanVien(txtMa.getText(), txtHo.getText(), txtTen.getText(),
				Integer.parseInt(txtTuoi.getText()), phai, Double.parseDouble(txtTL.getText()));
	
		

//		Neu them trung ma
		if (!listNV.themNhanVien(n1)) {
			JOptionPane.showMessageDialog(this, "TRÙNG MÃ NV");
		} else {
		
			listNV.themNhanVien(n1);
			System.out.println(listNV);
			dfTable.addRow(layDuLieu(n1));
			txtMa.setText("");
			txtHo.setText("");
			txtTen.setText("");
			txtTuoi.setText("");
			checkGT.setSelected(false);
			txtTL.setText("");
			txtMa.requestFocus();
		}
	}

	/**
	 * xoa tat ca cac row tren table
	 */
	public void XoaHetDLTrenTableMoDel() {
//		while (dfTable.getRowCount() > 0) {
//			dfTable.removeRow(0);
//		}
		DefaultTableModel dm = (DefaultTableModel) table.getModel();
		dm.getDataVector().removeAllElements();

	}

	// xoa trang
	public void xoaTrang() {
		txtMa.setText("");
		txtHo.setText("");
		txtTen.setText("");
		txtTL.setText("");
		txtTuoi.setText("");
	}

	/**
	 * tim kiem mot nhan vien
	 */
	public void timKiem() {
		String id = txtNhap.getText();
		if (id != null && id.trim().length() > 0) {
			int pos = listNV.timKiemNhanVien(id);
			if (pos != -1) { // tim thay thi xoa het dl tren giao dien table
				NhanVien nv = listNV.getElement(pos);
				XoaHetDLTrenTableMoDel();
				String[] rowTimDuoc = layDuLieu(nv);
				dfTable.addRow(rowTimDuoc);
			} else {
				XoaHetDLTrenTableMoDel();
				docDuLieuTuArrayVaoListModel();
				table.setModel(dfTable);
				JOptionPane.showMessageDialog(this, "Khong tim thay");
				txtNhap.requestFocus();
			}
		} else {
			JOptionPane.showMessageDialog(this, "Chua nhap ma can tim");
			txtNhap.requestFocus();
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			Object o = e.getSource();
			if (o.equals(btnThem)) {
				if (txtMa.getText().equals("") || txtHo.getText().equals("") || txtTen.getText().equals("")
						|| txtTuoi.getText().equals("") || txtTL.getText().equals(""))
					JOptionPane.showMessageDialog(this, "Phai nhap du lieu truoc.");
				else {
					ThemNv();
				}
			} else if (o.equals(btnXoa)) {

				int vt = table.getSelectedRow();
				dfTable.removeRow(vt);
				System.out.println("vị trí "+vt);
				xoaTrang();
				NhanVien nv = listNV.getElement(vt);
				listNV.xoaNhanVien(nv.getManv());
				System.out.println("nhan vien can xoa "+nv.getManv());
				System.out.println("Danh sach sau khi xoa");
				System.out.println(nv.getManv());
				System.out.println("-----");
				System.out.println(listNV);
				System.out.println("-----");
			} else if (o.equals(btnTim)) {
				timKiem();
				
			} else if (o.equals(txtNhap)) {
				timKiem();
			}

			else if (o.equals(btnXoaTrang)) {
				xoaTrang();
//				int i = table.getSelectedRow();
				
			}
			else if(o.equals(btnLuu)) {
				LuuTru l = new LuuTru();
				try {
					l.LuuFile(listNV, "src/bai1TableTH2_TranThiMinhHuyen_34_20105231/NhanVien.txt");
					System.out.println("Lưu thanh cong");
					JOptionPane.showMessageDialog(this, "Lưu thành công");
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				
			}
//			Su kien voi cac o text
			else if (o.equals(txtMa)) {
				if (!txtMa.getText().equals("")  && !txtMa.getText().trim().equals("") )
					txtHo.requestFocus();
				else {
					JOptionPane.showMessageDialog(this, "Không được phép rỗng");
				}
			} else if (o.equals(txtHo)) {
				if (!txtHo.getText().equals("")  && !txtHo.getText().trim().equals("") )
					txtTen.requestFocus();
				else {
					JOptionPane.showMessageDialog(this, "Không được phép rỗng");
				}
			} else if (o.equals(txtTen)) {
				if (!txtTen.getText().equals("")  && !txtTen.getText().trim().equals("") )
					txtTuoi.requestFocus();
				else {
					JOptionPane.showMessageDialog(this, "Không được phép rỗng");
				}
			} else if (o.equals(txtTuoi)) {
				if (!txtTuoi.getText().equals("") && !txtTuoi.getText().trim().equals("") 
						&& Integer.parseInt(txtTuoi.getText()) >=20 && Integer.parseInt(txtTuoi.getText()) <= 55)
					txtTL.requestFocus();
				else
					JOptionPane.showMessageDialog(this, "Tuổi liệu không hợp lệ");
			} else if (o.equals(txtTL)) {
				if (!txtTL.getText().equals("")  && !txtTL.getText().trim().equals("") && Double.parseDouble(txtTL.getText()) > 0)
					ThemNv();
				else
					JOptionPane.showMessageDialog(this, "Lương > 0 và không được rỗng");
			}
			
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(this, "Du lieu kh hợp lệ.");
		}
		//

	}

	@Override
	public void itemStateChanged(ItemEvent e) {

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// them 1 row vao dftable => dung de sua
		int row = table.getSelectedRow();
		txtMa.setText(table.getValueAt(row, 0).toString());
		txtHo.setText(table.getValueAt(row, 1).toString());
		txtTen.setText(table.getValueAt(row, 2).toString());
		
		checkGT.setSelected(dfTable.getValueAt(row, 3).toString() == "Nữ" ? true : false);
		txtTuoi.setText(table.getValueAt(row, 4).toString());
		txtTL.setText(table.getValueAt(row, 5).toString());
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
