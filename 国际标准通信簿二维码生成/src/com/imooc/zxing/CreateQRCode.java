package com.imooc.zxing;


import java.io.File;
import java.nio.file.Path;
import java.util.HashMap;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

//���ɶ�ά��
public class CreateQRCode {
	
	public static void main(String[] args){
		int width = 300;
		int height = 300;
		String format = "png";
		String content = "http://www.imooc.com";
		String content1 = "BEGIN:VCARD"+"\n"
				+"VERSION:2.1"+"\n"
				+"N:��;����"+"\n"
				+"FN:����"+"\n"
				+"NICKNAME:����Dian"+"\n"
				+"ORG:��˾;����"+"\n"
				+"TITLE:�ϰ�"+"\n"
				+"TEL;WORK;VOICE:�绰1"+"\n"
				
				+"TEL;HOME;VOICE:�绰1"+"\n"
				
				+"TEL;CELL;VOICE:11234567898"+"\n"
				+"TEL;PAGER;VOICE:0000-0000000"+"\n"
			
		
				+"ADR;WORK:;;��λ��ַ;�麣;�㶫;433000;����"+"\n"
				+"ADR;HOME;POSTAL;PARCEL:;;�ֵ���ַ;�麣;�㶫;433330;�й�"+"\n"
				+"URL:www.zhangyingfeng.cn"+"\n"
				+"URL:www.zhangyingfeng.cn"+"\n"
				+"EMAIL;PREF;INTERNET:123456789@qq.com"+"\n"
				+"X-QQ:123456789"+"\n"
				+"END:VCARD";
		
		//�����ά��Ĳ���
		HashMap hints = new HashMap();
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
		hints.put(EncodeHintType.MARGIN, 2);
		
		try{
			BitMatrix bitMatrix = new MultiFormatWriter().encode(content1,BarcodeFormat.QR_CODE,width,height,hints);
			Path file = new File("D:/code/img.png").toPath();
			MatrixToImageWriter.writeToPath(bitMatrix, format, file);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
