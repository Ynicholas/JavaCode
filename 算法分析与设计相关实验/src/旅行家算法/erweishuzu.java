package dazuoye;

import java.io.File;
import java.io.FileInputStream;

public class erweishuzu {
	public static void main(String args[]){
		File file = new File("C:/Users/***/Desktop/shujuji.txt");
		try{
			FileInputStream in = new FileInputStream(file);
			byte byt[] = new byte[4096];
			int len = in.read(byt);
			String shujuwenben = new String(byt,0,len);
			
			//System.out.println(shujuwenben);
			in.close();
			String[] shuju = shujuwenben.split(" ");
//			for (int i = 0; i < shuju.length; i++) {
//				System.out.println(Double.parseDouble(shuju[i]));
//			}
//			System.out.println(shuju.length);
			
			
			
			
			
			int shujulength = shuju.length;
			int e = (int)shujulength/3;
			//System.out.println(e);
			double x1[] = new double[e];
			double x2[] = new double[e];
			for(int i = 0;i < shuju.length; i++){	
				int b = (int)(i/3);
				int c = (int)(i%3);
				if( c == 1){
					x1[b] = Double.parseDouble(shuju[i]); 
					
				}else if(c == 2){
					x2[b] = Double.parseDouble(shuju[i]); 
					
				}
			}
			double[][] z = new double[e][e];
			
			for(int i = 0;i < e;i++){
				for(int j = 0;j < e;j++){
					double d = Math.pow((x1[i]-x1[j]),2) + Math.pow((x2[i]-x2[j]),2);
					z[i][j] = Math.sqrt(d);
				}
			}
			for(int i = 0;i < e;i++){
				for(int j = 0;j < e;j++){
					System.out.println(z[i][j]);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
