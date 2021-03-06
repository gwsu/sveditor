/****************************************************************************
 * Copyright (c) 2008-2011 Matthew Ballance and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Matthew Ballance - initial implementation
 ****************************************************************************/


package net.sf.sveditor.core.db.expr;

import net.sf.sveditor.core.db.SVDBItemType;
import net.sf.sveditor.core.db.SVDBTypeInfo;

public class SVDBTypeExpr extends SVDBExpr {
	public SVDBTypeInfo			fTypeInfo;
	
	public SVDBTypeExpr() {
		super(SVDBItemType.TypeExpr);
	}
	
	public SVDBTypeExpr(SVDBTypeInfo type) {
		this();
		fTypeInfo = type;
	}
	
	public void setTypeInfo(SVDBTypeInfo type) {
		fTypeInfo = type;
	}
	
	public SVDBTypeInfo getTypeInfo() {
		return fTypeInfo;
	}

}
