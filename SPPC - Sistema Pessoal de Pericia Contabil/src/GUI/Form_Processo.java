/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import ClassModel.Movimento_Class;
import ConnectionFactory.ConnectionFactory;
import DataAccessObj.DAO_CadastroMovimento;
import com.sun.glass.events.KeyEvent;
import java.awt.Color;
import java.awt.Window;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;





/**
 *
 * @author Leticia
 */
public class Form_Processo extends javax.swing.JFrame {

    /**
     * Creates new form Form_Processo
     */
    
    private Connection conn;
    private PreparedStatement pstm;
    private ResultSet rs;
    private boolean encargo = false;
    
    public Form_Processo(int p, String n) throws SQLException{
        initComponents();
        setLocationRelativeTo(null);
        jPanelEncargo.setVisible(false);
        //getContentPane().setBackground(Color.white);
        toolBarOptProcesso.setVisible(false);
       
        ///////////////////////////////////////////////////
        try {
            this.conn = new ConnectionFactory().getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Form_Processo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Form_Processo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (n != null) this.setLabels(p, n);
   
        this.populateTableMovimento();
        this.setVisible(true);
    }
    
    public void populateTableMovimento() throws SQLException {
        String sql = String.format("SELECT datal as \"Data\", saldo as \"Saldo\", valor_encargo as \"Taxa Praticada\" FROM movimento WHERE processo = %s", labelProceso.getText());

        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            tabelamov.setModel(DbUtils.resultSetToTableModel(rs));
            pstm.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Form_Processo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    public void setLabels(int processo, String nome){
        labelProceso.setText(String.valueOf(processo));
        labelNome.setText(nome);
    }
    
    public void Register() throws SQLException {
        
        Movimento_Class movimento = new Movimento_Class();
        
        movimento.setProcesso(Integer.parseInt(labelProceso.getText()));
        movimento.setData(datal.getText());
        movimento.setSaldo(Double.parseDouble(saldo.getText().replace(",", ".")));
        
        if (encargo)
        {
            movimento.setDataRef(dataRef.getText());
            movimento.setTipoEncargo((String) tipoEncargo.getSelectedItem());
            movimento.setValorEncargo(Double.parseDouble(valorEncargo.getText().replace(",", ".")));
        }

        if (datal.getText().isEmpty() || saldo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não devem haver campos em branco!");
        } else {
            DAO_CadastroMovimento dao = new DAO_CadastroMovimento();
            dao.add(movimento, encargo);
            JOptionPane.showMessageDialog(null, "Movimento cadastrado.");
            dispose();
            new Form_Processo(Integer.valueOf(this.labelProceso.getText()), labelNome.getText()).setVisible(true);
        }

    }
    
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jToolBar1 = new javax.swing.JToolBar();
        jToggleButton1 = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        labelNome = new javax.swing.JLabel();
        labelProceso = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelamov = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        saldo = new javax.swing.JTextField();
        datal = new javax.swing.JFormattedTextField();
        jPanelEncargo = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        dataRef = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        tipoEncargo = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        valorEncargo = new javax.swing.JTextField();
        salvar_mov = new javax.swing.JButton();
        jButtonEncargo = new javax.swing.JToggleButton();
        toolBarOptProcesso = new javax.swing.JToolBar();
        jButton7 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jToolBar1.setBorder(null);
        jToolBar1.setRollover(true);

        jToggleButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconsGUI/settings-icon (1).png"))); // NOI18N
        jToggleButton1.setFocusable(false);
        jToggleButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jToggleButton1);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Processo:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Nome:");

        labelNome.setText("Anna Luisa Rermam");

        labelProceso.setText("1234567890");

        jScrollPane1.setBorder(null);

        tabelamov.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Data", "Saldo Devedor", "Juros"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Float.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelamov);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Movimento"));

        jLabel5.setText("Data:");

        jLabel6.setText("Saldo:");

        try {
            datal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel7.setText("Data de Referência:");

        try {
            dataRef.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel8.setText("Tipo de Encargo:");

        tipoEncargo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "Cheque Especial", "Item 3", "Item 4" }));

        jLabel9.setText("Taxa Praticada:");

        valorEncargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valorEncargoActionPerformed(evt);
            }
        });
        valorEncargo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                valorEncargoKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanelEncargoLayout = new javax.swing.GroupLayout(jPanelEncargo);
        jPanelEncargo.setLayout(jPanelEncargoLayout);
        jPanelEncargoLayout.setHorizontalGroup(
            jPanelEncargoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEncargoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelEncargoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelEncargoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dataRef)
                    .addComponent(tipoEncargo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(valorEncargo))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanelEncargoLayout.setVerticalGroup(
            jPanelEncargoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEncargoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelEncargoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(dataRef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanelEncargoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(tipoEncargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanelEncargoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(valorEncargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        salvar_mov.setText("Salvar");
        salvar_mov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvar_movActionPerformed(evt);
            }
        });

        jButtonEncargo.setText("Encargo");
        jButtonEncargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEncargoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(saldo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(datal, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(salvar_mov, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtonEncargo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addComponent(jPanelEncargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelEncargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(datal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonEncargo)
                .addGap(18, 18, 18)
                .addComponent(salvar_mov)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        toolBarOptProcesso.setBorder(null);
        toolBarOptProcesso.setRollover(true);

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconsGUI/Home-icon.png"))); // NOI18N
        jButton7.setFocusable(false);
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        toolBarOptProcesso.add(jButton7);

        jButton1.setText("Alterar Movimento");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        toolBarOptProcesso.add(jButton1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelProceso)
                        .addGap(39, 39, 39)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelNome)
                        .addGap(311, 370, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addComponent(toolBarOptProcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(toolBarOptProcesso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(labelNome)
                    .addComponent(labelProceso))
                .addGap(25, 25, 25)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                .addGap(42, 42, 42))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void valorEncargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valorEncargoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_valorEncargoActionPerformed

    private void valorEncargoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_valorEncargoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jPanelEncargo.setVisible(false);
        }
    }//GEN-LAST:event_valorEncargoKeyPressed

    private void salvar_movActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvar_movActionPerformed
        // TODO add your handling code here:
        try {
            Register();
        } catch (SQLException ex) {
            Logger.getLogger(Form_CadastroProcesso.class.getName()).log(Level.SEVERE, null, ex);
            //throw new RuntimeException(ex);
        }
        
    }//GEN-LAST:event_salvar_movActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        toolBarOptProcesso.setVisible(true);
        if (!(jToggleButton1.isSelected())) {
            toolBarOptProcesso.setVisible(false);
        }
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new Form_AlterarMovimento().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        Window[] close = Window.getWindows();
        for (int i = 0; i < close.length; i++) {
            close[i].dispose();
            close[i] = null;
        }
        try {
            new Form_Sistema().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Form_Processo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButtonEncargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEncargoActionPerformed
        encargo = true;
        jPanelEncargo.setVisible(true);
        if (!(jButtonEncargo.isSelected())) {
            jPanelEncargo.setVisible(false);
        }
    }//GEN-LAST:event_jButtonEncargoActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField dataRef;
    private javax.swing.JFormattedTextField datal;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton7;
    private javax.swing.JToggleButton jButtonEncargo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelEncargo;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel labelProceso;
    private javax.swing.JTextField saldo;
    private javax.swing.JButton salvar_mov;
    private javax.swing.JTable tabelamov;
    private javax.swing.JComboBox tipoEncargo;
    private javax.swing.JToolBar toolBarOptProcesso;
    private javax.swing.JTextField valorEncargo;
    // End of variables declaration//GEN-END:variables
}
