package yigo.packing;

import java.io.IOException;

public class Packing {
	static final String patchPath = "F:\\testEnv\\damao\\patch";
	static final String releasePath = "F:\\testEnv\\damao\\release";
	static final String modulePath = "";

	static final String unzip_exe = "F:\\testEnv\\damao\\tools\\unzip.exe";

	public void packing(String patchName) throws IOException {
		Runtime runtime = Runtime.getRuntime();
		String cmd = unzip_exe + " " + patchPath + "\\" + patchName + " -d " + patchPath;
		runtime.exec(cmd);
	}

}
