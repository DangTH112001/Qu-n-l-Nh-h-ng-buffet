/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainView;

import Controller.DoiController;
import Form.TaiKhoan;
import DBObject.SQLTable;
import Form.DatVeForm;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author DangT
 */
public class CustomerHome extends javax.swing.JFrame {

    public static int Point;
    public static String MaKH;
    public static Object[] data = {};
    
    public CustomerHome() {
        initComponents();
        SQLTable table = new SQLTable();
    }
    
    private void set_TableDoi() {
        String query = "select * from DOI where MAKH = ?";
        
        int Col = SQLTable.getLength("DOI");
        int Row = 0;
        
        try {
            PreparedStatement statement = SQLTable.connection.prepareStatement("select count(*) from DOI where MAKH = ?");
            statement.setString(1, MaKH);
            ResultSet rs = statement.executeQuery();
            
            if (rs.next()) {
                Row = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManagerHome.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Object[][] data = new Object[Row][Col];
        
        try {
            PreparedStatement statement = SQLTable.connection.prepareStatement(query);
            statement.setString(1, MaKH);
            ResultSet rs = statement.executeQuery();
            
            int i = 0;
            while (rs.next()) {      
                data[i++] = SQLTable.getProperties("DOI", rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManagerHome.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            Table_Below.setModel(new DefaultTableModel(data, SQLTable.ColumnName("DOI")) { 
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }  
            });
        }
    }
    
    private void set_TableQua() {
        String query = "select * from QUA";
        
        int Col = SQLTable.getLength("QUA");
        int Row = SQLTable.getSize("QUA");
        
        Object[][] data = new Object[Row][Col];
        
        try {
            Statement statement = SQLTable.connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            
            int i = 0;
            while (rs.next()) {      
                data[i++] = SQLTable.getProperties("QUA", rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManagerHome.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            Table_Above.setModel(new DefaultTableModel(data, SQLTable.ColumnName("QUA")) { 
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }  
            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel_Tabs = new javax.swing.JPanel();
        Label_Home = new javax.swing.JLabel();
        Label_Create = new javax.swing.JLabel();
        Label_Gift = new javax.swing.JLabel();
        Label_BookingHistory = new javax.swing.JLabel();
        Label_AccountManagement = new javax.swing.JLabel();
        Icon_SearchQua = new javax.swing.JLabel();
        lb_CurrentPoint = new javax.swing.JLabel();
        Icon_SearchDoi = new javax.swing.JLabel();
        TextField_SearchQua = new javax.swing.JTextField();
        TextField_SearchLSDQ = new javax.swing.JTextField();
        ScrollPane_Qua = new javax.swing.JScrollPane();
        Table_Above = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table_Below = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btn_Exchange = new javax.swing.JButton();
        btn_Remove = new javax.swing.JButton();
        btn_Update = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Panel_Tabs.setBackground(new java.awt.Color(23, 35, 51));

        Label_Home.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        Label_Home.setForeground(new java.awt.Color(255, 255, 255));
        Label_Home.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Label_Home.setText("Home");
        Label_Home.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.WHITE));
        Label_Home.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Label_Home.setPreferredSize(new java.awt.Dimension(95, 95));
        Label_Home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label_HomeMouseClicked(evt);
            }
        });

        Label_Create.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        Label_Create.setForeground(new java.awt.Color(255, 255, 255));
        Label_Create.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Label_Create.setText("Create Ticket");
        Label_Create.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label_CreateMouseClicked(evt);
            }
        });

