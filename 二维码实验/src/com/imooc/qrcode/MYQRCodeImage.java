package com.imooc.qrcode;

import java.awt.image.BufferedImage;

import jp.sourceforge.qrcode.data.QRCodeImage;

public class MYQRCodeImage implements QRCodeImage {
	BufferedImage bufferedImage;
	public MYQRCodeImage(BufferedImage bufferedImage){
		this.bufferedImage = bufferedImage;
	}
	
	@Override
	public int getHeight() {
		// TODO 自动生成的方法存根
		return bufferedImage.getHeight();
	}

	@Override
	public int getPixel(int arg0, int arg1) {
		// TODO 自动生成的方法存根
		return bufferedImage.getRGB(arg0,arg1);
	}

	@Override
	public int getWidth() {
		// TODO 自动生成的方法存根
		return bufferedImage.getWidth();
	}

}
