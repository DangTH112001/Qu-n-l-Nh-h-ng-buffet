/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import DBObject.SQLTable;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author NTTV
 */
public class ReportForm extends javax.swing.JFrame {
    Object[] SalaryCol = {"Name", "Normal Shift", "Overtime", "Salary"};
    private SQLTable table;

    public ReportForm() throws SQLException, ClassNotFoundException {
        initComponents();
        setTitle("Report");

        table = new SQLTable();
        tf_yearChart.setText("2021");
        showRevenueChart();

        showSalary();
    }

    private void showSalary() {
        tb_Salary.setModel(new DefaultTableModel(null, SalaryCol) {
            @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                } 
        });
        
        String query = "SELECT\n" +
                        "    NHANVIEN.HOTEN AS A, " +
                        "    CATHUONG(NHANVIEN.MANV, ?) AS B, " +
                        "    TANGCA(NHANVIEN.MANV, ?) AS C, " +
                        "    GET_SALARY(NHANVIEN.MANV, CATHUONG(NHANVIEN.MANV, ?), TANGCA(NHANVIEN.MANV, ?)) AS D " +
                        "FROM (PHANCONG INNER JOIN NHANVIEN " +
                        "        ON NHANVIEN.MANV = PHANCONG.MANV) INNER JOIN CA " +
                        "                                            ON PHANCONG.MACA = CA.MACA " +
                        "WHERE EXTRACT(MONTH FROM PHANCONG.NGLAM) = ? " +
                        "GROUP BY NHANVIEN.MANV, NHANVIEN.HOTEN";
        
