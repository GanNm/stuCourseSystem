<%@page import="java.awt.image.BufferedImage" pageEncoding="gb2312"%>
<%@page import="java.awt.Graphics"%>
<%@page import="javax.imageio.ImageIO"%>
<%@page import="java.awt.Font"%>
<%@page import="java.awt.Color"%>
<%
	//让这个图片不存在于客户端缓存
	response.setHeader("Cache-Control","no-cache");
	int width = 100,height = 30;
	//图像
	BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);//宽度，高度，类型
	//得到画笔
	Graphics gra = image.getGraphics();
	//在界面上画一个矩形，用某种颜色填充
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
	
	//将str画在界面上，用蓝色，字体大小和图片高度一致
	gra.setFont(new Font("",Font.ITALIC,height));
	gra.setColor(new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255)));
	gra.drawString(str,10,height-3);//参数2和参数3是字符串画的位置的左下角的横坐标和纵坐标
	
	//加100个干扰点，实心圆，颜色随机
	for(int i=1;i<=100;i++){
		gra.setColor(new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255)));
		gra.fillOval((int)(Math.random()*width),(int)(Math.random()*height),2,2);//圆直径为2
	}
		
	
	// 输出图象到页面 
	ImageIO.write(image, "JPEG", response.getOutputStream());
	//清空缓冲区
	out.clear();
	out = pageContext.pushBody();
%>