/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.view;

import demo.dao.DBConnect;
import demo.model.ChiTietXuat;
import demo.model.GlobalData;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MY PC
 */
public class XuatKhoJFrameCreat extends javax.swing.JFrame {

    private List<ChiTietXuat> list = new ArrayList<>();
    private List listmahh = new ArrayList<>();
    private List listsl = new ArrayList<>();
    private DefaultTableModel t = new DefaultTableModel();
    /**
     * Creates new form NewJFrame
     */
    public XuatKhoJFrameCreat() {
        initComponents();
        setTitle("Tạo hóa đơn xuất");
        jtfManv.setText(GlobalData.getId());
        jtfManv.setEditable(false);
        jtfMahh.setEditable(false);
        jtfSoluongcon.setEditable(false);
        initHh();
        initTable();
        jtfMaxuat.setText(setID());
        jtfNgayXuat.setDate(Calendar.getInstance().getTime());
        setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);
    }

//    private void initNv() {
//            Connection cons = DBConnect.getConnection();
//            try {
//                String sql = "select Manv from nhanvien";
//                PreparedStatement ps = cons.prepareCall(sql);
//                ResultSet rs = ps.executeQuery();
//                jcbManv.removeAllItems();
//                while(rs.next()) {
//                    jcbManv.addItem(rs.getString("Manv"));
//                }
//                rs.close();
//                ps.close();
//                cons.close();
//                
//            } catch (Exception e) {
//                JOptionPane.showMessageDialog(this, e.getMessage());
//                e.printStackTrace();
//            }
//    }
        private void initHh() {       
            Connection cons = DBConnect.getConnection();
            try {
                String sql = "select Mahh, Tenhh from hanghoa";
                PreparedStatement ps = cons.prepareCall(sql);
                ResultSet rs = ps.executeQuery();
                jcbTenhh.removeAllItems();
                while(rs.next()) {
                    jcbTenhh.addItem(rs.getString("Tenhh"));
                }              
                rs.close();
                ps.close();
                cons.close();
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
                e.printStackTrace();
            }
    }
     
        private void initTable() {
            String[] column =  new String[]{"Mã xuất","Mã hàng hóa","Số lô","Số lượng"};
            t.setColumnIdentifiers(column);
            jtbChitiet.setModel(t);
        }
            
        private void fillTable() {
            t.setRowCount(0);
            for(ChiTietXuat ctx :list){
                t.addRow(new String[]{ctx.getMaxuat(),ctx.getMahh(),ctx.getSolo(),Integer.toString(ctx.getSoluong())});
            }
            t.fireTableDataChanged();
        }
        
        private String setID() {
            LocalDateTime now = LocalDateTime.now();  
            String id = ("X"+now.getDayOfMonth()+""+now.getMonthValue()+""+now.getHour()+""+now.getMinute()+""+now.getSecond());
            return id;
        }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbChitiet = new javax.swing.JTable();
        jbtSave = new javax.swing.JButton();
        jbtAdd = new javax.swing.JButton();
        jbtUpdate = new javax.swing.JButton();
        jbtDelete = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jtfNgayXuat = new com.toedter.calendar.JDateChooser();
        jtfMaxuat = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtfBennhan = new javax.swing.JTextArea();
        jtfManv = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jcbTenhh = new javax.swing.JComboBox<>();
        jtfSolo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jtfSoluong = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jtfMahh = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jtfSoluongcon = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jtbChitiet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtbChitiet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbChitietMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbChitiet);

        jbtSave.setText("Save");
        jbtSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtSaveActionPerformed(evt);
            }
        });

        jbtAdd.setText("Add");
        jbtAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtAddActionPerformed(evt);
            }
        });

        jbtUpdate.setText("Update");
        jbtUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtUpdateActionPerformed(evt);
            }
        });

        jbtDelete.setText("Delete");
        jbtDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtDeleteActionPerformed(evt);
            }
        });

        jButton1.setText("Close");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hóa đơn xuất", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 0, 51))); // NOI18N

        jLabel2.setText("Ngày xuất");

        jLabel1.setText("Mã xuất kho");

        jLabel3.setText("Mã nhân viên");

        jLabel4.setText("Bên nhận");

        jtfBennhan.setColumns(20);
        jtfBennhan.setRows(5);
        jScrollPane3.setViewportView(jtfBennhan);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtfNgayXuat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtfMaxuat, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3)
                    .addComponent(jtfManv))
                .addGap(40, 40, 40))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfManv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfMaxuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jtfNgayXuat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chi tiết hóa đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 0, 51))); // NOI18N

        jLabel5.setText("Chọn hàng hóa");

        jcbTenhh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbTenhh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbTenhhActionPerformed(evt);
            }
        });

        jLabel6.setText("Số lô");

        jLabel7.setText("Số lượng");

        jtfSoluong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jtfSoluongMouseExited(evt);
            }
        });

        jLabel8.setText("Mã hàng hóa");

        jLabel9.setText("Số lượng còn lại");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jcbTenhh, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtfSoluong, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                                    .addComponent(jtfMahh)
                                    .addComponent(jtfSoluongcon)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jtfSolo, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbTenhh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtfMahh)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jtfSoluongcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfSolo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfSoluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jbtAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbtUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbtDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbtSave, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(92, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(52, 52, 52))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 20, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtSave)
                    .addComponent(jbtAdd)
                    .addComponent(jbtUpdate)
                    .addComponent(jbtDelete))
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtAddActionPerformed
        // TODO add your handling code here:
        ChiTietXuat ctn = new ChiTietXuat();
        if(jtfMaxuat.getText().length() == 0 || jtfBennhan.getText().length() == 0 || jtfSolo.getText().length() == 0 || jtfSoluong.getText().length() == 0){
            JOptionPane.showMessageDialog(this, "Chưa điền đầy đủ thông tin!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
            ctn.setMaxuat(jtfMaxuat.getText());
            ctn.setNgayxuat(jtfNgayXuat.getDate());
            ctn.setManv(jtfManv.getText());
            ctn.setBennhan(jtfBennhan.getText());
            ctn.setMahh(jtfMahh.getText());
            ctn.setSolo(jtfSolo.getText());
            ctn.setSoluong(Integer.valueOf(jtfSoluong.getText()));
            list.add(ctn);
            fillTable();
            jtfSoluong.setText(Integer.toString(0));
            jtfSolo.setText("");
            jtfSoluongcon.setText(Integer.toString(0));
        }        
//        System.out.println(list);          
    }//GEN-LAST:event_jbtAddActionPerformed

    private void jbtSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSaveActionPerformed
        if(jtfMaxuat.getText().length() == 0 || jtfBennhan.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Không thể lưu dữ liệu, vui lòng kiểm tra lại", "Error",JOptionPane.ERROR_MESSAGE);
        }
        else{
            int select = JOptionPane.showConfirmDialog(this, "Save Change ?", "Warning", JOptionPane.YES_NO_OPTION);
            if(select == JOptionPane.NO_OPTION){
                return;
            }
            else{
                try {
                    Connection cons = DBConnect.getConnection();
                    String sqlchitiet = "INSERT INTO chitietxuat(maxuat, mahh, solo, soluong) VALUES(?, ?, ?, ?)";
                    String sql = "INSERT INTO hoadonxuat(maxuat, ngayxuat, manv, bennhan) VALUES(?, ?, ?, ?)";
                    String sqlupdate = "update hanghoa set soluong = soluong - ? where mahh = ?";
                    PreparedStatement ps = cons.prepareStatement(sqlchitiet);
                    PreparedStatement ps2 = cons.prepareStatement(sql);
                    PreparedStatement ps3 = cons.prepareStatement(sqlupdate);
                    for(ChiTietXuat ctx: list) {
                        ps2.setString(1, ctx.getMaxuat());
                        ps2.setDate(2, new Date(ctx.getNgayxuat().getTime()));
                        ps2.setString(3, ctx.getManv());
                        ps2.setString(4, ctx.getBennhan());
                    } 
                    ps2.execute();
                    for(ChiTietXuat ctx: list) {
                        ps.setString(1, ctx.getMaxuat());
                        ps.setString(2, ctx.getMahh());
                        ps.setString(3, ctx.getSolo());
                        ps.setString(4, Integer.toString(ctx.getSoluong())); 
                        ps.execute();
                    } 
                    for(ChiTietXuat ctx: list) {
                        ps3.setString(1, Integer.toString(ctx.getSoluong()));
                        ps3.setString(2, ctx.getMahh());
                        ps3.execute();
                    }
                    ps3.close();
                    ps2.close();
                    ps.close();
                    cons.close();

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, e.getMessage());
                    e.printStackTrace();
                }
                JOptionPane.showMessageDialog(this, "Đã lưu vào CSDL!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
        }
            
    }//GEN-LAST:event_jbtSaveActionPerformed

    private void jtbChitietMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbChitietMouseClicked
        // TODO add your handling code here:
       int selectRow = jtbChitiet.getSelectedRow();
