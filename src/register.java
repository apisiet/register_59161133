
import com.mongodb.*;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import static com.mongodb.client.model.Filters.eq;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import org.bson.Document;

 // @author NIRADA SUKCHIT
public class register extends javax.swing.JFrame {
//Creates new form register
public register() {
    initComponents();
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        register = new javax.swing.JLabel();
        username = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        Pass = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        Confirm = new javax.swing.JLabel();
        txtConfirm = new javax.swing.JPasswordField();
        email = new javax.swing.JLabel();
        txtNickName = new javax.swing.JTextField();
        btnCancel = new javax.swing.JButton();
        btnOK = new javax.swing.JButton();
        BG = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 255, 153));
        setResizable(false);
        setSize(new java.awt.Dimension(400, 600));

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        register.setFont(new java.awt.Font("TH SarabunPSK", 1, 42)); // NOI18N
        register.setText("ลงทะเบียน");
        jPanel2.add(register, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, -1, -1));

        username.setFont(new java.awt.Font("TH SarabunPSK", 1, 24)); // NOI18N
        username.setText("ชื่อผู้ใช้: ");
        jPanel2.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, -1, -1));

        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });
        jPanel2.add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, 180, 30));

        Pass.setFont(new java.awt.Font("TH SarabunPSK", 1, 24)); // NOI18N
        Pass.setText("รหัสผ่าน:");
        jPanel2.add(Pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, -1, -1));
        jPanel2.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 180, 30));

        Confirm.setFont(new java.awt.Font("TH SarabunPSK", 1, 24)); // NOI18N
        Confirm.setText("ยืนยันรหัสผ่าน:");
        jPanel2.add(Confirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, -1, -1));
        jPanel2.add(txtConfirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, 180, 30));

        email.setFont(new java.awt.Font("TH SarabunPSK", 1, 24)); // NOI18N
        email.setText("E-mail : ");
        jPanel2.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, -1, -1));
        jPanel2.add(txtNickName, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 210, 180, 30));

        btnCancel.setBackground(new java.awt.Color(255, 153, 255));
        btnCancel.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        btnCancel.setText("ยกเลิก");
        jPanel2.add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 260, -1, -1));

        btnOK.setBackground(new java.awt.Color(255, 153, 255));
        btnOK.setFont(new java.awt.Font("TH SarabunPSK", 1, 20)); // NOI18N
        btnOK.setText("ลงทะเบียน");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });
        jPanel2.add(btnOK, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 260, -1, -1));
        jPanel2.add(BG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 550, 360));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public static boolean booleancheckID = false;
    public void submitRegister(){
        
        MongoClientURI uri  = new MongoClientURI("mongodb://ox59161133:Sang0892484688@ds215502.mlab.com:15502/59161133apisiet");
        MongoClient client = new MongoClient(uri);
        MongoDatabase db = client.getDatabase(uri.getDatabase());
      
        MongoCollection<Document> user = db.getCollection("register");
        
        List<Document> seedData = new ArrayList<Document>();

        seedData.add(new Document("Username",txtUsername.getText())
                .append("Password", txtPassword.getText())
                .append("E-mail", txtNickName.getText())
               
        );
        user.insertMany(seedData);
            JLabel label = new JLabel("สมัครเรียบร้อย");
            label.setFont(new Font("TH SarabunPSK", Font.BOLD, 18));
            JOptionPane.showMessageDialog(this, label);
        
        client.close(); 
    }
    public boolean confirmPass(){
        if(txtPassword.getText().equals(txtConfirm.getText())){
            System.out.println("ซ้ำ");
            return true;
        }else {
            return false;
        }
    }
    public void checkID(){
        
        MongoClientURI uri  = new MongoClientURI("mongodb://ox59161133:Sang0892484688@ds215502.mlab.com:15502/59161133apisiet");
        MongoClient client = new MongoClient(uri);
        MongoDatabase db = client.getDatabase(uri.getDatabase());
        
        MongoCollection<Document> user = db.getCollection("register");
       
        try {
            
            Document myDoc = user.find(eq("ID", txtUsername.getText())).first();
            System.out.println(myDoc.toJson());
            booleancheckID = true;
            
        } catch (Exception e) {
            System.out.println("ดักว่าไอดีไม่ซ้ำ");
            //ดักไอดีซ้ำและคืนค่า Boolean
            booleancheckID = false;
        }      
    }
    public boolean checkEmpty(){
        if(txtUsername.getText().equals("")||txtPassword.getText().equals("")||txtNickName.getText().equals("")){
           
            return true;
        }else {
            return false;
        }     
    }
    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
       confirmPass();
        checkID();
        checkEmpty();
        confirmPass();
        if(booleancheckID){
            JLabel label = new JLabel("มีไอดีนี้อยู่ในระบบแล้ว");
            label.setFont(new Font("TH SarabunPSK", Font.BOLD, 18));
            JOptionPane.showMessageDialog(null,label,"ERROR",JOptionPane.WARNING_MESSAGE);

            reset();
        }else{
            if(checkEmpty()){
                JLabel label = new JLabel("กรุณากรอกข้อมูลให้ครบถ้วน");
                label.setFont(new Font("TH SarabunPSK", Font.BOLD, 18));
                JOptionPane.showMessageDialog(null,label,"ERROR",JOptionPane.WARNING_MESSAGE);
                reset();

            }else if(!checkEmpty()){
                if(!confirmPass()){
                    JLabel label = new JLabel("Password ไม่ตรงกัน");
                    label.setFont(new Font("TH SarabunPSK ", Font.BOLD, 18));
                    JOptionPane.showMessageDialog(null,label,"ERROR",JOptionPane.WARNING_MESSAGE);
                    reset();
                }
                else{
                    submitRegister();
                    reset();
                }

            }
        }
    }//GEN-LAST:event_btnOKActionPerformed

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsernameActionPerformed

 public void submit(){
        
        MongoClientURI uri  = new MongoClientURI("mongodb://ox59160104:g59160104@ds251902.mlab.com:51902/nirada59160104");
       
        MongoClient client = new MongoClient(uri);
        MongoDatabase db = client.getDatabase(uri.getDatabase());
      
        MongoCollection<Document> user = db.getCollection("register");
        
        List<Document> seedData = new ArrayList<Document>();

        seedData.add(new Document("Username",txtUsername.getText())
                .append("Password", txtPassword.getText())
                .append("NickName", txtNickName.getText()) 
        );
        user.insertMany(seedData);
        JOptionPane.showMessageDialog(this, "สมัครเรียบร้อย");
    
        client.close(); 
    }
 
    public void reset(){
        
        txtUsername.setText("");
        txtPassword.setText("");
        txtConfirm.setText("");
        txtNickName.setText("");
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
            java.util.logging.Logger.getLogger(register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BG;
    private javax.swing.JLabel Confirm;
    private javax.swing.JLabel Pass;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnOK;
    private javax.swing.JLabel email;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel register;
    private javax.swing.JPasswordField txtConfirm;
    private javax.swing.JTextField txtNickName;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    private javax.swing.JLabel username;
    // End of variables declaration//GEN-END:variables
}
