package exercices;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1015, 660);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 0, 128));
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 10, 1036, 692);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel txtmdp = new JLabel("Mot de Passe :");
		txtmdp.setForeground(new Color(255, 255, 255));
		txtmdp.setHorizontalAlignment(SwingConstants.CENTER);
		txtmdp.setFont(new Font("Tahoma", Font.BOLD, 24));
		txtmdp.setBounds(91, 339, 313, 59);
		panel.add(txtmdp);
		
		JLabel txtnom = new JLabel("Utilisateur :");
		txtnom.setForeground(new Color(255, 255, 255));
		txtnom.setHorizontalAlignment(SwingConstants.CENTER);
		txtnom.setFont(new Font("Tahoma", Font.BOLD, 24));
		txtnom.setBounds(119, 178, 313, 59);
		panel.add(txtnom);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 20));
		textField.setBounds(442, 190, 516, 47);
		panel.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 20));
		passwordField.setBounds(442, 339, 516, 59);
		panel.add(passwordField);
		
		JButton btnNewButton = new JButton("Se Connecter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
		            String nomUtilisateur = textField.getText();
		            String mdpUtilisateur = new String(passwordField.getPassword());
		            
		            if (nomUtilisateur.equals("") && mdpUtilisateur.equals("")) {
		                JOptionPane.showMessageDialog(null, "Veuillez remplir les champs", "Message", JOptionPane.OK_OPTION);
		            }
		            else if (nomUtilisateur.equals("Camille") && mdpUtilisateur.equals("1234")) {
		                Login.super.dispose();
		                new Menu().setVisible(true);
		            }
		            else {
		                JOptionPane.showMessageDialog(null,"Mot de passe ou\nNom Utilisateur sont incorrect","Message",JOptionPane.OK_OPTION );
		            }
		            
		        } catch (Exception e1) {
		            e1.printStackTrace();
		        } 
			}
		});
		btnNewButton.setBackground(new Color(0, 255, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnNewButton.setBounds(91, 539, 353, 47);
		panel.add(btnNewButton);
		
		JLabel txtmfc = new JLabel("MAISON DE FORMATION CONTINUE");
		txtmfc.setForeground(new Color(255, 255, 255));
		txtmfc.setHorizontalAlignment(SwingConstants.CENTER);
		txtmfc.setFont(new Font("Tahoma", Font.BOLD, 24));
		txtmfc.setBounds(91, 51, 779, 59);
		panel.add(txtmfc);
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Voulez-vous Quitter l'application?","Message",JOptionPane.OK_OPTION );
				System.exit(0);
				
			}
		});
		btnQuitter.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnQuitter.setBackground(new Color(255, 0, 0));
		btnQuitter.setBounds(610, 539, 348, 47);
		panel.add(btnQuitter);
	}
}
