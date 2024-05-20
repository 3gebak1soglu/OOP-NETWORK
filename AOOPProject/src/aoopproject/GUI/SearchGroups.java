package aoopproject.GUI;

import aoopproject.Group;
import aoopproject.GroupManager;
import aoopproject.User;
import aoopproject.UserSingleton;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class SearchGroups extends javax.swing.JFrame {
    private DefaultListModel listModel;
    private final User currentUser;

    public SearchGroups() {
        initComponents();
        currentUser = UserSingleton.getInstance().getCurrentUser();
        listModel = new DefaultListModel();
        groupsList.setModel(listModel);
        populateGroupList();
    }
    
    private void populateGroupList(){
        List<Group> groups = GroupManager.getAllGroupsFromFile();
        
        listModel.clear();
        for (Group group : groups) {
            if (group.toString().toLowerCase().contains(searchField.getText().toLowerCase())) {
                listModel.addElement(group);
            }
        }
    }
    
    private boolean checkUserIsMember(Group group) {
        for (User user : group.getMembers()) {
            if (user.getUsername().equals(currentUser.getUsername())) {
                return true;
            }
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        groupsList = new javax.swing.JList<>();
        joinGroupButton = new javax.swing.JButton();
        openWallButton = new javax.swing.JButton();
        searchField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        groupsList.setBackground(new java.awt.Color(245, 245, 245));
        groupsList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(groupsList);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 84, 368, 365));

        joinGroupButton.setBackground(new java.awt.Color(255, 51, 51));
        joinGroupButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        joinGroupButton.setForeground(new java.awt.Color(255, 255, 255));
        joinGroupButton.setText("Join Group");
        joinGroupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                joinGroupButtonActionPerformed(evt);
            }
        });
        jPanel1.add(joinGroupButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 410, 156, -1));

        openWallButton.setBackground(new java.awt.Color(255, 51, 51));
        openWallButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        openWallButton.setForeground(new java.awt.Color(255, 255, 255));
        openWallButton.setText("See Group Wall");
        openWallButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openWallButtonActionPerformed(evt);
            }
        });
        jPanel1.add(openWallButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(401, 84, 156, -1));

        searchField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        searchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFieldActionPerformed(evt);
            }
        });
        jPanel1.add(searchField, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 35, 377, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel1.setText("Search Groups");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(243, 6, -1, 23));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void joinGroupButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_joinGroupButtonActionPerformed
        Group selectedGroup = groupsList.getSelectedValue();
        
        if (selectedGroup != null) {
            if (!checkUserIsMember(selectedGroup)) {
                currentUser.addGroup(selectedGroup);
                selectedGroup.addMember(currentUser);
                GroupManager.joinGroup(currentUser.getUsername(), selectedGroup.getGroupID());
                JOptionPane.showMessageDialog(this, "You joined the group!");
            }
            else {
                JOptionPane.showMessageDialog(this, "You are already a member!");
            }
        }
        else {
            JOptionPane.showMessageDialog(this, "Please select a group first");
        }
        
    }//GEN-LAST:event_joinGroupButtonActionPerformed

    private void openWallButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openWallButtonActionPerformed
        Group selectedGroup = groupsList.getSelectedValue();
        if (selectedGroup != null) {
            GroupWall groupWall = new GroupWall(selectedGroup, checkUserIsMember(selectedGroup));
            groupWall.setVisible(true);
        }
    }//GEN-LAST:event_openWallButtonActionPerformed

    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFieldActionPerformed
        // TODO add your handling code here:
        populateGroupList();
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
            java.util.logging.Logger.getLogger(SearchGroups.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchGroups.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchGroups.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchGroups.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchGroups().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<Group> groupsList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton joinGroupButton;
    private javax.swing.JButton openWallButton;
    private javax.swing.JTextField searchField;
    // End of variables declaration//GEN-END:variables
}