//        System.out.println(selectRow);
        if(selectRow >= 0){
            String id = (String) jtbChitiet.getValueAt(selectRow, 1);
                for(ChiTietXuat ctx: list) {
                    if(id.equals(ctx.getMahh())){
                        jtfMahh.setText(ctx.getMahh());
                        jtfSolo.setText(ctx.getSolo());
                        jtfSoluong.setText(Integer.toString(ctx.getSoluong()));
                        break;
                    }
                }   
        }     
    }//GEN-LAST:event_jtbChitietMouseClicked

    private void jbtUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtUpdateActionPerformed
        
        if(jtfMaxuat.getText().length() == 0 || jtfBennhan.getText().length() == 0 || jtfSolo.getText().length() == 0 || jtfSoluong.getText().length() == 0){
            JOptionPane.showMessageDialog(this, "Chưa điền đầy đủ thông tin!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
        int  choice = JOptionPane.showConfirmDialog(this, "Bạn có muốn cập nhật giá trị?","Warning",JOptionPane.YES_NO_OPTION);
            if(choice == JOptionPane.NO_OPTION){
                return;
            }
            else{
                for(ChiTietXuat ctx:list){
                    if(ctx.getMahh().equals(jtfMahh.getText())){
                    ctx.setMahh(jtfMahh.getText());
                    ctx.setSolo(jtfSolo.getText());
                    ctx.setSoluong(Integer.valueOf(jtfSoluong.getText()));
                    break;
            }
        }
        fillTable();
        }
        }
    }//GEN-LAST:event_jbtUpdateActionPerformed

    private void jbtDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtDeleteActionPerformed
        if(jtfMaxuat.getText().length() == 0 || jtfBennhan.getText().length() == 0 || jtfSolo.getText().length() == 0 || jtfSoluong.getText().length() == 0){
            JOptionPane.showMessageDialog(this, "Chưa điền đầy đủ thông tin!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
        int  choice = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa giá trị?","Warning",JOptionPane.YES_NO_OPTION);
            if(choice == JOptionPane.NO_OPTION){
                return;
            }
            else{
                for(ChiTietXuat ctx:list){
                    if(ctx.getMahh().equals(jtfMahh.getText())){
                    list.remove(ctx);
                    break;
            }
        }
        fillTable();
        }
        }
    }//GEN-LAST:event_jbtDeleteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jcbTenhhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbTenhhActionPerformed
        // TODO add your handling code here:
        int c = jcbTenhh.getSelectedIndex();
