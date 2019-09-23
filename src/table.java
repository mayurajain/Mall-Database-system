
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class table extends javax.swing.JFrame {

    private String floor = null;
    private String category = null;
    private String sales = null;
    
    /**
     * Creates new form table
     */
    public table() {
        initComponents();
        show_user();
    }

    public table(String category, String floor, String sales) {
        this.category = category;              
        this.floor = floor;
        this.sales = sales;
    
        initComponents();
        show_user();
    }
    
   public ArrayList<User>userList(){
        ArrayList<User>usersList=new ArrayList<>();
        try{
          
         
//         String floor="";
//       String category="";
//      String sales="";
           Class.forName("com.mysql.jdbc.Driver");
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/malldb","root","");
//         String query1="SELECT * FROM shops where floor='"+floor+"' and category='"+category+"' and sales='"+sales+"'";
           String baseSearchQuery = "SELECT * FROM shops ";
           String searchCriteria = null;
           boolean whereAdded = false;
        
           if (floor != null && !floor.isEmpty()) {
               if (!whereAdded) {
                   whereAdded = true;
                   searchCriteria = " where floor='" + floor + "'";
               }
               else
                   searchCriteria = searchCriteria + " and floor = '" + floor + "'";
           }
           
           if (category != null && !category.isEmpty()) {
               if (!whereAdded) {
                   whereAdded = true;
                   searchCriteria = " where category='" + category + "'";
               }
               else
                   searchCriteria = searchCriteria + " and category = '" + category + "'";
           }
           
           if (sales != null && !sales.isEmpty()) {
               if (!whereAdded) {
                   whereAdded = true;
                   searchCriteria = " where sales='" + sales + "'";
               }
               else
                   searchCriteria = searchCriteria + " and sales = '" + sales + "'";
           }
           
           String searchQuery = baseSearchQuery;
           if (searchCriteria != null)
                 searchQuery = baseSearchQuery + searchCriteria;
           Statement st= con.createStatement();
           ResultSet rs= st.executeQuery(searchQuery);
           User user;
           while(rs.next()){
               user=new User(rs.getInt("shopid"),rs.getString("shopname"),rs.getString("category"),rs.getInt("phonenumber"),rs.getInt("floor"),rs.getString("sales"),rs.getString("timings"));
               usersList.add(user);
           }
        }
        catch(Exception e){
           JOptionPane.showMessageDialog(null,e);
       }
        return usersList;
        
    }
    public void show_user(){
        ArrayList<User>list=userList();
        DefaultTableModel model=(DefaultTableModel)result.getModel();
        Object[] row =new Object[7];
        for(int i=0;i<list.size();i++)
        {    row[0]=list.get(i).getshopid();

            row[1]=list.get(i).getshopname();
            row[2]=list.get(i).getcategory();
            row[3]=list.get(i).getphonenumber();
            row[4]=list.get(i).getfloor();
            row[5]=list.get(i).getsales();
            row[6]=list.get(i).gettimings();
            model.addRow(row);
        }
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        result = new javax.swing.JTable();
        back = new javax.swing.JButton();
        home = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        sub = new javax.swing.JButton();
        shoprequest = new javax.swing.JButton();
        complaint = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1350, 700));

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        result.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "shopid", "shopname", "category", "phonenumber", "floor", "ongoingsales", "timings"
            }
        ));
        jScrollPane1.setViewportView(result);

        back.setForeground(new java.awt.Color(255, 255, 255));
        back.setText("Back");
        back.setBorderPainted(false);
        back.setContentAreaFilled(false);
        back.setFocusPainted(false);
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        home.setForeground(new java.awt.Color(255, 255, 255));
        home.setText("Home");
        home.setBorderPainted(false);
        home.setContentAreaFilled(false);
        home.setDefaultCapable(false);
        home.setFocusPainted(false);
        home.setFocusable(false);
        home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Here is list of shops matching your requirments...!");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("|");

        sub.setForeground(new java.awt.Color(255, 255, 255));
        sub.setText("Click here to subscribe for deal updates");
        sub.setBorderPainted(false);
        sub.setContentAreaFilled(false);
        sub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subActionPerformed(evt);
            }
        });

        shoprequest.setForeground(new java.awt.Color(255, 255, 255));
        shoprequest.setText("Click here to apply for shop request");
        shoprequest.setBorder(null);
        shoprequest.setBorderPainted(false);
        shoprequest.setContentAreaFilled(false);
        shoprequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shoprequestActionPerformed(evt);
            }
        });

        complaint.setBackground(new java.awt.Color(255, 255, 255));
        complaint.setForeground(new java.awt.Color(255, 255, 255));
        complaint.setText("Click here to file a complaint ");
        complaint.setBorderPainted(false);
        complaint.setContentAreaFilled(false);
        complaint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                complaintActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(back)
                        .addGap(5, 5, 5)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(home)
                        .addGap(60, 60, 60))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 110, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(shoprequest)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(complaint)
                        .addGap(291, 291, 291)
                        .addComponent(sub)
                        .addGap(95, 95, 95))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(home)
                            .addComponent(back)
                            .addComponent(jLabel2)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sub)
                    .addComponent(shoprequest)
                    .addComponent(complaint))
                .addContainerGap(194, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        searchPage page = new searchPage();
               page.setVisible(true);
               setVisible(false);
    }//GEN-LAST:event_backActionPerformed

    private void homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeActionPerformed
       Page1 page = new Page1();
        page.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_homeActionPerformed

    private void subActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subActionPerformed
        subscribe sub=new subscribe();
        sub.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_subActionPerformed

    private void shoprequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shoprequestActionPerformed
        ShopRequest request=new ShopRequest();
        request.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_shoprequestActionPerformed

    private void complaintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_complaintActionPerformed
        complaint comp=new complaint();
        comp.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_complaintActionPerformed

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
            java.util.logging.Logger.getLogger(table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new table().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JButton complaint;
    private javax.swing.JButton home;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable result;
    private javax.swing.JButton shoprequest;
    private javax.swing.JButton sub;
    // End of variables declaration//GEN-END:variables
}
