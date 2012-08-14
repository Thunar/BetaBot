package com.rsfriend.loader.script.adapter;

import com.rsfriend.loader.asm.ClassAdapter;
import com.rsfriend.loader.asm.ClassVisitor;
import com.rsfriend.loader.asm.MethodVisitor;

/**
 * @author Jacmob
 */
public class SetSignatureAdapter extends ClassAdapter {

	public static class Signature {
		public String name;
		public String desc;
		public int new_access;
		public String new_name;
		public String new_desc;
	}

	private final Signature[] signatures;

	public SetSignatureAdapter(ClassVisitor delegate, Signature[] signatures) {
		super(delegate);
		this.signatures = signatures;
	}

	public MethodVisitor visitMethod(
			final int access,
			final String name,
			final String desc,
			final String signature,
			final String[] exceptions) {
		for (Signature s : signatures) {
			if (s.name.equals(name) && s.desc.equals("") || s.desc.equals(desc)) {
				return cv.visitMethod(
						s.new_access == -1 ? access : s.new_access,
						s.new_name,
						s.new_desc.equals("") ? desc : s.new_desc,
						signature,
						exceptions);
			}
		}
		return cv.visitMethod(access, name, desc, signature, exceptions);
	}

}
