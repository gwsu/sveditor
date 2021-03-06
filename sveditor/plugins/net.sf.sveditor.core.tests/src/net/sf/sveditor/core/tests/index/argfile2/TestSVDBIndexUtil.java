package net.sf.sveditor.core.tests.index.argfile2;

import java.io.File;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;

import net.sf.sveditor.core.SVCorePlugin;
import net.sf.sveditor.core.db.SVDBFile;
import net.sf.sveditor.core.db.index.SVDBIndexUtil;
import net.sf.sveditor.core.db.project.SVDBProjectData;
import net.sf.sveditor.core.db.project.SVDBProjectManager;
import net.sf.sveditor.core.db.project.SVProjectFileWrapper;
import net.sf.sveditor.core.tests.SVCoreTestCaseBase;
import net.sf.sveditor.core.tests.SVCoreTestsPlugin;
import net.sf.sveditor.core.tests.utils.BundleUtils;
import net.sf.sveditor.core.tests.utils.TestUtils;

public class TestSVDBIndexUtil extends SVCoreTestCaseBase {

	public void testIndexUtilFindFile() {
		BundleUtils utils = new BundleUtils(SVCoreTestsPlugin.getDefault().getBundle());
		SVCorePlugin.getDefault().setTestDebugLevel(0);
		
		utils.unpackBundleZipToFS("/uvm.zip", fTmpDir);
		
		IProject uvm = createProject("uvm", new File(fTmpDir, "uvm"));
		
		TestUtils.copy(
				"+define+QUESTA\n" +
				"+incdir+src\n" +
				"src/uvm_pkg.sv",
				uvm.getFile("uvm.f"));
		
		IFile uvm_pkg_sv = uvm.getFile("src/uvm_pkg.sv");
		
		assertNotNull(uvm_pkg_sv);
		assertTrue(uvm_pkg_sv.exists());

		SVDBProjectManager pmgr = SVCorePlugin.getDefault().getProjMgr();
		SVDBProjectData pdata = pmgr.getProjectData(uvm);
		
		SVProjectFileWrapper fw = pdata.getProjectFileWrapper();
		fw.addArgFilePath("${project_loc}/uvm.f");
		pdata.setProjectFileWrapper(fw);
		
		rebuildProject(uvm);
		
		SVDBFile file = SVDBIndexUtil.findIndexFile(uvm_pkg_sv);
	
		assertNotNull(file);
	}
	
}
