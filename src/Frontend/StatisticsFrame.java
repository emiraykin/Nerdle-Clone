package Frontend;

import Core.Statistics;

import static Core.Statistics.readStatistics;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template


/**
 *
 * @author emirm
 */
public class StatisticsFrame extends javax.swing.JFrame {

    /**
     * Creates new form Frontend.StatisticsFrame
     */
    public StatisticsFrame() {
        initComponents();
        this.setLocationRelativeTo(null);
        try {
            Statistics stats = readStatistics();
            lblCompleteds.setText(String.valueOf(stats.getVictory()));
            lblFaileds.setText(String.valueOf(stats.getLosses()));
            lblUncompleteds.setText(String.valueOf(stats.getUnfinishedGames()));
            lblCompAttemps.setText(String.valueOf(stats.getAvgFinishAtLines()));
            lblCompTime.setText(String.valueOf(stats.getAvgSuccessTime()));
        }
        catch (Exception e){
            //e.printStackTrace();
            lblCompleteds.setText("-");
            lblFaileds.setText("-");
            lblUncompleteds.setText("-");
            lblCompAttemps.setText("-");
            lblCompTime.setText("-");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        lblGamesFailed = new javax.swing.JLabel();
        lblGamesCompleted = new javax.swing.JLabel();
        lblGamesUncompleted = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblAvgCompTime = new javax.swing.JLabel();
        lblAvgCompAttemps = new javax.swing.JLabel();
        lblCompleteds = new javax.swing.JLabel();
        lblUncompleteds = new javax.swing.JLabel();
        lblFaileds = new javax.swing.JLabel();
        lblCompTime = new javax.swing.JLabel();
        lblCompAttemps = new javax.swing.JLabel();
        btngoBack = new javax.swing.JButton();
        lblFooter = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblGamesFailed.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblGamesFailed.setText("Games Failed :");

        lblGamesCompleted.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblGamesCompleted.setText("Games Completed  :");

        lblGamesUncompleted.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblGamesUncompleted.setText("Games Uncompleted :");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        lblAvgCompTime.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblAvgCompTime.setText("Avarage complete time :");

        lblAvgCompAttemps.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblAvgCompAttemps.setText("Avarage complete attemps :");

        lblCompleteds.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblCompleteds.setForeground(new java.awt.Color(51, 153, 0));
        lblCompleteds.setText("-");

        lblUncompleteds.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblUncompleteds.setForeground(new java.awt.Color(204, 204, 0));
        lblUncompleteds.setText("-");

        lblFaileds.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblFaileds.setForeground(new java.awt.Color(204, 0, 0));
        lblFaileds.setText("-");

        lblCompTime.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblCompTime.setForeground(new java.awt.Color(51, 153, 0));
        lblCompTime.setText("-");

        lblCompAttemps.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblCompAttemps.setForeground(new java.awt.Color(51, 153, 0));
        lblCompAttemps.setText("-");

        btngoBack.setText("Go Back");
        btngoBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btngoBackActionPerformed(evt);
            }
        });

        lblFooter.setText("5 - 20011103 Mehmet Keçeci - 20011062 Emir Çağrı Aykın");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(140, 140, 140)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(lblGamesUncompleted)
                                                        .addComponent(lblGamesCompleted)
                                                        .addComponent(lblGamesFailed)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(lblAvgCompTime))
                                                        .addComponent(lblAvgCompAttemps))
                                                .addGap(49, 49, 49)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(lblCompleteds)
                                                        .addComponent(lblUncompleteds)
                                                        .addComponent(lblFaileds)
                                                        .addComponent(lblCompTime)
                                                        .addComponent(lblCompAttemps)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(lblFooter)
                                                        .addComponent(btngoBack, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(253, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addContainerGap(385, Short.MAX_VALUE)
                                        .addComponent(jLabel6)
                                        .addGap(365, 365, 365)))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(98, 98, 98)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblGamesCompleted)
                                        .addComponent(lblCompleteds))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblGamesUncompleted)
                                        .addComponent(lblUncompleteds))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblGamesFailed)
                                        .addComponent(lblFaileds))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addGap(5, 5, 5)
                                                .addComponent(jLabel4))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(lblAvgCompTime)
                                                .addComponent(lblCompTime)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblAvgCompAttemps)
                                        .addComponent(lblCompAttemps))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                                .addComponent(btngoBack, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblFooter)
                                .addContainerGap())
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addContainerGap(258, Short.MAX_VALUE)
                                        .addComponent(jLabel6)
                                        .addGap(242, 242, 242)))
        );

        pack();
    }// </editor-fold>

    private void btngoBackActionPerformed(java.awt.event.ActionEvent evt) {
        GUI gui = new GUI();
        gui.setVisible(true);

        this.dispose();           // TODO add your handling code here:
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
            java.util.logging.Logger.getLogger(StatisticsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StatisticsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StatisticsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StatisticsFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StatisticsFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton btngoBack;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lblAvgCompAttemps;
    private javax.swing.JLabel lblAvgCompTime;
    private javax.swing.JLabel lblCompAttemps;
    private javax.swing.JLabel lblCompTime;
    private javax.swing.JLabel lblCompleteds;
    private javax.swing.JLabel lblFaileds;
    private javax.swing.JLabel lblFooter;
    private javax.swing.JLabel lblGamesCompleted;
    private javax.swing.JLabel lblGamesFailed;
    private javax.swing.JLabel lblGamesUncompleted;
    private javax.swing.JLabel lblUncompleteds;
    // End of variables declaration
}
