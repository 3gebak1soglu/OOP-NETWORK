package aoopproject.GUI;

import aoopproject.FriendManager;
import aoopproject.FriendRequestManager;
import aoopproject.UserManager;
import aoopproject.User;
import aoopproject.UserSingleton;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class SearchUsers extends javax.swing.JFrame {
    private DefaultListModel listModel;
    private final User currentUser;
    
    public SearchUsers() {
        initComponents();
        currentUser = UserSingleton.getInstance().getCurrentUser();
        listModel = new DefaultListModel();
        usersList.setModel(listModel);
        populateUserList();
    }
    
    private void populateUserList(){
        List<User> users = UserManager.getAllUsersFromFile(currentUser.getUsername());
        
        listModel.clear();
        for (User user : users) {
            if (user.toString().toLowerCase().contains(searchField.getText().toLowerCase())) {
                listModel.addElement(user);
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        usersList = new javax.swing.JList<>();
        sendFriendRequestButton = new javax.swing.JButton();
        openWallButton = new javax.swing.JButton();
        searchField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        usersList.setBackground(new java.awt.Color(245, 245, 245));
        usersList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(usersList);

        sendFriendRequestButton.setBackground(new java.awt.Color(255, 51, 51));
        sendFriendRequestButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        sendFriendRequestButton.setForeground(new java.awt.Color(255, 255, 255));
        sendFriendRequestButton.setText("Send Friend Request");
        sendFriendRequestButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendFriendRequestButtonActionPerformed(evt);
            }
        });

        openWallButton.setBackground(new java.awt.Color(255, 51, 51));
        openWallButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        openWallButton.setForeground(new java.awt.Color(255, 255, 255));
        openWallButton.setText("See Wall");
        openWallButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openWallButtonActionPerformed(evt);
            }
        });

        searchField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        searchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFieldActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel1.setText("Search Users");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sendFriendRequestButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(openWallButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(243, 243, 243)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(openWallButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(sendFriendRequestButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void sendFriendRequestButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendFriendRequestButtonActionPerformed
        // TODO add your handling code here:
        User selectedUser = usersList.getSelectedValue();
        if (selectedUser != null) {
            List<String> sendingRequests = FriendRequestManager.getSendingFriendRequests(currentUser.getUsername());
            List<String> recievedRequests = FriendRequestManager.getPendingFriendRequests(currentUser.getUsername());
            List<String> friends = FriendManager.readFriendsFromFile(currentUser.getUsername());
        
            if (sendingRequests.contains(selectedUser.getUsername())) {
                JOptionPane.showMessageDialog(this, "You already sent a request to " + selectedUser.getUsername() + "!");
            }
            else if (recievedRequests.contains(selectedUser.getUsername())) {
                JOptionPane.showMessageDialog(this, selectedUser.getUsername() + "already sent you a request!");
            }
            else if (friends.contains(selectedUser.getUsername())) {
                JOptionPane.showMessageDialog(this, "You are already friends with " + selectedUser.getUsername() + "!");
            }
            else {
                FriendRequestManager.sendFriendRequest(currentUser.getUsername(), selectedUser.getUsername());
                JOptionPane.showMessageDialog(this, "Friend request sent!");
            }
        }
        else {
            JOptionPane.showMessageDialog(this, "Please select a user first");
        }
    }//GEN-LAST:event_sendFriendRequestButtonActionPerformed

    private void openWallButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openWallButtonActionPerformed
        User selectedUser = usersList.getSelectedValue();
        if (selectedUser != null) {
            UserWall userWall = new UserWall(selectedUser);
            userWall.setVisible(true);
        }
        else {
            JOptionPane.showMessageDialog(this, "Please choose a user first");
        }
    }//GEN-LAST:event_openWallButtonActionPerformed

    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFieldActionPerformed
        // TODO add your handling code here:
        populateUserList();
    }//GEN-LAST:event_searchFieldActionPerformed

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
            java.util.logging.Logger.getLogger(SearchUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new SearchUsers().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton openWallButton;
    private javax.swing.JTextField searchField;
    private javax.swing.JButton sendFriendRequestButton;
    private javax.swing.JList<User> usersList;
    // End of variables declaration//GEN-END:variables
}
