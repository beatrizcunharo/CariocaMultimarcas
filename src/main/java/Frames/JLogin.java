package Frames;

import Arquivo.ArquivoLogin;
import Registros.Login;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
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
    String vetTabela[]=new String[7];
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
            if(txtUsuario2.getText().equals(l.get(i).getUsuario())){
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
        comboTipo = new javax.swing.JComboBox<String>();
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
        comboTipo1 = new javax.swing.JComboBox<String>();
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

        jLabel2.setText("Usuário:");

        jLabel8.setText("Senha:");

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        btnEnviar.setText("Enviar");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        jLabel1.setText("Confirmação de Senha:");

        jLabel3.setText("Tipo:");

        comboTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "Administrador", "Funcionário" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74)
                        .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtConfirmSenha)
                            .addComponent(txtSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                            .addComponent(comboTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addComponent(btnVoltar)
                .addGap(58, 58, 58))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtConfirmSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(comboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEnviar)
                    .addComponent(btnLimpar)
                    .addComponent(btnVoltar))
                .addGap(32, 32, 32))
        );

        jTabbedPane1.addTab("Cadastro", jPanel2);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setText("Usuário:");

        jLabel10.setText("Senha:");

        btnLimpar1.setText("Limpar");
        btnLimpar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpar1ActionPerformed(evt);
            }
        });

        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnVoltar1.setText("Voltar");
        btnVoltar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltar1ActionPerformed(evt);
            }
        });

        jLabel7.setText("Confirmação de Senha:");

        jLabel12.setText("Tipo:");

        comboTipo1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "Administrador", "Funcionário" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addComponent(btnLimpar1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtConfirmSenha1)
                            .addComponent(txtSenha1, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                            .addComponent(txtUsuario1, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                            .addComponent(comboTipo1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addComponent(btnVoltar1)
                .addGap(73, 73, 73))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsuario1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtSenha1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtConfirmSenha1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(comboTipo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAlterar)
                    .addComponent(btnLimpar1)
                    .addComponent(btnVoltar1))
                .addGap(32, 32, 32))
        );

        jTabbedPane1.addTab("Alterar", jPanel4);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setText("Usuário:");

        table.setModel(tabela);
        jScrollPane1.setViewportView(table);

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnVoltar2.setText("Voltar");
        btnVoltar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltar2ActionPerformed(evt);
            }
        });

        btnAlterar1.setText("Alterar");
        btnAlterar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterar1ActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtUsuario2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(230, 230, 230)
                        .addComponent(btnBuscar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(btnVoltar2)
                        .addGap(72, 72, 72)
                        .addComponent(btnAlterar1)
                        .addGap(65, 65, 65)
                        .addComponent(btnExcluir)))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsuario2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(btnBuscar)
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVoltar2)
                    .addComponent(btnAlterar1)
                    .addComponent(btnExcluir))
                .addGap(19, 19, 19))
        );

        jTabbedPane1.addTab("Pesquisar", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        JPrincipal principal = new JPrincipal();
        principal.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnVoltar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltar2ActionPerformed
        JPrincipal principal = new JPrincipal();
        principal.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVoltar2ActionPerformed

    private void btnVoltar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltar1ActionPerformed
        JPrincipal principal = new JPrincipal();
        principal.setVisible(true);
        this.dispose();
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
