package Frames;

import Arquivo.ArquivoLogin;
import Registros.Login;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 *  
    @author BEATRIZ CUNHA RODRIGUES             201776038
    @author DANIEL RIBEIRO LAVRA                201735042
    @author IVANYLSON HONÓRIO GONÇALVES         201776002
    @author JAKSON DUARTE MARTINS JÚNIOR	201435004
    @author MIKAELA CRISTINY QUITZ              201676014

 */
public class JLogin extends javax.swing.JFrame {
    DefaultTableModel tabela=new DefaultTableModel();
    ArquivoLogin arquivoLogin;
    String vetTabela[]=new String[2];
    int posicao;
    public JLogin() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        arquivoLogin = new ArquivoLogin();
        tabela.addColumn("Usuário");
        tabela.addColumn("Tipo");
        
       
    }
    public boolean vazioCadastro(){
        if(txtUsuario.getText().equals("") || txtSenha.getText().equals("") || txtConfirmSenha.getText().equals("") || comboTipo.getSelectedItem().equals("Selecione..."))
            return true;
        else
            return false;
    }
    
    public boolean vazioAlterar(){
        if(txtUsuario1.getText().equals("") || txtSenha1.getText().equals("") || txtConfirmSenha1.getText().equals("") || comboTipo1.getSelectedItem().equals("Selecione..."))
            return true;
        else
            return false;
    }
    
    public void limparCadastro(){
        txtUsuario.setText("");txtSenha.setText("");txtConfirmSenha.setText("");comboTipo.setSelectedItem("Selecione...");
    }
    public void limparAlterar(){
        txtUsuario1.setText("");txtSenha1.setText("");txtConfirmSenha1.setText("");comboTipo1.setSelectedItem("Selecione...");
    }
    
    public void pesquisa(){
        List<Login> l = arquivoLogin.output();
        int t = tabela.getRowCount();
        for (int i = 0; i < t; i++) {
            tabela.removeRow(0);
        }
        for(int i=0;i<l.size();i++){
            vetTabela[0] = l.get(i).getUsuario();
            vetTabela[1] = l.get(i).getTipo();
            tabela.addRow(vetTabela);
        }
    }
    public void pesquisaPorUsuario(){
        List<Login> l = arquivoLogin.output();
        int t = tabela.getRowCount();
        for (int i = 0; i < t; i++) {
            tabela.removeRow(0);
        }
        for (int i=0;i<l.size();i++) {
            if(txtUsuario2.getText().equalsIgnoreCase(l.get(i).getUsuario())){
                vetTabela[0] = l.get(i).getUsuario();
                vetTabela[1] = l.get(i).getTipo();
            }
        }
        tabela.addRow(vetTabela);
    }
    
    File file = new File("arquivoLogin.json");
    
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btnLimpar = new javax.swing.JButton();
        btnEnviar = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        txtSenha = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        txtConfirmSenha = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        comboTipo = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtUsuario1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        btnLimpar1 = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnVoltar1 = new javax.swing.JButton();
        txtSenha1 = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        txtConfirmSenha1 = new javax.swing.JPasswordField();
        jLabel12 = new javax.swing.JLabel();
        comboTipo1 = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txtUsuario2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        btnBuscar = new javax.swing.JButton();
        btnVoltar2 = new javax.swing.JButton();
        btnAlterar1 = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Usuário:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 40, -1, -1));
        jPanel2.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 37, 189, -1));

        jLabel8.setText("Senha:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 78, -1, -1));

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });
        jPanel2.add(btnLimpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(237, 263, 140, -1));

        btnEnviar.setText("Enviar");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });
        jPanel2.add(btnEnviar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 263, 140, -1));

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });
        jPanel2.add(btnVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(443, 263, 140, -1));
        jPanel2.add(txtSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 75, 189, -1));

        jLabel1.setText("Confirmação de Senha:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 116, -1, -1));
        jPanel2.add(txtConfirmSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 113, 189, -1));

        jLabel3.setText("Tipo:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 154, -1, -1));

        comboTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione...", "Administrador", "Funcionário" }));
        jPanel2.add(comboTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 151, 189, -1));

        jTabbedPane1.addTab("Cadastro", jPanel2);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setText("Usuário:");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(167, 38, -1, -1));
        jPanel4.add(txtUsuario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(211, 35, 189, -1));

        jLabel10.setText("Senha:");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(173, 76, -1, -1));

        btnLimpar1.setText("Limpar");
        btnLimpar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpar1ActionPerformed(evt);
            }
        });
        jPanel4.add(btnLimpar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(236, 263, 140, -1));

        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });
        jPanel4.add(btnAlterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 263, 138, -1));

        btnVoltar1.setText("Voltar");
        btnVoltar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltar1ActionPerformed(evt);
            }
        });
        jPanel4.add(btnVoltar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(443, 263, 140, -1));
        jPanel4.add(txtSenha1, new org.netbeans.lib.awtextra.AbsoluteConstraints(211, 73, 189, -1));

        jLabel7.setText("Confirmação de Senha:");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 114, -1, -1));
        jPanel4.add(txtConfirmSenha1, new org.netbeans.lib.awtextra.AbsoluteConstraints(211, 111, 189, -1));

        jLabel12.setText("Tipo:");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(183, 152, -1, -1));

        comboTipo1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione...", "Administrador", "Funcionário" }));
        jPanel4.add(comboTipo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(211, 149, 189, -1));

        jTabbedPane1.addTab("Alterar", jPanel4);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setText("Usuário:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));
        jPanel1.add(txtUsuario2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 340, -1));

        table.setModel(tabela);
        jScrollPane1.setViewportView(table);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 468, 91));

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 40, -1, -1));

        btnVoltar2.setText("Voltar");
        btnVoltar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltar2ActionPerformed(evt);
            }
        });
        jPanel1.add(btnVoltar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 295, 140, -1));

        btnAlterar1.setText("Alterar");
        btnAlterar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterar1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnAlterar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(209, 295, 140, -1));

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        jPanel1.add(btnExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 290, 140, -1));

        jTabbedPane1.addTab("Pesquisar", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        JPrincipal principal = new JPrincipal();
        if(principal.isVisible() == false){
           principal.setVisible(true);
           this.setVisible(false);
        }else{
            this.setVisible(false);
        }
        
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnVoltar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltar2ActionPerformed
        JPrincipal principal = new JPrincipal();
        if(principal.isVisible() == false){
           principal.setVisible(true);
           this.setVisible(false);
        }else{
            this.setVisible(false);
        }
    }//GEN-LAST:event_btnVoltar2ActionPerformed

    private void btnVoltar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltar1ActionPerformed
        JPrincipal principal = new JPrincipal();
        if(principal.isVisible() == false){
           principal.setVisible(true);
           this.setVisible(false);
        }else{
            this.setVisible(false);
        }
    }//GEN-LAST:event_btnVoltar1ActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limparCadastro();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnLimpar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpar1ActionPerformed
       limparAlterar();
    }//GEN-LAST:event_btnLimpar1ActionPerformed

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
       String user = txtUsuario.getText();
       String senha = txtSenha.getText();
       String confirmaSenha = txtConfirmSenha.getText();
       String tipo = comboTipo.getSelectedItem().toString();
       if(file.exists()){
            List <Login> logins = arquivoLogin.output();
            String usuarioExistente = "";
            for(int i=0;i<logins.size();i++){
                if(user.equals(logins.get(i).getUsuario())){
                    usuarioExistente = logins.get(i).getUsuario();
                    break;
                }
            }
            if(vazioCadastro() == true){
                JOptionPane.showMessageDialog(null, "Há campos vazios.");
            }else{
                if(!senha.equals(confirmaSenha)){
                    JOptionPane.showMessageDialog(null, "As senhas são diferentes.");
                    txtConfirmSenha.setText("");
                }else{
                    if(!usuarioExistente.equals("")){
                        JOptionPane.showMessageDialog(null, "Usuário já existente.");
                        txtUsuario.setText("");
                    }else{
                        arquivoLogin.cadastra(user, senha, tipo);
                        try {
                            arquivoLogin.input();
                            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso.");
                        } catch (IOException ex) {
                            Logger.getLogger(JLogin.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        limparCadastro(); 
                    }
                }
            }
        }else{
            if(!senha.equals(confirmaSenha)){
                JOptionPane.showMessageDialog(null, "As senhas são diferentes.");
                txtConfirmSenha.setText("");
            }else{
                arquivoLogin.cadastra(user, senha, tipo);
                try {
                    arquivoLogin.input();
                    JOptionPane.showMessageDialog(null, "Cadastrado com sucesso.");
                    } catch (IOException ex) {
                        Logger.getLogger(JLogin.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    limparCadastro(); 
                }
        }
       
    }//GEN-LAST:event_btnEnviarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
    if(txtUsuario2.getText().isEmpty()){
        pesquisa();
    }else{
        pesquisaPorUsuario();
    }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnAlterar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterar1ActionPerformed
    String cod = table.getValueAt(table.getSelectedRow(), 0).toString();
        if (table.getSelectedRow() >= 0) {
            List<Login> l = arquivoLogin.output();
            for(int i=0;i<l.size();i++){
                if(l.get(i).getUsuario().equals(cod)){
                   txtUsuario1.setText(l.get(i).getUsuario());
                   txtSenha1.setText(l.get(i).getSenha());
                   txtConfirmSenha1.setText(l.get(i).getSenha());
                   comboTipo1.setSelectedItem(l.get(i).getTipo());
                   posicao = i;
                   break;
                }
            }
            
            jTabbedPane1.setSelectedIndex(1);
        }else{
           JOptionPane.showMessageDialog(null, "Selecione uma linha.");
        }
    }//GEN-LAST:event_btnAlterar1ActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
    String user = txtUsuario1.getText();
    String senha = txtSenha1.getText();
    String confirmaSenha = txtConfirmSenha1.getText();
    String tipo = comboTipo1.getSelectedItem().toString();   
    if(vazioAlterar()== true){
        JOptionPane.showMessageDialog(null, "Há campos vazios.");
    }else{
        if(!senha.equals(confirmaSenha)){
            JOptionPane.showMessageDialog(null, "As senhas são diferentes.");
            txtConfirmSenha.setText("");
        }else{
            try {
                arquivoLogin.alterar(user,senha,tipo,posicao);
                JOptionPane.showMessageDialog(null, "Alterado com sucesso.");
                limparAlterar();
            } catch (IOException ex) {
                Logger.getLogger(JLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        String user = table.getValueAt(table.getSelectedRow(), 0).toString();
        if (table.getSelectedRow() >= 0) {

            if (JOptionPane.showConfirmDialog(null, "Deseja excluir realmente?", "Confirmação", 0) == 0) {

                try {
                    if (arquivoLogin.excluir(user)) {
                        JOptionPane.showMessageDialog(null, "Excluido com sucesso");
                        pesquisa();
                    }
                } catch (IOException ex) {
                    Logger.getLogger(JLogin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Favor selecionar uma linha");
        }

    }//GEN-LAST:event_btnExcluirActionPerformed
    
    
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
            java.util.logging.Logger.getLogger(JLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnAlterar1;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEnviar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnLimpar1;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JButton btnVoltar1;
    private javax.swing.JButton btnVoltar2;
    private javax.swing.JComboBox<String> comboTipo;
    private javax.swing.JComboBox<String> comboTipo1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable table;
    private javax.swing.JPasswordField txtConfirmSenha;
    private javax.swing.JPasswordField txtConfirmSenha1;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JPasswordField txtSenha1;
    private javax.swing.JTextField txtUsuario;
    private javax.swing.JTextField txtUsuario1;
    private javax.swing.JTextField txtUsuario2;
    // End of variables declaration//GEN-END:variables
}
