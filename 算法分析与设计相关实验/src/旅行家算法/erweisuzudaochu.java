package dazuoye;

import java.io.File;
import java.io.FileInputStream;

public class erweisuzudaochu {
	public double[][] erweishuzudaochufangfa(){
		File file = new File("C:/Users/***/Desktop/shujuji.txt");
		try{
			FileInputStream in = new FileInputStream(file);
			byte byt[] = new byte[2048];
			int len = in.read(byt);
			String shujuwenben = new String(byt,0,len);
			in.close();
			String[] shuju = shujuwenben.split(" ");	
			int shujulength = shuju.length;
			int e = (int)shujulength/3;
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
			return z;
		}catch(Exception e){
			e.printStackTrace();
			double[][] zz = null;
			return zz;
		}
		
	}
}

