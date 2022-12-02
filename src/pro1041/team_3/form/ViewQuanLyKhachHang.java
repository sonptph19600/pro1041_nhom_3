package pro1041.team_3.form;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pro1041.team_3.domainModel.KhachHang;
import pro1041.team_3.dto.KhachHangDto;
import pro1041.team_3.service.impl.KhachHangServiceImpl;

/**
 *
 * @author hanhltph27725
 */
public class ViewQuanLyKhachHang extends javax.swing.JPanel {

    private KhachHangServiceImpl khachHangServiceImpl;

    public ViewQuanLyKhachHang() {
        initComponents();
        khachHangServiceImpl = new KhachHangServiceImpl();
        loadTable(khachHangServiceImpl.getAll());
        tblKhachHang.fixTable(jScrollPane1);
    }

    private void clear() {
        txtMa.setText("");
        txtTen.setText("");
        txtTim.setText("");
        txtNgaySinh.setText("");
        txtEmail.setText("");
        txtSdt.setText("");
        txtDiaChi.setText("");
    }

    private void loadTable(ArrayList<KhachHangDto> lst) {
        DefaultTableModel dtm = (DefaultTableModel) tblKhachHang.getModel();
        dtm.setRowCount(0);
        int index = 1;
        for (KhachHangDto x : lst) {
            Object[] rowData = {
                index++,
                x.getMa(),
                x.getHoTen(),
                x.getGioiTinh() == 0 ? "Nam" : "Nữ",
                x.getNgaySinh(),
                x.getDiaChi().equals("") ? "-" : x.getDiaChi(),
                x.getSdt(),
                x.getEmail(),};
            dtm.addRow(rowData);
        }
    }

    private KhachHang getFormData() {
        UUID id = UUID.randomUUID();
        String ma = txtMa.getText().trim();
        String hoTen = txtTen.getText().trim();
        String ngaySinh = txtNgaySinh.getText().trim();
        String diaChi = txtDiaChi.getText().trim();
        String sdt = txtSdt.getText().trim();
        String email = txtEmail.getText().trim();
        Integer gioiTinh = rdoNam.isSelected() ? 0 : 1;
        Date ngay = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if (ngaySinh.length() == 0) {
            JOptionPane.showMessageDialog(this, "Ngày sinh không được trống");
            return null;
        }
        try {
            ngay = sdf.parse(ngaySinh);
        } catch (ParseException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Không đúng định dạng ngày");
            return null;
        }
        KhachHang khachHang = new KhachHang(id, ma, hoTen, ngay, gioiTinh, sdt, diaChi, email);
        return khachHang;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        txtMa = new pro1041.team_3.swing.TextField();
        txtTen = new pro1041.team_3.swing.TextField();
        txtDiaChi = new pro1041.team_3.swing.TextField();
        txtEmail = new pro1041.team_3.swing.TextField();
        txtSdt = new pro1041.team_3.swing.TextField();
        jpnNamNu = new javax.swing.JPanel();
        rdoNam = new pro1041.team_3.swing.RadioButtonCustom();
        rdoNu = new pro1041.team_3.swing.RadioButtonCustom();
        txtNgaySinh = new pro1041.team_3.swing.TextField();
        jPanel7 = new javax.swing.JPanel();
        btnTimKiem = new javax.swing.JLabel();
        txtTim = new pro1041.team_3.swing.TextField();
        btnClear = new pro1041.team_3.swing.ButtonCustom();
        btnSua = new pro1041.team_3.swing.ButtonCustom();
        btnThem = new pro1041.team_3.swing.ButtonCustom();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKhachHang = new pro1041.team_3.swing.config.Table();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtMa.setEditable(false);
        txtMa.setFont(new java.awt.Font("Nunito", 0, 12)); // NOI18N
        txtMa.setLabelText("Mã khách hàng");
        jPanel1.add(txtMa, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 260, -1));

