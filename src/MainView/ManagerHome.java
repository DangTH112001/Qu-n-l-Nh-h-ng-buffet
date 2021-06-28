/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainView;

import Controller.*;
import Form.*;
import DBObject.*;
import LoginView.LoginForm;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.Timer;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Phan Hau
 */
public class ManagerHome extends javax.swing.JFrame {
    private static int TagID = 0;
    private static String[] Table = {"", "NHANVIEN", "COMBO", "MONKHAC", "QUA", "VE", "GIAMGIA", "KHACHHANG", "CA", "HOADON"};
    private static String[] Ma = {"", "MANV", "MACB", "MAMK", "MAQUA", "MAVE", "MAGG", "MAKH", "MACA", "MAHD"};
    private static String[] Prefix = {"", "NV", "CB", "MK", "Q", "V", "GG", "KH", "C", "HD"};
    private Timer tm;
    private int x = 0;
    public static String MaNV;
    
     String[] list = {
                        "C:\\Users\\DangT\\Desktop\\BF_Restaurant\\src\\ImgSlide\\Drink.jpg",
                        "C:\\Users\\DangT\\Desktop\\BF_Restaurant\\src\\ImgSlide\\Food.jpg",
                        "C:\\Users\\DangT\\Desktop\\BF_Restaurant\\src\\ImgSlide\\Restaurant.jpg"
                    };
    
