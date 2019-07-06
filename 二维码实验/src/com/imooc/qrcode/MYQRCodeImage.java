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
		// TODO �Զ����ɵķ������
		return bufferedImage.getHeight();
	}

	@Override
	public int getPixel(int arg0, int arg1) {
		// TODO �Զ����ɵķ������
		return bufferedImage.getRGB(arg0,arg1);
	}

	@Override
	public int getWidth() {
		// TODO �Զ����ɵķ������
		return bufferedImage.getWidth();
	}

}
