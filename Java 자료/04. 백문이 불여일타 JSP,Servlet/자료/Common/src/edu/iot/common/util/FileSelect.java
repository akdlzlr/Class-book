package edu.iot.common.util;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

import edu.iot.common.ui.Prompt;

public class FileSelect {
	private String []filters;
	private File dir;
	
	public FileSelect(String dir) {
		filters = null;
		this.dir = new File(dir);
	}
	
	public FileSelect(String dir, String filters) {
		filters = filters.toLowerCase();
		this.filters = filters.split(",");
		System.out.println(Arrays.deepToString(this.filters));
		this.dir = new File(dir);
	}
	
	private File[] getFileList() {
		if(filters==null) {
			return dir.listFiles();
		} else {
			return dir.listFiles(new FilenameFilter() {
				@Override
				public boolean accept(File dir, String name) {
					name = name.toLowerCase();
					for(String filter : filters) {
						if(name.endsWith(filter)) {
							return true;
						}
					}
					return false;
				}
			});
		}
	}
	
	public File select() {
		File []files = getFileList();
		
		
		for(int i=0; i<files.length; i++) {
			System.out.println(i + "] " + files[i].getName());
		}
		
		Prompt prompt = new Prompt();
		int ix = prompt.getInt("선택");
		
		return files[ix] ;
		
	}

}






