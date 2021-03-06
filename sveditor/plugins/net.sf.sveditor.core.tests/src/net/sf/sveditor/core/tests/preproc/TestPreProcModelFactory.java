package net.sf.sveditor.core.tests.preproc;

import net.sf.sveditor.core.StringInputStream;
import net.sf.sveditor.core.Tuple;
import net.sf.sveditor.core.preproc.SVPreProcModelFactory;
import net.sf.sveditor.core.preproc.SVPreProcModelNode;
import net.sf.sveditor.core.preproc.SVPreProcOutput;
import net.sf.sveditor.core.preproc.SVPreProcessor;
import net.sf.sveditor.core.tests.SVCoreTestCaseBase;

public class TestPreProcModelFactory extends SVCoreTestCaseBase {
	
	public void testBasics() {
		String doc = 
				"`define MY_FIELD(name) \\\n" +
				"	int name\n" +
				"\n" +
				"`define MY_CLASS(name) \\\n" +
				"	class name;\\\n" +
				"		`MY_FIELD(field_rgy);\\\n" +
				"		`MY_FIELD(field_rgy1);\\\n" +
				"		`MY_FIELD(field_rgy2);\\\n" +
				"		`MY_FIELD(field_rgy3);\\\n" +
				"\n" +
				"`MY_CLASS(foobar);\n" +
				"	int my_field;\n" +
				"endclass\n" +
				"\n"
				;
				
		SVPreProcessor pp = new SVPreProcessor(getName(), null, null, null);
		SVPreProcModelFactory f = new SVPreProcModelFactory(pp);
		
		Tuple<SVPreProcModelNode, String> result = 
				f.build(new StringInputStream(doc));
		SVPreProcModelNode root = result.first();
		System.out.println("Model:\n" + root.toString());
		
		System.out.println("Doc:\n" + result.second().toString());
		System.out.println("Annotated Model:\n" + 
				root.toString(result.second().toString()));
	}

}
