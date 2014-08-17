package com.linesb.smet.Script;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import com.linesb.smet.Application;

public class ScriptLoader {
	
	Application m_application;
	
	public ScriptLoader(Application application) {
		m_application = application;
	}
	
	public void loadScripts() {
		File[] files = getPlugins();
		for (File file : files) {
			try {
				final JarFile jar = new JarFile(file);
				final Enumeration<JarEntry> entries = jar.entries();
				while (entries.hasMoreElements()) {
					final JarEntry e = entries.nextElement();
					final String name = e.getName().replace('/', '.').replace('\\', '.');
					if (name.endsWith(".class")) {
						final ClassLoader loader = URLClassLoader.newInstance(new URL[]{file.toURI().toURL()});
						final Class<?> pluginClass = loader.loadClass(name.substring(0, name.length() - 6));
						if (pluginClass != null) {
							m_application.addTab(new ScriptContext(pluginClass.asSubclass(Script.class).newInstance()));
						}
					}
				}
				jar.close();
			} catch (Exception e) {
				// Error, probably tried to cast a non class file
			}
		}
	}
	
	private File[] getPlugins() {
		final String DIRECTORY_PATH = "plugins/";
		File[] files = new File(DIRECTORY_PATH).listFiles();
		return files;
	}
	
}
