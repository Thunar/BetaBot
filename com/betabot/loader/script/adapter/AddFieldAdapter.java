package com.betabot.loader.script.adapter;

import com.betabot.loader.asm.ClassAdapter;
import com.betabot.loader.asm.ClassVisitor;

/**
 * @author Jacmob
 */
public class AddFieldAdapter extends ClassAdapter {

	public static class Field {
		public int access;
		public String name;
		public String desc;
	}

	private final Field[] fields;

	public AddFieldAdapter(ClassVisitor delegate, Field[] fields) {
		super(delegate);
		this.fields = fields;
	}

	public void visitEnd() {
		for (Field f : fields) {
			cv.visitField(f.access, f.name, f.desc, null, null);
		}
		cv.visitEnd();
	}

}
