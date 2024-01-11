/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package produtos;

import java.awt.Image;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.MessageFormat;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Henrique
 */
public class CadastroProdutos extends javax.swing.JFrame {
    //Conexão com o banco de dados  
    Connection sqlConn = null;
    String conn = "jdbc:mysql://localhost:3306/bdsistema?zeroDateTimeBehavior=convertToNull";
    String username = "root";
    String password = "root";
    
    //Instanciar objeto para o fluxo de bytes
    private FileInputStream arq;
    //Variável global para armazenar o tamanho da imagem(bytes)
    private int tamanho;
    
    public CadastroProdutos() {
        initComponents();
        imprimirDados();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCodigo = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        lblDataCadastro = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        lblQuantidade = new javax.swing.JLabel();
        lblDescricao = new javax.swing.JLabel();
        lblEstoqueMinimo = new javax.swing.JLabel();
        lblEstoqueMaximo = new javax.swing.JLabel();
        lblPrecoCompra = new javax.swing.JLabel();
        lblPrecoVenda = new javax.swing.JLabel();
        lblFatorLucro = new javax.swing.JLabel();
        lblNCM = new javax.swing.JLabel();
        lblCodigoBarras = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        txtQuantidade = new javax.swing.JTextField();
        cbxStatus = new javax.swing.JComboBox<>();
        txtEstoqueMinimo = new javax.swing.JTextField();
        txtEstoqueMaximo = new javax.swing.JTextField();
        txtPrecoVenda = new javax.swing.JTextField();
        txtPrecoCompra = new javax.swing.JTextField();
        txtNCM = new javax.swing.JTextField();
        txtFatorLucro = new javax.swing.JTextField();
        txtCodigoBarras = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaDescricao = new javax.swing.JTextArea();
        btnSair = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnApagar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();
        txtDataCadastro = new javax.swing.JTextField();
        lblFoto = new javax.swing.JLabel();
        btnCarregar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProdutos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCodigo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblCodigo.setText("Código");
        getContentPane().add(lblCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        lblStatus.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblStatus.setText("Status");
        getContentPane().add(lblStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(199, 11, -1, -1));

        lblDataCadastro.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblDataCadastro.setText("Data de Cadastro");
        getContentPane().add(lblDataCadastro, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, -1, -1));

        lblNome.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblNome.setText("Nome");
        getContentPane().add(lblNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 71, -1, -1));

        lblQuantidade.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblQuantidade.setText("Quantidade em Estoque");
        getContentPane().add(lblQuantidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(313, 71, -1, -1));

