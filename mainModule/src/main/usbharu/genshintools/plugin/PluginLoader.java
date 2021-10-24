package usbharu.genshintools.plugin;

import usbharu.genshintools.gui.IContentPane;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.jar.Attributes;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

public class PluginLoader {
	String pluginFolderPath="";
	public PluginLoader() {
		pluginFolderPath = System.getProperty("user.dir")+ File.separator+"plugins";
		System.out.println("Load Plugin in "+pluginFolderPath);
	}

	public ArrayList<IContentPane> getPlugins(){
		ArrayList <IContentPane>plugins = new ArrayList<>();
		try {
			File pluginFolder = new File(pluginFolderPath);
			String[] files = pluginFolder.list();
			for (String file:files) {
				if (file.endsWith(".jar")){
					File file1 = new File(pluginFolderPath+File.separator+file);
					System.out.println("file1 = " + file1);
					JarFile jar = new JarFile(file1);
					System.out.println("jar = " + jar);
					Manifest manifest = jar.getManifest();
					System.out.println("manifest = " + manifest);
					Attributes attributes = manifest.getMainAttributes();
					System.out.println("attributes = " + attributes);
					String pluginName = attributes.getValue("Plugin-Class");
					System.out.println("pluginName = " + pluginName);
					URL url = file1.getCanonicalFile().toURI().toURL();
					System.out.println("url = " + url);
					URLClassLoader loader = new URLClassLoader(new URL[]{url});
					System.out.println("loader = " + loader);
					Class cobj = loader.loadClass(pluginName);
					Class[] ifnames = cobj.getInterfaces();
					for (Class c : ifnames){
						if (c==IContentPane.class){
							System.out.println("Load "+pluginName);
							IContentPane contentPane = (IContentPane) cobj.getDeclaredConstructor().newInstance();
							plugins.add(contentPane);
							break;
						}
					}
				}
			}
		} catch (IOException | ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
			e.printStackTrace();
		}
		return plugins;
	}
}