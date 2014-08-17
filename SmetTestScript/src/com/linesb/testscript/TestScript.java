package com.linesb.testscript;

import java.awt.Graphics;

import com.linesb.smet.Script.Script;


public class TestScript implements Script {

	@Override
	public void draw(Graphics g) {
		g.drawOval(100, 50, 200, 200);
        g.fillOval(155, 100, 10, 20);
        g.fillOval(230, 100, 10, 20);
        g.drawArc(150, 160, 100, 50, 180, 180);
	}

}
