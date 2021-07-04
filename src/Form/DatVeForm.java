/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import Controller.VeController;
import DBObject.SQLTable;
import MainView.CustomerHome;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DangT
 */
public class DatVeForm extends javax.swing.JFrame {
    private String[] TableCombo = {"Tên combo", "Số người", "Giá"};
    private String[] TableMonKhac = {"Tên món", "Giá"};
    private String[] TableBan = {"Mã bàn", "Số lượng người"}; 
    private String[] TableInfo = {"Tên món", "Giá", "Số lượng"};
    private Integer TongCB = 0;
    private Integer TongMK = 0;
    CustomerHome home;
    
    Map<String, String> MapCombo;
    Map<String, String> MapMonKhac;
    Map<Integer, String> MapBan;
    
    private boolean state = false;
    private Date date;
    
    public DatVeForm() {
        DateFormat time = new SimpleDateFormat("HH:mm:ss");
        SQLTable table = new SQLTable();
        
        this.date = new Date();
        initComponents();
        home = new CustomerHome();
        MapCombo = new HashMap<>();
        MapMonKhac = new HashMap<>();
        MapBan = new HashMap<>();
            
        initCombo();
        initMonKhac();
        initInfo();
        try {
            dc_NgAn.setDate(new Date());
            Spin_TGBD.setValue(time.parse("00:00:00"));
            Spin_TGKT.setValue(time.parse("00:00:00"));
        } catch (ParseException ex) {
            Logger.getLogger(DatVeForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void initBan() {
        Table_Ban.setModel(new DefaultTableModel(null, TableBan){ 
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }  
        });
        
        String query = "SELECT MABAN, LOAIBAN, SONGUOI "
                    + "FROM BAN "
                    + "MINUS "
                    + "SELECT BAN.MABAN, BAN.LOAIBAN, BAN.SONGUOI "
                    + "FROM VE INNER JOIN BAN ON VE.MABAN = BAN.MABAN "
                    + "WHERE ((TO_NUM(VE.TGBD) <= TO_NUM(?) AND TO_NUM(VE.TGKT) > TO_NUM(?)) "
                    + "OR (TO_NUM(VE.TGBD) < TO_NUM(?) AND TO_NUM(VE.TGKT) >= TO_NUM(?))) AND VE.NGAN = ? "
                    + "ORDER BY SONGUOI";
        
        System.out.println("Created");
        DefaultTableModel model = (DefaultTableModel) Table_Ban.getModel();
        DateFormat date = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        
        Date TGBD = (Date) Spin_TGBD.getValue();
        Date TGKT = (Date) Spin_TGKT.getValue();
        Date NgAn = (Date) dc_NgAn.getDate();
        
        try {
            PreparedStatement stm = SQLTable.connection.prepareStatement(query);
            
            stm.setDate(1, new java.sql.Date(TGBD.getTime()));
            stm.setDate(2, new java.sql.Date(TGBD.getTime()));
            stm.setDate(3, new java.sql.Date(TGKT.getTime()));
            stm.setDate(4, new java.sql.Date(TGKT.getTime()));
            stm.setDate(5, new java.sql.Date(NgAn.getTime()));
            
            ResultSet rs = stm.executeQuery();
            
            int i = 0;
            while (rs.next()) {
                Object[] data = {rs.getString("MABAN"), rs.getInt("SONGUOI")};
                MapBan.put(i++, rs.getString("MABAN"));
                model.addRow(data);
            }
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    private void initCombo() {
        Table_Combo.setModel(new DefaultTableModel(null, TableCombo){ 
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }  
        });
        
        DefaultTableModel model = (DefaultTableModel) Table_Combo.getModel();
        
        String query = "SELECT * FROM COMBO ORDER BY SONGUOI";
        try {
            Statement stm = SQLTable.connection.createStatement();
            ResultSet rs = stm.executeQuery(query);
            
            int i = 1;
            while (rs.next()) {
                Object[] data = {rs.getString("TENCB"), rs.getInt("SONGUOI"), rs.getInt("GIA")};
                MapCombo.put(rs.getString("TENCB"), rs.getString("MACB"));
                model.addRow(data);
            }
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    private void initMonKhac() {
        Table_MonKhac.setModel(new DefaultTableModel(null, TableMonKhac){ 
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }  
        });
        
        DefaultTableModel model = (DefaultTableModel) Table_MonKhac.getModel();
        
        String query = "SELECT * FROM MONKHAC ORDER BY GIA";
        try {
            Statement stm = SQLTable.connection.createStatement();
            ResultSet rs = stm.executeQuery(query);
            
            int i = 1;
            while (rs.next()) {
                Object[] data = {rs.getString("TENMK"), rs.getInt("GIA")};
                MapMonKhac.put(rs.getString("TENMK"), rs.getString("MAMK"));
                model.addRow(data);
            }
            stm.close();
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    private void initInfo() {
        Table_Info.setModel(new DefaultTableModel(null, TableInfo) { 
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 2;
            }  
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Table_Combo = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        Table_Ban = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        Table_MonKhac = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        Table_Info = new javax.swing.JTable();
        btn_Create = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lb_NgayAn = new javax.swing.JLabel();
        dc_NgAn = new com.toedter.calendar.JDateChooser();
        SpinnerDateModel sm1 = new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
        Spin_TGBD = new javax.swing.JSpinner(sm1);
        SpinnerDateModel sm2 = new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
        Spin_TGKT = new javax.swing.JSpinner(sm2);
        tf_MaBan = new javax.swing.JTextField();
        lb_TongCB = new javax.swing.JLabel();
        lb_TongMK = new javax.swing.JLabel();
        Tong = new javax.swing.JLabel();
        tf_TongMK = new javax.swing.JTextField();
        tf_TongCB = new javax.swing.JTextField();
        tf_Tong = new javax.swing.JTextField();
        lb_Title = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("BOOKING FORM");

        Table_Combo.setModel(new javax.swing.table.DefaultTableModel(
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
        Table_Combo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table_ComboMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Table_Combo);

        Table_Ban.setModel(new javax.swing.table.DefaultTableModel(
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
        Table_Ban.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table_BanMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Table_Ban);

        Table_MonKhac.setModel(new javax.swing.table.DefaultTableModel(
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
        Table_MonKhac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table_MonKhacMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(Table_MonKhac);

        Table_Info.setModel(new javax.swing.table.DefaultTableModel(
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
        Table_Info.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table_InfoMouseClicked(evt);
            }
        });
        Table_Info.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                Table_InfoInputMethodTextChanged(evt);
            }
        });
        Table_Info.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                Table_InfoPropertyChange(evt);
            }
        });
        Table_Info.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Table_InfoKeyTyped(evt);
            }
        });
        jScrollPane4.setViewportView(Table_Info);

        btn_Create.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_Create.setText("Create");
        btn_Create.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_CreateMouseClicked(evt);
            }
        });

        jLabel3.setText("Table:");

        jLabel2.setText("Finish:");

        jLabel1.setText("Start Time:");

        lb_NgayAn.setText("Date:");

        dc_NgAn.setDateFormatString("dd/MM/yyyy");
        dc_NgAn.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dc_NgAnPropertyChange(evt);
            }
        });

        JSpinner.DateEditor de1 = new JSpinner.DateEditor(Spin_TGBD, "HH:mm:ss");
        Spin_TGBD.setEditor(de1);
        Spin_TGBD.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                Spin_TGBDStateChanged(evt);
            }
        });

        JSpinner.DateEditor de2 = new JSpinner.DateEditor(Spin_TGKT, "HH:mm:ss");
        Spin_TGKT.setEditor(de2);
        Spin_TGKT.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                Spin_TGKTStateChanged(evt);
            }
        });

        tf_MaBan.setEditable(false);

        lb_TongCB.setText("Tổng tiền combo: ");

        lb_TongMK.setText("Tổng tiền món khác: ");

        Tong.setText("Tổng tiền");

        tf_TongMK.setEditable(false);
        tf_TongMK.setText("0");

        tf_TongCB.setEditable(false);
        tf_TongCB.setText("0");

        tf_Tong.setEditable(false);
        tf_Tong.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_TongMK)
                            .addComponent(lb_TongCB)
                            .addComponent(Tong))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tf_TongCB, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(tf_TongMK)
                            .addComponent(tf_Tong))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_Create, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lb_NgayAn)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(27, 27, 27)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(dc_NgAn, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                                    .addComponent(Spin_TGBD)
                                    .addComponent(Spin_TGKT)
                                    .addComponent(tf_MaBan))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_NgayAn)
                    .addComponent(dc_NgAn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Spin_TGBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(Spin_TGKT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tf_MaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_TongCB)
                            .addComponent(tf_TongCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lb_TongMK)
                            .addComponent(tf_TongMK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Tong)
                            .addComponent(tf_Tong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_Create, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        lb_Title.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lb_Title.setForeground(new java.awt.Color(120, 168, 252));
        lb_Title.setText("TICKET");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lb_Title)
                .addGap(197, 197, 197))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(lb_Title)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Table_BanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table_BanMouseClicked
        int RowID = Table_Ban.getSelectedRow();
        tf_MaBan.setText(MapBan.get(RowID));
    }//GEN-LAST:event_Table_BanMouseClicked

    private void Spin_TGBDStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_Spin_TGBDStateChanged
        Calendar cal = Calendar.getInstance();
        cal.setTime((Date) Spin_TGBD.getValue());
        cal.add(Calendar.HOUR_OF_DAY, 2);
        Spin_TGKT.setValue(cal.getTime());
        
        initBan();
    }//GEN-LAST:event_Spin_TGBDStateChanged

    private void Spin_TGKTStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_Spin_TGKTStateChanged

    }//GEN-LAST:event_Spin_TGKTStateChanged

    private void dc_NgAnPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dc_NgAnPropertyChange
        try {
            DateFormat time = new SimpleDateFormat("HH:mm:ss");
            Spin_TGBD.setValue(time.parse("00:00:00"));
            Spin_TGKT.setValue(time.parse("00:00:00"));
        } catch (ParseException ex) {
            Logger.getLogger(DatVeForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_dc_NgAnPropertyChange

    private void Table_ComboMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table_ComboMouseClicked
        int RowID = Table_Combo.getSelectedRow();
        
        DefaultTableModel model = (DefaultTableModel) Table_Info.getModel();
        model.addRow(new Object[] {Table_Combo.getValueAt(RowID, 0), Table_Combo.getValueAt(RowID, 2), "1"});
        
        
        TongCB += (int) Table_Combo.getValueAt(RowID, 2);
        tf_TongCB.setText(TongCB.toString());
        Integer Tong = TongCB + TongMK;
        tf_Tong.setText(Tong.toString());
        
    }//GEN-LAST:event_Table_ComboMouseClicked

    private void Table_MonKhacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table_MonKhacMouseClicked
        int RowID = Table_MonKhac.getSelectedRow();
        
        DefaultTableModel model = (DefaultTableModel) Table_Info.getModel();
        model.addRow(new Object[] {Table_MonKhac.getValueAt(RowID, 0), Table_MonKhac.getValueAt(RowID, 1), "1"});

        
        TongMK += (int) Table_MonKhac.getValueAt(RowID, 1);
        tf_TongMK.setText(TongMK.toString());
        Integer Tong = TongCB + TongMK;
        tf_Tong.setText(Tong.toString());
    }//GEN-LAST:event_Table_MonKhacMouseClicked

    private void Table_InfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table_InfoMouseClicked
        int RowID = Table_Info.getSelectedRow();
        int ColID = Table_Info.getSelectedColumn();
        
        if (ColID != 2) {
            if (JOptionPane.showConfirmDialog(null, "Are you sure?", "WARNING",
            JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                if (RowID >= 0) { 
                    DefaultTableModel model = (DefaultTableModel) Table_Info.getModel();
                    model.removeRow(RowID);    
                    updateTong();
                }
            }
        }
    }//GEN-LAST:event_Table_InfoMouseClicked

    private void Table_InfoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_Table_InfoPropertyChange
        updateTong();
    }//GEN-LAST:event_Table_InfoPropertyChange

    private void Table_InfoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Table_InfoKeyTyped
        updateTong();
    }//GEN-LAST:event_Table_InfoKeyTyped

    private void btn_CreateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_CreateMouseClicked
        if (!check()) {
            JOptionPane.showMessageDialog(null, "Invalid input");
        }
        String VeID = SQLTable.getTableID("VE", "V");
        int RowID = 0;
        String CusID = CustomerHome.MaKH;
        String queryCB = "INSERT INTO CTCB VALUES (?, ?, ?)";
        String queryMK = "INSERT INTO CTMK VALUES (?, ?, ?)";
        String queryVe = "INSERT INTO VE VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        DateFormat time = new SimpleDateFormat("HH:mm:ss");
        DateFormat date = new SimpleDateFormat("dd/MM/yyyy");

        Object[] data = {
            VeID,
            tf_MaBan.getText(),
            CusID,
            date.format(dc_NgAn.getDate()),
            date.format(new Date()),
            TongCB.toString(),
            TongMK.toString(),
            time.format((Date) Spin_TGBD.getValue()),
            time.format((Date) Spin_TGKT.getValue())
        };
        VeController.add(data);
        
        
        
        while (true) {
            String name = (String) Table_Info.getValueAt(RowID, 0);
            String soluong = (String) Table_Info.getValueAt(RowID, 2);
            RowID++;

            try {
                if (name.contains("Combo")) {
                    String Ma = MapCombo.get(name);
                    int SL = Integer.parseInt(soluong);

                    PreparedStatement stm = SQLTable.connection.prepareStatement(queryCB);

                    stm.setString(1, Ma);
                    stm.setString(2, VeID);
                    stm.setInt(3, SL);
                    stm.execute();
                    stm.close();
                }
                else {
                    String Ma = MapCombo.get(name);
                    int SL = Integer.parseInt(soluong);

                    PreparedStatement stm = SQLTable.connection.prepareStatement(queryMK);

                    stm.setString(1, Ma);
                    stm.setString(2, VeID);
                    stm.setInt(3, SL);
                    stm.execute();
                    stm.close();
                }   
            }
            catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
                break;
            }       
        }
        dispose();
    }//GEN-LAST:event_btn_CreateMouseClicked

    private void Table_InfoInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_Table_InfoInputMethodTextChanged
        updateTong();
    }//GEN-LAST:event_Table_InfoInputMethodTextChanged
    
    private boolean check() {
        DateFormat time = new SimpleDateFormat("HH:mm:ss");
        DateFormat date = new SimpleDateFormat("dd/MM/yyyy");
        
        if (dc_NgAn.getDate().before(new Date()))
            return false;
        if (dc_NgAn.getDate() == null)
            return false;
        if (tf_MaBan.getText().equals(""))
            return false;
        try {
            if (((Date) Spin_TGBD.getValue()).before(time.parse("07:00:00")))
                return false;
            if (((Date) Spin_TGKT.getValue()).after(time.parse("21:00:00")))
                return false;
        }
        catch (Exception ex) {
            return false;
        }
        return true;
    }
    
    private void updateTong() {
        int i = 0;
        TongCB = 0;
        TongMK = 0;
        try {
            while (true) {
                String tmp = (String) Table_Info.getValueAt(i, 0);
                Integer money = (Integer) Table_Info.getValueAt(i, 1);
                String soluong = (String) Table_Info.getValueAt(i, 2);
                i++;

                if (tmp.contains("Combo")) {
                    TongCB += money * Integer.parseInt(soluong);
                }
                else {
                    TongMK += money * Integer.parseInt(soluong);
                }
            }
        }
        catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Cannot contain character");
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        tf_TongCB.setText(TongCB.toString());
        tf_TongMK.setText(TongMK.toString());
        Integer Tong = TongCB + TongMK;
        tf_Tong.setText(Tong.toString());
    }
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
            java.util.logging.Logger.getLogger(DatVeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DatVeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DatVeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DatVeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DatVeForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner Spin_TGBD;
    private javax.swing.JSpinner Spin_TGKT;
    private javax.swing.JTable Table_Ban;
    private javax.swing.JTable Table_Combo;
    private javax.swing.JTable Table_Info;
    private javax.swing.JTable Table_MonKhac;
    private javax.swing.JLabel Tong;
    private javax.swing.JButton btn_Create;
    private com.toedter.calendar.JDateChooser dc_NgAn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lb_NgayAn;
    private javax.swing.JLabel lb_Title;
    private javax.swing.JLabel lb_TongCB;
    private javax.swing.JLabel lb_TongMK;
    private javax.swing.JTextField tf_MaBan;
    private javax.swing.JTextField tf_Tong;
    private javax.swing.JTextField tf_TongCB;
    private javax.swing.JTextField tf_TongMK;
    // End of variables declaration//GEN-END:variables
}
