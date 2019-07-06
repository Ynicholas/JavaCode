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

//生成二维码
public class CreateQRCode {
	
	public static void main(String[] args){
		int width = 300;
		int height = 300;
		String format = "png";
		String content = "http://www.imooc.com";
		String content1 = "BEGIN:VCARD"+"\n"
				+"VERSION:2.1"+"\n"
				+"N:张;大明"+"\n"
				+"FN:姓名"+"\n"
				+"NICKNAME:点灬Dian"+"\n"
				+"ORG:公司;部门"+"\n"
				+"TITLE:老板"+"\n"
				+"TEL;WORK;VOICE:电话1"+"\n"
				
				+"TEL;HOME;VOICE:电话1"+"\n"
				
				+"TEL;CELL;VOICE:11234567898"+"\n"
				+"TEL;PAGER;VOICE:0000-0000000"+"\n"
			
		
				+"ADR;WORK:;;单位地址;珠海;广东;433000;国家"+"\n"
				+"ADR;HOME;POSTAL;PARCEL:;;街道地址;珠海;广东;433330;中国"+"\n"
				+"URL:www.zhangyingfeng.cn"+"\n"
				+"URL:www.zhangyingfeng.cn"+"\n"
				+"EMAIL;PREF;INTERNET:123456789@qq.com"+"\n"
				+"X-QQ:123456789"+"\n"
				+"END:VCARD";
		
		//定义二维码的参数
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
