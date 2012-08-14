package com.betabot.loader.script.adapter;

import com.betabot.loader.script.CodeReader;

import com.betabot.loader.asm.ClassAdapter;
import com.betabot.loader.asm.ClassVisitor;
import com.betabot.loader.asm.MethodVisitor;

/**
 * @author Jacmob
 */
public class AddMethodAdapter extends ClassAdapter {

	public static class Method {
		public int access;
		public String name;
		public String desc;
		public byte[] code;
		public int max_stack;
		public int max_locals;
	}

	private final Method[] methods;

	public AddMethodAdapter(ClassVisitor delegate, Method[] methods) {
		super(delegate);
		this.methods = methods;
	}

	public void visitEnd() {
		for (Method m : methods) {
			MethodVisitor mv = cv.visitMethod(m.access, m.name, m.desc, null, null);
			mv.visitCode();
			new CodeReader(m.code).accept(mv);
			mv.visitMaxs(m.max_stack, m.max_locals);
			mv.visitEnd();
		}
		cv.visitEnd();
	}

}
