package com.trabalho;

import com.trabalho.ui.MenuPrincipalFrame;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    private final SistemaCompraVenda sistema = new SistemaCompraVenda();
    private final JTextField campoEmail = new JTextField();
    private final JPasswordField campoSenha = new JPasswordField();

    public Main() {
        setTitle("EMPRESA X - Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420, 280);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new BorderLayout(12, 12));

        JPanel painel = new JPanel(new GridBagLayout());
        painel.setBackground(new Color(16, 24, 32));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel titulo = new JLabel("Faça o seu login");
        titulo.setForeground(Color.WHITE);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        painel.add(titulo, gbc);

        JLabel lblEmail = new JLabel("E-mail");
        lblEmail.setForeground(Color.WHITE);
        gbc.gridwidth = 1;
        gbc.gridy = 1;
        gbc.gridx = 0;
        painel.add(lblEmail, gbc);

        campoEmail.setText("admin@empresa.com");
        gbc.gridx = 1;
        painel.add(campoEmail, gbc);

        JLabel lblSenha = new JLabel("Senha");
        lblSenha.setForeground(Color.WHITE);
        gbc.gridx = 0;
        gbc.gridy = 2;
        painel.add(lblSenha, gbc);

        campoSenha.setText("123");
        gbc.gridx = 1;
        painel.add(campoSenha, gbc);

        JButton btnEntrar = new JButton("Entrar");
        btnEntrar.setBackground(new Color(255, 102, 153));
        btnEntrar.setForeground(Color.WHITE);
        btnEntrar.setFocusPainted(false);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        painel.add(btnEntrar, gbc);

        add(painel, BorderLayout.CENTER);

        btnEntrar.addActionListener(e -> realizarLogin());
    }

    private void realizarLogin() {
        String email = campoEmail.getText().trim();
        String senha = new String(campoSenha.getPassword());

        if (sistema.autenticar(email, senha)) {
            JOptionPane.showMessageDialog(this, "Login realizado com sucesso!");
            new MenuPrincipalFrame(sistema);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "E-mail ou senha inválidos.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Main login = new Main();
            login.setVisible(true);
        });
    }
}
