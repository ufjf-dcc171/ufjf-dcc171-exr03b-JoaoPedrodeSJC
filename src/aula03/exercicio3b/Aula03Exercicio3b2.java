/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula03.exercicio3b;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Aula03Exercicio3b2 extends JFrame{
    
    private final JLabel saida1,saida2,saida4;
    private final JTextField entrada1,entrada2;
    private final JButton soma,subtracao,multip,divisao;
    public Aula03Exercicio3b2() throws HeadlessException
    {
        super("Raizes da equação de segundo grau");
        setLayout(new FlowLayout(FlowLayout.LEFT));
        saida1 = new JLabel("Valor 1 = ");
        saida2 = new JLabel("Valor 2 = ");
        saida4 = new JLabel("");
        soma = new JButton("Soma");
        subtracao = new JButton("Subtração");
        multip = new JButton("Multiplicação");
        divisao = new JButton("Divisão");
        entrada1 = new JTextField(5);
        entrada2 = new JTextField(5);
        add(saida1);
        add(entrada1);
        add(saida2);
        add(entrada2);
        add(soma);
        add(subtracao);
        add(multip);
        add(divisao);
        add(saida4);
        soma.addActionListener(new operacao(1));
        subtracao.addActionListener(new operacao(2));
        multip.addActionListener(new operacao(3));
        divisao.addActionListener(new operacao(4));
    }

    private class operacao implements ActionListener {
        int op;
        public operacao(int num)
        {
            this.op = num;
        }
        @Override
        public void actionPerformed(ActionEvent e){
            try
            {
                int num1 = Integer.parseInt(entrada1.getText());
                int num2 = Integer.parseInt(entrada2.getText());
                
                if(op==1)
                {
                    saida4.setText("Soma = " + (num1 + num2));
                }
                else if(op==2)
                {
                    saida4.setText("Subtração = " + (num1 - num2));
                }
                else if(op==3)
                {
                    saida4.setText("Multiplicação = " + (num1 * num2));
                }
                else
                {
                    float num3 = num1;
                    float num4 = num2;
                    saida4.setText("Divisão = " + (num3 / num4));
                }
                
            }
            catch(NumberFormatException ex)
            {
                JOptionPane.showMessageDialog(null,"Valor digitado não é um número","ERRO", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
