<%@page import="java.awt.image.BufferedImage" pageEncoding="gb2312"%>
<%@page import="java.awt.Graphics"%>
<%@page import="javax.imageio.ImageIO"%>
<%@page import="java.awt.Font"%>
<%@page import="java.awt.Color"%>
<%
	//�����ͼƬ�������ڿͻ��˻���
	response.setHeader("Cache-Control","no-cache");
	int width = 100,height = 30;
	//ͼ��
	BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);//��ȣ��߶ȣ�����
	//�õ�����
	Graphics gra = image.getGraphics();
	//�ڽ����ϻ�һ�����Σ���ĳ����ɫ���
	gra.setColor(Color.WHITE);
	gra.fillRect(0,0,width,height);
	gra.setColor(Color.BLACK);
	gra.drawRect(0,0,width-1,height-1);
	
	String str = "";
	str = str + (int)(Math.random()*10);
	str = str + (int)(Math.random()*10);
	str = str + (int)(Math.random()*10);
	str = str + (int)(Math.random()*10);
	
	session.setAttribute("code",str);
	
	//��str���ڽ����ϣ�����ɫ�������С��ͼƬ�߶�һ��
	gra.setFont(new Font("",Font.ITALIC,height));
	gra.setColor(new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255)));
	gra.drawString(str,10,height-3);//����2�Ͳ���3���ַ�������λ�õ����½ǵĺ������������
	
	//��100�����ŵ㣬ʵ��Բ����ɫ���
	for(int i=1;i<=100;i++){
		gra.setColor(new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255)));
		gra.fillOval((int)(Math.random()*width),(int)(Math.random()*height),2,2);//Բֱ��Ϊ2
	}
		
	
	// ���ͼ��ҳ�� 
	ImageIO.write(image, "JPEG", response.getOutputStream());
	//��ջ�����
	out.clear();
	out = pageContext.pushBody();
%>