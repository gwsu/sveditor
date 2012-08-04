/****************************************************************************
 * Copyright (c) 2008-2010 Matthew Ballance and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Matthew Ballance - initial implementation
 ****************************************************************************/


package net.sf.sveditor.core.db;

import java.util.ArrayList;
import java.util.List;

public class SVDBMacroDef extends SVDBItem implements ISVDBChildItem {
	public List<SVDBMacroDefParam>			fParams;
	public String							fDef;

	public SVDBMacroDef() {
		super("", SVDBItemType.MacroDef);
	}
	
	public SVDBMacroDef(
			String 				name, 
			String				def) {
		super(name, SVDBItemType.MacroDef);
		fParams = new ArrayList<SVDBMacroDefParam>();
		fDef = def;
	}
	
	public String getDef() {
		return fDef;
	}
	
	public void setDef(String def) {
		fDef = def;
	}
	
	public List<SVDBMacroDefParam> getParameters() {
		return fParams;
	}

	public void addParameter(SVDBMacroDefParam p) {
		fParams.add(p);
		p.setParent(this);
	}
	

	@Override
	public void init(SVDBItemBase other) {
		super.init(other);
		
		SVDBMacroDef m = (SVDBMacroDef)other;
		fParams.clear();
		fParams.addAll(m.fParams);
		fDef = m.fDef;
	}

	/*
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof SVDBMacroDef) {
			SVDBMacroDef o = (SVDBMacroDef)obj;
			
			if (fParams.size() == o.fParams.size()) {
				 if (!o.fName.equals(fName)) {
					 return false;
				 }
				 
				 for (int i=0; i<fParams.size(); i++) {
					 if (!fParams.get(i).equals(o.fParams.get(i))) {
						 return false;
					 }
				 }

				 return super.equals(obj);
			} else {
				return false;
			}
		}
		
		return false;
	}
	 */
	
}
