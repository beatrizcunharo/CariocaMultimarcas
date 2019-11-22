package Frames;

import Arquivo.ArquivoEstoque;
import Registros.Blusas;
import Registros.Calcas;
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
public class JEstoque extends javax.swing.JFrame {
    DefaultTableModel tabela=new DefaultTableModel();
    String vetTabela[]=new String[9];
    ArquivoEstoque arquivoEstoque;
    int codigo = 0;
    int posicao;
    public void setIndex3(){
        jTabbedPane1.setSelectedIndex(2);
    }
    public JEstoque() {
        initComponents();
        
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        arquivoEstoque = new ArquivoEstoque();
        cmbTamanho.setEnabled(false);cmbTamanho1.setEnabled(false);
        cmbNumero.setEnabled(false);cmbNumero1.setEnabled(false);
        tabela.addColumn("Código");tabela.addColumn("Nome");tabela.addColumn("Tipo");
        tabela.addColumn("Tamanho");tabela.addColumn("Sexo");tabela.addColumn("Quantidade");
        tabela.addColumn("Valor Unit.");tabela.addColumn("Número");tabela.addColumn("Data Regis.");
       
   }
    public boolean vazioCadastro(){
        boolean vazio = false;
        if(txtNome.getText().equals("") || cmbTipo.getSelectedIndex() == 0 || cmbSexo.getSelectedIndex() == 0
            || txtQuant.getText().equals("") || txtValor.getText().equals("") || txtDataRegis.getText().equals("")){
                vazio = true;
        }else{
            if(cmbTipo.getSelectedIndex() == 1 || cmbTipo.getSelectedIndex() == 2 || cmbTipo.getSelectedIndex() == 3){
                if(cmbTamanho.getSelectedIndex() == 0){
                    vazio = true;
                }
            }else{
                if(cmbTipo.getSelectedIndex() == 4 || cmbTipo.getSelectedIndex() == 5 || cmbTipo.getSelectedIndex() == 6){
                    if(cmbNumero.getSelectedIndex() == 0){
                        vazio = true;
                    }
                }
            }
        }
        return vazio;
    }
    
    public boolean vazioAlterar(){
        boolean vazio = false;
        if(txtNome1.getText().equals("") || cmbTipo1.getSelectedIndex() == 0 || cmbSexo1.getSelectedIndex() == 0
            || txtQuant1.getText().equals("") || txtValor1.getText().equals("") || txtDataRegis1.getText().equals("")){
                vazio = true;
        }else{
            if(cmbTipo1.getSelectedIndex() == 1 || cmbTipo1.getSelectedIndex() == 2 || cmbTipo1.getSelectedIndex() == 3){
                if(cmbTamanho1.getSelectedIndex() == 0){
                    vazio = true;
                }
            }else{
                if(cmbTipo1.getSelectedIndex() == 4 || cmbTipo1.getSelectedIndex() == 5 || cmbTipo1.getSelectedIndex() == 6){
                    if(cmbNumero1.getSelectedIndex() == 0){
                        vazio = true;
                    }
                }
            }
        }
        return vazio;
    }
    
    public void limparCadastro(){
        txtNome.setText("");cmbTipo.setSelectedIndex(0);cmbTamanho.setSelectedIndex(0);
        cmbNumero.setSelectedIndex(0);cmbSexo.setSelectedIndex(0);txtQuant.setText("");txtValor.setText("");
        txtDataRegis.setText("");
    }
    
