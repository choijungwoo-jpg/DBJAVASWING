import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ex01 extends JFrame implements ActionListener {
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnCancel = new JButton("Cancel");
	private JButton btnLogin = new JButton("Login");

	@Override
	public void actionPerformed(ActionEvent e) {
//		System.out.println("e.getSource() = "+e.getSource());
		if (e.getSource() == btnCancel) {
			System.exit(0);
		} else {
			// DB �����ؼ� ID PW�� ������;
			/*
			 * 1. ojdbc6.jar ���� �����ͼ� ������Ʈ�� �����н� ���� 
			 * 2. class.forname �Լ��� class �߰� �Ǿ����� Ȯ�� 
			 * 3. Connection DriverManager.getConnection DB ���� 
			 * 4. PreparedStatement pstmt sql ���� ���� 
			 * 5. Resultset ���̺� ������.
			 * 
			 * insert delete update -> executeUpdate(); ��ȯ���� 0,1
			 * select -> executeQuery(); ��ȯ���� ���̺�
			 * 
			 */
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","1234");
				pstmt = conn.prepareStatement("select * from member where id=? and pw=?");
				pstmt.setString(1, textField.getText());
				pstmt.setString(2, textField_1.getText());			
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
//					System.out.println("id = "+rs.getString(1));
//					System.out.println("pw = "+rs.getString(2));
					setVisible(false);
					new MainForm();
				}else {
					JOptionPane.showMessageDialog(null, "�α��� ������ �����ϼ���.");
				}
				
			}catch (Exception ex) {
				ex.printStackTrace();
			}finally {
				try {
				rs.close();
				pstmt.close();
				conn.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	Ex01() {
		setLocation(400, 200);
//		setLocationRelativeTo(null);  //JFrame �߰����� ����

		setTitle("LoginForm");

		setSize(279, 350);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 153));
		panel.setBounds(0, 0, 284, 86);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Login Form");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("�ü�", Font.BOLD, 30));
		lblNewLabel.setBounds(27, 10, 214, 51);
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(51, 52, 204));
		panel_1.setBounds(0, 85, 284, 277);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		btnCancel.setFont(new Font("����", Font.BOLD, 12));
		btnCancel.setBounds(12, 134, 95, 81);
		panel_1.add(btnCancel);

		btnLogin.setFont(new Font("�ü�", Font.BOLD, 12));
		btnLogin.setBounds(157, 134, 95, 81);
		panel_1.add(btnLogin);

		JLabel lblID = new JLabel("ID");
		lblID.setFont(new Font("�ü�", Font.BOLD, 40));
		lblID.setForeground(Color.WHITE);
		lblID.setBounds(12, 10, 50, 52);
		panel_1.add(lblID);

		JLabel lblPW = new JLabel("PW");
		lblPW.setForeground(Color.WHITE);
		lblPW.setFont(new Font("�ü�", Font.BOLD, 40));
		lblPW.setBounds(12, 72, 62, 52);
		panel_1.add(lblPW);

		textField = new JTextField();
		textField.setBounds(84, 10, 168, 40);
		panel_1.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(83, 72, 169, 45);
		panel_1.add(textField_1);
		setVisible(true);

		btnCancel.addActionListener(this);
		btnLogin.addActionListener(this);

	}

	public static void main(String[] args) {
		new Ex01();
	}

}
