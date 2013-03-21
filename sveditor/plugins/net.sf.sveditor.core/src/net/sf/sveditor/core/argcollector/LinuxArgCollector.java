package net.sf.sveditor.core.argcollector;

import java.io.File;

import net.sf.sveditor.core.BundleUtils;
import net.sf.sveditor.core.SVCorePlugin;

public class LinuxArgCollector extends AbstractArgCollector {

	
	public LinuxArgCollector() {
	}

	@Override
	protected File copyWrapperFiles(File dest) {
		BundleUtils utils = new BundleUtils(SVCorePlugin.getDefault().getBundle());
		
		utils.copyBundleDirToFS(
				"/sve_compiler_wrappers/unix",
				dest);
		
		File unix = new File(dest, "unix");
		File files[] = unix.listFiles();
		for (File f : files) {
			f.setExecutable(true);
		}
		
		return new File(unix, "sve_collect_compiler_args");
	}
	


}
