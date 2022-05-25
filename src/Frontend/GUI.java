package Frontend;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author emirm
 */
public class GUI extends JFrame {

    /**
     * Creates new form NewJFrame1
     */
    public GUI() {
        initComponents();
        this.setLocationRelativeTo(null);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {


        jLabel3 = new JLabel();
        jLabel1 = new JLabel();
        btnContinue = new JButton();
        btnNewGame = new JButton();
        btnTest = new JButton();
        btnStatistics = new JButton();
        jLabel2 = new JLabel();



        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setText("NERDLE");

        btnContinue.setText("Continue");
        btnContinue.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnContinueActionPerformed(evt);
            }
        });

        btnNewGame.setText("New Game");
        btnNewGame.setActionCommand("");
        btnNewGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnNewGameActionPerformed(evt);
            }
        });

        btnTest.setText("Test");
        btnTest.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnTestActionPerformed(evt);
            }
        });

        btnStatistics.setText("Statistics");
        btnStatistics.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnStatisticsActionPerformed(evt);
            }
        });

        jLabel2.setText("5 - 20011103 Mehmet Keçeci - 20011062 Emir Çağrı Aykın");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(286, 286, 286)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(btnNewGame, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnContinue, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnTest, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnStatistics, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(239, 239, 239)
                                                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel2)))
                                .addContainerGap(266, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnNewGame, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnContinue, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnTest, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnStatistics, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>

    private void btnContinueActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void btnNewGameActionPerformed(ActionEvent evt) {
        NewGame newGame = new NewGame();
        newGame.setVisible(true);

        this.dispose();           // TODO add your handling code here:
    }

    private void btnTestActionPerformed(ActionEvent evt) {
        Test test = new Test();
        test.setVisible(true);

        this.dispose();
    }

    private void jButton4ActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void btnStatisticsActionPerformed(ActionEvent evt) {
        StatisticsFrame statisticsFrame = new StatisticsFrame();
        statisticsFrame.setVisible(true);

        this.dispose();
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
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private JButton btnContinue;
    private JButton btnNewGame;
    private JButton btnStatistics;
    private JButton btnTest;
    private JButton btnGoToTest;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;

    {
// Frontend.GUI initializer generated by IntelliJ IDEA Frontend.GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA Frontend.GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
    }
    // End of variables declaration
}