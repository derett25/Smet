package com.linesb.smet.Script;


import java.awt.Graphics;

import javax.swing.JPanel;

public class ScriptContext extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7662466628275177770L;
	private Script m_script;
	
	public ScriptContext(Script script) {
		m_script = script;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		m_script.draw(g);
	}
}
