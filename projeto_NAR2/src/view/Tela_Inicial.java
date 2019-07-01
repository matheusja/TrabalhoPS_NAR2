package view;

import java.awt.Color;
import java.awt.Frame;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
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
       Color minhaCor = new Color(100, 100, 100);
        getContentPane().setBackground(minhaCor);
        ImageIcon icon = new ImageIcon("./logo.png");
        //Mostra_Logo.setIcon(icon);
        //Tela_Inicial.getContentPane().setBackground(Color.black);
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
        JPanel_ini = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Cod_Read_JText = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        Cod_generated_JText = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        Cod_Read_JText2 = new javax.swing.JTextArea();
        jScrollPane10 = new javax.swing.JScrollPane();
        Cod_generated_JText2 = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        Cod_Read_JText3 = new javax.swing.JTextArea();
        jScrollPane11 = new javax.swing.JScrollPane();
        Cod_generated_JText3 = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        Cod_Read_JText4 = new javax.swing.JTextArea();
        jScrollPane12 = new javax.swing.JScrollPane();
        Cod_generated_JText4 = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane13 = new javax.swing.JScrollPane();
        Cod_Read_JText5 = new javax.swing.JTextArea();
        jScrollPane14 = new javax.swing.JScrollPane();
        Cod_generated_JText5 = new javax.swing.JTextArea();
        jToolBar1 = new javax.swing.JToolBar();
        abrir_file_jb = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Reg_jTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(123, 123, 123));
        setPreferredSize(new java.awt.Dimension(1300, 800));

        jTabbedPane1.setBackground(new java.awt.Color(123, 123, 123));
        jTabbedPane1.setForeground(new java.awt.Color(177, 177, 177));
        jTabbedPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        JPanel_ini.setBackground(new java.awt.Color(100, 100, 100));

        jScrollPane3.setBackground(new java.awt.Color(123, 123, 123));

        Cod_Read_JText.setEditable(false);
        Cod_Read_JText.setBackground(new java.awt.Color(76, 76, 76));
        Cod_Read_JText.setColumns(20);
        Cod_Read_JText.setRows(5);
        jScrollPane3.setViewportView(Cod_Read_JText);

        Cod_generated_JText.setEditable(false);
        Cod_generated_JText.setBackground(new java.awt.Color(76, 76, 76));
        Cod_generated_JText.setColumns(20);
        Cod_generated_JText.setRows(5);
        jScrollPane1.setViewportView(Cod_generated_JText);

        javax.swing.GroupLayout JPanel_iniLayout = new javax.swing.GroupLayout(JPanel_ini);
        JPanel_ini.setLayout(JPanel_iniLayout);
        JPanel_iniLayout.setHorizontalGroup(
            JPanel_iniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanel_iniLayout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 824, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        JPanel_iniLayout.setVerticalGroup(
            JPanel_iniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanel_iniLayout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        JPanel_iniLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jScrollPane1, jScrollPane3});

        jTabbedPane1.addTab("Inicio", JPanel_ini);

        jPanel1.setBackground(new java.awt.Color(100, 100, 100));

        jScrollPane7.setBackground(new java.awt.Color(123, 123, 123));

        Cod_Read_JText2.setEditable(false);
        Cod_Read_JText2.setBackground(new java.awt.Color(76, 76, 76));
        Cod_Read_JText2.setColumns(20);
        Cod_Read_JText2.setRows(5);
        jScrollPane7.setViewportView(Cod_Read_JText2);

        Cod_generated_JText2.setEditable(false);
        Cod_generated_JText2.setBackground(new java.awt.Color(76, 76, 76));
        Cod_generated_JText2.setColumns(20);
        Cod_generated_JText2.setRows(5);
        jScrollPane10.setViewportView(Cod_generated_JText2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 824, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane10)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Expansão de Macros", jPanel1);

        jPanel2.setBackground(new java.awt.Color(100, 100, 100));

        jScrollPane8.setBackground(new java.awt.Color(123, 123, 123));

        Cod_Read_JText3.setEditable(false);
        Cod_Read_JText3.setBackground(new java.awt.Color(76, 76, 76));
        Cod_Read_JText3.setColumns(20);
        Cod_Read_JText3.setRows(5);
        jScrollPane8.setViewportView(Cod_Read_JText3);

        Cod_generated_JText3.setEditable(false);
        Cod_generated_JText3.setBackground(new java.awt.Color(76, 76, 76));
        Cod_generated_JText3.setColumns(20);
        Cod_generated_JText3.setRows(5);
        jScrollPane11.setViewportView(Cod_generated_JText3);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 824, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane11)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Código Montado", jPanel2);

        jPanel3.setBackground(new java.awt.Color(100, 100, 100));

        jScrollPane9.setBackground(new java.awt.Color(123, 123, 123));

        Cod_Read_JText4.setEditable(false);
        Cod_Read_JText4.setBackground(new java.awt.Color(76, 76, 76));
        Cod_Read_JText4.setColumns(20);
        Cod_Read_JText4.setRows(5);
        jScrollPane9.setViewportView(Cod_Read_JText4);

        Cod_generated_JText4.setEditable(false);
        Cod_generated_JText4.setBackground(new java.awt.Color(76, 76, 76));
        Cod_generated_JText4.setColumns(20);
        Cod_generated_JText4.setRows(5);
        jScrollPane12.setViewportView(Cod_generated_JText4);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 824, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane12)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Código Linkado", jPanel3);

        jPanel4.setBackground(new java.awt.Color(100, 100, 100));

        jScrollPane13.setBackground(new java.awt.Color(123, 123, 123));

        Cod_Read_JText5.setEditable(false);
        Cod_Read_JText5.setBackground(new java.awt.Color(76, 76, 76));
        Cod_Read_JText5.setColumns(20);
        Cod_Read_JText5.setRows(5);
        jScrollPane13.setViewportView(Cod_Read_JText5);

        Cod_generated_JText5.setEditable(false);
        Cod_generated_JText5.setBackground(new java.awt.Color(76, 76, 76));
        Cod_generated_JText5.setColumns(20);
        Cod_generated_JText5.setRows(5);
        jScrollPane14.setViewportView(Cod_generated_JText5);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 824, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane14)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Execução", jPanel4);

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        abrir_file_jb.setBackground(new java.awt.Color(123, 123, 123));
        abrir_file_jb.setForeground(new java.awt.Color(177, 177, 177));
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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo.png"))); // NOI18N

        jScrollPane2.setBackground(new java.awt.Color(123, 123, 123));
        jScrollPane2.setForeground(new java.awt.Color(177, 177, 177));

        Reg_jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"PC", null},
                {"ACC", null},
                {"X0", null},
                {"X1", null},
                {"X2", null},
                {"X3", null},
                {"X4", null},
                {"X5", null},
                {"X6", null},
                {"X7", null},
                {"X8", null},
                {"X9", null},
                {"X10", null},
                {"X11", null},
                {"X12", null},
                {"X13", null},
                {"X14", null},
                {"X15", null}
            },
            new String [] {
                "Name", "Value"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Reg_jTable.setSelectionBackground(new java.awt.Color(123, 123, 123));
        Reg_jTable.setSelectionForeground(new java.awt.Color(123, 123, 123));
        jScrollPane2.setViewportView(Reg_jTable);
        if (Reg_jTable.getColumnModel().getColumnCount() > 0) {
            Reg_jTable.getColumnModel().getColumn(0).setResizable(false);
            Reg_jTable.getColumnModel().getColumn(1).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 789, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 798, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 679, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1169, 1169, 1169))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void abrir_file_jbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrir_file_jbActionPerformed
        
        JFileChooser fileChooser = new JFileChooser();                                  // cria um objeto para abrir o arquivo
        fileChooser.setDialogTitle ("Selecione o Arquivo TXT a Ser Aberto");            // titulo da caixa de seleção de arquivo
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);                      // set para apenas arquivos
        FileNameExtensionFilter filter = new FileNameExtensionFilter ("Binary","bin");   // configura o tipo de arquivo para aceitar apenas txt
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
          JLabel file_name = new JLabel(arq.getName());
          JPanel_ini.setName("teste");
          
          
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
    private javax.swing.JTextArea Cod_Read_JText;
    private javax.swing.JTextArea Cod_Read_JText2;
    private javax.swing.JTextArea Cod_Read_JText3;
    private javax.swing.JTextArea Cod_Read_JText4;
    private javax.swing.JTextArea Cod_Read_JText5;
    private javax.swing.JTextArea Cod_generated_JText;
    private javax.swing.JTextArea Cod_generated_JText2;
    private javax.swing.JTextArea Cod_generated_JText3;
    private javax.swing.JTextArea Cod_generated_JText4;
    private javax.swing.JTextArea Cod_generated_JText5;
    private javax.swing.JPanel JPanel_ini;
    private javax.swing.JTable Reg_jTable;
    private javax.swing.JButton abrir_file_jb;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
/*>>>>>>> 392493fa2d57565bae06362176e9f25f26b76064*/