        txtTen.setFont(new java.awt.Font("Nunito", 0, 12)); // NOI18N
        txtTen.setLabelText("Họ tên");
        jPanel1.add(txtTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 260, -1));

        txtDiaChi.setFont(new java.awt.Font("Nunito", 0, 12)); // NOI18N
        txtDiaChi.setLabelText("Địa chỉ");
        jPanel1.add(txtDiaChi, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 210, 260, -1));

        txtEmail.setFont(new java.awt.Font("Nunito", 0, 12)); // NOI18N
        txtEmail.setLabelText("Email");
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });
        jPanel1.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 210, 260, -1));

        txtSdt.setFont(new java.awt.Font("Nunito", 0, 12)); // NOI18N
        txtSdt.setLabelText("Số điện thoại");
        txtSdt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSdtActionPerformed(evt);
            }
        });
        jPanel1.add(txtSdt, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 120, 260, -1));

        jpnNamNu.setBackground(new java.awt.Color(255, 255, 255));
        jpnNamNu.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray), "Giới tính", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Nunito", 0, 12), new java.awt.Color(3, 155, 216))); // NOI18N
        jpnNamNu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonGroup1.add(rdoNam);
        rdoNam.setText("Nam");
        jpnNamNu.add(rdoNam, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        buttonGroup1.add(rdoNu);
        rdoNu.setText("Nữ");
        jpnNamNu.add(rdoNu, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, -1, -1));

        jPanel1.add(jpnNamNu, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 60, 270, 60));

        txtNgaySinh.setFont(new java.awt.Font("Nunito", 0, 12)); // NOI18N
        txtNgaySinh.setLabelText("Ngày sinh");
        jPanel1.add(txtNgaySinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 120, 260, -1));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray), "Tìm kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(3, 155, 216))); // NOI18N
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnTimKiem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pro1041/team_3/icon/customSearch.png"))); // NOI18N
        btnTimKiem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTimKiemMouseClicked(evt);
            }
        });
        jPanel7.add(btnTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 30, 30, 30));

        txtTim.setFont(new java.awt.Font("Nunito", 0, 12)); // NOI18N
        txtTim.setLabelText("");
        txtTim.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTimCaretUpdate(evt);
            }
        });
        txtTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimActionPerformed(evt);
            }
        });
        jPanel7.add(txtTim, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 320, 40));

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 390, 80));

        btnClear.setBackground(new java.awt.Color(1, 181, 204));
        btnClear.setForeground(new java.awt.Color(255, 255, 255));
        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pro1041/team_3/icon/add.png"))); // NOI18N
        btnClear.setText("Clear");
        btnClear.setFont(new java.awt.Font("Nunito", 1, 14)); // NOI18N
        btnClear.setMaximumSize(new java.awt.Dimension(113, 49));
        btnClear.setMinimumSize(new java.awt.Dimension(113, 49));
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        jPanel1.add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 290, 150, -1));

        btnSua.setBackground(new java.awt.Color(1, 181, 204));
        btnSua.setForeground(new java.awt.Color(255, 255, 255));
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pro1041/team_3/icon/edit.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.setFont(new java.awt.Font("Nunito", 1, 14)); // NOI18N
        btnSua.setMaximumSize(new java.awt.Dimension(113, 49));
        btnSua.setMinimumSize(new java.awt.Dimension(113, 49));
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        jPanel1.add(btnSua, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 290, 150, -1));

        btnThem.setBackground(new java.awt.Color(1, 181, 204));
        btnThem.setForeground(new java.awt.Color(255, 255, 255));
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pro1041/team_3/icon/add.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.setFont(new java.awt.Font("Nunito", 1, 14)); // NOI18N
        btnThem.setMaximumSize(new java.awt.Dimension(113, 49));
        btnThem.setMinimumSize(new java.awt.Dimension(113, 49));
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        jPanel1.add(btnThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 290, 150, -1));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 6, 1110, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh Sách Khách Hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Nunito", 0, 16))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã khách hàng", "Họ tên", "Giới tính", "Ngày sinh", "Địa chỉ", "SĐT", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblKhachHang.setFont(new java.awt.Font("Nunito", 0, 12)); // NOI18N
        tblKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhachHangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblKhachHang);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 1040, 250));

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 1080, 300));
    }// </editor-fold>//GEN-END:initComponents

    private void tblKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhachHangMouseClicked
        // TODO add your handling code here:
        int row = tblKhachHang.getSelectedRow();
        if (row == -1) {
            return;
        }

        String ma = (String) tblKhachHang.getValueAt(row, 1);
        String hoTen = (String) tblKhachHang.getValueAt(row, 2);
        String gioiTinh = (String) tblKhachHang.getValueAt(row, 3);
        Date ngaySinh = (Date) tblKhachHang.getValueAt(row, 4);
        String diaChi = (String) tblKhachHang.getValueAt(row, 5);
        String sdt = (String) tblKhachHang.getValueAt(row, 6);
        String email = (String) tblKhachHang.getValueAt(row, 7);

        txtMa.setText(ma);
        txtTen.setText(hoTen);
        txtNgaySinh.setText(ngaySinh.toString());
        txtDiaChi.setText(diaChi);
        txtSdt.setText(sdt);
        txtEmail.setText(email);
        if (gioiTinh.equals("Nam")) {
            rdoNam.setSelected(true);
        } else {
            rdoNu.setSelected(true);
        }
    }//GEN-LAST:event_tblKhachHangMouseClicked

    private void txtSdtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSdtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSdtActionPerformed

    private void btnTimKiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTimKiemMouseClicked
        // BTN Tìm kiếm sản phẩm
        try {
            loadTable((ArrayList<KhachHangDto>) khachHangServiceImpl.findKhachHang(txtTim.getText().trim()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnTimKiemMouseClicked

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        loadTable(khachHangServiceImpl.getAll());
        clear();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        int row = tblKhachHang.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Mời bạn chọn 1 bản ghi cần sửa");
            return;
        }
        String ma = (String) tblKhachHang.getValueAt(row, 1);
        KhachHang khachHang = getFormData();
        if (khachHang == null) {
            return;
        }
        khachHang.setMa(ma);
        String mess = khachHangServiceImpl.update(khachHang);
        if (mess.equals("Sửa thành công")) {
            loadTable(khachHangServiceImpl.getAll());
            clear();
        }
        JOptionPane.showMessageDialog(this, mess);
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        KhachHang khachHang = getFormData();
        if (khachHang == null) {
            return;
        }
        String mess = khachHangServiceImpl.insert(khachHang);
        if (mess.equals("Thêm thành công")) {
            loadTable(khachHangServiceImpl.getAll());
            clear();
        }
        JOptionPane.showMessageDialog(this, mess);
    }//GEN-LAST:event_btnThemActionPerformed

    private void txtTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimActionPerformed

    private void txtTimCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTimCaretUpdate
        // TODO add your handling code here:
        try {
            loadTable((ArrayList<KhachHangDto>) khachHangServiceImpl.findKhachHang(txtTim.getText().trim()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_txtTimCaretUpdate


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private pro1041.team_3.swing.ButtonCustom btnClear;
    private pro1041.team_3.swing.ButtonCustom btnSua;
    private pro1041.team_3.swing.ButtonCustom btnThem;
    private javax.swing.JLabel btnTimKiem;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jpnNamNu;
    private pro1041.team_3.swing.RadioButtonCustom rdoNam;
    private pro1041.team_3.swing.RadioButtonCustom rdoNu;
    private pro1041.team_3.swing.config.Table tblKhachHang;
    private pro1041.team_3.swing.TextField txtDiaChi;
    private pro1041.team_3.swing.TextField txtEmail;
    private pro1041.team_3.swing.TextField txtMa;
    private pro1041.team_3.swing.TextField txtNgaySinh;
    private pro1041.team_3.swing.TextField txtSdt;
    private pro1041.team_3.swing.TextField txtTen;
    private pro1041.team_3.swing.TextField txtTim;
    // End of variables declaration//GEN-END:variables
}