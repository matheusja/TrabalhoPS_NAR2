/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Frame;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.commons.io.FileUtils;


/**
 *
 * @author oem
 */
public class Tela_Inicial extends javax.swing.JFrame {

    private Frame Tela_Inicial;

    /**
     * Creates new form Tela_Inicial
     */
    public Tela_Inicial() {
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Cod_generated_JText = new javax.swing.JTextArea();
        Cod_Read_JText = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        abrir_file_jb = new javax.swing.JButton();
        Montar_jb = new javax.swing.JButton();
        Avançar_jb = new javax.swing.JButton();
        Retornar_jb = new javax.swing.JButton();
        Executar_jb = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        Cod_generated_JText.setColumns(20);
        Cod_generated_JText.setRows(5);
        jScrollPane1.setViewportView(Cod_generated_JText);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)
            .addComponent(Cod_Read_JText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(Cod_Read_JText, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Edit", jPanel1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 373, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 432, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Execute", jPanel2);

        jToolBar1.setRollover(true);

        abrir_file_jb.setText("Abrir Arquivo");
        abrir_file_jb.setFocusable(false);
        abrir_file_jb.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        abrir_file_jb.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        abrir_file_jb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrir_file_jbActionPerformed(evt);
            }
        });
        jToolBar1.add(abrir_file_jb);

        Montar_jb.setText("Montar");
        Montar_jb.setFocusable(false);
        Montar_jb.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Montar_jb.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(Montar_jb);

        Avançar_jb.setText("Avançar");
        Avançar_jb.setFocusable(false);
        Avançar_jb.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Avançar_jb.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(Avançar_jb);

        Retornar_jb.setText("Retornar");
        Retornar_jb.setFocusable(false);
        Retornar_jb.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Retornar_jb.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(Retornar_jb);

        Executar_jb.setText("Executar");
        Executar_jb.setFocusable(false);
        Executar_jb.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Executar_jb.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(Executar_jb);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 391, Short.MAX_VALUE))
                .addGap(777, 777, 777))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, Short.MAX_VALUE)
                .addGap(113, 113, 113)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(215, 215, 215))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void abrir_file_jbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrir_file_jbActionPerformed
        
        JFileChooser fileChooser = new JFileChooser();                                  // cria um objeto para abrir o arquivo
        fileChooser.setDialogTitle ("Selecione o Arquivo TXT a Ser Aberto");            // titulo da caixa de seleção de arquivo
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);                      // set para apenas arquivos
        FileNameExtensionFilter filter = new FileNameExtensionFilter ("Texto","txt");   // configura o tipo de arquivo para aceitar apenas txt
        fileChooser.setFileFilter(filter);                                              // aplica o filtro.
        fileChooser.showOpenDialog(this);
        File arq = fileChooser.getSelectedFile();                                 // pega o arquivo selecionado 
            
             if (arq == null){
                 JDialog aviso = new JDialog (Tela_Inicial, true);
                 aviso.add (new JLabel ("Arquivo invalido ou vazio"));
                 aviso.setVisible(true);
             }
         
          String conteudo ="";
        try {
            conteudo = FileUtils.readFileToString(arq);
        } catch (IOException ex) {
            Logger.getLogger(Tela_Inicial.class.getName()).log(Level.SEVERE, null, ex);
        }
          Cod_Read_JText.setText(conteudo);
    
    }//GEN-LAST:event_abrir_file_jbActionPerformed

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
            java.util.logging.Logger.getLogger(Tela_Inicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_Inicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_Inicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_Inicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela_Inicial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Avançar_jb;
    private javax.swing.JLabel Cod_Read_JText;
    private javax.swing.JTextArea Cod_generated_JText;
    private javax.swing.JButton Executar_jb;
    private javax.swing.JButton Montar_jb;
    private javax.swing.JButton Retornar_jb;
    private javax.swing.JButton abrir_file_jb;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}