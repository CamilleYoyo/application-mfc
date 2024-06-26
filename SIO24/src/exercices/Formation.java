package exercices;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.plaf.ComboBoxUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import javax.swing.JScrollPane;

public class Formation extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Formation frame = new Formation();
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
    private JTextField textIdf_1;
    private JTextField textIntitule_1;
    private JTextField textDescription;
    private JTextField textTarif;
    private JTextField textDuree;
    
    
    
    
    
    
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
	

	public Formation() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Utilisateur\\OneDrive\\Bureau\\Productions\\MFC\\src\\img\\logomfcredi.png"));
		initComponents();
        

		
		
		
		
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1137, 630);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 0, 128));
		panel.setBounds(10, 10, 351, 573);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Formations");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(20, 10, 309, 28);
		panel.add(lblNewLabel);
		

		
		JButton btnNewButton = new JButton("Ajouter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
			          Connect(); 
			          pst = con.prepareStatement("insert formation(Idf,IntuleF,DescriptionF,Tarif,Duree) values(?,?,?,?,?)");
			          pst.setString(1, textIdf_1.getText());
			          pst.setString(2, textIntitule_1.getText());
			          pst.setString(3, textDescription.getText());
			          /*pst.setBigDecimal(3, new BigDecimal(textTarif.getText()));
			          pst.setBigDecimal(4, new BigDecimal(textDuree.getText()));*/
			          pst.setString(4, textTarif.getText());
			          pst.setString(5, textDuree.getText());
			          
			          pst.executeUpdate();
			          con.close();
			          JOptionPane.showMessageDialog(null, "La Formation a bien été Ajouter");
			          Table();
			        }catch (Exception e1){
			          e1.printStackTrace();
			        }
				
				
			}
			
			/*CREATION DU TABLEAU*/
		   /* public void Table(){
		        String[] formation = {"IDF,INTITULE-FOrmation","DESCRIPTION-FORMATION","TARIF","DUREE"};
		        String[] afficher = new String[5];
		        DefaultTableModel model = new DefaultTableModel(null, formation);
		        try{
		            Connect();
		            Statement st = (Statement) con.createStatement();
		            rs = st.executeQuery("select * from formation");
		            
		            while (rs.next()) {
		                afficher[0]= rs.getString("IdF");
		                afficher[1]= rs.getString("IntuleF");
		                afficher[2]= rs.getString("DescriptionF");
		                afficher[3] = rs.getString("Tarif");
		                afficher[4]= rs.getString("Duree");
		                model.addRow(afficher);

		                
		            }
		            table.setModel(model);
		            con.close();
		        }catch(Exception e){
		            e.printStackTrace();
		            
		        }
		    }*/
		});
		btnNewButton.setBackground(new Color(0, 255, 128));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnNewButton.setBounds(41, 79, 258, 43);
		panel.add(btnNewButton);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
			          Connect(); 
			          pst = con.prepareStatement("update formation set IntuleF=? ,DescriptionF=? ,Tarif=? ,Duree=? where IdF=? ");
			          pst.setString(5, textIdf_1.getText());
			          pst.setString(1, textIntitule_1.getText());
			          pst.setString(2, textDescription.getText());
			          /*pst.setBigDecimal(3, new BigDecimal(textTarif.getText()));
			          pst.setBigDecimal(4, new BigDecimal(textDuree.getText()));*/
			          pst.setString(3, textTarif.getText());
			          pst.setString(4, textDuree.getText());
			          
			          pst.executeUpdate();
			          con.close();
			          JOptionPane.showMessageDialog(null, "La Formation a bien été Modifier");
			          Table();
			        }catch (Exception e1){
			          e1.printStackTrace();
			        }
			}
			
		});
		btnModifier.setForeground(new Color(0, 0, 0));
		btnModifier.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnModifier.setBackground(new Color(128, 0, 255));
		btnModifier.setBounds(41, 186, 258, 43);
		panel.add(btnModifier);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
			           Connect();
			           pst = (PreparedStatement) con.prepareStatement("delete from formation where IdF=?");
			           pst.setString(1, textIdf_1.getText());
			           pst.executeUpdate();
			           con.close();
			           JOptionPane.showMessageDialog(null, "La Formation a bient été supprimer");
			        }catch(Exception e1){
			            JOptionPane.showMessageDialog(null, "Il y'a eu une erreur au niveu de : "+e1.getMessage());
			            e1.printStackTrace();
			            
			        }
			}
		});
		btnSupprimer.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnSupprimer.setBackground(new Color(255, 0, 0));
		btnSupprimer.setBounds(41, 286, 258, 43);
		panel.add(btnSupprimer);
		
		JButton btnMenu = new JButton("Menu");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//PASSAGE A LA PAGE SUIVANTE
				Formation.super.dispose();
				Menu men = new Menu();
				men.setVisible(true);
			}
		});
		btnMenu.setForeground(new Color(255, 255, 255));
		btnMenu.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnMenu.setBackground(new Color(255, 0, 128));
		btnMenu.setBounds(41, 484, 258, 43);
		panel.add(btnMenu);
		
		JButton btnAfficher = new JButton("Afficher");
		btnAfficher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Table();
				/* if (table.getRowCount() == 0) {
			            JOptionPane.showMessageDialog(null, "La liste est vide.");
			        } else {
			            Table(); // Appel à la méthode pour afficher les données dans le tableau
			        }*/
			    
			}
		});
		btnAfficher.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnAfficher.setBackground(new Color(255, 255, 255));
		btnAfficher.setBounds(41, 372, 258, 43);
		panel.add(btnAfficher);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 0, 128));
		panel_1.setBounds(381, 10, 732, 573);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.BOLD, 13));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				int i = table.getSelectedRow();
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				textIdf_1.setText(model.getValueAt(i, 0).toString());
				textIntitule_1.setText(model.getValueAt(i, 1).toString());
				textDescription.setText(model.getValueAt(i, 2).toString());
				textTarif.setText(model.getValueAt(i, 3).toString());
				textDuree.setText(model.getValueAt(i, 4).toString());
				
			}
		});
		table.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table.setBounds(10, 350, 712, 202);
		panel_1.add(table);
		
		JLabel lblNewLabel_1 = new JLabel("Id : ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(10, 0, 156, 22);
		panel_1.add(lblNewLabel_1);
		
		textIdf_1 = new JTextField();
		textIdf_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		textIdf_1.setBounds(10, 25, 262, 22);
		panel_1.add(textIdf_1);
		textIdf_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Intitulé-Formation");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(10, 73, 262, 22);
		panel_1.add(lblNewLabel_2);
		
		textIntitule_1 = new JTextField();
		textIntitule_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		textIntitule_1.setBounds(10, 105, 262, 22);
		panel_1.add(textIntitule_1);
		textIntitule_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Description-Formation");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setBounds(10, 137, 262, 22);
		panel_1.add(lblNewLabel_3);
		
		textDescription = new JTextField();
		textDescription.setFont(new Font("Tahoma", Font.BOLD, 13));
		textDescription.setBounds(10, 169, 262, 22);
		panel_1.add(textDescription);
		textDescription.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Tarif");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_4.setBounds(10, 201, 262, 22);
		panel_1.add(lblNewLabel_4);
		
		textTarif = new JTextField();
		textTarif.setFont(new Font("Tahoma", Font.BOLD, 13));
		textTarif.setBounds(10, 233, 262, 22);
		panel_1.add(textTarif);
		textTarif.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Duree");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_5.setBounds(10, 285, 262, 22);
		panel_1.add(lblNewLabel_5);
		
		textDuree = new JTextField();
		textDuree.setFont(new Font("Tahoma", Font.BOLD, 13));
		textDuree.setBounds(10, 318, 262, 22);
		panel_1.add(textDuree);
		textDuree.setColumns(10);
		Table();
	}
	/*CREATION DU TABLEAU*/
	public void Table() {
	    // Définition des noms de colonnes
	    String[] formation = {"IDF", "INTITULE-FORMATION", "DESCRIPTION-FORMATION", "TARIF", "DUREE"};
	    String[] afficher = new String[5];
	    DefaultTableModel model = new DefaultTableModel(null, formation);
	    try {
	        Connect();
	        Statement st = con.createStatement();
	        rs = st.executeQuery("select * from formation");
	        
	        while (rs.next()) {
	            afficher[0] = rs.getString("IdF");
	            afficher[1] = rs.getString("IntuleF");
	            afficher[2] = rs.getString("DescriptionF");
	            afficher[3] = rs.getString("Tarif");
	            afficher[4] = rs.getString("Duree");
	            model.addRow(afficher);
	        }
	        table.setModel(new DefaultTableModel(
	        	new Object[][] {
	        	},
	        	new String[] {
	        		"IDF", "INTITULE-FORMATION", "DESCRIPTION-FORMATION", "TARIF", "DUREE"
	        	}
	        ));
	        con.close();
	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	}

	/*private void Table() {
		// TODO Auto-generated method stub
		
	}*/


	private void initComponents() {
		// TODO Auto-generated method stub
		
	}
}
