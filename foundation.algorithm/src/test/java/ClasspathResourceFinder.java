

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

public class ClasspathResourceFinder {

	public File findResource(String resourcePath) {
		URL url = getResourceAsURL(resourcePath);
		
		try {
			return new File(url.toURI());
		} catch (URISyntaxException e) {
			throw new RuntimeException(e.getMessage(), e);
		}catch(NullPointerException e){
			throw new RuntimeException(String.format("Fail to find resource - %s", resourcePath));
		}
	}

	private final ClassLoader defaultClassLoader;
	private final ClassLoader systemClassLoader;

	public ClasspathResourceFinder() {
		defaultClassLoader = getClass().getClassLoader();
		systemClassLoader = ClassLoader.getSystemClassLoader();
	}

	private URL getResourceAsURL(String resource) {
		return getResourceAsURL(resource, getClassLoaders(null));
	}
	
	private URL getResourceAsURL(String resource, ClassLoader[] classLoader) {
		URL url;
		for (ClassLoader cl : classLoader) {
			if (null != cl) {
				url = cl.getResource(resource);
				if(cl.getResource(resource) == null){
					url = cl.getResource("/" + resource);
				}
				
				if (null != url){
					return url;
				}
			}
		}
		return null;

	}

	private ClassLoader[] getClassLoaders(ClassLoader classLoader) {
		return new ClassLoader[] { classLoader, defaultClassLoader,
				Thread.currentThread().getContextClassLoader(),
				getClass().getClassLoader(), systemClassLoader };
	}
}
