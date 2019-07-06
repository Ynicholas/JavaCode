package com.imooc.qrcode;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import jp.sourceforge.qrcode.QRCodeDecoder;

public class ReadQRCode {

	public static void main(String[] args) throws Exception {
		// TODO 自动生成的方法存根
		File file = new File("D:/code/qrcode.png");
		BufferedImage bufferedImage = ImageIO.read(file);
		QRCodeDecoder codeDecoder = new QRCodeDecoder();
		String result = new String(codeDecoder.decode(new MYQRCodeImage(bufferedImage)),"gb2312");
		System.out.println(result);
	}

}
