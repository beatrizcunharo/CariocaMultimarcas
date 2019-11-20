package Frames;

import Arquivo.ArquivoEstoque;
import Registros.Blusas;
import Registros.Calcas;
import java.util.List;
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
public class JBuscaCodProduto extends javax.swing.JFrame {
    DefaultTableModel tabela=new DefaultTableModel();
    String vetTabela[]=new String[9];
    ArquivoEstoque arquivoEstoque;
    public JBuscaCodProduto() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        arquivoEstoque = new ArquivoEstoque();
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);  
        tabela.addColumn("Código");tabela.addColumn("Nome");tabela.addColumn("Tipo");
        tabela.addColumn("Tamanho");tabela.addColumn("Sexo");tabela.addColumn("Quantidade");
        tabela.addColumn("Valor Unit.");tabela.addColumn("Número");tabela.addColumn("Data Regis.");
    }
    
    public void pesquisa(){
        List<Blusas> b = arquivoEstoque.outputBlusas();
        List<Calcas> c = arquivoEstoque.outputCalcas();
        int t = tabela.getRowCount();
        for (int i = 0; i < t; i++) {
            tabela.removeRow(0);
        }
        for(int i=0;i<b.size();i++){
            vetTabela[0] = b.get(i).getCodigo()+"";
            vetTabela[1] = b.get(i).getNome();
            vetTabela[2] = b.get(i).getTipo();
            vetTabela[3] = b.get(i).getTamanho();
            vetTabela[4] = b.get(i).getSexo();
            vetTabela[5] = b.get(i).getQtde()+"";
            vetTabela[6] = b.get(i).getValor()+"";
            vetTabela[7] = "";
            vetTabela[8] = b.get(i).getDataRegistro();
            tabela.addRow(vetTabela);
        }
        for(int i=0;i<c.size();i++){
            vetTabela[0] = c.get(i).getCodigo()+"";
            vetTabela[1] = c.get(i).getNome();
            vetTabela[2] = c.get(i).getTipo();
            vetTabela[3] = "";
            vetTabela[4] = c.get(i).getSexo();
            vetTabela[5] = c.get(i).getQtde()+"";
            vetTabela[6] = c.get(i).getValor()+"";
            vetTabela[7] = c.get(i).getNumero()+"";
            vetTabela[8] = c.get(i).getDataRegistro();
            tabela.addRow(vetTabela);
        }
    }
    
    public void pesquisaPorNome(String nome){
        List<Blusas> b = arquivoEstoque.outputBlusas();
        List<Calcas> c = arquivoEstoque.outputCalcas();
        int t = tabela.getRowCount();
        for (int i = 0; i < t; i++) {
            tabela.removeRow(0);
        }
        for(int i=0;i<b.size();i++){
            if(b.get(i).getNome().contains(nome)){
                vetTabela[0] = b.get(i).getCodigo()+"";
                vetTabela[1] = b.get(i).getNome();
                vetTabela[2] = b.get(i).getTipo();
                vetTabela[3] = b.get(i).getTamanho();
                vetTabela[4] = b.get(i).getSexo();
                vetTabela[5] = b.get(i).getQtde()+"";
                vetTabela[6] = b.get(i).getValor()+"";
                vetTabela[7] = "";
                vetTabela[8] = b.get(i).getDataRegistro();
                tabela.addRow(vetTabela);
            }
        }
        for(int i=0;i<c.size();i++){
            if(c.get(i).getNome().contains(nome)){
                vetTabela[0] = c.get(i).getCodigo()+"";
                vetTabela[1] = c.get(i).getNome();
                vetTabela[2] = c.get(i).getTipo();
                vetTabela[3] = "";
                vetTabela[4] = c.get(i).getSexo();
                vetTabela[5] = c.get(i).getQtde()+"";
                vetTabela[6] = c.get(i).getValor()+"";
                vetTabela[7] = c.get(i).getNumero()+"";
                vetTabela[8] = c.get(i).getDataRegistro();
                tabela.addRow(vetTabela);
            }
        }
    }
    
    public void pesquisaPorCodigo(int codigo){
        List<Blusas> b = arquivoEstoque.outputBlusas();
        List<Calcas> c = arquivoEstoque.outputCalcas();
        int t = tabela.getRowCount();
        for (int i = 0; i < t; i++) {
            tabela.removeRow(0);
        }
        for(int i=0;i<b.size();i++){
            if(b.get(i).getCodigo() == codigo){
                vetTabela[0] = b.get(i).getCodigo()+"";
                vetTabela[1] = b.get(i).getNome();
                vetTabela[2] = b.get(i).getTipo();
                vetTabela[3] = b.get(i).getTamanho();
                vetTabela[4] = b.get(i).getSexo();
                vetTabela[5] = b.get(i).getQtde()+"";
                vetTabela[6] = b.get(i).getValor()+"";
                vetTabela[7] = "";
                vetTabela[8] = b.get(i).getDataRegistro();
                tabela.addRow(vetTabela);
            }
        }
        for(int i=0;i<c.size();i++){
            if(c.get(i).getCodigo() == codigo){
                vetTabela[0] = c.get(i).getCodigo()+"";
                vetTabela[1] = c.get(i).getNome();
                vetTabela[2] = c.get(i).getTipo();
                vetTabela[3] = "";
                vetTabela[4] = c.get(i).getSexo();
                vetTabela[5] = c.get(i).getQtde()+"";
                vetTabela[6] = c.get(i).getValor()+"";
                vetTabela[7] = c.get(i).getNumero()+"";
                vetTabela[8] = c.get(i).getDataRegistro();
                tabela.addRow(vetTabela);
            }
        }
    }
    
    
    public void pesquisaPorTipo(String tipo){
        List<Blusas> b = arquivoEstoque.outputBlusas();
        List<Calcas> c = arquivoEstoque.outputCalcas();
        int t = tabela.getRowCount();
        for (int i = 0; i < t; i++) {
            tabela.removeRow(0);
        }

        if(tipo.equals("Camisa") || tipo.equals("Camiseta") || tipo.equals("Moletom")){
           for(int i=0;i<b.size();i++){
                if(b.get(i).getTipo().equals(tipo)){
                    vetTabela[0] = b.get(i).getCodigo()+"";
                    vetTabela[1] = b.get(i).getNome();
                    vetTabela[2] = b.get(i).getTipo();
                    vetTabela[3] = b.get(i).getTamanho();
                    vetTabela[4] = b.get(i).getSexo();
                    vetTabela[5] = b.get(i).getQtde()+"";
                    vetTabela[6] = b.get(i).getValor()+"";
                    vetTabela[7] = "";
                    vetTabela[8] = b.get(i).getDataRegistro();
                    tabela.addRow(vetTabela);
                }
            }
        }else{
            if(tipo.equals("Calça") || tipo.equals("Bermuda") || tipo.equals("Short")){
               for(int i=0;i<c.size();i++){
                    if(c.get(i).getTipo().equals(tipo)){
                        vetTabela[0] = c.get(i).getCodigo()+"";
                        vetTabela[1] = c.get(i).getNome();
                        vetTabela[2] = c.get(i).getTipo();
                        vetTabela[3] = "";
                        vetTabela[4] = c.get(i).getSexo();
                        vetTabela[5] = c.get(i).getQtde()+"";
                        vetTabela[6] = c.get(i).getValor()+"";
                        vetTabela[7] = c.get(i).getNumero()+"";
                        vetTabela[8] = c.get(i).getDataRegistro();
                        tabela.addRow(vetTabela);
                    }
                }
            }
        }
    }
    
    public void pesquisaPorTamanho(String tamanho){
        List<Blusas> b = arquivoEstoque.outputBlusas();
        int t = tabela.getRowCount();
        for (int i = 0; i < t; i++) {
            tabela.removeRow(0);
        }
        for(int i=0;i<b.size();i++){
            if(b.get(i).getTamanho().equals(tamanho)){
                vetTabela[0] = b.get(i).getCodigo()+"";
                vetTabela[1] = b.get(i).getNome();
                vetTabela[2] = b.get(i).getTipo();
                vetTabela[3] = b.get(i).getTamanho();
                vetTabela[4] = b.get(i).getSexo();
                vetTabela[5] = b.get(i).getQtde()+"";
                vetTabela[6] = b.get(i).getValor()+"";
                vetTabela[7] = "";
                vetTabela[8] = b.get(i).getDataRegistro();
                tabela.addRow(vetTabela);
            }
        }
    }
    
    public void pesquisaPorNumero(int numero){
        List<Calcas> c = arquivoEstoque.outputCalcas();
        int t = tabela.getRowCount();
        for (int i = 0; i < t; i++) {
            tabela.removeRow(0);
        }
        for(int i=0;i<c.size();i++){
            if(c.get(i).getNumero() == numero){
                vetTabela[0] = c.get(i).getCodigo()+"";
                vetTabela[1] = c.get(i).getNome();
                vetTabela[2] = c.get(i).getTipo();
                vetTabela[3] = "";
                vetTabela[4] = c.get(i).getSexo();
                vetTabela[5] = c.get(i).getQtde()+"";
                vetTabela[6] = c.get(i).getValor()+"";
                vetTabela[7] = c.get(i).getNumero()+"";
                vetTabela[8] = c.get(i).getDataRegistro();
                tabela.addRow(vetTabela);
            }
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel7 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        btnBuscar2 = new javax.swing.JButton();
        btnVoltar2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel20 = new javax.swing.JLabel();
        cmbTipo = new javax.swing.JComboBox();
        jLabel27 = new javax.swing.JLabel();
        cmbTamanho = new javax.swing.JComboBox();
        jLabel28 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cmbNumero = new javax.swing.JComboBox();
        btnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jLabel19.setText("Nome:");

        btnBuscar2.setText("Buscar");
        btnBuscar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscar2ActionPerformed(evt);
            }
        });

        btnVoltar2.setText("Voltar Cadastro");
        btnVoltar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltar2ActionPerformed(evt);
            }
        });

        table.setModel(tabela);
        jScrollPane1.setViewportView(table);

        jLabel20.setText("Tipo:");

        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "Camisa", "Camiseta", "Moletom", "Calça", "Bermuda", "Short" }));

        jLabel27.setText("Tamanho:");

        cmbTamanho.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "PP", "P", "M", "G", "GG" }));

        jLabel28.setText("Código:");

        jLabel7.setText("Número:");

        cmbNumero.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "34", "36", "38", "40", "42", "44", "46", "48", "50", "52", "54", "56" }));

        btnVoltar.setText("Voltar Alterar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel28)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbTamanho, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(122, 122, 122))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbNumero, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(123, 123, 123)))
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(btnBuscar2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(btnVoltar2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVoltar)
                .addGap(119, 119, 119))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(cmbTamanho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cmbNumero, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBuscar2)
                        .addGap(36, 36, 36)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVoltar2)
                    .addComponent(btnVoltar))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Pesquisar", jPanel7);

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
        JVendas venda = new JVendas();
        if(venda.isVisible()){
            this.dispose();
        }else{
            venda.setIndex1();
            this.dispose();
        }
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnVoltar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltar2ActionPerformed
        JVendas venda = new JVendas();
        if(venda.isVisible()){
            this.dispose();
        }else{
            venda.setIndex0();
            this.dispose();
        }
    }//GEN-LAST:event_btnVoltar2ActionPerformed

    private void btnBuscar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar2ActionPerformed
        if(txtNome.getText().equals("") && cmbTipo.getSelectedIndex() == 0 && cmbTamanho.getSelectedIndex() == 0
            && cmbNumero.getSelectedIndex() == 0 && txtCodigo.getText().equals("")){
            pesquisa();
        }
        if(cmbTipo.getSelectedIndex() != 0){
            String tipo = cmbTipo.getSelectedItem().toString();
            pesquisaPorTipo(tipo);
        }
        if(cmbTamanho.getSelectedIndex() != 0){
            String tamanho = cmbTamanho.getSelectedItem().toString();
            pesquisaPorTamanho(tamanho);
        }
        if(cmbNumero.getSelectedIndex() != 0){
            int num = Integer.parseInt(cmbNumero.getSelectedItem().toString());
            pesquisaPorNumero(num);
        }
        if(!txtNome.getText().equals("")){
            String nome = txtNome.getText();
            pesquisaPorNome(nome);
        }
        if(!txtCodigo.getText().equals("")){
            int codigo = Integer.parseInt(txtCodigo.getText());
            pesquisaPorCodigo(codigo);
        }
    }//GEN-LAST:event_btnBuscar2ActionPerformed

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
            java.util.logging.Logger.getLogger(JBuscaCodProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JBuscaCodProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JBuscaCodProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JBuscaCodProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JBuscaCodProduto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar2;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JButton btnVoltar2;
    private javax.swing.JComboBox cmbNumero;
    private javax.swing.JComboBox cmbTamanho;
    private javax.swing.JComboBox cmbTipo;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
