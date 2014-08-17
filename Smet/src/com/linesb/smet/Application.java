package com.linesb.smet;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.UIManager;

import com.linesb.smet.Script.ScriptContext;
import com.linesb.smet.Script.ScriptLoader;
import com.linesb.smet.UI.ButtonUI;
import com.linesb.smet.Util.Utility;

public class Application extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1657276121801553728L;
	private JTabbedPane m_pane;
	private JToolBar m_toolbar;
	
	public static void main(String[] args) {
        new Application();
    }
	
	public Application() {
		initWindow();
		ScriptLoader loader = new ScriptLoader(this);
		loader.loadScripts();
	}
	
	private void initWindow() {
		setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        m_pane = new JTabbedPane();
        m_pane.setPreferredSize(new Dimension(Utility.APPLICATION_WIDTH, Utility.APPLICATION_HEIGHT));
        initToolbar();
        getContentPane().add(m_pane, BorderLayout.CENTER);
        pack();
        setVisible(true);
	}
	
	private void initToolbar() {
		m_toolbar = new JToolBar();
        m_toolbar.setFloatable(false);
        getContentPane().add(this.m_toolbar, BorderLayout.PAGE_START);
	}

	public void addTab(final ScriptContext context) {
	    JPanel tab = new JPanel();
	    tab.setOpaque(false);
	    JLabel tabLabel = new JLabel("Tab " + m_pane.getTabCount() + 1);

	    ButtonUI tabCloseButton = new ButtonUI(new ActionListener() {

		      public void actionPerformed(ActionEvent e) {
		        int closeTabNumber = m_pane.indexOfComponent(context);
		        m_pane.removeTabAt(closeTabNumber);
		      }
		    }, "close");

	    tab.add(tabLabel, BorderLayout.WEST);
	    tab.add(tabCloseButton, BorderLayout.EAST);

	    m_pane.addTab(null, context);
	    m_pane.setTabComponentAt(m_pane.getTabCount() - 1, tab);
	}
}
