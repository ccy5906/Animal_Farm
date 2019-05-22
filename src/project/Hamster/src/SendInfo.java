package project.Hamster.src;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.Properties;

import javax.activation.CommandMap;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.activation.MailcapCommandMap;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SendInfo extends JFrame {
	String kindanimal = "";

	public SendInfo(String kindanimal) {
		Dimension res = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		setPreferredSize(new Dimension(res.width - 400, res.height/4));
		JPanel contentPane = new JPanel();
		contentPane.setLayout(null);
		getContentPane().add(contentPane);

		Font font = new Font("210 라임 B", Font.PLAIN, 25);
		contentPane.setBackground(new Color(222,235,247));
		
		this.kindanimal = kindanimal;
		
		JLabel edit = new JLabel("이메일 주소");
		edit.setBounds(50, 50, res.width/2, 50);
		edit.setFont(font);
		contentPane.add(edit);
		
		
		  JTextField EditEmail = new JTextField(""); 
		  EditEmail.setBounds(50, 100,res.width/2, 50); 
		  EditEmail.setFont(font);
		  contentPane.add(EditEmail);
		 
		JButton send = new JButton("전송");
		send.setFont(font);
		send.setBackground(Color.WHITE);
		send.setFocusPainted(false);
		send.setBounds(res.width/2+100, 100, 200, 50);
		send.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new GmailSend(EditEmail.getText());
			}
		});
		contentPane.add(send);

		pack();
		setVisible(true);
		setLocation((res.width - getWidth()) / 2, (res.height - getHeight()) / 2);
		
	}
	
	 class GmailSend{
		 String filename="";
		 GmailSend(String getuser) {
		        String user = "team.animalfarm@gmail.com"; // 네이버일 경우 네이버 계정, gmail경우 gmail 계정
		        String password = "ehdanfshdwkd!";   // 패스워드

		        // SMTP 서버 정보를 설정한다.
		        Properties prop = new Properties();
		        prop.put("mail.smtp.host", "smtp.gmail.com"); 
		        prop.put("mail.smtp.port", 465); 
		        prop.put("mail.smtp.auth", "true"); 
		        prop.put("mail.smtp.ssl.enable", "true"); 
		        prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		        
		        Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator() {
		            protected PasswordAuthentication getPasswordAuthentication() {
		                return new PasswordAuthentication(user, password);
		            }
		        });

		        try {
		            MimeMessage message = new MimeMessage(session);
		            message.setFrom(new InternetAddress(user));

		            //수신자메일주소
		            message.addRecipient(Message.RecipientType.TO, new InternetAddress(getuser)); 

		            // Subject
		            message.setSubject(kindanimal+" 상황 대처 및 주의사항"); //메일 제목을 입력

		            Multipart mp = new MimeMultipart();
		            
		            // Text
		            if(kindanimal.equals("강아지")) {
		            	filename = "file/dog.txt";
		            }
		            else if(kindanimal.equals("고양이")) {
		            	filename = "file/cat.txt";
		            }
		            if(kindanimal.equals("햄스터")) {
		            	filename = "file/hamster.txt";
		            }
		            if(filename != null){
		            	if(fileSizeCheck(filename)){
		            	MimeBodyPart mbp = new MimeBodyPart();
		            	FileDataSource fds = new FileDataSource(filename);
		            	mbp.setDataHandler(new DataHandler(fds));
		            	mbp.setFileName(MimeUtility.encodeText(fds.getName(), "UTF-8", "B"));
		            	mp.addBodyPart(mbp);
		            	}else{
		            	throw new Exception("file size overflow !");
		            	}
		            	}
		            	MailcapCommandMap mc = (MailcapCommandMap) CommandMap.getDefaultCommandMap();
		            	mc.addMailcap("text/html;; x-java-content-handler=com.sun.mail.handlers.text_html");
		            	mc.addMailcap("text/xml;; x-java-content-handler=com.sun.mail.handlers.text_xml");
		            	mc.addMailcap("text/plain;; x-java-content-handler=com.sun.mail.handlers.text_plain");
		            	mc.addMailcap("multipart/*;; x-java-content-handler=com.sun.mail.handlers.multipart_mixed");
		            	mc.addMailcap("message/rfc822;; x-java-content-handler=com.sun.mail.handlers.message_rfc822");
		            	CommandMap.setDefaultCommandMap(mc);
		            	message.setContent(mp);
				/*
				 * message.setText("내용을 입력하세요"); //메일 내용을 입력
				 */
		            
		            // send the message
		            Transport.send(message); ////전송
		            System.out.println("message sent successfully...");
		            dispose();
		        } catch (AddressException e) {
		            // TODO Auto-generated catch block
		            e.printStackTrace();
		        } catch (MessagingException e) {
		            // TODO Auto-generated catch block
		            e.printStackTrace();
		        } catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		       
		    }
	        protected boolean fileSizeCheck(String filename) {
	        	if(new File(filename).length() > (1024 * 1024 * 2.5)) {return false;}
	        	return true;
	        	}
	 }
	 
	public static void main(String[] args) {
		new SendInfo("강아지");
	}

	

}