        try {
            PreparedStatement st = SQLTable.connection.prepareStatement(query);
        
            int val = getMonth((String) cb_Month.getSelectedItem());
                
            st.setInt(1, val);
            st.setInt(2, val);
            st.setInt(3, val);
            st.setInt(4, val);
            st.setInt(5, val);  

            ResultSet rs = st.executeQuery();

            DefaultTableModel tableModel = (DefaultTableModel) tb_Salary.getModel();

            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                int sal = rs.getInt(3);
                String role = rs.getString(4);

                tableModel.addRow(new Object[]{
                    id, name, sal, role
                });
            }
        }
        catch (Exception ex) {
            
        }
    }
    
    private int getMonth(String Month) {
        int res = -1;
        switch (Month) {
            case "JAN" : res = 1; break;
            case "FEB" : res = 2; break;
            case "MAR" : res = 3; break;
            case "APR" : res = 4; break;
            case "MAY" : res = 5; break;
            case "JUN" : res = 6; break;
            case "JUL" : res = 7; break;
            case "AUG" : res = 8; break;
            case "SEP" : res = 9; break;
            case "OCT" : res = 10; break;
            case "NOV" : res = 11; break;
            case "DEC" : res = 12; break;  
        }
        return res;
    }

    private void showRevenueChart() throws SQLException, ClassNotFoundException {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        String year = tf_yearChart.getText();

        String sql = "SELECT TRUNC(NGHD), SUM(TONGTIEN) "
                + "FROM HOADON "
                + "WHERE EXTRACT (YEAR FROM NGHD) = ? "
                + "GROUP BY TRUNC(NGHD) ";

        PreparedStatement pt = SQLTable.connection.prepareStatement(sql);
        pt.setString(1, year);

        ResultSet rs = pt.executeQuery();

        if (!rs.isBeforeFirst()) {
            JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f, "No data to show, please check again!");
            return;
        }

        while (rs.next()) {
            Date day = rs.getDate(1);
            int revenue = rs.getInt(2);
            System.out.println("Day:" + day + "\tRevenue:" + revenue);
            dataset.addValue(revenue, "Revenue", day);
        }

        JFreeChart chart = ChartFactory.createLineChart("REVENUE BY YEAR " + year, "Day", "Revenue", dataset);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(pnChart.getWidth(), pnChart.getHeight()));
        pnChart.removeAll();
        pnChart.setLayout(new CardLayout());
        pnChart.add(chartPanel);
        pnChart.revalidate();
        pnChart.repaint();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        mainPanel = new javax.swing.JPanel();
        pnChart = new javax.swing.JPanel();
        tf_yearChart = new javax.swing.JTextField();
        btn_checkChart = new javax.swing.JButton();
        btn_exportRevenue = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_Salary = new javax.swing.JTable();
        btn_exportSalary = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        lb_Month = new javax.swing.JLabel();
        cb_Month = new javax.swing.JComboBox<>();

        jButton1.setText("jButton1");

        jButton2.setText("jButton2");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        mainPanel.setBackground(new java.awt.Color(23, 35, 51));
        mainPanel.setToolTipText("");

        javax.swing.GroupLayout pnChartLayout = new javax.swing.GroupLayout(pnChart);
        pnChart.setLayout(pnChartLayout);
        pnChartLayout.setHorizontalGroup(
            pnChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 832, Short.MAX_VALUE)
        );
        pnChartLayout.setVerticalGroup(
            pnChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 327, Short.MAX_VALUE)
        );

        tf_yearChart.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tf_yearChart.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        btn_checkChart.setText("Check");
        btn_checkChart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_checkChartMouseClicked(evt);
            }
        });

        btn_exportRevenue.setText("Export");
        btn_exportRevenue.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_exportRevenueMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("YEAR");

        tb_Salary.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Salary", "Roll"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tb_Salary);

        btn_exportSalary.setText("Export");
        btn_exportSalary.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_exportSalaryMouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("SALARY");

        lb_Month.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lb_Month.setForeground(new java.awt.Color(255, 255, 255));
        lb_Month.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_Month.setText("MONTH");

        cb_Month.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC" }));
        cb_Month.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_MonthItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(376, 376, 376)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane2)
                            .addComponent(pnChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_checkChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tf_yearChart)
                            .addComponent(btn_exportRevenue, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lb_Month, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_exportSalary, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cb_Month, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_yearChart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_checkChart)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_exportRevenue))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnChart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 20, Short.MAX_VALUE)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(lb_Month)
                        .addGap(8, 8, 8)
                        .addComponent(cb_Month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_exportSalary)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_checkChartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_checkChartMouseClicked
        try {
            pnChart.removeAll();
            pnChart.setLayout(new CardLayout());
            showRevenueChart();
        } catch (SQLException ex) {
            System.out.println("Không thể xuất biểu đồ");
            Logger.getLogger(ReportForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReportForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_checkChartMouseClicked

    private void btn_exportRevenueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_exportRevenueMouseClicked
        showBaoCao();
    }//GEN-LAST:event_btn_exportRevenueMouseClicked

    private void showBaoCao() {
        Map parameters = new HashMap();
        parameters.put("YEAR", Integer.parseInt(tf_yearChart.getText()));
        try {        
            JasperDesign jd = JRXmlLoader.load("src\\report\\rpBaoCao.jrxml");
            JasperReport jr = JasperCompileManager.compileReport(jd);
            JasperPrint jp = JasperFillManager.fillReport(jr, parameters, SQLTable.connection);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(ReportForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void btn_exportSalaryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_exportSalaryMouseClicked
        Map parameters = new HashMap();
        parameters.put("MONTH", getMonth((String) cb_Month.getSelectedItem()));
        try {        
            JasperDesign jd = JRXmlLoader.load("src\\report\\LuongThang.jrxml");
            JasperReport jr = JasperCompileManager.compileReport(jd);
            JasperPrint jp = JasperFillManager.fillReport(jr, parameters, SQLTable.connection);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(ReportForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_exportSalaryMouseClicked

    private void cb_MonthItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_MonthItemStateChanged
        showSalary();
    }//GEN-LAST:event_cb_MonthItemStateChanged

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ReportForm().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(ReportForm.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ReportForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_checkChart;
    private javax.swing.JButton btn_exportRevenue;
    private javax.swing.JButton btn_exportSalary;
    private javax.swing.JComboBox<String> cb_Month;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lb_Month;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel pnChart;
    private javax.swing.JTable tb_Salary;
    private javax.swing.JTextField tf_yearChart;
    // End of variables declaration//GEN-END:variables
}