//        System.out.println(c);
        Connection cons = DBConnect.getConnection();
            try {
                String sql = "select Mahh, Soluong from hanghoa";
                PreparedStatement ps = cons.prepareCall(sql);
                ResultSet rs = ps.executeQuery();
                while(rs.next()) {
                    listmahh.add(rs.getString("mahh"));
                    listsl.add(rs.getString("soluong"));
                }  
               
                rs.close();
                ps.close();
                cons.close();                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
                e.printStackTrace();
            }
        if(c<0){
            jtfMahh.setText("");
            jtfSoluongcon.setText("");
        }
        else{
            jtfMahh.setText(listmahh.get(c).toString());
            jtfSoluongcon.setText(listsl.get(c).toString());
        }
    }//GEN-LAST:event_jcbTenhhActionPerformed

    private void jtfSoluongMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtfSoluongMouseExited
        // TODO add your handling code here:
        if(jtfSoluong.getText().length()==0){
            jtfSoluong.setText(Integer.toString(0));
        }
        else{
            if(Integer.valueOf(jtfSoluong.getText()) > Integer.valueOf(jtfSoluongcon.getText())){
            JOptionPane.showMessageDialog(this, "Không đủ số lượng trong kho, vui lòng kiểm tra lại!","Warning", JOptionPane.WARNING_MESSAGE);
            jtfSoluong.setText(Integer.toString(0));
            }
        }
        
    }//GEN-LAST:event_jtfSoluongMouseExited
    
       
    /**
     * @param args the command line arguments
     */
    
    
    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(XuatKhoJFrameCreat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(XuatKhoJFrameCreat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(XuatKhoJFrameCreat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(XuatKhoJFrameCreat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new XuatKhoJFrameCreat().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton jbtAdd;
    private javax.swing.JButton jbtDelete;
    private javax.swing.JButton jbtSave;
    private javax.swing.JButton jbtUpdate;
    private javax.swing.JComboBox<String> jcbTenhh;
    private javax.swing.JTable jtbChitiet;
    private javax.swing.JTextArea jtfBennhan;
    private javax.swing.JTextField jtfMahh;
    private javax.swing.JTextField jtfManv;
    private javax.swing.JTextField jtfMaxuat;
    private com.toedter.calendar.JDateChooser jtfNgayXuat;
    private javax.swing.JTextField jtfSolo;
    private javax.swing.JTextField jtfSoluong;
    private javax.swing.JTextField jtfSoluongcon;
    // End of variables declaration//GEN-END:variables
}