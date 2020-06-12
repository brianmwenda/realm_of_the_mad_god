package com.brian.rain;

import java.util.Random;

public class Screen {
	
	private int width,height;
	public int[] pixels;
	
	public int[] tiles = new int[64 * 64];
	private Random random = new Random();
	
	//int xtime = 0;
	//int ytime = 0;
	//int counter = 0;
	
	
	public Screen(int width, int height) {
		this.width = width;
		this.height= height;
		pixels = new int[width * height];//50400 pixels
		
		for (int i = 0;i < 64 * 64; i++) {
			tiles[i]=random.nextInt(0xffffff);
		}
		 
	}
	public void clear() {
		for(int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}
					
	}
	
	public void render() {
		//counter++;
		//if(counter % 10 == 0) xtime++;
		//if(counter % 10 == 0) ytime++;
		
		
		for(int y = 0;y < height;y++) {
			if(y < 0 || y >= height) {
				break;
			}
			for(int x = 0;x < width;x++) {
				if(x < 0 || x >= width) {
					break;
				}
				int tileIndex = (x >> 6) + (y >> 6) * 64;
				
				pixels[x + y*width] = tiles[tileIndex];
			}
		}
		
	}

}
