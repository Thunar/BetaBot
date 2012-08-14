package com.betabot.security;

import com.betabot.utils.GlobalConfiguration;
import com.betabot.utils.StringUtil;
import com.betabot.utils.io.IOHelper;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class UniqueID {
	private static final int LENGTH = 64;
	private static final byte[] SALT = {0x4a, 0x13, (byte) 0xf9, (byte) 0xcc};
	private static File store = new File(GlobalConfiguration.Paths.getSettingsDirectory(), "random.dat");

	public static String getID() {
		if (!store.exists()) {
			createStore();
		}
		final ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {
			out.write(IOHelper.read(store));
			out.write(getLocalHostAddress());
			out.write(StringUtil.getBytesUtf8(GlobalConfiguration.NAME));
			out.write(StringUtil.getBytesUtf8(GlobalConfiguration.Paths.URLs.DOWNLOAD));
			out.write(SALT);
		} catch (final IOException ignored) {
			return "ERROR";
		}
		return sha1(out.toByteArray());
	}

	private static void createStore() {
		final byte[] d = new byte[LENGTH];
		new SecureRandom().nextBytes(d);
		IOHelper.write(new ByteArrayInputStream(d), store);
	}

	private static byte[] getLocalHostAddress() throws IOException {
		final byte[] lo = NetworkInterface.getByInetAddress(InetAddress.getLocalHost()).getHardwareAddress();
		return lo == null ? new byte[] { 0 } : lo;
	}

	public static String sha1(final byte[] data) {
		final MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-1");
		} catch (final NoSuchAlgorithmException ignored) {
			return "NULL";
		}
		md.update(data);
		return StringUtil.byteArrayToHexString(md.digest());
	}
}