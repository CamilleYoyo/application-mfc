package exercices;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Formateur extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textId;
	private JTextField textNom;
	private JTextField textPrenom;
	private JTextField textTel;
	private JTextField textAdresse;
	private JTextField textMail;
	private JTextField textSpecial;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Formateur frame = new Formateur();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	
	
	/*Debut de code pour la base de donnee*/
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    private JTable table;
    
    
    
    
    
    
    
    
    
    /*CREATION DE LA CLASSE POUR CONNECTER A LA BASE DE DONNEE*/
    public void Connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/mfc", "root","");
            /*JOptionPane.showMessageDialog(null, "Connection reussie");*/
        }catch (Exception e) {
            e.printStackTrace();
            
        }
    }

    
    

	/**
	 * Create the frame.
	 */
	public Formateur() {
		initComponents();
        
        
        
        
        
        
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1142, 687);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 0, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 0, 128));
		panel.setForeground(new Color(128, 0, 128));
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 10, 413, 630);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Intervenant-Formateur");
		lblNewLabel.setBackground(new Color(240, 240, 240));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(10, 52, 393, 40);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Ajouter");
		btnNewButton.setBackground(new Color(0, 255, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
			          Connect(); 
			          pst = con.prepareStatement("insert intervenantsformateurs(IdFOR,NomInter,PrenomInter,TelInter,AdresseInter,MailInter,SpecialiteInter) values(?,?,?,?,?,?,?)");
			          pst.setString(1, textId.getText());
			          pst.setString(2, textNom.getText());
			          pst.setString(3, textPrenom.getText());
			          pst.setString(4, textTel.getText());
			          pst.setString(5, textAdresse.getText());
			          pst.setString(6, textMail.getText());
			          pst.setString(7, textSpecial.getText());
			          pst.executeUpdate();
			          con.close();
			          JOptionPane.showMessageDialog(null, "Le Formateur a bien été Ajouter");
			          Table();
			        }catch (Exception e1){
			          e1.printStackTrace();
			        }
			}
			
			
			
		});
		btnNewButton.setBounds(34, 156, 350, 40);
		panel.add(btnNewButton);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
			          Connect(); 
			          pst = (PreparedStatement) con.prepareStatement("update intervenantsformateurs set NomInter=?, PrenomInter=?, TelInter=?, AdresseInter=?, MailInter=?, SpecialiteInter=? where IdFOR=?");
			          pst.setString(7, textId.getText());
			          pst.setString(1, textNom.getText());
			          pst.setString(2, textPrenom.getText());
			          pst.setString(3, textTel.getText());
			          pst.setString(4, textAdresse.getText());
			          pst.setString(5, textMail.getText());
			          pst.setString(6, textSpecial.getText());
			          pst.executeUpdate();
			          con.close();
			          JOptionPane.showMessageDialog(null, "Le Formateur a bien été Modifier");
			          Table();
			        }catch (Exception e1){
			          e1.printStackTrace();
			        }
			}
		});
		btnModifier.setBackground(new Color(128, 0, 255));
		btnModifier.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnModifier.setBounds(34, 268, 350, 40);
		panel.add(btnModifier);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
			           Connect();
			           pst = (PreparedStatement) con.prepareStatement("delete from intervenantsformateurs where IdFOR=?");
			           pst.setString(1, textId.getText());
			           pst.executeUpdate();
			           con.close();
			           JOptionPane.showMessageDialog(null, "Le Formateur a bient été supprimer");
			        }catch(Exception e1){
			            JOptionPane.showMessageDialog(null, "Il y'a eu une erreur au niveu de : "+e1.getMessage());
			            e1.printStackTrace();
			            
			        }
			}
		});
		btnSupprimer.setBackground(new Color(255, 0, 0));
		btnSupprimer.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSupprimer.setBounds(34, 382, 350, 40);
		panel.add(btnSupprimer);
		
		JButton btnMenu = new JButton("Menu");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//PASSAGE A LA PAGE SUIVANTE
				Formateur.super.dispose();
				Menu men = new Menu();
				men.setVisible(true);
			}
		});
		btnMenu.setBackground(new Color(255, 0, 128));
		btnMenu.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnMenu.setBounds(34, 540, 350, 40);
		panel.add(btnMenu);
		
		JLabel lblNewLabel_1 = new JLabel(" Id :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(452, 10, 144, 26);
		contentPane.add(lblNewLabel_1);
		
		textId = new JTextField();
		textId.setFont(new Font("Tahoma", Font.BOLD, 14));
		textId.setBounds(452, 46, 200, 26);
		contentPane.add(textId);
		textId.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nom :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(699, 10, 144, 26);
		contentPane.add(lblNewLabel_1_1);
		
		textNom = new JTextField();
		textNom.setFont(new Font("Tahoma", Font.BOLD, 14));
		textNom.setColumns(10);
		textNom.setBounds(685, 46, 200, 26);
		contentPane.add(textNom);
		
		JLabel lblNewLabel_1_2 = new JLabel("Prenom : ");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_2.setBounds(949, 10, 144, 26);
		contentPane.add(lblNewLabel_1_2);
		
		textPrenom = new JTextField();
		textPrenom.setFont(new Font("Tahoma", Font.BOLD, 14));
		textPrenom.setColumns(10);
		textPrenom.setBounds(918, 46, 200, 26);
		contentPane.add(textPrenom);
		
		JLabel lblNewLabel_1_3 = new JLabel("Telephone : ");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_3.setBounds(452, 93, 144, 26);
		contentPane.add(lblNewLabel_1_3);
		
		textTel = new JTextField();
		textTel.setFont(new Font("Tahoma", Font.BOLD, 14));
		textTel.setColumns(10);
		textTel.setBounds(452, 129, 200, 26);
		contentPane.add(textTel);
		
		JLabel lblNewLabel_1_4 = new JLabel("Adresse : ");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_4.setBounds(722, 93, 144, 26);
		contentPane.add(lblNewLabel_1_4);
		
		textAdresse = new JTextField();
		textAdresse.setFont(new Font("Tahoma", Font.BOLD, 14));
		textAdresse.setColumns(10);
		textAdresse.setBounds(685, 129, 200, 26);
		contentPane.add(textAdresse);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("Email : ");
		lblNewLabel_1_4_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_4_1.setBounds(949, 93, 144, 26);
		contentPane.add(lblNewLabel_1_4_1);
		
		textMail = new JTextField();
		textMail.setFont(new Font("Tahoma", Font.BOLD, 14));
		textMail.setColumns(10);
		textMail.setBounds(942, 129, 200, 26);
		contentPane.add(textMail);
		
		JLabel lblNewLabel_1_4_2 = new JLabel("Spécialité : ");
		lblNewLabel_1_4_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_4_2.setBounds(452, 179, 144, 26);
		contentPane.add(lblNewLabel_1_4_2);
		
		textSpecial = new JTextField();
		textSpecial.setFont(new Font("Tahoma", Font.BOLD, 14));
		textSpecial.setColumns(10);
		textSpecial.setBounds(452, 215, 200, 26);
		contentPane.add(textSpecial);
		
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.BOLD, 14));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				int i = table.getSelectedRow();
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				textId.setText(model.getValueAt(i, 0).toString());
				textNom.setText(model.getValueAt(i, 1).toString());
				textPrenom.setText(model.getValueAt(i, 2).toString());
				textTel.setText(model.getValueAt(i, 3).toString());
				textAdresse.setText(model.getValueAt(i, 4).toString());
				textMail.setText(model.getValueAt(i, 5).toString());
				textSpecial.setText(model.getValueAt(i, 6).toString());
			}
		});
		table.setBounds(452, 275, 666, 365);
		contentPane.add(table);
		Table();
	}

	
	
	
	/*CREATION DU TABLEAU*/
	public void Table() {
	    // Définition des noms de colonnes
	    String[] intervenantsformateurs = {"IdFOR", "NomInter", "PrenomInter", "TelInter", "AdresseInter","MailInter","SpecialiteInter"};
	    String[] afficher = new String[7];
	    DefaultTableModel model = new DefaultTableModel(null, intervenantsformateurs);
	    try {
	        Connect();
	        Statement st = con.createStatement();
	        rs = st.executeQuery("select * from intervenantsformateurs");
	        
	        while (rs.next()) {
	            afficher[0] = rs.getString("IdFOR");
	            afficher[1] = rs.getString("NomInter");
	            afficher[2] = rs.getString("PrenomInter");
	            afficher[3] = rs.getString("TelInter");
	            afficher[4] = rs.getString("AdresseInter");
	            afficher[5] = rs.getString("MailInter");
	            afficher[6] = rs.getString("SpecialiteInter");
	            model.addRow(afficher);
	        }
	        table.setModel(model);
	        con.close();
	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	}


	//private void Table() {
		// TODO Auto-generated method stub
		
	//}


	private void initComponents() {
		// TODO Auto-generated method stub
		
	}
}