    private void set_Table(String TableName) {
        switchState(true);
        String query = "select * from " + TableName;
        
        int Col = SQLTable.getLength(TableName);
        int Row = SQLTable.getSize(TableName);
        
        Object[][] data = new Object[Row][Col];
        
        try {
            Statement statement = SQLTable.connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            
            int i = 0;
            while (rs.next()) {      
                data[i++] = SQLTable.getProperties(TableName, rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManagerHome.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            Table_Info.setModel(new DefaultTableModel(data, SQLTable.ColumnName(TableName)) { 
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }  
            });
        }
    } 
    public ManagerHome() {
        SQLTable table = new SQLTable();
        initComponents();
        SetImageSize(2);
        timer();
        switchState(false);
    } 
    private void timer() {
        tm = new Timer(10000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SetImageSize(x);
                x += 1;
                if (x >= list.length) 
                   x = 0;
            }
        });
        tm.start();
    } 
    private void switchState(boolean state) {
        ScrollPane_Info.setVisible(state);
        Panel_Function.setVisible(state);
        Icon_Search.setVisible(state);
        TextField_SearchContent.setText("");
        TextField_SearchContent.setVisible(state);
        Button_Print.setVisible(!state);
        Slide.setVisible(!state);
        
        if (TagID == 9) 
            Button_Print.setVisible(true);
    }  
    public static void update(Object[] data) {
        DefaultTableModel model = (DefaultTableModel) Table_Info.getModel();
        model.addRow(data);
    } 
    public static void update(Object[] data, int rowid) {
        DefaultTableModel model = (DefaultTableModel) Table_Info.getModel();
        for (int i = 1; i <= data.length; i++) {
            model.setValueAt(data[i - 1], rowid, i - 1);
        }
    }
    public static String getTableID() {
        String res = Prefix[TagID];
        try {
            Statement statement = SQLTable.connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT SEQ_"+Table[TagID]+".NEXTVAL FROM dual");  
            while (rs.next()) {
                res += rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ComboForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            return res;
        }  
     }  
    public void SetImageSize(int i) {
        ImageIcon icon = new ImageIcon(list[i]);
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(Slide.getWidth(), Slide.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newImc = new ImageIcon(newImg);
        Slide.setIcon(newImc);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel_Tabs = new javax.swing.JPanel();
        Label_Home = new javax.swing.JLabel();
        Label_Discount = new javax.swing.JLabel();
        Label_Total = new javax.swing.JLabel();
        Label_Employee = new javax.swing.JLabel();
        Label_Food = new javax.swing.JLabel();
        Label_Combo = new javax.swing.JLabel();
        Label_Gift = new javax.swing.JLabel();
        Label_Customer = new javax.swing.JLabel();
        Label_Ticket = new javax.swing.JLabel();
        Label_Shift = new javax.swing.JLabel();
        Label_Report = new javax.swing.JLabel();
        Label_Bill = new javax.swing.JLabel();
        Label_Bill1 = new javax.swing.JLabel();
        ScrollPane_Info = new javax.swing.JScrollPane();
        Table_Info = new javax.swing.JTable();
        Panel_Function = new javax.swing.JPanel();
        Button_Add = new javax.swing.JButton();
        Button_Remove = new javax.swing.JButton();
        Button_Print = new javax.swing.JButton();
        Button_Update = new javax.swing.JButton();
        Icon_Search = new javax.swing.JLabel();
        TextField_SearchContent = new javax.swing.JTextField();
        Slide = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Manager");
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1600, 780));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        Label_Discount.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        Label_Discount.setForeground(new java.awt.Color(255, 255, 255));
        Label_Discount.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Label_Discount.setText("Discount Management");
        Label_Discount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label_DiscountMouseClicked(evt);
            }
        });

        Label_Total.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        Label_Total.setForeground(new java.awt.Color(255, 255, 255));
        Label_Total.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Label_Total.setText("Total");

        Label_Employee.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        Label_Employee.setForeground(new java.awt.Color(255, 255, 255));
        Label_Employee.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Label_Employee.setText("Employee Management");
        Label_Employee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label_EmployeeMouseClicked(evt);
            }
        });

        Label_Food.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        Label_Food.setForeground(new java.awt.Color(255, 255, 255));
        Label_Food.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Label_Food.setText("Food Management");
        Label_Food.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label_FoodMouseClicked(evt);
            }
        });

        Label_Combo.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        Label_Combo.setForeground(new java.awt.Color(255, 255, 255));
        Label_Combo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Label_Combo.setText("Combo Management");
        Label_Combo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label_ComboMouseClicked(evt);
            }
        });

        Label_Gift.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        Label_Gift.setForeground(new java.awt.Color(255, 255, 255));
        Label_Gift.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Label_Gift.setText("Gift Management");
        Label_Gift.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label_GiftMouseClicked(evt);
            }
        });

        Label_Customer.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        Label_Customer.setForeground(new java.awt.Color(255, 255, 255));
        Label_Customer.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Label_Customer.setText("Customer Management");
        Label_Customer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label_CustomerMouseClicked(evt);
            }
        });

        Label_Ticket.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        Label_Ticket.setForeground(new java.awt.Color(255, 255, 255));
        Label_Ticket.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Label_Ticket.setText("Ticket Management");
        Label_Ticket.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label_TicketMouseClicked(evt);
            }
        });

        Label_Shift.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        Label_Shift.setForeground(new java.awt.Color(255, 255, 255));
        Label_Shift.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Label_Shift.setText("Shift Management");
        Label_Shift.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label_ShiftMouseClicked(evt);
            }
        });

        Label_Report.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        Label_Report.setForeground(new java.awt.Color(255, 255, 255));
        Label_Report.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Label_Report.setText("Report");
        Label_Report.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label_ReportMouseClicked(evt);
            }
        });

        Label_Bill.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        Label_Bill.setForeground(new java.awt.Color(255, 255, 255));
        Label_Bill.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Label_Bill.setText("Check In");
        Label_Bill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label_BillMouseClicked(evt);
            }
        });

        Label_Bill1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        Label_Bill1.setForeground(new java.awt.Color(255, 255, 255));
        Label_Bill1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Label_Bill1.setText("Bill Management");
        Label_Bill1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label_Bill1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout Panel_TabsLayout = new javax.swing.GroupLayout(Panel_Tabs);
        Panel_Tabs.setLayout(Panel_TabsLayout);
        Panel_TabsLayout.setHorizontalGroup(
            Panel_TabsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_TabsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_TabsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Label_Bill1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label_Report, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(Panel_TabsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(Label_Combo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Label_Food, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE))
                    .addComponent(Label_Gift, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label_Ticket, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label_Discount, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(Panel_TabsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(Label_Shift, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                        .addComponent(Label_Customer, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE))
                    .addGroup(Panel_TabsLayout.createSequentialGroup()
                        .addGroup(Panel_TabsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(Label_Home, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Label_Bill, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Label_Employee, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE))
                        .addGap(55, 55, 55)
                        .addComponent(Label_Total, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Panel_TabsLayout.setVerticalGroup(
            Panel_TabsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_TabsLayout.createSequentialGroup()
                .addGroup(Panel_TabsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_TabsLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(Label_Total, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Panel_TabsLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Label_Home, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Label_Bill, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(Label_Bill1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Label_Employee, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Label_Combo, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Label_Food, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Label_Gift, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Label_Ticket, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Label_Discount, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Label_Customer, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Label_Shift, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Label_Report, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Label_Home.getAccessibleContext().setAccessibleName("");

        getContentPane().add(Panel_Tabs, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 770));

        ScrollPane_Info.setPreferredSize(new java.awt.Dimension(1050, 670));

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
        ScrollPane_Info.setViewportView(Table_Info);

        getContentPane().add(ScrollPane_Info, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, 1050, 670));

        Button_Add.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        Button_Add.setText("Add");
        Button_Add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Button_AddMouseClicked(evt);
            }
        });

        Button_Remove.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        Button_Remove.setText("Remove");
        Button_Remove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Button_RemoveMouseClicked(evt);
            }
        });

        Button_Print.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        Button_Print.setText("Print");
        Button_Print.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Button_PrintMouseClicked(evt);
            }
        });

        Button_Update.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        Button_Update.setText("Update");
        Button_Update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Button_UpdateMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout Panel_FunctionLayout = new javax.swing.GroupLayout(Panel_Function);
        Panel_Function.setLayout(Panel_FunctionLayout);
        Panel_FunctionLayout.setHorizontalGroup(
            Panel_FunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_FunctionLayout.createSequentialGroup()
                .addGroup(Panel_FunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Button_Remove, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                    .addComponent(Button_Update, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                    .addComponent(Button_Print, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                    .addComponent(Button_Add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        Panel_FunctionLayout.setVerticalGroup(
            Panel_FunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_FunctionLayout.createSequentialGroup()
                .addComponent(Button_Add, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Button_Remove, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Button_Update, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Button_Print, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(426, Short.MAX_VALUE))
        );

        getContentPane().add(Panel_Function, new org.netbeans.lib.awtextra.AbsoluteConstraints(1360, 20, 190, 720));

        Icon_Search.setBackground(new java.awt.Color(255, 255, 255));
        Icon_Search.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Icon_Search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ic_search.png"))); // NOI18N
        Icon_Search.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(Icon_Search, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, 50, 32));

        TextField_SearchContent.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        TextField_SearchContent.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        TextField_SearchContent.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TextField_SearchContentKeyTyped(evt);
            }
        });
        getContentPane().add(TextField_SearchContent, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, 1000, 32));

        Slide.setMaximumSize(new java.awt.Dimension(1050, 670));
        Slide.setMinimumSize(new java.awt.Dimension(1050, 670));
        Slide.setPreferredSize(new java.awt.Dimension(1050, 670));
        getContentPane().add(Slide, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 50, 1050, 670));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Button_RemoveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button_RemoveMouseClicked
        int RowID = Table_Info.getSelectedRow();
  
        if (JOptionPane.showConfirmDialog(null, "Are you sure?", "WARNING",
            JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                if (RowID >= 0) {
                    String ID = (String) Table_Info.getValueAt(RowID, 0);
                    
                    switch (TagID) {
                        case 1: {NhanVienController.delete(ID); break;}
                        case 2: {ComboController.delete(ID); break;}
                        case 3: {MonKhacController.delete(ID); break;}
                        case 4: {QuaController.delete(ID); break;}
                        case 5: {VeController.delete(ID); break;}
                        case 6: {GiamGiaController.delete(ID); break;}
                        case 7: {KhachHangController.delete(ID); break;}
                        case 8: {CaController.delete(ID); break;}
                        case 9: {HoaDonController.delete(ID); break;}
                    }
                    
                    DefaultTableModel model = (DefaultTableModel) Table_Info.getModel();
                    model.removeRow(RowID);             
                }
            }    
    }//GEN-LAST:event_Button_RemoveMouseClicked
    private void TextField_SearchContentKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextField_SearchContentKeyTyped
        Table_Info.setAutoCreateRowSorter(true);
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(Table_Info.getModel());
        Table_Info.setRowSorter(sorter);
        
        TextField_SearchContent.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = TextField_SearchContent.getText();

                if (text.trim().length() == 0) {
                    sorter.setRowFilter(null);
                } else {
                    sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = TextField_SearchContent.getText();

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
        
    }//GEN-LAST:event_TextField_SearchContentKeyTyped
       
    private void Button_AddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button_AddMouseClicked
        switch (TagID) {
            case 1: {NhanVienForm add = new NhanVienForm(); add.setVisible(true); break;}
            case 2: {ComboForm add = new ComboForm(); add.setVisible(true); break;}
            case 3: {MonKhacForm add = new MonKhacForm(); add.setVisible(true); break;}
            case 4: {QuaForm add = new QuaForm(); add.setVisible(true); break;}
            case 5: {VeForm add = new VeForm(); add.setVisible(true); break;}
            case 6: {GiamGiaForm add = new GiamGiaForm(); add.setVisible(true); break;}
            case 7: {KhachHangForm add = new KhachHangForm(); add.setVisible(true); break;}
            case 8: {CaForm add = new CaForm(); add.setVisible(true); break;}
            case 9: {HoaDonForm add = new HoaDonForm(); add.setVisible(true); break;}
        }
    }//GEN-LAST:event_Button_AddMouseClicked
    private void Button_UpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button_UpdateMouseClicked
        int RowID = Table_Info.getSelectedRow();
        Object[] result = new String[20];
        
        for (int j = 0; j < SQLTable.getLength(Table[TagID]); j++) {
            if (Table_Info.getValueAt(RowID, j) != null)
                result[j] = (Table_Info.getValueAt(RowID, j)).toString();
            else
                result[j] = "";
        }
        
        switch (TagID) {
            case 1: {NhanVienForm add = new NhanVienForm(result, RowID); add.setVisible(true); break;}
            case 2: {ComboForm add = new ComboForm(result, RowID); add.setVisible(true); break;}
            case 3: {MonKhacForm add = new MonKhacForm(result, RowID); add.setVisible(true); break;}
            case 4: {QuaForm add = new QuaForm(result, RowID); add.setVisible(true); break;}
            case 5: {VeForm add = new VeForm(result, RowID); add.setVisible(true); break;}
            case 6: {GiamGiaForm add = new GiamGiaForm(result, RowID); add.setVisible(true); break;}
            case 7: {KhachHangForm add = new KhachHangForm(result, RowID); add.setVisible(true); break;}
            case 8: {CaForm add = new CaForm(result, RowID); add.setVisible(true); break;}
            case 9: {HoaDonForm add = new HoaDonForm(result, RowID); add.setVisible(true); break;}
        }
    }//GEN-LAST:event_Button_UpdateMouseClicked
    private void Label_BillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label_BillMouseClicked
        // Check if already check in
        // if not insert
        String query = "SELECT * FROM PHANCONG WHERE MANV = ? AND NGLAM = ?";
        try {
            PreparedStatement p_statement = SQLTable.connection.prepareStatement(query);
        }
        catch (Exception ex) {
            
        }
        
        System.out.println(MaNV);
    }//GEN-LAST:event_Label_BillMouseClicked
    private void Label_ReportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label_ReportMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Label_ReportMouseClicked
    private void Label_ShiftMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label_ShiftMouseClicked
        TagID = 8;
        switchState(true);
        set_Table("CA");
    }//GEN-LAST:event_Label_ShiftMouseClicked
    private void Label_TicketMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label_TicketMouseClicked
        TagID = 5;
        switchState(true);
        set_Table("VE");
    }//GEN-LAST:event_Label_TicketMouseClicked
    private void Label_CustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label_CustomerMouseClicked
        TagID = 7;
        switchState(true);
        set_Table("KHACHHANG");
    }//GEN-LAST:event_Label_CustomerMouseClicked
    private void Label_GiftMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label_GiftMouseClicked
        TagID = 4;
        switchState(true);
        set_Table("QUA");

    }//GEN-LAST:event_Label_GiftMouseClicked
    private void Label_ComboMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label_ComboMouseClicked
        TagID = 2;
        switchState(true);
        set_Table("COMBO");
    }//GEN-LAST:event_Label_ComboMouseClicked
    private void Label_FoodMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label_FoodMouseClicked
        TagID = 3;
        switchState(true);
        set_Table("MONKHAC");
    }//GEN-LAST:event_Label_FoodMouseClicked
    private void Label_EmployeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label_EmployeeMouseClicked
        TagID = 1;
        switchState(true);
        set_Table("NHANVIEN");
    }//GEN-LAST:event_Label_EmployeeMouseClicked
    private void Label_DiscountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label_DiscountMouseClicked
        TagID = 6;
        switchState(true);
        set_Table("GIAMGIA");
    }//GEN-LAST:event_Label_DiscountMouseClicked
    private void Label_HomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label_HomeMouseClicked
        switchState(false);
        timer();
    }//GEN-LAST:event_Label_HomeMouseClicked
    private void Label_Bill1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label_Bill1MouseClicked
        TagID = 9;
        switchState(true);
        set_Table("HOADON");
    }//GEN-LAST:event_Label_Bill1MouseClicked

    private void Button_PrintMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button_PrintMouseClicked
        System.out.println("Clicked");
    }//GEN-LAST:event_Button_PrintMouseClicked
    
    

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
            java.util.logging.Logger.getLogger(ManagerHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManagerHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManagerHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManagerHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManagerHome().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_Add;
    private javax.swing.JButton Button_Print;
    private javax.swing.JButton Button_Remove;
    private javax.swing.JButton Button_Update;
    private javax.swing.JLabel Icon_Search;
    private javax.swing.JLabel Label_Bill;
    private javax.swing.JLabel Label_Bill1;
    private javax.swing.JLabel Label_Combo;
    private javax.swing.JLabel Label_Customer;
    private javax.swing.JLabel Label_Discount;
    private javax.swing.JLabel Label_Employee;
    private javax.swing.JLabel Label_Food;
    private javax.swing.JLabel Label_Gift;
    private javax.swing.JLabel Label_Home;
    private javax.swing.JLabel Label_Report;
    private javax.swing.JLabel Label_Shift;
    private javax.swing.JLabel Label_Ticket;
    private javax.swing.JLabel Label_Total;
    private javax.swing.JPanel Panel_Function;
    private javax.swing.JPanel Panel_Tabs;
    private static javax.swing.JScrollPane ScrollPane_Info;
    private javax.swing.JLabel Slide;
    private static javax.swing.JTable Table_Info;
    private javax.swing.JTextField TextField_SearchContent;
    // End of variables declaration//GEN-END:variables
}
