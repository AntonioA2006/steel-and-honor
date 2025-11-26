package main;

import object.OBJ_Chest;
import object.OBJ_Door;
import object.OBJ_Key;

public class AssetSetter {
	GamePanel gp; 
	
	public AssetSetter(GamePanel gp) {
		this.gp = gp;
	}
	public void setObject() {
			gp.obj[0] = new OBJ_Key();
			gp.obj[0].wordX = 23 * gp.titleSize;
			gp.obj[0].wordY = 7 * gp.titleSize;
			
			gp.obj[1] = new OBJ_Key();
			gp.obj[1].wordX = 23 * gp.titleSize;
			gp.obj[1].wordY = 40 * gp.titleSize;
			
			gp.obj[2] = new OBJ_Key();
			gp.obj[2].wordX = 38 * gp.titleSize;
			gp.obj[2].wordY = 7 * gp.titleSize;

			gp.obj[3] = new OBJ_Door();
			gp.obj[3].wordX = 10 * gp.titleSize;
			gp.obj[3].wordY = 11 * gp.titleSize;

			gp.obj[4] = new OBJ_Door();
			gp.obj[4].wordX = 8 * gp.titleSize;
			gp.obj[4].wordY = 28 * gp.titleSize;

			gp.obj[5] = new OBJ_Door();
			gp.obj[5].wordX = 12 * gp.titleSize;
			gp.obj[5].wordY = 22 * gp.titleSize;
			
			
			gp.obj[6] = new OBJ_Chest();
			gp.obj[6].wordX = 10 * gp.titleSize;
			gp.obj[6].wordY = 7 * gp.titleSize;
	}
}