    public void limparAlterar(){
        txtNome1.setText("");cmbTipo1.setSelectedIndex(0);cmbTamanho1.setSelectedIndex(0);
        cmbNumero1.setSelectedIndex(0);cmbSexo1.setSelectedIndex(0);txtQuant1.setText("");txtValor1.setText("");
        txtDataRegis1.setText("");
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
    
    File fileB = new File("arquivoBlusas.json");
    File fileC = new File("arquivoCalcas.json");
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cmbSexo = new javax.swing.JComboBox<String>();
        jLabel9 = new javax.swing.JLabel();
        btnLimpar = new javax.swing.JButton();
        btnEnviar = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtQuant = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cmbTamanho = new javax.swing.JComboBox();
        jLabel17 = new javax.swing.JLabel();
        cmbTipo = new javax.swing.JComboBox();
        jLabel21 = new javax.swing.JLabel();
        cmbNumero = new javax.swing.JComboBox();
        txtDataRegis = new javax.swing.JFormattedTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        txtNome1 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        cmbSexo1 = new javax.swing.JComboBox<String>();
        jLabel22 = new javax.swing.JLabel();
        btnLimpar1 = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnVoltar3 = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        txtQuant1 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txtValor1 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        cmbTamanho1 = new javax.swing.JComboBox();
        jLabel26 = new javax.swing.JLabel();
        cmbTipo1 = new javax.swing.JComboBox();
        jLabel29 = new javax.swing.JLabel();
        cmbNumero1 = new javax.swing.JComboBox();
        txtDataRegis1 = new javax.swing.JFormattedTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        txtNome2 = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnVoltar2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel18 = new javax.swing.JLabel();
        cmbTipo2 = new javax.swing.JComboBox();
        jLabel19 = new javax.swing.JLabel();
        cmbTamanho2 = new javax.swing.JComboBox();
        jLabel20 = new javax.swing.JLabel();
        txtCodigo2 = new javax.swing.JTextField();
        btnAlterar1 = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        cmbNumero2 = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("Nome:");

        jLabel6.setText("Sexo:");

        cmbSexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "Feminino", "Masculino", "Unissex" }));

        jLabel9.setText("Tamanho:");

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

        jLabel1.setText("Quantidade:");

        jLabel3.setText("Valor unitário:");

        jLabel5.setText("Data de Registro:");

        cmbTamanho.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "PP", "P", "M", "G", "GG" }));

        jLabel17.setText("Tipo:");

        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "Camisa", "Camiseta", "Moletom", "Calça", "Bermuda", "Short" }));
        cmbTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoActionPerformed(evt);
            }
        });

        jLabel21.setText("Número:");

        cmbNumero.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "34", "36", "38", "40", "42", "44", "46", "48", "50", "52", "54", "56" }));

        try {
            txtDataRegis.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel2)
                .addGap(4, 4, 4)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(jLabel1)
                .addGap(6, 6, 6)
                .addComponent(txtQuant, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jLabel17)
                .addGap(4, 4, 4)
                .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(jLabel3)
                .addGap(6, 6, 6)
                .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel9)
                .addGap(4, 4, 4)
                .addComponent(cmbTamanho, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83)
                .addComponent(jLabel21)
                .addGap(6, 6, 6)
                .addComponent(cmbNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jLabel6)
                .addGap(4, 4, 4)
                .addComponent(cmbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jLabel5)
                .addGap(6, 6, 6)
                .addComponent(txtDataRegis, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(98, 98, 98)
                .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(108, 108, 108)
                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtQuant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel3))))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbTamanho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel21))))
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDataRegis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))))
                .addGap(131, 131, 131)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEnviar)
                    .addComponent(btnLimpar)
                    .addComponent(btnVoltar)))
        );

        jTabbedPane1.addTab("Cadastro", jPanel2);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel14.setText("Nome:");

        jLabel16.setText("Sexo:");

        cmbSexo1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "Feminino", "Masculino", "Unissex" }));

        jLabel22.setText("Tamanho:");

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

        btnVoltar3.setText("Voltar");
        btnVoltar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltar3ActionPerformed(evt);
            }
        });

        jLabel23.setText("Quantidade:");

        jLabel24.setText("Valor unitário:");

        jLabel25.setText("Data de Registro:");

        cmbTamanho1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "PP", "P", "M", "G", "GG" }));

        jLabel26.setText("Tipo:");

        cmbTipo1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "Camisa", "Camiseta", "Moletom", "Calça", "Bermuda", "Short" }));
        cmbTipo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipo1ActionPerformed(evt);
            }
        });

        jLabel29.setText("Número:");

        cmbNumero1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "34", "36", "38", "40", "42", "44", "46", "48", "50", "52", "54", "56" }));

        try {
            txtDataRegis1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel14)
                .addGap(4, 4, 4)
                .addComponent(txtNome1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(jLabel23)
                .addGap(6, 6, 6)
                .addComponent(txtQuant1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jLabel26)
                .addGap(4, 4, 4)
                .addComponent(cmbTipo1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(jLabel24)
                .addGap(6, 6, 6)
                .addComponent(txtValor1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel22)
                .addGap(4, 4, 4)
                .addComponent(cmbTamanho1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83)
                .addComponent(jLabel29)
                .addGap(6, 6, 6)
                .addComponent(cmbNumero1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jLabel16)
                .addGap(4, 4, 4)
                .addComponent(cmbSexo1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jLabel25)
                .addGap(6, 6, 6)
                .addComponent(txtDataRegis1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(98, 98, 98)
                .addComponent(btnLimpar1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(138, 138, 138)
                .addComponent(btnVoltar3))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNome1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtQuant1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel23))))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbTipo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtValor1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel26)
                            .addComponent(jLabel24))))
                .addGap(12, 12, 12)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbTamanho1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbNumero1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22)
                            .addComponent(jLabel29))))
                .addGap(19, 19, 19)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbSexo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDataRegis1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel25))))
                .addGap(131, 131, 131)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAlterar)
                    .addComponent(btnLimpar1)
                    .addComponent(btnVoltar3)))
        );

        jTabbedPane1.addTab("Alterar", jPanel5);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel15.setText("Nome:");

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

        table.setModel(tabela);
        jScrollPane1.setViewportView(table);

        jLabel18.setText("Tipo:");

        cmbTipo2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "Camisa", "Camiseta", "Moletom", "Calça", "Bermuda", "Short" }));

        jLabel19.setText("Tamanho:");

        cmbTamanho2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "PP", "P", "M", "G", "GG" }));
        cmbTamanho2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTamanho2ActionPerformed(evt);
            }
        });

        jLabel20.setText("Código:");

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

        jLabel7.setText("Número:");

        cmbNumero2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione...", "34", "36", "38", "40", "42", "44", "46", "48", "50", "52", "54", "56" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel19)
                        .addGap(4, 4, 4)
                        .addComponent(cmbTamanho2, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel7)
                        .addGap(4, 4, 4)
                        .addComponent(cmbNumero2, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 690, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(btnVoltar2)
                        .addGap(170, 170, 170)
                        .addComponent(btnAlterar1)
                        .addGap(136, 136, 136)
                        .addComponent(btnExcluir))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel15)
                        .addGap(4, 4, 4)
                        .addComponent(txtNome2, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(jLabel18)
                        .addGap(4, 4, 4)
                        .addComponent(cmbTipo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jLabel20)
                        .addGap(4, 4, 4)
                        .addComponent(txtCodigo2, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNome2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbTipo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCodigo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel18)
                            .addComponent(jLabel20))))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel19))
                            .addComponent(cmbTamanho2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel7))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(cmbNumero2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(31, 31, 31))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar)
                        .addGap(43, 43, 43)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVoltar2)
                    .addComponent(btnAlterar1)
                    .addComponent(btnExcluir)))
        );

        jTabbedPane1.addTab("Pesquisar", jPanel4);

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

    private void cmbTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoActionPerformed
        if(cmbTipo.getSelectedIndex() == 0){
            cmbTamanho.setEnabled(false);cmbNumero.setEnabled(false);cmbTamanho.setSelectedIndex(0);cmbNumero.setSelectedIndex(0);
        }
        if(cmbTipo.getSelectedIndex() == 1 || cmbTipo.getSelectedIndex() == 2 || cmbTipo.getSelectedIndex() == 3){
            cmbTamanho.setEnabled(true);cmbNumero.setEnabled(false);cmbNumero.setSelectedIndex(0);
        }
        if(cmbTipo.getSelectedIndex() == 4 || cmbTipo.getSelectedIndex() == 5 || cmbTipo.getSelectedIndex() == 6){
            cmbTamanho.setEnabled(false);cmbNumero.setEnabled(true);cmbTamanho.setSelectedIndex(0);
        }
    }//GEN-LAST:event_cmbTipoActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limparCadastro();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        
        if(fileB.exists()){
           List<Blusas> blusas = arquivoEstoque.outputBlusas();
           int i = blusas.size()-1;
           codigo = blusas.get(i).getCodigo();
           codigo = codigo+1;
        }
        if(fileC.exists()){
            List<Calcas> calcas = arquivoEstoque.outputCalcas();
            int i = calcas.size()-1;
            codigo = calcas.get(i).getCodigo();
            codigo = codigo+2;
        }
        
        if(vazioCadastro() == true){
            JOptionPane.showMessageDialog(null, "Há campos vazios.");
        }else{
            String nome = txtNome.getText();
            String tipo = cmbTipo.getSelectedItem().toString();
            String tamanho = cmbTamanho.getSelectedItem().toString();
            String sexo = cmbSexo.getSelectedItem().toString();
            int quantidade = Integer.parseInt(txtQuant.getText());
            double valor = Double.parseDouble(txtValor.getText());
            String dataRegistro = txtDataRegis.getText();
            if(tipo.equals("Camisa") || tipo.equals("Camiseta") || tipo.equals("Moletom")){
                arquivoEstoque.cadastraBlusas(codigo, nome, tipo, tamanho, sexo, quantidade, valor, dataRegistro);
                try {
                    arquivoEstoque.inputBlusas();
                    JOptionPane.showMessageDialog(null, "Cadastrado com sucesso.");
                    limparCadastro();
                } catch (IOException ex) {
                    Logger.getLogger(JEstoque.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                if(tipo.equals("Calça") || tipo.equals("Bermuda") || tipo.equals("Short")){
                    int numero = Integer.parseInt(cmbNumero.getSelectedItem().toString());
                    arquivoEstoque.cadastraCalcas(codigo, nome, tipo, numero, sexo, quantidade, valor, dataRegistro);
                    try {
                        arquivoEstoque.inputCalcas();
                        JOptionPane.showMessageDialog(null, "Cadastrado com sucesso.");
                        limparCadastro();
                    } catch (IOException ex) {
                        Logger.getLogger(JEstoque.class.getName()).log(Level.SEVERE, null, ex);
                    } 
                }
            }
        }
    }//GEN-LAST:event_btnEnviarActionPerformed

    private void btnLimpar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpar1ActionPerformed
        limparAlterar();
    }//GEN-LAST:event_btnLimpar1ActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        if(vazioAlterar() == true){
            JOptionPane.showMessageDialog(null, "Há campos vazios.");
        }else{
            String nome = txtNome1.getText();
            String tipo = cmbTipo1.getSelectedItem().toString();
            String tamanho = cmbTamanho1.getSelectedItem().toString();
            String sexo = cmbSexo1.getSelectedItem().toString();
            int quantidade = Integer.parseInt(txtQuant1.getText());
            double valor = Double.parseDouble(txtValor1.getText());
            String dataRegistro = txtDataRegis1.getText();
            if(tipo.equals("Camisa") || tipo.equals("Camiseta") || tipo.equals("Moletom")){
                try {
                    arquivoEstoque.alterarBlusas(nome, tipo, tamanho, sexo, quantidade, valor, dataRegistro, posicao);
                    JOptionPane.showMessageDialog(null, "Alterado com sucesso.");
                    limparAlterar();
                } catch (IOException ex) {
                    Logger.getLogger(JEstoque.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                if(tipo.equals("Calça") || tipo.equals("Bermuda") || tipo.equals("Short")){
                    int numero = Integer.parseInt(cmbNumero1.getSelectedItem().toString());
                    try {
                        arquivoEstoque.alterarCalcas(nome, tipo, numero, sexo, numero, valor, dataRegistro, posicao);
                        JOptionPane.showMessageDialog(null, "Alterado com sucesso.");
                        limparAlterar();
                    } catch (IOException ex) {
                        Logger.getLogger(JEstoque.class.getName()).log(Level.SEVERE, null, ex);
                    } 
                }
            }
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnVoltar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltar3ActionPerformed
        JPrincipal principal = new JPrincipal();
        if(principal.isVisible() == false){
           principal.setVisible(true);
           this.setVisible(false);
        }else{
            this.setVisible(false);
        } 
    }//GEN-LAST:event_btnVoltar3ActionPerformed

    private void cmbTipo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipo1ActionPerformed
        if(cmbTipo1.getSelectedIndex() == 0){
            cmbTamanho1.setEnabled(false);cmbNumero1.setEnabled(false);cmbTamanho1.setSelectedIndex(0);cmbNumero1.setSelectedIndex(0);
        }
        if(cmbTipo1.getSelectedIndex() == 1 || cmbTipo1.getSelectedIndex() == 2 || cmbTipo1.getSelectedIndex() == 3){
            cmbTamanho1.setEnabled(true);cmbNumero1.setEnabled(false);cmbNumero1.setSelectedIndex(0);
        }
        if(cmbTipo1.getSelectedIndex() == 4 || cmbTipo1.getSelectedIndex() == 5 || cmbTipo1.getSelectedIndex() == 6){
            cmbTamanho1.setEnabled(false);cmbNumero1.setEnabled(true);cmbTamanho1.setSelectedIndex(0);
        }
    }//GEN-LAST:event_cmbTipo1ActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if(txtNome2.getText().equals("") && cmbTipo2.getSelectedIndex() == 0 && cmbTamanho2.getSelectedIndex() == 0 
            && cmbNumero2.getSelectedIndex() == 0 && txtCodigo2.getText().equals("")){
            pesquisa();
        }
        if(cmbTipo2.getSelectedIndex() != 0){
            String tipo = cmbTipo2.getSelectedItem().toString();
            pesquisaPorTipo(tipo);
        }
        if(cmbTamanho2.getSelectedIndex() != 0){
            String tamanho = cmbTamanho2.getSelectedItem().toString();
            pesquisaPorTamanho(tamanho);
        }
        if(cmbNumero2.getSelectedIndex() != 0){
            int num = Integer.parseInt(cmbNumero2.getSelectedItem().toString());
            pesquisaPorNumero(num);
        }
        if(!txtNome2.getText().equals("")){
            String nome = txtNome2.getText();
            pesquisaPorNome(nome);
        }
        if(!txtCodigo2.getText().equals("")){
            int codigo = Integer.parseInt(txtCodigo2.getText());
            pesquisaPorCodigo(codigo);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        String nome = table.getValueAt(table.getSelectedRow(), 1).toString();
        if (table.getSelectedRow() >= 0) {

            if (JOptionPane.showConfirmDialog(null, "Deseja excluir realmente?", "Confirmação", 0) == 0) {

                try {
                    if (arquivoEstoque.excluir(nome)) {
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

    private void btnAlterar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterar1ActionPerformed
        String nome = table.getValueAt(table.getSelectedRow(), 1).toString();
        if (table.getSelectedRow() >= 0) {
            List<Blusas> b = arquivoEstoque.outputBlusas();
            List<Calcas> c = arquivoEstoque.outputCalcas();
            for(int i=0;i<b.size();i++){
                if(b.get(i).getNome().equals(nome)){
                   txtNome1.setText(b.get(i).getNome());
                   txtDataRegis1.setText(b.get(i).getDataRegistro());
                   txtQuant1.setText(b.get(i).getQtde()+"");
                   txtValor1.setText(b.get(i).getValor()+"");
                   cmbSexo1.setSelectedItem(b.get(i).getSexo());
                   cmbTamanho1.setSelectedItem(b.get(i).getTamanho());
                   cmbTipo1.setSelectedItem(b.get(i).getTipo());
                   posicao = i;
                   break;
                }
            }
            for(int i=0;i<c.size();i++){
                if(c.get(i).getNome().equals(nome)){
                   txtNome1.setText(c.get(i).getNome());
                   txtDataRegis1.setText(c.get(i).getDataRegistro());
                   txtQuant1.setText(c.get(i).getQtde()+"");
                   txtValor1.setText(c.get(i).getValor()+"");
                   cmbSexo1.setSelectedItem(c.get(i).getSexo());
                   cmbNumero1.setSelectedItem(c.get(i).getNumero()+"");
                   cmbTipo1.setSelectedItem(c.get(i).getTipo());
                   posicao = i;
                   break;
                }
            }
            
            jTabbedPane1.setSelectedIndex(1);
        }else{
           JOptionPane.showMessageDialog(null, "Selecione uma linha.");
        }
    }//GEN-LAST:event_btnAlterar1ActionPerformed

    private void cmbTamanho2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTamanho2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTamanho2ActionPerformed

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
            java.util.logging.Logger.getLogger(JEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JEstoque().setVisible(true);
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
    private javax.swing.JButton btnVoltar2;
    private javax.swing.JButton btnVoltar3;
    private javax.swing.JComboBox cmbNumero;
    private javax.swing.JComboBox cmbNumero1;
    private javax.swing.JComboBox cmbNumero2;
    private javax.swing.JComboBox<String> cmbSexo;
    private javax.swing.JComboBox<String> cmbSexo1;
    private javax.swing.JComboBox cmbTamanho;
    private javax.swing.JComboBox cmbTamanho1;
    private javax.swing.JComboBox cmbTamanho2;
    private javax.swing.JComboBox cmbTipo;
    private javax.swing.JComboBox cmbTipo1;
    private javax.swing.JComboBox cmbTipo2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtCodigo2;
    private javax.swing.JFormattedTextField txtDataRegis;
    private javax.swing.JFormattedTextField txtDataRegis1;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNome1;
    private javax.swing.JTextField txtNome2;
    private javax.swing.JTextField txtQuant;
    private javax.swing.JTextField txtQuant1;
    private javax.swing.JTextField txtValor;
    private javax.swing.JTextField txtValor1;
    // End of variables declaration//GEN-END:variables
}