        Label_Gift.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        Label_Gift.setForeground(new java.awt.Color(255, 255, 255));
        Label_Gift.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Label_Gift.setText("Gift");
        Label_Gift.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label_GiftMouseClicked(evt);
            }
        });

        Label_BookingHistory.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        Label_BookingHistory.setForeground(new java.awt.Color(255, 255, 255));
        Label_BookingHistory.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Label_BookingHistory.setText("Booking History");
        Label_BookingHistory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label_BookingHistoryMouseClicked(evt);
            }
        });

        Label_AccountManagement.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        Label_AccountManagement.setForeground(new java.awt.Color(255, 255, 255));
        Label_AccountManagement.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Label_AccountManagement.setText("Account mangement");
        Label_AccountManagement.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label_AccountManagementMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout Panel_TabsLayout = new javax.swing.GroupLayout(Panel_Tabs);
        Panel_Tabs.setLayout(Panel_TabsLayout);
        Panel_TabsLayout.setHorizontalGroup(
            Panel_TabsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_TabsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_TabsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Label_Gift, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(Panel_TabsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(Label_Home, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                        .addComponent(Label_Create, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(Label_BookingHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label_AccountManagement, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Panel_TabsLayout.setVerticalGroup(
            Panel_TabsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_TabsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Label_Home, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Label_Create, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Label_BookingHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Label_AccountManagement, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Label_Gift, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Icon_SearchQua.setBackground(new java.awt.Color(255, 255, 255));
        Icon_SearchQua.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Icon_SearchQua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ic_search.png"))); // NOI18N
        Icon_SearchQua.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lb_CurrentPoint.setText("Current Point: ");
        lb_CurrentPoint.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        Icon_SearchDoi.setBackground(new java.awt.Color(255, 255, 255));
        Icon_SearchDoi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Icon_SearchDoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ic_search.png"))); // NOI18N
        Icon_SearchDoi.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        TextField_SearchQua.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        TextField_SearchQua.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        TextField_SearchQua.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TextField_SearchQuaKeyTyped(evt);
            }
        });

        TextField_SearchLSDQ.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        TextField_SearchLSDQ.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        TextField_SearchLSDQ.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TextField_SearchLSDQKeyTyped(evt);
            }
        });

        ScrollPane_Qua.setPreferredSize(new java.awt.Dimension(1050, 670));

        Table_Above.setModel(new javax.swing.table.DefaultTableModel(
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
        ScrollPane_Qua.setViewportView(Table_Above);

        Table_Below.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(Table_Below);

        btn_Exchange.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btn_Exchange.setText("Exchange");
        btn_Exchange.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ExchangeMouseClicked(evt);
            }
        });

        btn_Remove.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btn_Remove.setText("Remove");
        btn_Remove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_RemoveMouseClicked(evt);
            }
        });

        btn_Update.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        btn_Update.setText("Update");
        btn_Update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_UpdateMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_Exchange, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
            .addComponent(btn_Remove, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
            .addComponent(btn_Update, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btn_Exchange, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_Remove, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_Update, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Panel_Tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Icon_SearchQua, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(TextField_SearchQua, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lb_CurrentPoint, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(Icon_SearchDoi, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(TextField_SearchLSDQ, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(ScrollPane_Qua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Icon_SearchQua, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextField_SearchQua, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addComponent(lb_CurrentPoint, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(ScrollPane_Qua, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(416, 416, 416)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Icon_SearchDoi, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextField_SearchLSDQ, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(Panel_Tabs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Label_HomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label_HomeMouseClicked

    }//GEN-LAST:event_Label_HomeMouseClicked

    private void Label_CreateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label_CreateMouseClicked
        DatVeForm form = new DatVeForm();
        form.setVisible(true);
    }//GEN-LAST:event_Label_CreateMouseClicked

    private void Label_GiftMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label_GiftMouseClicked
        lb_CurrentPoint.setText("Current Point: " + Point);
        set_TableQua();
        set_TableDoi();
    }//GEN-LAST:event_Label_GiftMouseClicked

    private void Label_BookingHistoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label_BookingHistoryMouseClicked
        set_TableVe1();
        set_TableVe2();
    }//GEN-LAST:event_Label_BookingHistoryMouseClicked

    private void set_TableVe1() {
        Object[] Col = {"Mã vé", "Ngày ăn", "Thời gian bắt đầu", "Thời gian kết thúc"};
        String query = "SELECT * FROM VE WHERE MAKH = ? AND NGAN >= SYSDATE";
        DateFormat time = new SimpleDateFormat("HH:mm:ss");
        DateFormat date = new SimpleDateFormat("dd/MM/yyyy");
        Table_Above.setModel(new DefaultTableModel(null, Col) { 
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }  
            });
        DefaultTableModel model = (DefaultTableModel) Table_Above.getModel();
        
        try {
            PreparedStatement stm = SQLTable.connection.prepareStatement(query);
            stm.setString(1, MaKH);
            ResultSet rs = stm.executeQuery();
            
            while (rs.next()) {
                model.addRow(new Object[] {rs.getString("MAVE"), date.format(rs.getDate("NGAN")), time.format(rs.getDate("TGBD")), time.format(rs.getDate("TGKT"))});
            }
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    private void set_TableVe2() {
        Object[] Col = {"Mã vé", "Ngày ăn", "Thời gian bắt đầu", "Thời gian kết thúc"};
        String query = "SELECT * FROM VE WHERE MAKH = ? AND NGAN < SYSDATE";
        DateFormat time = new SimpleDateFormat("HH:mm:ss");
        DateFormat date = new SimpleDateFormat("dd/MM/yyyy");
        Table_Below.setModel(new DefaultTableModel(null, Col) { 
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }  
            });
        DefaultTableModel model = (DefaultTableModel) Table_Below.getModel();
        
        try {
            PreparedStatement stm = SQLTable.connection.prepareStatement(query);
            stm.setString(1, MaKH);
            ResultSet rs = stm.executeQuery();
            
            while (rs.next()) {
                model.addRow(new Object[] {rs.getString("MAVE"), date.format(rs.getDate("NGAN")), time.format(rs.getDate("TGBD")), time.format(rs.getDate("TGKT"))});
            }
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    private void TextField_SearchQuaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextField_SearchQuaKeyTyped
        Table_Above.setAutoCreateRowSorter(true);
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(Table_Above.getModel());
        Table_Above.setRowSorter(sorter);
        
        TextField_SearchQua.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = TextField_SearchQua.getText();

                if (text.trim().length() == 0) {
                    sorter.setRowFilter(null);
                } else {
                    sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = TextField_SearchQua.getText();

                if (text.trim().length() == 0) {
                    sorter.setRowFilter(null);
                } else {
                    sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); 
            }
        });
    }//GEN-LAST:event_TextField_SearchQuaKeyTyped

    private void Label_AccountManagementMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label_AccountManagementMouseClicked
        TaiKhoan form = new TaiKhoan();
        form.setVisible(true);
    }//GEN-LAST:event_Label_AccountManagementMouseClicked

    private void btn_ExchangeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ExchangeMouseClicked
        int RowID = Table_Above.getSelectedRow();
        Object[] result = new String[20];
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        
        String MaQua = (String) Table_Above.getValueAt(RowID, 0);
        Date date = new Date();
        String SoLuong = "1"; 
        
        Object[] data = {MaKH, MaQua, format.format(date), SoLuong};
        
        DoiController.add(data);
        update(data);
        lb_CurrentPoint.setText("Current Point: " + Point);
    }//GEN-LAST:event_btn_ExchangeMouseClicked

    public void update(Object[] data) {
        DefaultTableModel model = (DefaultTableModel) Table_Below.getModel();
        model.addRow(data);
        
        String query = "SELECT DIEMTL FROM KHACHHANG WHERE MAKH = ?";
        try {
            PreparedStatement statement = SQLTable.connection.prepareStatement(query);
            statement.setString(1, MaKH);
            ResultSet rs = statement.executeQuery();
            
            if (rs.next())
                Point = rs.getInt("DIEMTL");
        }
        catch (Exception ex) {
            
        }
        lb_CurrentPoint.setText("Current Point: " + Point);
    }
    
    private void TextField_SearchLSDQKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextField_SearchLSDQKeyTyped
        Table_Below.setAutoCreateRowSorter(true);
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(Table_Below.getModel());
        Table_Below.setRowSorter(sorter);
        
        TextField_SearchLSDQ.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = TextField_SearchLSDQ.getText();

                if (text.trim().length() == 0) {
                    sorter.setRowFilter(null);
                } else {
                    sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = TextField_SearchLSDQ.getText();

                if (text.trim().length() == 0) {
                    sorter.setRowFilter(null);
                } else {
                    sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); 
            }
        });
    }//GEN-LAST:event_TextField_SearchLSDQKeyTyped

    private void btn_RemoveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_RemoveMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_RemoveMouseClicked

    private void btn_UpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_UpdateMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_UpdateMouseClicked

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
            java.util.logging.Logger.getLogger(CustomerHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Icon_SearchDoi;
    private javax.swing.JLabel Icon_SearchQua;
    private javax.swing.JLabel Label_AccountManagement;
    private javax.swing.JLabel Label_BookingHistory;
    private javax.swing.JLabel Label_Create;
    private javax.swing.JLabel Label_Gift;
    private javax.swing.JLabel Label_Home;
    private javax.swing.JPanel Panel_Tabs;
    private static javax.swing.JScrollPane ScrollPane_Qua;
    private javax.swing.JTable Table_Above;
    private javax.swing.JTable Table_Below;
    private javax.swing.JTextField TextField_SearchLSDQ;
    private javax.swing.JTextField TextField_SearchQua;
    private javax.swing.JButton btn_Exchange;
    private javax.swing.JButton btn_Remove;
    private javax.swing.JButton btn_Update;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JLabel lb_CurrentPoint;
    // End of variables declaration//GEN-END:variables
}