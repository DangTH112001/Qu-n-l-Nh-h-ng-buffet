/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainView;

import Controller.HoaDonController;
import Controller.PhanCongController;
import DBObject.SQLTable;
import Form.ReceiptForm;
import static MainView.ManagerHome.MaNV;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
 * @author DangT
 */
public class EmployeeHome extends javax.swing.JFrame {
    private Timer tm;
    private int x = 0;
    public static String MaNV;
    
     String[] list = {
                        "Drink.jpg",
                        "Food.jpg",
                        "Restaurant.jpg"
                    };
    public static void update(Object[] data) {
        
    }
     
    public EmployeeHome() {
        SQLTable table = new SQLTable();
        initComponents();
        switchState(false);
    }
    
    private void switchState(boolean state) {
        ScrollPane_Info.setVisible(state);
        Panel_Function.setVisible(state);
        Icon_Search.setVisible(state);
        TextField_SearchContent.setText("");
        TextField_SearchContent.setVisible(state);
        Slide.setVisible(!state);
    }
    
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel_Tabs = new javax.swing.JPanel();
        Label_Home = new javax.swing.JLabel();
        Label_CheckIn = new javax.swing.JLabel();
        Label_CreateReceipt = new javax.swing.JLabel();
        Label_Receipt = new javax.swing.JLabel();
        ScrollPane_Info = new javax.swing.JScrollPane();
        Table_Info = new javax.swing.JTable();
        Panel_Function = new javax.swing.JPanel();
        Button_Remove = new javax.swing.JButton();
        Button_Update = new javax.swing.JButton();
        Icon_Search = new javax.swing.JLabel();
        Slide = new javax.swing.JLabel();
        TextField_SearchContent = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Employee");
        setResizable(false);

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

        Label_CheckIn.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        Label_CheckIn.setForeground(new java.awt.Color(255, 255, 255));
        Label_CheckIn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Label_CheckIn.setText("Check In");
        Label_CheckIn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label_CheckInMouseClicked(evt);
            }
        });

        Label_CreateReceipt.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        Label_CreateReceipt.setForeground(new java.awt.Color(255, 255, 255));
        Label_CreateReceipt.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Label_CreateReceipt.setText("Create Receipt");
        Label_CreateReceipt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label_CreateReceiptMouseClicked(evt);
            }
        });

        Label_Receipt.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        Label_Receipt.setForeground(new java.awt.Color(255, 255, 255));
        Label_Receipt.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Label_Receipt.setText("Receipt Management");
        Label_Receipt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label_ReceiptMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout Panel_TabsLayout = new javax.swing.GroupLayout(Panel_Tabs);
        Panel_Tabs.setLayout(Panel_TabsLayout);
        Panel_TabsLayout.setHorizontalGroup(
            Panel_TabsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_TabsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_TabsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Label_CreateReceipt, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(Panel_TabsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(Label_Home, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                        .addComponent(Label_CheckIn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(Label_Receipt, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Panel_TabsLayout.setVerticalGroup(
            Panel_TabsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_TabsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Label_Home, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Label_CheckIn, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Label_Receipt, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Label_CreateReceipt, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(526, Short.MAX_VALUE))
        );

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

        Button_Remove.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        Button_Remove.setText("Remove");
        Button_Remove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Button_RemoveMouseClicked(evt);
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
                    .addComponent(Button_Update, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        Panel_FunctionLayout.setVerticalGroup(
            Panel_FunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_FunctionLayout.createSequentialGroup()
                .addComponent(Button_Remove, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Button_Update, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Icon_Search.setBackground(new java.awt.Color(255, 255, 255));
        Icon_Search.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Icon_Search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ic_search.png"))); // NOI18N
        Icon_Search.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Slide.setMaximumSize(new java.awt.Dimension(1050, 670));
        Slide.setMinimumSize(new java.awt.Dimension(1050, 670));
        Slide.setPreferredSize(new java.awt.Dimension(1050, 670));

        TextField_SearchContent.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        TextField_SearchContent.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        TextField_SearchContent.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TextField_SearchContentKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Panel_Tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Icon_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(TextField_SearchContent, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ScrollPane_Info, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Slide, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addComponent(Panel_Function, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel_Tabs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Icon_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TextField_SearchContent, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Panel_Function, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ScrollPane_Info, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(Slide, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Label_HomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label_HomeMouseClicked
        switchState(false);
    }//GEN-LAST:event_Label_HomeMouseClicked

    private void Label_CheckInMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label_CheckInMouseClicked
        // Check if already check in
        // if not insert
        if (PhanCongController.check(MaNV)) {
            PhanCongController.add(MaNV);
            JOptionPane.showMessageDialog(null, "Check in complete");
        }
        else 
            JOptionPane.showMessageDialog(null, "Employee aldready check in");
    }//GEN-LAST:event_Label_CheckInMouseClicked

    private void Label_CreateReceiptMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label_CreateReceiptMouseClicked
        ReceiptForm form = new ReceiptForm();
        form.setVisible(true);
    }//GEN-LAST:event_Label_CreateReceiptMouseClicked

    private void Button_RemoveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button_RemoveMouseClicked
        int RowID = Table_Info.getSelectedRow();
  
        if (JOptionPane.showConfirmDialog(null, "Are you sure?", "WARNING",
            JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                if (RowID >= 0) {
                    String ID = (String) Table_Info.getValueAt(RowID, 0);
                    
                    HoaDonController.delete(ID);
                    
                    DefaultTableModel model = (DefaultTableModel) Table_Info.getModel();
                    model.removeRow(RowID);             
                }
            }
    }//GEN-LAST:event_Button_RemoveMouseClicked

    private void Button_UpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Button_UpdateMouseClicked
       
    }//GEN-LAST:event_Button_UpdateMouseClicked

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
    
    private void Label_ReceiptMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label_ReceiptMouseClicked
        switchState(true);
        set_Table("HOADON");
    }//GEN-LAST:event_Label_ReceiptMouseClicked

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
            java.util.logging.Logger.getLogger(EmployeeHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_Remove;
    private javax.swing.JButton Button_Update;
    private javax.swing.JLabel Icon_Search;
    private javax.swing.JLabel Label_CheckIn;
    private javax.swing.JLabel Label_CreateReceipt;
    private javax.swing.JLabel Label_Home;
    private javax.swing.JLabel Label_Receipt;
    private javax.swing.JPanel Panel_Function;
    private javax.swing.JPanel Panel_Tabs;
    private static javax.swing.JScrollPane ScrollPane_Info;
    private javax.swing.JLabel Slide;
    private static javax.swing.JTable Table_Info;
    private javax.swing.JTextField TextField_SearchContent;
    // End of variables declaration//GEN-END:variables
}