        lblDescricao.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblDescricao.setText("Descrição");
        getContentPane().add(lblDescricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 124, -1, -1));

        lblEstoqueMinimo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblEstoqueMinimo.setText("Estoque Mínimo");
        getContentPane().add(lblEstoqueMinimo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 194, -1, -1));

        lblEstoqueMaximo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblEstoqueMaximo.setText("Estoque Máximo");
        getContentPane().add(lblEstoqueMaximo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 194, -1, -1));

        lblPrecoCompra.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblPrecoCompra.setText("Preço de Compra (R$)");
        getContentPane().add(lblPrecoCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 254, -1, -1));

        lblPrecoVenda.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblPrecoVenda.setText("Preço de Venda (R$)");
        getContentPane().add(lblPrecoVenda, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 254, -1, -1));

        lblFatorLucro.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblFatorLucro.setText("Fator Lucro (%)");
        getContentPane().add(lblFatorLucro, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 314, -1, -1));

        lblNCM.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblNCM.setText("NCM");
        getContentPane().add(lblNCM, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 314, -1, -1));

        lblCodigoBarras.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblCodigoBarras.setText("Código  de Barras GTIN / EAN");
        getContentPane().add(lblCodigoBarras, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 374, 190, -1));

        txtCodigo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        getContentPane().add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 175, -1));

        txtNome.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        getContentPane().add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 92, 285, -1));

        txtQuantidade.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        getContentPane().add(txtQuantidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(313, 92, 190, -1));

        cbxStatus.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cbxStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "I - Inativo", "A - Ativo" }));
        getContentPane().add(cbxStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 32, 120, -1));

        txtEstoqueMinimo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        getContentPane().add(txtEstoqueMinimo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 215, 164, -1));

        txtEstoqueMaximo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        getContentPane().add(txtEstoqueMaximo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 215, 164, -1));

        txtPrecoVenda.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        getContentPane().add(txtPrecoVenda, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 275, 164, -1));

        txtPrecoCompra.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        getContentPane().add(txtPrecoCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 275, 164, -1));

        txtNCM.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        getContentPane().add(txtNCM, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 335, 164, -1));

        txtFatorLucro.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        getContentPane().add(txtFatorLucro, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 335, 164, -1));

        txtCodigoBarras.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        getContentPane().add(txtCodigoBarras, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 395, 330, -1));

        txaDescricao.setColumns(20);
        txaDescricao.setRows(5);
        jScrollPane1.setViewportView(txaDescricao);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 145, 493, 43));

        btnSair.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });
        getContentPane().add(btnSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 360, 100, 40));

        btnNovo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });
        getContentPane().add(btnNovo, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 10, 100, 40));

        btnAlterar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAlterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 80, 100, 40));

        btnApagar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnApagar.setText("Apagar");
        btnApagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApagarActionPerformed(evt);
            }
        });
        getContentPane().add(btnApagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 150, 100, 40));

        btnLimpar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });
        getContentPane().add(btnLimpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 220, 100, 40));

        btnImprimir.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnImprimir.setText("Imprimir");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });
        getContentPane().add(btnImprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 290, 100, 40));

        txtDataCadastro.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        getContentPane().add(txtDataCadastro, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, 175, -1));

        lblFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/photoIcon.png"))); // NOI18N
        getContentPane().add(lblFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 210, 128, 128));

        btnCarregar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnCarregar.setText("Carregar foto");
        btnCarregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCarregarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCarregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 350, -1, -1));

        tblProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Status", "Nome", "Qtd. Estoque", "Estoque Mín.", "Estoque Máx.", "Preço Compra", "Preço Venda", "Fator Lucro"
            }
        ));
        jScrollPane2.setViewportView(tblProdutos);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 690, 210));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    PreparedStatement pst = null;
    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        float fatorLucro = calcularFatorLucro();
        String query = "INSERT INTO Produto (cod, status, nome, descricao, qtd_estoque, estoque_minimo, estoque_maximo,"
                + "preco_compra, preco_venda, bar_code, ncm, fator, data_cadastro, imagem) VALUE (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            sqlConn = DriverManager.getConnection(conn, username, password);
            pst = sqlConn.prepareStatement(query);
            pst.setString(1, txtCodigo.getText());
            pst.setString(2, cbxStatus.getSelectedItem().toString().substring(0, 1));
            pst.setString(3, txtNome.getText());
            pst.setString(4, txaDescricao.getText());
            pst.setString(5, txtQuantidade.getText());
            pst.setString(6, txtEstoqueMinimo.getText());
            pst.setString(7, txtEstoqueMaximo.getText());
            pst.setString(8, txtPrecoCompra.getText());
            pst.setString(9, txtPrecoVenda.getText());
            pst.setString(10, txtCodigoBarras.getText());
            pst.setString(11, txtNCM.getText());
            pst.setFloat(12, fatorLucro);
            pst.setString(13, txtDataCadastro.getText());
            pst.setBlob(14, arq, tamanho);
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Produto adicionado com sucesso!");
            limparCampos();
        } catch(ClassNotFoundException e) {
            java.util.logging.Logger.getLogger(CadastroProdutos.class.getName()).log(
                java.util.logging.Level.SEVERE,
                null, e);
            JOptionPane.showMessageDialog(this, "Não foi possível adicionar o produto no cadastro", "Erro", 2);
        }catch(Exception e) {
            java.util.logging.Logger.getLogger(CadastroProdutos.class.getName()).log(
                java.util.logging.Level.SEVERE,
                    null, e);
            JOptionPane.showMessageDialog(this, "Não foi possível adicionar o produto no cadastro", "Erro", 2);
        }
        imprimirDados();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        float fatorLucro = calcularFatorLucro();
        String query = "UPDATE Produto SET cod = ?, status = ?, nome = ?, descricao = ?, qtd_estoque = ?, estoque_minimo = ?, estoque_maximo = ?,"
                + "preco_compra = ?, preco_venda = ?, bar_code = ?, ncm = ?, fator = ?, data_cadastro = ?, imagem = ? WHERE cod = ?;";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            sqlConn = DriverManager.getConnection(conn, username, password);
            pst = sqlConn.prepareStatement(query);
            pst.setString(1, txtCodigo.getText());
            pst.setString(2, cbxStatus.getSelectedItem().toString().substring(0, 1));
            pst.setString(3, txtNome.getText());
            pst.setString(4, txaDescricao.getText());
            pst.setString(5, txtQuantidade.getText());
            pst.setString(6, txtEstoqueMinimo.getText());
            pst.setString(7, txtEstoqueMaximo.getText());
            pst.setString(8, txtPrecoCompra.getText());
            pst.setString(9, txtPrecoVenda.getText());
            pst.setString(10, txtCodigoBarras.getText());
            pst.setString(11, txtNCM.getText());
            pst.setFloat(12, fatorLucro);
            pst.setString(13, txtDataCadastro.getText());
            pst.setBlob(14, arq, tamanho);
            pst.setString(15, txtCodigo.getText());
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Produto alterado com sucesso!");
            limparCampos();
        } catch(ClassNotFoundException e) {
            java.util.logging.Logger.getLogger(CadastroProdutos.class.getName()).log(
                java.util.logging.Level.SEVERE,
                null, e);
        }catch(Exception e) {
            java.util.logging.Logger.getLogger(CadastroProdutos.class.getName()).log(
                java.util.logging.Level.SEVERE,
                    null, e);
            JOptionPane.showMessageDialog(this, "Não foi possível alterar o produto no cadastro", "Erro", 2);
        }
        imprimirDados();
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApagarActionPerformed
        String query = "DELETE FROM produto WHERE cod = ?";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            sqlConn = DriverManager.getConnection(conn, username, password);
            pst = sqlConn.prepareStatement(query);
            pst.setString(1, txtCodigo.getText());
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Produto removido com sucesso!");
            limparCampos();
        } catch (ClassNotFoundException e) {
            java.util.logging.Logger.getLogger(CadastroProdutos.class.getName()).log(
                java.util.logging.Level.SEVERE,
                null, e);
        }catch(Exception e) {
            java.util.logging.Logger.getLogger(CadastroProdutos.class.getName()).log(
                java.util.logging.Level.SEVERE,
                    null, e);
            JOptionPane.showMessageDialog(this, "Não foi possível deletar o produto no cadastro", "Erro", 2);
        }
        imprimirDados();
    }//GEN-LAST:event_btnApagarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limparCampos();
        imprimirDados();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        MessageFormat header = new MessageFormat("Impressão Padrão");
        MessageFormat footer = new MessageFormat("Página, (0, number, integer)");
        try {
            tblProdutos.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        } catch (java.awt.print.PrinterException e) {
            System.err.format("Impressão não encontrada", e.getMessage());
        }
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnCarregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCarregarActionPerformed
        carregarFoto();
    }//GEN-LAST:event_btnCarregarActionPerformed

    private Icon imgInicial;

    public void limparCampos() {
        txtCodigo.setText("");
        txtNome.setText("");
        txtQuantidade.setText("");
        txtEstoqueMinimo.setText("");
        txtEstoqueMaximo.setText("");
        txtPrecoCompra.setText("");
        txtPrecoVenda.setText("");
        txtFatorLucro.setText("");
        txtNCM.setText("");
        txtCodigoBarras.setText("");
        txaDescricao.setText("");
        cbxStatus.setSelectedIndex(0);
        txtDataCadastro.setText("");
        retornarIcone();
    }
    
    public void carregarFoto() {
        JFileChooser img = new JFileChooser();
        img.setDialogTitle("Selecionar foto");
        img.setFileFilter(new FileNameExtensionFilter("Arquivo de imagens (*.PNG, *.JPG, *.JPEG)", "png", "jpg", "jpeg"));
        int resultado = img.showOpenDialog(this); //Abre a janela para selecionar um arquivo
        if(resultado == JFileChooser.APPROVE_OPTION) {
            try {
                arq = new FileInputStream(img.getSelectedFile());
                tamanho = (int) img.getSelectedFile().length();
                Image foto = ImageIO.read(img.getSelectedFile()).getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_SMOOTH);
                lblFoto.setIcon(new ImageIcon(foto));
                lblFoto.updateUI();
            }catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    
    public void imprimirDados() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection sqlConn = DriverManager.getConnection(conn, username, password);
            Statement statement = sqlConn.createStatement();
            ResultSet resultado = statement.executeQuery("SELECT * FROM Produto");
            DefaultTableModel model = (DefaultTableModel) tblProdutos.getModel();
            model.setRowCount(0);
            
            while(resultado.next()) {
                String codigo = resultado.getString("cod");
                String status = resultado.getString("status");
                String nome = resultado.getString("nome");
                String qtdEstoque = String.valueOf(resultado.getInt("qtd_estoque"));
                String estoqueMin = String.valueOf(resultado.getInt("estoque_minimo"));
                String estoqueMax = String.valueOf(resultado.getInt("estoque_maximo"));
                String precoCompra =("R$ " + String.valueOf(resultado.getFloat("preco_compra")));
                String precoVenda = ("R$ " + String.valueOf(resultado.getFloat("preco_venda")));
                String fator = (String.valueOf(resultado.getFloat("fator")) + " %");
                String[] rows = {codigo, status, nome, qtdEstoque, estoqueMin, estoqueMax, precoCompra, precoVenda, fator};
                model.addRow(rows);
            }
        } catch (Exception e) {
            System.out.println("Erro: "+ e.getMessage());
        }
    }
    
    public float calcularFatorLucro() {
        float precoCompra, precoVenda, lucro;
        
        precoCompra = Float.valueOf(txtPrecoCompra.getText());
        precoVenda = Float.valueOf(txtPrecoVenda.getText());
        lucro = (precoCompra / precoVenda) * 100;
        
        txtFatorLucro.setText(Float.toString(lucro));
        return lucro;
    }
    
    public void retornarIcone() {
        ImageIcon icone = new ImageIcon(getClass().getResource("photoIcon.png"));
        lblFoto.setIcon(icone);
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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadastroProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroProdutos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnApagar;
    private javax.swing.JButton btnCarregar;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSair;
    private javax.swing.JComboBox<String> cbxStatus;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblCodigoBarras;
    private javax.swing.JLabel lblDataCadastro;
    private javax.swing.JLabel lblDescricao;
    private javax.swing.JLabel lblEstoqueMaximo;
    private javax.swing.JLabel lblEstoqueMinimo;
    private javax.swing.JLabel lblFatorLucro;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JLabel lblNCM;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblPrecoCompra;
    private javax.swing.JLabel lblPrecoVenda;
    private javax.swing.JLabel lblQuantidade;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JTable tblProdutos;
    private javax.swing.JTextArea txaDescricao;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCodigoBarras;
    private javax.swing.JTextField txtDataCadastro;
    private javax.swing.JTextField txtEstoqueMaximo;
    private javax.swing.JTextField txtEstoqueMinimo;
    private javax.swing.JTextField txtFatorLucro;
    private javax.swing.JTextField txtNCM;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPrecoCompra;
    private javax.swing.JTextField txtPrecoVenda;
    private javax.swing.JTextField txtQuantidade;
    // End of variables declaration//GEN-END:variables

}
